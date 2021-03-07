/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author bruno
 */
public class PainelComandas extends JPanel {

    private JPanel header = new Header("Comandas");
    private JPanel main = new JPanel();
    
    private JComboBox<Integer> comandas = new JComboBox<Integer>();

    private Contexto contexto;
    private JPanel wrapper1 = new JPanel();

    public PainelComandas(Contexto ctx) {

        // A ideia seria desenvolver a pagina dentro do JPanel main, podendo alterar o layout dele
        // sem problemas, sem quebrar a pagina. nao setar o layout dos paineis diretamente pois  
        // dessa forma quebraria.
        // Ex: main.setLayout(new blablaLayout());
        // e a partir dai add os componentes com main.add(Component);
        contexto = ctx;
        
        wrapper1.setLayout(new BoxLayout(wrapper1, BoxLayout.X_AXIS));
        wrapper1.add(comandas);
        main.add(wrapper1);
        
        add(header);
        add(main);
    }
    
    
}
