package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

	private JFrame frame;
	private JPanel panel;
	
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
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(width, height));
		panel.setMaximumSize(new Dimension(width, height));
		panel.setMinimumSize(new Dimension(width, height));
		panel.setFocusable(false);
		

		
		frame.add(panel);
		frame.pack();
	}//End createDisplay method
	
	public JPanel getJPanel()
	{
		return panel;
	}//End getCanvas method
	
	public void paintComponent(Graphics g)
	{
		g.clearRect(0, 0, width, height);

	}
	
	public JFrame getFrame()
	{
		return frame;
	}//End getFrame method
}//End class Display
