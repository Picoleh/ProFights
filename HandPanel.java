/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Lepec
 */
public class HandPanel extends JPanel{
    private ArrayList<Card> hand;
    public HandPanel(){
        hand = new ArrayList<>();
        this.setLayout(new FlowLayout());
        for(int i=0; i < 10; i++){
            Card c = new Card();
            hand.add(c);
            this.add(c);
        }
    }
}
