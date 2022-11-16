package model.dao;

import javax.swing.*;

import entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBD implements Dao{
    private int idPublisher;
    private int autorId;
    private String nomeAutor;

    static private final String USER = "root";
    static private final String PASS = "";
    static private final String DATABASE = "livraria";
    static private final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

    // MÉTODOS RESPONSÁVEIS POR LISTAR AS ENTIDADES DO BD

    @Override
    public List<Livros> listarTodosLivros(){ // MÉTODO QUE LISTA TODOS LIVROS

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
    public List<Editoras> listarTodasEditoras(){ // MÉTODO QUE LISTA TODAS EDITORAS
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
    public List<Autores> listarTodosAutores(){ // MÉTODO QUE LISTA TODOS AUTORES
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
    public List<RelTudo>listarTudo(){ // MÉTODO QUE REALIZA A PESQUISA DE TODAS AS RELAÇÕES DA TABELA (SEM WHERE)

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
    public List<Autores> buscarAutorSelecionado(String nome){ // MÉTODO QUE REALIZA A PESQUISA DE AUTORES ESPECÍFICOS

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
    public List<Editoras> buscarEditoraSelecionada(String nome){ // MÉTODO QUE REALIZA A PESQUISA DE EDITORAS ESPECÍFICAS

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
    public List<Livros> buscarLivroSelecionado(String nome){ // MÉTODO QUE REALIZA A PESQUISA DE LIVROS ESPECÍFICOS

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
    public List<RelLivrosAutores> buscarRelLivroAutor(String nome){ // MÉTODO QUE REALIZA PESQUISA RELACIONANDO 'authors' e 'books'

        List<RelLivrosAutores> lista_rel= new ArrayList<>();

        final String query = "SELECT * FROM authors as A LEFT JOIN booksauthors as BA on A.author_id = BA.author_id LEFT JOIN books AS B on B.isbn = BA.isbn WHERE B.title LIKE ? OR B.isbn LIKE ? OR A.name LIKE ?;";

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
    public List<RelLivrosEditoras> buscarRelLivroEditora(String nome){ // MÉTODO QUE REALIZA PESQUISA RELACIONANDO 'books' e 'publishers'

        List<RelLivrosEditoras> lista_relLivrosEditoras= new ArrayList<>();

        final String query = "SELECT * FROM books as b LEFT JOIN publishers as p ON b.publisher_id =  p.publisher_id WHERE b.isbn LIKE ? or b.title LIKE ? or p.name LIKE ?;";

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
    public List<RelTudo> buscarTudo(String nome){ // MÉTODO QUE REALIZA PESQUISA DE RELACIONANDO TODOS OS DADOS DO BD (COM WHERE)

        List<RelTudo> lista_rel= new ArrayList<>();

        final String query = "SELECT a.fname, a.name, b.title, b.isbn, b.price, p.name as editora , p.url " 
        + " FROM authors as a " 
        + " LEFT JOIN booksauthors ba " 
        + " on ba.author_id = a.author_id "
        + " LEFT join books b "
        + " on b.isbn = ba.isbn "
        + " LEFT join publishers p "
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
    public void InsertLivros(String titulo, String isbn, float preco, String nomeEditora, String name, String fname){ // MÉTODO QUE REALIZA INSERT NA 'books'

        // TRY PARA VERIFICAR SE O AUTOR INSERIDO ESTÁ CADASTRADO NO BANCO DE DADOS
        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sqlRelacao = "select * from authors where name LIKE ? or fname = ? ";
            PreparedStatement pstm = con.prepareStatement(sqlRelacao);

            pstm.setString(1, name + "%");
            pstm.setString(2, fname );
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                // CASO SIM, PASSA O ID DESSE AUTOR PARA A VARIAVEL autorId
                autorId = rs.getInt("author_id");
                nomeAutor = rs.getString("fname") + " " + rs.getString("name");
            } else {
                // CASO NÃO, PASSA O VALOR 0 PARA A VARIÁVEL autorId
                autorId = 0;
            }

        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

        // TRY PARA VERIFICAR SE A EDITORA INSERIDA ESTÁ CADASTRADA NO BANCO DE DADOS
        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String sqlPesquisaEditora = "select * from publishers where name = ?";

            PreparedStatement pstm = con.prepareStatement(sqlPesquisaEditora);

            pstm.setString(1, nomeEditora);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                // CASO SIM, PASSA O ID DESSA EDITORA PARA A VARIÁVEL idPublisher
                idPublisher = rs.getInt("publisher_id");

            }else {
                // CASO NÃO, RETORNA UMA MENSAGEM DE ERRO E CANCELA O MÉTODO
                JOptionPane.showMessageDialog(null, "Editora inserida não cadastrada no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // QUERY PARA VERIFICAR SE O LIVRO JÁ ESTÁ CADASTRADO
        try(Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sqlVerificacaoLivro = "select * from books where isbn = ?";
            PreparedStatement pstm = con.prepareStatement(sqlVerificacaoLivro);

            pstm.setString(1, isbn);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                // SE ESTIVER CADASTRADO, QUERY PARA VERIFICAR SE A RELAÇÃO DO AUTOR JÁ ESTÁ CADASTRADA
                if(autorId != 0){
                    try(Connection con2 = DriverManager.getConnection(URL, USER, PASS)) {
                        String sqlVerificacaoAutor = "select * from booksauthors where author_id = ? AND isbn = ? ";
                        PreparedStatement pstm2 = con2.prepareStatement(sqlVerificacaoAutor);
            
                        pstm2.setInt(1, autorId);
                        pstm2.setString(2, isbn);
                        ResultSet rs2 = pstm2.executeQuery();

                        if(!rs2.next()){

                            // SE NÃO TIVER CADASTRADA, INSERE A RELAÇÃO
                            try(Connection con3 = DriverManager.getConnection(URL, USER, PASS)) {
                                String sqlInsert = "insert into booksauthors (author_id, isbn) value (?,?);";
                                PreparedStatement pstm3 = con3.prepareStatement(sqlInsert);                
                               
                                pstm3.setInt(1, autorId);
                                pstm3.setString(2, isbn);
                                pstm3.execute();
                                
                                JOptionPane.showMessageDialog(null, "Relação com o autor " + nomeAutor + " inserida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                            
                            }catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro ", JOptionPane.ERROR_MESSAGE);
                            
                            }

                        } else {
                            // SE TIVER A RELAÇÃO DO AUTOR COM O LIVRO ESTIVER CADASTRADA, RETORNA UMA MENASGEM PARA O USUÁRIO E TERMINA A EXECUÇÃO DO MÉTODO
                            JOptionPane.showMessageDialog(null, "O livro inserido já está cadastrado e sua relação com o autor " + nomeAutor + " também",  "Atençâo:", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                    }catch (SQLException ErroSql) {
                        JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            } else {
                // CASO NÃO, CADASTRA O LIVRO

                // QUERY PARA ADICIONAR O LIVRO INSERIDO
                try(Connection con4 = DriverManager.getConnection(URL, USER, PASS)) {

                    String SqlInsertLivros = "insert into Books (title, isbn, publisher_id, price) values (?, ?, ?, ?)";
                    PreparedStatement pstm4 = con4.prepareStatement(SqlInsertLivros);

                    pstm4.setString(1, titulo);
                    pstm4.setString(2, isbn);
                    pstm4.setInt(3, idPublisher);
                    pstm4.setFloat(4, preco);
                    pstm4.execute();

                    JOptionPane.showMessageDialog(null, "Livro adicionado com Sucesso. ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                }catch (SQLException ErroSql) {
                    JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados, verifique se o livro já está cadastrado e o dados estão corretos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } 

                if(autorId != 0){

                    // QUERY PARA CADASTRAR A PRIMEIRA RELAÇÃO DO AUTOR INSERIDO COM O LIVRO
                    try(Connection con3 = DriverManager.getConnection(URL, USER, PASS)) {
                        String sqlInsert = "insert into booksauthors (author_id, isbn) value (?,?);";
                        PreparedStatement pstm3 = con3.prepareStatement(sqlInsert);                
                       
                        pstm3.setInt(1, autorId);
                        pstm3.setString(2, isbn);
                        pstm3.execute();

                        JOptionPane.showMessageDialog(null, "Relação com o autor " + nomeAutor + " inserida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);    
                    
                    }catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro ", JOptionPane.ERROR_MESSAGE);
                    
                    }
                } 
            } 
                   
        }catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void InsertAutores(String Nome, String Sobrenome){ // MÉTODO QUE REALIZA INSERT NA 'authors'

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
    public void InsertEditoras(String nomeEditora, String Url){ // MÉTODO QUE REALIZA INSERT NA 'publishers'
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

    // MÉTODOS RESPONSÁVEIS POR EXCLUIR AS ENTIDADES DO BANCO DE DADOS

    @Override
    public void apagarLivro(String isbn){  // MÉTODO QUE REALIZA DELETE NA 'books'
   
        // SELECT PARA VERIFICAR SE EXISTE O LIVRO A SER EXCLUIDO
        String queryVerificaEditora = "SELECT * FROM books WHERE isbn = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaEditora);
            pstm.setString(1, isbn);
            ResultSet rs = pstm.executeQuery();
            
            if (!rs.next()){
                // CASO NÃO EXISTA, ABRE UM POP-UP COM ESSA MENSAGEM E PARA A EXECUÇÃO DO MÉTODO
                JOptionPane.showMessageDialog(null, "Livro não cadastrado no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // QUERY PARA APAGAR AS RELAÇÕES QUE ESSE LIVRO POSSUI COM OS AUTORES
        String queryDeleteBook = "DELETE FROM booksauthors WHERE isbn = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryDeleteBook);
            pstm.setString(1, isbn);
            pstm.execute();
        } catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // QUERY PARA EXCLUIR O LIVRO
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
    public void apagarAutor(String nome, String sobrenome){ // MÉTODO QUE REALIZA DELETE NA 'authors'

        String isbn;
        int escolha;

        // SELECT PARA VERIFICAR SE EXISTE O AUTOR A SER EXCLUIDO
        String queryVerificaEditora = "SELECT * FROM authors WHERE fname = ? AND name = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaEditora);
            pstm.setString(1, nome);
            pstm.setString(2, sobrenome);
            ResultSet rs = pstm.executeQuery();
            
            if (!rs.next()){
                // CASO NÃO EXISTA, ABRE UM POP-UP COM ESSA MENSAGEM E PARA A EXECUÇÃO DO MÉTODO
                JOptionPane.showMessageDialog(null, "Autor não cadastrado no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // QUERY PARA VERIFICAR SE ALGUM LIVRO TEM RELAÇÃO COM ESSE AUTOR 
        String queryVerificaRelacao = "SELECT * FROM booksauthors WHERE author_id IN (SELECT author_id FROM authors WHERE fname = ? AND name = ?);";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaRelacao);
            pstm.setString(1, nome);
            pstm.setString(2, sobrenome);
            ResultSet rs = pstm.executeQuery();

            
            if (rs.next()){
                isbn = rs.getString("isbn");
                // CASO EXISTA RELAÇÃO, ABRE UM POP-UP PARA O USUÁRIO ESCOLHER SE ELE QUER APAGAR O LIVRO TAMBÉM OU SÓ A RELAÇÃO
                escolha = JOptionPane.showConfirmDialog(null, "O autor inserido possuí um livro cadastrado no sistema, deseja excluir também?", "Atençao", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(escolha == JOptionPane.YES_OPTION){
                    this.apagarLivro(isbn); // CHAMA O MÉTODO DE APAGAR LIVRO E CONTINUA A EXECUÇÃO DO MÉTODO
                    JOptionPane.showMessageDialog(null, "Livro apagado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else if (escolha == JOptionPane.CANCEL_OPTION ){
                    JOptionPane.showMessageDialog(null, "Autor nao apagado", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // QUERY PARA EXCLUIR A RELAÇÃO DESSE AUTOR COM POSSÍVEIS LIVROS
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


        // QUERY PARA EXCLUIR O AUTOR
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
    public void apagarEditora(String editora){ // // MÉTODO QUE REALIZA DELETE na 'publishers'

        int contador = 1;
        int escolha;
        String isbn;

        // SELECT PARA VERIFICAR SE EXISTE A EDITORA A SER EXCLUIDA
        String queryVerificaEditora = "SELECT * FROM publishers WHERE name = ?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaEditora);
            pstm.setString(1, editora);
            ResultSet rs = pstm.executeQuery();
            
            if (!rs.next()){
                // CASO NÃO EXISTA, ABRE UM POP-UP COM ESSA MENSAGEM E PARA A EXECUÇÃO DO MÉTODO
                JOptionPane.showMessageDialog(null, "Editora não cadastrada no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a query no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // SELECT PARA VERIFICAR SE ESSA EDITORA POSSUI LIVRO CADASTRADO NELA 
        String queryVerificaLivro= "SELECT *  FROM books WHERE publisher_id IN (SELECT publisher_id FROM publishers WHERE name = ?);";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement pstm = con.prepareStatement(queryVerificaLivro);
            pstm.setString(1, editora);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                
                // CASO EXISTA RELAÇÃO, ABRE UM POP-UP PARA O USUÁRIO ESCOLHER SE ELE QUER APAGAR O LIVRO TAMBÉM OU SÓ A RELAÇÃO
                escolha = JOptionPane.showConfirmDialog(null, "A editora inserida possuí livros cadastrados no sistema, deseja exclui-los?", "Atençao", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(escolha == JOptionPane.YES_OPTION){
                    while (rs.next()){
                        contador ++;
                        isbn = rs.getString("isbn");
                        this.apagarLivro(isbn); // CHAMA O MÉTODO DE APAGAR LIVRO E CONTINUA A EXECUÇÃO DO MÉTODO  
                    }

                    JOptionPane.showMessageDialog(null, contador + " Livros apagados", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else if (escolha == JOptionPane.CANCEL_OPTION || escolha == JOptionPane.CLOSED_OPTION){
                    JOptionPane.showMessageDialog(null, "Editora não apagada", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // CASO O USUÁRIO ESCOLHA NÃO APAGAR OS LIVROS, ATUALIZA O COLUNA 'publisher_id' DO 'books' PARA 'NULL'
                String queryUpdEditoraToNull = "UPDATE books SET publisher_id = null WHERE publisher_id IN (SELECT publisher_id FROM publishers WHERE name = ?);";

                try(Connection con1 = DriverManager.getConnection(URL, USER, PASS)){
                    PreparedStatement pstm1 = con1.prepareStatement(queryUpdEditoraToNull);
                    pstm1.setString(1, editora);
                    pstm1.executeUpdate();

                } catch(SQLException ErroSql){
                    JOptionPane.showMessageDialog(null, "Erro ao executar query no Banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            // APÓS ESSAS VALIDAÇÕES EXCLUI A EDITORA!
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

    // MÉTODOS RESPONSÁVEIS POR ATUALIZAR AS ENTIDADES DO BANCO DE DADOS

    @Override
    public void atualizarAutor(String novoNome, String novoSobrenome, String antigoNome, String antigoSobrenome){ // MÉTODO QUE REALIZA UPDATE NA 'authors'
       
        // NESSE MÉTODO NÃO PRECISA FAZER VERIFICAÇÃO SE EXISTE NO BANCO, POIS O NOME JA VEM DE UMA PESQUISA NO BANCO


        // QUERY PARA ATUALIZAR O AUTOR
        String queryUpdAutor = "UPDATE authors set fname = ?, name = ? WHERE fname = ? AND name = ?;";


        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement pstm = con.prepareStatement(queryUpdAutor);
            pstm.setString(1, novoNome);
            pstm.setString(2, novoSobrenome);
            pstm.setString(3, antigoNome);
            pstm.setString(4, antigoSobrenome);
            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void atualizarLivro(String novoTitulo, float novoPreco, String antigoTitulo, float antigoPreco){ //MÉTODO QUE REALIZA UPDATE NA 'books'

        // NESSE MÉTODO NÃO PRECISA FAZER VERIFICAÇÃO SE EXISTE NO BANCO, POIS O NOME JA VEM DE UMA PESQUISA NO BANCO

        // QUERY PARA ATUALIZAR O LIVRO
        String queryUpdLivro = "UPDATE books set title = ?, price = ? WHERE title = ? and price = ?;";

       try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
           PreparedStatement pstm = con.prepareStatement(queryUpdLivro);
           pstm.setString( 1, novoTitulo);
           pstm.setFloat( 2, novoPreco);
           pstm.setString( 3, antigoTitulo);
           pstm.setFloat( 4, antigoPreco);
           pstm.executeUpdate();

           JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

       } catch(Exception e){
           JOptionPane.showMessageDialog( null,  "Erro ao atualizar",  "Erro", JOptionPane.ERROR_MESSAGE);
       }
   }

    @Override
    public void atualizarEditora(String novoNome, String novaURL, String antigoNome, String antigaURL){ // MÉTODO QUE REALIZA UPDATE NA 'publishers'

        // NESSE MÉTODO NÃO PRECISA FAZER VERIFICAÇÃO SE EXISTE NO BANCO, POIS O NOME JA VEM DE UMA PESQUISA NO BANCO

        // QUERY PARA ATUALIZAR A EDITORA
        String queryUpdEditora = "UPDATE publishers set name = ?, url = ? WHERE name = ? and url = ?;";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
           PreparedStatement pstm = con.prepareStatement(queryUpdEditora);
           pstm.setString( 1, novoNome);
           pstm.setString( 2, novaURL);
           pstm.setString( 3, antigoNome);
           pstm.setString( 4, antigaURL);
           pstm.executeUpdate();

           JOptionPane.showMessageDialog(null, "Editora atualizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception e){

           JOptionPane.showMessageDialog( null,  "Erro ao atualizar",  "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
