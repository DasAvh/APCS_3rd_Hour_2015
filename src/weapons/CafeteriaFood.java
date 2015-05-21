package weapons;

import graphics.Assets;

public class CafeteriaFood extends Weapon 
{
	public CafeteriaFood() 
	{
		super(Assets.cafeteriaFood, "Cafeteria Food", "Some Cafeteria food");
	}//End constructor
	
	
	public String toString()
	{
		return "Cafeteria food";
	}//End toString method
}//End class CaferiaFood
