package weapons;

import graphics.Assets;

public class FriendSlayer extends Weapon 
{

	public FriendSlayer() 
	{
		super(Assets.friendSlayer, "FriendSlayer", "A fireaxe named Friendslayer");
	}//End constructor

	public String toString()
	{
		return "A fireaxe named Friendslayer";
	}//End toString method
}//End class FriendSlayer
