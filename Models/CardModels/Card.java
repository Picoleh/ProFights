package Models.CardModels;


import Models.EffectsModels.Effect;
import Models.EffectsModels.EffectsType;
import Models.Location;
import Models.NomeCarta;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;


public abstract class Card {
    public NomeCarta nome;
    public Image img;
    public Location location;
    public int ATK, DEF, VIDA;
    public ArrayList<Effect> efeitosAtivos;
    public boolean attacked = false;

    public Card(NomeCarta nome, Location location, Image img, int atk, int def){
        this.nome = nome;
        this.location = location;
        this.img = img;
        efeitosAtivos = new ArrayList<>();
        if(nome == NomeCarta.None)
            setBackCardImg();

        ATK = atk;
        DEF = def;
        VIDA = 100;
    }

    public void setBackCardImg(){
        try{
            Image imgBackCard = ImageIO.read(getClass().getResource("/GUI/Cards/Back.jpg"));
            img = (Card.MudaTamanhoImagem(imgBackCard, 0.25));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static Image MudaTamanhoImagem(Image img, double porcen){
        return img.getScaledInstance((int)(img.getWidth(null) * porcen), (int)(img.getHeight(null) * porcen), Image.SCALE_SMOOTH);
    }

    public abstract void Power();

    public abstract String getDescription();

    public abstract void tocaAudioMorte();

    public int getDEF(){
        int soma = 0;
        for(Effect ef : efeitosAtivos){
            if(ef.type == EffectsType.Deffense)
                soma += ef.value;
        }
        return DEF + soma;
    }

    public int getATK(){
        int soma = 0;
        for(Effect ef : efeitosAtivos){
            if(ef.type == EffectsType.Attack)
                soma += ef.value;
        }
        return ATK + soma;
    }

    public boolean getEnable(){
        for(Effect ef : efeitosAtivos){
            if(ef.type == EffectsType.Enable){
                return false;
            }
        }
        return true;
    }
}