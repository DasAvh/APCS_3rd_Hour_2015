package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import runner.Game;
import utilities.Utilities;


public abstract class State 
{
	private static HashMap<String, State> states = new HashMap<String, State>();
	private static State currentState = null;
	private static State lastState = null;
	protected Game game;
	
	//Fields
	protected ArrayList<String> textOptions;
	protected String titleText;
	protected Color backDropColor, passiveTextColor, activeTextColor;
	protected int choosenText;
	protected static final int fontSize = 48, titleFontSize = 72, hugeFontSize = 200;
	protected static final Font font = new Font("Consolas", Font.PLAIN, fontSize),
								titleFont = new Font("Consolas", Font.BOLD, titleFontSize),
								hugeFont = new Font("Consolas", Font.BOLD, hugeFontSize);		
	
	
	public State(Game game)
	{
		this.game = game;
	}//End constructor
	
	public static void setState(State state)
	{
		lastState = currentState;
		currentState = state;
		currentState.startup();
	}//End setState method
	
	public static State getState()
	{
		return currentState;
	}//End getState method
	
	public static State getState(String id)
	{
		return states.get(id);
	}//End method getState
	
	public static void addState(String id, State state)
	{
		states.put(id, state);
	}//End method addState

	public static State getPrevState()
	{
		return lastState;
	}//End lastState method
	
	//Abstract methods
	public abstract void startup();
	public abstract void tick();
	public abstract void render(Graphics g);
	
	protected void navigateMenu()
	{
		if(game.getKeyboardManager().up && choosenText != 0)
			choosenText --;
		
		if(game.getKeyboardManager().down && choosenText != textOptions.size() - 1)
			choosenText ++;
	}//End naviagteMenu method
	
	protected void drawMenu(Graphics g)
	{
		//Formatting options
		int paddingHeight = 150;
		int paddingWidth = 100;
		int spaceing = 100;
		
		//Title
		g.setColor(Utilities.genRandomColor());
		g.setFont(titleFont);
		g.drawString(titleText, paddingWidth, 70);
		
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
	
	
}//End abstract class State
