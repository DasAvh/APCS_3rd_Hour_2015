package tiles;

import entity.Entity;
import graphics.Assets;
import rooms.Room;

public class DoorTile extends Tile
{
	//Fields
	public static final int MOVE_UP    = -1;
	public static final int MOVE_DOWN  = 1;
	public static final int MOVE_LEFT  = -1;
	public static final int MOVE_RIGHT = 1;
	
	public DoorTile(int id) 
	{
		super(Assets.door, id);
	}//End constructor
	
	public boolean isWalkable()
	{
		return true;
	}//End isWalkable method
	
}//End DoorTile class
