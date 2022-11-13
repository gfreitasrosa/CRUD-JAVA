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
        this.view.informacoes(new AcaoInformacao());
        // this.view.realizaAtt(new AcaoAtualizar());
        this.view.addAutor(new AcaoAddAutor());
        this.view.attAutor(new AcaoAttAutor());

        this.view.camposInsAutores(new AcaoInvalidaCamposInserir());
        this.view.camposInsEditoras(new AcaoInvalidaCamposInserir());
        this.view.camposInsLivros(new AcaoInvalidaCamposInserir());

        this.view.deletar(new AcaoDeletar());

        this.view.pesquisaAutorAlterar(new AcaoPesquisaAlterar());
        this.view.pesquisaEditoraAlterar(new AcaoPesquisaAlterar());
        this.view.pesquisaLivrosAlterar(new AcaoPesquisaAlterar());

        this.view.camposAlterarAutor(new AcaoInvalidaCamposAlterar());
        this.view.camposAlterarEditoras(new AcaoInvalidaCamposAlterar());
        this.view.camposAlterarLivros(new AcaoInvalidaCamposAlterar());
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

    public class AcaoInformacao implements ActionListener{

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

    public class AcaoInvalidaCamposInserir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            
            if (view.verificaEscolhaInserirAutor()){
                


            } else if (view.verificaEscolhaInserirEditora()){

            } else if (view.verificaEscolhaInserirLivro()){

                view.desabilitaLivrosEditoras();
            }

        }
    }


    public class AcaoDeletar implements ActionListener{

        String nomeAutor;

        String SobrenomeAutor;

        @Override
        public void actionPerformed(ActionEvent ae){


            if(view.verificaEscolhaDeletarAutor()){

                nomeAutor = view.getTextoNomeAutor();
                SobrenomeAutor = view.getTextoSobrenomeAutor();

                model.apagarAutor(nomeAutor, SobrenomeAutor);




            }
        }
    }

    public class AcaoPesquisaAutor implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent ae){

        }


    }

    public class AcaoPesquisaAlterar implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent ae){

            contador = 0;

            view.desabilitaTelaAlterar();

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

    public class AcaoInvalidaCamposAlterar implements ActionListener{

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
}


