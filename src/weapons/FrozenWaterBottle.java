package weapons;

import graphics.Assets;

public class FrozenWaterBottle extends Weapon {

	public FrozenWaterBottle() {
		super(Assets.frozenWaterBottle, "a Frozen Water Bottle",
				"FROZEN water bottle", 3);
	}// End constructor

	public String toString() {
		return "FROZEN water bottle";
	}// End toString method
}// End class FrozenWaterBottle
