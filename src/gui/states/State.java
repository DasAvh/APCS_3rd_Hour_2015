package states;

import java.awt.Graphics;

import runner.Game;

public abstract class State 
{
	private static State currentState = null;
	protected Game game;
	
	public State(Game game)
	{
		this.game = game;
	}//End constructor
	
	public static void setState(State state)
	{
		currentState = state;
	}//End setState method
	
	public static State getState()
	{
		return currentState;
	}//End getState method
	

	public abstract void tick();
	public abstract void render(Graphics g);
}//End abstract class State
