/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class Restaurante {
    
    public static Cardapio cardapio = new Cardapio();
    public static Estoque estoque = new Estoque();
    
    
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu (){
        
        Integer[] options = {1, 2, 3};
        
        int opcao = JOptionPane.showOptionDialog(null, "O que gostaria de admnistrar: \n (1) CARDAPIO \n (2) CONTAS   \n (3) ESTOQUE     ", "BEM VINDO !!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]) + 1;
        
        
        switch(opcao){
            case 1:
                cardapio.verCardapio(); 
                break;
            case 3:
                estoque.verEstoque();
                break;
             
                
                    
                 
        }
    
    }
}
