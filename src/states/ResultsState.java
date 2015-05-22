package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;

public class ResultsState extends State
{
	private String suggestion;
	private ArrayList<String> listOfSuggestion;
	
	private int mode;
	private static final int SUGGESTION_MODE = 0;
	private static final int INTERRAGATION_MODE = 1;
	private static final int ACUSSATION_MODE = 2;
	
	public ResultsState(Game game) 
	{
		super(game);
	
		
		addState("results", this);
	}

	@Override
	public void startup() 
	{
		if(getPrevState() == getState("suggestion"))
		{
			suggestion = GameState.getWatson().getSuggestion(SuggestionState.selectedPlayer, SuggestionState.selectedWeapon,SuggestionState.selectedRoom);
			mode = 0;
		}else if(getPrevState() == getState("interragation"))
		{
			listOfSuggestion = GameState.getWatson().getInterrogation(InterragationState.selectedPlayer, InterragationState.selectedWeapon, InterragationState.selectedRoom);
			System.out.println(listOfSuggestion);
			mode = 1;
		}else
		{
			listOfSuggestion = GameState.getWatson().getAccusation(AcussationState.selectedPlayer, AcussationState.selectedWeapon,AcussationState.selectedRoom);
			mode = 2;
		}//End if
	}//End startup method

	@Override
	public void tick() 
	{
		// TODO Auto-generated method stub
		if(game.getKeyboardManager().enter)
			setState(getState("game"));
	}

	@Override
	public void render(Graphics g) 
	{
		imageFade(g);
		switch (mode) 
		{
			case SUGGESTION_MODE:
			{
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.PLAIN, 12));
	
				g.drawString(SuggestionState.selectedPlayer.toString(), 0, 12);
				g.drawString(SuggestionState.selectedWeapon.toString(), 0, 24);
				g.drawString(SuggestionState.selectedRoom.toString(), 0, 36);
				g.drawString(suggestion, 0, 48);
			}break;
			case INTERRAGATION_MODE:
			{
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.PLAIN, 12));
	
				for(int x = 0; x < listOfSuggestion.size(); x++)
					g.drawString(listOfSuggestion.get(x), 0, 12 * x);		
			}break;
			case ACUSSATION_MODE:
			{
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.PLAIN, 12));
	
				for(int x = 0; x < listOfSuggestion.size(); x++)
					g.drawString(listOfSuggestion.get(x), 0, 12 * x);
			}break;
		default:
			break;
		}

	}

}
