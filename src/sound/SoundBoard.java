package sound;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundBoard 
{
	//Fields
	private static AudioInputStream audioInputStream;
	private static Clip clip;	
	private static ArrayList<String> files;
	public static String[][] playList;
	private static int id;
	//Ids

	
	public static void initialize()
	{
		files = new ArrayList<String>();
		listFilesForFolder(new File("res/sounds/"));
		System.out.println(files);
		playList = new String[files.size()][2];
		
		String temp = "";
		for(int x = 0; x < files.size(); x++)
		{
			temp = files.get(x);
			playList[x][0] = temp.substring(0, temp.indexOf("."));
			playList[x][1] = "res/sounds/" + files.get(x); 
		}//End for
	}//ENd initalize
	
	public static void playSound(String name)
	{   
		try
		{
			//Opens file
	        audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        
	        //Starts playing sound
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }//End try-catch
	}//End playSound method
	
	public static void playSoundWithLoop(String name, int loopNum)
	{   
		try
		{
			//Opens file
	        audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        
	        //Starts playing sound
	        clip.open(audioInputStream);
	        clip.start();
	        clip.loop(loopNum);
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }//Try-catch
	}//End playSoundWithLoop method
	
	public static void stopSound()
	{
		clip.stop();
		clip.close();
		clip = null;
	}//End method stopSound
	
	public static void requestSong()
	{
		Scanner input = new Scanner(System.in);
		
		for(int x = 0; x < playList.length; x++)
			System.out.printf("Id - %-3d Song :  %s%n", x, playList[x][0]);
		
		System.out.println("Enter id of song: ");
		id = input.nextInt();
		
		if(id < playList.length && id > -1)
		{
			if(isSoundPlaying())
				stopSound();
			
			playSoundWithLoop(playList[id][1], 100);
		}else
			System.out.println("Error, invalid id");
		//input.close();
	}//End method requestSong
	
	public static boolean isSoundPlaying()
	{
		return clip != null;
	}//End method isSoundPlaying
	
	private static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
				files.add(fileEntry.getName());
			}// End if
		}// End for
		System.out.println("DONE");
	}// End method listFilesForFolder
	
}//End class SoundBoard
