package model.dao;

import java.util.List;

import entities.Autores;
import entities.Editoras;
import entities.Livros;
import entities.RelLivrosAutores;
import entities.RelLivrosEditoras;
import entities.RelTudo;

public interface Dao {

    // MÉTODOS DE BUSCA
    public List<Livros> listarTodosLivros();
    public List<Editoras> listarTodasEditoras();
    public List<Autores> listarTodosAutores();
    public List<RelTudo> listarTudo();
    public List<Livros> buscarLivroSelecionado(String nome);
    public List<Editoras> buscarEditoraSelecionada(String nome);
    public List<Autores> buscarAutorSelecionado(String nome);
    public List<RelLivrosAutores> buscarRelLivroAutor(String nome);
    public List<RelLivrosEditoras> buscarRelLivroEditora(String nome);
    public List<RelTudo> buscarTudo(String nome);
    public void InsertLivros(String titulo, String isbn, float preco, String nomeEditora, String name, String fname);
    public void InsertAutores(String Nome, String Sobrenome);
    public void InsertEditoras(String nomeEditora, String Url);
    public void apagarLivro(String isbn);
    public void apagarAutor(String nome, String sobrenome);
    public void apagarEditora(String nome);
    public void atualizarAutor(String novoNome, String novoSobrenome, String antigoNome, String antigoSobrenome );
    public void atualizarLivro(String novoTitulo, float novoPreco, String antigoTitulo, float antigoPreco);
    public void atualizarEditora(String novoNome, String novaURL, String antigoNome, String antigaURL);
}
