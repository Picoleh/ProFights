/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.*;

import Logic.Controller;
import Models.*;
import Models.CardModels.Card;

public class Interface{
    public static JFrame frame;
    public static CardInfoPanel infoCard;
    public static Controller controller;
    public static JLabel nome_p1,vida_p1,nome_p2,vida_p2;

    public static void CriaUI(Player p1, Player p2){
        frame = new JFrame();

        // Parte Esquerda - Infos
        JPanel infos = new JPanel(new BorderLayout());
        JPanel info_p2 = new JPanel(new GridLayout(2,1,10,10));
        JPanel turno = new JPanel(new GridLayout(7, 1));
        JPanel info_p1 = new JPanel(new GridLayout(2,1,10,10));
        nome_p1 = new JLabel(p1.nome);
        nome_p1.setHorizontalAlignment(JLabel.CENTER);
        vida_p1 = new JLabel();
        nome_p2 = new JLabel(p2.nome);
        nome_p2.setHorizontalAlignment(JLabel.CENTER);
        vida_p2 = new JLabel();
        updatesLifes(p1,p2);


        ChangeTurnButton btt_encerrarTurno = new ChangeTurnButton("Encerrar Turno");
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
//        FieldPanel campo_p1 = new FieldPanel(p1);
//        FieldPanel campo_p2 = new FieldPanel(p2);
        campo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        campo.add(p2.field);
        campo.add(p1.field);
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

        controller = new Controller(p1,p2);
        btt_encerrarTurno.addMouseListener(controller);
        deck_p1.deckButton.addMouseListener(controller);
        deck_p2.deckButton.addMouseListener(controller);
        for(FieldCardPanel x : p1.field.getFieldList()){
            x.addMouseListener(controller);
            x.btt.addMouseListener(controller);
        }
        for(FieldCardPanel x : p2.field.getFieldList()){
            x.addMouseListener(controller);
            x.btt.addMouseListener(controller);
        }


        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void HighlightsPlayer(Player active, Player p1, Player p2){
        if(active == p1){
            nome_p1.setFont(new Font("Arial",Font.BOLD, 22));
            vida_p1.setFont(new Font("Arial",Font.BOLD, 22));
            nome_p2.setFont(new Font("Arial",Font.BOLD, 12));
            vida_p2.setFont(new Font("Arial",Font.BOLD, 12));
        }
        else{
            nome_p2.setFont(new Font("Arial",Font.BOLD, 22));
            vida_p2.setFont(new Font("Arial",Font.BOLD, 22));
            nome_p1.setFont(new Font("Arial",Font.BOLD, 12));
            vida_p1.setFont(new Font("Arial",Font.BOLD, 12));
        }
    }

    public static void updatesLifes(Player p1, Player p2){
        Interface.vida_p1.setText("Vida: " + p1.vida);
        Interface.vida_p2.setText("Vida: " + p2.vida);
        checkWinsConditions(p1,p2);
    }

    public static void checkWinsConditions(Player p1, Player p2){
        if(p1.vida <= 0){
            showWinner(p2, false);
        }
        else if(p2.vida <= 0){
            showWinner(p1, false);
        }


        Set<NomeCarta> set = new HashSet<>();
        p1.cards.stream().filter(x -> x.location == Location.FIELD && set.add(x.nome));

        if(set.size() >= 4){
            showWinner(p1,true);
        }

        set.clear();
        p2.cards.stream().filter(x -> x.location == Location.FIELD && set.add(x.nome));
        if(set.size() >= 4){
            showWinner(p2, true);
        }

    }

    private static void showWinner(Player winner, boolean isWinByExodia){
        String exodia = "";
        if(isWinByExodia)
            exodia = "O Recogna foi montado....\nNão há como evitar a derrota...";
        JOptionPane.showMessageDialog(null, winner.nome + " GANHOU!!!!\n" + exodia);
        frame.dispose();
        MenuInicial.MostraMenu();
    }
}
