package dcc025.ufjf.restaurante;

public class Entrada extends Movimentacao {
    
    public Entrada(String nome, String descricao, Float valor) {
        super(nome, descricao, Math.abs(valor));
    }
    
}
