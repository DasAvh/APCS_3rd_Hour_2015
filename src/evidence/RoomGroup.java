package evidence;

import weapons.Weapon;


public class RoomGroup
{
	//Fields
	private Character character;
	private Weapon weapon;
	private Room room;
	private boolean killerGroup;

	public RGroup(Character c, Weapon w, Room r)
	{
		character = c;
		weapon = w;
		room = r;
		killerGroup = false;
	}
	public String toString()
	{
		return character.getName() + " in the " + room + " with a " + weapon;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	public Character getCharacter(){
		return character;
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
}

