/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Qyteti;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class QytetiTable  extends AbstractTableModel {
     List<Qyteti> lista;
    String[] kolonat = {"ID","Qyteti","Zip C"};

    public QytetiTable(){
        
    }
        public QytetiTable(List<Qyteti> lista) {
        this.lista = lista;
    }
        
            public void add(List<Qyteti> lista) {
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
    
        public Qyteti getQyteti(int i) {
        return lista.get(i);
    }
        
     @Override
        public String getColumnName(int column) {
            return kolonat[column];
        }
        
        
        

     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Qyteti q = getQyteti(rowIndex);
        switch(columnIndex){
            case 0:return q.getQytetiID();
            case 1: return q.getEmri();
            case 2:return q.getZipCode();
            default:return null;
        }
    }
}
