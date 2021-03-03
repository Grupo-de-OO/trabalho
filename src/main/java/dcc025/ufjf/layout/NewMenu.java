/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
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

    private static Contexto contexto = new Contexto();

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");

        JPanel pDireita = new JPanel();
        PainelEstoque pEstoque = new PainelEstoque(contexto);
        PainelCaixa pCaixa = new PainelCaixa();
        PainelComandas pComandas = new PainelComandas();
        PainelCardapio pCardapio = new PainelCardapio(contexto);
        frame.add(BorderLayout.CENTER, pDireita);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(pDireita);
        pDireita.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 601, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pComandas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pComandas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCaixa.setVisible(false);
        pComandas.setVisible(false);
        pEstoque.setVisible(true);
        pCardapio.setVisible(false);

        //paineis da esquerda
        JPanel pEsquerda = new JPanel(); //main panel da esquerda
        pEsquerda.setLayout(new BoxLayout(pEsquerda, BoxLayout.Y_AXIS));
        pEsquerda.setPreferredSize(new Dimension(250, 0));
        JPanel pEsquerdaBotoes = new JPanel();
        //pEsquerdaBotoes.setBackground(Color.red);
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes, BoxLayout.Y_AXIS));

        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo, BoxLayout.Y_AXIS));

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

        // Comandos dos botoes
        botaoEstoque.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pEstoque.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(false);
                pEstoque.setVisible(true);
                pCardapio.setVisible(false);
            }
        });

        botaoCardapio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCardapio.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(false);
                pEstoque.setVisible(false);
                pCardapio.setVisible(true);
            }
        });

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
        pEsquerda.setLayout(new BoxLayout(pEsquerda, BoxLayout.Y_AXIS));
        pEsquerda.add(pEsquerdaTitulo);
        pEsquerda.add(pEsquerdaBotoes);

        //barra do canto esquerdo do Jframe 
        frame.add(BorderLayout.WEST, pEsquerda);

    }

}
