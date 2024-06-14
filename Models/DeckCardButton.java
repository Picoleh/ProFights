package Models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckCardButton extends JButton {
    private int qtd;
    public DeckCardButton(Player player){
        qtd = 20;
        setBackCardImg();
        updateQtd();
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setFont(new Font("Arial",Font.BOLD, 22));
        this.setForeground(Color.WHITE);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(qtd > 0){
                    player.DrawCard();
                    qtd--;
                    updateQtd();
                }
                else{
                    //TODO exception no more Cards
                }
            }
        });
    }

    private void updateQtd(){
        this.setText(String.valueOf(qtd));
    }

    public void setBackCardImg(){
        try{
            Image imgBackCard = ImageIO.read(getClass().getResource("/GUI/Cards/Back.jpg"));
            this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(imgBackCard, 0.04)));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
