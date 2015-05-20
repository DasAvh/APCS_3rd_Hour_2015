package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;

public class PauseGameState extends State 
{
	//Ids
	private static final int RESUME_GAME = 0;
	private static final int CARDS = 1;
	private static final int SETTINGS = 2;
	private static final int EXIT_TO_MENU = 3;
	

	public PauseGameState(Game game) 
	{
		super(game);
		
		//Text options
		textOptions = new ArrayList<String>();
		textOptions.add("Resume");
		textOptions.add("Cards");
		textOptions.add("Settings");
		textOptions.add("Exit to Menu");
		
		//Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(255, 0, 255);
		backDropColor = new Color(0, 0, 0, 155);
		
		//Defaults chosen text
		choosenText = 0;
		
		addState("pause", this);
	}

	@Override
	public void tick() 
	{
		navigateMenu();
		
		if(game.getKeyboardManager().enter && choosenText == RESUME_GAME)
			setState(State.getState("game"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == CARDS)
			setState(State.getState("howToPlay"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == SETTINGS)
			setState(State.getState("gameOptions"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == EXIT_TO_MENU)
			setState(State.getState("mainMenu"));
		//End if
		
	}

	@Override
	public void render(Graphics g) 
	{
		//Formatting options
		int paddingHeight = 150;
		int paddingWidth = 100;
		int spaceing = 100;
		
		//Maintains game state as a background
		getState("game").render(g);
		
		//Sets black overlay
		g.setColor(backDropColor);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		
		//Draw text
		g.setColor(passiveTextColor);
		g.setFont(font);
		
		//Draw menu
		for(int x = 0; x < textOptions.size(); x++)
		{
			if(choosenText == x)
			{
				g.setColor(activeTextColor);
				g.drawString(textOptions.get(x), paddingWidth, paddingHeight + (spaceing * x));
				g.setColor(passiveTextColor);
			} else
			{
				g.drawString(textOptions.get(x), paddingWidth, paddingHeight + (spaceing * x));
			}//End if
		}//End for
		
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}

}//End class PauseGameState
