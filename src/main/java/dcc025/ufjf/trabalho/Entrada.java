/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.Date;

/**
 *
 * @author bruno
 */
public class Entrada extends Movimentacao {
    
    public Entrada(String nome, String descricao, Float valor) {
        super(nome, descricao, Math.abs(valor));
    }
    
}
