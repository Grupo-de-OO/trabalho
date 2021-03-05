/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

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
    
   
    public void addCardapio(String nome, float preco){
      ItemCardapio item = new ItemCardapio(nome,preco);
      this.Itens.add(item);
        
    }
    
    
    
    public Object[][] getCardapio(){
         Object[][] itensCardapio = new Object[Itens.size()][3];
         for(int i=0;i<Itens.size();i++) {
             itensCardapio[i][0] = Itens.get(i).getNome();
             itensCardapio[i][1] = Itens.get(i).getPreço();}
         return itensCardapio;
     }
    
    public void removeItem(){
    //criar um remove de acordo com o nome que se deseja remover
    }
    
    

}