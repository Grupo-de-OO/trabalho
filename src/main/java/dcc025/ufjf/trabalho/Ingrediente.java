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
public class Ingrediente {
    
    private String nomeIngrediente;
    private int quantidade;
    private String unidade;
    
    public Ingrediente(String nome, int quantidade, String unidade)
    {
        this.nomeIngrediente = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

@Override
    public String toString (){
        return nomeIngrediente +" :   " + quantidade;
    }
    
    //Getters e Setters--------------------------------------
    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}