package dcc025.ufjf.restaurante;

public class ItemEstoque {
    
    private String nomeItemEstoque;
    private float quantidade;
    private String unidade;
    
    public ItemEstoque(String nome, float quantidade, String unidade)
    {
        this.nomeItemEstoque = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return (this.quantidade + " " + this.unidade + " de " + this.nomeItemEstoque);
    }
  
    public String getNomeItemEstoque() {
        return nomeItemEstoque;
    }

    public void setNomeItemEstoque(String nomeItemEstoque) {
        this.nomeItemEstoque = nomeItemEstoque;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}