package Models.EffectsModels;
import java.io.*;
import javax.sound.sampled.*;

public class SoundEffects {
    Clip sfx;
    String sfxname;

    public void playOST(String ostname){

        if(sfx!=null && sfx.isRunning()){
            sfx.stop();
        }

        try {
            File soundeffect;

            if (sfxname=="AdrianaPower"){
                soundeffect = new File("Models\\Sounds\\AdrianaDog.wav");
            }
            else if (sfxname=="DouglasPower"){
                soundeffect = new File("Models\\Sounds\\DouglasPower.wav");
            }
            else if (sfxname=="HerculesPower"){
                soundeffect = new File("Models\\Sounds\\HerculesPower.wav");
            }
            else if (sfxname=="NilceuPower"){
                soundeffect = new File("Models\\Sounds\\NilceuBuff.wav");
            }
            else if (sfxname=="PowerSound"){
                soundeffect = new File("Models\\Sounds\\PowerSound.wav");
            }
            else if (sfxname=="Hit"){
                soundeffect = new File("Models\\Sounds\\Hit.wav");
            }
            else if (sfxname=="DogOut"){
                soundeffect = new File("Models\\Sounds\\DogOut.wav");
            }
            else if (sfxname=="LambretaOut"){
                soundeffect = new File("Models\\Sounds\\LambretaOut.wav");
            }
            else if (sfxname=="FemaleOut"){
                soundeffect = new File("Models\\Sounds\\FemaleOut.wav");
            }
            else if (sfxname=="MaleOut"){
                soundeffect = new File("Models\\Sounds\\MaleOut.wav");
            }
            else{
                soundeffect = new File("Models\\Sounds\\CardFlip.wav");
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundeffect);

            sfx = AudioSystem.getClip();
            sfx.open(audioIn);
            sfx.start();
        } catch (Exception sfxException) {
            System.out.println(sfxException);
        }
    }
}

