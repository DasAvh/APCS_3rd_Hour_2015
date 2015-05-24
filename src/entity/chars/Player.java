package entity.chars;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rooms.Door;
import rooms.Room;
import runner.Game;
import states.GameState;
import states.PlayerOptionsState;
import states.State;
import utilities.Utilities;
import board.Board;
import cards.Card;
import cards.PlayerCard;

public class Player extends Characters 
{
	private BufferedImage texture;
	private Card[] cards;
	private boolean hasLost;
	
	public Player(Game game, int x, int y, int id, String name, String slogan) 
	{
		super(game, x, y, Characters.CHARACTER_WIDTH, Characters.CHARACTER_HEIGHT, id, name, slogan);
		cards = new Card[6];
		hasLost = false;
		//Sets Player texture
		texture = Assets.playerImages.get(Utilities.genRandomNum(Assets.playerImages.size() ));
	}//End constructor

	@Override
	public void tick()
	{
		//Gets user input
		getUserInput();
		move();
		
		//Centers camera on player
		game.getCamera().centerOnEntity(GameState.activePlayer());
		
		//Checks if player hit door
		int doorNum = Board.hitDoor(this);
		
		if(!isInRoom() && doorNum != 0)
		{
			Room room = Door.doors[doorNum].getAssignRoom();
			if(!room.isFull())
			{
				setInRoom(room);
				PlayerOptionsState.setRoom(room);
				resetRoll();
				State.setState(State.getState("playerOptions"));
			}else
			{
				undoMove();
				System.out.println("FULL");
			}//End if
		}
		//End if
	}//End tick method

	private void getUserInput()
	{
		//Set movement to 0, to prevent
		//player from going forever in 
		//one direction
		xMove = 0;
		yMove = 0;
		
		//If player is in a room and mover, get that player outside the door
		if(isInRoom())
		{
			setOutOfRoom();
		}else
		{	
			if(game.getKeyboardManager().u)
				undoMove();
			
			if(game.getKeyboardManager().up && Board.hitObject(this, xMove, yMove))
				yMove = -SPEED;
			
			if(game.getKeyboardManager().down)
				yMove = SPEED;
			
			if(game.getKeyboardManager().left)
				xMove = -SPEED;
	
			if(game.getKeyboardManager().right)
				xMove = SPEED;
		}//End if
		
		if(xMove != 0 || yMove != 0)
		{
			prevTurnX = x;
			prevTurnY = y;
			System.out.println(prevTurnX + " " + prevTurnY);
		}
	}//End getUserInput method

	public void setInRoom(Room room)
	{
		this.room = room;
		room.setPlayerInRoom(this);
	}//End method setInRoom
	
	public void setOutOfRoom()
	{
		room.setPlayerOutOfRoom(this);
		room = null;
	}//End method setOutOfInRoom
	
	public boolean isInRoom()
	{
		return room != null;
	}//End method isInRoom
	
	public Room getRoom()
	{
		return room;
	}
	
	public void giveCards(Card[] cards)
	{
		this.cards = cards;
	}
	
	public Card[] getCards()
	{
		return cards;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void playerLost()
	{
		hasLost = true;
		GameState.aPlayerLost();
	}
	
	public boolean hasPlayerLost()
	{
		return hasLost;
	}
	public String toString()
	{
		return name;
	}
	
	
	public boolean equals(Object other)
	{
		if(other instanceof PlayerCard)
			return getName().equals(((PlayerCard)(other)).getName());
		else
			return getName().equals(((Player)(other)).getName());
	}
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, (int)(x - game.getCamera().getxOffset()), (int)(y - game.getCamera().getyOffset()), width, height, null);
	}//End render method
}//End class Player
