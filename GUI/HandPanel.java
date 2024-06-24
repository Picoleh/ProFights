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
    public Player playerAssociated;
    private ArrayList<HandCardButton> listButton;
    public HandPanel(Player player){
        listButton = new ArrayList<>();
        this.playerAssociated = player;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void update(){
        this.removeAll();
        listButton.clear();
        for(Card c : playerAssociated.cards){
            if(c.location == Location.HAND){
                HandCardButton cb = new HandCardButton(c,this);
                cb.addMouseListener(Interface.controller);
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
            if(c.isSelected){
                c.getCard().location = Location.FIELD;
                update();
                return c.getCard();
            }
        }
        return null;
    }

    public boolean isAnySelected(){
        for(HandCardButton c : listButton){
            if(c.isSelected){
                return true;
            }
        }
        return false;
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
        Card c = new Card(nomeEnum,Location.HAND,img);
        playerAssociated.cards.add(c);
        update();
    }

    public ArrayList<HandCardButton> getListHand(){
        return listButton;
    }
}
