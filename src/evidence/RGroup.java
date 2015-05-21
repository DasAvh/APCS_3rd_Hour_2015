package evidence;

import rooms.Room;
import weapons.Weapon;
import entity.chars.Player;


public class RGroup
{
	//Fields
	private Player player;
	private Weapon weapon;
	private Room room;
	private boolean killerGroup;

	private int id;
	
	public RGroup(Player p, Weapon w, Room r, int id)
	{
		player = p;
		weapon = w;
		room = r;
		this.id = id;
		killerGroup = false;
	}
	public String toString()
	{
		return player.getName() + " in the " + room + " with a " + weapon + " (ID: " + getId() + ")";
	}
	public Weapon getWeapon(){
		return weapon;
	}
	public Player getPlayer(){
		return player;
	}
	public Room getRoom(){
		return room;
	}
	public boolean isIt(){
		return killerGroup;
	}
	public void setIsIt(){
		killerGroup = true;
	}
	
	public int getId(){
		return id;
	}
}

