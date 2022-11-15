/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.AlgorithmMethod;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entidades.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Admin-PC
 */
public class ViewConcreta extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Boolean pesquisaBooks;
    Boolean pesquisaAuthors;
    Boolean pesquisaPublishers;
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


    @SuppressWarnings("unchecked")
    private void initComponents() {

        

        g1 = new javax.swing.ButtonGroup();
        janelacomabas = new javax.swing.JTabbedPane();
        abaPesquisa = new javax.swing.JPanel();
        tituloPesquisa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_abaPesquisa = new javax.swing.JTable();
        caixadetexto_abaPesquisa = new javax.swing.JTextField();
        botaopesquisar_abaPesquisa = new javax.swing.JButton();
        checkboxAutores_abaPesquisa = new javax.swing.JCheckBox();
        Filtrodepesquisa_abaPesquisa = new javax.swing.JLabel();
        checkboxLivros_abaPesquisa = new javax.swing.JCheckBox();
        checkboxEditoras_abaPesquisa = new javax.swing.JCheckBox();
        botaoAjuda_abaPesquisa = new javax.swing.JButton();

        abaDeletar = new javax.swing.JPanel();
        titulo_abaDeletar = new javax.swing.JLabel();
        caixadetexto_abaDeletar = new javax.swing.JTextField();
        botaopesquisar_abaDeletar = new javax.swing.JButton();
        Filtrodepesquisa_abaDeletar = new javax.swing.JLabel();
        checkboxLivros_abaDeletar = new javax.swing.JCheckBox();
        checkboxAutores_abaDeletar = new javax.swing.JCheckBox();
        checkboxEditoras_abaDeletar = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_abaDeletar = new javax.swing.JTable();
        botaoDeletar_abaDeletar = new javax.swing.JButton();

        abaInserir = new javax.swing.JPanel();
        titulo_abaInserir = new javax.swing.JLabel();
        botaoAjuda_abaInserir = new javax.swing.JButton();
        radioButton_AutorAbaInserir = new javax.swing.JRadioButton();
        radioButton_LivrosAbaInserir = new javax.swing.JRadioButton();
        radioButton_EditorasAbaInserir = new javax.swing.JRadioButton();
        caixadetexto_abaInserirSobreNome = new javax.swing.JTextField();
        caixadetexto_abaInserirNome1 = new javax.swing.JTextField();
        labelNome_abaInserir = new javax.swing.JLabel();
        labelSobreNome_abaInserir = new javax.swing.JLabel();
        caixadetexto_abaInserirTitulo = new javax.swing.JTextField();
        caixadetexto_abaInserirISBN = new javax.swing.JTextField();
        caixadetexto_abaInserirEditora = new javax.swing.JTextField();
        caixadetexto_abaInserirPreco = new javax.swing.JTextField();
        labelISBN_abaInserir = new javax.swing.JLabel();
        labelTitulo_abaInserir = new javax.swing.JLabel();
        labelpreco_abaInserir = new javax.swing.JLabel();
        labelNomeDaEditora_radiolivros_abaInserir = new javax.swing.JLabel();
        botaoAutor_abainserir = new javax.swing.JButton();
        labelAutores_abainserir = new javax.swing.JLabel();
        labelAutoresEscolhidos_abaInserir = new javax.swing.JLabel();
        labelNomeDaEditora_abaInserir = new javax.swing.JLabel();
        caixadetexto_NomeDaEditora_abaInserir = new javax.swing.JTextField();
        labelURL_abaInserir = new javax.swing.JLabel();
        caixadetexto_URL_abaInserir = new javax.swing.JTextField();
        labelQueMostraConfimacao_abaInserir = new javax.swing.JLabel();
        botaoinserir_abaInserir1 = new javax.swing.JButton();
        
        tabela_abaAutor = new javax.swing.JTable();
        botao_autor = new JButton();

        // OBJETOS DA ABA ALTERAR

        LblDadosAntigosEditorasAlterar = new javax.swing.JLabel();
        LblNovoDadosEditorasAlterar = new javax.swing.JLabel();

        grupo_abaALterar = new javax.swing.ButtonGroup();

        abaAlterar = new javax.swing.JPanel();
        titulo_abaAlterar = new javax.swing.JLabel();
        botaoAjuda_abaAlterar = new javax.swing.JButton();
        BtnAcaoAlterar = new javax.swing.JButton();

        botaoAutor_abaAlterar = new javax.swing.JButton();
        LblPrimeiroNomeAlterar = new javax.swing.JLabel();
        TxtFieldSobrenomeAlterar = new JLabel();

        TxtFieldNomeAlterar = new javax.swing.JLabel();
        LblNovosDadosAutoresAlterar = new javax.swing.JLabel();
        LblDadosAntigoAutoresAlterar = new javax.swing.JLabel();
        LblPrimeiroNomeAlterar2 = new javax.swing.JLabel();

        BtnLivrosAlterar = new javax.swing.JButton();
        LblAntigoPrecoAlterar = new javax.swing.JLabel();
        TxtFieldAntigoTituloAlterar = new javax.swing.JLabel();

        TxtFieldPrecoAntigoAlterar = new javax.swing.JLabel();
        LblTituloNovoAlterar = new javax.swing.JLabel();

        TxtFieldNovoTituloAlterar = new javax.swing.JTextField();
        TxtFieldNovoPrecoAlterar = new javax.swing.JTextField();
        LblNovoPrecoAlterar = new javax.swing.JLabel();
        LblNovoTituloAlterar = new javax.swing.JLabel();
        LblAntigaUrlAlterar = new javax.swing.JLabel();
        BtnEditorasAlterar = new javax.swing.JButton();
        LblAntigoNomeEditoraAlterar = new javax.swing.JLabel();
        TxtFieldAntigaUrlAlterar = new javax.swing.JLabel();
        TxtFieldAntigoNomeEditoraAlterar = new javax.swing.JLabel();

        LblNovoNomeEditoraAlterar = new javax.swing.JLabel();
        LblNovaUrlAlterar = new javax.swing.JLabel();
        TxtFieldNovaUrlAlterar = new javax.swing.JTextField();
        TxtFieldNovoNomeEditoraAlterar = new javax.swing.JTextField();

        radioButton_AutorAbaInserir1 = new javax.swing.JRadioButton();
        radioButton_EditorasAbaInserir1 = new javax.swing.JRadioButton();
        radioButton_LivrosAbaInserir1 = new javax.swing.JRadioButton();
        TxtFieldNovoNomeAlterar = new javax.swing.JTextField();
        TxtFieldNovoSobrenomeAlterar = new javax.swing.JTextField();

        LblConfirmarcaoAlterar = new javax.swing.JLabel();
        LblDadosAntigosLivrosAlterar = new javax.swing.JLabel();
        lblNovosDadosLivrosAlterar = new javax.swing.JLabel();

        tabelaAutor_abaAlterar = new JTable();
        botaoAttAutor_abaAlterar = new JButton();

        tabelaEditoras_abaAlterar = new JTable();
        botaoAttEditoras_abaAlterar = new JButton();

        tabelaLivros_abaAlterar = new JTable();
        botaoAttLivros_abaAlterar = new JButton();


        // OBJETOS DA ABA DELETAR

        grupo_abaDeletar = new javax.swing.ButtonGroup();
        abaDeletar = new javax.swing.JPanel();
        titulo_abaDeletar = new javax.swing.JLabel();
        botaoAjuda_abaDeletar = new javax.swing.JButton();
        radioButton_EditorasAbaDeletar = new javax.swing.JRadioButton();
        labelPrimeiroNome_abaDeletar = new javax.swing.JLabel();
        labelISBN_abaDeletar = new javax.swing.JLabel();
        labelNomedaEditora_abaDeletar = new javax.swing.JLabel();
        labelSobrenome_abaDeletar = new javax.swing.JLabel();
        botaoDeletar_abaDeletar1 = new javax.swing.JButton();
        caixadetextoPrimeiroNomeAutor_abaDeletar = new javax.swing.JTextField();

        caixadetextoISBN_abaDeletar = new javax.swing.JTextField();
        caixadetextoNomeDaEditora_abaDeletar = new javax.swing.JTextField();
        labelConclusaodeTarefa_abaDeletar = new javax.swing.JLabel();

        radioButton_AutorDeletar = new javax.swing.JRadioButton();
        radioButton_LivrosDeletar = new javax.swing.JRadioButton();
    
        caixadetextoSobrenomeAutor_abaDeletar = new javax.swing.JTextField();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        janelacomabas.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

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

        caixadetexto_abaPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        caixadetexto_abaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixadetexto_abaPesquisaActionPerformed(evt);
            }
        });

        botaopesquisar_abaPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        botaopesquisar_abaPesquisa.setText("Pesquisar");

        checkboxAutores_abaPesquisa.setText("Autores");
        checkboxAutores_abaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxAutores_abaPesquisaActionPerformed(evt);
            }
        });

        Filtrodepesquisa_abaPesquisa.setText("Pesquisar em:");

        checkboxLivros_abaPesquisa.setText("Livros");
        checkboxLivros_abaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxLivros_abaPesquisaActionPerformed(evt);
            }
        });

        checkboxEditoras_abaPesquisa.setText("Editoras");
        checkboxEditoras_abaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxEditoras_abaPesquisaActionPerformed(evt);
            }
        });

        botaoAjuda_abaPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        botaoAjuda_abaPesquisa.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        botaoAjuda_abaPesquisa.setText("Ajuda?");
        botaoAjuda_abaPesquisa.setToolTipText("");

        javax.swing.GroupLayout abaPesquisaLayout = new javax.swing.GroupLayout(abaPesquisa);
        abaPesquisa.setLayout(abaPesquisaLayout);
        abaPesquisaLayout.setHorizontalGroup(
            abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaPesquisaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Filtrodepesquisa_abaPesquisa)
                                .addGap(122, 122, 122)
                                .addComponent(checkboxLivros_abaPesquisa)
                                .addGap(122, 122, 122)
                                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkboxAutores_abaPesquisa)
                                .addGap(122, 122, 122)
                                .addComponent(checkboxEditoras_abaPesquisa))
                            .addComponent(caixadetexto_abaPesquisa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaopesquisar_abaPesquisa))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tituloPesquisa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaPesquisaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoAjuda_abaPesquisa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaPesquisaLayout.setVerticalGroup(
            abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPesquisa)
                .addGap(4, 4, 4)
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixadetexto_abaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaopesquisar_abaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxAutores_abaPesquisa)
                    .addComponent(Filtrodepesquisa_abaPesquisa)
                    .addComponent(checkboxLivros_abaPesquisa)
                    .addComponent(checkboxEditoras_abaPesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAjuda_abaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        janelacomabas.addTab("Pesquisa", abaPesquisa);

       
        janelacomabas.addTab("Inserir", abaInserir);

        abaDeletar.setBorder(new javax.swing.border.MatteBorder(null));

        titulo_abaDeletar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titulo_abaDeletar.setText("Deletar dados existentes");

        botaoAjuda_abaDeletar.setBackground(new java.awt.Color(204, 204, 204));
        botaoAjuda_abaDeletar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        botaoAjuda_abaDeletar.setText("Ajuda?");
        botaoAjuda_abaDeletar.setToolTipText("");
        botaoAjuda_abaDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAjuda_abaDeletarActionPerformed(evt);
            }
        });

        grupo_abaDeletar.add(radioButton_AutorDeletar);
        radioButton_AutorDeletar.setText("Autor");
        radioButton_AutorDeletar.setToolTipText("");

        grupo_abaDeletar.add(radioButton_LivrosDeletar);
        radioButton_LivrosDeletar.setText("Livros");

        grupo_abaDeletar.add(radioButton_EditorasAbaDeletar);
        radioButton_EditorasAbaDeletar.setText("Editoras");

        labelPrimeiroNome_abaDeletar.setText("Primeiro Nome:");

        labelISBN_abaDeletar.setText("ISBN:");

        labelNomedaEditora_abaDeletar.setText("Nome da Editora:");

        labelSobrenome_abaDeletar.setText("Sobrenome:");

        botaoDeletar_abaDeletar1.setBackground(new java.awt.Color(255, 51, 51));
        botaoDeletar_abaDeletar1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        botaoDeletar_abaDeletar1.setText("Deletar");
        botaoDeletar_abaDeletar1.setToolTipText("");

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
       
        labelConclusaodeTarefa_abaDeletar.setText("");

        javax.swing.GroupLayout abaDeletarLayout = new javax.swing.GroupLayout(abaDeletar);
        abaDeletar.setLayout(abaDeletarLayout);
        abaDeletarLayout.setHorizontalGroup(
            abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDeletarLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(labelISBN_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixadetextoISBN_abaDeletar)
                        .addGap(21, 21, 21))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(radioButton_LivrosDeletar)
                        .addGap(545, 545, 545)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addComponent(botaoAjuda_abaDeletar)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(labelConclusaodeTarefa_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoDeletar_abaDeletar1))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addComponent(radioButton_AutorDeletar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDeletarLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPrimeiroNome_abaDeletar)
                            .addComponent(labelSobrenome_abaDeletar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caixadetextoPrimeiroNomeAutor_abaDeletar)
                            .addComponent(caixadetextoSobrenomeAutor_abaDeletar)))
                    .addGroup(abaDeletarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton_EditorasAbaDeletar)
                            .addGroup(abaDeletarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelNomedaEditora_abaDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caixadetextoNomeDaEditora_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo_abaDeletar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaDeletarLayout.setVerticalGroup(
            abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDeletarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_abaDeletar)
                .addGap(16, 16, 16)
                .addComponent(radioButton_AutorDeletar)
                .addGap(18, 18, 18)
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrimeiroNome_abaDeletar)
                    .addComponent(caixadetextoPrimeiroNomeAutor_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSobrenome_abaDeletar)
                    .addComponent(caixadetextoSobrenomeAutor_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(radioButton_LivrosDeletar)
                .addGap(1, 1, 1)
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelISBN_abaDeletar)
                    .addComponent(caixadetextoISBN_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(radioButton_EditorasAbaDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomedaEditora_abaDeletar)
                    .addComponent(caixadetextoNomeDaEditora_abaDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(abaDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAjuda_abaDeletar)
                    .addComponent(botaoDeletar_abaDeletar1)
                    .addComponent(labelConclusaodeTarefa_abaDeletar))
                .addContainerGap())
        );

        janelacomabas.addTab("Deletar", abaDeletar);

        abaAlterar.setBorder(new javax.swing.border.MatteBorder(null));

        titulo_abaAlterar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titulo_abaAlterar.setText("Alterar dados existentes");

        botaoAjuda_abaAlterar.setBackground(new java.awt.Color(204, 204, 204));
        botaoAjuda_abaAlterar.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        botaoAjuda_abaAlterar.setText("Ajuda?");
        botaoAjuda_abaAlterar.setToolTipText("");
        botaoAjuda_abaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAjuda_abaAlterarActionPerformed(evt);
            }
        });

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
        botaoAutor_abaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutor_abaAlterarActionPerformed(evt);
            }
        });

        LblPrimeiroNomeAlterar.setText("Primeiro nome:");

        TxtFieldSobrenomeAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldSobrenomeAlterar.setText("(sobrenome do Autor)");
        TxtFieldSobrenomeAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtFieldNomeAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldNomeAlterar.setText("(primeiro nome do Autor)");
        TxtFieldNomeAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblNovosDadosAutoresAlterar.setText("Novos Dados");

        LblDadosAntigoAutoresAlterar.setText("Dados Antigos");

        LblPrimeiroNomeAlterar2.setText("Primeiro nome:");

        TxtFieldNovoNomeAlterar.setText("(primeiro nome)");

        TxtFieldNovoSobrenomeAlterar.setText("Sobrenome");

        BtnLivrosAlterar.setText("Escolher Livro");

        LblAntigoPrecoAlterar.setText("Preço:");

        TxtFieldAntigoTituloAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigoTituloAlterar.setText("(titulo do livro)");
        TxtFieldAntigoTituloAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblDadosAntigosLivrosAlterar.setText("Dados Antigos");

        TxtFieldPrecoAntigoAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldPrecoAntigoAlterar.setText("(preço)");
        TxtFieldPrecoAntigoAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblTituloNovoAlterar.setText("Titulo:");

        lblNovosDadosLivrosAlterar.setText("Novos Dados");

        TxtFieldNovoTituloAlterar.setText("novo titulo");

        TxtFieldNovoPrecoAlterar.setText("novo preço");

        LblNovoPrecoAlterar.setText("Preço:");

        LblNovoTituloAlterar.setText("Titulo:");

        LblAntigaUrlAlterar.setText("URL:");

        BtnEditorasAlterar.setText("Escolher Editoras");

        LblAntigoNomeEditoraAlterar.setText("Nome da Editora:");

        TxtFieldAntigaUrlAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigaUrlAlterar.setText("URL");
        TxtFieldAntigaUrlAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtFieldAntigoNomeEditoraAlterar.setBackground(new java.awt.Color(204, 204, 255));
        TxtFieldAntigoNomeEditoraAlterar.setText("(nome Da Editora)");
        TxtFieldAntigoNomeEditoraAlterar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblDadosAntigosEditorasAlterar.setText("Dados Antigos");

        LblNovoDadosEditorasAlterar.setText("Novos Dados");

        LblNovoNomeEditoraAlterar.setText("Nome da Editora:");

        LblNovaUrlAlterar.setText("URL:");

        TxtFieldNovaUrlAlterar.setText("jTextField5");

        TxtFieldNovoNomeEditoraAlterar.setText("jTextField6");

        LblConfirmarcaoAlterar.setText("(label que vai ser pra mostrar a confirmação de inserção, apagar depois tbm)");

        javax.swing.GroupLayout abaAlterarLayout = new javax.swing.GroupLayout(abaAlterar);
        abaAlterar.setLayout(abaAlterarLayout);
        abaAlterarLayout.setHorizontalGroup(
            abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                        .addComponent(botaoAutor_abaAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblPrimeiroNomeAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNomeAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblPrimeiroNomeAlterar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoNomeAlterar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFieldSobrenomeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFieldNovoSobrenomeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addComponent(radioButton_LivrosAbaInserir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblDadosAntigosLivrosAlterar)
                        .addGap(68, 68, 68)
                        .addComponent(lblNovosDadosLivrosAlterar)
                        .addGap(145, 145, 145))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(radioButton_AutorAbaInserir1)
                                .addGap(189, 189, 189)
                                .addComponent(LblDadosAntigoAutoresAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(LblNovosDadosAutoresAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(BtnLivrosAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblAntigoPrecoAlterar)
                                    .addComponent(LblNovoTituloAlterar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtFieldPrecoAntigoAlterar)
                                    .addComponent(TxtFieldAntigoTituloAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(radioButton_EditorasAbaInserir1)
                                .addGap(182, 182, 182)
                                .addComponent(LblDadosAntigosEditorasAlterar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                                .addComponent(botaoAjuda_abaAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(LblConfirmarcaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAcaoAlterar))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(BtnEditorasAlterar)
                                .addGap(18, 18, 18)
                                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaAlterarLayout.createSequentialGroup()
                                        .addComponent(LblNovoNomeEditoraAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldNovoNomeEditoraAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblNovaUrlAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldNovaUrlAlterar))
                                    .addGroup(abaAlterarLayout.createSequentialGroup()
                                        .addComponent(LblAntigoNomeEditoraAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldAntigoNomeEditoraAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblAntigaUrlAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtFieldAntigaUrlAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(titulo_abaAlterar))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblTituloNovoAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoTituloAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaAlterarLayout.createSequentialGroup()
                                .addComponent(LblNovoPrecoAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFieldNovoPrecoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(LblNovoDadosEditorasAlterar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        abaAlterarLayout.setVerticalGroup(
            abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_abaAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblDadosAntigoAutoresAlterar)
                    .addComponent(radioButton_AutorAbaInserir1))
                .addGap(9, 9, 9)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAutor_abaAlterar)
                    .addComponent(LblPrimeiroNomeAlterar)
                    .addComponent(TxtFieldNomeAlterar)
                    .addComponent(TxtFieldSobrenomeAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNovosDadosAutoresAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPrimeiroNomeAlterar2)
                    .addComponent(TxtFieldNovoNomeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFieldNovoSobrenomeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_LivrosAbaInserir1)
                    .addComponent(LblDadosAntigosLivrosAlterar)
                    .addComponent(lblNovosDadosLivrosAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnLivrosAlterar)
                            .addComponent(TxtFieldAntigoTituloAlterar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFieldPrecoAntigoAlterar)
                            .addComponent(LblAntigoPrecoAlterar)))
                    .addComponent(LblNovoTituloAlterar)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblTituloNovoAlterar)
                            .addComponent(TxtFieldNovoTituloAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNovoPrecoAlterar)
                            .addComponent(TxtFieldNovoPrecoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_EditorasAbaInserir1)
                    .addComponent(LblDadosAntigosEditorasAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEditorasAlterar)
                    .addComponent(LblAntigoNomeEditoraAlterar)
                    .addComponent(TxtFieldAntigoNomeEditoraAlterar)
                    .addComponent(LblAntigaUrlAlterar)
                    .addComponent(TxtFieldAntigaUrlAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblNovoDadosEditorasAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNovoNomeEditoraAlterar)
                    .addComponent(LblNovaUrlAlterar)
                    .addComponent(TxtFieldNovaUrlAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFieldNovoNomeEditoraAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAlterarLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(abaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAcaoAlterar)
                            .addComponent(botaoAjuda_abaAlterar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaAlterarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblConfirmarcaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

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

        caixadetexto_abaInserirPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixadetexto_abaInserirPrecoActionPerformed(evt);
            }
        });

        labelISBN_abaInserir.setText("ISBN");

        labelTitulo_abaInserir.setText("Título do Livro: ");

        labelpreco_abaInserir.setText("Preço:");

        labelNomeDaEditora_radiolivros_abaInserir.setText("Nome da Editora:");
        labelNomeDaEditora_radiolivros_abaInserir.setToolTipText("");

        botaoAutor_abainserir.setText("Escolher Autor");
        botaoAutor_abainserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutor_abainserirActionPerformed(evt);
            }
        });

        labelAutores_abainserir.setText("Autores:");

        labelAutoresEscolhidos_abaInserir.setText("");
        labelAutoresEscolhidos_abaInserir.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                labelAutoresEscolhidos_abaInserirComponentAdded(evt);
            }
        });

        labelNomeDaEditora_abaInserir.setText("Nome da Editora:");

        labelURL_abaInserir.setText("URL:");

        labelQueMostraConfimacao_abaInserir.setText("(label que vai ser pra mostrar a confirmação de inserção, apagar depois tbm)");

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

        javax.swing.GroupLayout abaInserirLayout = new javax.swing.GroupLayout(abaInserir);
        abaInserir.setLayout(abaInserirLayout);
        abaInserirLayout.setHorizontalGroup(
            abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaInserirLayout.createSequentialGroup()
                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaInserirLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelAutoresEscolhidos_abaInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                        .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(abaInserirLayout.createSequentialGroup()
                                                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(botaoAutor_abainserir, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelAutores_abainserir))
                                                .addGap(18, 18, 18)
                                                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                                        .addComponent(labelNomeDaEditora_radiolivros_abaInserir)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(caixadetexto_abaInserirEditora))
                                                    .addGroup(abaInserirLayout.createSequentialGroup()
                                                        .addComponent(labelTitulo_abaInserir)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(caixadetexto_abaInserirTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(21, 21, 21)
                                                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelpreco_abaInserir)
                                                    .addComponent(labelISBN_abaInserir))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(caixadetexto_abaInserirISBN)
                                                    .addComponent(caixadetexto_abaInserirPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                                            .addGroup(abaInserirLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(labelNome_abaInserir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(caixadetexto_abaInserirNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelSobreNome_abaInserir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(caixadetexto_abaInserirSobreNome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(labelQueMostraConfimacao_abaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoinserir_abaInserir1))))
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelNomeDaEditora_abaInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixadetexto_NomeDaEditora_abaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelURL_abaInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixadetexto_URL_abaInserir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaInserirLayout.setVerticalGroup(
            abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaInserirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo_abaInserir)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(radioButton_AutorAbaInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome_abaInserir)
                    .addComponent(caixadetexto_abaInserirNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSobreNome_abaInserir)
                    .addComponent(caixadetexto_abaInserirSobreNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(radioButton_LivrosAbaInserir)
                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixadetexto_abaInserirTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caixadetexto_abaInserirISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelISBN_abaInserir)
                            .addComponent(labelTitulo_abaInserir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomeDaEditora_radiolivros_abaInserir)
                            .addComponent(caixadetexto_abaInserirPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelpreco_abaInserir)
                            .addComponent(caixadetexto_abaInserirEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(abaInserirLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botaoAutor_abainserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAutores_abainserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(labelAutoresEscolhidos_abaInserir)
                .addGap(29, 29, 29)
                .addComponent(radioButton_EditorasAbaInserir)
                .addGap(18, 18, 18)
                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeDaEditora_abaInserir)
                    .addComponent(caixadetexto_NomeDaEditora_abaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelURL_abaInserir)
                    .addComponent(caixadetexto_URL_abaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(abaInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQueMostraConfimacao_abaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoinserir_abaInserir1)
                    .addComponent(botaoAjuda_abaInserir))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        janelacomabas.addTab("Inserir", abaInserir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelacomabas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelacomabas)
                .addContainerGap())
        );

       

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // MÉTODOS GERADOS PELO NETBEANS
    private void caixadetexto_abaInserirPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixadetexto_abaInserirPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixadetexto_abaInserirPrecoActionPerformed

    private void botaoAutor_abainserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutor_abainserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAutor_abainserirActionPerformed

    private void labelAutoresEscolhidos_abaInserirComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_labelAutoresEscolhidos_abaInserirComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labelAutoresEscolhidos_abaInserirComponentAdded

    private void caixadetexto_abaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixadetexto_abaPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixadetexto_abaPesquisaActionPerformed

    private void checkboxAutores_abaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxAutores_abaPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxAutores_abaPesquisaActionPerformed

    private void checkboxLivros_abaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxLivros_abaPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxLivros_abaPesquisaActionPerformed

    private void checkboxEditoras_abaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxEditoras_abaPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxEditoras_abaPesquisaActionPerformed

    private void caixadetexto_abaInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixadetexto_abaInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixadetexto_abaInserirActionPerformed

    private void checkboxLivros_abainserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxLivros_abainserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxLivros_abainserirActionPerformed

    private void checkboxAutores_abaInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxAutores_abaInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxAutores_abaInserirActionPerformed

    private void checkboxEditoras_abaInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxEditoras_abaInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxEditoras_abaInserirActionPerformed

    private void botaoAjuda_abaDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAjuda_abaDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAjuda_abaDeletarActionPerformed


    private void botaoAjuda_abaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAjuda_abaAlterarActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_botaoAjuda_abaAlterarActionPerformed

    private void botaoAutor_abaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutor_abaAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAutor_abaAlterarActionPerformed


    // MÉTODOS DA JANELA DELETAR

    public void deletar(ActionListener al){
        this.botaoDeletar_abaDeletar1.addActionListener(al);
    }

    public boolean verificaEscolhaDeletarAutor(){
        return this.radioButton_AutorDeletar.isSelected();
    }

    public boolean verificaEscolhaDeletarEditora(){
        return this.radioButton_EditorasAbaDeletar.isSelected();
    }

     public boolean verificaEscolhaDeletarLivro(){
         return this.radioButton_LivrosDeletar.isSelected();
     }

    public String getTextoNomeAutor(){
        return this.caixadetextoPrimeiroNomeAutor_abaDeletar.getText();
    }

    public String getTextoSobrenomeAutor(){
        return this.caixadetextoSobrenomeAutor_abaDeletar.getText();
    }

    public String getTextoISBN() {
        return this.caixadetextoISBN_abaDeletar.getText();
    }

    public String getTextoEditora() {
        return this.caixadetextoNomeDaEditora_abaDeletar.getText();
    }

    public void atualizarMensagemConclusao(String mensagem) {
        this.labelConclusaodeTarefa_abaDeletar.setText(mensagem);
    }

    public void habilitarLivrosDeletar(){
        this.caixadetextoISBN_abaDeletar.setEnabled(true);
    }

    public void habilitarAutorDeletar(){
        this.caixadetextoPrimeiroNomeAutor_abaDeletar.setEnabled(true);
        this.caixadetextoSobrenomeAutor_abaDeletar.setEnabled(true);
    }

    public void habilitarEditorasDeletar(){
        this.caixadetextoNomeDaEditora_abaDeletar.setEnabled(true);
    }
    public void desabilitarTelaDeletar(){
        this.caixadetextoISBN_abaDeletar.setEnabled(false);

        
        this.caixadetextoSobrenomeAutor_abaDeletar.setEnabled(false);
        this.caixadetextoPrimeiroNomeAutor_abaDeletar.setEnabled(false);

        this.caixadetextoNomeDaEditora_abaDeletar.setEnabled(false);
    }

    public void habilitarTelasDeletar(ActionListener al) {
        this.radioButton_AutorDeletar.addActionListener(al);
        this.radioButton_LivrosDeletar.addActionListener(al);
        this.radioButton_EditorasAbaDeletar.addActionListener(al);
    }

    public void ajudaDeletar(ActionListener al) {
        this.botaoAjuda_abaDeletar.addActionListener(al);
    }

    public void mensagemAjudaDeletar(){
        String[] infos = {"Nas checkboxs escolha os campos que deseja deletar.", "Autor: Deletar a partir do Nome e Sobrenome", "Livros: Deleta a partir do ISBN do livro.", "Editoras: Deleta a partir do nome da Editora."};
        JOptionPane.showMessageDialog(null, infos, "Como deletar:", JOptionPane.INFORMATION_MESSAGE);
    }

    // MÉTODOS DA JANELA INSERIR


    public void camposInsLivros(ActionListener al){

        this.radioButton_LivrosAbaInserir.addActionListener(al);

    }

    public void camposInsEditoras(ActionListener al){

        this.radioButton_EditorasAbaInserir.addActionListener(al);

    }

    public void camposInsAutores(ActionListener al){

        this.radioButton_AutorAbaInserir.addActionListener(al);
 
    }

    public boolean verificaEscolhaInserirAutor(){
        return this.radioButton_AutorAbaInserir.isSelected();
    }
    public boolean verificaEscolhaInserirEditora(){
        return this.radioButton_EditorasAbaInserir.isSelected();
    }

    public boolean verificaEscolhaInserirLivro(){
        return this.radioButton_LivrosAbaInserir.isSelected();
    }

    public void habilitaEditoras(){
        this.caixadetexto_NomeDaEditora_abaInserir.setEnabled(true);
        this.caixadetexto_URL_abaInserir.setEnabled(true);
    }

    public void habilitarAutor(){
        this.caixadetexto_abaInserirSobreNome.setEnabled(true);
        this.caixadetexto_abaInserirNome1.setEnabled(true);

    }

    public void habilitaLivros(){
        this.caixadetexto_abaInserirTitulo.setEnabled(true);
        this.caixadetexto_abaInserirPreco.setEnabled(true);
        this.caixadetexto_abaInserirISBN.setEnabled(true);
        this.caixadetexto_abaInserirEditora.setEnabled(true);
        this.botaoAutor_abainserir.setEnabled(true);

    }
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

    //inicializando botao de inserir
    public void Inserir(ActionListener al){
        this.botaoinserir_abaInserir1.addActionListener(al);
    }

    // Gets para Autor
    public String getNome(){
        return this.caixadetexto_abaInserirNome1.getText();
    }

    public String getSobrenome(){
       return this.caixadetexto_abaInserirSobreNome.getText();
    }

    //Gets para editoras

    public String getNomeEditora(){
        return this.caixadetexto_NomeDaEditora_abaInserir.getText();
    }

    public String getUrl(){
        return this.caixadetexto_URL_abaInserir.getText();
    }

    // Gets para os livros

    public String getInserirTitulo(){
        return this.caixadetexto_abaInserirTitulo.getText();
    }

    public String getInserirPreco(){
        if (this.caixadetexto_abaInserirPreco.getText().equals("")){
            return "0";
        }else{
            return this.caixadetexto_abaInserirPreco.getText();
        }
    }

    public String getISBN(){
        return this.caixadetexto_abaInserirISBN.getText();
    }

    public String getInserirEditoras(){
        return this.caixadetexto_abaInserirEditora.getText();
    }

    public String getAutoresSelecionados(){
        return this.labelAutoresEscolhidos_abaInserir.getText();
    }

    public String pesquisaInserir(){
        int value;
        value = this.tabela_abaAutor.getSelectedRow();

        String texto = this.tabela_abaAutor.getValueAt(value, 1).toString() + " " + this.tabela_abaAutor.getValueAt(value, 2).toString() + " / ";
        return texto;
    }

  

    public void attTextoAutorInserir(String texto){
        labelAutoresEscolhidos_abaInserir.setText(labelAutoresEscolhidos_abaInserir.getText() + " " + texto);
        
    }

    

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

    public void addAutorInserir(ActionListener al){
        this.botaoAutor_abainserir.addActionListener(al);
    }

    public void atualizaAutoresAbaInserir(int contador, Autores autor){

        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo2.addRow(infos);
        this.tabela_abaAutor.getTableHeader().resizeAndRepaint();
    }

    public Boolean getOpcaoAutorAbaInserir(){

       return radioButton_AutorAbaInserir.isSelected();
    }

    public Boolean getOpcaoEditoraAbaInserir(){

        return radioButton_EditorasAbaInserir.isSelected();
    }
    
    public Boolean getOpcaoLivroAbarInserir(){

        return radioButton_LivrosAbaInserir.isSelected();
    }

    public void attAutor(ActionListener al){
        this.botao_autor.addActionListener(al);
    } 

    // MÉTODOS JANELA ALTERAR

    public void pesquisaAutorAlterar(ActionListener al){
        this.botaoAutor_abaAlterar.addActionListener(al);
    }

    public void popUpAutorAbaAlterar(){
        
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

    public void pesquisaEditoraAlterar(ActionListener al){
        this.BtnEditorasAlterar.addActionListener(al);
        
    }

    public void popUpEditorasAbaAlterar(){
        
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

    public void atualizaAutoresAbaAlterar(int contador, Autores autor){

        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo3.addRow(infos);
        this.tabelaAutor_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    public void atualizaLivrosAbaAlterar(int contador, Livros livro){

        String[] infos = {(Integer.toString(contador)),livro.getTitle(),Float.toString(livro.getPrice())};

        modelo5.addRow(infos);
        this.tabelaLivros_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    public void atualizaEditorasAbaAlterar(int contador, Editoras editora){

        String[] infos = {(Integer.toString(contador)), editora.getName(),editora.getUrl()};

        modelo4.addRow(infos);
        this.tabelaEditoras_abaAlterar.getTableHeader().resizeAndRepaint();
    }

    public void pesquisaLivrosAlterar(ActionListener al){
        this.BtnLivrosAlterar.addActionListener(al);

    }
    
    public void popUpLivrosAbaAlterar(){

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

    public boolean getLivrosAbaAlterar(){
        return radioButton_LivrosAbaInserir1.isSelected();


    }
    
    public boolean getEditorasAbaAlterar(){
        return radioButton_EditorasAbaInserir1.isSelected();
    }
    
    public boolean getAutorAbaAlterar(){
        return radioButton_AutorAbaInserir1.isSelected();
    }

    public void desabilitaTelaAlterar(){

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

    public void habilitaAutorTelaAlterar(){

        this.TxtFieldNovoSobrenomeAlterar.setEnabled(true);
        this.TxtFieldNovoNomeAlterar.setEnabled(true);

        this.botaoAutor_abaAlterar.setEnabled(true);

    }

    public void habilitaEditoriaTelaAlterar(){

        this.TxtFieldNovaUrlAlterar.setEnabled(true);
        

        this.BtnEditorasAlterar.setEnabled(true);
        this.TxtFieldNovoNomeEditoraAlterar.setEnabled(true);

    }

    public void habilitaLivroTelaAlterar(){

        this.TxtFieldNovoTituloAlterar.setEnabled(true);
        this.TxtFieldNovoPrecoAlterar.setEnabled(true);

        this.BtnLivrosAlterar.setEnabled(true);


    }

    public void camposAlterarAutor(ActionListener al){
        
        this.radioButton_AutorAbaInserir1.addActionListener(al);

    }

    public void camposAlterarEditoras(ActionListener al){

        this.radioButton_EditorasAbaInserir1.addActionListener(al);

    }

    public void camposAlterarLivros(ActionListener al){

        this.radioButton_LivrosAbaInserir1.addActionListener(al);
 
    }

    public void limpaTabelaAlterar(){
        modelo3.setRowCount(0);
        modelo4.setRowCount(0);
        modelo5.setRowCount(0);
    }

    public String pesquisaAutorAlterar(){
        int value;
        value = this.tabelaAutor_abaAlterar.getSelectedRow();

        String texto = this.tabelaAutor_abaAlterar.getValueAt(value, 1).toString() + " " + this.tabelaAutor_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

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

    public void attAutorAlterar(ActionListener al){
        this.botaoAttAutor_abaAlterar.addActionListener(al);
    } 

    public String pesquisaLivroAlterar(){
        int value;
        value = this.tabelaLivros_abaAlterar.getSelectedRow();

        String texto = this.tabelaLivros_abaAlterar.getValueAt(value, 1).toString() + "/" + this.tabelaLivros_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

    public void attLivroAlterar(ActionListener al){
        this.botaoAttLivros_abaAlterar.addActionListener(al);
    } 

    public void attTextoLivroAlterar(String texto){
        String[] ListaLivro;
        ListaLivro = texto.split("/");

        TxtFieldAntigoTituloAlterar.setText(ListaLivro[0]); 
        TxtFieldPrecoAntigoAlterar.setText(ListaLivro[1]);
            
        
    }

    public String pesquisaEditoraAlterar(){
        int value;
        value = this.tabelaEditoras_abaAlterar.getSelectedRow();

        String texto = this.tabelaEditoras_abaAlterar.getValueAt(value, 1).toString() + "/" + this.tabelaEditoras_abaAlterar.getValueAt(value, 2).toString();
        return texto;
    }

    public void attEditoraAlterar(ActionListener al){
        this.botaoAttEditoras_abaAlterar.addActionListener(al);
    } 

    public void attTextoEditoraAlterar(String texto){
        String[] ListaEditora;
        ListaEditora = texto.split("/");

        TxtFieldAntigoNomeEditoraAlterar.setText(ListaEditora[0]); 
        TxtFieldAntigaUrlAlterar.setText(ListaEditora[1]);
               
    }

    public String getAntigoNomeAutorAlterar(){
        return this.TxtFieldNomeAlterar.getText();
    }

    public String getAntigoSobrenomeAutorAlterar(){
        return this.TxtFieldSobrenomeAlterar.getText();
    }

    public String getAntigoTituloLivroAlterar(){
        return this.TxtFieldAntigoTituloAlterar.getText();
    }

    public String getAntigoPrecoLivroAlterar(){
        return this.TxtFieldPrecoAntigoAlterar.getText();
    }

    public String getAntigoNomeEditoraAlterar(){
        return this.TxtFieldAntigoNomeEditoraAlterar.getText();
    }

    public String getAntigaUrlAlterar(){
        return this.TxtFieldAntigaUrlAlterar.getText();
    }

    public String getNovoNomeAutorAlterar(){
        return this.TxtFieldNovoNomeAlterar.getText();
    }

    public String getNovoSobrenomeAutorAlterar(){
        return this.TxtFieldNovoSobrenomeAlterar.getText();
    }

    public String getNovoTituloLivroAlterar(){
        return this.TxtFieldNovoTituloAlterar.getText();
    }

    public String getNovoPrecoLivroAlterar(){
        return this.TxtFieldNovoPrecoAlterar.getText();
    }

    public String getNovoNomeEditoraAlterar(){
        return this.TxtFieldNovoNomeEditoraAlterar.getText();
    }

    public String getNovaUrlEditoraAlterar(){
        return this.TxtFieldNovaUrlAlterar.getText();
    }

    public void realizaAlteracao(ActionListener al){
        this.BtnAcaoAlterar.addActionListener(al);
    }

    


    
   


    // MÉTODOS JANELA PESQUISA

    

    public void limpaTabelaInserir(){
        modelo2.setRowCount(0);
    }

    public void realizarPesquisa(ActionListener al){
        this.botaopesquisar_abaPesquisa.addActionListener(al);
    }

    public void habilita(){
        this.caixadetexto_abaPesquisa.setVisible(false);
    }
   
    public void informacoes(ActionListener al){
        this.botaoAjuda_abaPesquisa.addActionListener(al);
    }
    
    public void setOpcao(){

        this.pesquisaAuthors = checkboxAutores_abaPesquisa.isSelected();
        this.pesquisaBooks = checkboxLivros_abaPesquisa.isSelected();
        this.pesquisaPublishers = checkboxEditoras_abaPesquisa.isSelected();

    }

   
    
     
    public Boolean getOpcaoLivro(){
        return this.pesquisaBooks;
    }

    public Boolean getOpcaoAutor(){
        return this.pesquisaAuthors;
    }

    public Boolean getOpcaoEditora(){
        return this.pesquisaPublishers;
    }

    public String getTexto(){
        return this.caixadetexto_abaPesquisa.getText();
    }

    public void limpaTabelaPesquisa(){
        modelo.setRowCount(0);
    }

    public void atualizaTabelaAutor(int contador, Autores autor){

        String[] infos = {(Integer.toString(contador)), autor.getName(), autor.getFname()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    public void atualizaTabelaLivro(int contador, Livros livro){
        
        String[] infos = {(Integer.toString(contador)), "", "", livro.getTitle(), livro.getIsbn(), Float.toString(livro.getPrice())};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    public void atualizaTabelaEditora(int contador, Editoras editora){
        
        String[] infos = {(Integer.toString(contador)), "", "", "", "", "", editora.getName(), editora.getUrl()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    public void atualizaTabelaRelGeral(int contador, RelTudo valor){

       
        String[] infos = {(Integer.toString(contador)), valor.getNomeAutor().getName(),valor.getSobrenome().getFname(), valor.getTitulo().getTitle(), valor.getIsbn().getIsbn(), Float.toString(valor.getPreco().getPrice()), valor.getNomeEditora().getName(), valor.getUrl().getUrl()};


        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    public void atualizaRelLivroAutor(int contador, RelLivrosAutores dados){

        String[] infos = {(Integer.toString(contador)),  dados.getSobrenome().getName(), dados.getNome().getFname(), dados.getTitulo().getTitle(), dados.getIsbn().getIsbn(), Float.toString(dados.getPreco().getPrice())};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();
    }

    public void atualizaRelLivroEditora(int contador, RelLivrosEditoras dados){

        String[] infos = {(Integer.toString(contador)), "", "", dados.getTitulo().getTitle(), dados.getIsbn().getIsbn(), Float.toString(dados.getPreco().getPrice()), dados.getNome().getName(), dados.getUrl().getUrl()};

        modelo.addRow(infos);
        this.tabela_abaPesquisa.getTableHeader().resizeAndRepaint();

    }
    
    public void mensagemErro(){
        JOptionPane.showMessageDialog(null, "TESTE", "Erro ", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensagemAjudaPesquisa(){

        String[] infos = {"Nas checkboxs escolha os campos que deseja pesquisar.", "Autores: Pesquisas feitas no sobrenome", "Livros: Pesquisas feitas pelo título.", "Editoras: Pesquisas feitas pelo nome."};
        JOptionPane.showMessageDialog(null, infos, "Como realizar as pesquisas:", JOptionPane.INFORMATION_MESSAGE);
    }

    private javax.swing.ButtonGroup g1;
    private javax.swing.JLabel Filtrodepesquisa_abaAlterar;
    private javax.swing.JLabel Filtrodepesquisa_abaDeletar;
    private javax.swing.JLabel Filtrodepesquisa_abaInserir;
    private javax.swing.JLabel Filtrodepesquisa_abaPesquisa;
    private javax.swing.JPanel abaInserir;
    private javax.swing.JPanel abaPesquisa;
    private javax.swing.JButton botaoAlterar_abaAlterar;
    private javax.swing.JButton botaoDeletar_abaDeletar;
    private javax.swing.JButton botaoinserir_abaInserir;
    private javax.swing.JButton botaopesquisar_abaAlterar;
    private javax.swing.JButton botaopesquisar_abaDeletar;
    private javax.swing.JButton botaopesquisar_abaInserir;
    private javax.swing.JButton botaopesquisar_abaPesquisa;    
    private javax.swing.JButton botaoAjuda_abaPesquisa;
    private javax.swing.JLabel TxtFieldSobrenomeAlterar;
    private javax.swing.JTextField caixadetexto_abaDeletar;
    private javax.swing.JTextField caixadetexto_abaInserir;
    private javax.swing.JTextField caixadetexto_abaPesquisa;
    private javax.swing.JCheckBox checkboxAutores_abaAlterar;
    private javax.swing.JCheckBox checkboxAutores_abaDeletar;
    private javax.swing.JCheckBox checkboxAutores_abaInserir;
    private javax.swing.JCheckBox checkboxAutores_abaPesquisa;
    private javax.swing.JCheckBox checkboxEditoras_abaAlterar;
    private javax.swing.JCheckBox checkboxEditoras_abaDeletar;
    private javax.swing.JCheckBox checkboxEditoras_abaInserir;
    private javax.swing.JCheckBox checkboxEditoras_abaPesquisa;
    private javax.swing.JCheckBox checkboxLivros_abaAlterar;
    private javax.swing.JCheckBox checkboxLivros_abaDeletar;
    private javax.swing.JCheckBox checkboxLivros_abaPesquisa;
    private javax.swing.JCheckBox checkboxLivros_abainserir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane janelacomabas;
    private javax.swing.JTable tabela_abaAlterar;
    private javax.swing.JTable tabela_abaDeletar;
    private javax.swing.JTable tabela_abaInserir;
    private javax.swing.JTable tabela_abaPesquisa;
    private javax.swing.JLabel tituloPesquisa;
    private javax.swing.JLabel titulo_abaInserir;

    // VARIAVEIS ABA INSERIR

    private javax.swing.JButton botaoinserir_abaInserir1;
    private javax.swing.JButton botaoAutor_abainserir;
    private javax.swing.JButton botaoAjuda_abaInserir;

    private JDialog popUp;

    private javax.swing.JTextField caixadetexto_NomeDaEditora_abaInserir;
    private javax.swing.JTextField caixadetexto_URL_abaInserir;

    private javax.swing.JTextField caixadetexto_abaInserirEditora;
    private javax.swing.JTextField caixadetexto_abaInserirISBN;
    private javax.swing.JTextField caixadetexto_abaInserirNome1;
    private javax.swing.JTextField caixadetexto_abaInserirPreco;
    private javax.swing.JTextField caixadetexto_abaInserirSobreNome;
    private javax.swing.JTextField caixadetexto_abaInserirTitulo;

    private javax.swing.JLabel labelAutoresEscolhidos_abaInserir;
    private javax.swing.JLabel labelAutores_abainserir;
    private javax.swing.JLabel labelISBN_abaInserir;
    private javax.swing.JLabel labelNomeDaEditora_abaInserir;
    private javax.swing.JLabel labelNomeDaEditora_radiolivros_abaInserir;
    private javax.swing.JLabel labelNome_abaInserir;
    private javax.swing.JLabel labelQueMostraConfimacao_abaInserir;
    private javax.swing.JLabel labelSobreNome_abaInserir;
    private javax.swing.JLabel labelTitulo_abaInserir;
    private javax.swing.JLabel labelURL_abaInserir;
    private javax.swing.JLabel labelpreco_abaInserir;
    private javax.swing.JRadioButton radioButton_AutorAbaInserir;
    private javax.swing.JRadioButton radioButton_EditorasAbaInserir;
    private javax.swing.JRadioButton radioButton_LivrosAbaInserir;

    private JTable tabela_abaAutor ;
    private JButton botao_autor;

    // VARIÁVEIS DA ABA ALTERAR

    private javax.swing.ButtonGroup grupo_abaALterar;

    private javax.swing.JLabel LblPrimeiroNomeAlterar2;
    private javax.swing.JPanel abaAlterar;

    private javax.swing.JButton botaoAjuda_abaAlterar;
    private javax.swing.JButton BtnAcaoAlterar;
    private javax.swing.JButton botaoAutor_abaAlterar;
    private javax.swing.JButton BtnEditorasAlterar;
    private javax.swing.JButton BtnLivrosAlterar;
    
    private javax.swing.JTextField TxtFieldNovaUrlAlterar;
    private javax.swing.JTextField TxtFieldNovoNomeEditoraAlterar;

    private javax.swing.JTextField TxtFieldNovoTituloAlterar;
    private javax.swing.JTextField TxtFieldNovoPrecoAlterar;

    private javax.swing.JLabel TxtFieldAntigaUrlAlterar;
    
    private javax.swing.JLabel LblNovosDadosAutoresAlterar;
    private javax.swing.JLabel TxtFieldAntigoNomeEditoraAlterar;
    private javax.swing.JLabel LblNovoNomeEditoraAlterar;
    private javax.swing.JLabel LblAntigoNomeEditoraAlterar;
    private javax.swing.JLabel LblAntigoPrecoAlterar;
    private javax.swing.JLabel TxtFieldPrecoAntigoAlterar;
    private javax.swing.JLabel TxtFieldNomeAlterar;
    private javax.swing.JLabel LblNovoTituloAlterar;
    private javax.swing.JLabel LblNovaUrlAlterar;
    private javax.swing.JLabel LblAntigaUrlAlterar;
    private javax.swing.JLabel LblTituloNovoAlterar;
    private javax.swing.JLabel TxtFieldAntigoTituloAlterar;
    private javax.swing.JLabel LblDadosAntigoAutoresAlterar;
    private javax.swing.JLabel LblNovoPrecoAlterar;
    private javax.swing.JLabel LblPrimeiroNomeAlterar;
    private javax.swing.JLabel titulo_abaAlterar;

    private javax.swing.JLabel lblNovosDadosLivrosAlterar;
    private javax.swing.JLabel LblDadosAntigosEditorasAlterar;
    private javax.swing.JLabel LblNovoDadosEditorasAlterar;
    private javax.swing.JLabel LblDadosAntigosLivrosAlterar;

    private javax.swing.JRadioButton radioButton_AutorAbaInserir1;
    private javax.swing.JRadioButton radioButton_EditorasAbaInserir1;
    private javax.swing.JRadioButton radioButton_LivrosAbaInserir1;

    private javax.swing.JTextField TxtFieldNovoNomeAlterar;
    private javax.swing.JTextField TxtFieldNovoSobrenomeAlterar;

    private javax.swing.JLabel LblConfirmarcaoAlterar;

    private JTable tabelaAutor_abaAlterar;
    private JButton botaoAttAutor_abaAlterar;

    private JTable tabelaEditoras_abaAlterar;
    private JButton botaoAttEditoras_abaAlterar;

    private JButton botaoAttLivros_abaAlterar;
    private JTable tabelaLivros_abaAlterar;

    // VARIÁVEIS DA ABA DELETAR

    private javax.swing.ButtonGroup grupo_abaDeletar;
    private javax.swing.JPanel abaDeletar;

    private javax.swing.JRadioButton radioButton_AutorDeletar;
    private javax.swing.JRadioButton radioButton_EditorasAbaDeletar;
    private javax.swing.JRadioButton radioButton_LivrosDeletar;

    private javax.swing.JTextField caixadetextoISBN_abaDeletar;
    private javax.swing.JTextField caixadetextoNomeDaEditora_abaDeletar;
    private javax.swing.JTextField caixadetextoPrimeiroNomeAutor_abaDeletar;
    private javax.swing.JTextField caixadetextoSobrenomeAutor_abaDeletar;

    private javax.swing.JButton botaoAjuda_abaDeletar;
    private javax.swing.JButton botaoDeletar_abaDeletar1;

    private javax.swing.JLabel labelConclusaodeTarefa_abaDeletar;
    private javax.swing.JLabel labelISBN_abaDeletar;
    private javax.swing.JLabel labelPrimeiroNome_abaDeletar;
    private javax.swing.JLabel labelNomedaEditora_abaDeletar;
    private javax.swing.JLabel labelSobrenome_abaDeletar;
    private javax.swing.JLabel titulo_abaDeletar;



}
