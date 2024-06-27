/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import GUI.Deck.DeckPanel;
import GUI.Field.FieldPanel;
import GUI.Hand.HandPanel;
import GUI.Interface;
import Models.CardModels.Card;

import java.awt.*;
import java.util.*;

public class Player {
    public String nome;
    public int vida;
    public ArrayList<Card> cards;
    public HandPanel hand = new HandPanel(this,(Interface.class.getResource("/GUI/UtilImages/blackwood.jpg")));
    public FieldPanel field = new FieldPanel(this);;
    public DeckPanel deck = new DeckPanel(this);
    
    public Player(String nome){
        this.nome = nome;
        vida = 5000;
        cards = new ArrayList<>();
        //hand.setOpaque(false);
    }

    public void DrawCard(){
        hand.addRandomCardToHand();
        hand.update();
    }

    public void DrawNCards(int n){
        while(n-- > 0)
            DrawCard();
    }
}
