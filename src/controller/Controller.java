package controller;

import model.dao.*;
import model.entidades.Autores;
import model.entidades.Livros;
import model.entidades.Editoras;
import model.entidades.RelTudo;
import view.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller {

    janelacomabasaps view;
    Dao model;
    int contador;


    public Controller(Dao aModel, janelacomabasaps aView){
        this.model = aModel;
        this.view = aView;

    }

    public void init(){

        this.view.realizarPesquisa(new AcaoPesquisa());
        
    }

    public class AcaoPesquisa implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
          view.setOpcao();
        
          contador = 0;
          view.limpaTabela();


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
}

