package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GunCandlestick extends Weapon
{
	public GunCandlestick()
	{
		//constructs the weapon and sets its image
		super();
		setWeaponPicture((Image)(new ImageIcon("GunCandlestick.jpg").getImage()));
	}
	public String toString()
	{
		return "Candlestick made of guns";
	}
}
