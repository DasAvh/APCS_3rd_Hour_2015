package weapons;

import graphics.Assets;

public class GunCandleStick extends Weapon
{

	public GunCandleStick() 
	{
		super(Assets.gunCandleStick, "Gun CandleStick", "Candlestick made of guns",2);
	}//End constructor

	public String toString()
	{
		return "Candlestick made of guns";
	}//End toString method
}//End class GunCandleStick
