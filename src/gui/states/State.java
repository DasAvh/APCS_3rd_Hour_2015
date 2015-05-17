package states;

import java.awt.Graphics;
import java.util.HashMap;

import runner.Game;

public abstract class State 
{
	private static HashMap<String, State> states = new HashMap<String, State>();
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
	
	public static State getState(String id)
	{
		return states.get(id);
	}//End method getState
	
	public static void addState(String id, State state)
	{
		states.put(id, state);
	}//End method addState

	public abstract void tick();
	public abstract void render(Graphics g);
}//End abstract class State
