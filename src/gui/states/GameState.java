package states;

import java.awt.Graphics;

import runner.Game;
import tiles.Tile;
import board.Board;
import entity.chars.Player;

public class GameState extends State 
{
	//Fields
	private Player player;
	private Board board;
	
	public GameState(Game game)
	{
		super(game);
		board = new Board(game, "res/boards/TestBoard.txt");
		player = new Player(game, board.getSpawnX()[0] * Tile.TILE_WIDTH, board.getSpawnY()[0] * Tile.TILE_HEIGHT, 1);
	}//End constructor
	
	@Override
	public void tick() 
	{
		board.tick();
		player.tick();
	}//End method tick

	@Override
	public void render(Graphics g) 
	{
		board.render(g);
		player.render(g);
	
	}//End method render
}//End GameState class
