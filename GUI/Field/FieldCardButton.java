package GUI.Field;

import Models.Player;

import javax.swing.*;

public class FieldCardButton extends JButton {
    public Player playerAssociated;
    public FieldCardPanel Pai;
    public FieldCardButton(Player player, FieldCardPanel pai){
        playerAssociated = player;
        Pai = pai;
    }
}
