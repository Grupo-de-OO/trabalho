/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class PainelCardapio extends JPanel {

    private JPanel header = new Header("Cardápio");
    private JPanel main = new JPanel();
    private JTable tabela = new JTable();
    private JPanel buttonWrapper = new JPanel();
    private Contexto contexto = new Contexto();

    public PainelCardapio(Contexto ctx) {

        // A ideia seria desenvolver a pagina dentro do JPanel main, podendo alterar o layout dele
        // sem problemas, sem quebrar a pagina. nao setar o layout dos paineis diretamente pois  
        // dessa forma quebraria.
        // Ex: main.setLayout(new blablaLayout());
        // e a partir dai add os componentes com main.add(Component);
      
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        contexto = ctx;
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.cardapio.getCardapio(),
                new String[]{
                    "Nome", "Preço"
                }
        ));
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
        }
        
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 330));
        main.add(new JScrollPane(tabela));
        main.add(Box.createVerticalStrut(30));
        
        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.X_AXIS));
        JButton adiciona = new JButton("Adicionar no cardapio");
        buttonWrapper.add(adiciona);
        
        JButton retira = new JButton("Retirar do cardápio");
        buttonWrapper.add(Box.createHorizontalGlue());
        buttonWrapper.add(retira);
        
        
        
        //action buttons
        
        adiciona.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nome = new JTextField();
                JTextField preco = new JTextField();
                Object[] novoItem = {"Nome:", nome, "Preço:",preco};
                JOptionPane.showMessageDialog(null, novoItem);
                //DecimalFormat df = new DecimalFormat("0,00");
                //contexto.cardapio.addCardapio(nome.getText(), Float.parseFloat(df.format(preco.getText())));
                contexto.cardapio.addCardapio(nome.getText(), Float.parseFloat(preco.getText()));
               
                
                atualizaPainel();
            }
        });
        
        retira.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nomeRetira = new JTextField();
                Object[] itemRetira = {"Digite o nome do item pra retirar: ", nomeRetira};
                JOptionPane.showMessageDialog(null, itemRetira);
                //DecimalFormat df = new DecimalFormat("0,00");
                //contexto.cardapio.addCardapio(nome.getText(), Float.parseFloat(df.format(preco.getText())));
               
                while(!contexto.cardapio.remItem(nomeRetira.getText())){
                   
                   
               }
               
               
                atualizaPainel();
            }
        });
        
        
        
        
        
        
        
        
        main.add(buttonWrapper);
        
        add(header);
        add(main);

    }
    
    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.cardapio.getCardapio(),
                new String[]{
                    "Nome", "Preço"
                }
        ));
    }

}
