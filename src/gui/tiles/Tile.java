package tiles;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Tile 
{

	public static Tile[] tiles = new Tile[256];
	public static Tile hallwayTile = new HallwayTile(0);
	public static Tile wallTile = new WallTile(1);
	public static Tile doorTile = new DoorTile(2);
	public static Tile roomTile = new RoomTile(3);
	public static Tile spanwTile = new SpawnTile(4);
	
	//Fields
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}//End constructor
	
	public void tick()
	{
		
	}//End tick method
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}//End render method
	
	public boolean isWalkable()
	{
		return false;
	}//End isWalkable
	
	public int getId()
	{
		return id;
	}//End getId method
	
	public boolean equal(Object obj)
	{
		return false;
	}
}//End class Tile
