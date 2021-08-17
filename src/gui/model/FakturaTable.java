/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Faktura;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FakturaTable extends AbstractTableModel {

    List<Faktura> lista;
    String[] kolonat = {"ID", "Biznesi", "Produkti", "C.MeTvsh €", "C.PaTvsh €", "Data","Barkodi","Sasia"};

    public FakturaTable() {
        
    }

    public FakturaTable(List<Faktura> lista) {
        this.lista = lista;
    }

    public void add(List<Faktura> lista) {
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

    public Faktura getFaktura(int i) {
        return lista.get(i);
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
    
      public String getDate(Date date) {
        DateFormat da = new SimpleDateFormat("dd MMM, yyyy HH:mm");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Faktura f = getFaktura(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getFakturaID();
            case 1:
                return f.getBiznesiID();
            case 2:
                return f.getProduktiID();
            case 3:
                return f.getCmimimeTVSH();
            case 4:
                return f.getCmimi();
            case 5:
                return getDate(f.getData());
            case 6:
                return f.getBarkodi();
            case 7:
                return f.getSasia();
            default:
                return null;
        }
    }
}
