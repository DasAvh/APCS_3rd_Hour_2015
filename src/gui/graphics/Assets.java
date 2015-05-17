package graphics;

import java.awt.image.BufferedImage;

public class Assets
{
	//Dimensions
	private static final int width = 32, height = 32;
	private static final int cardWidth = 256, cardHeight = 256;
	
	//General
	public static BufferedImage missing;
	
	//Players
	public static BufferedImage playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix; 

	//Floors
	public static BufferedImage hallway, door, wall, room, spawn;
	
	//Weapons
	public static BufferedImage cafeteriaFood, friendSlayer, frozenWaterBottle, gunCandleStick,
								theNorton, tuba;
	public static void initialize()
	{
		//Sprite sheets
		SpriteSheet boardSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles/FloorSheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/players/PlayerSheet.png"));
		SpriteSheet weaponsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/weapons/WeaponsSheet.png"));
		
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
		
		//Weapon assets
		cafeteriaFood = weaponsSheet.crop(0, 0, cardWidth, cardHeight);
		friendSlayer = weaponsSheet.crop(cardWidth, 0, cardWidth, cardHeight);
		frozenWaterBottle = weaponsSheet.crop(cardWidth * 2, 0, cardWidth, cardHeight);
		gunCandleStick = weaponsSheet.crop(cardWidth * 3, 0, cardWidth, cardHeight);
		theNorton = weaponsSheet.crop(0, cardHeight, cardWidth, cardHeight);
		tuba = weaponsSheet.crop(cardWidth, cardHeight, cardWidth, cardHeight);
	}//End init method
}//End class Assets
