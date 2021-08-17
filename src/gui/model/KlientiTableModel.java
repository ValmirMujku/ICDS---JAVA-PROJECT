/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class KlientiTableModel extends AbstractTableModel{

    List<Klienti> list;
    String[] columns = {"ID", "Emri", "Mbiemri", "Mosha", "Gjinia", "Qyteti"/* ,"LogIn"*/};

    public KlientiTableModel() {
    }

    public KlientiTableModel(List<Klienti> list) {
        this.list = list;
    }

    public void add(List<Klienti> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public Klienti getKlienti(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k = getKlienti(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKId();
            case 1:
                return k.getEmri();
            case 2:
                return k.getMbiemri();
            case 3:
                return k.getMosha();
            case 4:
                return k.getGjinia();
            case 5:
                return k.getQyteti();
                /*
            case 6:
                return k.getKlientiLogIn();
                */
             default:
                 return null;
        }
    }
    
}
