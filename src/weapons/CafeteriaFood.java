package weapons;

import graphics.Assets;

public class CafeteriaFood extends Weapon
{
	public CafeteriaFood() 
	{
		super(Assets.cafeteriaFood, "some Cafeteria Food", "Some Cafeteria food",5);
	}//End constructor
	
	
	public String toString()
	{
		return "Cafeteria food";
	}//End toString method
}//End class CaferiaFood
