/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.LlojiiBiznesit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class LlojiiBiznesitComboBox extends AbstractListModel<LlojiiBiznesit> implements ComboBoxModel<LlojiiBiznesit>{
    private LlojiiBiznesit lloji;
    private List<LlojiiBiznesit> data;
    
    public LlojiiBiznesitComboBox(List arrayList){
        data = arrayList;
    }

    public LlojiiBiznesitComboBox() {
       
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public LlojiiBiznesit getElementAt(int index) { 
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        lloji = (LlojiiBiznesit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return lloji;
    }

}
