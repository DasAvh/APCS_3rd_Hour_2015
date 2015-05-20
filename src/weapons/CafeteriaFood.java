package weapons;

import graphics.Assets;

public class CafeteriaFood extends Weapon 
{
	public CafeteriaFood(int id) 
	{
		super(Assets.cafeteriaFood, id);
	}//End constructor
	
	public String message(String name)
	{
		return name + " suddenly grabbed the cafeteria food.";
	}
	
	public String toString()
	{
		return "Cafeteria food";
	}//End toString method
}//End class CaferiaFood
