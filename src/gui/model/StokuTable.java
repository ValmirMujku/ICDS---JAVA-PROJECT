/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Stoku;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class StokuTable extends AbstractTableModel {

    public StokuTable() {
    }

    List<Stoku> lista;
    String[] kolonat = {"ID", "Produkti", "Palete", "Pakete", "Cope","Data Skadences"};

    public StokuTable(List<Stoku> lista) {
        this.lista = lista;
        
    }

    public void add(List<Stoku> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    public Stoku getStoku(int i) {
        return lista.get(i);
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
    
    public String getDate(Date date) {
        DateFormat da = new SimpleDateFormat("dd MMM, yyyy ");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stoku s = getStoku(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getStokuID();
            case 1:
                return s.getProduktiID();
            case 2:
                return s.getPalete();
            case 3:
                return s.getPaketa();
            case 4:
                return s.getCope();
            case 5:
                return getDate(s.getDataSkadencesProd());
            default:
                return null;
        }
    }

}
