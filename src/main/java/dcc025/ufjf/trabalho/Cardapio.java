/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.List;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class Cardapio {
    
    private ArrayList<ItemCardapio> Itens = new ArrayList<ItemCardapio>();
    
    public Cardapio () {
        Itens.add(new ItemCardapio("a","a",100.50f));
        Itens.add(new ItemCardapio("b","b",150.50f));
        Itens.add(new ItemCardapio("c","c",50.50f));
        
    }
    
    public void addItem(){}
    public void removeItem(){}
    
    
    
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