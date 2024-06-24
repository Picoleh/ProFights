package Models;

import GUI.FieldPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class FieldCardPanel extends JPanel {
    public Card card;
    public FieldCardButton btt;
    public JProgressBar Vida;
    public boolean isSelected;
    private FieldPanel pai;
    public Player playerAssociated;

    public FieldCardPanel(Player player, FieldPanel pai){
        super(new BorderLayout());
        this.pai = pai;
        playerAssociated = player;
        isSelected = false;
        card = null;
        btt = new FieldCardButton(player, this);
        Vida = new JProgressBar();
        configuraLifeBar();
        this.add(btt, BorderLayout.CENTER);
        this.add(Vida, BorderLayout.SOUTH);
        this.setBackground(Color.PINK);
    }

    public void configuraLifeBar(){
        Vida.setMaximum(100);
        Vida.setMinimum(0);
        Vida.setUI(new BasicProgressBarUI(){
            protected Color getSelectionForeground() { return Color.BLACK; }
            protected Color getSelectionBackground() { return Color.BLACK; }
        });
    }

    public void addCard(Card c){
        card = c;
        btt.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.08)));
        updateLife();
        Vida.setBackground(Color.RED);
        Vida.setForeground(Color.GREEN);
        Vida.setStringPainted(true);
    }

    public void updateLife(){
        if(card.VIDA <= 0){
            card = null;
            btt.setIcon(null);
            Vida.setBackground(Color.gray);
            Vida.setStringPainted(false);
            Vida.setValue(0);
            configuraLifeBar();
        }
        else{
            Vida.setValue(card.VIDA);
        }
    }

    public void select(TypeSelection typeSelection){
        if(!pai.getFieldList().stream().filter(x -> x.isSelected && x == this).toList().isEmpty()){
            pai.DeselectAll();
        }
        else{
            pai.DeselectAll();
            this.isSelected = true;
            btt.setBorder(new LineBorder(Color.RED, 3));
        }

        if(typeSelection == TypeSelection.POWERED){
            btt.setBorder(new LineBorder(Color.MAGENTA,5));
        }
    }

    public Card getCard(){
        return card;
    }

    public void attack(FieldCardPanel opponent){
        opponent.getCard().VIDA -= card.ATK;
        opponent.updateLife();
    }
}
