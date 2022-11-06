package model.entidades;

public class RelLivrosAutores {

    private Autores sobrenome;
    private Autores nome;
    private Livros titulo;
    private Livros isbn;
    private Livros preco;

    public RelLivrosAutores(Autores aSobrenome, Autores aNome, Livros aTitulo, Livros aIsbn, Livros aPreco){
        this.sobrenome = aSobrenome;
        this.nome = aNome;
        this.titulo = aTitulo;
        this.isbn = aIsbn;
        this.preco = aPreco;
    }

    public Autores getNome() {
        return nome;
    }

    public Livros getIsbn() {
        return isbn;
    }

    public Livros getPreco() {
        return preco;
    }
    
    public Autores getSobrenome() {
        return sobrenome;
    }

    public Livros getTitulo() {
        return titulo;
    }
    
}
