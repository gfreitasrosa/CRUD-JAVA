package model.dao;

import model.entidades.Livros;

public class TesteConexao {
    public static void main(String[] args) {
        ConexaoBD.testaConexao();

        Dao db = new ConexaoBD();

        /*
        for (Editoras editoras: db.listarTodasEditoras()){
            System.out.println(editoras.getName());
        }

        System.out.println("  ");

        for (Livros livros: db.listarTodosLivros()){
            System.out.println(livros.getTitle());
        }

        System.out.println("  ");

        for (Autores autores: db.listarTodosAutores()){
            System.out.println(autores.getName() + " " + autores.getFname());
        }


        for (Autores autores: db.buscarAutorSelecionado("Stein")){
            System.out.println(autores.getName() + " " + autores.getFname());
        }
        */

        /*
        for(Editoras editoras: db.buscarEditoraSelecionada("Pren ")){
            System.out.println(editoras.getName());
        }

         */


        for(Livros livro: db.buscarLivroSelecionado("com")){
            System.out.println(livro.getTitle() + " " + livro.getPrice());
        }



    }
}
