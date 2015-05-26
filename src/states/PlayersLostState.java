package states;

import java.awt.Font;
import java.awt.Graphics2D;

import runner.Game;
import utilities.Utilities;
import cards.Card;
import cards.PlayerCard;
import entity.chars.Player;
import evidence.Watson;
import graphics.Assets;

public class PlayersLostState extends State {
	private PlayerCard killerCard;
	private Player killer;
	private String lostMessage;

	public PlayersLostState(Game game) {
		super(game);
		game.endGame();
		addState("playersLost", this);
	}

	@Override
	public void startup() {
		game.endGame();
		killer = Watson.getKiller();
		killerCard = Card.playerCards.get(killer.getId());
		lostMessage = Assets.winnerSayings.get(Utilities
				.genRandomNum(Assets.winnerSayings.size()));
	}

	@Override
	public void tick() {
		if (game.getKeyboardManager().enter)
			setState(getState("mainMenu"));

	}

	@Override
	public void render(Graphics2D g) {
		imageFade(g);
		game.getCamera().centerOnEntity(killerCard);
		killerCard.render(g);

		g.setColor(Utilities.rainbowFade());
		g.setFont(new Font("Consolas", Font.BOLD, 20));
		drawCenteredString(lostMessage, 800, 600, 525, g);
		drawCenteredString(killer.getName() + " was the killer!", 800, 600,
				545, g);
	}

}
