package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FriendSlayer extends Weapon
{
	public FriendSlayer()
	{
		super();
		setWeaponPicture((Image)(new ImageIcon("FriendSlayer.jpg").getImage()));
	}
}
