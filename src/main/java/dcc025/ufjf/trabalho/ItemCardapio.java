/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.*;
/**
 *
 * @author bruno
 */
public class ItemCardapio {
    
    private String nome;
    private String descricao;
    private float preco;
    private List<Ingrediente> ingredientesNecessarios = new ArrayList<Ingrediente>();

    public ItemCardapio(String nome, String descricao, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    @Override
    public String toString (){
        return nome + "\n  " + descricao + "\n  R$" + preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public float getPreço() {
        return preco;
    }

    public void setPreço(float preco) {
        this.preco = preco;
    }

    public List<Ingrediente> getIngredientesNecessarios() {
        return ingredientesNecessarios;
    }

    public void setIngredientesNecessarios(List<Ingrediente> ingredientesNecessarios) {
        this.ingredientesNecessarios = ingredientesNecessarios;
    }
    
}
