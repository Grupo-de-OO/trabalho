/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
 */
public class Caixa {
    
    private float saldoDoDia = 0;
    private float valorEmCaixa = 0;
    private List<Movimentacao> transacoes = new ArrayList<Movimentacao>();
    
    
    public void addEntrada(String nome, String descricao, Float valor) {
        Entrada novaEntrada = new Entrada(nome, descricao, valor);
        transacoes.add(novaEntrada);
    }
    
    public Object[][] getCaixa(){
         Object[][] caixa = new Object[transacoes.size()][4];
         for(int i=0;i<transacoes.size();i++) {
             caixa[i][0] = transacoes.get(i).getData();
             caixa[i][1] = transacoes.get(i).getNome();
             caixa[i][2] = transacoes.get(i).getDescricao();
             caixa[i][3] = transacoes.get(i).getValor();
         }
         return caixa;
    }
}