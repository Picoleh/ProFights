package Models.CardModels;

import Models.EffectsModels.Effect;
import Models.EffectsModels.EffectsType;
import Models.Location;
import Models.NomeCarta;

import java.awt.*;

public class NilceuCard extends Card{
    public NilceuCard(Location location, Image img){
        super(NomeCarta.Nilceu,location,img,40,35);
    }

    public void Power(){
        this.efeitosAtivos.add(new Effect(1, EffectsType.Attack,40));
        this.efeitosAtivos.add(new Effect(2,EffectsType.Deffense, 30));
    }
}
