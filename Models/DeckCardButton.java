package Models;

import Models.CardModels.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class DeckCardButton extends JButton {
    private int qtd;
    public Player playerAssociated;
    public DeckCardButton(Player player){
        playerAssociated = player;
        qtd = 20;
        setBackCardImg();
        updateQtd();
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setFont(new Font("Arial",Font.BOLD, 22));
        this.setForeground(Color.WHITE);
    }

    private void updateQtd(){
        this.setText(String.valueOf(qtd));
    }

    public void setBackCardImg(){
        try{
            Image imgBackCard = ImageIO.read(getClass().getResource("/GUI/Cards/Back.jpg"));
            this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(imgBackCard, 0.04)));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public int getCardsLeft(){
        return qtd;
    }

    public void removeOneCard(){
        qtd--;
        updateQtd();
    }
}
