
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.*;

import GUI.Deck.DeckPanel;
import GUI.Field.FieldCardPanel;
import Logic.Controller;
import Logic.Sountrack;
import Models.*;
import Models.CardModels.Card;

public class Interface{
    public static JFrame frame;
    public static CardInfoPanel infoCard;
    public static Controller controller;
    public static JLabel nome_p1,vida_p1,nome_p2,vida_p2,vezDe;

    public static void CriaUI(Player p1, Player p2){
        Sountrack.playOST("Battle");
        frame = new JFrame();
        CustomJPanel tudo = new CustomJPanel((Interface.class.getResource("/GUI/UtilImages/wood.png")));
        tudo.setLayout(new BorderLayout());
        // Parte Esquerda - Infos
        JPanel infos = new JPanel(new BorderLayout());
        JPanel info_p2 = new JPanel(new GridLayout(2,1,10,10));
        JPanel turno = new JPanel(new GridLayout(13, 1));
        turno.setPreferredSize(new Dimension(250,frame.getHeight()));
        JPanel info_p1 = new JPanel(new GridLayout(2,1,10,10));

        nome_p1 = new JLabel(p1.nome);
        nome_p1.setHorizontalAlignment(JLabel.CENTER);
        nome_p1.setForeground(Color.ORANGE);
        nome_p1.setFont(new Font("Arial", Font.BOLD, 26));

        vida_p1 = new JLabel();
        vida_p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        vida_p1.setFont(new Font("Arial", Font.BOLD, 24));

        nome_p2 = new JLabel(p2.nome);
        nome_p2.setHorizontalAlignment(JLabel.CENTER);
        nome_p2.setForeground(Color.ORANGE);
        nome_p2.setFont(new Font("Arial", Font.BOLD, 26));

        vida_p2 = new JLabel();
        vida_p2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        vida_p2.setFont(new Font("Arial", Font.BOLD, 24));

        updatesLifes(p1,p2);

        ChangeTurnButton btt_encerrarTurno = new ChangeTurnButton("<html>Encerrar<br> Turno</html>");
        JPanel flowTurno = new JPanel(new GridLayout(1,3));
        flowTurno.add(new JLabel());
        flowTurno.add(btt_encerrarTurno);
        flowTurno.add(new JLabel());
        info_p1.add(nome_p1);
        info_p1.add(vida_p1);
        info_p2.add(vida_p2);
        info_p2.add(nome_p2);
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(new JLabel());
        turno.add(flowTurno);
        vezDe = new JLabel();
        vezDe.setFont(new Font("Arial", Font.BOLD, 28));
        vezDe.setForeground(Color.WHITE);
        turno.add(vezDe);

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

        turno.setOpaque(false);
        info_p1.setOpaque(false);
        info_p2.setOpaque(false);
        flowTurno.setOpaque(false);
        campo.setOpaque(false);
        deck_p1.setOpaque(false);
        deck_p2.setOpaque(false);
        infos.setOpaque(false);
        centro.setOpaque(false);
        direita.setOpaque(false);

        tudo.add(infos, BorderLayout.WEST);
        tudo.add(centro, BorderLayout.CENTER);
        tudo.add(direita, BorderLayout.EAST);

        frame.add(tudo, BorderLayout.CENTER);

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
        vezDe.setText("Vez de: " + active.nome);
    }

    public static void updatesLifes(Player p1, Player p2){
        vida_p1.setText("Vida: " + p1.vida);
        if(p1.vida > 3500)
            vida_p1.setForeground(Color.GREEN);
        else if (p1.vida > 1500) {
            vida_p1.setForeground(Color.ORANGE);
        }
        else{
            vida_p1.setForeground(Color.RED);
        }

        if(p2.vida > 3500)
            Interface.vida_p2.setForeground(Color.GREEN);
        else if (p2.vida > 1500) {
            Interface.vida_p2.setForeground(Color.ORANGE);
        }
        else{
            Interface.vida_p2.setForeground(Color.RED);
        }
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
        for(Card c : p1.cards){
            if(c.location == Location.FIELD && (c.nome == NomeCarta.Douglas  || c.nome == NomeCarta.Paiola   ||
                                                c.nome == NomeCarta.Papa     || c.nome == NomeCarta.Krayton)){
                set.add(c.nome);
            }
        }


        if(set.size() >= 4){
            showWinner(p1,true);
        }

        set.clear();
        for(Card c : p2.cards){
            if(c.location == Location.FIELD && (c.nome == NomeCarta.Douglas  || c.nome == NomeCarta.Paiola   ||
                                                c.nome == NomeCarta.Papa     || c.nome == NomeCarta.Krayton)){
                set.add(c.nome);
            }
        }
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
        Sountrack.stopOST();
        MenuInicial.MostraMenu();
    }
}
