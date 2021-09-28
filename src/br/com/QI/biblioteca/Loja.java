
package br.com.QI.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Loja {
    
    private List<Livro> livros = new LinkedList<>();
    
    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public void setLivros(Livro lvr) {
        if(this.livros.stream().anyMatch((Livro livro) -> livro.getNomeDoLivro().toLowerCase().equals(lvr.getNomeDoLivro().toLowerCase())))throw new ValidacaoException("já existe um livro com esse nome"); 
        this.livros.add(lvr);
    }
    
    public List<Livro> colocarNoCarrinho(String f) {
        List<Livro> liv = new ArrayList<>();
        this.livros.stream().filter(livro -> livro.getNomeDoLivro().toLowerCase().equals(f.toLowerCase())).forEach(liv::add);
        this.livros.removeAll(liv);
        if(liv.isEmpty())throw new ValidacaoException("Não existe este livro"); 
        return liv;
    }
    
}
