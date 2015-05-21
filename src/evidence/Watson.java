import java.util.ArrayList;


public class Watson {
	private ArrayList<RGroup> groups;
	private final String[] listOfRooms = {"Mr. Clark's Room","Chem Lab","Chavez's Room","Cafeteria","Auto Room","Bathroom","Band Room","Art Studio","Gym", "Hall"};
	private final String[] weapons = {"The Norton","Gun Candlestick","Tuba","Frozen Waterbottle","Cafeteria Food","Fire Axe"};
	
	public Watson(ArrayList<Character> ppl, ArrayList<Weapon> weaps, ArrayList<Room> rooms)
	{
		groups = new ArrayList<RGroup>();
		
		for(Character c : ppl)
		{
			Weapon w = weaps.remove((int)(Math.random() * weaps.size()));
			Room r = rooms.remove((int)(Math.random() * rooms.size()));
			RGroup g = new RGroup(c,w,r);
			groups.add(g);
		}

		groups.get((int)(Math.random() * groups.size())).setIsIt();
	}
	
	/*
	 * Completed
	 * 
	 */
	public String getSuggestion(String n, String w, String r){
		int rn = (int) (Math.random() * 3);
		if(rn == 0){
			//Weapon
			for(RGroup i : groups){
				if(i.getWeapon().getName().equals(w)){
					return "The " + w + " was in " + i.getRoom().getName();
				}
			}
			return "";
		}else if(rn == 1){
			//Person
			for(RGroup i : groups){
				if(i.getCharacter().getName().equals(n)){
					return n + " was in the " + i.getRoom().getName();
				}
			}
			return "";
		}else if(rn == 2){
			//Person
			for(RGroup i : groups){
				if(i.getRoom().getName().equals(r)){
					return i.getCharacter().getName() + " was in the " + r;
				}
			}
			return "NoBody was in the " + r;
		}else{
			//Weapon
			for(RGroup i : groups){
				if(i.getRoom().getName().equals(r)){
					return "The " + i.getWeapon().getName() + " was in " + r;
				}
			}
			return "Nothing was in the " + r;
		}
	}
	
	public ArrayList<String> getInterrogation(String n, String w, String r){
		ArrayList<String> msgs = new ArrayList<String>();
		//Room Then Character Then
		boolean winner = false;
		Weapon weap = null;
		Character ch = null;
		Room rm = null;
		for(RGroup i : groups){
			if(i.isIt()){
				weap = i.getWeapon();
				ch = i.getCharacter();
				rm = i.getRoom();
				break;
			}
		}
		
		if(weap.getName().equals(w) && ch.getName().equals(n) && rm.getName().equals(r)){
			msgs.add(rm.getSlogan());
			msgs.add(ch.getNSlogan());
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
