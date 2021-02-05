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
 * @author thales
 */
public class  Estoque
{
    
    ArrayList<Ingredientes> estoqueItens = new ArrayList<Ingredientes>();
    
    public Estoque(){
        this.estoqueItens.add(new Ingredientes("BANANA",20));
        this.estoqueItens.add(new Ingredientes("ARROZ",30)); //pensar em como mudar o tipo da quantidade
        this.estoqueItens.add(new Ingredientes("MAÇÂ",30)); // dependendo do tipo de ingrediente 
                                                          // kilo, litro , etc  
     
    }
    
    public void verEstoque(){
    
        Generica imprimeEstoque = new Generica("ESTOQUE");  
        imprimeEstoque.ver(estoqueItens);                  
        
        
        
        
        
    }
    
    
    
    
    
    

    
    
}
