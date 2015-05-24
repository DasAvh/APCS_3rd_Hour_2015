package states.sia;

import runner.Game;

public class InterragationState extends SIAState
{
	public InterragationState(Game game) 
	{
		super(game);
		
		addState("interragation", this);
	}

}
