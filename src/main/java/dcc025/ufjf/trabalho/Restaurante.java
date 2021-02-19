/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 
 * @author

 *  Bruno de Oliveira Jucá - 201965013A

 *  Thales Brito de Souza Fonseca Rodrigues - 201965191A

 *  Rômulo Chrispim de Mello - 201935038

 *  Lowrran Durao Matias - 201935036

 *  Pedro Henrique Moreira Raad - 201965215A
 
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
                String[] options2 = {"Ver estoque","Adicionar item ao estoque","Remover item do estoque"};
                int opcao2 = JOptionPane.showOptionDialog(null, "O que gostaria de fazer no estoque:", "ESTOQUE", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) + 1;
                switch(opcao2){
                    case 1:
                        estoque.verEstoque();
                        break;
                    case 2:
                        JTextField nome = new JTextField();
                        JTextField quantidade = new JTextField();
                        JTextField unidade = new JTextField();
                        Object[] novoIngrediente = {"Nome:", nome,"Quantidade:",quantidade,"Unidade:",unidade};
                        JOptionPane.showMessageDialog(null,novoIngrediente);
                        estoque.addEstoque(nome.getText(),Integer.parseInt(quantidade.getText()), unidade.getText());
                        break;
                    case 3:
                        break;
                }
                break;
             
                
                    
                 
        }
    
    }
}
