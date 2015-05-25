package weapons;

import graphics.Assets;

public class TheNorton extends Weapon {
	public TheNorton() {
		super(Assets.theNorton, "The Nortan",
				"The Norton Anthology of English Literature", 1);
	}// End constructor

	public String toString() {
		return "The Norton Anthology of English Literature";
	}// End toString method
}// End TheNorton class
