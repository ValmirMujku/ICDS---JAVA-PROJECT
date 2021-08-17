/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Stoku;
import DAL.StokuRepository;
import gui.model.StokuTable;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public final class StokuForm extends javax.swing.JInternalFrame {

    StokuRepository str = new StokuRepository();
    StokuTable st;
  
    public StokuForm() {
        initComponents();
        shfaqTabelen();
        getPaleta();
        getPaketa();
        getCope();
        disableStokuFormDrag();
        setFormFullScren();
        StokuT.setAutoCreateRowSorter(true);
       
    }
    
    
    
    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize, ysize);
    }
    

    public void shfaqTabelen() {
        List<Stoku> lista = str.findByDate();
        st = new StokuTable(lista);
        StokuT.setModel(st);
        st.fireTableDataChanged();
        StokuT.getColumnModel().getColumn(0).setPreferredWidth(7);
    }

    public void getPaleta() {
         DecimalFormat df2 = new DecimalFormat(".##");
        double shuma = 0;
        for (int i = 0; i < StokuT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(StokuT.getValueAt(i, 2).toString());
            PaletaStok.setText(df2.format(shuma));
        }

    }

    public void getPaketa() {
        DecimalFormat df2 = new DecimalFormat(".##");
        double shuma = 0;
        for (int i = 0; i < StokuT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(StokuT.getValueAt(i, 3).toString());
            PaketaStok.setText(df2.format(shuma));
        }

    }

    public void getCope() {
        double shuma = 0;
        for (int i = 0; i < StokuT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(StokuT.getValueAt(i, 4).toString());
            CopeStok.setText(Double.toString(shuma));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StokuT = new javax.swing.JTable();
        DeleteStok = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CopeStok = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PaketaStok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PaletaStok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("STOKU");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        BackgroundPanel.setBackground(new java.awt.Color(153, 153, 255));

        StokuT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(StokuT);

        DeleteStok.setBackground(new java.awt.Color(0, 0, 0));
        DeleteStok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteStok.setForeground(new java.awt.Color(204, 204, 255));
        DeleteStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Stocks-icon.png"))); // NOI18N
        DeleteStok.setText("Kontrollo Skadencën");
        DeleteStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteStokActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("Copë");

        CopeStok.setEditable(false);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Paketa");

        PaketaStok.setEditable(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Paleta");

        PaletaStok.setEditable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("TOTALI   =");

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaletaStok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(PaketaStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(CopeStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteStok, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        BackgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CopeStok, PaketaStok, PaletaStok});

        BackgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaletaStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(PaketaStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CopeStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(DeleteStok, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        BackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CopeStok, PaketaStok, PaletaStok, jLabel1, jLabel2, jLabel3, jLabel4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteStokActionPerformed
        List<Stoku> lista = str.findAll();
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDataSkadencesProd().compareTo(new Date()) < 0) {
                count++;
                Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "Produkti " + "\"" + lista.get(i).getProduktiID().toString() + "\"" + " eshte pa afat." + "\n"
                       + "Afati i këtij produkti ka skaduar me: " + sdata + "\n"
                        + "Deshironi ti largoni nga stoku sasinë prej: " + "\n"
                        + lista.get(i).getPalete() + " Paleta." + "\n"
                        + lista.get(i).getPaketa() + " Paketa. " + "\n"
                        + lista.get(i).getCope() + " Copë.", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    str.remove(lista.get(i));
                    shfaqTabelen();
                    getPaleta();
                    getPaketa();
                    getCope();
                }
            }
        }
        if(count == 0){
            JOptionPane.showMessageDialog(this, "Të gjitha Produktet në Stok kanë afat.");
        }
    }//GEN-LAST:event_DeleteStokActionPerformed
    
    private void disableStokuFormDrag(){
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JTextField CopeStok;
    private javax.swing.JButton DeleteStok;
    private javax.swing.JTextField PaketaStok;
    private javax.swing.JTextField PaletaStok;
    private javax.swing.JTable StokuT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
