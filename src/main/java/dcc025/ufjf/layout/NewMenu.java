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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author thales
 */
public class NewMenu {
     
   
    
    private static void addButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        container.add(button);
        container.add(Box.createVerticalStrut(20));
    }
 
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       
         
 
    JFrame jframe = new JFrame("RESTAURANTE");  
    jframe.setLayout(null);  
    jframe.setSize(900,900);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 

    
    
    JPanel pEsquerda = new JPanel(); //painel principal da esquerda 
    
    pEsquerda.setLayout(null);
    pEsquerda.setBounds(0, 0,jframe.getWidth()/4,jframe.getHeight());
    pEsquerda.setBackground(Color.red);
    
    
    JPanel pEsquerdaTitulo = new JPanel();
    pEsquerdaTitulo.setLayout(null);
    pEsquerdaTitulo.setBackground(Color.pink);
    pEsquerdaTitulo.setBounds(0,0,pEsquerda.getWidth(),pEsquerda.getHeight()/3);
    
    JLabel nomeRestaurante = new JLabel("NOME RESTAURANTE");
    
    nomeRestaurante.setBounds(50,pEsquerdaTitulo.getHeight() - pEsquerdaTitulo.getHeight()/6,pEsquerdaTitulo.getWidth(),pEsquerdaTitulo.getHeight()/6);
    nomeRestaurante.setAlignmentX(Component.CENTER_ALIGNMENT);
    pEsquerdaTitulo.add(nomeRestaurante);

    
    JPanel pEsquerdaBotoes = new JPanel();
    pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes,BoxLayout.Y_AXIS));
    pEsquerdaBotoes.setBounds(pEsquerda.getWidth()/5,(pEsquerda.getHeight()*4)/10,(pEsquerda.getWidth()*3)/5,(pEsquerda.getHeight()*2)/3);
    pEsquerdaBotoes.setBackground(Color.green);
    addButton("CAIXA",pEsquerdaBotoes);
    addButton("COMANDAS",pEsquerdaBotoes);
    addButton("ESTOQUE",pEsquerdaBotoes);
    addButton("CARDAPIO",pEsquerdaBotoes);
    
    
    pEsquerda.add(pEsquerdaTitulo);
    pEsquerda.add(pEsquerdaBotoes);
    jframe.add(pEsquerda);  
    jframe.setVisible(true);
   
        jframe.addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent componentEvent) {
                //do stuf
            }
        });

    
    
    
    }
    
}
