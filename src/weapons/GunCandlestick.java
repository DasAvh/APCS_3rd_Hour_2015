package weapons;

import graphics.Assets;

public class GunCandleStick extends Weapon
{

	public GunCandleStick(int id) 
	{
		super(Assets.gunCandleStick, id);
	}//End constructor
	public String message(String name)
	{
		return name + " suddenly grabbed the gun candle stick.";
	}
	public String toString()
	{
		return "Candlestick made of guns";
	}//End toString method
}//End class GunCandleStick
