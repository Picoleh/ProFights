package Models.CardModels;

import GUI.Interface;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class PapaCard extends Card{
    public PapaCard(Location location, Image img){
        super(NomeCarta.Papa,location,img,78,31);
    }

    public void Power(){
        Interface.controller.getActivePlayer().DrawNCards(1);
    }
}
