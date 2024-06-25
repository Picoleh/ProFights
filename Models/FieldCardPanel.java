package Models;

import GUI.FieldPanel;
import Models.CardModels.Card;

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

    public FieldCardPanel(FieldCardPanel copy){
        super(new BorderLayout());
        this.card = copy.card;
        btt = new FieldCardButton(this.playerAssociated, this);
        Vida = new JProgressBar();
        configuraLifeBar();
        this.add(btt, BorderLayout.CENTER);
        this.add(Vida, BorderLayout.SOUTH);
        this.setBackground(Color.PINK);
        if(card != null){
            updateLife();
            addCard(card);
        }
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
        updateImage();
        updateLife();
        Vida.setBackground(Color.RED);
        Vida.setForeground(Color.GREEN);
        Vida.setStringPainted(true);
    }

    public void updateImage(){
        btt.setIcon(new ImageIcon(Card.MudaTamanhoImagem(card.img,0.08)));
        btt.revalidate();
        btt.repaint();
    }

    public void removeCard(){
        card = null;
        btt.setIcon(null);
        Vida.setBackground(Color.WHITE);
        Vida.setStringPainted(false);
        Vida.setValue(0);
        configuraLifeBar();
    }

    public void updateLife(){
        if(card.VIDA <= 0){
            removeCard();
        }
        else{
            if(card.VIDA > 100)
                card.VIDA -= card.VIDA - 100;
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
            this.isSelected = true;
            btt.setBorder(new LineBorder(Color.MAGENTA,5));
        }
    }

    public Card getCard(){
        return card;
    }

    public boolean attack(FieldCardPanel opponent){
        System.out.println("Atacando: " + card.nome + " bATK: " + card.ATK + " eATK: " + card.getATK());
        System.out.println("Defendendo: " + opponent.getCard().nome + " bDEF: " + opponent.getCard().DEF + " eDEF: " + opponent.getCard().getDEF());
        opponent.getCard().VIDA -= (int)(card.getATK() * ((100 -opponent.getCard().getDEF()) / 100.0));
        opponent.updateLife();
        return card.ATK != 0;
    }
}
