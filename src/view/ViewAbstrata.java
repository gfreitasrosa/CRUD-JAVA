package view;

import java.awt.event.ActionListener;
import model.entidades.*;

public interface ViewAbstrata {

   public void initComponents();


   // *****************************
   // * MÉTODOS DA JANELA DELETAR *
   // *****************************

   public void deletar(ActionListener al);
   public boolean verificaEscolhaDeletarAutor();
   public boolean verificaEscolhaDeletarEditora();
   public boolean verificaEscolhaDeletarLivro();
   public String getTextoNomeAutor();
   public String getTextoSobrenomeAutor();
   public String getTextoISBN(); 
   public String getTextoEditora();
   public void atualizarMensagemConclusao(String mensagem);
   public void habilitarLivrosDeletar();
   public void habilitarAutorDeletar();
   public void habilitarEditorasDeletar();
   public void desabilitarTelaDeletar();
   public void habilitarTelasDeletar(ActionListener al);
   public void ajudaDeletar(ActionListener al);
   public void mensagemAjudaDeletar();

   //*****************************
   //* MÉTODOS DA JANELA INSERIR *
   //*****************************

   public void limpaAutoresInserir();
   public void camposInsLivros(ActionListener al);
   public void BtnAjudaInserir(ActionListener al);
   public void mensagemAjudaInserir();
   public void camposInsEditoras(ActionListener al);
   public void camposInsAutores(ActionListener al);
   public boolean verificaEscolhaInserirAutor();
   public boolean verificaEscolhaInserirEditora();
   public boolean verificaEscolhaInserirLivro();
   public void habilitaEditoras();
   public void habilitarAutor();
   public void habilitaLivros();
   public void habilitarTela();
   public void desabilitarTela();
   public void Inserir(ActionListener al);
   public String getNome();
   public String getSobrenome();
   public String getNomeEditora();
   public String getUrl();
   public String getInserirTitulo();
   public String getInserirPreco();
   public String getISBN();
   public String getInserirEditoras();
   public String getAutoresSelecionados();
   public String pesquisaInserir();
   public void attTextoAutorInserir(String texto);
   public void popUpAutorAbaInserir();
   public void addAutorInserir(ActionListener al);
   public void atualizaAutoresAbaInserir(int contador, Autores autor);
   public Boolean getOpcaoAutorAbaInserir();
   public Boolean getOpcaoEditoraAbaInserir();
   public Boolean getOpcaoLivroAbarInserir();
   public void attAutor(ActionListener al);

   //**************************
   //* MÉTODOS JANELA ALTERAR *
   //**************************

   public void ajudaAlterar(ActionListener al);
   public void mensagemAjudaAlterar(); // MENSAGEM POP-UP DO BOTÃO AJUDA
   public void pesquisaAutorAlterar(ActionListener al);
   public void popUpAutorAbaAlterar();
   public void pesquisarEditoraAlterar(ActionListener al);
   public void popUpEditorasAbaAlterar();
   public void atualizaAutoresAbaAlterar(int contador, Autores autor);
   public void atualizaLivrosAbaAlterar(int contador, Livros livro);
   public void atualizaEditorasAbaAlterar(int contador, Editoras editora);
   public void pesquisaLivrosAlterar(ActionListener al);
   public void popUpLivrosAbaAlterar();
   public boolean getLivrosAbaAlterar();
   public boolean getEditorasAbaAlterar();
   public boolean getAutorAbaAlterar();
   public void desabilitaTelaAlterar();
   public void habilitaAutorTelaAlterar();
   public void habilitaEditoriaTelaAlterar();
   public void habilitaLivroTelaAlterar();
   public void camposAlterarAutor(ActionListener al);
   public void camposAlterarEditoras(ActionListener al);
   public void camposAlterarLivros(ActionListener al);
   public void limpaTabelaAlterar();
   public String pesquisaAutorAlterar();
   public void attTextoAutorAlterar(String texto);
   public void attAutorAlterar(ActionListener al);
   public String pesquisaLivroAlterar();
   public void attLivroAlterar(ActionListener al);
   public void attTextoLivroAlterar(String texto);
   public String pesquisaEditoraAlterar();
   public void attEditoraAlterar(ActionListener al);
   public void attTextoEditoraAlterar(String texto);
   public String getAntigoNomeAutorAlterar();
   public String getAntigoSobrenomeAutorAlterar();
   public String getAntigoTituloLivroAlterar();
   public String getAntigoPrecoLivroAlterar();
   public String getAntigoNomeEditoraAlterar();
   public String getAntigaUrlAlterar();
   public String getNovoNomeAutorAlterar();
   public String getNovoSobrenomeAutorAlterar();
   public String getNovoTituloLivroAlterar();
   public String getNovoPrecoLivroAlterar();
   public String getNovoNomeEditoraAlterar();
   public String getNovaUrlEditoraAlterar();
   public void realizaAlteracao(ActionListener al);

   //***************************
   //* MÉTODOS JANELA PESQUISA *
   //***************************

   public void limpaTabelaInserir(); // LIMPA A JTABLE DA TELA INSERIR
   public void realizarPesquisa(ActionListener al); // BOTÃO DE PESQUISA
   public void informacoes(ActionListener al); // BOTÃO DE AJUDA
   public Boolean getOpcaoLivro(); // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX LIVRO
   public Boolean getOpcaoAutor(); // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX AUTOR
   public Boolean getOpcaoEditora(); // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX EDITORA
   public String getTexto(); // RETORNA O TEXTO DO CAMPO DE PESQUISA
   public void limpaTabelaPesquisa(); // LIMPA A JTABLE DA TELA DE PESQUISA
   public void atualizaTabelaAutor(int contador, Autores autor);
   public void atualizaTabelaLivro(int contador, Livros livro);
   public void atualizaTabelaEditora(int contador, Editoras editora);
   public void atualizaTabelaRelGeral(int contador, RelTudo valor);
   public void atualizaRelLivroAutor(int contador, RelLivrosAutores dados);
   public void atualizaRelLivroEditora(int contador, RelLivrosEditoras dados);
   public void mensagemAjudaPesquisa(); // MENSAGEM POP-UP DO BOTÃO AJUDA







}
