package runner;
import graphic.camera.Camera;
import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import states.GameState;
import states.MainMenuState;
import states.State;
import userinput.KeyboardManager;
import userinput.MouseManager;
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
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyboard);
		//display.getJPanel().addMouseListener(mouse);
		Assets.init();
		
		boardCamera = new Camera(this, 0, 0);
		gameState = new GameState(this);
		menuState = new MainMenuState(this);
		State.setState(gameState);
	}//End initialize method

	private void tick()
	{
		keyboard.tick();
		mouse.tick();
		
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