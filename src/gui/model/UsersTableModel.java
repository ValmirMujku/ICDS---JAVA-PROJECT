/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Users;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class UsersTableModel extends AbstractTableModel{
    List<Users> list;
    String[] columns = {"Numri rendor", "ID e Perdoruesit","Passwordi i Perdoruesit"};

    public UsersTableModel() {
    }

    public UsersTableModel(List<Users> list) {
        this.list = list;
    }

    public void add(List<Users> list) {
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

    public Users getUsers(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Users u = getUsers(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getUId();
            case 1:
                return u.getUIdlog();
            case 2:
                return u.getUPassword();
             default:
                 return null;
        }
    }
}
