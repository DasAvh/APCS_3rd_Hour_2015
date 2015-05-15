package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CafeteriaFood extends Weapon
{

	public CafeteriaFood()
	{
		//constructs the weapon and sets its image
		super();
		setWeaponPicture((Image)(new ImageIcon("CafeteriaFood.jpg").getImage()));
	}
	
	public String toString()
	{
		return "Cafeteria food";
	}
}
