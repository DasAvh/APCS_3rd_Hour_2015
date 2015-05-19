package weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Weapon
{
	//Ids
	public static Weapon[] weapons = new Weapon[6];
	public static Weapon cafeteriaFoodWeapon = new CafeteriaFood(0);
	public static Weapon friendSlayerWeapon = new FriendSlayer(1);
	public static Weapon frozenWaterBottleWeapon = new FrozenWaterBottle(2);
	public static Weapon gunCandleStickWeapon = new GunCandleStick(3);
	public static Weapon theNortondWeapon = new TheNorton(4);
	public static Weapon tubaWeapon = new Tuba(5);
	
	//Fields
	public static final int WEAPON_WIDTH = 256;
	public static final int WEAPON_HEIGHT = 256;
	
	protected BufferedImage texture;
	protected boolean isMurderWeapon;
	protected final int id;
	
	
	
	public Weapon(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		weapons[id] = this;
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
	
	public int getId()
	{
		return id;
	}//End getId
}//End class Weapon
