package weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Weapon
{
	//Ids
	public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	//Fields
	public static final int WEAPON_WIDTH = 256;
	public static final int WEAPON_HEIGHT = 256;
	
	protected BufferedImage texture;
	protected boolean isMurderWeapon;
	private String name, slogan;
	
	public static void initialize()
	{
		weapons.add(new Tuba());
		weapons.add(new TheNorton());
		weapons.add(new GunCandleStick());
		weapons.add(new FrozenWaterBottle());
		weapons.add(new FriendSlayer());
		weapons.add(new CafeteriaFood());
	}
	
	public Weapon(BufferedImage texture, String name, String slogan)
	{
		this.texture = texture;
		this.name = name;
		this.slogan = slogan;
	}//End constructor
	
	public void makeMurderWeapon()
	{
		isMurderWeapon = true;
	}//End makeMurederWeapon method
	
	public boolean isMurderWeapon()
	{
		return isMurderWeapon;
	}//End isMurderWeapon method
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, null);
	}//End render method
	
	public String getName()
	{
		return name;
	}
	
	public String getSlogan()
	{
		return slogan;
	}
}//End class Weapon

