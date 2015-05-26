package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;
import tiles.Tile;
import utilities.Utilities;
import entity.chars.Player;

public class DieRollState extends State {
	// Fields

	public DieRollState(Game game) {
		super(game);

		// Setup colors
		backDropColor = new Color(0, 0, 0, 155);
		passiveTextColor = new Color(255, 0, 0);
		activeTextColor = new Color(255, 255, 255);

		// TEMP - Setup text
		textOptions = new ArrayList<String>();
		textOptions.add("1");
		textOptions.add("2");
		textOptions.add("3");
		textOptions.add("4");
		textOptions.add("5");
		textOptions.add("6");

		choosenText = 0;

		addState("die", this);
	}// End constructor

	@Override
	public void tick() {
		if (game.getKeyboardManager().enter) {
			choosenText = Utilities.diceRoll();
			GameState.players.get(GameState.currentPlayer).setAmountOfMoves(
					choosenText + 1);
			setState(getState("game"));
		}// End if
	}// End tick method

	@Override
	public void render(Graphics2D g) {
		// Maintains game state as a background
		getState("game").render(g);

		// Sets black overlay
		g.setColor(backDropColor);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());

		// Text
		g.setFont(new Font("Consolas", Font.PLAIN, 42));
		g.setColor(Utilities.rainbowFade());
		drawCenteredString(GameState.players.get(GameState.currentPlayer)
				.getName(), 800, 600, 300, g);
		g.setFont(font);
		drawCenteredString("ROLL", 800, 600, 342, g);
	}// End render method

	@Override
	public void startup() {

		System.out.println(game.newGame());
		
		if (game.newGame()) {
			GameState.currentPlayer = 0;
			
			GameState.players.clear();
			for (int x = 0; x < 6; x++) {
				GameState.players.add(new Player(game, game.getBoard()
						.getSpawnX()[x] * Tile.TILE_WIDTH, game.getBoard()
						.getSpawnY()[x] * Tile.TILE_HEIGHT, 
						ChoosePlayersState.choosenCards.get(x).getId(),
						ChoosePlayersState.choosenCards.get(x).getName(),
						ChoosePlayersState.choosenCards.get(x).getSlogan(), x));

			}// End for
		}// End if
	}// End startup method
}// End class DieRollState
