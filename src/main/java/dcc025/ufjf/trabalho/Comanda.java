/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import dcc025.ufjf.layout.Contexto;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class Comanda {
    
    private int id;
    private float valorTotal = 0 ;
    private List<ItemComanda> pedidos = new ArrayList<ItemComanda>();
    
    public Comanda(){
        id = ListaComandas.totalComandas++;
    }
    
    public void inserePedido(Contexto ctx){
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel cardapioAux = new JPanel();
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.X_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.Y_AXIS));
        cardapioAux.setBorder(BorderFactory.createTitledBorder("Cardápio"));
        cardapioAux.setLayout(new BorderLayout());
        JList<String> cardapio = new JList<String>();
        cardapio.setPreferredSize(new Dimension(150, 300));
        cardapio.setMinimumSize(new Dimension(150, 300));
        cardapio.setMaximumSize(new Dimension(150, 300));
        cardapio.setListData(ctx.cardapio.getVetCardapio());
        JLabel quantidadeLabel = new JLabel("Quantidade: ");
        quantidadeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField quantidadeField = new JTextField();
        quantidadeField.setMaximumSize(new Dimension(120, 15));
        quantidadeField.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardapioAux.add(cardapio);
        painel2.add(quantidadeLabel);
        painel2.add(quantidadeField);
        painel2.add(Box.createGlue());
        painel1.add(cardapioAux);
        painel1.add(Box.createRigidArea(new Dimension(20, 300)));
        painel1.add(painel2);
        
        boolean w = true;
        ItemComanda novoItemComanda = new ItemComanda(null, 0);
        while(w){
            try {
                boolean existeItem = false;
                JOptionPane.showMessageDialog(null, painel1);
                for (int i = 0; i < pedidos.size(); i++) {
                    if(pedidos.get(i).getItemCardapio().getNome().equals(cardapio.getSelectedValue())){
                        pedidos.get(i).setQuantidade(pedidos.get(i).getQuantidade() + Float.parseFloat(quantidadeField.getText()));
                        valorTotal += pedidos.get(i).getItemCardapio().getPreco()*Float.parseFloat(quantidadeField.getText());
                        existeItem = true;
                        novoItemComanda = pedidos.get(i);
                    }
                }
                if(!existeItem){
                    pedidos.add(new ItemComanda(ctx.cardapio.getItens().get(cardapio.getSelectedIndex()), Float.parseFloat(quantidadeField.getText())));
                    valorTotal += ctx.cardapio.getItens().get(cardapio.getSelectedIndex()).getPreco()*Integer.parseInt(quantidadeField.getText());
                    novoItemComanda =  pedidos.get(pedidos.size()-1);
                }
                w = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Selecione algum item", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número válido no campo quantidade", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            for(int i = 0; i < novoItemComanda.getItemCardapio().getIngredientesNecessarios().size();i++)
            ctx.estoque.remEstoque(novoItemComanda.getItemCardapio().getIngredientesNecessarios().get(i).getNomeItemEstoque(),Float.parseFloat(quantidadeField.getText())*novoItemComanda.getItemCardapio().getIngredientesNecessarios().get(i).getQuantidade());
        }
    }
    
    public void removePedido(int indice){
        valorTotal-=(pedidos.get(indice).getItemCardapio().getPreco())*(pedidos.get(indice).getQuantidade());
        pedidos.remove(indice);
    }
    
    public Object[][] getComanda(){
         Object[][] itensComanda = new Object[pedidos.size()][3];
         for(int i=0;i<pedidos.size();i++) {
             itensComanda[i][0] = pedidos.get(i).getItemCardapio().getNome();
             itensComanda[i][1] = pedidos.get(i).getQuantidade();
             itensComanda[i][2] = "R$" + new DecimalFormat("0.00").format(pedidos.get(i).getItemCardapio().getPreco());}
         return itensComanda;
     }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemComanda> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemComanda> pedidos) {
        this.pedidos = pedidos;
    }
    
}