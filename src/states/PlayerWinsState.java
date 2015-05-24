package states;

import java.awt.Graphics;

import runner.Game;
import utilities.Utilities;

public class PlayerWinsState extends State 
{
	private String message;
	public PlayerWinsState(Game game)
	{
		super(game);
	
		addState("playerWins", this);
	}

	@Override
	public void startup() 
	{
		message = GameState.players.get(GameState.currentPlayer).getName();
		game.endGame();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(game.getKeyboardManager().enter)
		{
			System.exit(1);
		//	setState(getState("mainMenu"));
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Utilities.genRandomColor());
		g.setFont(font);
		g.drawString(message, WIDTH/2 - fontSize, HEIGHT/2 - fontSize);
	}

}
