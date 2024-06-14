/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import Models.*;

public class Interface{
    //public static HandPanel hand_p1;
    //public static HandPanel hand_p2;
    public static JFrame frame;
    public static CardInfoPanel infoCard;
    public static void CriaUI(Player p1, Player p2){
        frame = new JFrame();
        // Parte Esquerda - Infos
        JPanel infos = new JPanel(new BorderLayout());
        JPanel info_p2 = new JPanel();
        JPanel turno = new JPanel(new GridLayout(7, 1));
        JPanel info_p1 = new JPanel();
        JLabel nome_p1 = new JLabel(p1.nome);
        JLabel vida_p1 = new JLabel("Vida: 5000");
        JLabel nome_p2 = new JLabel(p2.nome);
        JLabel vida_p2 = new JLabel("Vida: 5000");
        JButton btt_encerrarTurno = new JButton("Encerrar Turno");

        info_p1.add(nome_p1);
        info_p1.add(vida_p1);
        info_p2.add(nome_p2);
        info_p2.add(vida_p2);
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(btt_encerrarTurno);
        turno.setBackground(Color.YELLOW);
        
        infos.add(info_p2, BorderLayout.NORTH);
        infos.add(turno, BorderLayout.CENTER);
        infos.add(info_p1, BorderLayout.SOUTH);
        // ------------------------
        JPanel centro = new JPanel(new BorderLayout());
        // Parte Centro - Cartas p1
        JScrollPane scroll_p1 = new JScrollPane(p1.hand);
        scroll_p1.setBorder(null);
        scroll_p1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll_p1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //-------------------------
        // Parte Centro - Cartas p2

        JScrollPane scroll_p2 = new JScrollPane(p2.hand);
        scroll_p2.setBorder(null);
        scroll_p2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll_p2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //-------------------------
        // Parte Centro - Campo
        JPanel campo = new JPanel(new GridLayout(2, 1, 5, 20));
        FieldPanel campo_p1 = new FieldPanel(p1);
        FieldPanel campo_p2 = new FieldPanel(p2);
        campo.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        campo.add(campo_p1);
        campo.add(campo_p2);
        campo.setBackground(Color.BLUE);
        //-------------------------
        centro.add(scroll_p1, BorderLayout.SOUTH);
        centro.add(scroll_p2, BorderLayout.NORTH);
        centro.add(campo, BorderLayout.CENTER);
        //-------------------------
        JPanel direita = new JPanel(new BorderLayout());
        // Parte Direita - Decks
        DeckPanel deck_p1 = new DeckPanel(p1);
        DeckPanel deck_p2 = new DeckPanel(p2);
        //-------------------------
        // Parte Direita - Carta
        infoCard = new CardInfoPanel();
        //-------------------------
        direita.add(deck_p1, BorderLayout.SOUTH);
        direita.add(infoCard, BorderLayout.CENTER);
        direita.add(deck_p2, BorderLayout.NORTH);

        infos.setBackground(Color.red);
        centro.setBackground(Color.green);
        
        frame.add(infos, BorderLayout.WEST);
        frame.add(centro, BorderLayout.CENTER);
        frame.add(direita, BorderLayout.EAST);
        
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
