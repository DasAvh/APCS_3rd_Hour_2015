package entity.chars;

import board.Board;
import runner.Game;
import tiles.Tile;
import entity.Entity;

public abstract class Characters extends Entity 
{
	public static final int CHARACTER_WIDTH = Tile.TILE_WIDTH;
	public static final int CHARACTER_HEIGHT = Tile.TILE_HEIGHT;
	public static final int SPEED = Tile.TILE_HEIGHT;
	
	protected int xMove, yMove;
	//Fields
	/*
	 * Weapon - Weapon assign to player
	 * Room- Room assign to player
	 */
	public Characters(Game game, int x, int y, int width, int height) 
	{
		super(game, x, y, width, height);
		xMove = 0;
		yMove = 0;
	}//End constructor
	
	public void move()
	{
		x += xMove;
		y += yMove;
	}//End move method
	
	//GETTER & SETTERS
	public float getxMove() {
		return xMove;
	}
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
}//End class Characters
