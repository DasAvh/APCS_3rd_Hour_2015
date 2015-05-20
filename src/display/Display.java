package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.Utilities;

public class Display 
{
	//Fields
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		//Creates a display with this title, width, and height
		//Also stores the data for later
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}//End 3-args constructors
	
	private void createDisplay()
	{
		//Creates JFrame with constructor data
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Creates a Canvas to draw the game on
		canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		//Adds canvas to JFram
		frame.add(canvas);
		frame.pack();
	}//End createDisplay method
	
	public Canvas getCanvas()
	{
		return canvas;
	}//End getCanvas method
	
	public void hotlineDLC()
	{
		frame.setBackground(Utilities.genRandomColor());
	}
	
	public JFrame getFrame()
	{
		return frame;
	}//End getFrame method
}//End class Display
