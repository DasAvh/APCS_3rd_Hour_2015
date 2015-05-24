package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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

		addState("playersLost", this);
	}

	@Override
	public void startup() {
		killer = Watson.getKiller();
		killerCard = Card.playerCards.get(killer.getId());
		lostMessage = Assets.winnerSayings.get(Utilities
				.genRandomNum(Assets.winnerSayings.size()));
	}

	@Override
	public void tick() {
		if (game.getKeyboardManager().enter)
			System.exit(1);

	}

	@Override
	public void render(Graphics g) {
		imageFade(g);
		game.getCamera().centerOnEntity(killerCard);
		killerCard.render(g);

		g.setColor(Color.CYAN);
		g.setFont(new Font("Consolas", Font.BOLD, 20));
		drawCenteredString(lostMessage, 800, 600, 525, g);
		drawCenteredString(killer.getName() + " was the killer!", 800, 600, 545, g);
	}

}
