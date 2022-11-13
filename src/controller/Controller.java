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

import java.awt.event.ActionEvent;
import java.util.Arrays;

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
        this.view.informacoes(new AcaoInformacao());
        // this.view.realizaAtt(new AcaoAtualizar());
        this.view.addAutor(new AcaoAddAutor());
        this.view.attAutor(new AcaoAttAutor());
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
                           // view.atualizaTabelaEditora(contador, relacao);
                            //  CRIAR O MÉTODO PARA ATUALIZAR A VIEW

                        }
                    } else{
                        for (Autores autor: model.buscarAutorSelecionado(view.getTexto())){
                            contador ++;
                            view.atualizaTabelaAutor(contador, autor);


                        }
                    }
                }
            
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

    public class AcaoInformacao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            view.mensagemAjudaPesquisa();    
            System.out.println(view.pesquisa()); 
            
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
                    view.atualizaAutores(contador, autor);
                }
                
                view.popUp();

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

    public class AcaoInsertAutores implements ActionListener{
        String nomeAutor;
        String sobreNomeAutor;

        @Override
        public void actionPerformed(ActionEvent al){


            if(view.verificaEscolhaInserirAutor()){
                nomeAutor = view.getNome();
                sobreNomeAutor = view.getSobrenome();

                model.InsertAutores(nomeAutor, sobreNomeAutor);
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

                model.InsertEditoras(nomeEditora, Url);
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
                preco = Float.valueOf(view.getInserirPreco());
                isbn = view.getISBN();
                listaAutoresEscolhidos = view.getAutoresSelecionados().split(" / ");

                for(String valor: listaAutoresEscolhidos){
                    listaLinhas = valor.split(" ");

                    model.InsertLivros(titulo, isbn, preco, nomeEditora, listaLinhas[1], listaLinhas[2]);
                    listaLinhas = null;


                }

            }
        }
    }


}



