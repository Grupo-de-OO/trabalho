package dcc025.ufjf.restaurante;

import java.util.Date;

public class Movimentacao { 
    
    private Date data;
    private String nome;
    private String descricao;
    private Float valor;

    public Movimentacao(String nome, String descricao, Float valor) {
        this.data = new Date();
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public Movimentacao(String nome, String descricao, Float valor, Date data) {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
