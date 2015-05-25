package states.sia;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import runner.Game;
import states.GameState;
import states.State;
import utilities.Utilities;
import cards.Card;
import cards.PlayerCard;
import evidence.Watson;

public class ResultsState extends State {
	private String suggestion;
	private String suggestionTwo;
	private ArrayList<String> listOfSuggestion;
	private Card cardToDraw;
	private int mode;
	private int currentScene;
	private static final int SUGGESTION_MODE = 0;
	private static final int INTERRAGATION_MODE = 1;
	private static final int ACUSSATION_MODE = 2;

	public ResultsState(Game game) {
		super(game);
		addState("results", this);
	}// End constructor

	@Override
	public void startup() {
		if (getPrevState() == getState("suggestion")) {
			suggestion = GameState.getWatson().getSuggestion(
					SuggestionState.selectedPlayer,
					SuggestionState.selectedWeapon,
					SuggestionState.selectedRoom);

			if (suggestion.contains(SIAState.selectedPlayer.getName()))
				cardToDraw = SIAState.selectedPlayer;
			else if (suggestion.contains(SIAState.selectedWeapon.getName()))
				cardToDraw = SIAState.selectedWeapon;
			else if (suggestion.contains("Nobody"))
				cardToDraw = new PlayerCard(game, 0, 0, Card.CARD_WIDTH,
						Card.CARD_HEIGHT, 25, "Nobody", "was", "Here");
			else
				cardToDraw = Card.playerCards.get(Watson.playerInRoom.getId());
			// End if

			mode = 0;
		} else if (getPrevState() == getState("interragation")) {
			listOfSuggestion = GameState.getWatson().getInterrogation(
					InterragationState.selectedPlayer,
					InterragationState.selectedWeapon,
					InterragationState.selectedRoom);
			suggestion = "";
			for (int x = 0; x < listOfSuggestion.size() - 1; x++)
				suggestion += listOfSuggestion.get(x) + " ";

			suggestionTwo = listOfSuggestion.get(listOfSuggestion.size() - 1);

			cardToDraw = SIAState.selectedPlayer;

			mode = 1;
		} else {
			listOfSuggestion = GameState.getWatson().getAccusation(
					AcussationState.selectedPlayer,
					AcussationState.selectedWeapon,
					AcussationState.selectedRoom);
			cardToDraw = SIAState.selectedPlayer;

			currentScene = 0;
			mode = 2;
		}// End if
	}// End startup method

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (game.getKeyboardManager().enter) {
			if (mode == ACUSSATION_MODE) {
				if (currentScene == 3) {
					if (!listOfSuggestion.get(3).equals("You Lose"))
						setState(getState("playerWins"));
					else {
						GameState.players.get(GameState.currentPlayer)
								.playerLost();
						GameState.nextPlayer();
						setState(getState("game"));
					}
				} else
					currentScene++;
				// End if
			} else {
				GameState.nextPlayer();
				setState(getState("game"));
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Utilities.rainbowFade());

		switch (mode) {
		case SUGGESTION_MODE: {
			g.drawImage(Watson.roomEvidenceIsIn.getTexture(), 0, 0, null);
			cardToDraw.render(g);
			g.setFont(new Font("Consolas", Font.PLAIN, 20));
			game.getCamera().centerOnEntity(cardToDraw);
			drawCenteredString(suggestion, 800, 600, 525, g);
		}
			break;
		case INTERRAGATION_MODE: {
			g.drawImage(SIAState.roomIn.getTexture(), 0, 0, null);
			cardToDraw.render(g);
			game.getCamera().centerOnEntity(cardToDraw);
			g.setFont(genFont);
			for (int x = 0; x < listOfSuggestion.size(); x++) {
				drawCenteredString(suggestion, 800, 600, 525, g);
				drawCenteredString(suggestionTwo, 800, 600, 545, g);
			}// End for
		}
			break;
		case ACUSSATION_MODE: {
			g.drawImage(SIAState.roomIn.getTexture(), 0, 0, null);
			cardToDraw.render(g);
			game.getCamera().centerOnEntity(cardToDraw);
			g.setFont(new Font("Consolas", Font.PLAIN, 32));
			switch (currentScene) {
			case 0:
				drawCenteredString(listOfSuggestion.get(currentScene), 800,
						600, 545, g);
				break;
			case 1:
				drawCenteredString(listOfSuggestion.get(currentScene), 800,
						600, 545, g);
				break;
			case 2:
				drawCenteredString(listOfSuggestion.get(currentScene), 800,
						600, 545, g);
				break;
			case 3: {
				String line = listOfSuggestion.get(currentScene);
				String temp[] = line.split("~");

				for (int x = 0; x < temp.length; x++)
					drawCenteredString(temp[x], 800, 600, 525 + (x * 32), g);

			}
				break;
			default:
				break;
			}// End switch
		}// End switch
			break;
		default:
			break;
		}// End switch

	}

}
