package weapons;

import graphics.Assets;

public class FrozenWaterBottle extends Weapon 
{

	public FrozenWaterBottle() 
	{
		super(Assets.frozenWaterBottle,"Frozen Water Bottle", "FROZEN water bottle");
	}//End constructor
	
	public String toString()
	{
		return "FROZEN water bottle";
	}//End toString method
}//End class FrozenWaterBottle
