 package controller;

import model.dao.*;
import model.entidades.Autores;
import model.entidades.Livros;
import model.entidades.RelLivrosAutores;
import model.entidades.RelLivrosEditoras;
import model.entidades.Editoras;
import model.entidades.RelTudo;
import view.*;

import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class Controller {

    ViewConcreta view;
    Dao model;
    int contador;


    public Controller(Dao aModel, ViewConcreta aView){
        this.model = aModel;
        this.view = aView;

    }

    public void init(){

        this.view.realizarPesquisa(new AcaoPesquisa());
        this.view.informacoes(new AcaoInformacaoPesquisa());
        // this.view.realizaAtt(new AcaoAtualizar());
        this.view.addAutor(new AcaoAddAutor());
        this.view.attAutor(new AcaoAttAutor());

        this.view.deletar(new AcaoDeletar());
        this.view.habilitarTelasDeletar(new HabilitarTelaDeletar());
        this.view.ajudaDeletar(new AcaoInformacaoDeletar());

        this.view.camposInsAutores(new AcaoInvalidaCamposInserir());
        this.view.camposInsEditoras(new AcaoInvalidaCamposInserir());
        this.view.camposInsLivros(new AcaoInvalidaCamposInserir());
        this.view.Inserir(new AcaoInsertAutores());
        this.view.Inserir(new AcaoInsertEditoras());
        this.view.Inserir(new AcaoinsertLivros());

    }

    // CLASSES RELACIONADAS A ABA PESQUISA

    public class AcaoPesquisa implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
          view.setOpcao();

          contador = 0;
          view.limpaTabelaPesquisa();

            if (view.getOpcaoAutor() && view.getOpcaoEditora() && view.getOpcaoLivro()){

                if(view.getTexto() != ""){
                    if (model.buscarTudo(view.getTexto()).isEmpty()){
                        for (RelTudo relacao: model.listarTudo()){
                            contador ++;
                            view.atualizaTabelaRelGeral(contador, relacao);

                        }
                    } else{
                        for (RelTudo valores: model.buscarTudo(view.getTexto())){
                            contador ++;
                            view.atualizaTabelaRelGeral(contador, valores);
                        }
                    }
                }

                return;

            } else if (view.getOpcaoAutor() && view.getOpcaoLivro()){

                if(view.getTexto() != ""){
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
                }
                
            } else if (view.getOpcaoEditora() && view.getOpcaoLivro()){

                if(view.getTexto() != ""){
                    if (model.buscarLivroSelecionado(view.getTexto()).isEmpty()){
                        for (RelLivrosEditoras relacao: model.buscarRelLivroEditora(view.getTexto())){
                            contador ++;
                            view.atualizaRelLivroEditora(contador, relacao);
                           // view.atualizaTabelaEditora(contador, relacao);
                            //  CRIAR O MÉTODO PARA ATUALIZAR A VIEW

                        }
                    } else{
                        for (RelLivrosEditoras relacao: model.buscarRelLivroEditora(view.getTexto())){
                            contador ++;
                            view.atualizaRelLivroEditora(contador, relacao);


                        }
                    }
                }
            
            } else if (view.getOpcaoEditora() && view.getOpcaoAutor()){

                JOptionPane.showMessageDialog(null, "A relação de pesquisa Autores e Editoras não existe!", "Erro ao pesquisar", JOptionPane.ERROR_MESSAGE);

            } else if (view.getOpcaoAutor()){

                if(view.getTexto() != ""){
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
            }
        }
    }

    public class AcaoInformacaoPesquisa implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            view.mensagemAjudaPesquisa();    
            
        }
    }

    // CLASSES RELACIONADAS A ABA ATUALZIAR

    public class AcaoAtualizar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            
        }
    }

    // CLASSES RELACIONADAS A ABA INSERIR
    
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

    public class AcaoAttAutor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            
            view.attTextoAutor(view.pesquisa());

        }
    }

    public class AcaoDeletar implements ActionListener{
        String nomeAutor;
        String sobrenomeAutor;
        String isbn;
        String editora;

        @Override
        public void actionPerformed(ActionEvent ae){
            if(view.verificaEscolhaDeletarAutor()){

                nomeAutor = view.getTextoNomeAutor();
                sobrenomeAutor = view.getTextoSobrenomeAutor();
                

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

                model.apagarAutor(nomeAutor, sobrenomeAutor);

            } else if (view.verificaEscolhaDeletarLivro()) {
                isbn = view.getTextoISBN();
                model.apagarLivro(isbn);

                if (isbn.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo ISBN está vazio!");
                    return;
                } else {
                    view.atualizarMensagemConclusao("");
                }

            } else if (view.verificaEscolhaDeletarEditora()) {
                editora = view.getTextoEditora();
                model.apagarEditora(editora);

                if (editora.equals("")) {
                    view.atualizarMensagemConclusao("Erro ao deletar: Campo Nome da Editora está vazio!");
                    return;
                } else {
                    view.atualizarMensagemConclusao("");
                }
            }
        }
    }

    public class HabilitarTelaDeletar implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent ae) {
            view.desabilitarTelaDeletar();

            if (view.verificaEscolhaDeletarAutor()) {
                view.habilitarAutorDeletar();
            } else if (view.verificaEscolhaDeletarLivro()) {
                view.habilitarLivrosDeletar();
            } else if (view.verificaEscolhaDeletarEditora()) {
                view.habilitarEditorasDeletar();
            }
        }
    }

    public class AcaoInformacaoDeletar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            view.mensagemAjudaDeletar();
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
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso", "Erro", JOptionPane.INFORMATION_MESSAGE);

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
                    JOptionPane.showMessageDialog(null, "Adicionado com sucesso ", "Erro", JOptionPane.INFORMATION_MESSAGE);

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
            String nome;
            String sobrenome;
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

                } else if (preco == 0.0) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta o preco ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (isbn.equals("")) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar, falta a ISBN ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                } else if (listaAutoresEscolhidos.length == 1) {
                    model.InsertLivros(titulo, isbn, preco, nomeEditora, null, null);


                } else {
                    for (String valor : listaAutoresEscolhidos) {
                        listaLinhas = valor.split(" ");

                        model.InsertLivros(titulo, isbn, preco, nomeEditora, listaLinhas[1], listaLinhas[2]);
                        listaLinhas = null;
                        JOptionPane.showMessageDialog(null, "Livro adicionado com Sucesso. ", "Erro", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        }
    }

    public class AcaoInvalidaCamposInserir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            view.desabilitarTela();

            if (view.verificaEscolhaInserirAutor()){
                view.habilitarAutor();

            } else if (view.verificaEscolhaInserirEditora()){
                view.habilitaEditoras();

            } else if (view.verificaEscolhaInserirLivro()){

                view.habilitaLivros();
            }
        }

    }


}

