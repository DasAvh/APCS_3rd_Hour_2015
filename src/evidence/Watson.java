package evidence;

import java.util.ArrayList;

import rooms.Room;
import weapons.Weapon;
import cards.PlayerCard;
import cards.RoomCard;
import cards.WeaponCard;
import entity.chars.Player;


public class Watson 
{
	private ArrayList<RGroup> groups;
	
	public Watson(ArrayList<Player> ppl, ArrayList<Weapon> weaps, ArrayList<Room> rooms)
	{	
		groups = new ArrayList<RGroup>();
		int index = 1;
		
		for(Player c : ppl)
		{
			Weapon w = weaps.remove((int)(Math.random() * weaps.size()));
			Room r = rooms.remove((int)(Math.random() * rooms.size()));
			RGroup g = new RGroup(c,w,r, index);
			index++;
			groups.add(g);
		}

		groups.get((int)(Math.random() * groups.size())).setIsIt();
		
		for(RGroup g : groups)
			System.out.println(g);
	}
	
	/*
	 * Completed
	 * 
	 */
	public String getSuggestion(PlayerCard n, WeaponCard w, RoomCard r)
	{
		int rn = (int) (Math.random() * 3);
		if(rn == 0)
		{
			//Weapon
			for(RGroup i : groups)
			{
				System.out.println(i.getWeapon().getName() + " " + w.getName());
				if(i.getWeapon().getName().equals(w))
				{
					return "The " + w + " was in " + i.getRoom().getName();
				}
			}
			return "A";
		}else if(rn == 1)
		{
			//Person
			for(RGroup i : groups)
			{
				System.out.println(i.getPlayer().getName() + " " + n.getName());
				if(i.getPlayer().getName().equals(n.getName()))
				{
					return n + " was in the " + i.getRoom().getName();
				}
			}
			return "B";
		}else if(rn == 2)
		{
			//Room
			for(RGroup i : groups)
			{
				System.out.println(i.getRoom().getName() + " " + r.getName());
				if(i.getRoom().getName().equals(r.getName()))
				{
					return i.getPlayer().getName() + " was in the " + r;
				}
			}
			return "NoBody was in the " + r;
		}else{
			//Weapon
			for(RGroup i : groups)
			{
				if(i.getRoom().getName().equals(w.getName()))
				{
					return "The " + i.getWeapon().getName() + " was in " + r;
				}
			}
			return "Nothing was in the " + r;
		}
	}
	
	public ArrayList<String> getInterrogation(String n, String w, String r)
	{
		ArrayList<String> msgs = new ArrayList<String>();
		//Room Then Character Then
		boolean winner = false;
		Weapon weap = null;
		Player pl = null;
		Room rm = null;
		for(RGroup i : groups){
			if(i.isIt()){
				weap = i.getWeapon();
				pl = i.getPlayer();
				rm = i.getRoom();
				break;
			}
		}
		
		if(weap.getName().equals(w) && pl.getName().equals(n) && rm.getName().equals(r)){
			msgs.add(rm.getSlogan());
			msgs.add(pl.getSlogan());
			msgs.add(weap.getSlogan());
			msgs.add("Hmm...That is a interesting possibility");
		}else{
			msgs.add("NOPE");
		}
		
		return msgs;
	}
	
	public ArrayList<String> getAccusation(String n, String w, String r){

		
		return new ArrayList<String>();
	}
	
	public void listGroups(){
		for(RGroup i : groups){
			System.out.println(i.isIt());
		}
	}
}
