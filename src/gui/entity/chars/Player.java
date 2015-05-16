package entity.chars;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import board.Board;
import runner.Game;
import tiles.Tile;

public class Player extends Characters 
{
	private BufferedImage texture;
	private int id;
	
	public Player(Game game, int x, int y, int id) 
	{
		super(game, x, y, Characters.CHARACTER_WIDTH, Characters.CHARACTER_HEIGHT);
		this.id = id;
		
		switch (id) { 
		case 1:texture = Assets.playerOne;break;
		case 2:texture = Assets.playerTwo;break;
		case 3:texture = Assets.playerThree;break;
		case 4:texture = Assets.playerFour;break;
		case 5:texture = Assets.playerFive;break;
		case 6:texture = Assets.playerSix;break;
		default:texture = Assets.missing;break;
		}
	}//End constructor

	@Override
	public void tick()
	{
		getUserInput();
		move();
		game.getCamera().centerOnEntity(this);
	}//End tick method

	private void getUserInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyboardManager().up && Board.hitWall(this, 0,-Tile.TILE_HEIGHT))
			yMove = -SPEED;
		
		if(game.getKeyboardManager().down && Board.hitWall(this,0,Tile.TILE_HEIGHT))
			yMove = SPEED;
		
		if(game.getKeyboardManager().left && Board.hitWall(this, -Tile.TILE_WIDTH,0))
			xMove = -SPEED;
		
		if(game.getKeyboardManager().right && Board.hitWall(this, Tile.TILE_WIDTH,0))
			xMove = SPEED;
	}//End getUserInput method
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, (int)(x - game.getCamera().getxOffset()), (int)(y - game.getCamera().getyOffset()), width, height, null);
	}//End render method
}//End class Player
