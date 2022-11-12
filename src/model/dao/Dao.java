package model.dao;

import model.entidades.Editoras;
import model.entidades.Autores;
import model.entidades.Livros;
import model.entidades.RelLivrosAutores;
import model.entidades.RelLivrosEditoras;
import model.entidades.RelTudo;

import java.util.List;

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
    public void InsertLivros(Livros livros);
    public void InsertAutores(Autores autores);
    public void InsertEditoras(Editoras editoras);
    public void apagarLivro(String isbn);
    public void apagarAutor(Integer ID);
    public void apagarEditora(Integer ID);
    

}
