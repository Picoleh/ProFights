/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import Models.*;


public class HandPanel extends JPanel{
    private Player playerAssociado;
    private ArrayList<HandCardButton> listButton;
    public HandPanel(Player player){
        this.playerAssociado = player;
        this.listButton = new ArrayList<>();
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    public void update(){
        this.removeAll();
        listButton.clear();
        for(Card c : playerAssociado.cards){
            if(c.location == Location.HAND){
                HandCardButton cb = new HandCardButton(c,this);
                this.add(cb);
                listButton.add(cb);
            }
        }

        Interface.frame.revalidate();
        Interface.frame.repaint();
    }

    public void DeselectAll(){
        for(HandCardButton c : listButton){
            c.setMargin(new Insets(0,0,0,0));
            c.setBorder(null);
            c.isSelected = false;
        }
    }

    public Card getSelectedCard(){
        for(HandCardButton c : listButton){
            if(c.isSelected)
                return c.getCard();
        }
        return null;
    }

    public void addRandomCardToHand(){
        Random rd = new Random();
        NomeCarta nomeEnum = NomeCarta.values()[rd.nextInt(1,NomeCarta.values().length)];
        Image img = null;
        String url = "/GUI/Cards/"+nomeEnum+".jpeg";
        try{
            img = ImageIO.read(getClass().getResource(url));
        }catch(Exception ex){
            System.out.println(ex);
        }
        int atk=0,def=0;
        switch (nomeEnum){
            case NomeCarta.Adriana:
                atk = 33;
                def = 2;
                break;
        }
        Card c = new Card(nomeEnum,Location.HAND,img);
        playerAssociado.cards.add(c);
        update();
    }
}
