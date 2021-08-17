/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Produkti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ProduktiComboBox extends AbstractListModel<Produkti> implements ComboBoxModel<Produkti>{
    private Produkti produkti;
    private List<Produkti> data;
    
    public ProduktiComboBox(List arrayList){
        data = arrayList;
    }

    public ProduktiComboBox() {
       
    }



    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Produkti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        produkti = (Produkti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return produkti;
    }
    
    
}
