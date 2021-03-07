/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.*;
/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class ItemCardapio {
    
    private String nome;
    private float preco;
    private int quantidade;//quantidade que possui disponivel para ser vendida

    
    private List<ItemEstoque> ingredientesNecessarios = new ArrayList<ItemEstoque>(); //pensar no item estoque antes de adicionar no cardapio

    public ItemCardapio(String nome, float preco,int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public List<ItemEstoque> getIngredientesNecessarios() {
        return ingredientesNecessarios;
    }

    public void setIngredientesNecessarios(List<ItemEstoque> ingredientesNecessarios) {
        this.ingredientesNecessarios = ingredientesNecessarios;
    }
    
}
