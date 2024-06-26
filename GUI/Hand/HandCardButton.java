/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Hand;

import Models.CardModels.Card;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HandCardButton extends JButton{
    private Card card;
    private HandPanel Pai;
    public boolean isSelected;

    public HandCardButton(Card c, HandPanel pai) {
        card = c;
        Pai = pai;
        isSelected = false;
        this.setVisible(true);
        this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.06)));
        this.setMargin(new Insets(0,0,0,0));
        this.setBorder(null);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public Card getCard(){
        return card;
    }

    public void select(){
        if(!Pai.getListHand().stream().filter(x -> x.isSelected && x == this).toList().isEmpty()){
            Pai.DeselectAll();
        }
        else {
            Pai.DeselectAll();
            this.setMargin(new Insets(5,5,5,5));
            this.setBorder(new LineBorder(Color.RED, 3));
            isSelected = true;
        }
    }

    public HandPanel getPai(){
        return Pai;
    }
}
