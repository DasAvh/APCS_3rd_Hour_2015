package entity.chars;

import graphics.Assets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import rooms.Door;
import rooms.Room;
import runner.Game;
import states.GameState;
import states.PlayerOptionsState;
import states.State;
import board.Board;
import cards.Card;
import cards.PlayerCard;

public class Player extends Characters {
	private BufferedImage[] textures;
	private BufferedImage textureToDraw, prevTexture;
	private Card[] cards;
	private boolean hasLost;
	
	
	public Player(Game game, int x, int y, int id, String name, String slogan, int playerSkin) {
		super(game, x, y, Characters.CHARACTER_WIDTH,
				Characters.CHARACTER_HEIGHT, id, name, slogan);
		cards = new Card[6];
		hasLost = false;
		// Sets Player texture

		switch (playerSkin) {
		case 0:
			textures = Assets.playerOneImages;
			break;
		case 1:
			textures = Assets.playerTwoImages;
			break;
		case 2:
			textures = Assets.playerThreeImages;
			break;
		case 3:
			textures = Assets.playerFourImages;
			break;
		case 4:
			textures = Assets.playerFiveImages;
			break;
		case 5:
			textures = Assets.playerSixImages;
			break;
		default:
			break;
		}

		if (playerSkin > 3)
			textureToDraw = textures[0];
		else
			textureToDraw = textures[2];

		prevTexture = textureToDraw;
	}// End constructor

	@Override
	public void tick() {
		// Gets user input
		getUserInput();
		move();

		// Centers camera on player
		game.getCamera().centerOnEntity(GameState.activePlayer());

		// Checks if player hit door
		int doorNum = Board.hitDoor(this);
		
		if (!isInRoom() && doorNum != 0) {
			Room room = Door.doors[doorNum].getAssignRoom();
			if (!room.isFull()) {

				setInRoom(room);
				PlayerOptionsState.setRoom(room);
				resetRoll();
				State.setState(State.getState("playerOptions"));
			} else {
				undoMove();
				System.out.println("FULL");
			}// End if
		}// End if
			// End if
	}// End tick method

	private void getUserInput() {
		// Set movement to 0, to prevent
		// player from going forever in
		// one direction
		xMove = 0;
		yMove = 0;

		// If player is in a room and mover, get that player outside the door
		if (isInRoom()) {
			setOutOfRoom();
		} else {
			if (game.getKeyboardManager().u) {
				undoMove();
				textureToDraw = prevTexture;
			}
			
			if (game.getKeyboardManager().up) {
				yMove = -SPEED;
				textureToDraw = textures[0];
			}

			if (game.getKeyboardManager().down) {
				yMove = SPEED;
				textureToDraw = textures[2];
			}
			if (game.getKeyboardManager().left) {
				xMove = -SPEED;
				textureToDraw = textures[3];
			}
			if (game.getKeyboardManager().right) {
				xMove = SPEED;
				textureToDraw = textures[1];
			}
			
			if (xMove != 0 || yMove != 0) {
				prevTurnX = x;
				prevTurnY = y;
			}
		}// End if
	}// End getUserInput method

	@Override
	public void render(Graphics2D g) {
		g.drawImage(textureToDraw, (int) (x - game.getCamera().getxOffset()),
				(int) (y - game.getCamera().getyOffset()), width, height, null);
	}// End render method

	public void setInRoom(Room room) {
		this.room = room;
		room.setPlayerInRoom(this);
	}// End method setInRoom

	public void setOutOfRoom() {
		room.setPlayerOutOfRoom(this);
		room = null;
	}// End method setOutOfInRoom

	public boolean isInRoom() {
		return room != null;
	}// End method isInRoom

	public Room getRoom() {
		return room;
	}// End getRoom method

	public void giveCards(Card[] cards) {
		this.cards = cards;
	}// End giveCards method

	public Card[] getCards() {
		return cards;
	}// End getCards method

	public String getName() {
		return name;
	}// End getName method

	public void playerLost() {
		hasLost = true;
		GameState.aPlayerLost();
	}// End playerLost method

	public boolean hasPlayerLost() {
		return hasLost;
	}// End hasPlayerLost method

	public String toString() {
		return name;
	}// End toString method

	public boolean equals(Object other) {
		if (other instanceof PlayerCard)
			return getName().equals(((PlayerCard) (other)).getName());
		else
			return getName().equals(((Player) (other)).getName());
	}// End equals method
}// End class Player
