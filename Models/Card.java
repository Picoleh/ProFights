package Models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Card {
    public NomeCarta nome;
    public Image img;
    public Location location;
    public int ATK, DEF, VIDA;


    public Card(NomeCarta nome, Location location, Image img){
        this.nome = nome;
        this.location = location;
        this.img = img;
        if(nome == NomeCarta.None)
            setBackCardImg();

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
}
