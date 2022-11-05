package model.dao;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Autores;
import model.entidades.Editoras;
import model.entidades.Livros;

public class ConexaoBD implements Dao{

    static private final String USER = "root";
    static private final String PASS = "";
    static private final String DATABASE = "livraria";
    static private final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

    static void testaConexao() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.println("Conexão bem-sucedida!");

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // MÉTODOS RESPONSÁVEIS POR LISTAR AS ENTIDADES DO BD

    @Override
    public List<Livros> listarTodosLivros(){

       List<Livros> livros = new ArrayList<>();

       final String query = "SELECT * FROM Books;";

       try (Connection con = DriverManager.getConnection(URL, USER, PASS)){

           Statement stm = con.createStatement();
           ResultSet rs = stm.executeQuery(query);

           while(rs.next()) {
               String titulo = rs.getString("title");
               String isbn = rs.getString("isbn");
               float price = rs.getFloat("price");
               Livros livro = new Livros(titulo, isbn, price);
               livros.add(livro);
           }

       } catch(Exception e){
               e.printStackTrace();
       }

        return livros;
    }

    @Override
    public List<Editoras> listarTodasEditoras(){
        List<Editoras> editoras = new ArrayList<>();

        final String query = "SELECT * FROM Publishers;";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)){

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()) {
                String name = rs.getString("name");
                String url = rs.getString("url");
                Editoras editora = new Editoras(name, url);
                editoras.add(editora);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return editoras;
    }

    @Override
    public List<Autores> listarTodosAutores(){
        List<Autores> autores = new ArrayList<>();

        final String query = "SELECT * FROM Authors;";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)){

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()) {
                String name = rs.getString("name");
                String fname = rs.getString("fname");
                Autores autor = new Autores(name, fname);
                autores.add(autor);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return autores;
    }

    @Override
    public List<Autores> buscarAutorSelecionado(String nome){

        List<Autores> autores_sel = new ArrayList<>();

        final String query = "SELECT * FROM Authors WHERE Authors.name = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                String fname = rs.getString("fname");
                Autores autor = new Autores(name, fname);
                autores_sel.add(autor);
            }

        } catch(Exception e){
            e.printStackTrace();

        }

        return autores_sel;


    }

    @Override
    public List<Editoras> buscarEditoraSelecionada(String nome){

        List<Editoras> editoras_sel = new ArrayList<>();

            final String query = "SELECT * FROM Publishers WHERE Publishers.name = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                String url = rs.getString("url");
                Editoras editora = new Editoras(name, url);
                editoras_sel.add(editora);
            }

        } catch(Exception e){
            e.printStackTrace();

        }

        return editoras_sel;


    }

    @Override
    public List<Livros> buscarLivroSelecionado(String nome){

        List<Livros> livros_rel= new ArrayList<>();

        final String query = "SELECT * FROM Books WHERE Books.title LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                float price = rs.getFloat("price");
                Livros livro = new Livros(title, isbn, price);
                livros_rel.add(livro);
            }

        } catch(Exception e){
            e.printStackTrace();

        }

        return livros_rel;


    }
    

    // MÉTODOS RESPONSÁVEIS POR ADICIONAR AS ENTIDADES DO BD

    @Override
    public void InsertLivros(Livros livros){

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String SqlInsertLivros = "insert into Books (title, isbn, price) values (?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertLivros);

            pstm.setString(1, livros.getTitle());
            pstm.setString(2, livros.getIsbn());
            pstm.setFloat(3, livros.getPrice());
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void InsertAutores(Autores autores){

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            String SqlInsertAutores = "insert into Authors (name, fname) value (?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertAutores);

            pstm.setString(1, autores.getName());
            pstm.setString(2, autores.getFname());
            pstm.execute();

        }catch (SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void InsertEditoras(Editoras editoras){
        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String SqlInsertEditoras = "insert into Publishers (name, url) value (?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertEditoras);

            pstm.setString(1, editoras.getName());
            pstm.setString(2, editoras.getUrl());
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);


        }catch (SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // MÉTODOS RESPONSÁVEIS POR EXCLUIR AS ENTIDADES DO BD

    @Override
    public void apagarLivro(String isbn){
        String queryDelBook = "DELETE FROM Books WHERE isbn = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDelBook);
            pstm.setString(1, isbn);
            pstm.execute();
        } catch(Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void apagarAutor(Integer ID){
        String queryDelAuthor = "DELETE FROM Authors WHERE author_id = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDelAuthor);
            pstm.setInt(1, ID);
            pstm.execute();
        } catch(Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void apagarEditora(Integer ID){
        String queryDelPubli = "DELETE FROM Publishers WHERE publisher_id = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDelPubli);
            pstm.setInt(1, ID);
            pstm.execute();
        } catch(Exception e){
            e.printStackTrace();

        }

    }
}





