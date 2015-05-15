package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuba extends Weapon
{
	public Tuba()
	{
		//constructs the weapon and sets its image
		super();
		setWeaponPicture((Image)(new ImageIcon("Tuba.JPG").getImage()));
	}
	public String toString()
	{
		return "Tuba";
	}
}
