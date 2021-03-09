/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import dcc025.ufjf.trabalho.ItemCardapio;
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
                JTextField quantidade = new JTextField();
                
                Object[] novoItem = {"Nome:", nome, "Preço:",preco,"Porção:",quantidade};
                JOptionPane.showMessageDialog(null, novoItem);
                
                ItemCardapio novoItemCardapio = new ItemCardapio(nome.getText(), Float.parseFloat(preco.getText()),Integer.parseInt(quantidade.getText()));
                
                int option = 0;
                JTextField nomeIng = new JTextField();
                JTextField qtdIng = new JTextField();
                JTextField unidadeIng = new JTextField();
                
                while (option != 1 && option != -1) {
                    Object[] options = { "Adicionar Ingrediente", "Terminar"};
                    Object[] novoIng = {"Adicione um igrediente que seja necessário para a preparo final do novo item", " ", "Nome:", nomeIng, "Quantidade:", qtdIng, "Unidade:",unidadeIng};
                    option = JOptionPane.showOptionDialog(null, novoIng, "Adicione um ingrediente", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (option == 0) {
                        novoItemCardapio.addIngrediente(nomeIng.getText(), Float.parseFloat(qtdIng.getText()), unidadeIng.getText());
                    }
                    nomeIng.setText("");
                    qtdIng.setText("");
                    unidadeIng.setText("");
                }         
                
                //DecimalFormat df = new DecimalFormat("0,00");
                //contexto.cardapio.addCardapio(nome.getText(), Float.parseFloat(df.format(preco.getText())));
                contexto.cardapio.addCardapio(novoItemCardapio);
                atualizaPainel();
            }
        });
        
        retira.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nomeRetira = new JTextField();
                Object[] itemRetira = {"DIGITE O NOME DO ITEM PARA RETIRAR DO CARDÁPIO: ", nomeRetira};
                JOptionPane.showMessageDialog(null, itemRetira);
                //DecimalFormat df = new DecimalFormat("0,00");
                //contexto.cardapio.addCardapio(nome.getText(), Float.parseFloat(df.format(preco.getText())));
                 boolean aux = contexto.cardapio.remItem(nomeRetira.getText().toLowerCase());
                
                 do{
                    if(aux){
                    break;
                        }
                    else{
                    JTextField newnomeRetira = new JTextField();
                    Object[] newitemRetira = {"ITEM NÃO ENCONTRADO, DIGITE UM ITEM QUE TENHA NO CARDÁPIO :", newnomeRetira};
                    JOptionPane.showMessageDialog(null, newitemRetira);
                     aux = contexto.cardapio.remItem(newnomeRetira.getText());
                        
                        
                    }
                }while(!aux);
                atualizaPainel();
            }
        });
        main.add(buttonWrapper);
        
        add(header);
        add(main);

    }
    
    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.cardapio.getCardapioTemp(), // Apos testes, voltar para getCardapio() e remover coluna "Ingredientes"
                new String[]{
                    "Nome", "Preço","Porção", "Ingredientes" // ingredientes temporariamente inseridos
                }
        ));
    }

}
