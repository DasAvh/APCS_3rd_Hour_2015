package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	//Fields
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}//End constructor
	
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}//End method crop
}//End class SpriteSheet
