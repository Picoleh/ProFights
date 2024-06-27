package Models.CardModels;

import GUI.Interface;
import Models.EffectsModels.SoundEffects;
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
        Interface.controller.attacksLeft++;
        this.VIDA += 50;
        SoundEffects.playOST("CardFlip");
    }

    public void tocaAudioMorte(){
        SoundEffects.playOST("MaleOut");
    }

    public String getDescription(){
        return "Krayton eh uma carta diferente, ao contrario das outras, ele pode retornar a mao do jogador. Ao fazer isso, ele recupera vida e possibilita mais um ataque de suas cartas";
    }
}