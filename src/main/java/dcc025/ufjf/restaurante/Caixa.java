package dcc025.ufjf.restaurante;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Caixa {
    
    private float saldoDoDia = 0;
    private float valorEmCaixa = 0;
    private ArrayList<Movimentacao> transacoes = new ArrayList<Movimentacao>();
    
    public void addMovimentacao(String nome, String descricao, Float valor, Date data) {
        Movimentacao novaMovimentacao = new Movimentacao(nome, descricao, valor, data);
        valorEmCaixa += valor;
        transacoes.add(novaMovimentacao);
    }
    
    public void addEntrada(String nome, String descricao, Float valor) {
        Entrada novaEntrada = new Entrada(nome, descricao, valor);
        valorEmCaixa += valor;
        transacoes.add(novaEntrada);
    }
    
    public void addSaida(String nome, String descricao, Float valor) {
        Saida novaSaida = new Saida(nome, descricao, valor);
        valorEmCaixa -= valor;
        transacoes.add(novaSaida);
    }
    
    public Object[][] getCaixa(){
        Object[][] caixa = new Object[transacoes.size()][4];
        for(int i=0;i<transacoes.size();i++) {
            caixa[i][0] = transacoes.get(i).getData().get(Calendar.DAY_OF_MONTH) + "/" + transacoes.get(i).getData().get(Calendar.MONTH) + "/" + transacoes.get(i).getData().get(Calendar.YEAR) + " " + transacoes.get(i).getData().get(Calendar.HOUR_OF_DAY) + ":" + transacoes.get(i).getData().get(Calendar.MINUTE);
            caixa[i][1] = transacoes.get(i).getNome();
            caixa[i][2] = transacoes.get(i).getDescricao();
            caixa[i][3] = "R$" + (new DecimalFormat("0.00").format(transacoes.get(i).getValor()));
        }
        return caixa;
    }

    public float getSaldoDoDia() {
        return saldoDoDia;
    }

    public void setSaldoDoDia(float saldoDoDia) {
        this.saldoDoDia = saldoDoDia;
    }

    public float getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(float valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }

    public ArrayList<Movimentacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<Movimentacao> transacoes) {
        this.transacoes = transacoes;
    }
    
}