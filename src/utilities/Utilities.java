package utilities;

	import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import rooms.Room;
import weapons.Weapon;
import entity.chars.Player;

public class Utilities 
{
	
	public static String loadFile(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}//End try-catch
		
		return builder.toString();
	}//End loadFile
	
	public static String[] loadFile(String path, String ignore)
	{
		StringBuilder builder = new StringBuilder();
		String[] sections = {
				"","",""
		};
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			int index = -1;
			
			while((line = br.readLine()) != null)
			{
				if(line.substring(0, 1).equals(ignore))
				{
						index++;
						line = br.readLine();
				}//End if
				
				sections[index] += (line + " ");

			}//End while
				
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}//End try-catch
		
		return sections;
	}//End loadFile
	
	public static ArrayList<String> loadFileArray(String path)
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<String> text = new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = br.readLine()) != null)
				text.add(line);
				
				
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}//End try-catch
		
		return text;
	}//End loadFile
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}//End try-catch
	}//End parseInt method
	
	public static int diceRoll()
	{
		return (int)(Math.random() * 5 + 1);
	}//End diceRoll method
	
	public static int genRandomNum(int seed)
	{
		return (int)(Math.random() * seed);
	}//End method genRandomNumber
	
	public static Color genRandomColor()
	{
		return new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
	}//End genRandonColor method
	
	public static void printArray(String[] data)
	{
		for(String d : data)
			System.out.println(d + "|");
	}//End printArray method
	
	public static void pauseGame(int duration)
	{
		try 
		{
			Thread.sleep(duration);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}//End try catch
	}//End pauseGame method
	
	public static void copyWArrayList(ArrayList<Weapon> l1, ArrayList<Weapon> l2)
	{
		l1.clear();
		for(Weapon e : l2)
			l1.add(e);
	}

	public static void copyPArrayList(ArrayList<Player> l1, ArrayList<Player> l2) 
	{
		// TODO Auto-generated method stub
		l1.clear();
		for(Player e : l2)
			l1.add(e);
	}
	
	public static void copyRArrayList(ArrayList<Room> l1, ArrayList<Room> l2) 
	{
		// TODO Auto-generated method stub
		l1.clear();
		for(Room e : l2)
			l1.add(e);
	}
}//End Utilities class
