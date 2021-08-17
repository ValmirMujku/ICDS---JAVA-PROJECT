/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Porosia;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PorosiaTableModel extends AbstractTableModel{
    
    List<Porosia> list;
    String[] columns = {"ID", "Produkti:", "Sasia:", "Biznesi:", "Adresa", "Totali:"};

    public PorosiaTableModel() {
    }

    public PorosiaTableModel(List<Porosia> list) {
        this.list = list;
    }

    public void add(List<Porosia> list) {
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

    public Porosia getPorosia(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Porosia p = getPorosia(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPorosiaID();
            case 1:
                return p.getProduktiID();
            case 2:
                return p.getSasia();
            case 3:
                return p.getBiznesiID();
            case 4:
                return p.getAdresa();
            case 5:
                return p.getTotali();
             default:
                 return null;
        }
    }
}
