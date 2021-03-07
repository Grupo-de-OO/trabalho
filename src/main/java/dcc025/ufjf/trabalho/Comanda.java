/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import dcc025.ufjf.layout.Contexto;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    public void inserePedido(){
        //Pedidos teste
        pedidos.add(new ItemComanda(new ItemCardapio("Banana", 150), 3));
        valorTotal += 450;
        pedidos.add(new ItemComanda(new ItemCardapio("Maçâ", 20), 5));
        valorTotal += 100;
    }
    
    public void removePedido(){}
    
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