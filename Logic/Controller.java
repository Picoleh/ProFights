package Logic;

import Excep.*;
import GUI.*;
import GUI.Deck.*;
import GUI.Field.*;
import GUI.Hand.*;
import Models.*;
import Models.CardModels.*;
import Models.EffectsModels.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Controller implements MouseListener, ActionListener {
    private Player activePlayer;
    private Player enemyPlayer;
    private Player p1,p2;
    private boolean playerDrawed=false,playerUsedPower=false;
    public int attacksLeft = 3;

    public Controller(Player p1, Player p2){
        startGame(p1,p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    public void choseWhoStarts(Player p1, Player p2){
        Random r = new Random();
        if (r.nextInt(2) == 0) {
            activePlayer = p1;
            enemyPlayer = p2;
        } else {
            activePlayer = p2;
            enemyPlayer = p1;
        }
        Interface.HighlightsPlayer(activePlayer);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource() instanceof HandCardButton handButton && handButton.getPai().playerAssociated == activePlayer) { // Sua carta na mao
            handButton.select();
        }
        else if (e.getSource() instanceof FieldCardButton fieldButton && fieldButton.isEnabled()) {
            if(e.getButton() == MouseEvent.BUTTON3){
                String str = "";
                for(Effect effect : fieldButton.Pai.getCard().efeitosAtivos){
                    str += effect.turnosRestantes + " turno(s) restante de " + effect.value + " " + effect.type.toString() + "\n";
                }
                if(str.isEmpty())
                    str = "Não há efeitos ativos nessa carta";

                JOptionPane.showMessageDialog(null, str);
            }
            else {
                if (fieldButton.playerAssociated == activePlayer) { // Sua carta no campo
                    if (PodeColocarCartaCampo(fieldButton)) { // colocar carta campo
                        fieldButton.Pai.addCard(activePlayer.hand.getSelectedCard());
                        Interface.checkWinsConditions(p1, p2);
                    } else if (fieldButton.Pai.getCard() != null) { // Selecionar carta seu campo
                        if (e.getClickCount() == 2) {
                            try {
                                if (playerUsedPower) {
                                    throw new PlayerAlreadyUsedPowerUpException();
                                }
                                int op = JOptionPane.showConfirmDialog(null, "Deseja ativar o poder de: " + fieldButton.Pai.getCard().nome);
                                if (op == JOptionPane.YES_OPTION) {
                                    playerUsedPower = true;
                                    fieldButton.Pai.select(TypeSelection.POWERED);
                                    fieldButton.Pai.getCard().Power();
                                    if (fieldButton.Pai.getCard() instanceof DouglasCard || fieldButton.Pai.getCard() instanceof NilceuCard) {
                                        fieldButton.Pai.updateImage();
                                    }
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        } else {
                            fieldButton.Pai.select(TypeSelection.NORMAL);
                        }
                    }
                } else { // Carta oponente
                    if (PodeAtacar(fieldButton)) {
                        boolean attacked = activePlayer.field.getFieldSelected().attack(fieldButton.Pai);
                        if (attacked) {
                            SoundEffects.playOST("Hit");
                            attacksLeft--;
                            activePlayer.field.getFieldSelected().getCard().attacked = true;
                        }
                    }
                }
            }
        }
        else if (e.getSource() instanceof DeckCardButton deckButton && deckButton.playerAssociated == activePlayer) { // Sacar carta
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void startGame(Player p1, Player p2){
        choseWhoStarts(p1,p2);
    }

    public void ChangeTurns(){
        CalculateFinalDamage();
        updateEffects(activePlayer);
        Player aux = activePlayer;
        activePlayer = enemyPlayer;
        enemyPlayer = aux;

        checkEffects(activePlayer);

        activePlayer.hand.DeselectAll();
        activePlayer.field.DeselectAll();
        enemyPlayer.hand.DeselectAll();
        enemyPlayer.field.DeselectAll();

        playerDrawed = playerUsedPower = false;
        attacksLeft = 3;

        Interface.HighlightsPlayer(activePlayer);
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

    private void updateEffects(Player activePlayer){
        for(Card c : activePlayer.cards){
            for(Effect e : c.efeitosAtivos){
                e.passaTurno();
            }
            c.efeitosAtivos.removeIf(x -> x.turnosRestantes <= 0);
            if(c.nome == NomeCarta.AparecidoNilceu && c.efeitosAtivos.stream().noneMatch(x -> x.type == EffectsType.Deffense && x.value == 30)){
                NilceuCard c1 = (NilceuCard) c;
                c1.endPower();
                for(FieldCardPanel f : activePlayer.field.getFieldList()){
                    if(f.getCard() == c){
                        f.updateImage();
                        break;
                    }
                }
            }

            c.attacked = false;
        }
    }

    private void checkEffects(Player activePlayer){
        for(FieldCardPanel f : activePlayer.field.getFieldList()){
            if(f.card != null){
                boolean opa = f.card.getEnable();
                f.setEnabled(opa);
                f.btt.setEnabled(opa);
            }
        }
    }


    // Condições cliques
    public boolean PodeColocarCartaCampo(FieldCardButton fieldButton){
        return activePlayer.hand.isAnySelected() && fieldButton.Pai.getCard() == null;
    }

    public boolean PodeAtacar(FieldCardButton fieldButton){
        return fieldButton.Pai.getCard() != null && activePlayer.field.isAnySelected() && !activePlayer.field.getFieldSelected().getCard().attacked && attacksLeft > 0;
    }
}