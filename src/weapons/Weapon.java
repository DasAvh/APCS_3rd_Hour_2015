package weapons;

import java.awt.Image;
import javax.swing.ImageIcon;




public class Weapon
{
	protected boolean isMurderWeapon;
	protected Image weaponPicture;
	
	public Weapon()
	{
		isMurderWeapon = false;
		weaponPicture = null;
	}

	public void makeMurderWeapon()
	{
		isMurderWeapon = true;
	}
	
	public void switchMurderWeapon()
	{
		if(isMurderWeapon)
		{
			isMurderWeapon = false;
		}
		else
			isMurderWeapon = true;
	}
	
	public void setWeaponPicture(Image weapPic)
	{
		weaponPicture = weapPic;
	}
}
