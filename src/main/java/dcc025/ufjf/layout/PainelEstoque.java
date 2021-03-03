/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class PainelEstoque extends JPanel {

    private JPanel header = new Header("Estoque");
    private JPanel main = new JPanel();
    private JTable tabela = new JTable();
    private JPanel buttonWrapper = new JPanel();
    private Contexto contexto;

    public PainelEstoque(Contexto ctx) {
        this.contexto = ctx;
        //Object ingdts = new Object[][] {{this.contexto.estoque.estoqueItens.get(0)},}; 

        // A ideia seria desenvolver a pagina dentro do JPanel main, podendo alterar o layout dele
        // sem problemas, sem quebrar a pagina. nao setar o layout dos paineis diretamente pois  
        // dessa forma quebraria.
        // Ex: main.setLayout(new blablaLayout());
        // e a partir dai add os componentes com main.add(Component);
        //setBackground(Color.green);
        //header.setBackground(Color.pink);
        //main.setBackground(Color.red);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        //main.setPreferredSize(new Dimension(5000,5000));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{this.contexto.estoque.estoqueItens.toArray()},
                new String[]{
                    "Produtos", "Quantidade", "Unidade"
                }
        ));
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
        }
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 330));
        main.add(new JScrollPane(tabela));
        main.add(Box.createVerticalStrut(30));

        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.X_AXIS));
        buttonWrapper.add(new JButton("botao1"));
        buttonWrapper.add(Box.createHorizontalGlue());
        JButton botao2 = new JButton("botao2");
        buttonWrapper.add(botao2);

        main.add(buttonWrapper);

        add(header);
        add(main);

        botao2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nome = new JTextField();
                JTextField quantidade = new JTextField();
                JTextField unidade = new JTextField();
                Object[] novoIngrediente = {"Nome:", nome, "Quantidade:", quantidade, "Unidade:", unidade};
                JOptionPane.showMessageDialog(null, novoIngrediente);
                contexto.estoque.addEstoque(nome.getText(), Integer.parseInt(quantidade.getText()), unidade.getText());
                contexto.estoque.verEstoque();
                atualizaPainel();
            }
        });

    }

    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{this.contexto.estoque.estoqueItens.toArray()},
                new String[]{
                    "Produtos", "Quantidade", "Unidade"
                }
        ));
    }

}
