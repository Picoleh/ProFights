package GUI;

import java.io.*;
import javax.sound.sampled.*;

public class Sountrack {
    Clip ost;
    String ostname;

    public void playOST(String ostname){

        if(ost!=null && ost.isRunning()){
            ost.stop();
        }

        try {
            File musica;

            if (ostname=="battle"){
                musica = new File("GUI\\Sounds\\ProFightsBattle.wav");
            }
            else{
                musica = new File("GUI\\Sounds\\ProFightsMenu.wav");
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musica);

            ost = AudioSystem.getClip();
            ost.open(audioIn);
            ost.loop(Clip.LOOP_CONTINUOUSLY);
            ost.start();
        } catch (Exception ostException) {
            System.out.println(ostException);
        }
    }

    public void stopOST(){
        if(ost!=null && ost.isRunning()){
            ost.stop();
        }
    }
}
