package gui.view;

import BLL.Shitjet;
import DAL.ShitjetRepository;
import gui.model.ShitjetTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseMotionListener;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableRowSorter;


public class ShitjetForm extends javax.swing.JInternalFrame {

    ShitjetRepository shr = new ShitjetRepository();
    ShitjetTable shtable;

    public ShitjetForm() {
        initComponents();
        shfaqTabelenShitjet();
        getTotalipaTvsh();
        getTotali();
        diferenca();
        disableShtijetFormDrag();
        setFormFullScren();
//        setFormInMiddle();
         ShitjetT.setAutoCreateRowSorter(true);
    }
    
    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize, ysize);
    }
  
//   private void setFormInMiddle(){
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
//    }
    
    private void shfaqTabelenShitjet() {
        List<Shitjet> lista = shr.findAll();
        shtable = new ShitjetTable(lista);
        ShitjetT.setModel(shtable);
        shtable.fireTableDataChanged();
        ShitjetT.getColumnModel().getColumn(0).setPreferredWidth(8);
        ShitjetT.getColumnModel().getColumn(1).setPreferredWidth(80);
        ShitjetT.getColumnModel().getColumn(2).setPreferredWidth(100);

    }

    public void tabelaLoadSearch(List<Shitjet> lista) {
        shtable = new ShitjetTable(lista);
        ShitjetT.setModel(shtable);
        shtable.fireTableDataChanged();
    }

    public void getTotalipaTvsh() {
        double shuma = 0;
        for (int i = 0; i < ShitjetT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(ShitjetT.getValueAt(i, 4).toString());
            toPaTvsh.setText(Double.toString(shuma));
        }

    }

    public void getTotali() {
          DecimalFormat df2 = new DecimalFormat(".##");
        double shuma = 0;
        for (int i = 0; i < ShitjetT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(ShitjetT.getValueAt(i, 5).toString());
            totMeTvsh.setText(df2.format(shuma));
        }

    }

    public void diferenca() {
        double totmetvsh = 0, totpatvsh = 0, diferenca = 0;
        for (int i = 0; i < ShitjetT.getRowCount(); i++) {
            totmetvsh = totmetvsh + Double.parseDouble(ShitjetT.getValueAt(i, 5).toString());
            totpatvsh = totpatvsh + Double.parseDouble(ShitjetT.getValueAt(i, 4).toString());
        }
        diferenca = totmetvsh - totpatvsh;
        String asd1 = Double.toString(Math.round(diferenca));
            DiferencaTot.setText(asd1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShitjetBackgroundPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DiferencaTot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        toPaTvsh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totMeTvsh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShitjetT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("SHITJET");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        ShitjetBackgroundPanel.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("€");

        DiferencaTot.setEditable(false);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setText("TVSH:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("€");

        toPaTvsh.setEditable(false);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Totali pa Tvsh");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("€");

        totMeTvsh.setEditable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Total-Commander-icon.png"))); // NOI18N
        jLabel1.setText("Totali me TVSH");

        ShitjetT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ShitjetT);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Money-icon.png"))); // NOI18N
        jButton1.setText("Gjenero Total Shitjet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Money-icon.png"))); // NOI18N
        jButton2.setText("Gjenero");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setText("Biznesi");

        SearchField.addFocusListener(new FocusListener()
            {

                @Override
                public void focusGained(FocusEvent e)
                {
                    if(SearchField.getText().equals("Emri")){
                        SearchField.setForeground(Color.black);
                        SearchField.setText("");
                    }

                }

                public void focusLost(FocusEvent e)
                {
                    if(SearchField.getText().equals("")){
                        SearchField.setForeground(new Color(204,204,204));
                        SearchField.setText("Emri");}
                }
            });
            SearchField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
            SearchField.setForeground(new java.awt.Color(204, 204, 204));
            SearchField.setText("Emri");
            SearchField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SearchFieldActionPerformed(evt);
                }
            });

            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-search-property-30.png"))); // NOI18N

            javax.swing.GroupLayout ShitjetBackgroundPanelLayout = new javax.swing.GroupLayout(ShitjetBackgroundPanel);
            ShitjetBackgroundPanel.setLayout(ShitjetBackgroundPanelLayout);
            ShitjetBackgroundPanelLayout.setHorizontalGroup(
                ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShitjetBackgroundPanelLayout.createSequentialGroup()
                    .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ShitjetBackgroundPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE))
                        .addGroup(ShitjetBackgroundPanelLayout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(totMeTvsh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(toPaTvsh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DiferencaTot, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShitjetBackgroundPanelLayout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addGap(42, 42, 42))
            );

            ShitjetBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

            ShitjetBackgroundPanelLayout.setVerticalGroup(
                ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ShitjetBackgroundPanelLayout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGroup(ShitjetBackgroundPanelLayout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(ShitjetBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totMeTvsh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(DiferencaTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(toPaTvsh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(252, Short.MAX_VALUE))
            );

            ShitjetBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DiferencaTot, jLabel1, jLabel2, jLabel3, jLabel6, toPaTvsh, totMeTvsh});

            ShitjetBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SearchField, jLabel7, jLabel8});

            ShitjetBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

            DocumentListener document2Listener = new DocumentListener() {
                public void changedUpdate(DocumentEvent documentEvent) {
                    printIt(documentEvent);
                }
                public void insertUpdate(DocumentEvent documentEvent) {
                    printIt(documentEvent);
                }
                public void removeUpdate(DocumentEvent documentEvent) {
                    printIt(documentEvent);
                }

                private void printIt(DocumentEvent documentEvent) {
                    DocumentEvent.EventType type = documentEvent.getType();
                    if(!SearchField.getText().equals("") && !SearchField.getText().equals("Emri"))
                    {
                        tabelaLoadSearch(shr.find(SearchField.getText()));
                    }
                    else
                    {
                        shfaqTabelenShitjet();
                    }
                }
            };
            SearchField.getDocument().addDocumentListener(document2Listener);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ShitjetBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ShitjetBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    

    public boolean thesameBiznes() {
        int count = 0;
        String biznesi = "";
        for (int i = 0; i < ShitjetT.getRowCount(); i++) {
            if (i == 0) {
                biznesi = ShitjetT.getValueAt(i, 1).toString();
                count++;
            }
            if (i != 0 && ShitjetT.getValueAt(i, 1).toString().equals(biznesi)) {
                count++;
            }

        }
        if (count == ShitjetT.getRowCount()) {
            return true;
        }
        return false;
    }

    public void gjeneroShitjetBiznes() throws PrinterException {
        if (thesameBiznes() == false) {
            JOptionPane.showMessageDialog(this, "Gjenerimi mund të ekzekutohet vetëm për një Biznes.");
            return;
        }
        double shuma=0,shuma1=0,diferenca = 0;
        for (int i = 0; i < ShitjetT.getRowCount(); i++) {
            shuma = shuma + Double.parseDouble(ShitjetT.getValueAt(i, 5).toString());
            totMeTvsh.setText(Double.toString(shuma));
             shuma1 = shuma1 + Double.parseDouble(ShitjetT.getValueAt(i, 4).toString());
            toPaTvsh.setText(Double.toString(shuma1));
            
        }
             DecimalFormat df2 = new DecimalFormat(".##");
         diferenca = shuma - shuma1;
            String asd3 = df2.format(diferenca);
            DiferencaTot.setText(df2.format(diferenca));

        int choice;
        int count = 1;
        choice = JOptionPane.showConfirmDialog(null, "Deshironi ti gjeneroni shitjet?", "Kujdes!", JOptionPane.INFORMATION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            Format formatter = new SimpleDateFormat("dd-MM-yyyy ");
            String sdata = formatter.format(new Date());
            String string1 = "SHITJET  " + "\"" + ShitjetT.getValueAt(0, 1)+ "\""+ "  " +sdata;
            String asd = String.valueOf(shuma);
            String asd2 = String.valueOf(shuma1);
            
            String string2 = "TOTALI = " + asd + "  €" +"       " + "C.pa Tvsh = " + asd2 + " €" + "       " + "TVSH = " + asd3 + " €";
            MessageFormat m1 = new MessageFormat(string1);
            MessageFormat m2 = new MessageFormat(string2);
            ShitjetT.print(JTable.PrintMode.FIT_WIDTH, m1, m2);
        }
    }

    public void gjeneroShitjet() throws PrinterException {
        int choice;
        int count = 1;
        choice = JOptionPane.showConfirmDialog(null, "Deshironi ti gjeneroni shitjet?", "Kujdes!", JOptionPane.INFORMATION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            Format formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
            String sdata = formatter.format(new Date());
            String string1 = "SHITJET  " + sdata;
            String asd = totMeTvsh.getText().toString();
            String string2 = "TOTALI = " + asd + "  €" + "                                       Nenshkrimi:_________________";
            MessageFormat m1 = new MessageFormat(string1);
            MessageFormat m2 = new MessageFormat(string2);
            ShitjetT.print(JTable.PrintMode.FIT_WIDTH, m1, m2);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            gjeneroShitjet();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            gjeneroShitjetBiznes();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void disableShtijetFormDrag(){
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiferencaTot;
    private javax.swing.JTextField SearchField;
    private javax.swing.JPanel ShitjetBackgroundPanel;
    private javax.swing.JTable ShitjetT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField toPaTvsh;
    private javax.swing.JTextField totMeTvsh;
    // End of variables declaration//GEN-END:variables
}
