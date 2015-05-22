package states;

import java.awt.Color;
import java.awt.Graphics;

import cards.Card;
import cards.PlayerCard;
import cards.RoomCard;
import cards.WeaponCard;
import rooms.Room;
import runner.Game;

public class InterragationState extends State
{
	//Fields
		private Color backgroundColor, backDropColor, frameColor, fillColor, selectedColor;
		private int cardSelection;
		
		public static PlayerCard selectedPlayer;
		public static WeaponCard selectedWeapon;
		public static RoomCard   selectedRoom;
		
//		private ArrayList<PlayerCard> playerCards;
//		private ArrayList<WeaponCard> weaponCards;
//		private ArrayList<RoomCard>   roomCards;
		
		public InterragationState(Game game) 
		{
			super(game);
			
			backDropColor = new Color(0, 0 , 0, 155);
			backgroundColor = Color.BLACK;
			frameColor = Color.YELLOW;
			fillColor = Color.WHITE;
			selectedColor = Color.BLUE;
			
			addState("interragation", this);
		}

		public static void setRoom(Room room)
		{
			selectedRoom = Card.roomCards.get(room.getId() - 1);
		}
		
		@Override
		public void startup() 
		{
			cardSelection = 0;
		}

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
			
			if(game.getKeyboardManager().enter)
			{
				if(cardSelection == 0)
				{
					selectedPlayer = Card.playerCards.get(GameState.players.get(choosenText).getId());
				} else if(cardSelection == 1)
				{
					selectedWeapon = Card.weaponCards.get(choosenText);
					System.out.println(selectedPlayer + " " + selectedWeapon + " " + selectedRoom + " ASDD");
					GameState.nextPlayer();
					setState(State.getState("results"));
				}
				cardSelection++;
				choosenText = 0;
			}
		}

		@Override
		public void render(Graphics g) 
		{
			getPrevState().render(g);
			drawScreen(g);
			
		}
		
		private void drawScreen(Graphics g)
		{
			Card card;
			if(cardSelection == 0)
			{
				for(int x = 0; x < 6; x++)
				{
					card = Card.playerCards.get(GameState.players.get(x).getId());
					
					if(x == choosenText)
					{
						System.out.println(Card.playerCards.get(GameState.players.get(choosenText).getId()));
						game.getCamera().centerOnEntity(card);
						g.setColor(Color.BLUE);
						g.fillRect((int)(card.getX() - game.getCamera().getxOffset()) - 5, (int)(card.getY() - game.getCamera().getyOffset() - 5), card.getWidth() + 10, card.getHeight() + 10);
					}//End if
					
					card.render(g);
				}//End for
			}else if(cardSelection == 1)
			{
				for(int i = 0; i < Card.weaponCards.size(); i++)
				{
					
					card = Card.weaponCards.get(i);
					
					if(i == choosenText)
					{
						System.out.println(Card.weaponCards.get(choosenText));
						game.getCamera().centerOnEntity(card);
						g.setColor(Color.RED);
						g.fillRect((int)(card.getX() - game.getCamera().getxOffset()) - 5, (int)(card.getY() - game.getCamera().getyOffset() - 5), card.getWidth() + 10, card.getHeight() + 10);
					}//End if
					
					card.render(g);
				}//End for
			}
		}
}
