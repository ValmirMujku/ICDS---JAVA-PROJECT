/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Pozitat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class PozitaComboBox extends AbstractListModel<Pozitat> implements ComboBoxModel<Pozitat>{
    private Pozitat pozita;
    private List<Pozitat> data;
    
    public PozitaComboBox(List arrayList){
        data = arrayList;
    }

    public PozitaComboBox() {
       
    }



    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Pozitat getElementAt(int index) { 
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        pozita = (Pozitat)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return pozita;
    }

}