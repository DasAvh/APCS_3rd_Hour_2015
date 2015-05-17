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
		//entity.setX(1*64);
		//entity.setY(1*64);
	}//End movePlayerIntoRoom method
	
	public static void movePlayerOutOfRoom(Entity entity)
	{
		//entity.setX(4*64);
		//entity.setY(4*64);
	}//End movePlayerOutOfRoom method
}//End DoorTile class
