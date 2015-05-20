package weapons;

import graphics.Assets;

public class FriendSlayer extends Weapon 
{

	public FriendSlayer(int id) 
	{
		super(Assets.friendSlayer, id);
	}//End constructor

	public String message(String name)
	{
		return name + " traitorously grabbed the Friend Slayer.";
	}
	public String toString()
	{
		return "A fireaxe named Friendslayer";
	}//End toString method
}//End class FriendSlayer
