package Models.CardModels;

import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class CachorroCard extends Card{
    public CachorroCard(Location location, Image img){
        super(NomeCarta.Cachorro,location,img,55,30);
    }

    public void Power(){
    }
}
