/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.JTableModel;

import Model.entitites.Author;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jc
 */
public class TMAuthor extends AbstractTableModel {
    
    private List listAuthors;
    
    private final int COL_CPF = 0;
    private final int COL_NAME = 1;
    private final int COL_HOMETOWN = 2;

    public TMAuthor(List listAuthors) {
        this.listAuthors = listAuthors;
    }
    
    @Override
    public int getRowCount() {
        return listAuthors.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    // receive the value selected in your paramater
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author aux = new Author();
        
        if(listAuthors.isEmpty()) {
            return aux;
        } else {
            aux = (Author) listAuthors.get(rowIndex);
            
            switch(columnIndex) {
                case -1:
                    return aux;
                case COL_NAME:
                    return aux.getName();
                case COL_CPF:
                    return aux.getCpf();
                case COL_HOMETOWN:
                    return aux.getHometown();
                default:
                    break;
            }
        }
        return aux;
    }

    //Check cell of table is editable or not editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    //return name of column
    @Override
    public String getColumnName(int column) {
        
        switch(column) {
            case COL_NAME:
                return "NOME";
            case COL_CPF:
                return "CPF";
            case COL_HOMETOWN:
                return "CIDADE NATAL";
            default:
                break;
        }
        
        return "";
    }
    
    //return class of column
    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}