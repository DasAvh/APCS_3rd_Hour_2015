package states;

import graphics.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessOrder;

import display.Display;
import runner.Game;
import utilities.SoundBoard;
import utilities.Utilities;

public class MainMenuState extends State 
{
	//Fields
	private final int HEIGHT, WIDTH;
	private Color fade;
	private int speed, ticks, index, x, y, xMove, yMove;
	/*
	 * Need new wav
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
		
		//Images
		HEIGHT = game.getHeight();
		WIDTH  = game.getWidth();
		speed = 1;
		fade = new Color(0,0,0,0);
		ticks = 0;
		index = Utilities.genRandomNum(Assets.mainMenuImages.size());
		//Add to hashmap of states
		addState("mainMenu", this);
	}//End constructor
	
	@Override
	public void tick() 
	{
		navigateMenu();
		
		if(game.getKeyboardManager().enter && choosenText == PLAY_GAME)
			setState(State.getState("die"));
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
		
		drawMenu(g);
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
		index = Utilities.genNonRepeatRandomNum(Assets.mainMenuImages.size());
	}
	
	private void setDirection()
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
		}//End if
	}//End setDirection method
	
	@Override
	public void startup() 
	{
		SoundBoard.playSoundWithLoop(SoundBoard.mainMenu, 100);
		setDirection();
	}//End startup method

}//End class MainMenuState
