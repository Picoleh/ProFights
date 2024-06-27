package Models.CardModels;

import Models.EffectsModels.SoundEffects;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class LambretaRoxaCard extends Card{
    public LambretaRoxaCard(Location location, Image img){
        super(NomeCarta.LambretaRoxa,location,img,25,70);
    }

    public void Power(){
    }

    public void tocaAudioMorte(){
        SoundEffects.playOST("LambretaOut");
    }

    public String getDescription(){
        return "Carta invocada pelo Hercules. Não possui poder especial";
    }
}
