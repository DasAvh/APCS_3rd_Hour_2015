import java.util.ArrayList;

public class Room 
{
	private int length;
	private int width;
	private String name;
	private boolean redPassage;
	private boolean bluePassage;
	private ArrayList<Player> playersInRoom = new ArrayList<Player>();
	private Weapon weaponInRoom;
	
	public Room(int l, int w, String n, boolean rP, boolean bP)
	{
		length = l;
		width = w;
		n = name;
		redPassage = rP;
		bluePassage = bP;
		weaponInRoom = null;
	}
	
	public boolean isInRoom(Player p)
	{
		for(Player pl : playersInRoom)
		{
			if(pl == p)
				return true;
		}
		return false;
	}
	
	public void goThroughPassage(Room target, Player p)
	{
		if(redPassage == target.getRedPassage())
		{
			target.addPlayer(p);
			removePlayer(p);
		}
		else if(bluePassage == target.getBluePassage())
		{
			target.addPlayer(p);
			removePlayer(p);
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
	
	public void addPlayer(Player p)
	{
		playersInRoom.add(p);
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
	
	public void removePlayer(Player p)
	{
		for(int x = 0; x <= playersInRoom.size() - 1; x++)
		{
			if(playersInRoom.get(x) == p)
			{
				playersInRoom.remove(x);
			}
		}
	}
}
