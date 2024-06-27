package Models.CardModels;

import GUI.Interface;
import Models.EffectsModels.SoundEffects;
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

    public void tocaAudioMorte(){
        SoundEffects.playOST("MaleOut");
    }

    public String getDescription(){
        return "A carta Papa eh parecida com a de outros invocadores, porem, mais poderosa. Papa pode invocar uma carta do deck, alem de ter ataque e defesa altos.";
    }
}
