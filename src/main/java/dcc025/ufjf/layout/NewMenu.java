/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
    
     
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(900,600);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");
        
        JPanel pDireita = new PainelCaixa();
        frame.add(BorderLayout.CENTER, pDireita);
        
        
        
        
        //paineis da esquerda
        JPanel pEsquerda = new JPanel(); //main panel da esquerda
        pEsquerda.setLayout(new BoxLayout(pEsquerda, BoxLayout.Y_AXIS));
        pEsquerda.setPreferredSize(new Dimension(250, 0));
        JPanel pEsquerdaBotoes = new JPanel();
        //pEsquerdaBotoes.setBackground(Color.red);
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes,BoxLayout.Y_AXIS));
        
        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo,BoxLayout.Y_AXIS));
        
        
        
        
        //setando os botões da esquerda
        JButton botaoComandas = new JButton("Comandas");
        botaoComandas.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoComandas.setMaximumSize(new Dimension(160, 50));
        
        JButton botaoCaixa = new JButton("Caixa");
        botaoCaixa.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCaixa.setMaximumSize(new Dimension(160, 50));
        
        JButton botaoEstoque = new JButton("Estoque");
        botaoEstoque.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoEstoque.setMaximumSize(new Dimension(160, 50));
        
        JButton botaoCardapio = new JButton("Cardápio");
        botaoCardapio.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCardapio.setMaximumSize(new Dimension(160, 50));
        
        

        //adcionando botoes pEsquerdaBotoes
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(200));
        //pEsquerdaBotoes.add(Box.createRigidArea(new Dimension(50,0)));
        
        pEsquerdaBotoes.add(botaoComandas);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCaixa);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoEstoque);
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCardapio);


        
        
        //setando pEsquerdaTitulo    
        pEsquerdaTitulo.add(new JLabel("Nome do Restaurante"));

        
       
        
    
        //setando pEsquerda
        pEsquerda.setLayout(new BoxLayout(pEsquerda,BoxLayout.Y_AXIS));
        pEsquerda.add(pEsquerdaTitulo);
        pEsquerda.add(pEsquerdaBotoes);
        
        
        
        //barra do canto esquerdo do Jframe 
        frame.add(BorderLayout.WEST,pEsquerda);

 
        
        
        
        
        
    
    }
    
}
