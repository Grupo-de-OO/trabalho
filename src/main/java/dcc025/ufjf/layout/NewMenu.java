/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
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
        frame.setSize(700,700);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");
        
        
        
        
        
        //paineis da esquerda
        JPanel pEsquerda = new JPanel(); //main panel da esquerda
        JPanel pEsquerdaBotoes = new JPanel();
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes,BoxLayout.Y_AXIS));
        
        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo,BoxLayout.Y_AXIS));
        
        
        
        
        //setando os botões da esquerda
        JButton botaoComandas = new JButton("Comandas");
        
        JButton botaoCaixa = new JButton("Caixa");
        
        JButton botaoEstoque = new JButton("Estoque");
        
        JButton botaoCardapio = new JButton("Cardápio");
        
        

        //adcionando botoes pEsquerdaBotoes
        
        pEsquerdaBotoes.add(Box.createVerticalStrut(300));
        pEsquerdaBotoes.add(Box.createRigidArea(new Dimension(50,0)));
        
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
