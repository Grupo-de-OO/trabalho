/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Cardapio {
    List<String> Itens = new ArrayList<String>();
    
    public Cardapio () {
        Itens.add("Romulo picado");
        Itens.add("Thales");
        Itens.add("Júca flambado");
    }
    
    public void verCardapio (){
        System.out.println("Cardapio -------------------");
        int i = 1;
        for(String item : Itens){
            System.out.println(i + " " + item);
            i++;
        }
    }
}
