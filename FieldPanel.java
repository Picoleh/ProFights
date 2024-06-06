/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Lepec
 */
public class FieldPanel extends JPanel{
    private ArrayList<Card> cards;
    public FieldPanel(){
        cards = new ArrayList<>();
        this.setLayout(new GridLayout(2, 5, 5, 5));
        for(int i=0; i < 10; i++){
            Card c = new Card();
            cards.add(c);
            this.add(c);
        }
    }
}
