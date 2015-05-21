package cards;

import runner.Game;

public class PlayerCard extends Card
{

	public PlayerCard(Game game, int x, int y, int width, int height, int id, String name, String slogan) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = slogan;
	}//End PlayerCard class
	
}///End PlayerCard class
