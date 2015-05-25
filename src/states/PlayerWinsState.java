package states;

import java.awt.Font;
import java.awt.Graphics2D;

import runner.Game;
import utilities.Utilities;
import cards.Card;

public class PlayerWinsState extends State {
	private String message;
	private Card player;

	public PlayerWinsState(Game game) {
		super(game);

		addState("playerWins", this);
	}

	@Override
	public void startup() {
		message = GameState.players.get(GameState.currentPlayer).getName()
				+ " Wins";
		player = Card.playerCards.get(GameState.players.get(
				GameState.currentPlayer).getId());

		game.endGame();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (game.getKeyboardManager().enter)
			setState(getState("mainMenu"));
	}

	@Override
	public void render(Graphics2D g) {
		imageFade(g);
		player.render(g);
		game.getCamera().centerOnEntity(player);

		g.setColor(Utilities.rainbowFade());
		g.setFont(new Font("Consolas", Font.PLAIN, 32));
		drawCenteredString(message, 800, 600, 545, g);
	}

}
