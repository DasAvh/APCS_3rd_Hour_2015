package tiles;

import graphics.Assets;

public class HallwayTile extends Tile
{

	public HallwayTile(int id) 
	{
		super(Assets.hallway, id);
	}//End constructor
	
	public boolean isWalkable()
	{
		return true;
	}//End method isWalkable
}//End class HallwayTile
