package evidence;

public class Testing {
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
	private static String[] rooms = {"Mr. Clark's Room","Chem Lab","Chavez's Room","Cafeteria","Auto Room","Bathroom","Band Room","Art Studio","Gym"};
	public static void main(String[] args){
		System.out.println(people[(int) (Math.random() * people.length)] + " was found with a " + weapons[(int) (Math.random() * weapons.length)] + " in the " + rooms[(int) (Math.random() * rooms.length)]);
		System.out.println("Okkk!");
	}
}
