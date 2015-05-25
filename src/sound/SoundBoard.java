package sound;

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
	public static String hotline;
	
	public static void initialize()
	{
		mainMenu = "res/sounds/mainMenu.wav";
		hotline  = "res/sounds/hotline.wav";
	}
	
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
	    }
	}
	
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
	    }
	}
	
	public static void stopSound()
	{
		clip.stop();
		clip = null;
	}
	
	public static boolean isSoundPlaying()
	{
		return clip != null;
	}
}//End class SoundBoard
