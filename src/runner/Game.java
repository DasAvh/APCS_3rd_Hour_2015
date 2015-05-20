package runner;
import graphic.camera.Camera;
import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.ObjectInputStream.GetField;

import states.ChoosePlayersState;
import states.DieRollState;
import states.GameOptionsState;
import states.GameState;
import states.HowToPlayState;
import states.MainMenuState;
import states.PauseGameState;
import states.PlayerOptionsState;
import states.State;
import userinput.KeyboardManager;
import userinput.MouseManager;
import utilities.SoundBoard;
import display.Display;


public class Game implements Runnable 
{
	//Fields
	private Display display;
	private int width, height;
	public String title;
	
	//Threading
	private Thread thread;
	private boolean isRunning = false;
	
	//Drawing stuff
	private BufferStrategy bs;
	private Graphics g;

	//States
	private State gameState;
	private State menuState;
	private State howToPlayState;
	private State gameOptionsState;
	private State choosePlayerState;
	private State playerOptionsState;
	private State dieState;
	private State pauseState;
	
	//Input
	private KeyboardManager keyboard;
	private MouseManager mouse;
	
	//Camera
	private Camera boardCamera;
	
	public Game(String title, int width, int height)
	{	
		this.width = width;
		this.height = height;
		this.title = title;
		keyboard = new KeyboardManager();
		mouse = new MouseManager();
	}//End 3-args constructor

	private void initialize()
	{
		//Creates window and adds KeyListener
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyboard);
		
		//Loads Assets
		Assets.initialize();
		SoundBoard.initialize();
		
		//Setups game camera
		boardCamera = new Camera(this, 0, 0);
		
		//Create states
		menuState = new MainMenuState(this);
		gameState = new GameState(this);
		howToPlayState = new HowToPlayState(this);
		gameOptionsState = new GameOptionsState(this);
		choosePlayerState = new ChoosePlayersState(this);
		playerOptionsState = new PlayerOptionsState(this);
		dieState = new DieRollState(this);
		pauseState = new PauseGameState(this);
		
		//Sets menuState to display main menu
		
		State.setState(menuState);
	}//End initialize method

	private void tick()
	{
		keyboard.tick();
		mouse.tick();
		
		if(keyboard.numPadOne)
			State.setState(playerOptionsState);
		else if(keyboard.numPadTwo)
			State.setState(gameState);
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}//End if
	}//End method tick
	
	public void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}//End if
		
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Drawing
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing
		bs.show();
		g.dispose();
	}//End method render
	
	public void run()
	{
		initialize();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(isRunning)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}//End if
			
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}//End if
		}//End while
		
		stop();
	}//End run method
	
	public KeyboardManager getKeyboardManager()
	{
		return keyboard;
	}//End getKeyboardManager
	
	public MouseManager getMouseManager()
	{
		return mouse;
	}//End getMouseManager method
	
	public Camera getCamera()
	{
		return boardCamera;
	}//End getCamera method
	
	public int getWidth()
	{
		return width;
	}//End getWidth method
	
	public int getHeight()
	{
		return height;
	}//End getHeight method
	
	public synchronized void start()
	{
		if(isRunning)
			return;
		
		isRunning = true;
		thread = new Thread(this);
		//Calls run method
		thread.start();
	}//End start method
	
	public synchronized void stop()
	{
		if(!isRunning)
			return;
		
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//End try-catch
	}//End stop method
}//End class Game
