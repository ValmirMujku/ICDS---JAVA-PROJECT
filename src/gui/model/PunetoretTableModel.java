/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Punetori;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;


public class PunetoretTableModel extends AbstractTableModel{
    List<Punetori> list;
    String[] columns = {"ID", "Emri", "Mbiemri", "Mosha", "Gjinia", "Pozita", "Adresa" /*, "LogIn  */};

    public PunetoretTableModel() {
    }

    public PunetoretTableModel(List<Punetori> list) {
        this.list = list;
    }

    public void add(List<Punetori> list) {
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

    public Punetori getPunetori(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Punetori p = getPunetori(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPId();
            case 1:
                return p.getEmri();
            case 2:
                return p.getMbiemri();
            case 3:
                return p.getMosha();
            case 4:
                return p.getGjinia(); 
            case 5:
                return p.getPozita();
            case 6:
                return p.getAdresa();
                /*
            case 7:
                return p.getPuneotriLogIn();
                */
             default:
                 return null;
        }
    }
}
