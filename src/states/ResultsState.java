package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import runner.Game;

public class ResultsState extends State
{
	private String suggestion;
	public ResultsState(Game game) 
	{
		super(game);
		// TODO Auto-generated constructor stub
		addState("results", this);
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		System.out.println("Generating suggestion");
		suggestion = GameState.getWatson().getSuggestion(SuggestionState.selectedPlayer, SuggestionState.selectedWeapon,SuggestionState.selectedRoom);
		System.out.println("Suggestion Generated");
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(game.getKeyboardManager().enter)
			setState(getState("game"));
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.drawString(SuggestionState.selectedPlayer.toString(), 0, 12);
		g.drawString(SuggestionState.selectedWeapon.toString(), 0, 24);
		g.drawString(SuggestionState.selectedRoom.toString(), 0, 36);
		
		g.drawString(suggestion, 0, 48);
	}

}
