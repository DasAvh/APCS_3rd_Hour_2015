package states;

import graphics.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import utilities.Utilities;

public class GameOptionsState extends State
{
	//Ids
	private static final int RETURN = 1;
	
	public GameOptionsState(Game game) 
	{
		super(game);
		
		//Setup text options
		titleText = "SETTINGS";
		textOptions = new ArrayList<String>();
		textOptions.add("Idk");
		textOptions.add("Return");
		
		//Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 255);
		backDropColor = new Color(0, 0, 0, 155);
		
		addState("gameOptions", this);
	}//End constructor

	@Override
	public void tick()
	{
		navigateMenu();
		
		if(game.getKeyboardManager().enter && choosenText == RETURN)
			setState(State.getState("mainMenu"));
	}//End method tick

	@Override
	public void render(Graphics g) 
	{	
		//Sets background
		g.drawImage(Assets.mainMenuBackgroundImage, 0, 0, null);
		
		drawMenu(g);
	}//End render method
}//End class GameOptionsState
