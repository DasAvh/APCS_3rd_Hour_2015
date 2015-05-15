package weapons;

import java.awt.Image;




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
		//like switch murder weapon but only turns isMurderWeapon to true
		isMurderWeapon = true;
	}
	
	public void switchMurderWeapon()
	{
		//switches if the weapon is a murder weapon or not
		if(isMurderWeapon)
		{
			isMurderWeapon = false;
		}
		else
			isMurderWeapon = true;
	}
	
	public void setWeaponPicture(Image weapPic)
	{
		//sets the picture that is the weapon
		weaponPicture = weapPic;
	}
	public boolean getIsMurderWeapon()
	{
		//gets if the weapon is a murder weapon
		return isMurderWeapon;
	}
	public Image getWeaponPicture()
	{
		//gets the picture of the weapon
		return weaponPicture;
	}
}
