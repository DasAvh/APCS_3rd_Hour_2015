package utilities;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundBoard 
{
	//Fields
	private static AudioInputStream audioInputStream;
	private static Clip clip;	
	
	//Ids
	public static String mainMenu; 
	
	public static void initialize()
	{
		mainMenu = "res/sounds/mainMenu.wav";
	}//End initialize method
	
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
	    } catch(Exception ex)
		{
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }//End try catch
	}//End method playSound
	
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
	    }//End try catch
	}//End method playSoundWithLoop
	
	public static void stopSound()
	{
		clip.stop();
		clip = null;
	}//End method stopSound
	
	public static boolean isSoundPlaying()
	{
		return clip != null;
	}//End method isSoundPlaying
}//End class SoundBoard
