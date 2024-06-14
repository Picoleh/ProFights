/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import GUI.HandPanel;
import GUI.Interface;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HandCardButton extends JButton{
//    public NomeCarta nome;
//    public int ATK, DEF, VIDA;
//    public Image img;
    private Card card;
    private HandPanel pai;
    public boolean isSelected;


    public HandCardButton(Card c, HandPanel pai) {
        this.pai = pai;
        isSelected = false;
        this.setVisible(true);
        this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.06)));
        this.setMargin(new Insets(0,0,0,0));
        this.setBorder(null);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                select();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Interface.infoCard.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img, 0.25)));
            }

            @Override
            public void mouseExited(MouseEvent e){
                Interface.infoCard.setBackCardImg();
            }
        });
    }

    private void select(){
        pai.DeselectAll();
        this.setMargin(new Insets(5,5,5,5));
        this.setBorder(new LineBorder(Color.RED, 3));
        isSelected = true;
    }
}
