package GUI;

import Models.*;

import javax.swing.*;

public class DeckPanel extends JPanel {
    DeckCardButton deckButton;
    public DeckPanel(Player player){
        this.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        deckButton = new DeckCardButton(player);
        this.add(deckButton);
    }
}
