package cards;

import java.awt.Color;
import java.awt.Graphics;

import runner.Game;
import entity.chars.Player;
import graphics.Assets;

public class PlayerCard extends Card
{

	public PlayerCard(Game game, int x, int y, int width, int height, int id, String name, String slogan, String interSlogan) 
	{
		super(game, x, y, width, height, id);
		this.name = name;
		this.slogan = slogan;
		this.interSlogan = interSlogan;
		texture = Assets.playerCardImages.get(id);
	}//End PlayerCard class
	
	public void render(Graphics g) 
	{
		if(choosen)
		{
			g.drawImage(texture, (int)(getX() - game.getCamera().getxOffset()), (int)(getY() - game.getCamera().getyOffset()), CARD_WIDTH, CARD_HEIGHT, null);
			g.setColor(new Color(55,55,55,155));
			g.fillRect((int)(getX() - game.getCamera().getxOffset()), (int)(getY() - game.getCamera().getyOffset()), CARD_WIDTH, CARD_HEIGHT);
		}else
		{
			g.drawImage(texture, (int)(getX() - game.getCamera().getxOffset()), (int)(getY() - game.getCamera().getyOffset()), CARD_WIDTH, CARD_HEIGHT, null);
		}
	}
	
	public PlayerCard getCard()
	{
		return this;
	}
	
	public String toString()
	{
		return getName();
	}
	
	public Object equal(Object other)
	{
		return getName().equals(((PlayerCard)(other)).getName()); 
	}
}///End PlayerCard class
