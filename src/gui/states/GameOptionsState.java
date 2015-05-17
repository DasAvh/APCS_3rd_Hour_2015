package states;

import java.awt.Graphics;

import runner.Game;

public class GameOptionsState extends State
{

	public GameOptionsState(Game game) 
	{
		super(game);
		
		addState("gameOptions", this);
	}//End constructor

	@Override
	public void tick()
	{
		
	}//End method tick

	@Override
	public void render(Graphics g) 
	{
		
	}//End method render
}//End class GameOptionsState
