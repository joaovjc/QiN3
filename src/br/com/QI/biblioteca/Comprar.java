/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.QI.biblioteca;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joaovjc
 */
public class Comprar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();
        List<Livro> carrinho = new LinkedList<>();
        loja.setLivros(new Livro("Java Para Iniciantes", new BigDecimal("1500.0")));
        loja.setLivros(new Livro("Java Intermediario", new BigDecimal("300.0")));
        loja.setLivros(new Livro("Java avançado", new BigDecimal("200.0")));
        loja.setLivros(new Livro("Java Servlet", new BigDecimal("1000.0")));
        loja.setLivros(new Livro("Maven", new BigDecimal("3000.0")));
        loja.setLivros(new Livro("Java Rest", new BigDecimal("200.0")));
        loja.setLivros(new Livro("AJAX", new BigDecimal("1250.0")));
        
        String f;
        System.out.println("Estes são os livros a venda: ");
        
        do{
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            loja.getLivros().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                    + "Digite o nome do Livro que quer colocar em seu carrinho(para sair digite 'sair'): ");
            
            f = sc.nextLine();
            if(!(f.toLowerCase().equals("sair"))){
                try {
                    carrinho.addAll(loja.colocarNoCarrinho(f));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }while(!f.toLowerCase().equals("sair"));
         
        System.out.println((carrinho.isEmpty()) ? "obrigado por olhar nossa loja" 
            : "o Total sera de: R$" 
                + ((carrinho.size() >= 5) ? carrinho.stream().mapToDouble(livro -> (livro.getPreco().doubleValue() * 0.5)).sum() : carrinho.stream().mapToDouble(livro -> livro.getPreco().doubleValue()).sum()));
        sc.close();
    }
        
        
}
