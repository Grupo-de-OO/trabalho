/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class Header extends JPanel {

    private JLabel title;
    private JSeparator separador = new JSeparator();
    private JPanel titleWrapper = new JPanel();
    
    public Header(String titleText) {
       
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        
        title = new JLabel(titleText);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new java.awt.Font("Tahoma", 1, 36));
        separador.setMaximumSize( new Dimension(3000, 3) );
        
        titleWrapper.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        titleWrapper.setMaximumSize( new Dimension(3000, 60) );
        titleWrapper.setPreferredSize(new Dimension(3000, 70) );
        titleWrapper.add(title, gbc);
        
        add(titleWrapper);
        add(separador);
    }
    
    
}
