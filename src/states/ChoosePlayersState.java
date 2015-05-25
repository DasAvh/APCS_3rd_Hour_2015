package states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;
import sound.SoundBoard;
import cards.Card;
import cards.PlayerCard;

public class ChoosePlayersState extends State {
	// Fields
	public static ArrayList<PlayerCard> choosenCards;
	private Card card;

	public ChoosePlayersState(Game game) {
		super(game);
		choosenCards = new ArrayList<PlayerCard>();
		State.addState("choosePlayers", this);
	}// End constructor

	@Override
	public void tick() {
		if (game.getKeyboardManager().left && choosenText != 0)
			choosenText--;

		if (game.getKeyboardManager().right
				&& choosenText != Card.playerCards.size() - 1)
			choosenText++;

		if (game.getKeyboardManager().up && choosenText - 4 >= 0)
			choosenText -= 4;

		if (game.getKeyboardManager().down
				&& choosenText + 4 <= Card.playerCards.size() - 1)
			choosenText += 4;

		if (game.getKeyboardManager().enter
				&& !Card.playerCards.get(choosenText).isChoosen()) {
			choosenCards.add(Card.playerCards.get(choosenText));
			Card.playerCards.get(choosenText).choosen();
		}

		if (game.getKeyboardManager().escape)
			setState(getPrevState());

		if (choosenCards.size() == 6) {
			SoundBoard.stopSound();
			setState(State.getState("die"));
		}

		// game.getCamera().centerOnEntity(Card.playerCards.get(choosenText));
	}// End tick method

	@Override
	public void render(Graphics2D g) {
		imageFade(g);
		for (int x = 0; x < Card.playerCards.size(); x++) {
			card = Card.playerCards.get(x);

			if (x == choosenText) {
				game.getCamera().centerOnEntity(card);
				g.setColor(new Color(0, 0, 0, 155));
			}

			card.render(g);
		}
	}// End render method

	@Override
	public void startup() {
		choosenText = 0;
		for (int x = 0; x < choosenCards.size(); x++)
			choosenCards.get(x).unChoosen();

		Card.initialize(game);
		choosenCards.clear();
	}
}// End ChoosePlayersState
