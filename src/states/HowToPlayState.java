package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;
import utilities.Utilities;

public class HowToPlayState extends State {
	// Fields
	private ArrayList<String> instructions;

	public HowToPlayState(Game game) {
		super(game);

		// Text options
		titleText = "HOW TO PLAY";
		textOptions = new ArrayList<String>();
		textOptions.add("Jessie do it");
		textOptions.add("Return");

		// How to play message
		instructions = Utilities.loadFileArray("res/Instructions.txt");

		// Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 255);
		backDropColor = new Color(0, 0, 0, 155);

		// Defaults chosen text
		choosenText = 0;

		addState("howToPlay", this);
	}// End constructor

	@Override
	public void tick() {
		navigateMenu();
		if (game.getKeyboardManager().enter)
			setState(State.getPrevState());
		// End if
	}// End tick method

	@Override
	public void render(Graphics2D g) {
		// Sets background
		imageFade(g);

		g.setColor(backDropColor);
		g.fillRect(140, 150 - fontSize, 530, 200 * textOptions.size());

		Font nozzle = new Font("Arial", Font.BOLD, 14);
		g.setFont(nozzle);
		g.setColor(Color.CYAN);

		for (int x = 0; x < instructions.size(); x++) {
			g.drawString(instructions.get(x), 150, (x * 14) + 150);
			System.out.println("\n");
		}
	}// End render method

	@Override
	public void startup() {
		// TODO Auto-generated method stub

	}

}// End class HowToPlayState
