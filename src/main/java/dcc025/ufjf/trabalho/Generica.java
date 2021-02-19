/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
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