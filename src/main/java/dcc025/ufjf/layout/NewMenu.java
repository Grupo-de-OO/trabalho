/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thales
 */
public class NewMenu {
     
    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
 
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");
        
        
        
        
        
        //paineis da esquerda
        JPanel pEsquerda = new JPanel(); //main panel da esquerda
        JPanel pEsquerdaBotoes = new JPanel();
        JPanel pEsquerdaAux = new JPanel();
        pEsquerdaAux.setBackground(Color.red);
        
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes,BoxLayout.Y_AXIS));
        pEsquerdaBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo,BoxLayout.Y_AXIS));
        
        
        
        //setando os botões da esquerda
        JButton botaoComandas = new JButton("Comandas");
        
        JButton botaoCaixa = new JButton("Caixa");
       
        botaoCaixa.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton botaoEstoque = new JButton("Estoque");
        
        JButton botaoCardapio = new JButton("Cardápio");
     
        
        //adcionando botoes pEsquerdaBotoes
        
        //pEsquerdaBotoes.add(Box.createVerticalStrut(300));
       // pEsquerdaBotoes.add(Box.createRigidArea(new Dimension(50,0)));
        
       /*
        pEsquerdaBotoes.add(botaoComandas);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCaixa);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoEstoque);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCardapio);
        */
        addAButton("CAIXA", pEsquerdaBotoes);
        addAButton("COMANDAS", pEsquerdaBotoes);
        pEsquerdaBotoes.setBackground(Color.yellow);

        
        
        //setando pEsquerdaTitulo    
        JLabel nomeRestaurante = new JLabel("NOME DO RESTAURANTE");
        //pEsquerdaTitulo.add(Box.createVerticalStrut(200));

       
        pEsquerdaTitulo.add(nomeRestaurante);
        
        
       
        
    
        //setando pEsquerda
        pEsquerda.setAlignmentX(Component.CENTER_ALIGNMENT);
        pEsquerda.setLayout(new BoxLayout(pEsquerda,BoxLayout.Y_AXIS));
        
        pEsquerda.add(pEsquerdaTitulo);
        pEsquerda.add(pEsquerdaAux);
        pEsquerda.add(pEsquerdaBotoes);
        pEsquerda.setBackground(Color.green);
        
        
        //barra do canto esquerdo do Jframe 
        frame.add(BorderLayout.WEST,pEsquerda);

        
        
        
        
        
        
    
    }
    
}
