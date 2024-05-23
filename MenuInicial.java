/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Lepec
 */
public class MenuInicial {
    public static void CriaMenu(){
        JFrame frame = new JFrame();
        JPanel buttons = new JPanel(new GridLayout(1,7));
        JPanel btts = new JPanel(new GridLayout(6, 1));
        JButton bttPlay = new JButton("Jogar");
        JButton bttHowToPlay = new JButton("Como Jogar");
        JButton bttExit = new JButton("Sair");
        
        btts.add(bttPlay);
        btts.add(new JLabel());
        btts.add(bttHowToPlay);
        btts.add(new JLabel());
        btts.add(bttExit);
        btts.add(new JLabel());
        
        bttPlay.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                String nomeP1, nomeP2;
                nomeP1 = JOptionPane.showInputDialog(null, "Informe o nome Player 1: ", "", JOptionPane.INFORMATION_MESSAGE);
                nomeP2 = JOptionPane.showInputDialog(null, "Informe o nome Player 2: ", "", JOptionPane.INFORMATION_MESSAGE);
                
                Player p1 = new Player(nomeP1);
                Player p2 = new Player(nomeP2);
                Interface.CriaUI(p1, p2);
            }
        });
        
        buttons.add(new JLabel());
        buttons.add(new JLabel());
        buttons.add(new JLabel());
        buttons.add(btts);
        buttons.add(new JLabel());
        buttons.add(new JLabel());
        buttons.add(new JLabel());
        
        frame.add(buttons, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
    
}
