package Models.CardModels;

import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class NilceuCard extends Card{
    public NilceuCard(Location location, Image img){
        super(NomeCarta.Nilceu,location,img,40,20);
    }

    public void Power(){
        this.ATK += 40;
        this.DEF += 20;
    }
}
