package weapons;

import graphics.Assets;

public class GunCandlestick extends Weapon
{

	public GunCandlestick(int id) 
	{
		super(Assets.gunCandleStick, id);
	}//End constructor

	public String toString()
	{
		return "Candlestick made of guns";
	}//End toString method
}//End class GunCandleStick
