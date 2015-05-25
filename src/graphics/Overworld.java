package graphics;

import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;
import utilities.Utilities;

public class Overworld {
	// Fields
	private static Game game;
	private static final int WIDTH = 64;
	private static final int HEIGHT = 64;
	private static ArrayList<Integer> xCoords;
	private static ArrayList<Integer> yCoords;
	private static ArrayList<String> id;

	public static void initialize(Game aGame, String path) {
		game = aGame;
		String temp[] = Utilities.loadFile(path).split("\n");
		xCoords = new ArrayList<Integer>();
		yCoords = new ArrayList<Integer>();
		id = new ArrayList<String>();

		for (int x = 0; x < temp.length; x++) {
			xCoords.add(Utilities.parseInt(temp[x].split("\\s+")[0]));
			yCoords.add(Utilities.parseInt(temp[x].split("\\s+")[1]));
			id.add(temp[x].split("\\s+")[2]);
		}
	}// End method initialize

	public static void renderRooms(Graphics2D g) {
		for (int x = 0; x < id.size(); x++)
			g.drawImage(Assets.overworldImages.get(id.get(x)),
					(int) (xCoords.get(x) * WIDTH - game.getCamera()
							.getxOffset()),
					(int) (yCoords.get(x) * HEIGHT - game.getCamera()
							.getyOffset()), WIDTH * 3, HEIGHT * 3, null);
	}
	
	public static void renderOutside(Graphics2D g)
	{
		g.drawImage(Assets.lcBorder, (int)(-3 * 64 -game.getCamera().getxOffset()),(int) (-3 * 64 -game.getCamera().getyOffset()), null);
	}
}// End class Overworld
