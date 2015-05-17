package states;

import java.awt.Graphics;

import runner.Game;

public class HowToPlayState extends State
{

	public HowToPlayState(Game game) 
	{
		super(game);
		
		addState("howToPlay", this);
	}//End constructor

	@Override
	public void tick() 
	{
		
	}//End tick method

	@Override
	public void render(Graphics g) 
	{
		
	}//End render method

}//End class HowToPlayState
