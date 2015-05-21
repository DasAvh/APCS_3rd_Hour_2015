package cards;

import runner.Game;
import entity.chars.Player;

public class PlayerCard extends Card
{

	public PlayerCard(Game game, int x, int y, int width, int height, int id, String name, String slogan) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = slogan;
	}//End PlayerCard class
	
	public PlayerCard getCard()
	{
		return this;
	}
	
	public String toString()
	{
		return getName();
	}
	
	public Object equal(Object other)
	{
		return getName().equals(((Player)(other)).getName()); 
	}
}///End PlayerCard class
