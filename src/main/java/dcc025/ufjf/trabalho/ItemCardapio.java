/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

/**
 *
 * @author bruno
 */
public class ItemCardapio {
    
    private String nome;
    private String descricao;
    private String preço;

    public ItemCardapio(String nome, String descricao, String preço) {
        this.nome = nome;
        this.descricao = descricao;
        this.preço = preço;
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

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }
}
