package entity.evidence;

import java.util.ArrayList;

import utilities.Utilities;

public class Room 
{	
	//Fields
	public static ArrayList<Room> rooms;
	private String name;
	
	public Room(String name)
	{
		this.name = name;
	}//End constructor
	
	public static void initialize()
	{
		String temp = Utilities.loadFile("lists/weapons.txt");
		String[] data = temp.split("\n");
		
		for(String s : data)
			rooms.add(new Room(s));
		//End for
	}//End initialize method
}//End class Room
