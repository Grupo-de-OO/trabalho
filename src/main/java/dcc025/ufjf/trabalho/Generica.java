/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;

/**
 *
 * @author thales
 */
public class Generica {
    
    String nomePrincipal;
    
    public Generica(String nomePrincipal){
        this.nomePrincipal = nomePrincipal;
        
    }
    
    public <T> void ver(ArrayList<T> itens)
    {
        System.out.println(" " + this.nomePrincipal + " -------------------");
        int i = 1;
        
        for(T item : itens)
        {
            System.out.println(i + " " + item);
            i++;
        }
   
    }
}