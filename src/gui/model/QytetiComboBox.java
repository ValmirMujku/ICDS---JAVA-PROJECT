/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;


import BLL.Qyteti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class QytetiComboBox extends AbstractListModel<Qyteti> implements ComboBoxModel<Qyteti>{
      private Qyteti qyteti;
    private List<Qyteti> data;
    
  
    public QytetiComboBox(List arrayList){
        data = arrayList;
    }
    
    
    public QytetiComboBox(){}
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Qyteti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        qyteti = (Qyteti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return qyteti;
    }
    
}
