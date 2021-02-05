/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

/**
 *
 * @author thales
 */
public class Ingredientes {
    
    String nomeIngrediente;
    int quantidade;
    
    public Ingredientes(String nome, int quantidade)
    {
        this.nomeIngrediente = nome;
        this.quantidade = quantidade;
        
    }

@Override
    public String toString (){
        return nomeIngrediente +" :   " + quantidade;    
      


}

}