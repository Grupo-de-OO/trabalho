/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author bruno
 */
public class PainelComandas extends JPanel implements InterfaceLayout {

    private Contexto contexto;
    private JPanel header = new Header("Comandas");
    private JPanel main = new JPanel();
    private JPanel wrapper1 = new JPanel();
    private JPanel wrapper2 = new JPanel();
    private JPanel wrapperBotoes = new JPanel();
    private JPanel wrapper3 = new JPanel();
    private JComboBox<Integer> comandas = new JComboBox<Integer>();
    private JButton adicionaComanda = formataBotao("Adiciona Comanda");
    private JButton fechaComanda = formataBotao("Fecha Comanda");
    private JButton adicionaPedido = formataBotao("Adiciona Pedido");
    private JButton removePedido = formataBotao("Remove Pedido");
    private JTable tabela = new JTable();
    private JLabel total = new JLabel();

    public PainelComandas(Contexto ctx) {

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        contexto = ctx;

        //Método para atualizar a tabela quando é trocado o número do ComboBox
        comandas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if ((int) ie.getItem() == comandas.getSelectedIndex()) {
                    trocaTabela();
                }
            }
        });

        adicionaComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contexto.listaComandas.insereComanda();
                atualizaComboBox();
                comandas.setSelectedIndex(comandas.getItemCount() - 1);

            }
        });

        adicionaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (contexto.listaComandas.getListaComandas().size() > 0) {
                    if (contexto.cardapio.getItens().size() > 0) {
                        contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).inserePedido(contexto);
                        trocaTabela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há nada cadastrado no cardapio.", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você não possui comandas em aberto.", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removePedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.showConfirmDialog(main, "Tem certeza que deseja remover " + contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getPedidos().get(tabela.getSelectedRow()), "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0) {
                    //contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).removePedido(contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getPedidos().get(tabela.getSelectedRow()).getItemCardapio().getClass());
                    contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getPedidos().remove(tabela.getSelectedRow());
                        
                }
                trocaTabela();
                atualizaPainel();
            }
        });

        fechaComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.showConfirmDialog(main, "Tem certeza que deseja fechar a Comanda #" + comandas.getSelectedItem(), "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0) {
                    contexto.listaComandas.fechaComanda(comandas.getSelectedIndex(), contexto);
                }
                atualizaPainel();
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
        tabela.setPreferredScrollableViewportSize(InterfaceLayout.tableDimension);
        tabela.setRowSelectionAllowed(true);
        wrapper2.add(new JScrollPane(tabela));

        //Add wrapperBotoes
        wrapperBotoes.setLayout(new BoxLayout(wrapperBotoes, BoxLayout.Y_AXIS));
        wrapperBotoes.add(adicionaComanda);
        wrapperBotoes.add(Box.createVerticalStrut(10));
        wrapperBotoes.add(adicionaPedido);
        wrapperBotoes.add(Box.createVerticalStrut(10));
        wrapperBotoes.add(removePedido);
        wrapperBotoes.add(Box.createVerticalStrut(10));
        wrapperBotoes.add(fechaComanda);
        wrapperBotoes.add(Box.createGlue());
        wrapper2.add(wrapperBotoes);

        //Add wrapper2
        wrapper2.setLayout(new BoxLayout(wrapper2, BoxLayout.X_AXIS));
        main.add(wrapper2);

        //Add wrapper3
        wrapper3.setLayout(new BoxLayout(wrapper3, BoxLayout.X_AXIS));
        wrapper3.add(total);
        wrapper3.add(Box.createGlue());
        main.add(wrapper3);

        //Add header e main
        add(header);
        add(main);
    }

    private static JButton formataBotao(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        return button;

    }

    private void atualizaComboBox() {
        comandas.removeAllItems();
        for (int i = 0; i < contexto.listaComandas.getListaComandas().size(); i++) {
            comandas.addItem(contexto.listaComandas.getListaComandas().get(i).getId());
        }
    }

    private void trocaTabela() {
        if (contexto.listaComandas.getListaComandas().size() > 0) {
            tabela.setModel(new javax.swing.table.DefaultTableModel(
                    contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getComanda(),
                    new String[]{
                        "Nome", "Quantidade", "Preço"
                    }
            ));
            total.setText("TOTAL: R$" + new DecimalFormat("0.00").format(contexto.listaComandas.getListaComandas().get(comandas.getSelectedIndex()).getValorTotal()));
        } else {
            tabela.setModel(new javax.swing.table.DefaultTableModel(null, new String[]{"Nome", "Quantidade", "Preço"}));
            total.setText("TOTAL: R$0,00");
        }
    }

    //Não sei se vai ser usado mas ta ai
    @Override
    public void atualizaPainel() {
        int i;
        if (contexto.listaComandas.getListaComandas().size() > 0) {
            i = comandas.getSelectedIndex();
            atualizaComboBox();
            trocaTabela();
            comandas.setSelectedIndex(i);
        } else {
            atualizaComboBox();
            trocaTabela();
        }
    }

}
