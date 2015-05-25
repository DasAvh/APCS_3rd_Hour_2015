package tiles;

import graphics.Assets;

public class DoorTileRotated extends Tile {
	public DoorTileRotated(int id) {
		super(Assets.doorV, id);
	}// End constructor

	public boolean isWalkable() {
		return true;
	}// End isWalkable method
}// End DoorTile class
