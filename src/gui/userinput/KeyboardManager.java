package userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JEditorPane;

public class KeyboardManager implements KeyListener {
	
	private boolean[] keys;

	public boolean up, down, left, right, leftArrow, rightArrow, numPadOne, numPadTwo,
				   enter, escape;
	
	private boolean keyIsPressed;
	private int currentKeyDown;
	
	public KeyboardManager()
	{
		keyIsPressed = false;
		keys = new boolean[256];
	}//End constructor
	
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		leftArrow = keys[KeyEvent.VK_LEFT];
		rightArrow = keys[KeyEvent.VK_RIGHT];
		numPadOne = keys[KeyEvent.VK_NUMPAD1];
		numPadTwo = keys[KeyEvent.VK_NUMPAD2];
		enter = keys[KeyEvent.VK_ENTER];
		escape = keys[KeyEvent.VK_ESCAPE];
		
		keys[currentKeyDown] = false;
	}//End method tick

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(!keys[e.getKeyCode()] && !keyIsPressed )
		{
			keys[e.getKeyCode()] = true;
			keyIsPressed = true;
			currentKeyDown = e.getKeyCode();
			//System.out.println(e.getKeyChar() + " Pressed");
		}//End if
	}//End method keyPressed

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == currentKeyDown)
		{
			keys[e.getKeyCode()] = false;
			keyIsPressed = false;
		//	System.out.println(e.getKeyChar() + " Released");
		}
	}//End method keyReleased

	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}//End method keyTyped
	
	public boolean canMove()
	{
		return keyIsPressed;
	}
}//End KeyboardManager class
