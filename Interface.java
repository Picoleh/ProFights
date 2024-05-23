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
public class Interface{
    public static void CriaUI(Player p1, Player p2){
        JFrame frame = new JFrame();
        
        // Parte Esquerda - Infos
        JPanel infos = new JPanel(new GridLayout(3,1));
        JPanel info_p2 = new JPanel();
        JPanel turno = new JPanel();
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
        turno.add(btt_encerrarTurno);
        
        infos.add(info_p2);
        infos.add(turno);
        infos.add(info_p1);
        // ------------------------
        JPanel centro = new JPanel();
        JPanel cartas_p1 = new JPanel();
        JPanel cartas_p2 = new JPanel();
        
        infos.setBackground(Color.red);
        centro.setBackground(Color.green);
        cartas_p1.setBackground(Color.blue);
        cartas_p2.setBackground(Color.orange);
        
        frame.add(infos, BorderLayout.WEST);
        frame.add(centro, BorderLayout.CENTER);
        frame.add(cartas_p1, BorderLayout.SOUTH);
        frame.add(cartas_p2, BorderLayout.NORTH);
        
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
