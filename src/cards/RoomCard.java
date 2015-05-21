package cards;

import runner.Game;

public class RoomCard extends Card
{
	public RoomCard(Game game, int x, int y, int width, int height, int id, String name) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = "A " + name;
	}//End WeaponCard class
}//End RoomCard Class
