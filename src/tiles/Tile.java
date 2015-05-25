package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	// Ids
	public static Tile[] tiles = new Tile[256];
	public static Tile hallwayTile = new HallwayTile(0);
	public static Tile wallTile = new WallTile(1);
	public static Tile doorTile = new DoorTile(2);
	public static Tile roomTile = new RoomTile(3);
	public static Tile spanwTile = new SpawnTile(4);
	public static Tile doorRotatedTile = new DoorTileRotated(5);

	public static final int HALLWAY_TILE = 0;
	public static final int WALL_TILE = 1;
	public static final int DOOR_TILE = 2;
	public static final int ROOM_TILE = 3;
	public static final int SPAWN_TILE = 4;

	// Fields
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	protected boolean isWalkble;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		isWalkble = false;
		tiles[id] = this;
	}// End constructor

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}// End render method

	public boolean isWalkable() {
		return isWalkble;
	}// End isWalkable

	public int getId() {
		return id;
	}// End getId method

	public boolean equal(Object obj) {
		return false;
	}// End equal method

	public void setToWalkable() {
		isWalkble = true;
	}// End setToWalkable method

	public void setToNotWalkable() {
		isWalkble = false;
	}// End setToNotWalkable method

	public Tile getTile() {
		return this;
	}// End getTile method
}// End class Tile
