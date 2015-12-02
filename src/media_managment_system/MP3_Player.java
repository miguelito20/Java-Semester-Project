package media_managment_system;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MP3_Player{
	FileInputStream FIS;
	BufferedInputStream BIS;
	public Player mstream;
	public long pauseSong;
	public long SongLength;
	public String currentSong;
	
	public void Stop()
	{
		if(mstream != null){
			mstream.close();
			pauseSong = 0;
			SongLength = 0;
		}
	}
	public void Play(String path){
		try{
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);
			mstream = new Player(BIS);
			
			SongLength = FIS.available();
			 currentSong = path+"";
			} 			
		catch (FileNotFoundException | JavaLayerException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				try {
					mstream.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
	}
	public void Pause() {
		if(mstream != null){
			try{
				pauseSong = FIS.available();
				mstream.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}

	}
	public void Resume (){
		try{
			FIS = new FileInputStream(currentSong);
			BIS = new BufferedInputStream(FIS);
			mstream = new Player(BIS);
			FIS.skip(SongLength - pauseSong);
		}
		catch (FileNotFoundException | JavaLayerException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				try {
					mstream.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
	}

}
