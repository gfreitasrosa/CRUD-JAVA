package view;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.*;

import java.awt.event.*;                                 

public class ViewConcreta extends JFrame implements ViewAbstrata {

    /**
     * Creates new form NewJFrame
     */
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
    DefaultTableModel modelo4;
    DefaultTableModel modelo5;

    String EscolhaAbaInserir;

    public ViewConcreta() {
        initComponents();
        pack();
        setVisible(true);
        modelo = (DefaultTableModel) this.tabela_abaPesquisa.getModel();
        modelo2 = (DefaultTableModel) this.tabela_abaAutor.getModel();
        modelo3 = (DefaultTableModel) this.tabelaAutor_abaAlterar.getModel();
        modelo4 = (DefaultTableModel) this.tabelaEditoras_abaAlterar.getModel();
        modelo5 = (DefaultTableModel) this.tabelaLivros_abaAlterar.getModel();
        this.desabilitarTela();
        this.desabilitarTelaDeletar();
        this.desabilitaTelaAlterar();
    }

    @Override
    public void initComponents() {
        g1 = new ButtonGroup();
        janelacomabas = new JTabbedPane();
        abaPesquisa = new JPanel();
        tituloPesquisa = new JLabel();
        jScrollPane1 = new JScrollPane();
        tabela_abaPesquisa = new JTable();
        TxtFieldPesquisa = new JTextField();
        BtnPesquisa = new JButton();
        CheckBoxAutoresPesquisa = new JCheckBox();
        Filtrodepesquisa_abaPesquisa = new JLabel();
        CheckBoxLivrosPesquisa = new JCheckBox();
        CheckBoxEditorasPesquisa = new JCheckBox();
        BtnAjudaPesquisa = new JButton();

        abaDeletar = new JPanel();
        LblTituloDeletar = new JLabel();

        abaInserir = new JPanel();
        titulo_abaInserir = new JLabel();
        botaoAjuda_abaInserir = new JButton();
        radioButton_AutorAbaInserir = new JRadioButton();
        radioButton_LivrosAbaInserir = new JRadioButton();
        radioButton_EditorasAbaInserir = new JRadioButton();
        caixadetexto_abaInserirSobreNome = new JTextField();
        caixadetexto_abaInserirNome1 = new JTextField();
        labelNome_abaInserir = new JLabel();
        labelSobreNome_abaInserir = new JLabel();
        caixadetexto_abaInserirTitulo = new JTextField();
        caixadetexto_abaInserirISBN = new JTextField();
        caixadetexto_abaInserirEditora = new JTextField();
        caixadetexto_abaInserirPreco = new JTextField();
        labelISBN_abaInserir = new JLabel();
        labelTitulo_abaInserir = new JLabel();
        labelpreco_abaInserir = new JLabel();
        labelNomeDaEditora_radiolivros_abaInserir = new JLabel();
        botaoAutor_abainserir = new JButton();
        labelAutores_abainserir = new JLabel();
        labelAutoresEscolhidos_abaInserir = new JLabel();
        labelNomeDaEditora_abaInserir = new JLabel();
        caixadetexto_NomeDaEditora_abaInserir = new JTextField();
        labelURL_abaInserir = new JLabel();
        caixadetexto_URL_abaInserir = new JTextField();
        botaoinserir_abaInserir1 = new JButton();
        
        tabela_abaAutor = new JTable();
        botao_autor = new JButton();

        // OBJETOS DA ABA ALTERAR

        LblDadosAntigosEditorasAlterar = new JLabel();
        LblNovoDadosEditorasAlterar = new JLabel();

        grupo_abaALterar = new ButtonGroup();

        abaAlterar = new JPanel();
        titulo_abaAlterar = new JLabel();
        BtnAjudaAlterar = new JButton();
        BtnAcaoAlterar = new JButton();

        botaoAutor_abaAlterar = new JButton();
        LblPrimeiroNomeAlterar = new JLabel();
        TxtFieldSobrenomeAlterar = new JLabel();

        TxtFieldNomeAlterar = new JLabel();
        LblNovosDadosAutoresAlterar = new JLabel();
        LblDadosAntigoAutoresAlterar = new JLabel();
        LblPrimeiroNomeAlterar2 = new JLabel();

        BtnLivrosAlterar = new JButton();
        LblAntigoPrecoAlterar = new JLabel();
        TxtFieldAntigoTituloAlterar = new JLabel();

        TxtFieldPrecoAntigoAlterar = new JLabel();
        LblTituloNovoAlterar = new JLabel();

        TxtFieldNovoTituloAlterar = new JTextField();
        TxtFieldNovoPrecoAlterar = new JTextField();
        LblNovoPrecoAlterar = new JLabel();
        LblNovoTituloAlterar = new JLabel();
        LblAntigaUrlAlterar = new JLabel();
        BtnEditorasAlterar = new JButton();
        LblAntigoNomeEditoraAlterar = new JLabel();
        TxtFieldAntigaUrlAlterar = new JLabel();
        TxtFieldAntigoNomeEditoraAlterar = new JLabel();

        LblNovoNomeEditoraAlterar = new JLabel();
        LblNovaUrlAlterar = new JLabel();
        TxtFieldNovaUrlAlterar = new JTextField();
        TxtFieldNovoNomeEditoraAlterar = new JTextField();

        radioButton_AutorAbaInserir1 = new JRadioButton();
        radioButton_EditorasAbaInserir1 = new JRadioButton();
        radioButton_LivrosAbaInserir1 = new JRadioButton();
        TxtFieldNovoNomeAlterar = new JTextField();
        TxtFieldNovoSobrenomeAlterar = new JTextField();

        LblDadosAntigosLivrosAlterar = new JLabel();
        lblNovosDadosLivrosAlterar = new JLabel();

        tabelaAutor_abaAlterar = new JTable();
        botaoAttAutor_abaAlterar = new JButton();

        tabelaEditoras_abaAlterar = new JTable();
        botaoAttEditoras_abaAlterar = new JButton();

        tabelaLivros_abaAlterar = new JTable();
        botaoAttLivros_abaAlterar = new JButton();

        // OBJETOS DA ABA DELETAR

        grupo_abaDeletar = new ButtonGroup();
        abaDeletar = new JPanel();
        LblTituloDeletar = new JLabel();
        BtnAjudaDeletar = new JButton();
        radioButton_EditorasAbaDeletar = new JRadioButton();
        LblPrimeiroNomeDeletar = new JLabel();
        LblISBNDeletar = new JLabel();
        LblNomeDaEditoraDeletar = new JLabel();
        LblSobrenomeDeletar = new JLabel();
        BtnDeletarDeletar = new JButton();
        TxtFieldPrimeiroNomeAutorDeletar = new JTextField();

        TxtFieldISBNDeletar = new JTextField();
        TxtFieldNomeDaEditoraDeletar = new JTextField();
        LblConclusaoDeTarefaDeletar = new JLabel();

        radioButton_AutorDeletar = new JRadioButton();
        radioButton_LivrosDeletar = new JRadioButton();
    
        TxtFieldSobrenomeAutorDeletar = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janelacomabas.setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        abaPesquisa.setBorder(new javax.swing.border.MatteBorder(null));

        tituloPesquisa.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        tituloPesquisa.setText("Pesquisas e Consultas");

        tabela_abaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nº Ordem", "Sobrenome do Autor", "Nome do Autor", "Título do livro", "ISBN", "Preço", "Nome da editora", "URL"
            }
        ));
        jScrollPane1.setViewportView(tabela_abaPesquisa);

        TxtFieldPesquisa.setBackground(new java.awt.Color(204, 204, 204));

        BtnPesquisa.setBackground(new java.awt.Color(204, 204, 204));

        BtnPesquisa.setText("Pesquisar");

        CheckBoxAutoresPesquisa.setText("Autores");

        Filtrodepesquisa_abaPesquisa.setText("Pesquisar em:");

        CheckBoxLivrosPesquisa.setText("Livros");

        CheckBoxEditorasPesquisa.setText("Editoras");

        BtnAjudaPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        BtnAjudaPesquisa.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        BtnAjudaPesquisa.setText("Ajuda?");
        BtnAjudaPesquisa.setToolTipText("");

        GroupLayout abaPesquisaLayout = new GroupLayout(abaPesquisa);
        abaPesquisa.setLayout(abaPesquisaLayout);
        abaPesquisaLayout.setHorizontalGroup(
            abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGroup(abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaPesquisaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Filtrodepesquisa_abaPesquisa)
                                .addGap(122, 122, 122)
                                .addComponent(CheckBoxLivrosPesquisa)
                                .addGap(122, 122, 122)
                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CheckBoxAutoresPesquisa)
                                .addGap(122, 122, 122)
                                .addComponent(CheckBoxEditorasPesquisa))
                            .addComponent(TxtFieldPesquisa))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPesquisa))
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tituloPesquisa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, abaPesquisaLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAjudaPesquisa)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaPesquisaLayout.setVerticalGroup(
            abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPesquisa)
                .addGap(4, 4, 4)
                .addGroup(abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFieldPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaPesquisaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxAutoresPesquisa)
                    .addComponent(Filtrodepesquisa_abaPesquisa)
                    .addComponent(CheckBoxLivrosPesquisa)
                    .addComponent(CheckBoxEditorasPesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnAjudaPesquisa, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        janelacomabas.addTab("Pesquisar", abaPesquisa);

        janelacomabas.addTab("Inserir", abaInserir);

        abaDeletar.setBorder(new javax.swing.border.MatteBorder(null));

        LblTituloDeletar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LblTituloDeletar.setText("Deletar dados existentes");

        BtnAjudaDeletar.setBackground(new java.awt.Color(204, 204, 204));
        BtnAjudaDeletar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        BtnAjudaDeletar.setText("Ajuda?");
        BtnAjudaDeletar.setToolTipText("");

        grupo_abaDeletar.add(radioButton_AutorDeletar);
        radioButton_AutorDeletar.setText("Autor");
        radioButton_AutorDeletar.setToolTipText("");

        grupo_abaDeletar.add(radioButton_LivrosDeletar);
        radioButton_LivrosDeletar.setText("Livros");

        grupo_abaDeletar.add(radioButton_EditorasAbaDeletar);
        radioButton_EditorasAbaDeletar.setText("Editoras");

        LblPrimeiroNomeDeletar.setText("Primeiro Nome:");

        LblISBNDeletar.setText("ISBN:");

        LblNomeDaEditoraDeletar.setText("Nome da Editora:");

        LblSobrenomeDeletar.setText("Sobrenome:");

        BtnDeletarDeletar.setBackground(new java.awt.Color(255, 51, 51));
        BtnDeletarDeletar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        BtnDeletarDeletar.setText("Deletar");
        BtnDeletarDeletar.setToolTipText("");

        tabelaAutor_abaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nº Ordem", "Sobrenome do Autor", "Nome do autor"
            }
        ));

        tabelaEditoras_abaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nº Ordem", "Nome", "URL"
            }
        ));
       
        LblConclusaoDeTarefaDeletar.setText("");

        GroupLayout abaDeletarLayout = new GroupLayout(abaDeletar);
        abaDeletar.setLayout(abaDeletarLayout);
        abaDeletarLayout.setHorizontalGroup(
            abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, abaDeletarLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(LblISBNDeletar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFieldISBNDeletar)
                        .addGap(21, 21, 21))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(radioButton_LivrosDeletar)
                        .addGap(545, 545, 545)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addComponent(BtnAjudaDeletar)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(LblConclusaoDeTarefaDeletar, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDeletarDeletar))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addComponent(radioButton_AutorDeletar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, abaDeletarLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(LblPrimeiroNomeDeletar)
                            .addComponent(LblSobrenomeDeletar))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFieldPrimeiroNomeAutorDeletar)
                            .addComponent(TxtFieldSobrenomeAutorDeletar)))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton_EditorasAbaDeletar)
                            .addGroup(abaDeletarLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblNomeDaEditoraDeletar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNomeDaEditoraDeletar, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblTituloDeletar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaDeletarLayout.setVerticalGroup(
            abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTituloDeletar)
                .addGap(16, 16, 16)
                .addComponent(radioButton_AutorDeletar)
                .addGap(18, 18, 18)
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPrimeiroNomeDeletar)
                    .addComponent(TxtFieldPrimeiroNomeAutorDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSobrenomeDeletar)
                    .addComponent(TxtFieldSobrenomeAutorDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(radioButton_LivrosDeletar)
                .addGap(1, 1, 1)
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblISBNDeletar)
                    .addComponent(TxtFieldISBNDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(radioButton_EditorasAbaDeletar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNomeDaEditoraDeletar)
                    .addComponent(TxtFieldNomeDaEditoraDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(abaDeletarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAjudaDeletar)
                    .addComponent(BtnDeletarDeletar)
                    .addComponent(LblConclusaoDeTarefaDeletar))
                .addContainerGap())
        );

        janelacomabas.addTab("Deletar", abaDeletar);

        abaAlterar.setBorder(new javax.swing.border.MatteBorder(null));

        titulo_abaAlterar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titulo_abaAlterar.setText("Alterar dados existentes");

        BtnAjudaAlterar.setBackground(new java.awt.Color(204, 204, 204));
        BtnAjudaAlterar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        BtnAjudaAlterar.setText("Ajuda?");
        BtnAjudaAlterar.setToolTipText("");

        tabelaAutor_abaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nº Ordem", "Sobrenome do Autor", "Nome do autor"
            }
        ));

        tabelaEditoras_abaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nº Ordem", "Nome", "URL"
            }
        ));

        tabelaLivros_abaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                    "Nº Ordem","Titulo", "Preço"
            }
        ));

        BtnAcaoAlterar.setBackground(new java.awt.Color(51, 255, 204));
        BtnAcaoAlterar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        BtnAcaoAlterar.setText("Alterar");
        BtnAcaoAlterar.setToolTipText("");

        grupo_abaALterar.add(radioButton_AutorAbaInserir1);
        radioButton_AutorAbaInserir1.setText("Autor");
        radioButton_AutorAbaInserir1.setToolTipText("");

        grupo_abaALterar.add(radioButton_LivrosAbaInserir1);
        radioButton_LivrosAbaInserir1.setText("Livros");

        grupo_abaALterar.add(radioButton_EditorasAbaInserir1);
        radioButton_EditorasAbaInserir1.setText("Editoras");

        botaoAutor_abaAlterar.setText("Escolher Autor");

        LblPrimeiroNomeAlterar.setText("Primeiro nome:");

        TxtFieldSobrenomeAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldSobrenomeAlterar.setText("Sobrenome do autor");
        TxtFieldSobrenomeAlterar.setBorder(BorderFactory.createEtchedBorder());

        TxtFieldNomeAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldNomeAlterar.setText("Nome do autor");
        TxtFieldNomeAlterar.setBorder(BorderFactory.createEtchedBorder());

        LblNovosDadosAutoresAlterar.setText("Novos Dados");

        LblDadosAntigoAutoresAlterar.setText("Dados Antigos");

        LblPrimeiroNomeAlterar2.setText("Primeiro nome:");

        TxtFieldNovoNomeAlterar.setText("");

        TxtFieldNovoSobrenomeAlterar.setText("");

        BtnLivrosAlterar.setText("Escolher Livro");

        LblAntigoPrecoAlterar.setText("Preço:");

        TxtFieldAntigoTituloAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigoTituloAlterar.setText("Titulo do livro");
        TxtFieldAntigoTituloAlterar.setBorder(BorderFactory.createEtchedBorder());

        LblDadosAntigosLivrosAlterar.setText("Dados Antigos");

        TxtFieldPrecoAntigoAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldPrecoAntigoAlterar.setText("Preço");
        TxtFieldPrecoAntigoAlterar.setBorder(BorderFactory.createEtchedBorder());

        LblTituloNovoAlterar.setText("Titulo:");

        lblNovosDadosLivrosAlterar.setText("Novos Dados");

        TxtFieldNovoTituloAlterar.setText("");

        TxtFieldNovoPrecoAlterar.setText("");

        LblNovoPrecoAlterar.setText("Preço:");

        LblNovoTituloAlterar.setText("Titulo:");

        LblAntigaUrlAlterar.setText("URL:");

        BtnEditorasAlterar.setText("Escolher Editoras");

        LblAntigoNomeEditoraAlterar.setText("Nome da Editora:");

        TxtFieldAntigaUrlAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigaUrlAlterar.setText("URL da editora");
        TxtFieldAntigaUrlAlterar.setBorder(BorderFactory.createEtchedBorder());

        TxtFieldAntigoNomeEditoraAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigoNomeEditoraAlterar.setText("Nome Da Editora");
        TxtFieldAntigoNomeEditoraAlterar.setBorder(BorderFactory.createEtchedBorder());

        LblDadosAntigosEditorasAlterar.setText("Dados Antigos");

        LblNovoDadosEditorasAlterar.setText("Novos Dados");

        LblNovoNomeEditoraAlterar.setText("Nome da Editora:");

        LblNovaUrlAlterar.setText("URL:");

        TxtFieldNovaUrlAlterar.setText("");

        TxtFieldNovoNomeEditoraAlterar.setText("");

        GroupLayout abaAlterarLayout = new GroupLayout(abaAlterar);
        abaAlterar.setLayout(abaAlterarLayout);
        abaAlterarLayout.setHorizontalGroup(
            abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                        .addComponent(botaoAutor_abaAlterar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblPrimeiroNomeAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNomeAlterar, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblPrimeiroNomeAlterar2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoNomeAlterar)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFieldSobrenomeAlterar, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFieldNovoSobrenomeAlterar, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addComponent(radioButton_LivrosAbaInserir1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblDadosAntigosLivrosAlterar)
                        .addGap(68, 68, 68)
                        .addComponent(lblNovosDadosLivrosAlterar)
                        .addGap(145, 145, 145))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(radioButton_AutorAbaInserir1)
                                .addGap(189, 189, 189)
                                .addComponent(LblDadosAntigoAutoresAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(LblNovosDadosAutoresAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(BtnLivrosAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(LblAntigoPrecoAlterar)
                                    .addComponent(LblNovoTituloAlterar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtFieldPrecoAntigoAlterar)
                                    .addComponent(TxtFieldAntigoTituloAlterar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(radioButton_EditorasAbaInserir1)
                                .addGap(182, 182, 182)
                                .addComponent(LblDadosAntigosEditorasAlterar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                                .addComponent(BtnAjudaAlterar)
                                .addGap(580, 580, 580)
                                .addComponent(BtnAcaoAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(BtnEditorasAlterar)
                                .addGap(18, 18, 18)
                                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(abaAlterarLayout.createSequentialGroup()
                                        .addComponent(LblNovoNomeEditoraAlterar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldNovoNomeEditoraAlterar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblNovaUrlAlterar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldNovaUrlAlterar))
                                    .addGroup(abaAlterarLayout.createSequentialGroup()
                                        .addComponent(LblAntigoNomeEditoraAlterar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldAntigoNomeEditoraAlterar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblAntigaUrlAlterar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldAntigaUrlAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(titulo_abaAlterar))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblTituloNovoAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoTituloAlterar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblNovoPrecoAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoPrecoAlterar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(LblNovoDadosEditorasAlterar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        abaAlterarLayout.setVerticalGroup(
            abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_abaAlterar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(LblDadosAntigoAutoresAlterar)
                    .addComponent(radioButton_AutorAbaInserir1))
                .addGap(9, 9, 9)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAutor_abaAlterar)
                    .addComponent(LblPrimeiroNomeAlterar)
                    .addComponent(TxtFieldNomeAlterar)
                    .addComponent(TxtFieldSobrenomeAlterar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNovosDadosAutoresAlterar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPrimeiroNomeAlterar2)
                    .addComponent(TxtFieldNovoNomeAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFieldNovoSobrenomeAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_LivrosAbaInserir1)
                    .addComponent(LblDadosAntigosLivrosAlterar)
                    .addComponent(lblNovosDadosLivrosAlterar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnLivrosAlterar)
                            .addComponent(TxtFieldAntigoTituloAlterar))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFieldPrecoAntigoAlterar)
                            .addComponent(LblAntigoPrecoAlterar)))
                    .addComponent(LblNovoTituloAlterar)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LblTituloNovoAlterar)
                            .addComponent(TxtFieldNovoTituloAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNovoPrecoAlterar)
                            .addComponent(TxtFieldNovoPrecoAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_EditorasAbaInserir1)
                    .addComponent(LblDadosAntigosEditorasAlterar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEditorasAlterar)
                    .addComponent(LblAntigoNomeEditoraAlterar)
                    .addComponent(TxtFieldAntigoNomeEditoraAlterar)
                    .addComponent(LblAntigaUrlAlterar)
                    .addComponent(TxtFieldAntigaUrlAlterar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblNovoDadosEditorasAlterar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNovoNomeEditoraAlterar)
                    .addComponent(LblNovaUrlAlterar)
                    .addComponent(TxtFieldNovaUrlAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFieldNovoNomeEditoraAlterar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(abaAlterarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAcaoAlterar)
                            .addComponent(BtnAjudaAlterar)))
                    .addGroup(GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap())
        )));

        LblPrimeiroNomeAlterar.getAccessibleContext().setAccessibleName("Nome do Autor:");

        grupo_abaALterar.add(radioButton_AutorAbaInserir);
        radioButton_AutorAbaInserir.setText("Autor");
        radioButton_AutorAbaInserir.setToolTipText("");

        grupo_abaALterar.add(radioButton_LivrosAbaInserir);
        radioButton_LivrosAbaInserir.setText("Livros");

        janelacomabas.addTab("Alterar", abaAlterar);
        
        abaInserir.setBorder(new javax.swing.border.MatteBorder(null));

        titulo_abaInserir.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titulo_abaInserir.setText("Inserir novos dados");

        botaoAjuda_abaInserir.setBackground(new java.awt.Color(204, 204, 204));
        botaoAjuda_abaInserir.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        botaoAjuda_abaInserir.setText("Ajuda?");
        botaoAjuda_abaInserir.setToolTipText("");

        g1.add(radioButton_AutorAbaInserir);
        radioButton_AutorAbaInserir.setText("Autor");
        radioButton_AutorAbaInserir.setToolTipText("");

        g1.add(radioButton_LivrosAbaInserir);
        radioButton_LivrosAbaInserir.setText("Livros");

        g1.add(radioButton_EditorasAbaInserir);
        radioButton_EditorasAbaInserir.setText("Editoras");

        labelNome_abaInserir.setText("Primeiro nome: ");

        labelSobreNome_abaInserir.setText("Sobrenome:");

        labelISBN_abaInserir.setText("ISBN");

        labelTitulo_abaInserir.setText("Título do Livro: ");

        labelpreco_abaInserir.setText("Preço:");

        labelNomeDaEditora_radiolivros_abaInserir.setText("Nome da Editora:");
        labelNomeDaEditora_radiolivros_abaInserir.setToolTipText("");

        botaoAutor_abainserir.setText("Escolher Autor");

        labelAutores_abainserir.setText("Autores:");

        labelAutoresEscolhidos_abaInserir.setText("");
    

        labelNomeDaEditora_abaInserir.setText("Nome da Editora:");

        labelURL_abaInserir.setText("URL:");


        tabela_abaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nº Ordem", "Sobrenome do Autor", "Nome do autor"
            }
        ));

        botaoinserir_abaInserir1.setBackground(new java.awt.Color(153, 255, 153));
        botaoinserir_abaInserir1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        botaoinserir_abaInserir1.setText("Inserir");
        botaoinserir_abaInserir1.setToolTipText("");

        GroupLayout abaInserirLayout = new GroupLayout(abaInserir);
        abaInserir.setLayout(abaInserirLayout);
        abaInserirLayout.setHorizontalGroup(
            abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaInserirLayout.createSequentialGroup()
                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(abaInserirLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelAutoresEscolhidos_abaInserir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                        .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(abaInserirLayout.createSequentialGroup()
                                                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(botaoAutor_abainserir, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelAutores_abainserir))
                                                .addGap(18, 18, 18)
                                                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                                        .addComponent(labelNomeDaEditora_radiolivros_abaInserir)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(caixadetexto_abaInserirEditora))
                                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                                        .addComponent(labelTitulo_abaInserir)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(caixadetexto_abaInserirTitulo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(21, 21, 21)
                                                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelpreco_abaInserir)
                                                    .addComponent(labelISBN_abaInserir))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(caixadetexto_abaInserirISBN)
                                                    .addComponent(caixadetexto_abaInserirPreco, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                                            .addGroup(abaInserirLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(labelNome_abaInserir)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(caixadetexto_abaInserirNome1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelSobreNome_abaInserir)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(caixadetexto_abaInserirSobreNome, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2))))
                            .addComponent(radioButton_AutorAbaInserir)
                            .addComponent(radioButton_EditorasAbaInserir)
                            .addComponent(radioButton_LivrosAbaInserir)
                            .addGroup(abaInserirLayout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(titulo_abaInserir))
                            .addGroup(abaInserirLayout.createSequentialGroup()
                                .addComponent(botaoAjuda_abaInserir)
                                .addGap(18, 18, 18)
                                .addGap(18, 18, 18)
                                .addComponent(botaoinserir_abaInserir1))))
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelNomeDaEditora_abaInserir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixadetexto_NomeDaEditora_abaInserir, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelURL_abaInserir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixadetexto_URL_abaInserir)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaInserirLayout.setVerticalGroup(
            abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(abaInserirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo_abaInserir)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(radioButton_AutorAbaInserir)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome_abaInserir)
                    .addComponent(caixadetexto_abaInserirNome1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSobreNome_abaInserir)
                    .addComponent(caixadetexto_abaInserirSobreNome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(radioButton_LivrosAbaInserir)
                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(caixadetexto_abaInserirTitulo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(caixadetexto_abaInserirISBN, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelISBN_abaInserir)
                            .addComponent(labelTitulo_abaInserir))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomeDaEditora_radiolivros_abaInserir)
                            .addComponent(caixadetexto_abaInserirPreco, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelpreco_abaInserir)
                            .addComponent(caixadetexto_abaInserirEditora, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botaoAutor_abainserir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAutores_abainserir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(labelAutoresEscolhidos_abaInserir)
                .addGap(29, 29, 29)
                .addComponent(radioButton_EditorasAbaInserir)
                .addGap(18, 18, 18)
                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeDaEditora_abaInserir)
                    .addComponent(caixadetexto_NomeDaEditora_abaInserir, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelURL_abaInserir)
                    .addComponent(caixadetexto_URL_abaInserir, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(abaInserirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoinserir_abaInserir1)
                    .addComponent(botaoAjuda_abaInserir))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        janelacomabas.addTab("Inserir", abaInserir);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelacomabas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelacomabas)
                .addContainerGap())
        );

        pack();
    }

    // *****************************
    // * MÉTODOS DA JANELA DELETAR *
    // *****************************

    @Override
    public void deletar(ActionListener al){
        this.BtnDeletarDeletar.addActionListener(al);
    }

    @Override // Métodos Gets para pegar o texto digitado pelo user
    public String getTextoNomeAutor(){
        return this.TxtFieldPrimeiroNomeAutorDeletar.getText();
    }

    @Override
    public String getTextoSobrenomeAutor(){
        return this.TxtFieldSobrenomeAutorDeletar.getText();
    }

    @Override
    public String getTextoISBN() {
        return this.TxtFieldISBNDeletar.getText();
    }

    @Override
    public String getTextoEditora() {
        return this.TxtFieldNomeDaEditoraDeletar.getText();
    }

    @Override // Mensagem no fim da tela que trata os campos vazio
    public void atualizarMensagemConclusao(String mensagem) {
        this.LblConclusaoDeTarefaDeletar.setText(mensagem);
    }

    @Override // Métodos para pegar a escolha de qual seção o autor vai deletar
    public boolean verificaEscolhaDeletarAutor() {
        return this.radioButton_AutorDeletar.isSelected();
    }

    @Override
    public boolean verificaEscolhaDeletarEditora() {
        return this.radioButton_EditorasAbaDeletar.isSelected();
    }

    @Override
    public boolean verificaEscolhaDeletarLivro() {
        return this.radioButton_LivrosDeletar.isSelected();
    }

    @Override
    public void habilitarLivrosDeletar(){
        this.TxtFieldISBNDeletar.setEnabled(true);
    }

    @Override
    public void habilitarAutorDeletar(){
        this.TxtFieldPrimeiroNomeAutorDeletar.setEnabled(true);
        this.TxtFieldSobrenomeAutorDeletar.setEnabled(true);
    }

    @Override
    public void habilitarEditorasDeletar(){
        this.TxtFieldNomeDaEditoraDeletar.setEnabled(true);
    }

    @Override // Método que deixa a tela desabilitada por padrão
    public void desabilitarTelaDeletar(){
        this.TxtFieldISBNDeletar.setEnabled(false);
    
        this.TxtFieldSobrenomeAutorDeletar.setEnabled(false);
        this.TxtFieldPrimeiroNomeAutorDeletar.setEnabled(false);

        this.TxtFieldNomeDaEditoraDeletar.setEnabled(false);
    }

    @Override
    public void habilitarTelasDeletar(ActionListener al) {
        this.radioButton_AutorDeletar.addActionListener(al);
        this.radioButton_LivrosDeletar.addActionListener(al);
        this.radioButton_EditorasAbaDeletar.addActionListener(al);
    }

    @Override // Método do botão de ajuda
    public void ajudaDeletar(ActionListener al) {
        this.BtnAjudaDeletar.addActionListener(al);
    }

    @Override // Popup da mensagem em si do botao de ajuda
    public void mensagemAjudaDeletar(){
        String[] infos = {"Nas checkboxs escolha os campos que deseja deletar.", "Autor: Deletar a partir do Nome e Sobrenome", "Livros: Deleta a partir do ISBN do livro.", "Editoras: Deleta a partir do nome da Editora."};
        JOptionPane.showMessageDialog(null, infos, "Como deletar:", JOptionPane.INFORMATION_MESSAGE);
    }

    //*****************************
    //* MÉTODOS DA JANELA INSERIR *
    //*****************************

    public void limpaAutoresInserir(){
        this.labelAutoresEscolhidos_abaInserir.setText("");
    }

    @Override
    public void camposInsLivros(ActionListener al){
        this.radioButton_LivrosAbaInserir.addActionListener(al);
    }

    @Override
    public void BtnAjudaInserir(ActionListener al){
        this.botaoAjuda_abaInserir.addActionListener(al);
    }

    @Override
    public void mensagemAjudaInserir(){
        String[] infos = {"Nas checkbox selecione o que deseja inserir para habilitar os campos", "Autores: Inserir Nome e Sobrenome", "Livros: Escolha o Autor, Insira o Titulo, Preco, ISBN e Editora", "Editora: Insira o Nome da Editora e URL."};
        JOptionPane.showMessageDialog(null, infos, "Como utilizar o método Inserir:", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void camposInsEditoras(ActionListener al){
        this.radioButton_EditorasAbaInserir.addActionListener(al);
    }

    @Override
    public void camposInsAutores(ActionListener al){
        this.radioButton_AutorAbaInserir.addActionListener(al);
    }

    @Override
    public boolean verificaEscolhaInserirAutor(){
        return this.radioButton_AutorAbaInserir.isSelected();
    }

    @Override
    public boolean verificaEscolhaInserirEditora(){
        return this.radioButton_EditorasAbaInserir.isSelected();
    }

    @Override
    public boolean verificaEscolhaInserirLivro(){
        return this.radioButton_LivrosAbaInserir.isSelected();
    }

    @Override
    public void habilitaEditoras(){
        this.caixadetexto_NomeDaEditora_abaInserir.setEnabled(true);
        this.caixadetexto_URL_abaInserir.setEnabled(true);
    }

    @Override
    public void habilitarAutor(){
        this.caixadetexto_abaInserirSobreNome.setEnabled(true);
        this.caixadetexto_abaInserirNome1.setEnabled(true);
    }

    @Override
    public void habilitaLivros(){
        this.caixadetexto_abaInserirTitulo.setEnabled(true);
        this.caixadetexto_abaInserirPreco.setEnabled(true);
        this.caixadetexto_abaInserirISBN.setEnabled(true);
        this.caixadetexto_abaInserirEditora.setEnabled(true);
        this.botaoAutor_abainserir.setEnabled(true);
    }

    @Override
    public void habilitarTela(){
        this.caixadetexto_abaInserirSobreNome.setEnabled(true);
        this.caixadetexto_abaInserirNome1.setEnabled(true);

        this.caixadetexto_abaInserirTitulo.setEnabled(true);
        this.caixadetexto_abaInserirPreco.setEnabled(true);
        this.caixadetexto_abaInserirISBN.setEnabled(true);
        this.caixadetexto_abaInserirEditora.setEnabled(true);
        this.botaoAutor_abainserir.setEnabled(true);
        this.caixadetexto_NomeDaEditora_abaInserir.setEnabled(true);
        this.caixadetexto_URL_abaInserir.setEnabled(true);
    }

    @Override
    public void desabilitarTela(){
        this.caixadetexto_abaInserirSobreNome.setEnabled(false);
        this.caixadetexto_abaInserirNome1.setEnabled(false);

        this.caixadetexto_abaInserirTitulo.setEnabled(false);
        this.caixadetexto_abaInserirPreco.setEnabled(false);
        this.caixadetexto_abaInserirISBN.setEnabled(false);
        this.caixadetexto_abaInserirEditora.setEnabled(false);
        this.botaoAutor_abainserir.setEnabled(false);
        this.caixadetexto_NomeDaEditora_abaInserir.setEnabled(false);
        this.caixadetexto_URL_abaInserir.setEnabled(false);
    }

    @Override //inicializando botao de inserir
    public void Inserir(ActionListener al){
        this.botaoinserir_abaInserir1.addActionListener(al);
    }

    @Override // Gets para Autor
    public String getNome(){
        return this.caixadetexto_abaInserirNome1.getText();
    }

    @Override
    public String getSobrenome(){
       return this.caixadetexto_abaInserirSobreNome.getText();
    }

    //Gets para editoras
    @Override
    public String getNomeEditora(){
        return this.caixadetexto_NomeDaEditora_abaInserir.getText();
    }

    @Override
    public String getUrl(){
        return this.caixadetexto_URL_abaInserir.getText();
    }

    // Gets para os livros
    @Override
    public String getInserirTitulo(){
        return this.caixadetexto_abaInserirTitulo.getText();
    }

    @Override
    public String getInserirPreco(){
        if (!this.caixadetexto_abaInserirPreco.getText().matches("[0-9]*")){
            return "0";
             
        }else if (this.caixadetexto_abaInserirPreco.getText().equals("")){
            return "0";
            
        } else {
            return this.caixadetexto_abaInserirPreco.getText();
        }
    }

    @Override
    public String getISBN(){
        return this.caixadetexto_abaInserirISBN.getText();
    }

    @Override
    public String getInserirEditoras(){
        return this.caixadetexto_abaInserirEditora.getText();
    }

    @Override
    public String getAutoresSelecionados(){
        return this.labelAutoresEscolhidos_abaInserir.getText();
    }

    @Override
    public String pesquisaInserir(){
        int value;
        value = this.tabela_abaAutor.getSelectedRow();

        String texto = this.tabela_abaAutor.getValueAt(value, 1).toString() + " " + this.tabela_abaAutor.getValueAt(value, 2).toString() + " / ";
        return texto;
    }

    @Override
    public void attTextoAutorInserir(String texto){
        labelAutoresEscolhidos_abaInserir.setText(labelAutoresEscolhidos_abaInserir.getText() + " " + texto);
    }

    @Override
    public void popUpAutorAbaInserir(){
        // JFrame table = new JFrame();
        // table.setSize(300, 300);
        // table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        popUp = new JDialog();

        popUp.setSize(500, 500);
        popUp.setLayout(new FlowLayout());
        popUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(tabela_abaAutor);

        botao_autor.setText("Adicionar");

        tabela_abaAutor.setSize(350, 350);

        // panel.add(tabela_abaAutor);
        // panel.setSize(480, 380);
        popUp.add(scroll);
        // popUp.add(tabela_abaAutor);
        popUp.add(botao_autor);
        popUp.setTitle("Escolha um autor!");

        // table.setVisible(true);

        popUp.setVisible(true); 

        // table.add(tabela_abaAutor);
        // table.add(botao_autor);
        // table.add(jScrollPane1);
    }

    @Override
    public void addAutorInserir(ActionListener al){
        this.botaoAutor_abainserir.addActionListener(al);
    }

    @Override
    public void atualizaAutoresAbaInserir(int contador, Autores autor){

        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo2.addRow(infos);
        this.tabela_abaAutor.getTableHeader().resizeAndRepaint();
    }

    @Override
    public Boolean getOpcaoAutorAbaInserir(){
       return radioButton_AutorAbaInserir.isSelected();
    }

    @Override
    public Boolean getOpcaoEditoraAbaInserir(){
        return radioButton_EditorasAbaInserir.isSelected();
    }
    
    @Override
    public Boolean getOpcaoLivroAbarInserir(){
        return radioButton_LivrosAbaInserir.isSelected();
    }

    @Override
    public void attAutor(ActionListener al){
        this.botao_autor.addActionListener(al);
    } 

    //**************************
    //* MÉTODOS JANELA ALTERAR *
    //**************************

    @Override
    public void ajudaAlterar(ActionListener al){ // BOTÃO AJUDA ALTERAR
        this.BtnAjudaAlterar.addActionListener(al);
    }

    @Override
    public void mensagemAjudaAlterar(){ // MENSAGEM POP-UP DO BOTÃO AJUDA
        String[] infos = {"Clique no botão referente a qual entidade deseja atualizar", "Escolha ela na lista", "Insira o novos dados e clique no botão Alterar"};
        JOptionPane.showMessageDialog(null, infos, "Como realizar as alterações:", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void pesquisaAutorAlterar(ActionListener al){ // BOTÃO DO AUTOR ALTERAR
        this.botaoAutor_abaAlterar.addActionListener(al);
    }

    @Override
    public void popUpAutorAbaAlterar(){ // POP UP DO AUTOR
        // JFrame table = new JFrame();
        // table.setSize(300, 300);
        // table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        popUp = new JDialog();
 
        popUp.setSize(500, 500);
        popUp.setLayout(new FlowLayout());
        popUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(tabelaAutor_abaAlterar);

        botaoAttAutor_abaAlterar.setText("Adicionar");

        tabelaAutor_abaAlterar.setSize(350, 350);

        // panel.add(tabela_abaAutor);
        // panel.setSize(480, 380);
        popUp.add(scroll);
        // popUp.add(tabela_abaAutor);
        popUp.add(botaoAttAutor_abaAlterar);
        popUp.setTitle("Escolha um autor para atualizar!");

        // table.setVisible(true);

        popUp.setVisible(true); 

        // table.add(tabela_abaAutor);
        // table.add(botao_autor);
        // table.add(jScrollPane1);
    }

    @Override
    public void pesquisarEditoraAlterar(ActionListener al){ // BOTÃO EDITORA ALTERAR
        this.BtnEditorasAlterar.addActionListener(al);
    }

    @Override
    public void popUpEditorasAbaAlterar(){  // POPUP DA EDITORA
        // JFrame table = new JFrame();
        // table.setSize(300, 300);
        // table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        popUp = new JDialog();
 
        popUp.setSize(500, 500);
        popUp.setLayout(new FlowLayout());
        popUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        // JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(tabelaEditoras_abaAlterar);

        botaoAttEditoras_abaAlterar.setText("Adicionar");
        
        tabelaEditoras_abaAlterar.setSize(350, 350);

        // panel.add(tabela_abaAutor);
        // panel.setSize(480, 380);
        popUp.add(scroll);
        // popUp.add(tabela_abaAutor);
        popUp.add(botaoAttEditoras_abaAlterar);
        popUp.setTitle("Escolha uma editoras para atualizar!");

        // table.setVisible(true);

        popUp.setVisible(true); 

        // table.add(tabela_abaAutor);
        // table.add(botao_autor);
        // table.add(jScrollPane1);   
    }

    @Override
    public void atualizaAutoresAbaAlterar(int contador, Autores autor){ // TABLE QUE APARECE NOME DO AUTOR SOBRENOME
        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo3.addRow(infos);
        this.tabelaAutor_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaLivrosAbaAlterar(int contador, Livros livro){
        String[] infos = {(Integer.toString(contador)),livro.getTitle(),Float.toString(livro.getPrice())};

        modelo5.addRow(infos);
        this.tabelaLivros_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaEditorasAbaAlterar(int contador, Editoras editora){
        String[] infos = {(Integer.toString(contador)), editora.getName(),editora.getUrl()};

        modelo4.addRow(infos);
        this.tabelaEditoras_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void pesquisaLivrosAlterar(ActionListener al){  // BOTÃO DO LIVRO ALTERAR
        this.BtnLivrosAlterar.addActionListener(al);
    }
    
    @Override
    public void popUpLivrosAbaAlterar(){    // POP UP DO LIVRO ALTERAR
        // JFrame table = new JFrame();
        // table.setSize(300, 300);
        // table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        popUp = new JDialog();

        popUp.setSize(500, 500);
        popUp.setLayout(new FlowLayout());
        popUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(tabelaLivros_abaAlterar);

        botaoAttLivros_abaAlterar.setText("Adicionar");

        tabelaLivros_abaAlterar.setSize(350, 350);

        // panel.add(tabela_abaAutor);
        // panel.setSize(480, 380);
        popUp.add(scroll);
        // popUp.add(tabela_abaAutor);
        popUp.add(botaoAttLivros_abaAlterar);
        popUp.setTitle("Escolha um livro para atualizar!");

        // table.setVisible(true);

        popUp.setVisible(true);

        // table.add(tabela_abaAutor);
        // table.add(botao_autor);
        // table.add(jScrollPane1);
    }

    @Override
    public boolean getLivrosAbaAlterar(){ // RADIOBUTTON DO LIVROS SE ESTÁ SELECIONADO
        return radioButton_LivrosAbaInserir1.isSelected();
    }
    
    @Override
    public boolean getEditorasAbaAlterar(){ // RADIOBUTTON DAS EDITORAS SE ESTÁ SELECIONADO
        return radioButton_EditorasAbaInserir1.isSelected();
    }
    
    @Override
    public boolean getAutorAbaAlterar(){ // RADIOBUTTON DOS AUTORES SE ESTÁ SELECIONADO
        return radioButton_AutorAbaInserir1.isSelected();
    }

    @Override
    public void desabilitaTelaAlterar(){ // PARA DESABILITAR O USO CASO NÃO ESTEJA SELECIONADO
        this.TxtFieldNovoNomeEditoraAlterar.setEnabled(false);
        this.TxtFieldNovaUrlAlterar.setEnabled(false);

        this.TxtFieldNovoTituloAlterar.setEnabled(false);
        this.TxtFieldNovoPrecoAlterar.setEnabled(false);

        this.TxtFieldNovoNomeAlterar.setEnabled(false);
        this.TxtFieldNovoSobrenomeAlterar.setEnabled(false);;

        this.BtnEditorasAlterar.setEnabled(false);
        this.botaoAutor_abaAlterar.setEnabled(false);
        this.BtnLivrosAlterar.setEnabled(false);
    }

    @Override
    public void habilitaAutorTelaAlterar(){ // HABILITAR CASO ESTEJA SELECIONADO AUTOR
        this.TxtFieldNovoSobrenomeAlterar.setEnabled(true);
        this.TxtFieldNovoNomeAlterar.setEnabled(true);

        this.botaoAutor_abaAlterar.setEnabled(true);
    }

    @Override
    public void habilitaEditoriaTelaAlterar(){ // HABILITAR CASO ESTEJA SELECIONADO EDITORAS
        this.TxtFieldNovaUrlAlterar.setEnabled(true);
        
        this.BtnEditorasAlterar.setEnabled(true);
        this.TxtFieldNovoNomeEditoraAlterar.setEnabled(true);
    }

    @Override
    public void habilitaLivroTelaAlterar(){ // HABILITAR CASO ESTEJA SELECIONADO LIVROS
        this.TxtFieldNovoTituloAlterar.setEnabled(true);
        this.TxtFieldNovoPrecoAlterar.setEnabled(true);

        this.BtnLivrosAlterar.setEnabled(true);
    }

    @Override
    public void camposAlterarAutor(ActionListener al){
        this.radioButton_AutorAbaInserir1.addActionListener(al);
    }

    @Override
    public void camposAlterarEditoras(ActionListener al){ //
        this.radioButton_EditorasAbaInserir1.addActionListener(al);
    }

    @Override
    public void camposAlterarLivros(ActionListener al){
        this.radioButton_LivrosAbaInserir1.addActionListener(al);
    }

    @Override
    public void limpaTabelaAlterar(){ // LIMPAR A TABELA ALTERAR
        modelo3.setRowCount(0);
        modelo4.setRowCount(0);
        modelo5.setRowCount(0);
    }

    @Override
    public String pesquisaAutorAlterar(){
        int value;
        value = this.tabelaAutor_abaAlterar.getSelectedRow();

        String texto = this.tabelaAutor_abaAlterar.getValueAt(value, 1).toString() + " " + this.tabelaAutor_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

    @Override
    public void attTextoAutorAlterar(String texto){
        String[] ListaAutor;
        ListaAutor = texto.split(" ");

        if (ListaAutor.length == 3){
            TxtFieldSobrenomeAlterar.setText(ListaAutor[0]); 
            TxtFieldNomeAlterar.setText(ListaAutor[1] + " " + ListaAutor[2]);
        } else{ 
            TxtFieldSobrenomeAlterar.setText(ListaAutor[0]); 
            TxtFieldNomeAlterar.setText(ListaAutor[1]);
            
        } 
    }

    @Override
    public void attAutorAlterar(ActionListener al){
        this.botaoAttAutor_abaAlterar.addActionListener(al);
    } 

    @Override
    public String pesquisaLivroAlterar(){
        int value;
        value = this.tabelaLivros_abaAlterar.getSelectedRow();

        String texto = this.tabelaLivros_abaAlterar.getValueAt(value, 1).toString() + "/" + this.tabelaLivros_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

    @Override
    public void attLivroAlterar(ActionListener al){
        this.botaoAttLivros_abaAlterar.addActionListener(al);
    } 

    @Override
    public void attTextoLivroAlterar(String texto){
        String[] ListaLivro;
        ListaLivro = texto.split("/");

        TxtFieldAntigoTituloAlterar.setText(ListaLivro[0]); 
        TxtFieldPrecoAntigoAlterar.setText(ListaLivro[1]);   
    }

    @Override
    public String pesquisaEditoraAlterar(){ // TABELA DE PESQUISA EDITORAS
        int value;
        value = this.tabelaEditoras_abaAlterar.getSelectedRow();

        String texto = this.tabelaEditoras_abaAlterar.getValueAt(value, 1).toString() + "/" + this.tabelaEditoras_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

    @Override
    public void attEditoraAlterar(ActionListener al){ // BOTÃO EDITORAS
        this.botaoAttEditoras_abaAlterar.addActionListener(al);
    } 

    @Override
    public void attTextoEditoraAlterar(String texto){
        String[] ListaEditora;
        ListaEditora = texto.split("/");

        TxtFieldAntigoNomeEditoraAlterar.setText(ListaEditora[0]); 
        TxtFieldAntigaUrlAlterar.setText(ListaEditora[1]);        
    }

    @Override
    public String getAntigoNomeAutorAlterar(){ // TXTFIELD DO ANTIGO NOME AUTOR
        return this.TxtFieldNomeAlterar.getText();
    }

    @Override
    public String getAntigoSobrenomeAutorAlterar(){ // TXTFIELD DO ANTIGO SOBRENOME AUTOR
        return this.TxtFieldSobrenomeAlterar.getText();
    }

    @Override
    public String getAntigoTituloLivroAlterar(){ // TXTFIELD DO ANTIGO TITULO DO LIVRO
        return this.TxtFieldAntigoTituloAlterar.getText();
    }

    @Override
    public String getAntigoPrecoLivroAlterar(){ // TXTFIELD DO ANTIGO PREÇO DO LIVRO
        return this.TxtFieldPrecoAntigoAlterar.getText();
    }

    @Override
    public String getAntigoNomeEditoraAlterar(){ // TXTFIELD DO ANTIGONOME DA EDITORA
        return this.TxtFieldAntigoNomeEditoraAlterar.getText();
    }

    @Override
    public String getAntigaUrlAlterar(){ // TXTFIELD DA ANTIGA URL
        return this.TxtFieldAntigaUrlAlterar.getText();
    }

    @Override
    public String getNovoNomeAutorAlterar(){ // TXTFIELD DO NOVO NOME AUTOR
        return this.TxtFieldNovoNomeAlterar.getText();
    }

    @Override
    public String getNovoSobrenomeAutorAlterar(){ // TXTFIELD DO NOVO SOBRENOME AUTOR
        return this.TxtFieldNovoSobrenomeAlterar.getText();
    }

    @Override
    public String getNovoTituloLivroAlterar(){ // TEXTFIELD DO NOVO TITULO LIVRO
        return this.TxtFieldNovoTituloAlterar.getText();
    }

    @Override
    public String getNovoPrecoLivroAlterar(){ //TXTFIELD DO NOVO PREÇO LIVRO
        return this.TxtFieldNovoPrecoAlterar.getText();
    }

    @Override
    public String getNovoNomeEditoraAlterar(){ // TXTFIELD DO NOVO NOME EDITORA
        return this.TxtFieldNovoNomeEditoraAlterar.getText();
    }

    @Override
    public String getNovaUrlEditoraAlterar(){ // TEXTFIELD DA NOVA URL
        return this.TxtFieldNovaUrlAlterar.getText();
    }

    @Override
    public void realizaAlteracao(ActionListener al){ // BOTÃO DE ALTERAR
        this.BtnAcaoAlterar.addActionListener(al);
    }

    //***************************
    //* MÉTODOS JANELA PESQUISA *
    //***************************

    @Override
    public void limpaTabelaInserir(){ // LIMPA A JTABLE DA TELA INSERIR
        modelo2.setRowCount(0);
    }

    @Override
    public void realizarPesquisa(ActionListener al){ // BOTÃO DE PESQUISA
        this.BtnPesquisa.addActionListener(al);
    }

    @Override
    public void informacoes(ActionListener al){ // BOTÃO DE AJUDA
        this.BtnAjudaPesquisa.addActionListener(al);
    } 
    
    @Override
    public Boolean getOpcaoLivro(){ // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX LIVRO
        return this.CheckBoxLivrosPesquisa.isSelected();
    }

    @Override
    public Boolean getOpcaoAutor(){ // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX AUTOR
        return this.CheckBoxAutoresPesquisa.isSelected();
    }

    @Override
    public Boolean getOpcaoEditora(){ // RETORNA SE O USUÁRIO CLICOU NA CHECKBOX EDITORA
        return this.CheckBoxEditorasPesquisa.isSelected();
    }

    @Override
    public String getTexto(){ // RETORNA O TEXTO DO CAMPO DE PESQUISA
        return this.TxtFieldPesquisa.getText();
    }

    @Override
    public void limpaTabelaPesquisa(){ // LIMPA A JTABLE DA TELA DE PESQUISA
        modelo.setRowCount(0);
    }

    // MÉTODOS QUE ATUALIZAM A JTABLE DA TELA DE PESQUISA

    @Override
    public void atualizaTabelaAutor(int contador, Autores autor){
        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaTabelaLivro(int contador, Livros livro){ 
        String[] infos = {(Integer.toString(contador)), "", "", livro.getTitle(), livro.getIsbn(), Float.toString(livro.getPrice())};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaTabelaEditora(int contador, Editoras editora){   
        String[] infos = {(Integer.toString(contador)), "", "", "", "", "", editora.getName(), editora.getUrl()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaTabelaRelGeral(int contador, RelTudo valor){
        String[] infos = {(Integer.toString(contador)), valor.getNomeAutor().getName(),valor.getSobrenome().getFname(), valor.getTitulo().getTitle(), valor.getIsbn().getIsbn(), Float.toString(valor.getPreco().getPrice()), valor.getNomeEditora().getName(), valor.getUrl().getUrl()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaRelLivroAutor(int contador, RelLivrosAutores dados){
        String[] infos = {(Integer.toString(contador)),  dados.getSobrenome().getName(), dados.getNome().getFname(), dados.getTitulo().getTitle(), dados.getIsbn().getIsbn(), Float.toString(dados.getPreco().getPrice())};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    @Override
    public void atualizaRelLivroEditora(int contador, RelLivrosEditoras dados){
        String[] infos = {(Integer.toString(contador)), "", "", dados.getTitulo().getTitle(), dados.getIsbn().getIsbn(), Float.toString(dados.getPreco().getPrice()), dados.getNome().getName(), dados.getUrl().getUrl()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();

    }
    
    // FIM DOS MÉTODOS QUE ATUALIZAM A JTABLE DA TELA PESQUISA

    @Override
    public void mensagemAjudaPesquisa(){ // MENSAGEM POP-UP DO BOTÃO AJUDA
        String[] infos = {"Nas checkboxs escolha os campos que deseja pesquisar.", "Autores: Pesquisas feitas no sobrenome", "Livros: Pesquisas feitas pelo título.", "Editoras: Pesquisas feitas pelo nome."};
        JOptionPane.showMessageDialog(null, infos, "Como realizar as pesquisas:", JOptionPane.INFORMATION_MESSAGE);
    }

    private ButtonGroup g1;
    private JLabel Filtrodepesquisa_abaPesquisa;
    private JPanel abaInserir;
    private JPanel abaPesquisa;
    private JButton BtnPesquisa;    
    private JButton BtnAjudaPesquisa;
    private JLabel TxtFieldSobrenomeAlterar;
    private JTextField TxtFieldPesquisa;
    private JCheckBox CheckBoxAutoresPesquisa;
    private JCheckBox CheckBoxEditorasPesquisa;
    private JCheckBox CheckBoxLivrosPesquisa;
    private JScrollPane jScrollPane1;
    private JTabbedPane janelacomabas;
    private JTable tabela_abaPesquisa;
    private JLabel tituloPesquisa;
    private JLabel titulo_abaInserir;

    // VARIAVEIS ABA INSERIR

    private JButton botaoinserir_abaInserir1;
    private JButton botaoAutor_abainserir;
    private JButton botaoAjuda_abaInserir;

    private JDialog popUp;

    private JTextField caixadetexto_NomeDaEditora_abaInserir;
    private JTextField caixadetexto_URL_abaInserir;

    private JTextField caixadetexto_abaInserirEditora;
    private JTextField caixadetexto_abaInserirISBN;
    private JTextField caixadetexto_abaInserirNome1;
    private JTextField caixadetexto_abaInserirPreco;
    private JTextField caixadetexto_abaInserirSobreNome;
    private JTextField caixadetexto_abaInserirTitulo;

    private JLabel labelAutoresEscolhidos_abaInserir;
    private JLabel labelAutores_abainserir;
    private JLabel labelISBN_abaInserir;
    private JLabel labelNomeDaEditora_abaInserir;
    private JLabel labelNomeDaEditora_radiolivros_abaInserir;
    private JLabel labelNome_abaInserir;
    private JLabel labelSobreNome_abaInserir;
    private JLabel labelTitulo_abaInserir;
    private JLabel labelURL_abaInserir;
    private JLabel labelpreco_abaInserir;
    private JRadioButton radioButton_AutorAbaInserir;
    private JRadioButton radioButton_EditorasAbaInserir;
    private JRadioButton radioButton_LivrosAbaInserir;

    private JTable tabela_abaAutor ;
    private JButton botao_autor;

    // VARIÁVEIS DA ABA ALTERAR

    private ButtonGroup grupo_abaALterar;

    private JLabel LblPrimeiroNomeAlterar2;
    private JPanel abaAlterar;

    private JButton BtnAjudaAlterar;
    private JButton BtnAcaoAlterar;
    private JButton botaoAutor_abaAlterar;
    private JButton BtnEditorasAlterar;
    private JButton BtnLivrosAlterar;
    
    private JTextField TxtFieldNovaUrlAlterar;
    private JTextField TxtFieldNovoNomeEditoraAlterar;

    private JTextField TxtFieldNovoTituloAlterar;
    private JTextField TxtFieldNovoPrecoAlterar;

    private JLabel TxtFieldAntigaUrlAlterar;
    
    private JLabel LblNovosDadosAutoresAlterar;
    private JLabel TxtFieldAntigoNomeEditoraAlterar;
    private JLabel LblNovoNomeEditoraAlterar;
    private JLabel LblAntigoNomeEditoraAlterar;
    private JLabel LblAntigoPrecoAlterar;
    private JLabel TxtFieldPrecoAntigoAlterar;
    private JLabel TxtFieldNomeAlterar;
    private JLabel LblNovoTituloAlterar;
    private JLabel LblNovaUrlAlterar;
    private JLabel LblAntigaUrlAlterar;
    private JLabel LblTituloNovoAlterar;
    private JLabel TxtFieldAntigoTituloAlterar;
    private JLabel LblDadosAntigoAutoresAlterar;
    private JLabel LblNovoPrecoAlterar;
    private JLabel LblPrimeiroNomeAlterar;
    private JLabel titulo_abaAlterar;

    private JLabel lblNovosDadosLivrosAlterar;
    private JLabel LblDadosAntigosEditorasAlterar;
    private JLabel LblNovoDadosEditorasAlterar;
    private JLabel LblDadosAntigosLivrosAlterar;

    private JRadioButton radioButton_AutorAbaInserir1;
    private JRadioButton radioButton_EditorasAbaInserir1;
    private JRadioButton radioButton_LivrosAbaInserir1;

    private JTextField TxtFieldNovoNomeAlterar;
    private JTextField TxtFieldNovoSobrenomeAlterar;

    private JTable tabelaAutor_abaAlterar;
    private JButton botaoAttAutor_abaAlterar;

    private JTable tabelaEditoras_abaAlterar;
    private JButton botaoAttEditoras_abaAlterar;

    private JButton botaoAttLivros_abaAlterar;
    private JTable tabelaLivros_abaAlterar;

    // VARIÁVEIS DA ABA DELETAR

    private ButtonGroup grupo_abaDeletar;
    private JPanel abaDeletar;

    private JRadioButton radioButton_AutorDeletar;
    private JRadioButton radioButton_EditorasAbaDeletar;
    private JRadioButton radioButton_LivrosDeletar;

    private JTextField TxtFieldISBNDeletar;
    private JTextField TxtFieldNomeDaEditoraDeletar;
    private JTextField TxtFieldPrimeiroNomeAutorDeletar;
    private JTextField TxtFieldSobrenomeAutorDeletar;

    private JButton BtnAjudaDeletar;
    private JButton BtnDeletarDeletar;

    private JLabel LblConclusaoDeTarefaDeletar;
    private JLabel LblISBNDeletar;
    private JLabel LblPrimeiroNomeDeletar;
    private JLabel LblNomeDaEditoraDeletar;
    private JLabel LblSobrenomeDeletar;
    private JLabel LblTituloDeletar;
}
