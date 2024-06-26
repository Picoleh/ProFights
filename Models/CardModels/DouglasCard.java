package Models.CardModels;

import Models.EffectsModels.SoundEffects;
import Models.Location;
import Models.NomeCarta;

import javax.imageio.ImageIO;
import java.awt.*;

public class DouglasCard extends Card{
    public boolean isInDefenseMode = false;
    private static String pathToImage;
    public DouglasCard(Location location, Image img){
        super(NomeCarta.Douglas,location,img,90,16);
    }

    public void Power(){
        if(this.ATK == 90){
            this.ATK = 0;
            this.DEF = 97;
            isInDefenseMode = true;
            pathToImage = "/GUI/Cards/DouglasDEF.jpeg";
        }
        else{
            this.ATK = 90;
            this.DEF = 16;
            isInDefenseMode = false;
            pathToImage = "/GUI/Cards/Douglas.jpeg";
        }
        updateImage();
        SoundEffects.playOST("DouglasPower");
    }

    public String getDescription(){
        return "Douglas possui dois modos: ATK, o qual ele da bastante dano, mas possui pouca defesa; e DEF, o qual ele nao ataca, mas pode tankar quase todos os golpes.";
    }

    public void tocaAudioMorte(){
        SoundEffects.playOST("MaleOut");
    }

    private void updateImage(){
        try{
            this.img = ImageIO.read(getClass().getResource(pathToImage));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}