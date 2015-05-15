package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuba extends Weapon
{
	public Tuba()
	{
		super();
		setWeaponPicture((Image)(new ImageIcon("Tuba.JPG").getImage()));
	}
	public String toString()
	{
		return "Tuba";
	}
}
