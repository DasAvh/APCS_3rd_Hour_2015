package cards;

import graphics.Assets;
import runner.Game;
import weapons.Weapon;

public class WeaponCard extends Card
{

	public WeaponCard(Game game, int x, int y, int width, int height, int id, String name, String slogan) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = slogan;
		texture = Assets.weaponCardImages.get(id);
	}//End WeaponCard class
	
	public WeaponCard getCard()
	{
		return this;
	}
	
	public String toString()
	{
		return getName();
	}

	public Object equal(Object other)
	{
		return getName().equals(((WeaponCard)(other)).getName()); 
	}
}//End class WeaponCard
