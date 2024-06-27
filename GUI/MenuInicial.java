/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

import Logic.Sountrack;
import Models.CardModels.Card;
import Models.Player;

public class MenuInicial {
    private static JFrame frame;
    public static void CriaMenu(){
        try{
            Sountrack.playOST("Menu");
            frame = new JFrame();
            URL bg = MenuInicial.class.getResource("/GUI/UtilImages/bg3.gif");
            ImageIcon icon = new ImageIcon(bg);
            JLabel back = new JLabel();
            back.setLayout(new BorderLayout());
            back.setIcon(icon);
            icon.setImageObserver(back);
            back.setLayout(new BorderLayout());
            frame.add(back);
            JPanel buttons = new JPanel(new GridLayout(1,7));
            JPanel btts = new JPanel(new GridLayout(3,1));
            JButton bttPlay = new JButton();
            bttPlay.setIcon(new ImageIcon(Card.MudaTamanhoImagem(ImageIO.read(MenuInicial.class.getResource("/GUI/UtilImages/StartButton.png")), 0.08)));
            bttPlay.setBorderPainted(false);
            bttPlay.setContentAreaFilled(false);
            bttPlay.setFocusPainted(false);
            bttPlay.setOpaque(false);
            bttPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JButton bttHowToPlay = new JButton();
            bttHowToPlay.setIcon(new ImageIcon(Card.MudaTamanhoImagem(ImageIO.read(MenuInicial.class.getResource("/GUI/UtilImages/HowToButton.png")), 0.08)));
            bttHowToPlay.setBorderPainted(false);
            bttHowToPlay.setContentAreaFilled(false);
            bttHowToPlay.setFocusPainted(false);
            bttHowToPlay.setOpaque(false);
            bttHowToPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JButton bttExit = new JButton();
            bttExit.setIcon(new ImageIcon(Card.MudaTamanhoImagem(ImageIO.read(MenuInicial.class.getResource("/GUI/UtilImages/ExitButton.png")), 0.08)));
            bttExit.setBorderPainted(false);
            bttExit.setContentAreaFilled(false);
            bttExit.setFocusPainted(false);
            bttExit.setOpaque(false);
            bttExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JLabel logoP = new JLabel(new ImageIcon(MenuInicial.class.getResource("/GUI/UtilImages/JustLogo.png")));
            logoP.setSize(600, 300);

            btts.add(bttPlay);
            btts.add(new JLabel());
            btts.add(bttHowToPlay);
            btts.add(new JLabel());
            btts.add(bttExit);
            btts.add(new JLabel());

            bttPlay.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    String nomeP1 = "s", nomeP2 = "l";
                    nomeP1 = JOptionPane.showInputDialog(null, "Informe o nome Player 1: ", "", JOptionPane.INFORMATION_MESSAGE);
                    nomeP2 = JOptionPane.showInputDialog(null, "Informe o nome Player 2: ", "", JOptionPane.INFORMATION_MESSAGE);

                    Player p1 = new Player(nomeP1);
                    Player p2 = new Player(nomeP2);
                    frame.setVisible(false);
                    Sountrack.stopOST();
                    Interface.CriaUI(p1, p2);
                }
            });

            bttHowToPlay.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    frame.setVisible(false);
                    HowToPlay htp = new HowToPlay();
                    frame.setVisible(false);
                    htp.CriaTela();
                }
            });

            buttons.add(new JLabel());
            buttons.add(new JLabel());
            buttons.add(new JLabel());
            buttons.add(btts);
            buttons.add(new JLabel());
            buttons.add(new JLabel());
            buttons.add(new JLabel());

            buttons.setOpaque(false);
            btts.setOpaque(false);
            back.add(logoP, BorderLayout.CENTER);
            back.add(buttons, BorderLayout.SOUTH);

            frame.pack();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(3);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void MostraMenu(){
        frame.setVisible(true);
        Sountrack.playOST("Menu");
    }
}