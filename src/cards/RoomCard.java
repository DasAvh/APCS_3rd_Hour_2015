package cards;

import graphics.Assets;
import rooms.Room;
import runner.Game;

public class RoomCard extends Card
{
	public RoomCard(Game game, int x, int y, int width, int height, int id, String name) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = "A " + name;
		texture = Assets.roomCardImages.get(id);
	}//End WeaponCard class
	
	public RoomCard getCard()
	{
		return this;
	}
	
	public String toString()
	{
		return getName();
	}
	
	public String getSlogan()
	{
		return slogan;
	}
	
	public Object equal(Object other)
	{
		return getName().equals(((RoomCard)(other)).getName()); 
	}
}//End RoomCard Class
