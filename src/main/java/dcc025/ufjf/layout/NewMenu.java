/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import dcc025.ufjf.trabalho.ItemCardapio;
import dcc025.ufjf.trabalho.ItemEstoque;
import dcc025.ufjf.utils.Arquivo;
import dcc025.ufjf.utils.Json;
import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 *
 * @author thales
 */
public class NewMenu {

    private static JButton formataBotao(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150, 30));
        return button;

    }

    private static Contexto contexto = new Contexto();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.addWindowListener(new frameEvent(contexto));

        frame.setSize(900, 600);
        frame.setMinimumSize(frame.getSize());
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");
        // frame.addWindowListener(new frameEvent(contexto));

        //toolbar 
        JPanel pDireita = new JPanel();

        //setando paineis secundários
        PainelEstoque pEstoque = new PainelEstoque(contexto);
        PainelCaixa pCaixa = new PainelCaixa(contexto);
        PainelComandas pComandas = new PainelComandas(contexto);
        PainelCardapio pCardapio = new PainelCardapio(contexto);

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

        //Add pDireita
        frame.add(BorderLayout.CENTER, pDireita);

        pCaixa.setVisible(false);
        pComandas.setVisible(true);
        pEstoque.setVisible(false);
        pCardapio.setVisible(false);

        JPanel pEsquerda = new JPanel(); //painel principal da esquerda 

        pEsquerda.setLayout(null);
        pEsquerda.setPreferredSize(new Dimension(200, frame.getHeight()));

        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo, BoxLayout.Y_AXIS));

        JPanel pEsquerdaBotoes = new JPanel();
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes, BoxLayout.Y_AXIS));

        //setando os botões da esquerda
        JButton botaoComandas = formataBotao("COMANDAS");
        JButton botaoCaixa = formataBotao("CAIXA");
        JButton botaoEstoque = formataBotao("ESTOQUE");
        JButton botaoCardapio = formataBotao("CARDAPIO");

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

        botaoCaixa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCaixa.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(true);
                pEstoque.setVisible(false);
                pCardapio.setVisible(false);
            }
        });

        botaoComandas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pComandas.atualizaPainel();
                pComandas.setVisible(true);
                pCaixa.setVisible(false);
                pEstoque.setVisible(false);
                pCardapio.setVisible(false);
            }
        });

        //adcionando botoes pEsquerdaBotoes
//        pEsquerdaBotoes.add(Box.createVerticalStrut(200));
        //pEsquerdaBotoes.add(Box.createRigidArea(new Dimension(50,0)));
        pEsquerdaBotoes.add(botaoComandas);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCaixa);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoEstoque);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCardapio);

        //setando pEsquerdaTitulo    
        ImageIcon image = new ImageIcon("restaurante.png");
        JLabel imagem = new JLabel(image);
        imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nomeRestaurante = new JLabel("THALEZIN DO CAPA");
        nomeRestaurante.setAlignmentX(Component.CENTER_ALIGNMENT);
        pEsquerdaTitulo.add(imagem);
        pEsquerdaTitulo.add(Box.createVerticalStrut(50));
        pEsquerdaTitulo.add(nomeRestaurante);
        pEsquerdaTitulo.add(Box.createVerticalStrut(100));
        
        //setando pEsquerda
        pEsquerda.setLayout(new BoxLayout(pEsquerda, BoxLayout.Y_AXIS));
        pEsquerda.add(pEsquerdaTitulo);
        pEsquerda.add(pEsquerdaBotoes);
        JPanel pEsquerdaAux = new JPanel();
        pEsquerdaAux.setLayout(new BoxLayout(pEsquerdaAux, BoxLayout.X_AXIS));
        pEsquerdaAux.add(pEsquerda);
        JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
        pEsquerdaAux.add(separador);
        pEsquerdaAux.add(Box.createGlue());

        //Add pEsquerda
        frame.add(BorderLayout.WEST, pEsquerdaAux);

        //////////toolBar/////////// 
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        //menus
        JMenu menu = new JMenu();
        ImageIcon iconeConfig = new ImageIcon("confic_icon.png");
        Image image2 = iconeConfig.getImage();
        Image newimgIcon = image2.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        iconeConfig = new ImageIcon(newimgIcon);

        menu.setIcon(iconeConfig);

        //menu itens
        JMenu subMenu1 = new JMenu("Carregar arquivos");

        JRadioButton escolheEstoque = new JRadioButton("Carregar estoque");
        subMenu1.add(escolheEstoque);

        escolheEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String lerArquivo = Arquivo.lerArquivo("jsons//estoque.json");
                    List<ItemEstoque> itens = Json.toEstoque(lerArquivo);

                    for (int i = 0; i < itens.size(); i++) {
                        contexto.estoque.addEstoque(itens.get(i).getNomeItemEstoque(), itens.get(i).getQuantidade(), itens.get(i).getUnidade());
                    }
                } catch (IOException r) {
                    System.err.println("Erro ao tentar escrever no arquivo: " + r.toString());
                }

            }
        });

        JRadioButton escolheCardapio = new JRadioButton("Carregar cardápio");
        subMenu1.add(escolheCardapio);

        escolheCardapio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String lerArquivo = Arquivo.lerArquivo("jsons//cardapio.json");
                    List<ItemCardapio> itens = Json.toCardapio(lerArquivo);

                    for (int i = 0; i < itens.size(); i++) {
                        contexto.cardapio.addCardapio(itens.get(i).getNome(), itens.get(i).getPreco(), itens.get(i).getDisponivel());
                    }
                } catch (IOException i) {
                    System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
                }

            }
        });

        JRadioButton escolheCaixa = new JRadioButton("Carregar caixa");
        subMenu1.add(escolheCaixa);
        
//        JButton renomeiaRestaurante = new JButton();
//        renomeiaRestaurante.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                String novoNome = JOptionPane.showInputDialog(null, "Novo nome do restaurante:", "Novo Nome");
//                try {
//                    BufferedReader br = new BufferedReader(new FileReader(new File("NomeRestaurante")));
//                    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("NomeRestaurante")));
//                    
//                } catch (IOException ex) {
//                    Logger.getLogger(NewMenu.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        
        menu.add(subMenu1);
        menuBar.add(menu);

        frame.setVisible(true);

    }

}
