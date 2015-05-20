package entity.evidence;

import java.util.ArrayList;

import utilities.Utilities;

public class Person 
{
	//Fields
	public static ArrayList<Person> people;
	private String name;
	private String message;
	
	public Person(String data)
	{
		name = data.split("-")[0];
		message = data.split("-")[1];
	}//End constructor
	
	public static void initialize()
	{
		String temp = Utilities.loadFile("lists/players.txt");
		String[] data = temp.split("\n");
		
		for(String s : data)
			people.add(new Person(s));
		//End for
	}//End initialize method
}//End class Person
