package entity.chars;

import java.util.ArrayList;

import board.Board;
import runner.Game;
import states.GameState;
import states.State;
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
	protected int[] lastX, lastY;
	protected int amountOfMoves, amountOfUndos;
	protected boolean rolled;
	protected boolean inRoom;
	
	//Fields
	/*
	 * Weapon - Weapon assign to player
	 * Room- Room assign to player
	 */
	public Characters(Game game, int x, int y, int width, int height, int id) 
	{
		super(game, x, y, width, height, id);
		lastX = new int[6];
		lastY = new int[6];
		xMove = 0;
		yMove = 0;
		inRoom = false;
		rolled = false;
	}//End constructor
	
	public void move()
	{
		if(Board.hitObject(this, xMove, yMove))
		{
			//Moves Character
			x += xMove;
			y += yMove;

			//If moved decrease moves and store last position
			if(xMove != 0 || yMove != 0)
			{
				amountOfMoves--;
				amountOfUndos++;
				
				if(amountOfMoves != 0)
				{
					lastX[amountOfMoves - 1] = x;
					lastY[amountOfMoves - 1] = y;
				}//End if

			}//End if
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
	
	/* * * * * * * * *
	 *  Roll methods *
	 * * * * * * * * */
	public void setAmountOfMoves(int roll)
	{
		amountOfMoves = roll;
		amountOfUndos = 0;
		lastX[amountOfMoves - 1] = getX();
		lastY[amountOfMoves - 1] = getY();
		System.out.println(amountOfMoves + " " + amountOfUndos + " Index "+ (amountOfMoves - 1)+ " " +
				lastX[amountOfMoves - 1] + " " + lastY[amountOfMoves - 1]);
		rolled = true;
	}//End roll method
	
	public int getAmountOfMoves()
	{
		return amountOfMoves;
	}
	
	public boolean hasRolled()
	{
		return rolled;
	}//End hasRolled method
	
	public void resetRoll()
	{
		rolled = false;
	}//End resetRoll method
	
	public void undoMove()
	{
		if(amountOfUndos != 0)
		{
			setX(lastX[amountOfMoves]);
			setY(lastY[amountOfMoves]);
			amountOfMoves++;
			amountOfUndos--;
			System.out.println(amountOfMoves + " " + amountOfUndos);
		}//End if
	}//End method undoMove
	
	/* * * * * * * * *
	 *  Room methods *
	 * * * * * * * * */
	
	public void setInRoom()
	{
		inRoom = true;
	}//End method setInRoom
	
	public void setOutOfRoom()
	{
		inRoom = false;
	}//End method setOutOfInRoom
	
	public boolean isInRoom()
	{
		return inRoom;
	}//End method isInRoom
	
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
