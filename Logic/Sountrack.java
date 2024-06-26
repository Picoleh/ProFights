package Logic;

import java.io.*;
import java.util.Objects;
import javax.sound.sampled.*;

public class Sountrack {
    private static Clip ost;

    public static void playOST(String ostName){
        if(ost!=null && ost.isRunning()){
            ost.stop();
        }

        try {
            AudioInputStream x = null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sountrack.class.getResourceAsStream("/Logic/Sounds/ProFights"+ostName+".wav"));

            ost = AudioSystem.getClip();
            //ost.open(audioIn);
            //ost.loop(Clip.LOOP_CONTINUOUSLY);
            //ost.start();
        } catch (Exception ostException) {
            System.out.println(ostException);
        }
    }

    public static void stopOST(){
        if(ost!=null && ost.isRunning()){
            ost.stop();
        }
    }
}
