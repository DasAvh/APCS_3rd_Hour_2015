package evidence;

import java.util.ArrayList;
import java.util.List;

import rooms.Room;
import states.GameState;
import utilities.Utilities;
import weapons.Weapon;
import cards.Card;
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
        
        givePlayersCards(ppl, weaps, rooms);
        System.out.println("WATSON OUT");
    }
     
    private void givePlayersCards(ArrayList<Player> ppl, ArrayList<Weapon> weaps, ArrayList<Room> rooms) 
    {
    	ArrayList<PlayerCard> tempPlayerCards = new ArrayList<PlayerCard>();
       	for(int x = 0; x < ppl.size(); x++)
       		tempPlayerCards.add(Card.getPlayerCards().get(ppl.get(x).getId()));
       	
    	ArrayList<WeaponCard> tempWeaponCards = Card.getWeaponCards();
    	ArrayList<RoomCard> tempRoomCards = Card.getRoomCards();
    	List<Card> choosenCards = new ArrayList<Card>();
    	Card[] cards = new Card[6];
    	int index = 0;
    	
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

     
        
        System.out.println("MURDER ITEMS : " + pl + " | " + weap + " |  " + rm);
        
    	for(int x = 0; x < tempPlayerCards.size(); x++)
    	{
    		index = 0;
    		cards = new Card[6];

            choosenCards.add(tempWeaponCards.get(weap.getId()));
            choosenCards.add(Card.getPlayerCards().get(pl.getId()));
            choosenCards.add(tempRoomCards.get(rm.getId() - 1));
    	    
    		while(index < 6)
    		{
    	        int rn = (int) (Math.random() * 3);
    	        PlayerCard randomPlayerCard = tempPlayerCards.get(Utilities.genRandomNum(tempPlayerCards.size()));
    	        WeaponCard randomWeaponCard = tempWeaponCards.get(Utilities.genRandomNum(tempWeaponCards.size()));
    	        RoomCard randomRoomCard = tempRoomCards.get(Utilities.genRandomNum(tempRoomCards.size()));

    	        if(rn == 0 && !(choosenCards.contains(randomPlayerCard)))
    	        {
    	        	System.out.println("PLAYER CARD");
    	        	cards[index] = randomPlayerCard;
    	        	choosenCards.add(randomPlayerCard);
    	        	index++;
    	        }
    	        
    	        if(rn == 1 && !(choosenCards.contains(randomWeaponCard)))
    	        {
    	        	System.out.println("WEAPON CARD");
    	        	cards[index] = randomWeaponCard;
    	        	choosenCards.add(randomWeaponCard);
    	        	index++;
    	        }
    	        
    	        if(rn == 2 && !(choosenCards.contains(randomRoomCard)))
    	        {
    	        	System.out.println("ROOM CARD");
    	        	cards[index] = randomRoomCard;
    	        	choosenCards.add(randomRoomCard);
    	        	index++;
    	        }
    	  
    		}//End while
    		choosenCards.clear();

    		GameState.players.get(x).giveCards(cards);
    	}//End outer for
	}//End givePlayerCards

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
     
	public ArrayList<String> getInterrogation(PlayerCard n, WeaponCard w, RoomCard r)
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
			msgs.add("Hmm...That is a interesting possibility.");
		}else{
			msgs.add(r.getSlogan());
			msgs.add(n.getSlogan());
			msgs.add(w.getSlogan());
			if(!(weap.getName().equals(w)))
				msgs.add("WAIT! I am certain it could not have been the" + w + ". I have proof.");
			else if(!(pl.getName().equals(n)))
				msgs.add("WAIT! I am certain it could not have been " + n + ". I have proof.");
			else if(!(rm.getName().equals(r)))
				msgs.add("WAIT! I am certain it could not have been in the " + r + ". I have proof.");
		}
		
		return msgs;
	}
     
    public ArrayList<String> getAccusation(PlayerCard p, WeaponCard w, RoomCard r){
        ArrayList<String> msgs = new ArrayList<String>();
        //Room Then Character Then
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
         
        if(weap.getName().equals(w) && pl.getName().equals(p) && rm.getName().equals(r)){
            msgs.add(r.getSlogan());
            msgs.add(p.getSlogan());
            msgs.add(w.getSlogan());
            msgs.add("You Win");
        }else{
            msgs.add(r.getSlogan());
            msgs.add(p.getSlogan());
            msgs.add(w.getSlogan());
            msgs.add("You Lose");
        }
         
        return msgs;
    }
     
    public boolean isGuessRight(PlayerCard p, WeaponCard w, RoomCard r){
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
         
        if(weap.getName().equals(w) && pl.getName().equals(p) && rm.getName().equals(r)){
            return true;
        }else{
            return false;
        }
    }
     
    public void listGroups(){
        for(RGroup i : groups){
            System.out.println(i.isIt());
        }
    }
}
