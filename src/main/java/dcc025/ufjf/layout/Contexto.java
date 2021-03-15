package dcc025.ufjf.layout;

import dcc025.ufjf.restaurante.Caixa;
import dcc025.ufjf.restaurante.Estoque;
import dcc025.ufjf.restaurante.Cardapio;
import dcc025.ufjf.restaurante.ListaComandas;

public class Contexto {
    
    public Estoque estoque;
    public Cardapio cardapio;
    public Caixa caixa;
    public ListaComandas listaComandas;
    
    public Contexto() {
        estoque = new Estoque();
        cardapio = new Cardapio();
        caixa = new Caixa();
        listaComandas = new ListaComandas();
    }

}
