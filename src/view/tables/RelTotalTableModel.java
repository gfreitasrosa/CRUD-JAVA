package view.tables;

import java.util.List;
import model.entidades.*;
import view.*;
import javax.swing.table.AbstractTableModel;

public class RelTotalTableModel extends AbstractTableModel{

    private final int ORDEM=0;
    private final int SOBRENOME=1;
    private final int NOME=2;
    private final int TITULO=3;
    private final int ISBN=4;
    private final int PRECO=5;
    private final int EDITORA=6;
    private final int URL=7;

    private final String colunas[] ={"Nº Ordem", "Sobrenome", "Nome","Titulo do livro", "ISBN", "Preco", "Editora", "URL"};
    private final List<RelTudo> dados;

    public RelTotalTableModel(List<RelTudo> dados){
        this.dados = dados;
    }

    @Override
    public int getColumnCount() {
        //retorna o total de colunas
        return colunas.length;
    }
 
    @Override
    public int getRowCount() {
        //retorna o total de linhas na tabela
        return dados.size();
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
        case ORDEM:
            return int.class;
        case SOBRENOME:
            return String.class;
        case NOME:
            return String.class;
        case TITULO:
            return String.class;
        case ISBN:
            return String.class;
        case PRECO:
            return Float.class;
        case EDITORA:
            return String.class;
        case URL:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha
 
        //pega o dados corrente da linha
        RelTudo relacao=dados.get(rowIndex);
 
        //retorna o valor da coluna
        switch (columnIndex) {
        case SOBRENOME:
            return relacao.getSobrenome();
        case NOME:
            return relacao.getNomeAutor();
        case TITULO:
            return relacao.getTitulo();
        case ISBN:
            return relacao.getIsbn();
        case PRECO:
            return relacao.getPreco();
        case EDITORA:
            return relacao.getNomeEditora();
        case URL:
            return relacao.getUrl();
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }

    //Métodos abaixo são para manipulação de dados
 
    /**
     * retorna o valor da linha indicada
     * @param rowIndex
     * @return
     */
    public RelTudo getValue(int rowIndex){
        return dados.get(rowIndex);
    }
 
    /**
     * retorna o indice do objeto
     * @param relacao
     * @return
     */
    public int indexOf(RelTudo relacao) {
        return dados.indexOf(relacao);
    }
 
    /**
     * add um relacao á lista
     * @param relacao
     */
    public void onAdd(RelTudo relacao) {
        dados.add(relacao);
        fireTableRowsInserted(indexOf(relacao), indexOf(relacao));
    }
 
    /**
     * add uma lista de relacao
     * @param dadosIn
     */
    public void onAddAll(List<RelTudo> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }
 
    /**
     * remove um registro da lista, através do indice
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    /**
     * remove um registro da lista, através do objeto
     * @param relacao
     */
    public void onRemove(RelTudo relacao) {
        int indexBefore=indexOf(relacao);//pega o indice antes de apagar
        dados.remove(relacao);  
        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }
}
