package Models.CardModels;

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
    }

    private void updateImage(){
        try{
            this.img = ImageIO.read(getClass().getResource(pathToImage));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}