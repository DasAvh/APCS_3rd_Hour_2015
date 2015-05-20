package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import tiles.Tile;
import board.Board;
import entity.chars.Player;

public class GameState extends State 
{
	//Fields
	private Board board;
	
	//Players
	public static ArrayList<Player> players;
	public static int currentPlayer;
	
	//Spaces
	
	public GameState(Game game)
	{
		super(game);
		board = new Board(game, "res/boards/TestBoardMap.txt", "res/boards/TestBoardData.txt");
		players = new ArrayList<Player>();
		
		backDropColor = new Color(0, 0, 0, 155);
		passiveTextColor = new Color(255, 0, 0);
		activeTextColor = new Color(255, 255, 255);
		
		for(int x = 0; x < 6; x++)
		{
			players.add(new Player(game, board.getSpawnX()[x] * Tile.TILE_WIDTH, board.getSpawnY()[x] * Tile.TILE_HEIGHT, x + 1));
			
		}//End for
		
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

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}
}//End GameState class
