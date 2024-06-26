package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CustomJPanel extends JPanel {
    private Image img;
    public CustomJPanel(URL url){
        try {
            this.img = ImageIO.read(url);
        }catch (Exception ex){
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0,0,null);
    }
}
