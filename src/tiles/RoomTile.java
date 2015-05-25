package tiles;

import graphics.Assets;

public class RoomTile extends Tile {

	public RoomTile(int id) {
		super(Assets.room, id);
		isWalkble = true;
	}
}
