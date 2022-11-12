package model.entidades;

import java.util.concurrent.atomic.AtomicBoolean;

public class RelLivrosEditoras {

     private Livros titulo;
     private Livros preco;
     private Livros isbn;
     private Editoras nome;
     private Editoras url;

     public RelLivrosEditoras(Livros aTitulo, Livros aPreco, Livros aIsbn, Editoras aNome, Editoras aUrl){
        this.titulo = aTitulo;
        this.preco = aPreco;
        this.isbn = aIsbn;
        this.nome = aNome;
        this.url = aUrl;
     }

     public Editoras getNome() {
         return nome;
     }

     public Livros getPreco() {
         return preco;
     }

     public Livros getTitulo() {
         return titulo;
     }

     public Editoras getUrl() {
         return url;
     }

     public void setNome(Editoras nome) {
         this.nome = nome;
     }

     public void setPreco(Livros preco) {
         this.preco = preco;
     }
     
     public void setTitulo(Livros titulo) {
         this.titulo = titulo;
     }

     public void setUrl(Editoras url) {
         this.url = url;
     }


     
    
}
