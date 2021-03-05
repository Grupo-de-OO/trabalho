/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bruno
 */
public class PainelCaixa extends JPanel {

    private JPanel header = new Header("Caixa");
    private JPanel main = new JPanel();

    public PainelCaixa() {

        // A ideia seria desenvolver a pagina dentro do JPanel main, podendo alterar o layout dele
        // sem problemas, sem quebrar a pagina. nao setar o layout dos paineis diretamente pois  
        // dessa forma quebraria.
        // Ex: main.setLayout(new blablaLayout());
        // e a partir dai add os componentes com main.add(Component);
        
        main.add(new JButton("Teste"));
        
        add(header);
        add(main);
   
    
    }
}
