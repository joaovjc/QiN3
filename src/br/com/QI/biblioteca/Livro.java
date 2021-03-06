/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.QI.biblioteca;

import java.math.BigDecimal;

public class Livro {
    
    private String nomeDoLivro;
    private BigDecimal preco;
    
    public Livro(String nomeDoLivro, BigDecimal preco) {
        if (nomeDoLivro == null)throw new ValidacaoException("O Nome Do Livro não pode ser null");
        this.nomeDoLivro = nomeDoLivro;
        this.preco = preco;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "[ O nome do livro é: " + this.nomeDoLivro + "| e o Preço é: " + this.preco + " ]"; 
    }
    
}
