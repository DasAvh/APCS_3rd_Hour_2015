package states;

import graphics.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import utilities.Utilities;

public class MainMenuState extends State 
{
	/*
	 * Need Max Payne 1 Main theme when sound is implemented
	 */
	//Ids
	private static final int PLAY_GAME = 0;
	private static final int HOW_TO_PLAY = 1;
	private static final int SETTINGS = 2;
	private static final int EXIT_GAME = 3;

	
	public MainMenuState(Game game) 
	{
		super(game);
		
		//Setup text options
		titleText = "CLUE";
		textOptions = new ArrayList<String>();
		textOptions.add("Play Game");
		textOptions.add("How to Play");
		textOptions.add("Settings");
		textOptions.add("Exit Game");
		
		//Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(255, 0, 255);
		backDropColor = new Color(0, 0, 0, 155);
		
		//Defaults chosen text
		choosenText = 0;
		
		//Add to hashmap of states
		addState("mainMenu", this);
	}//End constructor
	
	@Override
	public void tick() 
	{
		navigateMenu();
		
		if(game.getKeyboardManager().enter && choosenText == PLAY_GAME)
			setState(State.getState("game"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == HOW_TO_PLAY)
			setState(State.getState("howToPlay"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == SETTINGS)
			setState(State.getState("gameOptions"));
		//End if
		
		
		
		if(game.getKeyboardManager().enter && choosenText == EXIT_GAME)
			System.exit(0);
		//End if
	}//End method tick

	@Override
	public void render(Graphics g) 
	{	
		//Sets background
		g.drawImage(Assets.mainMenuBackgroundImage, 0, 0, null);
		
		drawMenu(g);
	}

	
}//End class MainMenuState
