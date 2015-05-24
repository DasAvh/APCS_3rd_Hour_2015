package rooms;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utilities.Utilities;
import cards.RoomCard;
import entity.Entity;
import entity.chars.Player;
import graphics.Assets;

public class Room 
{
	//Fields
	public static Room[] rooms = new Room[10];
	public static ArrayList<Room> rooms2 = new ArrayList<Room>();
	public static final int ROOM_WIDTH = 2;
	public static final int ROOM_HEIGHT = 2;
	public static final int ROOM_SIZE = ROOM_WIDTH * ROOM_HEIGHT; 

	//Ids
	//public static Room generalRoom = new GeneralRoom(0); 
	//public static Room passageRoom = new PassageRoom(1);
	public static final int GENERAL_ROOM = 0;
	public static final int PASSAGE_ROOM = 1;
	
	//Protected
	protected int id;
	protected String name;
	protected String slogan;
	protected ArrayList<Entity> playersInRoom;
	protected int[] xPoints;
	protected int[] yPoints;
	protected BufferedImage texture;
	
	public Room(String[] data, int id, String name)
	{
		xPoints = new int[ROOM_SIZE];
		yPoints = new int[ROOM_SIZE];
		this.id = id;
		
		int index = 0;
		
		for(int i = 0; i < data.length / 2; i++)
		{
			
			//System.out.println(Integer.parseInt(spawnData[index]) + " " + Integer.parseInt(spawnData[index + 1]));
			xPoints[i] = Utilities.parseInt(data[index]);
			yPoints[i] = Utilities.parseInt(data[index + 1]);
			index += 2;
		}//End for

		//this.slogan = slogan;
		this.name = name;
		playersInRoom = new ArrayList<Entity>(0);
		
		switch (id) 
		{
		case 1:texture = Assets.clarkRoom;break;
		case 2:texture = Assets.chemLab;break;
		case 3:texture = Assets.chavezRoom;break;
		case 4:texture = Assets.cafeteria;break;
		case 5:texture = Assets.autoRoom;break;
		case 6:texture = Assets.bathroom;break;
		case 7:texture = Assets.bandRoom;break;
		case 8:texture = Assets.artStudio;break;
		case 9:texture = Assets.gym;break;
		case 10:texture = Assets.clarkRoom;break;

		default:
			break;
		}
		
		rooms2.add(this);
	}//End constructor
	
	public boolean isFull()
	{
		return ROOM_SIZE == playersInRoom.size();
	}//End isFull method
	
	public void printRoom()
	{
		for(int x = 0; x < ROOM_SIZE; x++)
		{
			System.out.print(xPoints[x] + " ");
			System.out.println(yPoints[x]);
		}//End for
		
		System.out.println("\nPlayers: " + playersInRoom);
	}//End printRoom method
	
	public boolean inRoom(int x, int y)
	{
		for(int i = 0; i < ROOM_SIZE; i++)
		{
			if(x == xPoints[i] && y == yPoints[i])
				return true;
		}
		return false;
	}//End inRoom method
	
	public void setPlayerInRoom(Player entity)
	{
		entity.setX(xPoints[playersInRoom.size()] * 64);
		entity.setY(yPoints[playersInRoom.size()] * 64);
		playersInRoom.add(entity);
		System.out.println(name);
	}//End method setPlayerInRoom
	
	public void setPlayerOutOfRoom(Player entity)
	{
		entity.setX(entity.getLastMoveX());
		entity.setY(entity.getLastMoveY());
		playersInRoom.remove(entity);

	}//End metho setPlayerOutOfRoom
	
	public BufferedImage getTexture()
	{
		return texture;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSlogan()
	{
		return slogan;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return name;
	}
	
	
	public boolean equals(Object other)
	{
		return getName().equals(((RoomCard)(other)).getName()); 
	}
}//End class Room
