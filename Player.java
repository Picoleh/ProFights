/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;

import java.util.*;

/**
 *
 * @author Lepec
 */
public class Player {
    public String nome;
    public int vida;
    List<Card> cards;
    
    public Player(String nome){
        this.nome = nome;
        vida = 5000;
    }
}
