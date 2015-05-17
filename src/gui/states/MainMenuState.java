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
	
	//Fields
	private ArrayList<String> textOptions;
	private Color backDropColor, passiveTextColor, activeTextColor;
	private int choosenText, fontSize;
	private Font font, titleFont;
	
	public MainMenuState(Game game) 
	{
		super(game);
		
		//Setup text options
		textOptions = new ArrayList<String>();
		textOptions.add("Play Game");
		textOptions.add("How to Play");
		textOptions.add("Settings");
		textOptions.add("Exit Game");
		
		//Setup colors
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 255);
		backDropColor = new Color(0, 0, 0, 155);
		
		//Defaults chosen text
		choosenText = 0;
		
		//Font
		fontSize = 48;
		font = new Font("Consolas", Font.PLAIN, fontSize);
		titleFont = new Font("Consolas", Font.BOLD, 72);
		
		//Add to hashmap of states
		addState("mainMenu", this);
	}//End constructor
	
	@Override
	public void tick() 
	{
		if(game.getKeyboardManager().up && choosenText != 0)
			choosenText --;
		
		if(game.getKeyboardManager().down && choosenText != textOptions.size() - 1)
			choosenText ++;
		
		if(game.getKeyboardManager().enter && choosenText == PLAY_GAME)
			setState(State.getState("game"));
		//End if
		
		if(game.getKeyboardManager().enter && choosenText == EXIT_GAME)
			System.exit(0);
		//End if
	}//End method tick

	@Override
	public void render(Graphics g) 
	{
		//Formatting options
		int paddingHeight = 150;
		int paddingWidth = 100;
		int spaceing = 100;
		
		//Sets background
		g.drawImage(Assets.mainMenuBackgroundImage, 0, 0, null);
		
		//Title
		g.setColor(Utilities.genRandomColor());
		g.setFont(titleFont);
		g.drawString("CLUE", paddingWidth, 70);
		
		//Backdrop for menu
		g.setColor(backDropColor);
		g.fillRect(paddingWidth, paddingHeight - fontSize, fontSize * 7, spaceing * textOptions.size()); 
		
		//Text color and font
		g.setColor(passiveTextColor);
		g.setFont(font);
		
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
	}//End render method
	
}//End class MainMenuState
