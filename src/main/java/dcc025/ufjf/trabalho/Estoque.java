/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class  Estoque
{
    
    public ArrayList<ItemEstoque> estoqueItens = new ArrayList<ItemEstoque>();
    
    
    public Estoque(){
        //this.estoqueItens.add(new ItemEstoque("BANANA",20,"Kg"));//pensar em como mudar o tipo da quantidade
        //this.estoqueItens.add(new ItemEstoque("ARROZ",30,"Kg")); // dependendo do tipo de ingrediente 
        //this.estoqueItens.add(new ItemEstoque("MAÇÂ",30,"Kg")); // kilo, litro , etc  
    }

    public ArrayList<ItemEstoque> getEstoqueItens() {
        return estoqueItens;
    }
    
   
    public void addEstoque(ItemEstoque ingrediente){
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while(w && i<estoqueItens.size()){
            if(ingrediente.getNomeItemEstoque().equals(estoqueItens.get(i).getNomeItemEstoque())){
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
    
    public void addEstoque(String nome, float quantidade, String unidade){
        boolean w = true;
        boolean jaExiste = false;
        int i = 0;
        while(w && i<estoqueItens.size()){
            if(nome.equals(estoqueItens.get(i).getNomeItemEstoque())){
                estoqueItens.get(i).setQuantidade(estoqueItens.get(i).getQuantidade() + quantidade);
                jaExiste = true;
                w = false;
            }
            i++;
        }
        if(!jaExiste){
            estoqueItens.add(new ItemEstoque(nome.trim(),quantidade, unidade));
        }
    }
    
    public void remEstoque(String ingredienteNome, int quantidade){
        
        ItemEstoque ingrediente = new ItemEstoque(ingredienteNome, quantidade, " ");
        
        boolean itemExiste = false;
        for(ItemEstoque ingredienteEst : estoqueItens){
            if(ingredienteEst.getNomeItemEstoque().equalsIgnoreCase(ingrediente.getNomeItemEstoque())){
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
    
     public void remEstoque(ItemEstoque ingrediente){
         boolean itemExiste = false;
         for(ItemEstoque ingredienteEst : estoqueItens){
             if(ingredienteEst.getNomeItemEstoque().equalsIgnoreCase(ingrediente.getNomeItemEstoque())){
                 ingrediente = ingredienteEst;
                 itemExiste = true;
             }
         }
         if(itemExiste){
            estoqueItens.remove(ingrediente);
            JOptionPane.showMessageDialog(null, ingrediente.getNomeItemEstoque() + " removido do estoque.");
         }else
            JOptionPane.showMessageDialog(null, "Não existe " + ingrediente.getNomeItemEstoque() + " no estoque.");
     }
     
     public int getEstoqueSize (){
         return estoqueItens.size();
     }
     
     public Object[][] getEstoque(){
         Object[][] ingredientes = new Object[estoqueItens.size()][3];
         for(int i=0;i<estoqueItens.size();i++) {
             ingredientes[i][0] = estoqueItens.get(i).getNomeItemEstoque();
             ingredientes[i][1] = estoqueItens.get(i).getQuantidade();
             ingredientes[i][2] = estoqueItens.get(i).getUnidade();
         }
         return ingredientes;
     }

   
     
}
