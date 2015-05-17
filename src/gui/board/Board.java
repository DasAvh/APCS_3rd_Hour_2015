package board;

import java.awt.Graphics;
import java.awt.geom.GeneralPath;

import rooms.GeneralRoom;
import rooms.PassageRoom;
import rooms.Room;
import runner.Game;
import tiles.Tile;
import utilities.Utilities;
import entity.Entity;

public class Board
{
	private Game game;
	private int width, height;
	private int[] spawnX, spawnY;
	public static int[][] rooms;
	public static int[][] tiles;
	
	public Board(Game game, String path, String pathTwo)
	{
		this.game = game;
		loadBoard(path);
		loadTriggers(pathTwo);
	}//End constructor

	public void tick()
	{
		//Maybe disco tiles?
	}//End tick method
	
	public void render(Graphics g)
	{
		int xStart = (int)Math.max(0, game.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int)Math.min(width, (game.getCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1); 
		int yStart = (int)Math.max(0, game.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int)Math.min(height, (game.getCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1); 
		
		//Renders viewport only
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart ; x < xEnd; x++)
			{
				getTile(x, y).render(g, (int)( x * Tile.TILE_WIDTH  - game.getCamera().getxOffset()),
										(int)( y * Tile.TILE_HEIGHT - game.getCamera().getyOffset()));
			}//End inner for
		}//End outer for
	}//End render method
	
	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t == null)
			return Tile.hallwayTile;
		//End if
		
		return t;
	}//End method getTile
	
	public static boolean hitObject(Entity entity, int xMove, int yMove)
	{
		int currentX = entity.getX() / Tile.TILE_WIDTH;
		int currentY = entity.getY() / Tile.TILE_HEIGHT;
		int tileX = currentX + (xMove / 64);
		int tileY = currentY + (yMove / 64);
		
		//System.out.printf("%s %s %s %s%n", currentX, currentY, tileX, tileY);	
		
		if(Tile.tiles[tiles[tileX][tileY]].isWalkable())
			return true;
	
		return false;
	}//End hitWall method
	
	public static boolean hitDoor(Entity entity)
	{
		if(Tile.tiles[tiles[entity.getX() / Tile.TILE_WIDTH][entity.getY() / Tile.TILE_HEIGHT]].getId() == Tile.DOOR_TILE)
			return true;
		
		return false;
	}//End hitDoor method
	
	public static int hitRoom(Entity entity)
	{
		for(int x = 1; x < Room.rooms.length; x++)
		{
			if(Room.rooms[x].inRoom(entity.getX() / Tile.TILE_WIDTH,
					entity.getY() / Tile.TILE_HEIGHT))
				return x;
		}
		return 0;
	}//End hitDoor method
	

	
	private void loadBoard(String path)
	{
		String file = Utilities.loadFile(path);
		String[] data = file.split("\\s+");
		spawnX = new int[6];
		spawnY = new int[6];

		//Board size : w x h
		width  = Utilities.parseInt(data[0]);
		height = Utilities.parseInt(data[1]);
		tiles = new int[width][height];
		
		//Actually board
		for(int y = 0; y < height; y++)
		{
			for(int x = 0 ; x < width; x++)
			{
				//Plus 14 is to skip size and spawn point data
				tiles[x][y] = Utilities.parseInt(data[(x + y * width) + 2]);
			}//End inner for
		}//End outer for
	}//End method loadBoard
	
	private void loadTriggers(String path)
	{
		String[] file = Utilities.loadFile(path, "=");
		String[] spawnData = file[0].split("\\s+");
		String[] roomData = file[1].split("#");
		
		int index = 0;
		
		//Loads up spawn points
		for(int i = 0; i < spawnData.length / 2; i++)
		{
			//System.out.println(Integer.parseInt(spawnData[index]) + " " + Integer.parseInt(spawnData[index + 1]));
			spawnX[i] = Utilities.parseInt(spawnData[index]);
			spawnY[i] = Utilities.parseInt(spawnData[index + 1]);
			index += 2;
		}//End for
		
		//Reset index
		index = 1;
		
		while(index < roomData.length)
		{
			System.out.println(roomData[index]);
			if(roomData[index].substring(0, 1).equals("P"))
			{
				String temp = roomData[index].substring(3);
				String[] xyCoords = temp.split("\\s+");
				Room.rooms[index] = new PassageRoom(xyCoords, index);
				Room.rooms[index].printRoom();
			}else
			{
				String temp = roomData[index].substring(3);
				String[] xyCoords = temp.split("\\s+");
				Room.rooms[index] = new GeneralRoom(xyCoords, index);
			}//End if
			index++;
		}//End while		
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
