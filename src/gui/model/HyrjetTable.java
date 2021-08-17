/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Hyrjet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class HyrjetTable extends AbstractTableModel{
     public HyrjetTable() {
    }
    
    List<Hyrjet> lista;
    String[] kolonat = {"ID", "Data", "Paleta","Paketa","Copa","Totali"};

    public HyrjetTable(List<Hyrjet> lista) {
        this.lista = lista;
    }

    public void add(List<Hyrjet> lista) {
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

    public Hyrjet getHyrjet(int i) {
        return lista.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
    
     public String getDate(Date date) {
        DateFormat da = new SimpleDateFormat("dd MMM, yyyy HH-mm");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hyrjet h = getHyrjet(rowIndex);
        switch(columnIndex){
            case 0:return h.getHyrjetID();
            case 1:return getDate(h.getData());
            case 2:return h.getPalete();
            case 3:return h.getPaketa();
            case 4:return h.getCope();
            case 5:return h.getTotali();
            default: return null;
        }
    }
}
