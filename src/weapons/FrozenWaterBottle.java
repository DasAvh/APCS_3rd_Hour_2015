package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FrozenWaterBottle extends Weapon
{
	public FrozenWaterBottle()
	{
		//constructs the weapon and sets its image
		super();
		setWeaponPicture((Image)(new ImageIcon("FrozenWaterBottle.jpg").getImage()));
	}
	public String toString()
	{
		return "FROZEN water bottle";
	}
}
