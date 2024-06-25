package Logic;

import Excep.OutOfCardsException;
import Excep.PlayerAlreadyDrawedException;
import Excep.PlayerAlreadyUsedPowerUpException;
import GUI.Interface;
import Models.*;
import Models.CardModels.Card;
import Models.CardModels.DouglasCard;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Controller implements MouseListener, ActionListener {
    private Player activePlayer;
    private Player enemyPlayer;
    private Player p1,p2;
    private boolean playerDrawed=false,playerAttacked=false,playerUsedPower=false;

    public Controller(Player p1, Player p2){
        startGame(p1,p2);
        addAllListeners(p1,p2);
        this.p1 = p1;
        this.p2 = p2;
        Interface.HighlightsPlayer(p1,p1,p2);
    }

    public void addAllListeners(Player p1, Player p2){
//        ArrayList<HandCardButton> handP1 = activePlayer.hand.getListHand();
//        ArrayList<HandCardButton> handP2 = enemyPlayer.hand.getListHand();
//        ArrayList<FieldCardButton> fieldP1 = activePlayer.field.getListfield();
    }

    public void choseWhoStarts(Player p1, Player p2){
        Random r = new Random();

//        if (r.nextInt(2) == 0) {
//            activePlayer = p1;
//            enemyPlayer = p2;
//        } else {
//            activePlayer = p2;
//            enemyPlayer = p1;
//        }
        activePlayer = p1;
        enemyPlayer = p2;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource() instanceof HandCardButton handButton && handButton.getPai().playerAssociated == activePlayer) {
            handButton.select();
        }
        else if (e.getSource() instanceof FieldCardButton fieldButton) {
            if (fieldButton.playerAssociated == activePlayer) {
                if (activePlayer.hand.isAnySelected() && fieldButton.Pai.getCard() == null) {
                    fieldButton.Pai.addCard(activePlayer.hand.getSelectedCard());
                } else if (fieldButton.Pai.getCard() != null) {
                    if(e.getClickCount() == 2){
                        try {
                            if(playerUsedPower){
                                throw new PlayerAlreadyUsedPowerUpException();
                            }
                            int op = JOptionPane.showConfirmDialog(null, "Deseja ativar o poder de: " + fieldButton.Pai.getCard().nome);
                            if(op == JOptionPane.YES_OPTION){
                                playerUsedPower = true;
                                fieldButton.Pai.select(TypeSelection.POWERED);
                                fieldButton.Pai.getCard().Power();
                                if(fieldButton.Pai.getCard() instanceof DouglasCard) {
                                    fieldButton.Pai.updateImage();
                                }
                            }
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                    else{
                        fieldButton.Pai.select(TypeSelection.NORMAL);
                    }
                }
            } else { // PlayerAssociated == enemyPlayer
                if (fieldButton.Pai.getCard() != null && activePlayer.field.isAnySelected() && !playerAttacked) {
                    playerAttacked = activePlayer.field.getFieldSelected().attack(fieldButton.Pai);
                }
            }
        }
        else if (e.getSource() instanceof DeckCardButton deckButton && deckButton.playerAssociated == activePlayer) {
            try {
                if (deckButton.getCardsLeft() <= 0) {
                    throw new OutOfCardsException();
                }
                if (playerDrawed) {
                    throw new PlayerAlreadyDrawedException();
                }

                playerDrawed = true;
                activePlayer.DrawCard();
                deckButton.removeOneCard();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        else if (e.getSource() instanceof ChangeTurnButton btt) {
            System.out.println("Turnos Trocados");
            ChangeTurns();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() instanceof HandCardButton handButton){
            Interface.infoCard.setIcon(new ImageIcon(Card.MudaTamanhoImagem(handButton.getCard().img, 0.25)));
        }
        else if(e.getSource() instanceof FieldCardPanel fieldPanel && fieldPanel.getCard() != null){
            Interface.infoCard.setIcon(new ImageIcon(Card.MudaTamanhoImagem(fieldPanel.getCard().img, 0.25)));
        }
        else if(e.getSource() instanceof FieldCardButton fieldbtt && fieldbtt.Pai.getCard() != null){
            Interface.infoCard.setIcon(new ImageIcon(Card.MudaTamanhoImagem(fieldbtt.Pai.getCard().img, 0.25)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() instanceof HandCardButton handButton && handButton.getPai().playerAssociated == activePlayer){
            Interface.infoCard.setBackCardImg();
        }
    }

    public void startGame(Player p1, Player p2){
        choseWhoStarts(p1,p2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void ChangeTurns(){
        CalculateFinalDamage();

        Player aux = activePlayer;
        activePlayer = enemyPlayer;
        enemyPlayer = aux;

        activePlayer.hand.DeselectAll();
        activePlayer.field.DeselectAll();
        enemyPlayer.hand.DeselectAll();
        enemyPlayer.field.DeselectAll();

        playerDrawed = playerAttacked = playerUsedPower = false;

        Interface.HighlightsPlayer(activePlayer,p1,p2);
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public Player getEnemyPlayer(){
        return enemyPlayer;
    }

    private void CalculateFinalDamage(){
        int dmg = 0;
        for(FieldCardPanel f : activePlayer.field.getFieldList()){
            if(f.card != null)
                dmg += f.card.ATK;
        }

        enemyPlayer.vida -= dmg;
        Interface.updatesLifes(p1,p2);
    }
}
