package entity;

import java.awt.Graphics;

import runner.Game;

public abstract class Entity
{
	protected Game game;
	protected int x, y;
	protected int width, height;
	
	public Entity(Game game, int x, int y, int width, int height)
	{
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}//End constructor
	
	public abstract void tick();
	public abstract void render(Graphics g);

	//Getters & Setters
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
}//End class Entity
