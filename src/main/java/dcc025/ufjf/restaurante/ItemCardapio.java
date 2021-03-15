package dcc025.ufjf.restaurante;

import java.util.*;

public class ItemCardapio {
    
    private String nome;
    private float preco;
    private Boolean disponivel;

    
    private List<ItemEstoque> ingredientesNecessarios = new ArrayList<ItemEstoque>();

    public ItemCardapio(String nome, float preco, Boolean disponivel) {
        this.nome = nome;
        this.preco = preco;
        this.disponivel = false;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
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
    
    public void addIngrediente(String nome, float quantidade, String unidade) {
        ItemEstoque novoIng = new ItemEstoque(nome.trim(), quantidade, unidade);
        ingredientesNecessarios.add(novoIng);
    }   
}
