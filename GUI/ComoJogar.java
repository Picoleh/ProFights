package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

import Logic.Sountrack;
import Models.CardModels.Card;
import Models.Player;

public class ComoJogar{

    public static JFrame frameHTP;

    public static void CriaComoJogar(){
        JLabel instructions = new JLabel("ProFights eh um jogo de batalha de cartas. Nele, voce pode usar os poderes unicos de cada carta, e atacar com elas. Cada jogador pode utilizar 1 poder e 3 ataques por turno. Ao derrotar uma carta, o dano sobressalente vai para o jogador. Ganha o jogador que tirar toda a vida do outro.");
        JPanel adriana = new JPanel(new GridLayout(1,2));
        JPanel douglas = new JPanel(new GridLayout(1,2));
        JPanel fabiano = new JPanel(new GridLayout(1,2));
        JPanel hercules = new JPanel(new GridLayout(1,2));
        JPanel krayton = new JPanel(new GridLayout(1,2));
        JPanel nilceu = new JPanel(new GridLayout(1,2));
        JPanel paiola = new JPanel(new GridLayout(1,2));
        JPanel papa = new JPanel(new GridLayout(1,2));
        JPanel perea = new JPanel(new GridLayout(1,2));
        JPanel invocations = new JPanel(new GridLayout(1,2));

        JPanel imgAdriana = new JPanel();
        JPanel imgDouglasATK = new JPanel();
        JPanel imgDouglasDEF = new JPanel();
        JPanel imgDouglas = new JPanel(new GridLayout(1,2));
        JPanel imgFabiano = new JPanel();
        JPanel imgHercules = new JPanel();
        JPanel imgKrayton = new JPanel();
        JPanel imgNilceuNormal = new JPanel();
        JPanel imgNilceuMaromba = new JPanel();
        JPanel imgNilceu = new JPanel(new GridLayout(1,2));
        JPanel imgPaiola = new JPanel();
        JPanel imgPapa = new JPanel();
        JPanel imgPerea = new JPanel();
        JPanel imgInvocationsDog = new JPanel();
        JPanel imgInvocationsLambreta = new JPanel();
        JPanel imgInvocations = new JPanel(new GridLayout(1,2));

        JLabel instAdriana = new JLabel("Adriana eh uma carta fraca, mas possui um grande poder: invocar seus cachorros que sabem calculo integral.");
        JLabel instDouglas = new JLabel("Douglas possui dois modos: ATK, o qual ele da bastante dano, mas possui pouca defesa; e DEF, o qual ele nao ataca, mas pode tankar quase todos os golpes.");
        JLabel instFabiano = new JLabel("Fabiano possui um grande poder, ele coloca os inimigo para dormir, os fazendo incapazes de realizar qualquer acao.");
        JLabel instHercules = new JLabel("Hercules eh uma carta fraca, mas possui um grande poder: invocar sua lambreta roxa.");
        JLabel instKrayton = new JLabel("Krayton eh uma carta diferente, ao contrario das outras, ele pode retornar a mao do jogador. Ao fazer isso, ele recupera vida.");
        JLabel instNilceu = new JLabel("Nilceu parece uma carta fraca, de inicio. Porem, ao usar seu poder, ele fica extremamente poderoso. Seu ataque e sua defesa o tornam imbativel.");
        JLabel instPaiola = new JLabel("Paiola eh uma das cartas mais importantes do jogo. Seu poder eh unico, podendo curar outras cartas. Pode ser usado estrategicamente em diversas situacoes.");
        JLabel instPapa = new JLabel("A carta Papa eh parecida com a de outros invocadores, porem, mais poderosa. Papa pode invocar uma carta do deck, alem de ter ataque e defesa altos.");
        JLabel instPerea = new JLabel("A carta do Perea pode ser utilizada de forma muito estrategica. Ele pode diminuir a defesa do alvo, ao utilizar seu poder.");
        JLabel instInvocations = new JLabel("Cartas invocacoes nao possuem nenhum poder especial. Elas apenas causam dano, ou tankam dano.");

        JLabel nameAdriana = new JLabel("Adriana");
        JLabel nameDouglas = new JLabel("Douglas");
        JLabel nameFabiano = new JLabel("Fabiano");
        JLabel nameHercules = new JLabel("Hercules");
        JLabel nameKrayton = new JLabel("Krayton");
        JLabel nameNilceu = new JLabel("Nilceu");
        JLabel namePaiola = new JLabel("Paiola");
        JLabel namePapa = new JLabel("Papa");
        JLabel namePerea = new JLabel("Perea");
        JLabel nameInvocations = new JLabel("Invocacoes");

        JPanel detailsAdriana = new JPanel(new GridLayout(2,1));
        JPanel detailsDouglas = new JPanel(new GridLayout(2,1));
        JPanel detailsFabiano = new JPanel(new GridLayout(2,1));
        JPanel detailsHercules = new JPanel(new GridLayout(2,1));
        JPanel detailsKrayton = new JPanel(new GridLayout(2,1));
        JPanel detailsNilceu = new JPanel(new GridLayout(2,1));
        JPanel detailsPaiola = new JPanel(new GridLayout(2,1));
        JPanel detailsPapa = new JPanel(new GridLayout(2,1));
        JPanel detailsPerea = new JPanel(new GridLayout(2,1));
        JPanel detailsInvocations = new JPanel(new GridLayout(2,1));

        JPanel cartas = new JPanel(new GridLayout(5,2));

        imgDouglas.add(imgDouglasATK);
        imgDouglas.add(imgDouglasDEF);
        imgNilceu.add(imgNilceuNormal);
        imgNilceu.add(imgNilceuMaromba);
        imgInvocations.add(imgInvocationsDog);
        imgInvocations.add(imgInvocationsLambreta);

        detailsAdriana.add(nameAdriana);
        detailsAdriana.add(imgAdriana);
        detailsDouglas.add(nameDouglas);
        detailsDouglas.add(imgDouglas);
        detailsFabiano.add(nameFabiano);
        detailsFabiano.add(imgFabiano);
        detailsHercules.add(nameHercules);
        detailsHercules.add(imgHercules);
        detailsKrayton.add(nameKrayton);
        detailsKrayton.add(imgKrayton);
        detailsNilceu.add(nameNilceu);
        detailsNilceu.add(imgNilceu);
        detailsPaiola.add(namePaiola);
        detailsPaiola.add(imgPaiola);
        detailsPapa.add(namePapa);
        detailsPapa.add(imgPapa);
        detailsPerea.add(namePerea);
        detailsPerea.add(imgPerea);
        detailsInvocations.add(nameInvocations);
        detailsInvocations.add(imgInvocations);

        adriana.add(detailsAdriana);
        adriana.add(instAdriana);
        douglas.add(detailsDouglas);
        douglas.add(instDouglas);
        fabiano.add(detailsFabiano);
        fabiano.add(instFabiano);
        hercules.add(detailsHercules);
        hercules.add(instHercules);
        krayton.add(detailsKrayton);
        krayton.add(instKrayton);
        nilceu.add(detailsNilceu);
        nilceu.add(instNilceu);
        paiola.add(detailsPaiola);
        paiola.add(instPaiola);
        papa.add(detailsPapa);
        papa.add(instPapa);
        perea.add(detailsPerea);
        perea.add(instPerea);
        invocations.add(detailsInvocations);
        invocations.add(instInvocations);

        cartas.add(adriana);
        cartas.add(douglas);
        cartas.add(fabiano);
        cartas.add(hercules);
        cartas.add(krayton);
        cartas.add(nilceu);
        cartas.add(paiola);
        cartas.add(papa);
        cartas.add(perea);
        cartas.add(invocations);

        frameHTP.setLayout(new BorderLayout());
        frameHTP.add(instructions,BorderLayout.NORTH);
        frameHTP.add(cartas,BorderLayout.CENTER);
    }
}
