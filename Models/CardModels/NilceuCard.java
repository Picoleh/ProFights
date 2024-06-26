package Models.CardModels;

import Models.EffectsModels.Effect;
import Models.EffectsModels.EffectsType;
import Models.Location;
import Models.NomeCarta;

import javax.imageio.ImageIO;
import java.awt.*;

public class NilceuCard extends Card{
    public NilceuCard(Location location, Image img){
        super(NomeCarta.AparecidoNilceu,location,img,40,35);
    }

    public void Power(){
        this.efeitosAtivos.add(new Effect(1, EffectsType.Attack,60));
        this.efeitosAtivos.add(new Effect(2,EffectsType.Deffense, 35));
        try{
            this.img = ImageIO.read(getClass().getResource("/GUI/Cards/Nilceu.jpeg"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void endPower(){
        try{
            this.img = ImageIO.read(getClass().getResource("/GUI/Cards/AparecidoNilceu.jpeg"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}