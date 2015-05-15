package weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Norton extends Weapon
{

	public Norton()
	{
		super();
		setWeaponPicture((Image)(new ImageIcon("TheNorton.jpg").getImage()));
	}
	public String toString()
	{
		return "The Norton Anthology of English Literature";
	}
}
