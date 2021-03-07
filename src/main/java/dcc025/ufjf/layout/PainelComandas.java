/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author bruno
 */
public class PainelComandas extends JPanel {

    private Contexto contexto;
    private JPanel header = new Header("Comandas");
    private JPanel main = new JPanel();
    private JPanel wrapper1 = new JPanel();
    private JPanel wrapper2 = new JPanel();
    private JComboBox<Integer> comandas = new JComboBox<Integer>();
    private JButton adicionaComanda = new JButton("Adiciona Comanda");
    private JButton adicionaPedido = new JButton("Adiciona Pedido");
    private JTable tabela = new JTable();

    public PainelComandas(Contexto ctx) {

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        contexto = ctx;
        
        //Método para atualizar a tabela quando é trocado o número do ComboBox
        comandas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if((int)ie.getItem()==comandas.getSelectedIndex())
                    trocaTabela();
            }
        });
        
        adicionaComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contexto.listaComandas.insereComanda();
                atualizaComboBox();
                comandas.setSelectedIndex(comandas.getItemCount()-1);
            }
        });

        adicionaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).inserePedido();
                trocaTabela();
            }
        });
        
        //Add wrapper1
        wrapper1.setLayout(new BoxLayout(wrapper1, BoxLayout.X_AXIS));
        wrapper1.add(new JLabel("Comanda: "));
        comandas.setMaximumSize(new Dimension(45, 20));
        wrapper1.add(comandas);
        wrapper1.add(Box.createGlue());
        main.add(wrapper1);
        
        //Add tabela
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 330));
        main.add(new JScrollPane(tabela));
        
        //Add wrapper2
        wrapper2.setLayout(new BoxLayout(wrapper2, BoxLayout.X_AXIS));
        wrapper2.add(adicionaComanda);
        wrapper2.add(adicionaPedido);
        main.add(wrapper2);
        
        //Add header e main
        add(header);
        add(main);
    }

    private void atualizaComboBox() {
        comandas.removeAllItems();
        for (int i = 0; i < contexto.listaComandas.getListaComandas().size(); i++) {
            comandas.addItem(contexto.listaComandas.getListaComandas().get(i).getId());
        }
    }

    private void trocaTabela() {
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getComanda(),
                new String[]{
                    "Nome", "Quantidade", "Preço"
                }
        ));
    }
    
    //Não sei se vai ser usado mas ta ai
    private void atualizaPainel() {
        int i;
        if(contexto.listaComandas.getListaComandas().size()>0)
            i = comandas.getSelectedIndex();
        else
            i = 0;
        atualizaComboBox();
        trocaTabela();
        comandas.setSelectedIndex(i);
    }

}
