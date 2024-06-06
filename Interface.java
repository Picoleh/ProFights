/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profights;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Lepec
 */
public class Interface{
    public static void CriaUI(Player p1, Player p2){
        JFrame frame = new JFrame();
        
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
        HandPanel hand_p1 = new HandPanel();
        JScrollPane scroll_p1 = new JScrollPane(hand_p1);
        scroll_p1.setBorder(null);
        scroll_p1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll_p1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        hand_p1.setBackground(Color.GREEN);
        //-------------------------
        // Parte Centro - Cartas p2
        JPanel cartas_p2 = new JPanel(new FlowLayout());
        //-------------------------
        // Parte Centro - Campo
        JPanel campo = new JPanel(new GridLayout(2, 1, 5, 20));
        // Parte Centro - Campo p1
        FieldPanel campo_p1 = new FieldPanel();
        FieldPanel campo_p2 = new FieldPanel();
        //-------------------------
        campo.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        campo.add(campo_p1);
        campo.add(campo_p2);
        campo.setBackground(Color.BLUE);
        
        
        centro.add(scroll_p1, BorderLayout.SOUTH);
        centro.add(cartas_p2, BorderLayout.NORTH);
        centro.add(campo, BorderLayout.CENTER);
        
        
        
        
        infos.setBackground(Color.red);
        centro.setBackground(Color.green);
        cartas_p2.setBackground(Color.orange);
        
        frame.add(infos, BorderLayout.WEST);
        frame.add(centro, BorderLayout.CENTER);
        
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
