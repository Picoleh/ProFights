/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Models.*;

public class FieldPanel extends JPanel{
    private ArrayList<FieldCardButton> fieldCardButtons;
    public FieldPanel(Player player){
        fieldCardButtons = new ArrayList<>();
        this.setLayout(new GridLayout(2, 5, 5, 5));
        for(int i=0; i < 10; i++){
//            JPanel conjunto = new JPanel(new BorderLayout());
//            JPanel ImgCarta = new JPanel();
//            JPanel vida = new JPanel();
            FieldCardButton c = new FieldCardButton(player);
            fieldCardButtons.add(c);
            //ImgCarta.add(c);
            this.add(c);
        }
    }
}
