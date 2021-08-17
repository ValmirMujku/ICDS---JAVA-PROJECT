/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Porosite;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PorositeTableModel extends AbstractTableModel{
    
    List<Porosite> list;
    String[] columns = {"ID", "Biznesi:", "Data:", "Sasia:", "Totali:"};

    public PorositeTableModel() {
    }

    public PorositeTableModel(List<Porosite> list) {
        this.list = list;
    }

    public void add(List<Porosite> list) {
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

    public Porosite getPorosite(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Porosite p = getPorosite(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPorositeId();
            case 1:
                return p.getBiznesiID();
            case 2:
                return p.getData();
            case 3:
                return p.getSasia();
            case 4:
                return p.getTotali();
            case 5:
             default:
                 return null;
        }
    }
}
