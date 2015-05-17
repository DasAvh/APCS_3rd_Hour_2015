package entity.chars;

import java.util.ArrayList;

import board.Board;
import runner.Game;
import states.GameState;
import tiles.DoorTile;
import tiles.Tile;
import utilities.Utilities;
import entity.Entity;

public abstract class Characters extends Entity 
{
	public static final int CHARACTER_WIDTH = Tile.TILE_WIDTH;
	public static final int CHARACTER_HEIGHT = Tile.TILE_HEIGHT;
	public static final int SPEED = Tile.TILE_HEIGHT;
	
	protected int xMove, yMove;
	protected ArrayList<Integer> lastPosition;
	protected int amountOfMoves;
	protected boolean inRoom;
	
	//Fields
	/*
	 * Weapon - Weapon assign to player
	 * Room- Room assign to player
	 */
	public Characters(Game game, int x, int y, int width, int height, int id) 
	{
		super(game, x, y, width, height, id);
		xMove = 0;
		yMove = 0;
		inRoom = false;
	}//End constructor
	
	public void move()
	{
		if(Board.hitObject(this, xMove, yMove))
		{
			x += xMove;
			y += yMove;	
		}//End if
		
		if(Board.hitDoor(this))
		{
			if(!isInRoom())
				DoorTile.movePlayerIntoRoom(this);
			else if(isInRoom())
			{
				DoorTile.movePlayerOutOfRoom(this);
				setOutOfRoom();
			}//End if
			
		}//End if
	}//End move method
	
	public void roll()
	{
		amountOfMoves = Utilities.diceRoll();
	}//End roll method
	

	public void undoMove()
	{
		
	}
	
	public void setInRoom()
	{
		inRoom = true;
	}
	
	public void setOutOfRoom()
	{
		inRoom = false;
	}
	
	public boolean isInRoom()
	{
		return inRoom;
	}
	
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
