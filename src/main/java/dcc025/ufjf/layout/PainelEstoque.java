/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PainelEstoque extends JPanel implements InterfaceLayout {

    private JPanel header = new Header("Estoque");
    private JPanel main = new JPanel();
    private JTable tabela = new JTable();
    private JPanel buttonWrapper = new JPanel();
    private Contexto contexto;

    public PainelEstoque(Contexto ctx) {
        this.contexto = ctx;

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

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
                //JTextField unidade = new JTextField();
                String [] opcoesUnidade = {"Kg", "Unid"};
                JComboBox unidade = new JComboBox(opcoesUnidade);
                Object[] novoIngrediente = {"Nome:", nome, "Quantidade:", quantidade, "Unidade:", unidade};
                JOptionPane.showMessageDialog(null, novoIngrediente);
                //arrumar esse tratamento para null
                if (nome.getText().isEmpty() || quantidade.getText().isEmpty() || unidade.getSelectedItem().toString().equals("")) {
                    //JOptionPane.showMessageDialog(null, "Você deixou algum campo sem preencher informação.", "ERRO", JOptionPane.ERROR_MESSAGE);   
                } else {
                    contexto.estoque.addEstoque(nome.getText(), Float.parseFloat(quantidade.getText()), unidade.getSelectedItem().toString());
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
                if (nome.getText().isEmpty() || quantidade.getText().isEmpty()) {
                    //JOptionPane.showMessageDialog(null, "Você deixou algum campo sem preencher informação.", "ERRO", JOptionPane.ERROR_MESSAGE);                       
                } else {
                    contexto.estoque.remEstoque(nome.getText().trim(), Float.parseFloat(quantidade.getText()));
                }
                atualizaPainel();
            }
        });
        atualizaPainel();

    }
    @Override
    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.estoque.getEstoque(),
                new String[]{
                    "Produtos", "Quantidade", "Unidade"
                }
        ));
    }

}
