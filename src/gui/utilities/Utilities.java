package utilities;

	import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
				"",""
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
				}
				
				sections[index] += (line + " ");

			}//End while
				
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}//End try-catch
		
		return sections;
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
	
	public static Color genRandomColor()
	{
		return new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
	}//End genRandonColor method
	
	public static void printArrays(String[] data)
	{
		for(String d : data)
			System.out.println(d + "|");
	}
}//End Utilities class
