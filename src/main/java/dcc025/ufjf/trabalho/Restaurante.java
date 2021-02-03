/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.ufjf.trabalho;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Restaurante {
    public static Cardapio cardapio = new Cardapio();
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu (){
        Scanner scan = new Scanner(System.in);
        int opcao;
        System.out.println("BEM VINDO!");
        System.out.println("O que gostaria de fazer: ");
        System.out.println("(1) CARDAPIO");
        System.out.println("(2) CONTAS");
        System.out.println("(3) ESTOQUE");
        opcao = scan.nextInt();
        
        if(opcao==1){
            cardapio.verCardapio();
        }
    }
}
