/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Komuna;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class KomunaComboBox extends AbstractListModel<Komuna> implements ComboBoxModel<Komuna>{
    private Komuna komuna;
    private List<Komuna> data;
    
    public KomunaComboBox(List arrayList){
        data = arrayList;
    }

    public KomunaComboBox() {
       
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Komuna getElementAt(int index) { 
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        komuna = (Komuna)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return komuna;
    }

}
