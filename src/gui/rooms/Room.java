package rooms;

import utilities.Utilities;
import entity.Entity;

public class Room 
{
	//Fields
	public static Room[] rooms = new Room[10];
	public static final int ROOM_WIDTH = 2;
	public static final int ROOM_HEIGHT = 2;
	public static final int ROOM_SIZE = ROOM_WIDTH * ROOM_HEIGHT; 
	protected int[] xPoints;
	protected int[] yPoints;
	
	//Ids
	//public static Room generalRoom = new GeneralRoom(0); 
	//public static Room passageRoom = new PassageRoom(1);
	
	public static final int GENERAL_ROOM = 0;
	public static final int PASSAGE_ROOM = 1;
	
	//Protected
	protected int id;
	protected String name;
	protected int playersInRoom;
	
	
	public Room(String[] data, int id)
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

		playersInRoom = 0;
	}//End constructor
	
	public boolean isFull()
	{
		return ROOM_SIZE == playersInRoom;
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
	
	public void setPlayerInRoom(Entity entity)
	{
		System.out.println(xPoints[playersInRoom]);
		System.out.println(yPoints[playersInRoom]);
		System.out.println(id);
		entity.setX(xPoints[playersInRoom] * 64);
		entity.setY(yPoints[playersInRoom] * 64);
		playersInRoom++;
	}//End method setPlayerInRoom
	
	public void setPlayerOutOfRoom(Entity entity)
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}//End setName
	
	public int getId()
	{
		return id;
	}
}//End class Room
