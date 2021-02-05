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
    ArrayList<ItemCardapio> Itens = new ArrayList<ItemCardapio>();
    
    public Cardapio () {
        Itens.add(new ItemCardapio("a","a",100.50f));
        Itens.add(new ItemCardapio("b","b",150.50f));
        Itens.add(new ItemCardapio("c","c",50.50f));
        
    }
    
    public void verCardapio (){
    /*
        System.out.println("Cardapio -------------------");
        int i = 1;
        for(ItemCardapio item : Itens){
            System.out.println(i + " " + item);
            i++;
        }
    }
    */
       Generica imprimeCardapio = new Generica("CARDAPIO");
       imprimeCardapio.ver(this.Itens);



}
}