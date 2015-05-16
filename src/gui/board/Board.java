package board;

import java.awt.Graphics;

import runner.Game;
import states.GameState;
import tiles.Tile;
import utilities.Utilities;
import entity.Entity;

public class Board
{
	private Game game;
	private int width, height;
	private int[] spawnX, spawnY;
	private static int[][] tiles;
	
	public Board(Game game, String path)
	{
		this.game = game;
		loadBoard(path);
	}//End constructor

	
	public void tick()
	{
		
	}
	
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
		return t;
	}//End method getTile
	
	public static boolean hitObject(Entity entity, int xMove, int yMove)
	{
		int currentX = entity.getX() / Tile.TILE_WIDTH;
		int currentY = entity.getY() / Tile.TILE_HEIGHT;
		int tileX = currentX + (xMove / 64);
		int tileY = currentY+ (yMove / 64);
		
		//System.out.printf("%s %s %s %s%n", currentX, currentY, tileX, tileY);	
		
		if(Tile.tiles[tiles[tileX][tileY]].isWalkable())
		{
			return true;
		}
	
		return false;
	}//End hitWall method
	
	private void loadBoard(String path)
	{
		String file = Utilities.loadFile(path);
		String[] data = file.split("\\s+");
		spawnX = new int[6];
		spawnY = new int[6];
		
		//Board size : w x h
		width  = Utilities.parseInt(data[0]);
		height = Utilities.parseInt(data[1]);
		
		//Spawn points
		spawnX[0] = Utilities.parseInt(data[2]);
		spawnY[0] = Utilities.parseInt(data[3]);
		spawnX[1] = Utilities.parseInt(data[4]);
		spawnY[1] = Utilities.parseInt(data[5]);
		spawnX[2] = Utilities.parseInt(data[6]);
		spawnY[2] = Utilities.parseInt(data[7]);
		spawnX[3] = Utilities.parseInt(data[8]);
		spawnY[3] = Utilities.parseInt(data[9]);
		spawnX[4] = Utilities.parseInt(data[10]);
		spawnY[4] = Utilities.parseInt(data[11]);
		spawnX[5] = Utilities.parseInt(data[12]);
		spawnY[5] = Utilities.parseInt(data[13]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0 ; x < width; x++)
			{
				//Plus 14 is to skip size and spawn point data
				tiles[x][y] = Utilities.parseInt(data[(x + y * width) + 14]);
			}//End inner for
		}//End outer for
	}//End method loadBoard
	
	public int[] getSpawnX()
	{
		return spawnX;
	}//End getSpawnX
	
	public int[] getSpawnY()
	{
		return spawnY;
	}//End getSpawnY
}//End class Board
