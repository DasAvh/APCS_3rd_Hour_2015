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

public class Watson {
	private static ArrayList<RGroup> groups;
	public static Room roomEvidenceIsIn;
	public static Player playerInRoom;

	public Watson(ArrayList<Player> ppl, ArrayList<Weapon> weaps,
			ArrayList<Room> rooms) {
		groups = new ArrayList<RGroup>();
		int index = 1;

		for (Player c : ppl) {
			Weapon w = weaps.remove((int) (Math.random() * weaps.size()));
			Room r = rooms.remove((int) (Math.random() * rooms.size()));
			RGroup g = new RGroup(c, w, r, index);
			index++;
			groups.add(g);
		}

		groups.get((int) (Math.random() * groups.size())).setIsIt();

		for (RGroup g : groups)
			System.out.println(g);

		givePlayersCards(ppl, weaps, rooms);
		System.out.println("WATSON OUT");
	}

	private void givePlayersCards(ArrayList<Player> ppl,
			ArrayList<Weapon> weaps, ArrayList<Room> rooms) {
		ArrayList<PlayerCard> tempPlayerCards = new ArrayList<PlayerCard>();
		for (int x = 0; x < ppl.size(); x++)
			tempPlayerCards.add(Card.getPlayerCards().get(ppl.get(x).getId()));

		ArrayList<WeaponCard> tempWeaponCards = Card.getWeaponCards();
		ArrayList<RoomCard> tempRoomCards = Card.getRoomCards();
		List<Card> choosenCards = new ArrayList<Card>();
		Card[] cards = new Card[6];
		int index = 0;

		Weapon weap = null;
		Player pl = null;
		Room rm = null;

		for (RGroup i : groups) {
			if (i.isIt()) {
				weap = i.getWeapon();
				pl = i.getPlayer();
				rm = i.getRoom();
				break;
			}
		}

		System.out.println("MURDER ITEMS : " + pl + " | " + weap + " |  " + rm);

		for (int x = 0; x < tempPlayerCards.size(); x++) {
			index = 0;
			cards = new Card[6];

			choosenCards.add(tempWeaponCards.get(weap.getId()));
			choosenCards.add(Card.getPlayerCards().get(pl.getId()));
			choosenCards.add(tempRoomCards.get(rm.getId() - 1));

			while (index < 6) {
				int rn = (int) (Math.random() * 3);
				PlayerCard randomPlayerCard = tempPlayerCards.get(Utilities
						.genRandomNum(tempPlayerCards.size()));
				WeaponCard randomWeaponCard = tempWeaponCards.get(Utilities
						.genRandomNum(tempWeaponCards.size()));
				RoomCard randomRoomCard = tempRoomCards.get(Utilities
						.genRandomNum(tempRoomCards.size()));

				if (rn == 0 && !(choosenCards.contains(randomPlayerCard))) {
					cards[index] = randomPlayerCard;
					choosenCards.add(randomPlayerCard);
					index++;
				}
				if (rn == 1 && !(choosenCards.contains(randomWeaponCard))) {
					cards[index] = randomWeaponCard;
					choosenCards.add(randomWeaponCard);
					index++;
				}
				if (rn == 2 && !(choosenCards.contains(randomRoomCard))) {
					cards[index] = randomRoomCard;
					choosenCards.add(randomRoomCard);
					index++;
				}

			}// End while
			choosenCards.clear();

			GameState.players.get(x).giveCards(cards);
		}// End outer for
	}// End givePlayerCards

	public String getSuggestion(PlayerCard n, WeaponCard w, RoomCard r) {
		int rn = (int) (Math.random() * 3);
		System.out.println(rn);

		if (rn == 0) {
			// Weapon
			for (RGroup i : groups) {
				System.out.println(i.getWeapon().getName() + " " + w.getName());
				if (i.getWeapon().equals(w)) {
					playerInRoom = i.getPlayer();
					roomEvidenceIsIn = i.getRoom();
					return "The " + w + " was in " + i.getRoom().getName();
				}
			}
			return "A";
		} else if (rn == 1) {
			// Person
			for (RGroup i : groups) {
				System.out.println(i.getPlayer().getName() + " " + n.getName());
				if (i.getPlayer().equals(n)) {
					playerInRoom = i.getPlayer();
					roomEvidenceIsIn = i.getRoom();
					return n + " was in the " + i.getRoom().getName();
				}
			}

			return "B";
		} else if (rn == 2) {
			// Room
			for (RGroup i : groups) {
				System.out.println(i.getRoom().getName() + " " + r.getName());
				if (i.getRoom().equals(r)) {
					playerInRoom = i.getPlayer();
					roomEvidenceIsIn = i.getRoom();
					return i.getPlayer().getName() + " was in the " + r;
				}
			}
			System.out.println(Room.rooms2);
			roomEvidenceIsIn = Room.rooms[r.getId()];
			return "Nobody was in the " + r;
		} else {
			// Weapon
			for (RGroup i : groups) {
				if (i.getRoom().equals(w)) {
					playerInRoom = i.getPlayer();
					roomEvidenceIsIn = i.getRoom();
					return "The " + i.getWeapon().getName() + " was in " + r;
				}
			}

			roomEvidenceIsIn = Room.rooms2.get(r.getId());
			Utilities.pauseGame(5000);
			return "Nothing was in the " + r;
		}
	}

	public ArrayList<String> getInterrogation(PlayerCard n, WeaponCard w,
			RoomCard r) {
		ArrayList<String> msgs = new ArrayList<String>();
		// Room Then Character Then
		boolean winner = false;
		Weapon weap = null;
		Player pl = null;
		Room rm = null;
		for (RGroup i : groups) {
			if (i.isIt()) {
				weap = i.getWeapon();
				pl = i.getPlayer();
				rm = i.getRoom();
				break;
			}
		}

		if (weap.equals(w) && pl.equals(n) && rm.equals(r)) {
			msgs.add(r.getSlogan());
			msgs.add(n.getInterSlogan());
			msgs.add(w.getSlogan());
			msgs.add("Hmm...That is a interesting possibility.");
		} else {
			msgs.add(n.getInterSlogan());
			msgs.add(r.getName() + " with");
			msgs.add(w.getName());
			if (!(weap.equals(w)))
				msgs.add("WAIT! I am certain it could not have been the " + w
						+ ". I have proof.");
			else if (!(pl.equals(n)))
				msgs.add("WAIT! I am certain it could not have been " + n
						+ ". I have proof.");
			else if (!(rm.equals(r)))
				msgs.add("WAIT! I am certain it could not have been in the "
						+ r + ". I have proof.");
		}

		return msgs;
	}

	public ArrayList<String> getAccusation(PlayerCard p, WeaponCard w,
			RoomCard r) {
		ArrayList<String> msgs = new ArrayList<String>();
		// Room Then Character Then
		Weapon weap = null;
		Player pl = null;
		Room rm = null;
		for (RGroup i : groups) {
			if (i.isIt()) {
				weap = i.getWeapon();
				pl = i.getPlayer();
				rm = i.getRoom();
				break;
			}
		}

		if (weap.equals(w) && pl.equals(p) && rm.equals(r)) {
			msgs.add(r.getSlogan());
			msgs.add(p.getName());
			msgs.add(w.getSlogan());
			msgs.add(p.getSlogan());
		} else {
			msgs.add(r.getSlogan());
			msgs.add(p.getName());
			msgs.add(w.getSlogan());
			msgs.add("You Lose");
		}

		return msgs;
	}

	public static Player getKiller()
	{
		
		Player pl = null;
		for (RGroup i : groups) 
		{
			if (i.isIt())
				pl = i.getPlayer();
		}
		return pl;
	}
	
	public void listGroups() {
		for (RGroup i : groups) {
			System.out.println(i.isIt());
		}
	}
}
