package weapons;

import graphics.Assets;

public class FrozenWaterBottle extends Weapon 
{

	public FrozenWaterBottle(int id) 
	{
		super(Assets.frozenWaterBottle, id);
	}//End constructor
	
	public String toString()
	{
		return "FROZEN water bottle";
	}//End toString method
}//End class FrozenWaterBottle
