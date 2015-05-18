package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import runner.Game;
import utilities.Utilities;

public class DieRollState extends State
{
	//Fields
	private static final int DIE_SIZE = 300;
	private static final int ROLL_DURATION = 2;
	
	public DieRollState(Game game)
	{
		super(game);
		
		//Setup colors
		backDropColor = new Color(0, 0, 0, 155);
		passiveTextColor = new Color(255, 0, 0);
		activeTextColor = new Color(255, 255, 255);
		
		//TEMP - Setup text
		textOptions = new ArrayList<String>();
		textOptions.add("1");
		textOptions.add("2");
		textOptions.add("3");
		textOptions.add("4");
		textOptions.add("5");
		textOptions.add("6");
		
		choosenText = 0;
		
		addState("die", this);
	}//End constructor

	@Override
	public void tick() 
	{
		if(game.getKeyboardManager().enter)
		{
			for(int x = 0; x < ROLL_DURATION; x++)
			{
				choosenText = Utilities.diceRoll();
				render(game.getGraphics());
				try {
					Thread.sleep(x * ROLL_DURATION);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//End try-catch
			}//End for
			System.out.println("DONE");
			GameState.players.get(GameState.currentPlayer).setAmountOfMoves(choosenText + 1);
			setState(getState("game"));
		}//End if
	}//End tick method

	@Override
	public void render(Graphics g) 
	{
		//Maintains game state as a background
		getState("game").render(g);
		
		//Sets black overlay
		g.setColor(backDropColor);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		
		//Create die backdrop
		g.setColor(passiveTextColor);
		g.fillRect(250, 175, DIE_SIZE, DIE_SIZE);
		
		//Die number
		g.setFont(font);
		g.setColor(activeTextColor);
		g.drawString(textOptions.get(choosenText), 352, 350);
		
		g.dispose();
	}//End render method
}//End class DieRollState
