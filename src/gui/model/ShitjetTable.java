package gui.model;

import BLL.Shitjet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ShitjetTable extends AbstractTableModel {

    public ShitjetTable() {
    }

    List<Shitjet> lista;
    String[] kolonat = {"ID", "Biznesi", "Data", "C.meTvsh", "C.paTvsh", "Totali", "Sasia(paketa)"};

    public ShitjetTable(List<Shitjet> lista) {
        this.lista = lista;
    }

    public void add(List<Shitjet> lista) {
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

    public Shitjet getShitjet(int i) {
        return lista.get(i);
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

    public String getDate(Date date) {
        DateFormat da = new SimpleDateFormat("dd MMM, yyyy HH:mm");
        return da.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Shitjet sh = getShitjet(rowIndex);
        switch (columnIndex) {
            case 0:
                return sh.getShitjetID();
            case 1:
                return sh.getBiznesiID();
            case 2:
                return getDate(sh.getData());
            case 3:
                return sh.getCmimimeTvsh();
            case 4:
                return sh.getCmimipaTvsh();
            case 5:
                return sh.getTotali();
            case 6:
                return sh.getSasiaPaket();
            default:return null;
        }
    }

}
