package states;

import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import tiles.Tile;
import board.Board;
import entity.Entity;
import entity.chars.Player;

public class GameState extends State 
{
	//Fields
	private Player player;
	private Board board;
	
	//Players
	public static ArrayList<Player> players;
	public static int currentPlayer;
	
	public GameState(Game game)
	{
		super(game);
		board = new Board(game, "res/boards/TestBoard.txt");
		players = new ArrayList<Player>();
		
		for(int x = 0; x < 6; x++)
			players.add(new Player(game, board.getSpawnX()[x] * Tile.TILE_WIDTH, board.getSpawnY()[x] * Tile.TILE_HEIGHT, x + 1)); 

		currentPlayer = 0;
		//player = new Player(game, board.getSpawnX()[0] * Tile.TILE_WIDTH, board.getSpawnY()[0] * Tile.TILE_HEIGHT, 1);
	}//End constructor
	
	@Override
	public void tick() 
	{
		board.tick();
		
		if(game.getKeyboardManager().leftArrow && currentPlayer != 0)
			currentPlayer--;
		else if(game.getKeyboardManager().rightArrow && currentPlayer != 5)
			currentPlayer++;
		
		players.get(currentPlayer).tick();
	}//End method tick

	@Override
	public void render(Graphics g) 
	{
		board.render(g);
		
		//Renders players
		for(Player p : players)
			p.render(g);
	}//End method render
	
	public static Player activePlayer()
	{
		return players.get(currentPlayer);
	}
}//End GameState class
