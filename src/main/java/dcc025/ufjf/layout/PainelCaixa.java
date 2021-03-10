/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class PainelCaixa extends JPanel {

    private JPanel header = new Header("Caixa");
    private JPanel main = new JPanel();
    private JPanel statusWrapper = new JPanel();
    private JLabel emCaixa = formataLabel("Em caixa: ");
    private JLabel emAberto = formataLabel("Comandas em aberto: ");
    private JTable tabela = new JTable();
    private Contexto contexto = new Contexto();
    private JPanel bottomWrapper = new JPanel();
    private JButton novaEntrada = new JButton("Nova Entrada");
    private JButton novaSaida = new JButton("Nova Saída");
//    private JLabel saldo = formataLabel("Saldo do dia: ");

            
    public PainelCaixa(Contexto ctx) {

        // A ideia seria desenvolver a pagina dentro do JPanel main, podendo alterar o layout dele
        // sem problemas, sem quebrar a pagina. nao setar o layout dos paineis diretamente pois  
        // dessa forma quebraria.
        // Ex: main.setLayout(new blablaLayout());
        // e a partir dai add os componentes com main.add(Component);
        contexto = ctx;
        statusWrapper.setLayout(new BoxLayout(statusWrapper, BoxLayout.X_AXIS));
        statusWrapper.add(emCaixa);
        statusWrapper.add(Box.createHorizontalGlue());
        statusWrapper.add(emAberto);
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 330));
        
        bottomWrapper.setLayout(new BoxLayout(bottomWrapper, BoxLayout.X_AXIS));
        bottomWrapper.add(novaEntrada);
        bottomWrapper.add(Box.createHorizontalGlue());
        bottomWrapper.add(novaSaida);
        
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        main.add(statusWrapper);
        main.add(Box.createVerticalStrut(20));
        main.add(new JScrollPane(tabela));
        main.add(Box.createVerticalStrut(20));
        main.add(bottomWrapper);
        add(header);
        add(main);
        atualizaPainel();
        
        novaEntrada.addActionListener(
                new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt
            ) {
                JTextField nome = new JTextField();
                JTextField descricao = new JTextField();
                JTextField valor = new JTextField();
                Object[] novaEntrada = {"Nome:", nome, "Descrição:", descricao, "Valor:", valor};
                JOptionPane.showMessageDialog(null, novaEntrada);
                if(!nome.getText().isEmpty() || !descricao.getText().isEmpty() || !valor.getText().isEmpty())
                    contexto.caixa.addEntrada(nome.getText(), descricao.getText(), Float.parseFloat(valor.getText()));
                atualizaPainel();
            }
        }
        );
        
        novaSaida.addActionListener(
                new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt
            ) {
                JTextField nome = new JTextField();
                JTextField descricao = new JTextField();
                JTextField valor = new JTextField();
                Object[] novaSaida = {"Nome:", nome, "Descrição:", descricao, "Valor:", valor};
                JOptionPane.showMessageDialog(null, novaSaida);
                contexto.caixa.addSaida(nome.getText(), descricao.getText(), Float.parseFloat(valor.getText()));
                atualizaPainel();
            }
        }
        );
    }
    
    public void atualizaPainel() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            contexto.caixa.getCaixa(),
            new String[]{
            "Data", "Nome", "Descrição", "Preço"
            }
        ));
        emCaixa.setText("Em caixa: R$" + new DecimalFormat("0.00").format(contexto.caixa.getValorEmCaixa()));
        emAberto.setText("Comandas em aberto: " + contexto.listaComandas.getListaComandas().size());
    }
    
    private static JLabel formataLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("", 1, 20));     
        return label;
    }
}
