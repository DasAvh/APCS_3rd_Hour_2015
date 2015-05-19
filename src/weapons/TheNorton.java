package weapons;

import graphics.Assets;

public class TheNorton extends Weapon 
{

	public TheNorton( int id) 
	{
		super(Assets.theNorton, id);
	}//End constructor

	public String toString()
	{
		return "The Norton Anthology of English Literature";
	}//End toString method
}//End TheNorton class
