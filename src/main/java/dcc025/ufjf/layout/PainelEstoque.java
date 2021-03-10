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
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 330));
        main.add(new JScrollPane(tabela));
        main.add(Box.createVerticalStrut(30));

        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.X_AXIS));
        JButton addItem = new JButton("Adiciona Item");
        buttonWrapper.add(addItem);
        buttonWrapper.add(Box.createHorizontalGlue());
        JButton rmItem = new JButton("Remove Item");
        buttonWrapper.add(rmItem);

        main.add(buttonWrapper);

        add(header);
        add(main);
        atualizaPainel();

        addItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nome = new JTextField();
                JTextField quantidade = new JTextField();
                JTextField unidade = new JTextField();
                Object[] novoIngrediente = {"Nome:", nome, "Quantidade:", quantidade, "Unidade:", unidade};
                JOptionPane.showMessageDialog(null, novoIngrediente);
                //arrumar esse tratamento para null
                if(nome!=null && quantidade!= null && unidade != null){ 
                    contexto.estoque.addEstoque(nome.getText(), Float.parseFloat(quantidade.getText()), unidade.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Você deixou algum campo sem preencher informação.", "ERRO", JOptionPane.ERROR_MESSAGE);   
                }
                
                atualizaPainel();
            }
        });
        
        rmItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nome = new JTextField();
                JTextField quantidade = new JTextField();
                Object[] ingrediente = {"Nome:", nome, "Quantidade:", quantidade};
                JOptionPane.showMessageDialog(null, ingrediente);
                contexto.estoque.remEstoque(nome.getText(), Integer.parseInt(quantidade.getText()));
                atualizaPainel();
            }
        });
    atualizaPainel();

    }

    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.estoque.getEstoque(),
                new String[]{
                    "Produtos", "Quantidade", "Unidade"
                }
        ));
    }

}
