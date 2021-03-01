/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class Painel extends JPanel {

    private JButton b, c;
    
    public Painel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        b = new JButton("bla");
        c = new JButton("cla");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(b);
        add(c);
        
        setBackground(Color.RED);
        setVisible(true);
    }
    
    
}
