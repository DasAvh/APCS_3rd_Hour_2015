package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import sound.SoundBoard;
import tiles.Tile;
import utilities.Utilities;
import board.Board;
import entity.chars.Player;

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
			choosenText = Utilities.diceRoll();
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
		//g.setColor(passiveTextColor);
		//g.fillRect(250, 175, DIE_SIZE, DIE_SIZE);
		
		//Die number
		g.setFont(hugeFont);
		g.setColor(Utilities.genRandomColor());
		g.drawString("ROLL", game.getWidth() / 2 - hugeFontSize, game.getHeight() / 2 + 75);
		
		g.dispose();
	}//End render method

	@Override
	public void startup() 
	{	
		if(SoundBoard.isSoundPlaying())
			SoundBoard.stopSound();
		
		if(game.newGame())
		{
			for(int x = 0; x < 6; x++)
			{
				GameState.players.add(new Player(game, Board.getBoard().getSpawnX()[x] * Tile.TILE_WIDTH, Board.getBoard().getSpawnY()[x] * Tile.TILE_HEIGHT, ChoosePlayersState.choosenCards.get(x).getId(),
						ChoosePlayersState.choosenCards.get(x).getName(),ChoosePlayersState.choosenCards.get(x).getSlogan()));
				
			}//End for
		}
	}
}//End class DieRollState
