/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Biznesi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class BiznesiComboBox extends AbstractListModel<Biznesi> implements ComboBoxModel<Biznesi>{
        private Biznesi biznesi;
    private List<Biznesi> data;
    
    public  BiznesiComboBox (List arrayList){
        data = arrayList;
    }

    public  BiznesiComboBox () {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Biznesi getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        biznesi = (Biznesi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return biznesi;
    }
}
