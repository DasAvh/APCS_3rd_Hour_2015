package weapons;

import java.awt.Image;
import javax.swing.ImageIcon;




public class Weapon
{
	private boolean isMurderWeapon;
	private Image weaponPicture;
	
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
	public boolean getIsMurderWeapon()
	{
		return isMurderWeapon;
	}
	public Image getWeaponPicture()
	{
		return weaponPicture;
	}
}
