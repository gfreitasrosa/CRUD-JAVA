 package controller;

import model.dao.*;
import view.*;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Autores;
import entities.Editoras;
import entities.Livros;
import entities.RelLivrosAutores;
import entities.RelLivrosEditoras;
import entities.RelTudo;

import java.awt.event.ActionEvent;

public class Controller {
    ViewAbstrata view;
    Dao model;
    int contador;

    public Controller(Dao aModel, ViewConcreta aView){
        this.model = aModel;
        this.view = aView;
    }

    public void init(){
        // ABA PESQUISA

        this.view.realizarPesquisa(new AcaoPesquisa());
        this.view.informacoes(new AcaoInformacaoPesquisa());
  
        // ABA DELETAR
        
        this.view.deletar(new AcaoDeletar());
        this.view.habilitarTelasDeletar(new AcaoHabilitarTelaDeletar());
        this.view.ajudaDeletar(new AcaoInformacaoDeletar());

        // ABA INSERIR

        this.view.addAutorInserir(new AcaoAddAutor());
        this.view.attAutor(new AcaoAttAutorInserir());

        this.view.camposInsAutores(new AcaoHabilitarTelaInserir());
        this.view.camposInsEditoras(new AcaoHabilitarTelaInserir());
        this.view.camposInsLivros(new AcaoHabilitarTelaInserir());

        this.view.Inserir(new AcaoInsertAutores());
        this.view.Inserir(new AcaoInsertEditoras());
        this.view.Inserir(new AcaoinsertLivros());
        this.view.BtnAjudaInserir(new AcaoInformacaoInserir());

        // ABA ALTERAR

        this.view.pesquisaAutorAlterar(new AcaoPesquisaAlterar());
        this.view.pesquisarEditoraAlterar(new AcaoPesquisaAlterar());
        this.view.pesquisaLivrosAlterar(new AcaoPesquisaAlterar());

        this.view.camposAlterarAutor(new AcaoHabilitaTelaAlterar());
        this.view.camposAlterarEditoras(new AcaoHabilitaTelaAlterar());
        this.view.camposAlterarLivros(new AcaoHabilitaTelaAlterar());

        this.view.attAutorAlterar(new AcaoAttDadosAntigosAlterar());
        this.view.attLivroAlterar(new AcaoAttDadosAntigosAlterar());
        this.view.attEditoraAlterar(new AcaoAttDadosAntigosAlterar());

        this.view.realizaAlteracao(new AcaoAlterar());

        this.view.ajudaAlterar(new AcaoAjudaAlterar());
    }

    // *************
    // * PESQUISAR *
    // *************

    public class AcaoPesquisa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
          contador = 0;
          view.limpaTabelaPesquisa();

            // VERIFICA A ESCOLHA DO USUÁRIO NAS CHECKBOX
            if (view.getOpcaoAutor() && view.getOpcaoEditora() && view.getOpcaoLivro()){
                // VERIFICA O USUÁRIO ESCREVEU ALGO
                if (model.buscarTudo(view.getTexto()).isEmpty()){
                    // CASO SIM, EXECUTA O MÉTODO DE LISTAR TUDO
                    for (RelTudo relacao: model.listarTudo()){
                        contador ++;
                        view.atualizaTabelaRelGeral(contador, relacao);
                    }
                } else{
                    // CASO NÃO, EXECUTA O MÉTODO UTILIZANDO A CLAUSULA 'WHERE' NO BD
                    for (RelTudo valores: model.buscarTudo(view.getTexto())){
                        contador ++;
                        view.atualizaTabelaRelGeral(contador, valores);
                    }
                }
            } else if (view.getOpcaoAutor() && view.getOpcaoLivro()){
                if (model.buscarRelLivroAutor(view.getTexto()).isEmpty()){
                    for (RelLivrosAutores relacao: model.buscarRelLivroAutor(view.getTexto())){
                        contador ++;
                        view.atualizaRelLivroAutor(contador, relacao);
                    }
                } else{
                    for (RelLivrosAutores relacao: model.buscarRelLivroAutor(view.getTexto())){
                        contador ++;
                        view.atualizaRelLivroAutor(contador, relacao);
                    }
                }  
            } else if (view.getOpcaoEditora() && view.getOpcaoLivro()){
                if (model.buscarLivroSelecionado(view.getTexto()).isEmpty()){
                    for (RelLivrosEditoras relacao: model.buscarRelLivroEditora(view.getTexto())){
                        contador ++;
                        view.atualizaRelLivroEditora(contador, relacao);
                    }
                } else{
                    for (RelLivrosEditoras relacao: model.buscarRelLivroEditora(view.getTexto())){
                        contador ++;
                        view.atualizaRelLivroEditora(contador, relacao);
                    }
                }
            } else if (view.getOpcaoEditora() && view.getOpcaoAutor()){
                JOptionPane.showMessageDialog(null, "A relação de pesquisa Autores e Editoras não existe!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else if (view.getOpcaoAutor()){

                if (model.buscarAutorSelecionado(view.getTexto()).isEmpty()){
                    for (Autores autor: model.listarTodosAutores()){
                        contador ++;
                    view.atualizaTabelaAutor(contador, autor);
                    }
                } else{
                    for (Autores autor: model.buscarAutorSelecionado(view.getTexto())){
                        contador ++;
                        view.atualizaTabelaAutor(contador, autor);
                    }
                }  
            } else if (view.getOpcaoLivro()){
                if (model.buscarLivroSelecionado(view.getTexto()).isEmpty()){
                    for (Livros livro: model.listarTodosLivros()){
                        contador ++;
                        view.atualizaTabelaLivro(contador, livro);
                    }   
                } else{
                    for (Livros livro: model.buscarLivroSelecionado(view.getTexto())){
                        contador ++;
                        view.atualizaTabelaLivro(contador, livro);
                    }
                }
            } else if (view.getOpcaoEditora()){
                if (model.buscarEditoraSelecionada(view.getTexto()).isEmpty()){
                    for (Editoras editora: model.listarTodasEditoras()){
                        contador ++; 
                        view.atualizaTabelaEditora(contador, editora);
                    }
                } else{
                    for (Editoras editora: model.buscarEditoraSelecionada(view.getTexto())){
                        contador ++;
                        view.atualizaTabelaEditora(contador, editora);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escolha alguma opção para pesquisar", "Atenção", JOptionPane.WARNING_MESSAGE);
            }  
        }
    }

    public class AcaoInformacaoPesquisa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            // MÉTODO CHAMADO AO CLICAR NO BOTÃO AJUDA
            view.mensagemAjudaPesquisa();    
        }
    }

    // ***********
    // * DELETAR *
    // ***********
    
    public class AcaoDeletar implements ActionListener{
        String nomeAutor;
        String sobrenomeAutor;
        String isbn;
        String editora;

        @Override
        public void actionPerformed(ActionEvent ae){
            // Verifica se o autor escolheu a opção Autor na tela
            if(view.verificaEscolhaDeletarAutor()){
                nomeAutor = view.getTextoNomeAutor();
                sobrenomeAutor = view.getTextoSobrenomeAutor();

                // Validação para ver se todos os campo necessários estão preenchidos
                if (nomeAutor.equals("") && (sobrenomeAutor.equals(""))) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo Primeiro Nome e campo Sobrenome está vazio!");
                    return;
                } else if (nomeAutor.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo Primeiro Nome está vazio!");
                    return;
                } else if(sobrenomeAutor.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo Sobrenome está vazio!");
                    return;
                } else {
                    view.atualizarMensagemConclusao("");
                }
                model.apagarAutor(nomeAutor, sobrenomeAutor); // Chama a classe na model para excluir do BD
                
                // Verifica se o autor escolheu a opção Livro na tela
            } else if (view.verificaEscolhaDeletarLivro()) {        
                isbn = view.getTextoISBN();

                // Validação para ver se todos os campo necessários estão preenchidos
                if (isbn.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo ISBN está vazio!");
                    return;
                } else {
                    view.atualizarMensagemConclusao("");
                }
 
                model.apagarLivro(isbn);// Chama a classe na model para excluir do BD

                // Verifica se o autor escolheu a opção Editora na tela
            } else if (view.verificaEscolhaDeletarEditora()) {
                editora = view.getTextoEditora();

                // Validação para ver se todos os campo necessários estão preenchidos
                if (editora.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo Nome da Editora está vazio!");
                    return;
                } else {
                    view.atualizarMensagemConclusao("");
                }
                model.apagarEditora(editora); // Chama a classe na model para excluir do BD
            } else {
                JOptionPane.showMessageDialog(null, "Escolha uma opção e insira os valores para excluir", "Erro", JOptionPane.ERROR_MESSAGE);  
            }
        }
    }

    public class AcaoHabilitarTelaDeletar implements ActionListener{ // Classe que habilita a tela por opção escolhida
        @Override
        public void actionPerformed (ActionEvent ae) {
            view.desabilitarTelaDeletar(); // Deixa a tela desabilitada

            // Chama da view e habilita opção na tela confor escolhido pelo usuário
            if (view.verificaEscolhaDeletarAutor()) {
                view.habilitarAutorDeletar();
            } else if (view.verificaEscolhaDeletarLivro()) {
                view.habilitarLivrosDeletar();
            } else if (view.verificaEscolhaDeletarEditora()) {
                view.habilitarEditorasDeletar();
            }
        }
    }

    public class AcaoInformacaoDeletar implements ActionListener { // Classe que chama mensagem do botão ajuda
        @Override
        public void actionPerformed(ActionEvent ae){
            view.mensagemAjudaDeletar();
        }
    }

    // ***********
    // * INSERIR *
    // ***********

    public class AcaoAddAutor implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            contador = 0;

            view.limpaTabelaInserir();

            if (view.getOpcaoAutorAbaInserir()){
                 

            } else if (view.getOpcaoEditoraAbaInserir()) {


            } else if (view.getOpcaoLivroAbarInserir()){
                
                for (Autores autor: model.listarTodosAutores()){
                    contador ++;
                    view.atualizaAutoresAbaInserir(contador, autor);
                }
                
                view.popUpAutorAbaInserir();

            } else{
                System.out.println("Deu merda");
            }       
        }
    }

    public class AcaoAttAutorInserir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            view.attTextoAutorInserir(view.pesquisaInserir());
        }
    }

    public class AcaoInsertAutores implements ActionListener{
        String nomeAutor;
        String sobreNomeAutor;

        @Override
        public void actionPerformed(ActionEvent al){
            if(view.verificaEscolhaInserirAutor()){
                nomeAutor = view.getNome();
                sobreNomeAutor = view.getSobrenome();

                if (nomeAutor.equals("")){
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta o Nome do Autor ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (sobreNomeAutor.equals("")) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta Sobrenome do Autor", "Erro", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    model.InsertAutores(nomeAutor, sobreNomeAutor);
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public class AcaoInsertEditoras implements ActionListener {
        String nomeEditora;
        String Url;

        @Override
        public void actionPerformed(ActionEvent al) {
            if (view.verificaEscolhaInserirEditora()) {
                nomeEditora = view.getNomeEditora();
                Url = view.getUrl();

                if (nomeEditora.equals("") && Url.equals("")) {
                    JOptionPane.showMessageDialog(null, "Campos em branco. ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (nomeEditora.equals("")){
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta nome da editora ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (Url.equals("")) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta a URL ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    model.InsertEditoras(nomeEditora, Url);
                }
            }
        }
    }

    public class AcaoinsertLivros implements ActionListener{
        String titulo;
        String nomeEditora;
        Float preco;
        String isbn;

        @Override
        public void actionPerformed(ActionEvent ae){
            String[] listaAutoresEscolhidos;
            String[] listaLinhas;

            if(view.verificaEscolhaInserirLivro()){
                titulo = view.getInserirTitulo();
                nomeEditora = view.getInserirEditoras();
                preco = Float.parseFloat(view.getInserirPreco());
                isbn = view.getISBN();
                listaAutoresEscolhidos = view.getAutoresSelecionados().split(" / ");

                if (titulo.equals("") && nomeEditora.equals("") && preco == 0.0 && isbn.equals("")){
                    JOptionPane.showMessageDialog(null, "Campos em branco ", "Erro", JOptionPane.INFORMATION_MESSAGE);
                } else if(titulo.equals("")) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta Titulo do livro ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                }else if (nomeEditora.equals("")){
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta nome da editora ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (preco == 0.0 || Float.isNaN(preco)) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta o preço ou preço inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (isbn.equals("")) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta a ISBN ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (listaAutoresEscolhidos.length < 1) {
                    model.InsertLivros(titulo, isbn, preco, nomeEditora, null, null);

                } else {
                    for (String valor : listaAutoresEscolhidos) {
                        listaLinhas = valor.split(" ");
                        if (listaLinhas.length > 3){
                            model.InsertLivros(titulo, isbn, preco, nomeEditora, listaLinhas[1], listaLinhas[2] + " " + listaLinhas[3]);
                        } else {
                            model.InsertLivros(titulo, isbn, preco, nomeEditora, listaLinhas[1], listaLinhas[2]);
                        }
                        
                        listaLinhas = null;
                    }
                }
            }
        }
    }

    public class AcaoHabilitarTelaInserir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            view.desabilitarTela();

            if (view.verificaEscolhaInserirAutor()){
                view.limpaAutoresInserir();
                view.habilitarAutor();

            } else if (view.verificaEscolhaInserirEditora()){
                view.limpaAutoresInserir();
                view.habilitaEditoras();

            } else if (view.verificaEscolhaInserirLivro()){
                view.habilitaLivros();
            }
        }
    }

    public class AcaoInformacaoInserir implements ActionListener{ // mensagem de ajuda para o usuário.

        @Override
        public void actionPerformed(ActionEvent ae){
            view.mensagemAjudaInserir();

        }
    }
    
    // ***********
    // * ALTERAR *
    // ***********

    public class AcaoAjudaAlterar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            // MÉTODO CHAMADO AO CLICAR NO BOTÃO AJUDA
            view.mensagemAjudaAlterar();;    
        }
    }

    public class AcaoPesquisaAlterar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            contador = 0;

            view.limpaTabelaAlterar();

            if (view.getLivrosAbaAlterar()){
                for (Livros livros:model.listarTodosLivros()){
                    contador ++;
                    view.atualizaLivrosAbaAlterar(contador, livros);
       
                }
                view.popUpLivrosAbaAlterar();

            } else if (view.getAutorAbaAlterar()) {
                for (Autores autor:model.listarTodosAutores()){
                    contador ++;
                    view.atualizaAutoresAbaAlterar(contador, autor);
                    
                }
                view.popUpAutorAbaAlterar();

            } else if (view.getEditorasAbaAlterar()) {
                for (Editoras editora:model.listarTodasEditoras()){
                    contador ++;
                    view.atualizaEditorasAbaAlterar(contador, editora);
                    
                }
                view.popUpEditorasAbaAlterar();

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum botão escolhido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class AcaoHabilitaTelaAlterar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            view.desabilitaTelaAlterar();
            
            if (view.getAutorAbaAlterar()){
                view.habilitaAutorTelaAlterar();

            } else if (view.getLivrosAbaAlterar()){
                view.habilitaLivroTelaAlterar();

            } else if (view.getEditorasAbaAlterar()){
                view.habilitaEditoriaTelaAlterar();
            }
        }
    }

    public class AcaoAttDadosAntigosAlterar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            if (view.getAutorAbaAlterar()){
                view.attTextoAutorAlterar(view.pesquisaAutorAlterar());

            } else if (view.getLivrosAbaAlterar()){
                view.attTextoLivroAlterar(view.pesquisaLivroAlterar());

            } else if (view.getEditorasAbaAlterar()){
                view.attTextoEditoraAlterar(view.pesquisaEditoraAlterar());

            }
        }
    }

    public class AcaoAlterar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            if (view.getAutorAbaAlterar()){
                if (!verificaCamposAutor()){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos referentes ao autor", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                model.atualizarAutor(view.getNovoNomeAutorAlterar(),
                view.getNovoSobrenomeAutorAlterar(),
                view.getAntigoNomeAutorAlterar(),
                view.getAntigoSobrenomeAutorAlterar());

            }else if (view.getLivrosAbaAlterar()){
                if (!verificaCamposLivro()){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos referentes ao livro", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                model.atualizarLivro(view.getNovoTituloLivroAlterar(),
                Float.parseFloat(view.getNovoPrecoLivroAlterar()),
                view.getAntigoTituloLivroAlterar(),
                Float.parseFloat(view.getAntigoPrecoLivroAlterar()));
                
            } else if (view.getEditorasAbaAlterar()){
                if (!verificaCamposEditora()){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos referentes a editora", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                model.atualizarEditora(view.getNovoNomeEditoraAlterar(),
                view.getNovaUrlEditoraAlterar(),
                view.getAntigoNomeEditoraAlterar(),
                view.getAntigaUrlAlterar()
                );
            }  
        }

        public boolean verificaCamposAutor(){
            if (view.getAntigoNomeAutorAlterar().equals("")      ||  
                view.getAntigoSobrenomeAutorAlterar().equals("") ||
                view.getNovoNomeAutorAlterar().equals("")        ||
                view.getNovoSobrenomeAutorAlterar().equals(""))
                {
                return false;
            } else {
                return true;
            }
        }

        public boolean verificaCamposLivro(){
            if (
                view.getAntigoTituloLivroAlterar().equals("")    ||
                view.getAntigoPrecoLivroAlterar().equals("")     ||
                view.getNovoTituloLivroAlterar().equals("")      ||
                view.getNovoPrecoLivroAlterar().equals("")
                ){
                return false;
            } else {
                return true;
            }
        }

        public boolean verificaCamposEditora(){
            if (
                view.getAntigoNomeEditoraAlterar().equals("")    ||
                view.getAntigaUrlAlterar().equals("")            ||
                view.getNovoNomeEditoraAlterar().equals("")      ||
                view.getNovaUrlEditoraAlterar().equals("")){
                return false;
            } else {
                return true;
            }
        }
    }
}
