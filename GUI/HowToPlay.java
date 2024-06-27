package GUI;

import Models.CardModels.*;
import Models.Location;
import Models.NomeCarta;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class HowToPlay {

    public class CardPanel extends JPanel{
        public CardPanel(Card c, JFrame f){
            super(new BorderLayout());
            JPanel img = new JPanel();
            JPanel desc = new JPanel();
            JPanel atributos = new JPanel();

            img.setOpaque(false);
            desc.setOpaque(false);
            atributos.setOpaque(false);

            JLabel auxImg = new JLabel(new ImageIcon(Card.MudaTamanhoImagem(c.img,0.07)));

            JTextArea d = new JTextArea(c.getDescription());
            d.setEditable(false);
            d.setColumns(30);
            d.setLineWrap(true);
            d.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel a = new JLabel("ATK: " + c.ATK + "\n  DEF: " + c.DEF);
            a.setFont(new Font("Arial", Font.BOLD, 20));

            img.add(auxImg);
            desc.add(d);
            atributos.add(a);

            JPanel da = new JPanel(new GridLayout(1,2));
            da.setOpaque(false);
            da.add(desc);
            da.add(atributos);

            this.add(img, BorderLayout.WEST);
            this.add(da, BorderLayout.CENTER);
            this.setPreferredSize(new Dimension(f.getWidth(), f.getHeight()));
        }
    }

    public void CriaTela(){
        JFrame frame = new JFrame();
        CustomJPanel tudo = new CustomJPanel((getClass().getResource("/GUI/UtilImages/FundoHowToPlay.jpg")));
        tudo.setLayout(new BorderLayout());

        JPanel expliJogo = new JPanel();
        expliJogo.setOpaque(false);

        JTextArea expli = new JTextArea("ProFights é um jogo em turnos onde vence o jogador que diminuir a vida do oponente a zero. Por turno," +
                " pode-se comprar uma carta, posicionar quantas cartas quiser no campo e atacar com três delas, há também como ativar um " +
                "poder especial de alguma carta. A cada final de turno, todas as suas cartas atacam o oponente.");
        expli.setFont(new Font("Arial", Font.PLAIN, 26));
        expli.setEditable(false);
        expli.setColumns(85);
        expli.setLineWrap(true);
        expliJogo.add(expli);

        JPanel cartas = new JPanel(new GridLayout((NomeCarta.values().length-6), 2,1,1));
        cartas.setOpaque(false);

        for(NomeCarta nome : Arrays.stream(NomeCarta.values()).filter(x -> x != NomeCarta.None).toList()){
            Image img = null;
            String url = "/GUI/Cards/"+nome+".jpeg";
            try{
                img = ImageIO.read(HowToPlay.class.getResource(url));
            }catch(Exception ex){
                System.out.println(ex);
            }
            Card c = switch (nome) {
                case Perea -> new PereaCard(Location.DECK, img);
                case Adriana -> new AdrianaCard(Location.DECK, img);
                case Fabiano -> new FabianoCard(Location.DECK, img);
                case Papa -> new PapaCard(Location.DECK, img);
                case Paiola -> new PaiolaCard(Location.DECK, img);
                case AparecidoNilceu -> new NilceuCard(Location.DECK,img);
                case Krayton -> new KraytonCard(Location.DECK,img);
                case Hercules -> new HerculesCard(Location.DECK,img);
                case Douglas -> new DouglasCard(Location.DECK,img);
                case Cachorro -> new CachorroCard(Location.DECK, img);
                case LambretaRoxa -> new LambretaRoxaCard(Location.DECK, img);
                default -> null;
            };

            CardPanel x = new CardPanel(c,frame);
            x.setBorder(new LineBorder(Color.BLACK,1));
            x.setOpaque(false);
            cartas.add(x);
        }

        tudo.add(expliJogo, BorderLayout.NORTH);


        JScrollPane bar = new JScrollPane(cartas);
        bar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        bar.setOpaque(false);

        tudo.add(cartas, BorderLayout.CENTER);


        frame.add(tudo, BorderLayout.CENTER);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                MenuInicial.MostraMenu();
            }
        });
    }
}
