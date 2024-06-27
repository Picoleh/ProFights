package Models.CardModels;

import GUI.Interface;
import Models.EffectsModels.SoundEffects;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class AdrianaCard extends Card{
    public AdrianaCard(Location location, Image img){
        super(NomeCarta.Adriana,location,img,12,39);
    }

    public void Power(){
        Interface.controller.getActivePlayer().hand.addCardToHand(NomeCarta.Cachorro);
        SoundEffects.playOST("AdrianaDog");
    }

    public String getDescription(){
        return "Adriana eh uma carta fraca, mas possui um grande poder: invocar seus cachorros que sabem calculo integral.";
    }

    public void tocaAudioMorte(){
        SoundEffects.playOST("FemaleOut");
    }
}
