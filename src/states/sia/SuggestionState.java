package states.sia;

import runner.Game;

public class SuggestionState extends SIAState
{
	public SuggestionState(Game game) 
	{
		super(game);
		
		addState("suggestion", this);
	}
}//End SuggestionState class
