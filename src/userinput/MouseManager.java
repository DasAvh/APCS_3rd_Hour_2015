package userinput;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tiles.Tile;

public class MouseManager implements MouseListener 
{

	private Tile tile;

	public void tick()
	{
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tile))
			System.out.println("Ye");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}//End class MouseManager
