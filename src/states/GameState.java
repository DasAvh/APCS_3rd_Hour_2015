package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import rooms.Room;
import runner.Game;
import weapons.Weapon;
import board.Board;
import cards.Card;
import entity.chars.Player;
import evidence.Watson;

public class GameState extends State 
{
	//Fields
	private Board board;
	private static Watson watson;
	
	//Players
	public static ArrayList<Player> players;
	public static int currentPlayer;
	
	//Spaces
	
	public GameState(Game game)
	{
		super(game);
		
		board = Board.getBoard();
		players = new ArrayList<Player>();
		
		backDropColor = new Color(0, 0, 0, 155);
		passiveTextColor = new Color(255, 0, 0);
		activeTextColor = new Color(255, 255, 255);
		
		currentPlayer = 0;
		
		addState("game", this);
	}//End constructor
	
	@Override
	public void tick() 
	{
		board.tick();
		
		if(!players.get(currentPlayer).hasRolled())
		{
			setState(getState("die"));
			return;
		}
		
		if(players.get(currentPlayer).getAmountOfMoves() == 0)
		{
			players.get(currentPlayer).resetRoll();
			if(currentPlayer != players.size() - 1)
				currentPlayer++;
			else 
				currentPlayer = 0;
		}
		
		//Exit game
		if(game.getKeyboardManager().escape)
			State.setState(getState("pause"));
		
		
		//Allows only the currentPlayer to move
		players.get(currentPlayer).tick();
	}//End method tick

	@Override
	public void render(Graphics g) 
	{
		//Renders board
		board.render(g);
		
		//Renders players
		for(Player p : players)
			p.render(g);
		
		g.setColor(backDropColor);
		g.fillRect(10, 10, 200, 50);
		g.setColor(activeTextColor);
		g.setFont(font);
		g.drawString("Moves " + players.get(currentPlayer).getAmountOfMoves(), 20, font.getSize());
	}//End method render
	
	public static Player activePlayer()
	{
		return players.get(currentPlayer);
	}//End method getActivePlayer
	
	public static void nextPlayer()
	{
		if(currentPlayer == 5)
			currentPlayer = 0;
		else
			currentPlayer++;
		//End if
	}//End method nextPlayer

	public static Watson getWatson()
	{
		return watson;
	}
	
	@Override
	public void startup() 
	{
		// TODO Auto-generated method stub
		if(game.newGame())
		{
			watson = new Watson(players, Weapon.weapons, Room.rooms2);
			Card.reset();
			game.gameStarted();
		}
	}
}//End GameState class
