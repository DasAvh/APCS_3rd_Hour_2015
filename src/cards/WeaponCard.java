package cards;

import runner.Game;

public class WeaponCard extends Card
{

	public WeaponCard(Game game, int x, int y, int width, int height, int id, String name, String slogan) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = slogan;
	}//End WeaponCard class
}//End class WeaponCard
