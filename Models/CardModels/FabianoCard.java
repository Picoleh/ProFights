package Models.CardModels;

import GUI.Interface;
import Models.EffectsModels.Effect;
import Models.EffectsModels.EffectsType;
import GUI.Field.FieldCardButton;
import GUI.Field.FieldCardPanel;
import Models.EffectsModels.SoundEffects;
import Models.Location;
import Models.NomeCarta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FabianoCard extends Card{
    public FabianoCard(Location location, Image img){
        super(NomeCarta.Fabiano,location,img,59,26);
    }

    public void Power(){
        JFrame f = new JFrame();
        JPanel field = new JPanel(new GridLayout(2,5,5,5));
        field.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        for(FieldCardPanel panel : Interface.controller.getEnemyPlayer().field.getFieldList()){
            FieldCardPanel aux = new FieldCardPanel(panel);
            aux.btt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getSource() instanceof FieldCardButton fieldButton){
                        fieldButton.Pai.card.efeitosAtivos.add(new Effect(1, EffectsType.Enable,0));
                        SoundEffects.playOST("FabianoPower");
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

    public void tocaAudioMorte(){
        SoundEffects.playOST("MaleOut");
    }

    public String getDescription(){
        return "Fabiano possui um grande poder, ele coloca os inimigo para dormir, os fazendo incapazes de realizar qualquer acao.";
    }
}