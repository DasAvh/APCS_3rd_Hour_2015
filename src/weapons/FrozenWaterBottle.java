package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FrozenWaterBottle extends Weapon
{
	public FrozenWaterBottle()
	{
		super();
		setWeaponPicture((Image)(new ImageIcon("FrozenWaterBottle.jpg").getImage()));
	}
	public String toString()
	{
		return "FROZEN water bottle";
	}
}
