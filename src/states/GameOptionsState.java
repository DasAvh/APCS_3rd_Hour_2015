package states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;

public class GameOptionsState extends State {
	// Ids
	private static final int RETURN = 3;

	public GameOptionsState(Game game) {
		super(game);

		// Setup text options
		titleText = "SETTINGS";
		textOptions = new ArrayList<String>();
		textOptions.add("Idk");
		textOptions.add("Wasn't on");
		textOptions.add("the budget");

		textOptions.add("Return");

		// Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 255);
		backDropColor = new Color(0, 0, 0, 155);

		addState("gameOptions", this);
	}// End constructor

	@Override
	public void tick() {
		navigateMenu();

		if (game.getKeyboardManager().enter && choosenText == RETURN)
			setState(State.getPrevState());
	}// End method tick

	@Override
	public void render(Graphics2D g) {
		// Sets background
		imageFade(g);

		drawMenu(g);
	}// End render method

	@Override
	public void startup() {
		// TODO Auto-generated method stub

	}
}// End class GameOptionsState
