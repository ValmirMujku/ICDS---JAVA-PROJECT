package gui.view;

import BLL.Hyrjet;
import DAL.HyrjetRepository;
import Exceptions.HyrjetException;
import gui.model.HyrjetTable;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import java.awt.print.PrinterException;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class HyrjetForm extends javax.swing.JInternalFrame {

    HyrjetRepository hr = new HyrjetRepository();
    HyrjetTable htable;

    public HyrjetForm() {
        initComponents();
        shfaqTabelenHyrjet();
        setTotali();
        disableHyrjetFormDrag();
//        setFormInMiddle();
        setFormFullScren();
        HyrjetT.setAutoCreateRowSorter(true);
    }
    
    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize, ysize);
    }

//    private void setFormInMiddle() {
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
//    }

    public void shfaqTabelenHyrjet() {
        try {
            List<Hyrjet> lista = hr.findAll();
            htable = new HyrjetTable(lista);
            HyrjetT.setModel(htable);
            htable.fireTableDataChanged();
            HyrjetT.getColumnModel().getColumn(0).setPreferredWidth(8);
        } catch (HyrjetException ex) {
            Logger.getLogger(HyrjetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTotali() {
        double shuma = 0;
        for (int i = 0; i < HyrjetT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(HyrjetT.getValueAt(i, 5).toString());
            TotalHyrje.setText(Double.toString(shuma));
        }
    }

    public void gjeneroHyrjet() throws PrinterException {
        try {
            int choice;
            int count = 1;
            choice = JOptionPane.showConfirmDialog(null, "Deshironi ti gjeneroni Hyrjet?", "Kujdes!", JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                Format formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
                String sdata = formatter.format(new Date());
                String string1 = "Hyrjet  " + sdata;
                String asd = TotalHyrje.getText().toString();
                String string2 = "TOTALI = " + asd + "  €" + "                                       Nenshkrimi:_________________";
                MessageFormat m1 = new MessageFormat(string1);
                MessageFormat m2 = new MessageFormat(string2);
                HyrjetT.print(JTable.PrintMode.FIT_WIDTH, m1, m2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HyrjetBackgroundPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalHyrje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HyrjetT = new javax.swing.JTable();
        GjHyrjet = new javax.swing.JButton();

        setClosable(true);
        setTitle("HYRJET");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        HyrjetBackgroundPanel.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Total-Commander-icon.png"))); // NOI18N
        jLabel1.setText("TOTALI: ");

        TotalHyrje.setEditable(false);
        TotalHyrje.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("€");

        HyrjetT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(HyrjetT);

        GjHyrjet.setBackground(new java.awt.Color(0, 0, 0));
        GjHyrjet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GjHyrjet.setForeground(new java.awt.Color(204, 204, 204));
        GjHyrjet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-document-30.png"))); // NOI18N
        GjHyrjet.setText("Gjenero Hyrjet");
        GjHyrjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GjHyrjetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HyrjetBackgroundPanelLayout = new javax.swing.GroupLayout(HyrjetBackgroundPanel);
        HyrjetBackgroundPanel.setLayout(HyrjetBackgroundPanelLayout);
        HyrjetBackgroundPanelLayout.setHorizontalGroup(
            HyrjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HyrjetBackgroundPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(HyrjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GjHyrjet, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HyrjetBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalHyrje, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        HyrjetBackgroundPanelLayout.setVerticalGroup(
            HyrjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HyrjetBackgroundPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(GjHyrjet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HyrjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalHyrje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        HyrjetBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TotalHyrje, jLabel1, jLabel2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HyrjetBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HyrjetBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GjHyrjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GjHyrjetActionPerformed
        try {
            gjeneroHyrjet();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_GjHyrjetActionPerformed
    private void disableHyrjetFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GjHyrjet;
    private javax.swing.JPanel HyrjetBackgroundPanel;
    private javax.swing.JTable HyrjetT;
    private javax.swing.JTextField TotalHyrje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
