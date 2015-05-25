package tiles;

import graphics.Assets;

public class HallwayTile extends Tile {

	public HallwayTile(int id) {
		super(Assets.hallway, id);
		isWalkble = true;
	}// End constructor

}// End class HallwayTile
