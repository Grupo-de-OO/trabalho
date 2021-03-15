package dcc025.ufjf.layout;

import dcc025.ufjf.trabalho.Caixa;
import dcc025.ufjf.trabalho.Estoque;
import dcc025.ufjf.trabalho.Cardapio;
import dcc025.ufjf.trabalho.ListaComandas;

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
