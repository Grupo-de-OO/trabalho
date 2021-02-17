/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thales
 */
public class  Estoque
{
    
    private ArrayList<Ingrediente> estoqueItens = new ArrayList<Ingrediente>();
    
    public Estoque(){
        this.estoqueItens.add(new Ingrediente("BANANA",20,"Kg"));//pensar em como mudar o tipo da quantidade
        this.estoqueItens.add(new Ingrediente("ARROZ",30,"Kg")); // dependendo do tipo de ingrediente 
        this.estoqueItens.add(new Ingrediente("MAÇÂ",30,"Kg")); // kilo, litro , etc  
    }
    
    public void verEstoque(){
        Generica imprimeEstoque = new Generica("ESTOQUE");  
        imprimeEstoque.ver(estoqueItens);                  
    }
    
    public void addEstoque(Ingrediente ingrediente){
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while(w && i<estoqueItens.size()){
            if(ingrediente.getNomeIngrediente().equals(estoqueItens.get(i).getNomeIngrediente())){
                estoqueItens.get(i).setQuantidade(estoqueItens.get(i).getQuantidade() + ingrediente.getQuantidade());
                jaExiste = true;
                w = false;
            }
            i++;
        }
        if(!jaExiste){
            estoqueItens.add(ingrediente);
        }
    }
    
    public void addEstoque(String nome, int quantidade, String unidade){
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while(w && i<estoqueItens.size()){
            if(nome.equals(estoqueItens.get(i).getNomeIngrediente())){
                estoqueItens.get(i).setQuantidade(estoqueItens.get(i).getQuantidade() + quantidade);
                jaExiste = true;
                w = false;
            }
            i++;
        }
        if(!jaExiste){
            estoqueItens.add(new Ingrediente(nome,quantidade, unidade));
        }
    }
    
    public void remEstoque(Ingrediente ingrediente, int quantidade){
        boolean itemExiste = false;
        for(Ingrediente ingredienteEst : estoqueItens){
            if(ingredienteEst.getNomeIngrediente().equals(ingrediente.getNomeIngrediente())){
                if(ingredienteEst.getQuantidade() - quantidade >= 0){
                    ingredienteEst.setQuantidade(ingredienteEst.getQuantidade() - quantidade);
                    System.out.println("Foram removidos " + quantidade + ingredienteEst.getUnidade() + " do estoque.");
                    itemExiste = true;
                }else{
                    int opcao = JOptionPane.showConfirmDialog(null,"Não foi possível remover " + quantidade + ingredienteEst.getUnidade() + " do estoque pois só tem " + ingredienteEst.getQuantidade() + ingredienteEst.getUnidade()
                                      + "\nGostaria de remover mesmo assim?");
                    if(opcao==JOptionPane.YES_OPTION){
                        itemExiste = false;
                        ingrediente = ingredienteEst;
                    }
                }
            }
        }
        if(!itemExiste)
            remEstoque(ingrediente);
    }
    
     public void remEstoque(Ingrediente ingrediente){
         boolean itemExiste = false;
         for(Ingrediente ingredienteEst : estoqueItens){
             if(ingredienteEst.getNomeIngrediente().equals(ingrediente.getNomeIngrediente())){
                 ingrediente = ingredienteEst;
                 itemExiste = true;
             }
         }
         if(itemExiste){
            estoqueItens.remove(ingrediente);
            JOptionPane.showMessageDialog(null, ingrediente.getNomeIngrediente() + " removido do estoque.");
         }else
            JOptionPane.showMessageDialog(null, "Não existe " + ingrediente.getNomeIngrediente() + " no estoque.");
     }
     
     public int getEstoqueSize (){
         return estoqueItens.size();
     }
}
