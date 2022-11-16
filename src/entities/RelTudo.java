package entities;

public class RelTudo {

    Autores sobrenome;
    Autores nomeAutor;
    Livros titulo;
    Livros isbn;
    Livros preco;
    Editoras nomeEditora;
    Editoras url;
    

    public RelTudo(Autores aSobrenome, Autores aNomeAutor, Livros aTitulo, Livros aIsbn, Livros aPreco, Editoras aNomeEditora, Editoras aUrl)
    {

        this.sobrenome = aSobrenome;
        this.nomeAutor = aNomeAutor;
        this.titulo = aTitulo;
        this.isbn = aIsbn;
        this.preco = aPreco;
        this.nomeEditora = aNomeEditora;
        this.url = aUrl;
     }

    // MÉTODOS GETTERS

    public Autores getSobrenome() {
        return sobrenome;
    }

    public Autores getNomeAutor() {
        return nomeAutor;
    }

    public Livros getTitulo() {
        return titulo;
    }

    public Livros getIsbn() {
        return isbn;
    }

    public Livros getPreco() {
        return preco;
    }

    public Editoras getNomeEditora() {
        return nomeEditora;
    }

    public Editoras getUrl() {
        return url;
    }

    // MÉTODOS SETTERS

    public void setSobrenome(Autores sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNomeAutor(Autores nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setTitulo(Livros titulo) {
        this.titulo = titulo;
    }
    
    public void setIsbn(Livros isbn) {
        this.isbn = isbn;
    }

    public void setPreco(Livros preco) {
        this.preco = preco;
    }

    public void setNomeEditora(Editoras nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public void setUrl(Editoras url) {
        this.url = url;
    }


}
