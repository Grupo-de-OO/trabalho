/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class Cardapio {

    private ArrayList<ItemCardapio> Itens = new ArrayList<ItemCardapio>();

    public void addCardapio(String nome, float preco, Boolean disponivel) {
        ItemCardapio item = new ItemCardapio(nome.trim(), preco, disponivel);
        this.Itens.add(item);
        Itens.add(new ItemCardapio("Banana", 150, disponivel));
        Itens.add(new ItemCardapio("Maçâ", 20, disponivel));
    }

    public ArrayList<ItemCardapio> getItens() {
        return Itens;
    }
    
    
    
    public void addCardapio(ItemCardapio item) {
        this.Itens.add(item);
    }

    public Object getNomeCardapio() {
        Object[] nomes = new Object[Itens.size()];
        for (int i = 0; i < Itens.size(); i++) {
            nomes[i] = Itens.get(i).getNome();
        }
        return nomes;
    }

    public Object[][] getCardapio() {
        Object[][] itensCardapio = new Object[Itens.size()][3];
        for (int i = 0; i < Itens.size(); i++) {
            itensCardapio[i][0] = Itens.get(i).getNome();
            itensCardapio[i][1] = "R$" + new DecimalFormat("0.00").format(Itens.get(i).getPreco());
            itensCardapio[i][2] = Itens.get(i).getDisponivel();
        }
        return itensCardapio;
    }
    
    public Object[][] getCardapioTemp() {
        Object[][] itensCardapio = new Object[Itens.size()][4];
        for (int i = 0; i < Itens.size(); i++) {
            itensCardapio[i][0] = Itens.get(i).getNome();
            itensCardapio[i][1] = "R$" + new DecimalFormat("0.00").format(Itens.get(i).getPreco());
            itensCardapio[i][2] = Itens.get(i).getDisponivel();
            String ingString = "";
            for (ItemEstoque ingrediente : Itens.get(i).getIngredientesNecessarios()) {
                ingString = ingString + ingrediente.toString() + ", ";
            }
            itensCardapio[i][3] = ingString;          
        }
        return itensCardapio;
    }

    public boolean remItem(String nome) {
        boolean itemExiste = false;
        for (int i = 0; i < Itens.size(); i++) {
            if (Itens.get(i).getNome().toLowerCase().trim().equals(nome)) {
                ItemCardapio aux = Itens.get(i);
                itemExiste = true;
                Itens.remove(aux);
                JOptionPane.showMessageDialog(null, aux.getNome() + " removido do cardápio","Item Removido",JOptionPane.WARNING_MESSAGE);
            } else {
                itemExiste = false;
            }
        }
        return itemExiste;
    }

    
}
