/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.FaturaHyrese;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FaturaHyreseTable extends AbstractTableModel {

    List<FaturaHyrese> lista;
    String[] kolonat = {"ID", "Produkti", "Cmimi €", "Data", "Paleta", "Paketa", "Cope","Data Skadences"};

    public FaturaHyreseTable() {
    }

    public FaturaHyreseTable(List<FaturaHyrese> lista) {
        this.lista = lista;
    }

    public void add(List<FaturaHyrese> lista) {
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

    public FaturaHyrese getFaturaHyrese(int i) {
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
   public String getDate2(Date date) {
        DateFormat da = new SimpleDateFormat("dd MMM, yyyy ");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FaturaHyrese FH = getFaturaHyrese(rowIndex);
        switch (columnIndex) {
            case 0:
                return FH.getFaturaHID();
            case 1:
                return FH.getProduktiID();
            case 2:
                return FH.getCmimi();
            case 3:
                return getDate(FH.getData());
            case 4:
                return FH.getPalete();
            case 5:
                return FH.getPaketa();
            case 6:
                return FH.getCope();
            case 7:
                return getDate2(FH.getDataeSkadences());
            default:
                return null;
        }
    }

}
