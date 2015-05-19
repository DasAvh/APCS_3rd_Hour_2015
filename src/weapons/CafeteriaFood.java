package weapons;

import graphics.Assets;

public class CafeteriaFood extends Weapon 
{
	public CafeteriaFood(int id) 
	{
		super(Assets.cafeteriaFood, id);
	}//End constructor
	
	
	public String toString()
	{
		return "Cafeteria food";
	}//End toString method
}//End class CaferiaFood
