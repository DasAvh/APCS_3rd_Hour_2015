package evidence;

public class Interrogation 
{
	private static String[] listOfRooms = {"Mr. Clark's Room","Chem Lab","Chavez's Room","Cafeteria","Auto Room","Bathroom","Band Room","Art Studio","Gym"};
	private static String[] weapons = {"The Norton","Gun Candlestick","Tuba","Frozen Waterbottle","Cafeteria Food","Fire Axe"};
	private static String[] people = {
		"Nicholas Biegel",
		"Victor Bolivar",
		"Nathon Bowdish",
		"Jordan Buckmaster",
		"Jocelynn Cheesebourough",
		"Jay Chopra",
		"Daniel Gilbert",
		"Lauren Granskog",
		"Ethan Hunt",
		"Samuel Hupp",
		"Nathon Jackson",
		"Jacob Kieta",
		"Celine McCormack",
		"Noah Miller",
		"Mike the Pimp Norcutt",
		"Gage O'Conner",
		"Mathew Palm",
		"Dino Rinaldi",
		"Andrew Ring",
		"Peter Shepered",
		"Justin Tancos",
		"Tiffany Tao",
		"Jesse Veloz",
		"Jakub Wrobel",
		"Jacob Zak"
	};
	private String solWeapon =  weapons[(int)(Math.random() * 6)];
	private String solCharacter = people[(int)(Math.random() * 25)];
	private String solRoom = listOfRooms[(int)(Math.random() * 9)];

	
	public String getInterogation(Weapon w, Character c, Room r)
	{
		if(solWeapon.equals(w) && solCharacter.equals(c) && solRoom.equals(r.getName()))
		{
			System.out.println("That's an interesting possibility...");
		}
		else if(solWeapon.equals(w))
		{
			System.out.println("")
		}
	}
	
	
}