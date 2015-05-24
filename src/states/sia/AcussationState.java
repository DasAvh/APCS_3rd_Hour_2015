package states.sia;

import runner.Game;

public class AcussationState extends SIAState
{
		public AcussationState(Game game) 
		{
			super(game);
			addState("acussation", this);
		}
}