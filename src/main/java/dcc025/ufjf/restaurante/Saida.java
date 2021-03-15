package dcc025.ufjf.restaurante;

import java.util.Date;

public class Saida extends Movimentacao {

    public Saida(String nome, String descricao, Float valor) {
        super(nome, descricao, (-1 * Math.abs(valor)));
    }
    
}
