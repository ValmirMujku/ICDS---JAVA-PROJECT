/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Pozitat;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class PozitatTableModel extends AbstractTableModel{
    List<Pozitat> list;
    String[] columns = {"ID", "Emri i pozites"};

    public PozitatTableModel() {
    }

    public PozitatTableModel(List<Pozitat> list) {
        this.list = list;
    }

    public void add(List<Pozitat> list) {
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

    public Pozitat getPozita(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pozitat p = getPozita(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPozitaID();
            case 1:
                return p.getEmri();
             default:
                 return null;
        }
    }
}
