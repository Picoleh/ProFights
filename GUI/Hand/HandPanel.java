/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Hand;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import GUI.CustomJPanel;
import GUI.Interface;
import Models.*;
import Models.CardModels.*;


public class HandPanel extends CustomJPanel {
    public Player playerAssociated;
    private ArrayList<HandCardButton> listButton;
    public HandPanel(Player player, URL opa){
        super(opa);
        listButton = new ArrayList<>();
        this.playerAssociated = player;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void update(){
        this.removeAll();
        listButton.clear();
        for(Card c : playerAssociated.cards){
            if(c.location == Location.HAND){
                HandCardButton cb = new HandCardButton(c,this);
                cb.addMouseListener(Interface.controller);
                this.add(cb);
                listButton.add(cb);
            }
        }

        Interface.frame.revalidate();
        Interface.frame.repaint();
    }

    public void DeselectAll(){
        for(HandCardButton c : listButton){
            c.setMargin(new Insets(0,0,0,0));
            c.setBorder(null);
            c.isSelected = false;
        }
    }

    public Card getSelectedCard(){
        for(HandCardButton c : listButton){
            if(c.isSelected){
                c.getCard().location = Location.FIELD;
                update();
                return c.getCard();
            }
        }
        return null;
    }

    public boolean isAnySelected(){
        for(HandCardButton c : listButton){
            if(c.isSelected){
                return true;
            }
        }
        return false;
    }

    public void addRandomCardToHand(){
        Random rd = new Random();
        NomeCarta nomeEnum = NomeCarta.values()[rd.nextInt(1,NomeCarta.values().length - 2)];
        Image img = null;
        String url = "/GUI/Cards/"+nomeEnum+".jpeg";
        try{
            img = ImageIO.read(getClass().getResource(url));
        }catch(Exception ex){
            System.out.println(ex);
        }
        Card c = switch (nomeEnum) {
            case Perea -> new PereaCard(Location.HAND, img);
            case Adriana -> new AdrianaCard(Location.HAND, img);
            case Fabiano -> new FabianoCard(Location.HAND, img);
            case Papa -> new PapaCard(Location.HAND, img);
            case Paiola -> new PaiolaCard(Location.HAND, img);
            case AparecidoNilceu -> new NilceuCard(Location.HAND,img);
            case Krayton -> new KraytonCard(Location.HAND,img);
            case Hercules -> new HerculesCard(Location.HAND,img);
            case Douglas -> new DouglasCard(Location.HAND,img);
            default -> null;
        };
        playerAssociated.cards.add(c);
        update();
    }

    public void addCardToHand(NomeCarta nome){
        String url = "/GUI/Cards/"+nome+".jpeg";
        Image img = null;
        try{
            img = ImageIO.read(getClass().getResource(url));
        }catch(Exception ex){
            System.out.println(ex);
        }

        Card c = switch (nome) {
            case Perea -> new PereaCard(Location.HAND, img);
            case Adriana -> new AdrianaCard(Location.HAND, img);
            case Fabiano -> new FabianoCard(Location.HAND, img);
            case Papa -> new PapaCard(Location.HAND, img);
            case Paiola -> new PaiolaCard(Location.HAND, img);
            case AparecidoNilceu -> new NilceuCard(Location.HAND,img);
            case Krayton -> new KraytonCard(Location.HAND,img);
            case Hercules -> new HerculesCard(Location.HAND,img);
            case Douglas -> new DouglasCard(Location.HAND,img);
            case Cachorro -> new CachorroCard(Location.HAND, img);
            case LambretaRoxa -> new LambretaRoxaCard(Location.HAND, img);
            default -> null;
        };

        playerAssociated.cards.add(c);
        update();
    }

    public ArrayList<HandCardButton> getListHand(){
        return listButton;
    }
}