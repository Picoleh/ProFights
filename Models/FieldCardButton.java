package Models;

import javax.swing.*;

public class FieldCardButton extends JButton {
    public Card card;
    public FieldCardButton(Player player){
        super("",null);
        card = null;
    }

    public void addCard(Card c){
        this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.2)));
        this.setText(String.valueOf(c.VIDA));
        this.setHorizontalTextPosition(JButton.BOTTOM);
        card = c;
    }
}
