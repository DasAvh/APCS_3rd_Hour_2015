package states;

import java.awt.Graphics;

import runner.Game;

public class ChoosePlayersState extends State 
{
	//Fields
	
	public ChoosePlayersState(Game game) 
	{
		super(game);
		
		
		
		State.addState("choosePlayers", this);
	}//End constructor

	@Override
	public void tick() 
	{
		
	}//End tick method

	@Override
	public void render(Graphics g) 
	{
		
	}//End render method

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}
}//End ChoosePlayersState
