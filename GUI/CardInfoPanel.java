package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import Models.Card;

public class CardInfoPanel extends JLabel {
    public CardInfoPanel(){
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBackground(Color.PINK);
        setBackCardImg();
    }

    public void setBackCardImg(){
        try{
            Image imgBackCard = ImageIO.read(getClass().getResource("/GUI/Cards/Back.jpg"));
            this.setIcon(new ImageIcon(Card.MudaTamanhoImagem(imgBackCard, 0.25)));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
