package dcc025.ufjf.layout;

import dcc025.ufjf.restaurante.ItemCardapio;
import dcc025.ufjf.restaurante.ItemEstoque;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PainelCardapio extends JPanel implements InterfaceLayout {

    private JPanel header = new Header("Cardápio");
    private JPanel main = new JPanel();
    private JTable tabela = new JTable();
    private JPanel buttonWrapper = new JPanel();
    private Contexto contexto = new Contexto();

    public PainelCardapio(Contexto ctx) {

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

        tabela.setPreferredScrollableViewportSize(InterfaceLayout.tableDimension);
        main.add(new JScrollPane(tabela));
        main.add(Box.createVerticalStrut(30));

        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.X_AXIS));
        JButton adiciona = new JButton("Adicionar no cardapio");
        buttonWrapper.add(adiciona);
        JButton ver = new JButton("Ver Ingredientes");
        buttonWrapper.add(Box.createHorizontalGlue());
        buttonWrapper.add(ver);
        JButton retira = new JButton("Retirar do cardápio");
        buttonWrapper.add(Box.createHorizontalGlue());
        buttonWrapper.add(retira);

        ver.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (contexto.cardapio.getItens().size() > 0) {
                    if (tabela.getSelectedRow() != -1) {
                        String ingString = "";
                        for (ItemEstoque ingrediente : contexto.cardapio.getItens().get(tabela.getSelectedRow()).getIngredientesNecessarios()) {
                            ingString = ingString + ingrediente.toString() + "\n ";
                        }
                        JOptionPane.showMessageDialog(null, ingString,contexto.cardapio.getItens().get(tabela.getSelectedRow()).getNome(),JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum item selecionado, selecione um item.","AVISO",JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não existe itens no cardapio.","AVISO",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //action buttons
        adiciona.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField nome = new JTextField();
                JTextField preco = new JTextField();

                Object[] novoItem = {"Nome:", nome, "Preço:", preco};
                JOptionPane.showMessageDialog(null, novoItem);
                if (!nome.getText().isEmpty() && !preco.getText().isEmpty()) {
                    ItemCardapio novoItemCardapio = new ItemCardapio(nome.getText(), Float.parseFloat(preco.getText()), false);

                    int option = 0;
                    JTextField nomeIng = new JTextField();
                    JTextField qtdIng = new JTextField();
                    String[] opcoesUnidade = {"Kg", "Unid"};
                    JComboBox unidadeIng = new JComboBox(opcoesUnidade);

                    while (option != 1 && option != -1) {
                        Object[] options = {"Adicionar Ingrediente", "Terminar"};
                        Object[] novoIng = {"Adicione um igrediente que seja necessário para a preparo final do novo item", " ", "Nome:", nomeIng, "Quantidade:", qtdIng, "Unidade:", unidadeIng};
                        option = JOptionPane.showOptionDialog(null, novoIng, "Adicione um ingrediente", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (option == 0 && (!nomeIng.getText().isEmpty() || !qtdIng.getText().isEmpty())) {
                            novoItemCardapio.addIngrediente(nomeIng.getText(), Float.parseFloat(qtdIng.getText()), unidadeIng.getSelectedItem().toString());
                        }
                        nomeIng.setText("");
                        qtdIng.setText("");
                    }

                    contexto.cardapio.addCardapio(novoItemCardapio);
                }
                atualizaPainel();
            }
        });

        retira.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (contexto.cardapio.getCardapio().length != 0) {
                    JTextField nomeRetira = new JTextField();
                    Object[] itemRetira = {"Digite o nome do item para retirar do cardápio: ", nomeRetira};
                    int opcao = JOptionPane.showConfirmDialog(null, itemRetira, "Retira", JOptionPane.OK_CANCEL_OPTION);

                    boolean aux = contexto.cardapio.remItem(nomeRetira.getText().toLowerCase().trim());
                    while (!aux && opcao == 0) {

                        JTextField newnomeRetira = new JTextField();
                        Object[] newitemRetira = {"Item não encontrado, digite um item que tenha no cardápio :", newnomeRetira};
                        opcao = JOptionPane.showConfirmDialog(null, newitemRetira, "Retira", JOptionPane.OK_CANCEL_OPTION);
                        aux = contexto.cardapio.remItem(newnomeRetira.getText().toLowerCase().trim());

                    }
                    atualizaPainel();
                } else {
                    JOptionPane.showMessageDialog(null, "Cardápio Vazio", "ERROR", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        main.add(buttonWrapper);
        add(header);
        add(main);
    }

    @Override
    public void atualizaPainel() {
        checaDisponibilidade();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                contexto.cardapio.getCardapio(),
                new String[]{
                    "Nome", "Preço", "Disponibilidade",}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    public void checaDisponibilidade() {
        for (ItemCardapio item : contexto.cardapio.getItens()) {
            for (ItemEstoque ing : item.getIngredientesNecessarios()) {
                for (ItemEstoque itemEstoque : contexto.estoque.getEstoqueItens()) {
                    if (ing.getNomeItemEstoque().equalsIgnoreCase(itemEstoque.getNomeItemEstoque())) {
                        if (ing.getQuantidade() <= itemEstoque.getQuantidade()) {
                            item.setDisponivel(true);
                        } else {
                            item.setDisponivel(false);
                            break;
                        }
                    }
                }
            }
        }
    }

}
