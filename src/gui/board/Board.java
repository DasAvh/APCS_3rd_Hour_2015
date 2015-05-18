package board;

import java.awt.Graphics;
import java.awt.geom.GeneralPath;

import rooms.Door;
import rooms.GeneralRoom;
import rooms.PassageRoom;
import rooms.Room;
import runner.Game;
import tiles.Tile;
import utilities.Utilities;
import entity.Entity;

public class Board
{
	//Fields
	private Game game;
	private int width, height;
	private int[] spawnX, spawnY;
	
	//Static Fields
	public static int[][] rooms;
	public static int[][] tiles;
	public static int[][] doors;
	
	public Board(Game game, String path, String pathTwo)
	{
		//Allows use of Game methods
		this.game = game;
		
		//Loads two files
		loadBoard(path);
		loadTriggers(pathTwo);
	}//End constructor

	public void tick()
	{
		//Maybe disco tiles if threading can be figured out?
	}//End tick method
	
	public void render(Graphics g)
	{
		//Gets starting and ending x positions of viewport
		int xStart = (int)Math.max(0, game.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd   = (int)Math.min(width, (game.getCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		
		//Gets starting and ending y positions of viewport
		int yStart = (int)Math.max(0, game.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd   = (int)Math.min(height, (game.getCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1); 
		
		//Renders viewport only -> Off screen tiles are not drawn
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart ; x < xEnd; x++)
				getTile(x, y).render(g, (int)( x * Tile.TILE_WIDTH  - game.getCamera().getxOffset()),
										(int)( y * Tile.TILE_HEIGHT - game.getCamera().getyOffset()));
			//End inner for
		}//End outer for
	}//End render method
	
	public Tile getTile(int x, int y)
	{
		//Returns a tile from Tile class static 
		//array tiles at x and y coordinates
		Tile t = Tile.tiles[tiles[x][y]];
		
		//If null return a hallway tile instead
		if(t == null)
			return Tile.hallwayTile;
		//End if
		
		return t;
	}//End method getTile
	
	public static boolean hitObject(Entity entity, int xMove, int yMove)
	{
		//Gets position where entity wants to move
		//Split into 4 variables for now (Should only need two)
		int currentX = entity.getX() / Tile.TILE_WIDTH;
		int currentY = entity.getY() / Tile.TILE_HEIGHT;
		int tileX 	 = currentX + (xMove / 64);
		int tileY 	 = currentY + (yMove / 64);
			
		
		//Checks if potential tile can hold a entity
		//If so return true, else return false
		if(Tile.tiles[tiles[tileX][tileY]].isWalkable())
			return true;
		//End if
		
		return false;
	}//End hitWall method
	
	public static int hitDoor(Entity entity)
	{
		for(int x = 1; x < Door.doors.length - 1; x++)
		{
			//If standing in a room, return the room number
			if(Door.doors[x].onDoor(entity.getX() / Tile.TILE_WIDTH,
									entity.getY() / Tile.TILE_HEIGHT))
				return x;
			//End if
		}//End for
		
		//Return 0 if player is not standing in a room
		return 0;
	}//End hitDoor method
	
	public static Tile getDoor(Entity entity)
	{
			return Tile.tiles[tiles[entity.getX() / Tile.TILE_WIDTH]
					   		 	   [entity.getY() / Tile.TILE_HEIGHT]];
	}//End getDoor method
	
	public static int hitRoom(Entity entity)
	{
		//Checks to see if entity is standing in a room
		for(int x = 1; x < Room.rooms.length; x++)
		{
			//If standing in a room, return the room number
			if(Room.rooms[x].inRoom(entity.getX() / Tile.TILE_WIDTH,
									entity.getY() / Tile.TILE_HEIGHT))
				return x;
			//End if
		}//End for
		
		//Return 0 if player is not standing in a room
		return 0;
	}//End hitDoor method
	
	private void loadBoard(String path)
	{
		//Loads file & separates data into a array
		//Data is split if there is whitespace
		String   file = Utilities.loadFile(path);
		String[] data = file.split("\\s+");

		//Board size : w x h
		width  = Utilities.parseInt(data[0]);
		height = Utilities.parseInt(data[1]);
		tiles  = new int[width][height];
		
		//Board is assign Ids of tiles -> Ids used for rendering
		for(int y = 0; y < height; y++)
		{
			for(int x = 0 ; x < width; x++)
			{
				//Plus 2 is to skip size data
				tiles[x][y] = Utilities.parseInt(data[(x + y * width) + 2]);
			}//End inner for
		}//End outer for
	}//End method loadBoard
	
	private void loadTriggers(String path)
	{
		//Loads file with special condition and returns a Array of Strings
		//Condition is to skip lines that begin with the condition
		//When it hits condition it moves on to the next position in array
		String[] file 	   = Utilities.loadFile(path, "=");
		String[] spawnData = file[0].split("\\s+");
		String[] roomData  = file[1].split("#");
		String[] doorData  = file[2].split("#");
		
		//Initialize spawn point arrays
		spawnX = new int[spawnData.length / 2];
		spawnY = new int[spawnData.length / 2];
		
		//Starting index of first array
		int index = 0;
		
		//Loads up spawn points
		for(int i = 0; i < spawnData.length / 2; i++)
		{
			//System.out.println(Integer.parseInt(spawnData[index]) + " " + Integer.parseInt(spawnData[index + 1]));
			spawnX[i] = Utilities.parseInt(spawnData[index]);
			spawnY[i] = Utilities.parseInt(spawnData[index + 1]);
			index += 2;
		}//End for
		
		//Starting index of second array
		index = 1;
		
		while(index < roomData.length)
		{
			//If roomData starts with "P", generate a Passage Room
			//Else generate a General room
			//Gets x and y coordinates and splits the data
			//Stores new Room object and coordinates in Room static array rooms at this index
			if(roomData[index].substring(0, 1).equals("P"))
			{
				String temp = roomData[index].substring(3);
				String[] xyCoords = temp.split("\\s+");
				Room.rooms[index] = new PassageRoom(xyCoords, index);
			}else
			{
				String temp = roomData[index].substring(3);
				String[] xyCoords = temp.split("\\s+");
				Room.rooms[index] = new GeneralRoom(xyCoords, index);
			}//End if
			
			index++;
		}//End while	
		
		//Starting index of third array
		index = 1;
		
		//Gets location of a door and
		//what room to assign it
		while(index < doorData.length)
		{
			String temp = doorData[index].substring(2).trim();
			String[] data = temp.split("\\s+");
			Door.doors[index] = new Door(data, index);
			index++;
		}//End if
		
		for(int i = 0; i < Door.doors.length - 1; i++)
			System.out.println(Door.doors[i + 1].getAssignRoom().getId());
	}//End method loadTriggers
	
	public int[] getSpawnX()
	{
		return spawnX;
	}//End getSpawnX
	
	public int[] getSpawnY()
	{
		return spawnY;
	}//End getSpawnY
}//End class Board
