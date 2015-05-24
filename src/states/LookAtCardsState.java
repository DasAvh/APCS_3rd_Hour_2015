package states;

import java.awt.Color;
import java.awt.Graphics;

import cards.Card;
import runner.Game;

public class LookAtCardsState extends State 
{

	
	public LookAtCardsState(Game game) 
	{
		super(game);
		
		
		State.addState("lookAtCards", this);
	}//End constructor

	@Override
	public void tick() 
	{
		if(game.getKeyboardManager().left && choosenText != 0)
			choosenText--;
		
		if(game.getKeyboardManager().right && choosenText != GameState.players.size()- 1)
			choosenText++;
		
		if(game.getKeyboardManager().up && choosenText - 3 >= 0)
			choosenText-=3;
		
		if(game.getKeyboardManager().down && choosenText + 3 <= GameState.players.size()- 1)
			choosenText+=3;
		
		if(game.getKeyboardManager().enter || game.getKeyboardManager().escape)
			setState(getPrevState());
	}//End tick method

	public void render(Graphics g) 
	{
		getPrevState().render(g);
		drawScreen(g);	
	}
	
	private void drawScreen(Graphics g)
	{
		Card card;

		for(int x = 0; x < 6; x++)
		{
			card = GameState.players.get(GameState.currentPlayer).getCards()[x];
		
			if(x == choosenText)
			{
				System.out.println(card);
				game.getCamera().centerOnEntity(card);
				g.setColor(new Color(0,0,0,155));
			}
			card.render(g);
		}//End for
	}
	@Override
	public void startup() 
	{
		Card.realignCards(GameState.players.get(GameState.currentPlayer).getCards());
	}
}//End ChooseCardsState

