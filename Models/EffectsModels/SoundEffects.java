package Models.EffectsModels;
import Logic.Sountrack;

import java.io.*;
import javax.sound.sampled.*;

public class SoundEffects {
    private static Clip sfx;

    public static void playOST(String sfxName){

        if(sfx!=null && sfx.isRunning()){
            sfx.stop();
        }

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sountrack.class.getResourceAsStream("/Logic/Sounds/"+sfxName+".wav"));
            sfx = AudioSystem.getClip();
            sfx.open(audioIn);
            sfx.start();
        } catch (Exception sfxException) {
            System.out.println(sfxException);
        }
    }
}

