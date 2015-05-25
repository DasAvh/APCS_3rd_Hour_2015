package states;

import java.awt.Color;
import java.awt.Graphics2D;

import runner.Game;
import cards.Card;

public class LookAtCardsState extends State {

	public LookAtCardsState(Game game) {
		super(game);

		State.addState("lookAtCards", this);
	}// End constructor

	@Override
	public void tick() {
		if (game.getKeyboardManager().left && choosenText != 0)
			choosenText--;

		if (game.getKeyboardManager().right
				&& choosenText != GameState.players.size() - 1)
			choosenText++;

		if (game.getKeyboardManager().up && choosenText - 3 >= 0)
			choosenText -= 3;

		if (game.getKeyboardManager().down
				&& choosenText + 3 <= GameState.players.size() - 1)
			choosenText += 3;

		if (game.getKeyboardManager().enter || game.getKeyboardManager().escape)
			setState(getPrevState());
	}// End tick method

	public void render(Graphics2D g) {
		getPrevState().render(g);
		drawScreen(g);
	}

	private void drawScreen(Graphics2D g) {
		Card card;

		for (int x = 0; x < 6; x++) {
			card = GameState.players.get(GameState.currentPlayer).getCards()[x];

			if (x == choosenText) {
				game.getCamera().centerOnEntity(card);
				g.setColor(new Color(0, 0, 0, 155));
			}
			card.render(g);
		}// End for
	}

	@Override
	public void startup() {
		choosenText = 0;
		Card.realignCards(GameState.players.get(GameState.currentPlayer)
				.getCards());
	}
}// End ChooseCardsState

