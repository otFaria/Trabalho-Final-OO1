/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.JTableModel;

import Model.entitites.Book;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jc
 */
public class TMBook extends AbstractTableModel {
    
    private List listBooks;
    
    private final int COL_COD_BOOK = 0;
    private final int COL_NAME = 1;
    private final int COL_AUTHOR_ID = 2;
    
    
      public TMBook(List listBooks) {
        this.listBooks = listBooks;
    }
    
    @Override
    public int getRowCount() {
        return listBooks.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book aux = new Book();
        
        //return object empty
        if(listBooks.isEmpty()) {
            return aux;
        } else {
            aux = (Book) listBooks.get(rowIndex);
            
            switch(columnIndex) {
                case -1:
                    return aux;
                case COL_COD_BOOK:
                    return aux.getCod_book();
                case COL_NAME:
                    return aux.getName();
                case COL_AUTHOR_ID:
                    return aux.getAuthorId();
                default:
                    break;
            }
        }
        
        return aux;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
            case COL_COD_BOOK:
                return "COD_LIVRO";
            case COL_NAME:
                return "NOME";
            case COL_AUTHOR_ID:
                return "AUTOR_ID"; 
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {        
        return String.class;
    }

}
