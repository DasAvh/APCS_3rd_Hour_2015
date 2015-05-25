package tiles;

import graphics.Assets;

public class DoorTile extends Tile {
	public DoorTile(int id) {
		super(Assets.doorH, id);
	}// End constructor

	public boolean isWalkable() {
		return true;
	}// End isWalkable method
}// End DoorTile class
