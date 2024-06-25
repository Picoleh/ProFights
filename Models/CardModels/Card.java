package Models.CardModels;


import Models.EffectsModels.Effect;
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

}
