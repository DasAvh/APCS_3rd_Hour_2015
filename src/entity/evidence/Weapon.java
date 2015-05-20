package entity.evidence;

import java.util.ArrayList;

import utilities.Utilities;

public class Weapon 
{
	//Fields
	public static ArrayList<Weapon> weapons;
	private String name;
	
	public Weapon(String name)
	{
		this.name = name;
	}
	
	public static void initialize()
	{
		String temp = Utilities.loadFile("lists/weapons.txt");
		String[] data = temp.split("\n");
		
		for(String s : data)
			weapons.add(new Weapon(s));
		//End for
	}//End initialize method
}//End class Weapon
