/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class ItemEstoque {
    
    private String nomeItemEstoque;
    private int quantidade;
    private String unidade;
    
    public ItemEstoque(String nome, int quantidade, String unidade)
    {
        this.nomeItemEstoque = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }


    //Getters e Setters--------------------------------------
    public String getNomeItemEstoque() {
        return nomeItemEstoque;
    }

    public void setNomeItemEstoque(String nomeItemEstoque) {
        this.nomeItemEstoque = nomeItemEstoque;
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