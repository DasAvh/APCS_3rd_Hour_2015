package userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyboardManager()
	{
		keys = new boolean[256];
	}//End constructor
	
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}//End method tick

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
		System.out.println(e.getKeyChar() + " Pressed");
	}//End method keyPressed

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}//End method keyReleased

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}//End method keyTyped
}//End KeyboardManager class
