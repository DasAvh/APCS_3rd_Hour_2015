package entity.chars;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import board.Board;
import rooms.Room;
import runner.Game;
import states.GameState;
import states.State;
import tiles.Tile;
import utilities.Utilities;

public class Player extends Characters 
{
	private BufferedImage texture;

	public Player(Game game, int x, int y, int id) 
	{
		super(game, x, y, Characters.CHARACTER_WIDTH, Characters.CHARACTER_HEIGHT, id);
		
		//Sets Player texture
		switch (id) 
		{ 
			case 1:texture = Assets.playerOne;break;
			case 2:texture = Assets.playerTwo;break;
			case 3:texture = Assets.playerThree;break;
			case 4:texture = Assets.playerFour;break;
			case 5:texture = Assets.playerFive;break;
			case 6:texture = Assets.playerSix;break;
			default:texture = Assets.missing;break;
		}//End switch 
	}//End constructor

	@Override
	public void tick()
	{
		//Gets user input
		getUserInput();
		move();

		//Centers camera on player
		game.getCamera().centerOnEntity(GameState.activePlayer());
		
		//Collision check for rooms
		int roomNum = Board.hitRoom(this);
		
		if(roomNum != 0 && !inRoom)
		{
			if(!Room.rooms[roomNum].isFull())
			{
				setInRoom();
				Room.rooms[roomNum].setPlayerInRoom(this);
				State.setState(State.getState("playerOptions"));
			}else
			{
				System.out.println("FULL");
			}
			
		}//End if
	}//End tick method

	private void getUserInput()
	{
		xMove = 0;
		yMove = 0;
		
	//	System.out.println(getAmountOfMoves());
		
		if(game.getKeyboardManager().u)
			undoMove();
		
		if(game.getKeyboardManager().up && Board.hitObject(this, xMove, yMove))
		{
			yMove = -SPEED;
		}
		if(game.getKeyboardManager().down)
		{
			yMove = SPEED;
		}
		if(game.getKeyboardManager().left)
		{
			xMove = -SPEED;

		}
		if(game.getKeyboardManager().right)
		{
			xMove = SPEED;
		}
	}//End getUserInput method

	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, (int)(x - game.getCamera().getxOffset()), (int)(y - game.getCamera().getyOffset()), width, height, null);
	}//End render method
}//End class Player
