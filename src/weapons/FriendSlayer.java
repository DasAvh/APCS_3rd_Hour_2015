package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FriendSlayer extends Weapon
{
	public FriendSlayer()
	{
		//constructs the weapon and sets its image
		super();
		setWeaponPicture((Image)(new ImageIcon("FriendSlayer.jpg").getImage()));
	}
	public String toString()
	{
		return "A fireaxe named Friendslayer";
	}
}
