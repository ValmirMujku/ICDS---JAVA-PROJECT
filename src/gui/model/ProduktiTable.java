package gui.model;

import BLL.Produkti;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProduktiTable extends AbstractTableModel {

    public ProduktiTable() {
    }

    List<Produkti> lista;
    String[] kolonat = {"ID", "Emri", "C.Furnizimit €", "Barkodi","Paleta --->", "Paketa --->", "Cope"};

    public ProduktiTable(List<Produkti> lista) {
        this.lista = lista;
    }

    public void add(List<Produkti> lista) {
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

    public Produkti getProdukti(int i) {
        return lista.get(i);
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

    public String getDate(Date date) {
        DateFormat da = new SimpleDateFormat("MMM dd, yyyy");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produkti p = getProdukti(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProduktiID();
            case 1:
                return p.getEmri();
            case 2:
                return p.getCmimi();
            case 3:
                return p.getBarkodi();
            case 4:
                return p.getPalete();
            case 5:
                return p.getPaketa();
            case 6:
                return p.getCope();
            default:
                return null;
        }
    }

}
