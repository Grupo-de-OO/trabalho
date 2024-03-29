package dcc025.ufjf.restaurante;

public class ItemComanda {
    private ItemCardapio itemCardapio;
    private float quantidade;

    public ItemComanda(ItemCardapio itemCardapio, float quantidade) {
        this.itemCardapio = itemCardapio;
        this.quantidade = quantidade;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
}
