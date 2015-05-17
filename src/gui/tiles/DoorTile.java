package tiles;

import entity.Entity;
import graphics.Assets;

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
	
	public static void movePlayerIntoRoom(Entity entity)
	{

	}//End movePlayerIntoRoom method
	
	public static void movePlayerOutOfRoom(Entity entity)
	{

	}//End movePlayerOutOfRoom method
}//End DoorTile class
