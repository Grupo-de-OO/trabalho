package dcc025.ufjf.layout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * @author
 *  Bruno de Oliveira Jucá - 201965013A
 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A
 *  Rômulo Chrispim de Mello - 201935038
 *  Lowrran Durao Matias - 201935036
 *  Pedro Henrique Moreira Raad - 201965215A
 */

public class Menu {

    private static JButton formataBotao(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150, 30));
        return button;

    }

    private static Contexto contexto = new Contexto();

    public static void main(String[] args) {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // Not worth my time
            }
        }
        
        JFrame frame = new JFrame();
        frame.addWindowListener(new frameEvent(contexto,frame));

        frame.setSize(900, 600);
        frame.setMinimumSize(frame.getSize());
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Restaurante");
        ImageIcon image = new ImageIcon("restaurante.png");
        frame.setIconImage(image.getImage());
        frame.getLayeredPane().setToolTipText("Restaurant Manager System");

        //Toolbar 
        JPanel pDireita = new JPanel();

        //Setando paineis secundários
        PainelEstoque pEstoque = new PainelEstoque(contexto);
        PainelCaixa pCaixa = new PainelCaixa(contexto);
        PainelComandas pComandas = new PainelComandas(contexto);
        PainelCardapio pCardapio = new PainelCardapio(contexto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(pDireita);
        pDireita.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 601, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pComandas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pComandas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //Add pDireita
        frame.add(BorderLayout.CENTER, pDireita);

        pCaixa.setVisible(false);
        pComandas.setVisible(true);
        pEstoque.setVisible(false);
        pCardapio.setVisible(false);

        //Setando painel principal da esquerda
        JPanel pEsquerda = new JPanel(); 

        pEsquerda.setLayout(null);
        pEsquerda.setPreferredSize(new Dimension(200, frame.getHeight()));

        JPanel pEsquerdaTitulo = new JPanel();
        pEsquerdaTitulo.setLayout(new BoxLayout(pEsquerdaTitulo, BoxLayout.Y_AXIS));

        JPanel pEsquerdaBotoes = new JPanel();
        pEsquerdaBotoes.setLayout(new BoxLayout(pEsquerdaBotoes, BoxLayout.Y_AXIS));

        //setando os botões da esquerda
        JButton botaoComandas = formataBotao("COMANDAS");
        JButton botaoCaixa = formataBotao("CAIXA");
        JButton botaoEstoque = formataBotao("ESTOQUE");
        JButton botaoCardapio = formataBotao("CARDAPIO");

        // Comandos dos botoes
        botaoEstoque.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pEstoque.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(false);
                pEstoque.setVisible(true);
                pCardapio.setVisible(false);
            }
        });

        botaoCardapio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCardapio.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(false);
                pEstoque.setVisible(false);
                pCardapio.setVisible(true);
            }
        });

        botaoCaixa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCaixa.atualizaPainel();
                pComandas.setVisible(false);
                pCaixa.setVisible(true);
                pEstoque.setVisible(false);
                pCardapio.setVisible(false);
            }
        });

        botaoComandas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pComandas.atualizaPainel();
                pComandas.setVisible(true);
                pCaixa.setVisible(false);
                pEstoque.setVisible(false);
                pCardapio.setVisible(false);
            }
        });

        //Adcionando botões pEsquerdaBotoes
        pEsquerdaBotoes.add(botaoComandas);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCaixa);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoEstoque);

        pEsquerdaBotoes.add(Box.createVerticalStrut(20));
        pEsquerdaBotoes.add(botaoCardapio);

        //Setando pEsquerdaTitulo    
        JLabel imagem = new JLabel(image);
        imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nomeRestaurante = new JLabel("THALEZIN DO CAPA");
        nomeRestaurante.setAlignmentX(Component.CENTER_ALIGNMENT);
        pEsquerdaTitulo.add(imagem);
        pEsquerdaTitulo.add(Box.createVerticalStrut(50));
        pEsquerdaTitulo.add(nomeRestaurante);
        pEsquerdaTitulo.add(Box.createVerticalStrut(100));
        
        //setando pEsquerda
        pEsquerda.setLayout(new BoxLayout(pEsquerda, BoxLayout.Y_AXIS));
        pEsquerda.add(pEsquerdaTitulo);
        pEsquerda.add(pEsquerdaBotoes);
        JPanel pEsquerdaAux = new JPanel();
        pEsquerdaAux.setLayout(new BoxLayout(pEsquerdaAux, BoxLayout.X_AXIS));
        pEsquerdaAux.add(pEsquerda);
        JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
        pEsquerdaAux.add(separador);
        pEsquerdaAux.add(Box.createGlue());

        //Add pEsquerda
        frame.add(BorderLayout.WEST, pEsquerdaAux);

        frame.setVisible(true);

    }

}
