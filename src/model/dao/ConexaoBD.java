package model.dao;

import javax.swing.*;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entidades.*;

public class ConexaoBD implements Dao{

    private int idPublisher;
    private int autorId;

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
    public List<RelTudo>listarTudo(){

        List<RelTudo> lista_rel= new ArrayList<>();

        final String query = "SELECT a.fname, a.name, b.title, b.isbn, b.price, p.name as editora , p.url " 
        + " FROM authors as a " 
        + " LEFT JOIN booksauthors ba " 
        + " on ba.author_id = a.author_id "
        + " LEFT join books b "
        + " on b.isbn = ba.isbn "
        + " LEFT join publishers p "
        + " on p.publisher_id = b.publisher_id";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);


            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String fName = rs.getString("fname");
                String name = rs.getString("name");
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                Float price = rs.getFloat("price");
                String pName = rs.getString("editora");
                String url = rs.getString("url");

                Autores auxAutores = new Autores(name, fName);
                Livros auxLivros = new Livros(title, isbn, price);
                Editoras auxEditoras = new Editoras(pName, url);

                RelTudo relacao = new RelTudo(auxAutores, auxAutores, auxLivros, auxLivros, auxLivros, auxEditoras, auxEditoras);
                lista_rel.add(relacao);
            }

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Acoteceu algum erro na busca, contante o suporte!", "Erro", JOptionPane.ERROR_MESSAGE);
            lista_rel.clear();
            return lista_rel;

        }

        return lista_rel;

    }

    @Override
    public List<Autores> buscarAutorSelecionado(String nome){

        List<Autores> autores_sel = new ArrayList<>();

        final String query = "SELECT * FROM Authors WHERE Authors.name  LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1,"%" + nome + "%");
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

            final String query = "SELECT * FROM Publishers WHERE Publishers.name LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
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

        final String query = "SELECT * FROM Books WHERE Books.title LIKE ? OR Books.isbn LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
            pstm.setString(2, "%" + nome + "%");
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

    @Override
    public List<RelLivrosAutores> buscarRelLivroAutor(String nome){

        List<RelLivrosAutores> lista_rel= new ArrayList<>();

        final String query = "SELECT * FROM authors as A INNER JOIN booksauthors as BA on A.author_id = BA.author_id INNER JOIN books AS B on B.isbn = BA.isbn WHERE B.title LIKE ? OR B.isbn LIKE ? OR A.name LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
            pstm.setString(2, "%" + nome + "%");
            pstm.setString(3, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                String fName = rs.getString("fname");
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                Float price = rs.getFloat("price");

                Autores auxAutores = new Autores(name, fName);
                Livros auxLivros = new Livros(title, isbn, price);

                RelLivrosAutores relLivrosAutores = new RelLivrosAutores(auxAutores, auxAutores, auxLivros, auxLivros, auxLivros);
                
                lista_rel.add(relLivrosAutores);
            }

        } catch(Exception e){
            e.printStackTrace();

        }

        return lista_rel;

    }

    @Override
    public List<RelLivrosEditoras> buscarRelLivroEditora(String nome){

        List<RelLivrosEditoras> lista_relLivrosEditoras= new ArrayList<>();

        final String query = "SELECT * FROM books as b INNER JOIN publishers as p ON b.publisher_id =  p.publisher_id WHERE b.isbn LIKE ? or b.title LIKE ? or p.name LIKE ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
            pstm.setString(2, "%" + nome + "%");
            pstm.setString(3, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                Float price = rs.getFloat("price");
                String name = rs.getString("name");
                String url = rs.getString("url");

                Livros auxLivros = new Livros(title, isbn, price);
                Editoras auxEditoras = new Editoras(name, url);

                RelLivrosEditoras relLivrosEditoras = new RelLivrosEditoras(auxLivros, auxLivros, auxLivros, auxEditoras, auxEditoras);
                
                lista_relLivrosEditoras.add(relLivrosEditoras);
            }

        } catch(Exception e){
            e.printStackTrace();

        }

        return lista_relLivrosEditoras;

    }


    @Override
    public List<RelTudo> buscarTudo(String nome){

        List<RelTudo> lista_rel= new ArrayList<>();

        final String query = "SELECT a.fname, a.name, b.title, b.isbn, b.price, p.name as editora , p.url " 
        + " FROM authors as a " 
        + " INNER JOIN booksauthors ba " 
        + " on ba.author_id = a.author_id "
        + " inner join books b "
        + " on b.isbn = ba.isbn "
        + " inner join publishers p "
        + " on p.publisher_id = b.publisher_id "
        + " WHERE a.fname LIKE ? OR a.name LIKE ? OR b.title LIKE ? OR b.isbn LIKE ?; ";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, "%" + nome + "%");
            pstm.setString(2, "%" + nome + "%");
            pstm.setString(3, "%" + nome + "%");
            pstm.setString(4, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                String fName = rs.getString("fname");
                String name = rs.getString("name");
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                Float price = rs.getFloat("price");
                String pName = rs.getString("editora");
                String url = rs.getString("url");

                Autores auxAutores = new Autores(name, fName);
                Livros auxLivros = new Livros(title, isbn, price);
                Editoras auxEditoras = new Editoras(pName, url);

                RelTudo relacao = new RelTudo(auxAutores, auxAutores, auxLivros, auxLivros, auxLivros, auxEditoras, auxEditoras);
                lista_rel.add(relacao);
            }

        } catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Acoteceu algum erro na busca, contante o suporte!", "Erro", JOptionPane.ERROR_MESSAGE);

        }

        return lista_rel;

    }
    

    // MÉTODOS RESPONSÁVEIS POR ADICIONAR AS ENTIDADES DO BD

    @Override
    public void InsertLivros(String titulo, String isbn, float preco, String nomeEditora, String name, String fname){

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sqlRelacao = "select * from authors where name = ? and fname = ? ";
            PreparedStatement pstm = con.prepareStatement(sqlRelacao);

            pstm.setString(1, name);
            pstm.setString(2, fname);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
               autorId = rs.getInt("author_id");


            }else {
                System.out.println("Autor não cadastrada! ");
            }



        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sqlPesquisaEditora = "select * from publishers where name = ?";
            PreparedStatement pstm = con.prepareStatement(sqlPesquisaEditora);

            pstm.setString(1, nomeEditora);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                idPublisher = rs.getInt("publisher_id");


            }else {
                System.out.println("Editora não cadastrada! ");
            }

        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String SqlInsertLivros = "insert into Books (title, isbn, publisher_id, price) values (?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertLivros);

            pstm.setString(1, titulo);
            pstm.setString(2, isbn);
            pstm.setInt(3, idPublisher);
            pstm.setFloat(4, preco);
            pstm.execute();



        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASS)) {
            String sqlInsert = "insert into booksauthors (author_id, isbn) value (?,?);";
            PreparedStatement pstm2 = con2.prepareStatement(sqlInsert);

            pstm2.setInt(1, autorId);
            pstm2.setString(2, isbn);
            pstm2.execute();



        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Livro adicionado sem autor.", "Observação ", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    @Override
    public void InsertAutores(String Nome, String Sobrenome){

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            String SqlInsertAutores = "insert into Authors (name, fname) value (?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertAutores);

            pstm.setString(1, Sobrenome);
            pstm.setString(2, Nome);
            pstm.execute();

        }catch (SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void InsertEditoras(String nomeEditora, String Url){
        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String SqlInsertEditoras = "insert into Publishers (name, url) value (?, ?)";
            PreparedStatement pstm = con.prepareStatement(SqlInsertEditoras);

            pstm.setString(1, nomeEditora);
            pstm.setString(2, Url);
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);


        }catch (SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // MÉTODOS RESPONSÁVEIS POR EXCLUIR AS ENTIDADES DO BD

    @Override
    public void apagarLivro(String isbn){
        String queryDeleteBook = "DELETE FROM booksauthors WHERE isbn = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDeleteBook);
            pstm.setString(1, isbn);
            pstm.execute();
        } catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }


        String queryDelBook = "DELETE FROM Books WHERE isbn = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDelBook);
            pstm.setString(1, isbn);
            pstm.execute();
        } catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void apagarAutor(String nome, String sobrenome){

        String queryDeleteBook = "DELETE FROM booksauthors WHERE author_id IN (SELECT author_id FROM authors WHERE name = ? and fname = ?)";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDeleteBook);
            pstm.setString(1, sobrenome);
            pstm.setString(2, nome);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Valor apagado da tabela booksauthor", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        String queryDelAuthor = "DELETE FROM authors WHERE fname = ? AND name = ?;";

        try(Connection con1 = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm1 = con1.prepareStatement(queryDelAuthor);
            pstm1.setString(1, nome);
            pstm1.setString(2, sobrenome);
            pstm1.execute();
            JOptionPane.showMessageDialog(null, "Valor apagado da tabela authors", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException ErroSql){
          JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void apagarEditora(String editora){
        String queryVerificaEditora = "SELECT * FROM books WHERE publisher_id IN (SELECT publisher_id FROM publishers WHERE name = ?);";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaEditora);
            pstm.setString(1, editora);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String queryUpdEditoraToNull = "UPDATE books SET publisher_id = null WHERE publisher_id IN (SELECT publisher_id FROM publishers WHERE name = ?);";

                try(Connection con1 = DriverManager.getConnection(URL, USER, PASS)){
                    PreparedStatement pstm1 = con1.prepareStatement(queryUpdEditoraToNull);
                    pstm1.setString(1, editora);
                    pstm1.executeUpdate();

                } catch(SQLException ErroSql){
                    JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            String queryDelPubli = "DELETE FROM publishers WHERE name = ?";

            try(Connection con2 = DriverManager.getConnection(URL, USER, PASS)){
                PreparedStatement pstm2 = con2.prepareStatement(queryDelPubli);
                pstm2.setString(1, editora);
                pstm2.execute();
                JOptionPane.showMessageDialog(null, "Valor apagado da tabela publishers", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ErroSql){
                JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void atualizarAutor(String novoNome, String novoSobrenome, String antigoNome, String antigoSobrenome ) {

        String queryUpdAutor = "UPDATE authors set fname = ? and name = ? WHERE fname = ? and name = ?;";


        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement pstm = con.prepareStatement(queryUpdAutor);
            pstm.setString(1, novoNome);
            pstm.setString(2, novoSobrenome);
            pstm.setString(3, antigoNome);
            pstm.setString(4, antigoSobrenome);
            pstm.executeUpdate();


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar", "Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }


   public void atualizarLivro(String novoTitulo, float novoPreco, String antigoTitulo, float antigoPreco){

        String queryUpdLivro = "UPDATE books set title = ? and price = ? WHERE title = ? and price = ?;";

       try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
           PreparedStatement pstm = con.prepareStatement(queryUpdLivro);
           pstm.setString( 1, novoTitulo);
           pstm.setFloat( 2, novoPreco);
           pstm.setString( 3, antigoTitulo);
           pstm.setFloat( 4, antigoPreco);
           pstm.executeUpdate();


       } catch(Exception e){

           JOptionPane.showMessageDialog( null,  "Erro ao atualizar",  "Erro", JOptionPane.ERROR_MESSAGE);

       }
   }

   public void atualizarEditora(String novoNome, String novaURL, String antigoNome, String antigaURL){

       String queryUpdEditora = "UPDATE publishers set name = ? and url = ? WHERE name = ? and url = ?;";

       try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
           PreparedStatement pstm = con.prepareStatement(queryUpdEditora);
           pstm.setString( 1, novoNome);
           pstm.setString( 2, novaURL);
           pstm.setString( 3, antigoNome);
           pstm.setString( 4, antigaURL);
           pstm.executeUpdate();


       } catch(Exception e){

           JOptionPane.showMessageDialog( null,  "Erro ao atualizar",  "Erro", JOptionPane.ERROR_MESSAGE);

       }
   }
}


