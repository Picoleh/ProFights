package Models.CardModels;

import GUI.Interface;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class KraytonCard extends Card{
    public KraytonCard(Location location, Image img){
        super(NomeCarta.Krayton,location,img,69,44);
    }

    public void Power(){
        this.location = Location.HAND;
        Interface.controller.getActivePlayer().hand.update();
        Interface.controller.getActivePlayer().field.getFieldSelected().removeCard();
        this.VIDA += 50;
    }
}
