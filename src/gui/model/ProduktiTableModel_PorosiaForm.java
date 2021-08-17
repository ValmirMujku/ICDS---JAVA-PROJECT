/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Produkti;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProduktiTableModel_PorosiaForm extends AbstractTableModel{
    List<Produkti> list;
    String[] columns = {"ID", "Emri i produktit", "Qmimi i produktit", "Paketa"};

    public ProduktiTableModel_PorosiaForm() {
    }

    public ProduktiTableModel_PorosiaForm(List<Produkti> list) {
        this.list = list;
    }

    public void add(List<Produkti> list) {
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

    public Produkti getPozita(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produkti p = getPozita(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProduktiID();
            case 1:
                return p.getEmri();
            case 2:
                return p.getCmimi();
            case 3:
                return p.getPaketa();
             default:
                 return null;
        }
    }
}
