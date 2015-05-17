package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;

public class PlayerOptionsState extends State 
{
	//Fields
	private ArrayList<String> textOptions;
	private Color overlayColor, passiveTextColor, activeTextColor;
	private int choosenText, fontSize; //This is how chosen is spelled now
	private Font font;
	
	public PlayerOptionsState(Game game) 
	{
		super(game);
		
		//Setup text options
		textOptions = new ArrayList<String>();
		textOptions.add("1");
		textOptions.add("Suggest");
		textOptions.add("3");
		textOptions.add("End turn");
		
		//Setup colors
		overlayColor = new Color(0, 0, 0, 155);
		passiveTextColor = new Color(255, 255, 255);
		activeTextColor = new Color(0, 255, 0);
		
		//Defaults chosen text to one
		choosenText = 0;
		
		//Font
		fontSize = 48;
		font = new Font("Consolas", Font.PLAIN, fontSize);
		
		//Add to hashmap of states
		addState("playerOptions", this);
	}//End constructor

	@Override
	public void tick() 
	{
		if(game.getKeyboardManager().up && choosenText != 0)
			choosenText --;
		
		if(game.getKeyboardManager().down && choosenText != textOptions.size() - 1)
			choosenText ++;
		
		if(game.getKeyboardManager().enter && choosenText == 3)
		{
			setState(State.getState("game"));
			GameState.nextPlayer();
			choosenText = 0;
		}//End if
	}//End tick method

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
		g.setColor(overlayColor);
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
	}//End render method

}//End class PlayerOptionsState
