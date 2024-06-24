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
    private ArrayList<FieldCardPanel> fieldCardPanels;
    public FieldPanel(Player player){
        fieldCardPanels = new ArrayList<>();
        this.setLayout(new GridLayout(2, 5, 5, 5));
        for(int i=0; i < 10; i++){
            FieldCardPanel c = new FieldCardPanel(player, this);
            fieldCardPanels.add(c);
            c.addMouseListener(Interface.controller);
            c.btt.addMouseListener(Interface.controller);
            this.add(c);
        }
    }

    public void DeselectAll(){
        for(FieldCardPanel panel : fieldCardPanels){
            panel.btt.setBorder(null);
            panel.isSelected = false;
        }
    }

    public FieldCardPanel getFieldSelected(){
        for(FieldCardPanel c : fieldCardPanels){
            if(c.isSelected){
                return c;
            }
        }
        return null;
    }

    public boolean isAnySelected(){
        for(FieldCardPanel c : fieldCardPanels){
            if(c.isSelected){
                return true;
            }
        }
        return false;
    }

    public ArrayList<FieldCardPanel> getFieldList(){
        return fieldCardPanels;
    }
}
