package graphics;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 32, height = 32;
	
	//General
	public static BufferedImage missing;
	
	//Players
	public static BufferedImage playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix; 

	//Floors
	public static BufferedImage hallway, door, wall, room, spawn;
	public static void init()
	{
		//Sprite sheets
		SpriteSheet boardSheet = new SpriteSheet(ImageLoader.loadImage("/textures/FloorSheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerSheet.png"));
		
		//General
		missing = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		
		//Player assets
		playerOne = playerSheet.crop(0, 0, width, height);
		playerTwo = playerSheet.crop(width, 0, width, height);
		playerThree = playerSheet.crop(width * 2, 0, width, height);
		playerFour = playerSheet.crop(width * 3, 0, width, height);
		playerFive = playerSheet.crop(0, height, width, height);
		playerSix = playerSheet.crop(width, height, width, height);
		
		//Floor Assets
		hallway = boardSheet.crop(0, 0, width, height);
		wall = boardSheet.crop(width, 0, width, height);
		room = boardSheet.crop(width * 2, 0, width, height);
		spawn = boardSheet.crop(width * 3, 0, width, height);
		door = boardSheet.crop(0, height, width, height);
	}//End init method
}//End class Assets
