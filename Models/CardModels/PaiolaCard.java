package Models.CardModels;

import GUI.Interface;
import Models.FieldCardButton;
import Models.FieldCardPanel;
import Models.Location;
import Models.NomeCarta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaiolaCard extends Card{
    public PaiolaCard(Location location, Image img){
        super(NomeCarta.Paiola,location,img,64,55);
    }

    public void Power(){
        JFrame f = new JFrame();
        JPanel field = new JPanel(new GridLayout(2,5,5,5));
        field.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        for(FieldCardPanel panel : Interface.controller.getActivePlayer().field.getFieldList()){
            FieldCardPanel aux = new FieldCardPanel(panel);
            aux.btt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getSource() instanceof FieldCardButton fieldButton){
                        panel.card.VIDA += 70;
                        panel.updateLife();
                        f.dispose();
                    }
                }
            });
            field.add(aux);
        }

        f.add(field, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
