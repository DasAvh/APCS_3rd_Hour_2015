package states;

import graphics.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;

public class HowToPlayState extends State
{
	//Ids
	private static final int RETURN = 1;
	
	/*
	 * Message is not yet implemented
	 */
	
	//Fields
	private String instructions;
	private Font messageFont;
	private static final int messageFontSize = 24;
	
	public HowToPlayState(Game game) 
	{
		super(game);
		
		//Text options
		titleText = "HOW TO PLAY";
		textOptions = new ArrayList<String>();
		textOptions.add("Jesse did it");
		textOptions.add("Return");
		
		//How to play message
		instructions = "Jesse did it";
		
		//Message settings
		messageFont = new Font("Impact", Font.BOLD, messageFontSize);
		
		//Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 255);
		backDropColor = new Color(0, 0, 0, 155);
		
		//Defaults chosen text
		choosenText = 0;
		
		addState("howToPlay", this);
	}//End constructor

	@Override
	public void tick() 
	{
		navigateMenu();
		if(game.getKeyboardManager().enter && choosenText == RETURN)
			setState(State.getState("mainMenu"));
		//End if
	}//End tick method

	@Override
	public void render(Graphics g) 
	{
		//Sets background
		g.drawImage(Assets.mainMenuBackgroundImage, 0, 0, null);
		
		drawMenu(g);
	}//End render method

}//End class HowToPlayState
