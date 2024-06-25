package Models.CardModels;

import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class HerculesCard extends Card{
    public HerculesCard(Location location, Image img){
        super(NomeCarta.Hercules,location,img,33,20);
    }

    public void Power(){
        //TODO poder hercules
    }
}
