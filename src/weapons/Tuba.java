package weapons;

import graphics.Assets;

public class Tuba extends Weapon 
{
	public Tuba(int id)
	{
		super(Assets.tuba, id);
	}//End constructor
	public String message(String name)
	{
		return name + " suddunley gabbed dah toobah.";
	}
	public String toString()
	{
		return "Tuba";
	}//End toString method	
}//End Tuba class
