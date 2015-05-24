package states;

import graphics.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
	protected static int HEIGHT, WIDTH;
	protected static Color fade;
	protected static int speed, ticks, index, x, y, xMove, yMove;
	
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
	
	////////FADING\\\\\\\\\

	public void imageFade(Graphics g) 
	{	
		//Sets background
	//	g.drawImage(Assets.mainMenuImages.get(index), 0, 0, 800, 600, null);
		translateImage(g);
		g.setColor(fade);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		darken();

		
		if(ticks == 2)
		{
			x = 0;
			y = 0;
			switchImages();
			setDirection();
			ticks = 0;
		}
	}//End render method

	private void darken()
	{
		if(fade.getAlpha() == 255)
		{
			speed = -1;
			ticks++;
		}
		else if(fade.getAlpha() == 0)
		{
			speed = 1;
			ticks++;
		}//End if
		
		fade = new Color(0,0,0, fade.getAlpha() + speed);
	}//End darken method
	
	private void translateImage(Graphics g)
	{
		g.drawImage(Assets.mainMenuImages.get(index), x, y, 1400, 1200, null);
		x += xMove;
		y += yMove;
	}
	
	private void switchImages()
	{
		index = Utilities.genRandomNum(Assets.mainMenuImages.size());
	}
	
	protected void setDirection()
	{
		int temp = Utilities.genRandomNum(4);
		
		if(temp == 0)
		{
			System.out.println("ZERO");
			x = -600;
			y = -600;
			xMove = 1;
			yMove = 1;
		}else if(temp == 1)
		{
			System.out.println("ONE");
			x = -600  ;
			y = 0 ;
			xMove = 1;
			yMove = -1;
		}else if(temp == 2)
		{
			System.out.println("TWO");
			x = 0;
			y = -600;
			xMove = -1;
			yMove = 1;
		}else if(temp == 3)
		{
			System.out.println("THREE");
			x = 0;
			y = 0;
			xMove = -1;
			yMove = -1;
		}

	}
	
	
	  protected void drawCenteredString(String s, int w, int h, int y, Graphics g) 
	  {
			FontMetrics fm = g.getFontMetrics();
			int x = (w - fm.stringWidth(s)) / 2;
			g.drawString(s, x, y);
	  }
}//End abstract class State
