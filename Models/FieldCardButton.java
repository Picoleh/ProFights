package Models;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FieldCardButton extends JButton {
    public Card card;
    public FieldCardButton(Player player){
        super("",null);
        card = null;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Card c = player.hand.getSelectedCard();
                if(c != null)
                    addCard(c);
            }
        });
    }

    public void addCard(Card c){
        card = c;
        this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.2)));
        this.setText(String.valueOf(c.VIDA));
        this.setHorizontalTextPosition(JButton.BOTTOM);
    }
}
