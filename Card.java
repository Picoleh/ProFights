/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Lepec
 */
public class Card extends JButton{
    public String nome;
    public int ATK, DEF;
    public Image imagem;

    public Card(String nome, int ATK, int DEF, Image imagem) {
        super(nome);
        this.nome = nome;
        this.ATK = ATK;
        this.DEF = DEF;
        this.imagem = imagem;
        this.setVisible(true);
        this.setPreferredSize(new Dimension(50, 100));
    }
    
    public Card(){
        super("teste");
        this.setVisible(true);
    }
}
