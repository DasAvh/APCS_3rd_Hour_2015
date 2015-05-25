package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.Utilities;

/*
 * Add method to set players image
 */
public class Assets {
	// Dimensions
	private static final int width = 16, height = 16;
	private static final int overWorldWidth = 32, overWorldHeight = 32;
	private static final int playerWidth = 32, playerHeight = 32;
	private static final int cardWidth = 256, cardHeight = 256;
	private static final int roomWidth = 800, roomHeight = 600;

	// MainMenu
	public static ArrayList<BufferedImage> mainMenuImages;

	// General
	public static BufferedImage missing;
	public static BufferedImage mainMenuBackgroundImage;

	// Players
	public static BufferedImage[] playerOneImages;
	public static BufferedImage[] playerTwoImages;
	public static BufferedImage[] playerThreeImages;
	public static BufferedImage[] playerFourImages;
	public static BufferedImage[] playerFiveImages;
	public static BufferedImage[] playerSixImages;

	// Cards
	public static HashMap<Integer, BufferedImage> playerCardImages;
	public static HashMap<Integer, BufferedImage> weaponCardImages;
	public static HashMap<Integer, BufferedImage> roomCardImages;
	// Floors
	public static BufferedImage hallway, doorH, doorV, wall, room, spawn;

	// Rooms
	public static BufferedImage clarkRoom, chemLab, chavezRoom, cafeteria,
			autoRoom, bathroom, bandRoom, artStudio, gym, hall;
	// Weapons
	public static BufferedImage cafeteriaFood, friendSlayer, frozenWaterBottle,
			gunCandleStick, theNorton, tuba;

	// Overworld
	public static HashMap<String, BufferedImage> overworldImages;
	public static BufferedImage lcBorder;
	// Misc
	public static ArrayList<String> chars;
	public static ArrayList<String> winnerSayings;

	public static void initialize() {
		// Sprite sheets
		SpriteSheet boardSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/tiles/FloorSheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/players/PlayersSheet.png"));
		SpriteSheet weaponsSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/weapons/WeaponsSheet.png"));
		SpriteSheet roomsSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/rooms/RoomsSheet.png"));
		SpriteSheet clarkRoomSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/ClarkRoom/ClarkRoom.png"));
		SpriteSheet chemLabSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/ChemLab/ChemLab.png"));
		SpriteSheet chavezRoomSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/ChavezRoom/ChavezRoom.png"));
		SpriteSheet cafeteriaSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/Cafeteria/Cafeteria.png"));
		SpriteSheet autoSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/overworld/Auto/Auto.png"));
		SpriteSheet bathroomSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/Bathroom/Bathroom.png"));
		SpriteSheet bandRoomSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/BandRoom/BandRoom.png"));
		SpriteSheet artStudioSheet = new SpriteSheet(
				ImageLoader
						.loadImage("/textures/overworld/ArtStudio/ArtStudio.png"));
		SpriteSheet gymSheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/overworld/Gym/Gym.png"));

		// General
		missing = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		mainMenuBackgroundImage = ImageLoader
				.loadImage("/textures/misc/Class.jpg");

		// Load folder of images - Only for main menu
		mainMenuImages = new ArrayList<BufferedImage>();
		listFilesForFolder(new File("res/textures/menu/"));

		// Load cards
		playerCardImages = new HashMap<Integer, BufferedImage>();
		weaponCardImages = new HashMap<Integer, BufferedImage>();
		roomCardImages = new HashMap<Integer, BufferedImage>();
		listCardFilesForFolder(new File("res/textures/cards/players/"),
				"/textures/cards/players/", playerCardImages);
		listCardFilesForFolder(new File("res/textures/cards/weapons/"),
				"/textures/cards/weapons/", weaponCardImages);
		listCardFilesForFolder(new File("res/textures/cards/rooms/"),
				"/textures/cards/rooms/", roomCardImages);

		// Player assets
		playerOneImages = new BufferedImage[4];
		playerOneImages[0] = playerSheet.crop(0, 0, playerWidth, playerHeight);
		playerOneImages[1] = playerSheet.crop(playerWidth, 0, playerWidth,
				playerHeight);
		playerOneImages[2] = playerSheet.crop(playerWidth * 2, 0, playerWidth,
				playerHeight);
		playerOneImages[3] = playerSheet.crop(playerWidth * 3, 0, playerWidth,
				playerHeight);

		playerTwoImages = new BufferedImage[4];
		playerTwoImages[0] = playerSheet.crop(0, playerHeight, playerWidth,
				playerHeight);
		playerTwoImages[1] = playerSheet.crop(playerWidth, playerHeight,
				playerWidth, playerHeight);
		playerTwoImages[2] = playerSheet.crop(playerWidth * 2, playerHeight,
				playerWidth, playerHeight);
		playerTwoImages[3] = playerSheet.crop(playerWidth * 3, playerHeight,
				playerWidth, playerHeight);

		playerThreeImages = new BufferedImage[4];
		playerThreeImages[0] = playerSheet.crop(0, playerHeight * 2,
				playerWidth, playerHeight);
		playerThreeImages[1] = playerSheet.crop(playerWidth, playerHeight * 2,
				playerWidth, playerHeight);
		playerThreeImages[2] = playerSheet.crop(playerWidth * 2,
				playerHeight * 2, playerWidth, playerHeight);
		playerThreeImages[3] = playerSheet.crop(playerWidth * 3,
				playerHeight * 2, playerWidth, playerHeight);

		playerFourImages = new BufferedImage[4];
		playerFourImages[0] = playerSheet.crop(0, playerHeight * 3,
				playerWidth, playerHeight);
		playerFourImages[1] = playerSheet.crop(playerWidth, playerHeight * 3,
				playerWidth, playerHeight);
		playerFourImages[2] = playerSheet.crop(playerWidth * 2,
				playerHeight * 3, playerWidth, playerHeight);
		playerFourImages[3] = playerSheet.crop(playerWidth * 3,
				playerHeight * 3, playerWidth, playerHeight);

		playerFiveImages = new BufferedImage[4];
		playerFiveImages[0] = playerSheet.crop(0, playerHeight * 4,
				playerWidth, playerHeight);
		playerFiveImages[1] = playerSheet.crop(playerWidth, playerHeight * 4,
				playerWidth, playerHeight);
		playerFiveImages[2] = playerSheet.crop(playerWidth * 2,
				playerHeight * 4, playerWidth, playerHeight);
		playerFiveImages[3] = playerSheet.crop(playerWidth * 3,
				playerHeight * 4, playerWidth, playerHeight);

		playerSixImages = new BufferedImage[4];
		playerSixImages[0] = playerSheet.crop(0, playerHeight * 5, playerWidth,
				playerHeight);
		playerSixImages[1] = playerSheet.crop(playerWidth, playerHeight * 5,
				playerWidth, playerHeight);
		playerSixImages[2] = playerSheet.crop(playerWidth * 2,
				playerHeight * 5, playerWidth, playerHeight);
		playerSixImages[3] = playerSheet.crop(playerWidth * 3,
				playerHeight * 5, playerWidth, playerHeight);

		// Floor Assets
		hallway = boardSheet.crop(0, 0, width, height);
		wall = boardSheet.crop(width, 0, width, height);
		room = boardSheet.crop(width * 2, 0, width, height);
		spawn = boardSheet.crop(width * 3, 0, width, height);
		doorV = boardSheet.crop(0, height, width, height);
		doorH = boardSheet.crop(width, height, width, height);

		// Weapon assets
		cafeteriaFood = weaponsSheet.crop(0, 0, cardWidth, cardHeight);
		friendSlayer = weaponsSheet.crop(cardWidth, 0, cardWidth, cardHeight);
		frozenWaterBottle = weaponsSheet.crop(cardWidth * 2, 0, cardWidth,
				cardHeight);
		gunCandleStick = weaponsSheet.crop(cardWidth * 3, 0, cardWidth,
				cardHeight);
		theNorton = weaponsSheet.crop(0, cardHeight, cardWidth, cardHeight);
		tuba = weaponsSheet.crop(cardWidth, cardHeight, cardWidth, cardHeight);

		// Room assets
		clarkRoom = roomsSheet.crop(0, 0, roomWidth, roomHeight);
		chemLab = roomsSheet.crop(roomWidth, 0, roomWidth, roomHeight);
		chavezRoom = roomsSheet.crop(roomWidth * 2, 0, roomWidth, roomHeight);
		cafeteria = roomsSheet.crop(0, roomHeight, roomWidth, roomHeight);
		autoRoom = roomsSheet
				.crop(roomWidth, roomHeight, roomWidth, roomHeight);
		bathroom = roomsSheet.crop(roomWidth * 2, roomHeight, roomWidth,
				roomHeight);
		bandRoom = roomsSheet.crop(0, roomHeight * 2, roomWidth, roomHeight);
		artStudio = roomsSheet.crop(roomWidth, roomHeight * 2, roomWidth,
				roomHeight);
		gym = roomsSheet.crop(roomWidth * 2, roomHeight * 2, roomWidth,
				roomHeight);

		// Load class and winner sayings
		chars = Utilities.loadFileArray("res/lists/players.txt");
		winnerSayings = Utilities.loadFileArray("res/lists/winnerSayings.txt");

		// Load overworld assets
		overworldImages = new HashMap<String, BufferedImage>();
		overworldImages.put("clarkRoom", clarkRoomSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("chemLab", chemLabSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("chavezRoom", chavezRoomSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("cafeteria", cafeteriaSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("auto",
				autoSheet.crop(0, 0, overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("bathroom", bathroomSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("bandRoom", bandRoomSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("artStudio", artStudioSheet.crop(0, 0,
				overWorldWidth * 3, overWorldHeight * 3));
		overworldImages.put("gym",
				gymSheet.crop(0, 0, overWorldWidth * 3, overWorldHeight * 3));

		lcBorder = ImageLoader
				.loadImage("/textures/overworld/Outside/LCBorder.png");

	}// End init method

	private static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
				mainMenuImages.add(ImageLoader.loadImage("/textures/menu/"
						+ fileEntry.getName()));
			}// End if
		}// End for
		System.out.println("DONE");
	}// End method listFilesForFolder

	private static void listCardFilesForFolder(final File folder, String path,
			HashMap<Integer, BufferedImage> list) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				int index = fileEntry.getName().indexOf(".");

				list.put(
						Utilities.parseInt(fileEntry.getName().substring(0,
								index)),
						ImageLoader.loadImage(path + fileEntry.getName()));
			}// End if
		}// End if
	}// End method listFilesForFolder
}// End class Assets
