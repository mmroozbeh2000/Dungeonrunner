package dungeonrunner;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
  static File menuMusic = new File("C:/Javafiler/Sound.wav");

    
public void playSound(File sound) {
     
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.open();
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);              
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public void stopSound(File sound) {

}
 
}