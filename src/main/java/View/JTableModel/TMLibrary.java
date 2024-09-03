/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.JTableModel;

import Model.entitites.Library;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jc
 */
public class TMLibrary extends AbstractTableModel {

    private List listLibrary;
    
    private final int COL_NAME = 0;
    private final int COL_COD_BOOK = 1;
    
    @Override
    public int getRowCount() {
        return listLibrary.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Library aux = new Library();
        
        //return object empty
        if(listLibrary.isEmpty()) {
            return aux;
        } else {
            aux = (Library) listLibrary.get(rowIndex);
            
            switch(columnIndex) {
                case -1:
                    return aux;
                case COL_NAME:
                    return aux.getName();
                case COL_COD_BOOK:
                    return aux.getId_book();
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
            
            case COL_NAME:
                return "Name";
            case COL_COD_BOOK:
                return "Cod_Book";
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
