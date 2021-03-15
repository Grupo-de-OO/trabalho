package dcc025.ufjf.layout;

import dcc025.ufjf.restaurante.ItemCardapio;
import dcc025.ufjf.restaurante.ItemEstoque;
import dcc025.ufjf.restaurante.Movimentacao;
import dcc025.ufjf.utils.Arquivo;
import dcc025.ufjf.utils.Json;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameEvent implements WindowListener {

    private Contexto ctx;
    private JFrame frame;
    
    public FrameEvent(Contexto ctx, JFrame frame) {
        this.ctx = ctx;
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent we) {
        // carrega estoque
        try{
            String lerArquivo = Arquivo.lerArquivo("jsons//estoque.json");
            List<ItemEstoque> itens = Json.toEstoque(lerArquivo);

            for(int i = 0;i<itens.size();i++){
                ctx.estoque.addEstoque(itens.get(i).getNomeItemEstoque(),itens.get(i).getQuantidade(),itens.get(i).getUnidade());
            }   
        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
        // carrega cardapio
        try {
            String lerArquivo = Arquivo.lerArquivo("jsons//cardapio.json");
            List<ItemCardapio> itens = Json.toCardapio(lerArquivo);

            for (int i = 0; i < itens.size(); i++) {
                ctx.cardapio.addCardapio(itens.get(i));
            }
        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
        // carrega caixa
        try {
            String lerArquivo = Arquivo.lerArquivo("jsons//caixa.json");
            List<Movimentacao> itens = Json.toCaixa(lerArquivo);

            for (int i = 0; i < itens.size(); i++) {
                ctx.caixa.addMovimentacao(itens.get(i).getNome(), itens.get(i).getDescricao(), itens.get(i).getValor(), itens.get(i).getData());
            }
        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
    
    }

    @Override
    public void windowClosing(WindowEvent we) {
        JLabel txt = new JLabel("Se você fechar o programa perderá as comandas.");
        JLabel txt2 = new JLabel("Deseja fechar o programa mesmo assim ?");
        txt.setAlignmentX(Component.CENTER_ALIGNMENT);
        txt2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel texto = new JPanel();
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));
        texto.add(txt);
        texto.add(txt2);
        if(ctx.listaComandas.getListaComandas().size() > 0 )
            escreveArquivos();
        if(JOptionPane.showConfirmDialog(frame, texto, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            escreveArquivos();
        }else
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    private void escreveArquivos(){
        ArrayList cardapio = ctx.cardapio.getItens();
        String json1 = Json.toJSON(cardapio);
        Arquivo.escreverArquivo("jsons//cardapio.json", json1);

        ArrayList estoque = ctx.estoque.getEstoqueItens();
        String json2 = Json.toJSON(estoque);
        Arquivo.escreverArquivo("jsons//estoque.json", json2);

        ArrayList transacoes = ctx.caixa.getTransacoes();
        String json3 = Json.toJSON(transacoes);
        Arquivo.escreverArquivo("jsons//caixa.json", json3);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
