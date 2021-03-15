package dcc025.ufjf.restaurante;

import dcc025.ufjf.layout.Contexto;
import java.util.ArrayList;
import java.util.List;

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
