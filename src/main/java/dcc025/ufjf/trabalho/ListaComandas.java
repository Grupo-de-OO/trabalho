/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import dcc025.ufjf.layout.Contexto;
import java.util.ArrayList;
import java.util.List;
import dcc025.ufjf.trabalho.Comanda;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class ListaComandas {

    static int totalComandas = 0;

    List<Comanda> listaComandas = new ArrayList<Comanda>();

    public void fechaComanda(int id, Contexto ctx) {
        ctx.caixa.addEntrada("Conta #" + listaComandas.get(id).getId(), "Conta Paga", listaComandas.get(id).getValorTotal());
        listaComandas.remove(id);
    }

    public void insereComanda() {
        listaComandas.add(new Comanda());
    }

    public int getTotalComandas() {
        return totalComandas;
    }

    public void setTotalComandas(int totalComandas) {
        this.totalComandas = totalComandas;
    }

    public List<Comanda> getListaComandas() {
        return listaComandas;
    }

    public void setListaComandas(List<Comanda> listaComandas) {
        this.listaComandas = listaComandas;
    }

}
