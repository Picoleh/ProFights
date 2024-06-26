package Models.CardModels;

import GUI.Interface;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class AdrianaCard extends Card{
    public AdrianaCard(Location location, Image img){
        super(NomeCarta.Adriana,location,img,12,39);
    }

    public void Power(){
        Interface.controller.getActivePlayer().hand.addCardToHand(NomeCarta.Cachorro);
    }
}
