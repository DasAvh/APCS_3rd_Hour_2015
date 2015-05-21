package entity.chars;

import rooms.Room;
import runner.Game;
import tiles.DoorTile;
import tiles.Tile;
import board.Board;
import entity.Entity;

public abstract class Characters extends Entity 
{
	//Static fields
	public static final int CHARACTER_WIDTH = Tile.TILE_WIDTH;
	public static final int CHARACTER_HEIGHT = Tile.TILE_HEIGHT;
	public static final int SPEED = Tile.TILE_HEIGHT;
	
	//Protected fields
	protected int xMove, yMove;
	protected int[] lastX, lastY;
	protected int prevTurnX, prevTurnY;
	protected int amountOfMoves, amountOfUndos;
	protected boolean rolled;
	protected Room room;
	
	//Evidence Stuff
	protected String name, slogan;
	
	//Fields
	/*
	 * Weapon - Weapon assign to player
	 * Room   - Room assign to player
	 */
	
	public Characters(Game game, int x, int y, int width, int height, int id, String name, String slogan) 
	{
		//Entity constructor
		super(game, x, y, width, height, id);
		
		//Array used to record a character's last
		//positions. Ranges from 1 to 6
		lastX = new int[6];
		lastY = new int[6];
		
		//Character's movement speed
		//Defaults to 0
		xMove = 0;
		yMove = 0;
		
		//Sets boolean variables to false
		//Used to check if character has rolled
		//and if character is in a room
		room = null;
		rolled = false;

		this.name = name;
		this.slogan = slogan;
	}//End constructor
	
	public void move()
	{
		if(Board.hitObject(this, xMove, yMove))
		{
			//Moves Character by xMove and yMove
			x += xMove;
			y += yMove;

			//If Character did move, decrease amount of 
			//moves, store last position, and increase 
			//number of undos the Character has
			if(xMove != 0 || yMove != 0)
			{
				amountOfMoves--;
				amountOfUndos++;
				
				//Checks to see if its the Character's
				//last turn, if so do not record last
				//position. Prevents OutOfBounds error
				if(amountOfMoves != 0)
				{

					lastX[amountOfMoves - 1] = x;
					lastY[amountOfMoves - 1] = y;
				}//End if
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
	

	
	/* * * * * * * * * * *
	 *  Evidence methods *
	 * * * * * * * * * * */
	
	public String getName()
	{
		return name;
	}
	
	public String getSlogan()
	{
		return slogan;
	}
	
	//GETTER & SETTERS
	public int getLastMoveX()
	{
		return prevTurnX;
	}
	
	public int getLastMoveY()
	{
		return prevTurnY;
	}
	
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
