package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

	private JFrame frame;
	private JPanel panel;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}//End 3-args constructors
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}//End createDisplay method
	
	public JPanel getJPanel()
	{
		return panel;
	}//End getJPanel method
	
	public Canvas getCanvas()
	{
		return canvas;
	}//End getCanvas method
	
	
	public JFrame getFrame()
	{
		return frame;
	}//End getFrame method
}//End class Display
