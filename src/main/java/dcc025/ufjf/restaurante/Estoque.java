package dcc025.ufjf.restaurante;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Estoque {

    public ArrayList<ItemEstoque> estoqueItens = new ArrayList<ItemEstoque>();

    public ArrayList<ItemEstoque> getEstoqueItens() {
        return estoqueItens;
    }

    public void addEstoque(ItemEstoque ingrediente) {
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while (w && i < estoqueItens.size()) {
            if (ingrediente.getNomeItemEstoque().equals(estoqueItens.get(i).getNomeItemEstoque())) {
                estoqueItens.get(i).setQuantidade(estoqueItens.get(i).getQuantidade() + ingrediente.getQuantidade());
                jaExiste = true;
                w = false;
            }
            i++;
        }
        if (!jaExiste) {
            estoqueItens.add(ingrediente);
        }
    }

    public void addEstoque(String nome, float quantidade, String unidade) {
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while (w && i < estoqueItens.size()) {
            if (nome.equals(estoqueItens.get(i).getNomeItemEstoque())) {
                estoqueItens.get(i).setQuantidade(estoqueItens.get(i).getQuantidade() + quantidade);
                jaExiste = true;
                w = false;
            }
            i++;
        }
        if (!jaExiste) {
            estoqueItens.add(new ItemEstoque(nome.trim(), quantidade, unidade));
        }
    }

    public void remEstoque(String ingredienteNome, float quantidade) {

        ItemEstoque ingrediente = new ItemEstoque(ingredienteNome, quantidade, " ");

        for (ItemEstoque ingredienteEst : estoqueItens) {
            if (ingredienteEst.getNomeItemEstoque().equalsIgnoreCase(ingrediente.getNomeItemEstoque())) {
                if (ingredienteEst.getQuantidade() - quantidade >= 0) {
                    ingredienteEst.setQuantidade(ingredienteEst.getQuantidade() - quantidade);
                    JOptionPane.showMessageDialog(null, "Foram removidos " + quantidade + ingredienteEst.getUnidade() + " de " + ingredienteEst.getNomeItemEstoque() + " do estoque.", "AVISO", JOptionPane.WARNING_MESSAGE);
                } else {
                    int opcao = JOptionPane.showConfirmDialog(null, "Não foi possível remover " + quantidade + ingredienteEst.getUnidade() + " de " + ingredienteEst.getNomeItemEstoque() + " do estoque pois só tem " + ingredienteEst.getQuantidade() + ingredienteEst.getUnidade()
                            + "\nGostaria de remover mesmo assim?");
                    if (opcao == JOptionPane.YES_OPTION) {
                        ingredienteEst.setQuantidade(0);
                    }
                }
            }
        }
    }

    public void remEstoque(ItemEstoque ingrediente) {
        boolean itemExiste = false;
        for (ItemEstoque ingredienteEst : estoqueItens) {
            if (ingredienteEst.getNomeItemEstoque().equalsIgnoreCase(ingrediente.getNomeItemEstoque())) {
                ingrediente = ingredienteEst;
                itemExiste = true;
            }
        }
        if (itemExiste) {
            estoqueItens.remove(ingrediente);
            JOptionPane.showMessageDialog(null, ingrediente.getNomeItemEstoque() + " removido do estoque.");
        } else {
            JOptionPane.showMessageDialog(null, "Não existe " + ingrediente.getNomeItemEstoque() + " no estoque.");
        }
    }

    public int getEstoqueSize() {
        return estoqueItens.size();
    }

    public Object[][] getEstoque() {
        Object[][] ingredientes = new Object[estoqueItens.size()][3];
        for (int i = 0; i < estoqueItens.size(); i++) {
            ingredientes[i][0] = estoqueItens.get(i).getNomeItemEstoque();
            ingredientes[i][1] = estoqueItens.get(i).getQuantidade();
            ingredientes[i][2] = estoqueItens.get(i).getUnidade();
        }
        return ingredientes;
    }

}
