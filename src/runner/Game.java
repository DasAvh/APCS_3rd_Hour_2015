package runner;

import graphic.camera.Camera;
import graphics.Assets;
import graphics.Overworld;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import sound.SoundBoard;
import states.ChoosePlayersState;
import states.DieRollState;
import states.GameOptionsState;
import states.GameState;
import states.HowToPlayState;
import states.LookAtCardsState;
import states.MainMenuState;
import states.MusicSelectionState;
import states.PauseGameState;
import states.PlayerOptionsState;
import states.PlayerWinsState;
import states.PlayersLostState;
import states.State;
import states.sia.AcussationState;
import states.sia.InterragationState;
import states.sia.ResultsState;
import states.sia.SuggestionState;
import userinput.KeyboardManager;
import utilities.Utilities;
import weapons.Weapon;
import board.Board;
import cards.Card;
import display.Display;

public class Game implements Runnable {
	// Fields
	private Display display;
	private int width, height;
	public String title;

	// Threading
	private Thread thread;
	private boolean isRunning = false;

	// Drawing stuff
	private BufferStrategy bs;
	private Graphics g;
	private Graphics2D g2;

	// States
	private State gameState;
	private State menuState;
	private State howToPlayState;
	private State gameOptionsState;
	private State choosePlayerState;
	private State playerOptionsState;
	private State dieState;
	private State pauseState;
	private State suggestionState;
	private State interragationState;
	private State acussationState;
	private State resultsState;
	private State lookAtCardsState;
	private State playerWinsState;
	private State playersLostState;
	private State musicSelectionState;
	
	// Input
	private KeyboardManager keyboard;
	private boolean newGame;
	private Board board;
	// Evidence

	// Camera
	private Camera boardCamera;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyboard = new KeyboardManager();
		newGame = true;
	}// End 3-args constructor

	private void initialize() {
		// Creates window and adds KeyListener
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyboard);

		// Loads Assets
		Assets.initialize();
		Weapon.initialize();
		SoundBoard.initialize();
		// Board.initialize(this,
		// "res/boards/BoardMap.txt","res/boards/BoardData.txt");
		board = new Board(this, "res/boards/BoardMap.txt",
				"res/boards/BoardData.txt");
		Card.initialize(this);
		Overworld.initialize(this, "res/boards/BoardOverworldRooms.txt");
		// Setups game camera
		boardCamera = new Camera(this, 0, 0);

		// Create states
		menuState = new MainMenuState(this);
		gameState = new GameState(this);
		howToPlayState = new HowToPlayState(this);
		gameOptionsState = new GameOptionsState(this);
		choosePlayerState = new ChoosePlayersState(this);
		playerOptionsState = new PlayerOptionsState(this);
		dieState = new DieRollState(this);
		pauseState = new PauseGameState(this);
		suggestionState = new SuggestionState(this);
		interragationState = new InterragationState(this);
		acussationState = new AcussationState(this);
		resultsState = new ResultsState(this);
		lookAtCardsState = new LookAtCardsState(this);
		playerWinsState = new PlayerWinsState(this);
		playersLostState = new PlayersLostState(this);
		musicSelectionState = new MusicSelectionState(this);
		
		// Sets menuState to display main menu
		State.setState(menuState);
	}// End initialize method

	private void tick() {
		keyboard.tick();

		if (State.getState() != null) {
			State.getState().tick();
		}// End if
	}// End method tick

	public void render() {
		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}// End if

		g = bs.getDrawGraphics();

		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Drawing
		g.setColor(Utilities.hotlineFade());
		g.fillRect(0, 0, width, height);

		g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		if (State.getState() != null)
			State.getState().render(g2);

		// End Drawing
		bs.show();
		g.dispose();
	}// End method render

	public void run() {
		initialize();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
					
				tick();
				render();
				ticks++;
				delta--;
			}// End if

			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}// End if
		}// End while

		stop();
	}// End run method

	public KeyboardManager getKeyboardManager() {
		return keyboard;
	}// End getKeyboardManager

	public Board getBoard() {
		return board;
	}

	public boolean newGame() {
		return newGame;
	}// End newGame method

	public void gameStarted() {
		newGame = false;
	}// End gameStarted method

	public void endGame() {
		newGame = true;
	}// End endGame method

	public Camera getCamera() {
		return boardCamera;
	}// End getCamera method

	public int getWidth() {
		return width;
	}// End getWidth method

	public int getHeight() {
		return height;
	}// End getHeight method

	public synchronized void start() {
		if (isRunning)
			return;

		isRunning = true;
		thread = new Thread(this);
		// Calls run method
		thread.start();
	}// End start method

	public synchronized void stop() {
		if (!isRunning)
			return;

		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}// End try-catch
	}// End stop method
}// End class Game
