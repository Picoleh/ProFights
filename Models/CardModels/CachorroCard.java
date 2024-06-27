package Models.CardModels;

import Models.EffectsModels.SoundEffects;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class CachorroCard extends Card{
    public CachorroCard(Location location, Image img){
        super(NomeCarta.Cachorro,location,img,55,30);
    }

    public void Power(){
    }

    public String getDescription(){
        return "Carta invocada pela Adriana. Não possui poder especial";
    }

    public void tocaAudioMorte(){
        SoundEffects.playOST("DogOut");
    }
}
