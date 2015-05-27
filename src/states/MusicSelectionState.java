package states;

import java.awt.Color;
import java.awt.Graphics2D;

import runner.Game;
import sound.SoundBoard;
import utilities.Utilities;

public class MusicSelectionState extends State
{
	private static int currentSong;
	
	public MusicSelectionState(Game game) 
	{
		super(game);
		currentSong = 0;
		backDropColor = new Color(0,0,0, 155);
		addState("music", this);
	}

	@Override
	public void startup() 
	{
		
	}

	@Override
	public void tick() 
	{
		if(currentSong != 0 && game.getKeyboardManager().up)
			currentSong--;
		
		if(currentSong != SoundBoard.playList.length - 1 && game.getKeyboardManager().down)
			currentSong++;
		
		if(game.getKeyboardManager().enter)
			SoundBoard.playSoundWithLoop(SoundBoard.playList[currentSong][1], 100);
		
		if(game.getKeyboardManager().p)
			SoundBoard.pauseResumeMusic();
		
		if(game.getKeyboardManager().escape)
			setState(getPrevState());
	}

	@Override
	public void render(Graphics2D g) 
	{
		getPrevState().render(g);
		g.setColor(backDropColor);
		g.fillRect(0, 0, 800, 600);
		
		for(int x = 0; x < SoundBoard.playList.length; x++)
		{
			g.setColor(Color.WHITE);
			
			if(x == currentSong)
				g.setColor(Utilities.rainbowFade());
			
			//if(SoundBoard.playList[x][0] != null)
			g.setFont(font);
			drawCenteredString(SoundBoard.playList[x][0], 800, 600, 50 * x + 50, g);
			

		}//End for
	}//End render

}//End class MusicSelectionState
