/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import dcc025.ufjf.trabalho.Caixa;
import dcc025.ufjf.trabalho.Estoque;
import dcc025.ufjf.trabalho.Cardapio;
import dcc025.ufjf.trabalho.Comanda;
/**
 *
 * @author bruno
 */
public class Contexto {
    
    Estoque estoque;
    Cardapio cardapio;
    Caixa caixa;
    Comanda comanda;
    
    public Contexto() {
        estoque = new Estoque();
        cardapio = new Cardapio();
        caixa = new Caixa();
        comanda = new Comanda();
    }

}
