package rooms;
 
import java.util.ArrayList;

public class Room 
{
	private int length;
	private int width;
	private String name;
	private boolean redPassage;
	private boolean bluePassage;
	private ArrayList<Character> charactersInRoom = new ArrayList<Character>();
	private Weapon weaponInRoom;
	private Room murderRoom;
	
	public Room(int l, int w, String n, boolean rP, boolean bP)
	{
		length = l;
		width = w;
		n = name;
		redPassage = rP;
		bluePassage = bP;
		weaponInRoom = null;
	}
	
	public boolean isInRoom(Character p)
	{
		for(Character pl : charactersInRoom)
		{
			if(pl == p)
				return true;
		}
		return false;
	}
	
	public void goThroughPassage(Room target, Character p)
	{
		if(redPassage == target.getRedPassage())
		{
			target.addCharacter(p);
			removeCharacter(p);
		}
		else if(bluePassage == target.getBluePassage())
		{
			target.addCharacter(p);
			removeCharacter(p);
		}
	}
	
	public boolean getRedPassage()
	{
		return redPassage;
	}
	
	public boolean getBluePassage()
	{
		return bluePassage;
	}
	
	public void addCharacter(Character p)
	{
		charactersInRoom.add(p);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Weapon getWeapon()
	{
		return weaponInRoom;
	}
	
	public void setWeapon(Weapon wep)
	{
		weaponInRoom = wep;
	}
	
	public void removeCharacter(Character p)
	{
		for(int x = 0; x <= charactersInRoom.size() - 1; x++)
		{
			if(charactersInRoom.get(x) == p)
			{
				charactersInRoom.remove(x);
			}
		}
	}
	
	public static String getMurderRoom()
	{
		return murderRoom;
	}
	
}
