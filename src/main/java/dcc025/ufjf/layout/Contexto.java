/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import dcc025.ufjf.trabalho.Estoque;
import dcc025.ufjf.trabalho.Cardapio;
/**
 *
 * @author bruno
 */
public class Contexto {
    
    Estoque estoque;
    Cardapio cardapio;
    
    public Contexto() {
        estoque = new Estoque();
        cardapio = new Cardapio();
        
    }

}
