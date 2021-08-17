package gui.view;

import BLL.Biznesi;
import BLL.Faktura;
import DAL.FakturaInterFace;
import DAL.FakturaRepository;
import gui.model.FakturaTable;
import java.util.List;
import BLL.Produkti;
import BLL.Shitjet;

import BLL.Stoku;
import DAL.BiznesiRepository;
import Exceptions.FaturaException;
import Exceptions.ProduktiException;

import gui.model.ProduktiComboBox;
import DAL.ProduktiRepository;
import DAL.ShitjetRepository;

import DAL.StokuRepository;

import gui.model.BiznesiComboBox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class FakturaForm extends javax.swing.JInternalFrame {

    ProduktiRepository qre = new ProduktiRepository();
    BiznesiRepository br = new BiznesiRepository();
    StokuRepository str = new StokuRepository();
    FakturaInterFace fi = new FakturaRepository();
    ShitjetRepository shr = new ShitjetRepository();
    FakturaTable t;
    int Kontrolleri = 0;

    public FakturaForm() throws ProduktiException, FaturaException {
        initComponents();
        shfaqTabelen();
        time();
        tabelaSelectedIndexChange();
//     IDFIELD.setEditable(false);
        loadbox();
        loadbox2();
        setTitle("ICDS - Administrata Main Panel");
        disableFakturaFormDrag();
//        setFormInMiddle();
        setFormFullScren();
    }
    
        //KJO
    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize, ysize);
    }

//    private void setFormInMiddle() {
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
//    }

    public void loadbox() throws ProduktiException {
        ProduktiComboBox qc;
        List<Produkti> lista = qre.findAll();
        qc = new ProduktiComboBox(lista);
        this.ProduktiBox.setModel(qc);

    }

    public void loadbox2() {

        BiznesiComboBox bc;
        List<Biznesi> lista = br.findAll();
        bc = new BiznesiComboBox(lista);
        this.BiznesiBox.setModel(bc);

    }

    public void shfaqTabelen() throws FaturaException {
        List<Faktura> lista = fi.findAll();
        t = new FakturaTable(lista);
        FakturaT.setModel(t);
        t.fireTableDataChanged();
        FakturaT.getColumnModel().getColumn(0).setPreferredWidth(7);
        FakturaT.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    public void pastroFushat() throws ProduktiException {
        FakturaT.clearSelection();

        CmimiField.setText("");
        SasiaFat.setText("");
        CmimimeTVSH.setText("");
        BiznesiBox.setSelectedIndex(-1);
        ProduktiBox.setSelectedItem(-1);
        loadbox();
        loadbox2();
    }

    BigDecimal tot = new BigDecimal("0.00");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        faturaBackgroundPanel = new javax.swing.JPanel();
        PRINT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TOTALI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FakturaT = new javax.swing.JTable();
        DeleteALL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SasiaFat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CmimimeTVSH = new javax.swing.JTextField();
        CmimimeTVSHLABEL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CmimiLabel = new javax.swing.JLabel();
        CmimiField = new javax.swing.JTextField();
        ProduktiBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        BiznesiBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        kohaButton = new javax.swing.JLabel();

        setClosable(true);
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("FATURA"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        faturaBackgroundPanel.setBackground(new java.awt.Color(153, 153, 255));
        faturaBackgroundPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        PRINT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PRINT.setForeground(new java.awt.Color(0, 153, 0));
        PRINT.setText("PRINT");
        PRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("€");

        TOTALI.setEditable(false);
        TOTALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOTALIActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Total-Commander-icon.png"))); // NOI18N
        jLabel4.setText("TOTALI:");

        FakturaT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(FakturaT);

        DeleteALL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteALL.setForeground(new java.awt.Color(255, 0, 0));
        DeleteALL.setText("Delete All");
        DeleteALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteALLActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("Paketa");

        SasiaFat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SasiaFatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setText("Sasia:");

        CmimimeTVSH.setEditable(false);
        CmimimeTVSH.setPreferredSize(new java.awt.Dimension(32, 24));

        CmimimeTVSHLABEL.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        CmimimeTVSHLABEL.setText("Cmimi me TVSH:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel7.setText("€");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setText("€");
        jLabel6.setPreferredSize(new java.awt.Dimension(32, 24));

        CmimiLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        CmimiLabel.setText("Cmimi pa TVSH:");

        CmimiField.setEditable(false);
        CmimiField.setPreferredSize(new java.awt.Dimension(32, 24));

        ProduktiBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProduktiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProduktiBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Produkti:");

        BiznesiBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BiznesiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiznesiBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Biznesi:");

        EditB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EditB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-edit-file-30.png"))); // NOI18N
        EditB.setText("EDIT");
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBActionPerformed(evt);
            }
        });

        DeleteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        DeleteB.setText("DELETE");
        DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-30.png"))); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        kohaButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kohaButton.setBorder(new javax.swing.border.MatteBorder(null));
        kohaButton.setFocusCycleRoot(true);
        kohaButton.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout faturaBackgroundPanelLayout = new javax.swing.GroupLayout(faturaBackgroundPanel);
        faturaBackgroundPanel.setLayout(faturaBackgroundPanelLayout);
        faturaBackgroundPanelLayout.setHorizontalGroup(
            faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faturaBackgroundPanelLayout.createSequentialGroup()
                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faturaBackgroundPanelLayout.createSequentialGroup()
                                .addComponent(kohaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(309, 309, 309))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faturaBackgroundPanelLayout.createSequentialGroup()
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(SaveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120)
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(CmimimeTVSHLABEL)
                                    .addComponent(CmimiLabel)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProduktiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BiznesiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(CmimimeTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(CmimiField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(SasiaFat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteALL))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, faturaBackgroundPanelLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TOTALI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PRINT))
                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120))
        );

        faturaBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DeleteALL, PRINT});

        faturaBackgroundPanelLayout.setVerticalGroup(
            faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(DeleteALL))
                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                        .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kohaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                        .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(SaveButton)
                                            .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(BiznesiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(CancelButton))
                                    .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ProduktiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addGap(30, 30, 30)
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DeleteB)
                                    .addComponent(CmimimeTVSHLABEL)
                                    .addComponent(CmimimeTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addComponent(EditB))
                            .addGroup(faturaBackgroundPanelLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CmimiLabel)
                                    .addComponent(CmimiField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SasiaFat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(faturaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TOTALI)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRINT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        faturaBackgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmimiField, CmimimeTVSH, ProduktiBox, SasiaFat, jLabel1, jLabel6, jLabel7});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(faturaBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(faturaBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProduktiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProduktiBoxActionPerformed
        CmimiField.setText(((Produkti) ProduktiBox.getSelectedItem()).getCmimi().toString());
        BigDecimal per = new BigDecimal("100.00");
        BigDecimal TVSH = new BigDecimal("18.00");
        BigDecimal shuma = new BigDecimal(CmimiField.getText()).divide(per);
        BigDecimal perqindja = shuma.multiply(TVSH);
        BigDecimal ppp = perqindja.add(new BigDecimal(CmimiField.getText()));
        String asd = ppp.toString();
        CmimimeTVSH.setText(asd.substring(0, asd.length() - 2));
    }//GEN-LAST:event_ProduktiBoxActionPerformed

    private void TOTALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOTALIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TOTALIActionPerformed

    private void BiznesiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BiznesiBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BiznesiBoxActionPerformed

    public boolean SimboletSasia() {
        int COUNT = 0;
        char[] shkronjat = SasiaFat.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }

        }
        if (COUNT == SasiaFat.getText().length()) {
            return true;
        }
        return false;

    }


    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try {
            if (CmimiField.getText().equals("") || CmimimeTVSH.getText().equals("") || SasiaFat.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar (OBLIGATIVE).");
            } else if (Kontrolleri != 0 && egzistonBiznesi() == false) {
                JOptionPane.showMessageDialog(this, "Fatura procesohet vetem per nje Biznes.");
                return;
            } else {
                Faktura f = new Faktura();

                f.setProduktiID((Produkti) ProduktiBox.getSelectedItem());
                f.setBiznesiID((Biznesi) BiznesiBox.getSelectedItem());
                f.setCmimi(new BigDecimal(CmimiField.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                f.setCmimimeTVSH(new BigDecimal(CmimimeTVSH.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                f.setData(new Date());
                if (Integer.parseInt(SasiaFat.getText()) == 0) {
                    JOptionPane.showMessageDialog(this, "Sasia nuk lejohet te jete 0.");
                    return;
                } else if (SimboletSasia() == false) {
                    JOptionPane.showMessageDialog(this, "Rubrika e Sasisë përmban simbole joValide");
                    return;
                } else {
                    f.setSasia(new BigDecimal(SasiaFat.getText()));
                }
                f.setBarkodi(((Produkti) ProduktiBox.getSelectedItem()).getBarkodi());
                tot = tot.add(new BigDecimal(CmimimeTVSH.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                String asd1 = tot.toString();
                TOTALI.setText(asd1);
                //-------------------------------------------//
                int[] KontrolleratStoku = {0, 0, 0, 0,};
                List<Stoku> lista = str.findAll();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getProduktiID().equals((Produkti) ProduktiBox.getSelectedItem())) {
                        KontrolleratStoku[0]++;
                        System.out.println(KontrolleratStoku[0]);
                        int rez = lista.get(i).getPaketa().compareTo(new BigDecimal(SasiaFat.getText()));
                        if (rez == 0 || rez == 1) {
                            BigDecimal paketaZbritje = lista.get(i).getPaketa().subtract(new BigDecimal(SasiaFat.getText()));
                            lista.get(i).setPaketa(paketaZbritje);
                            str.edit(lista.get(i));
                            KontrolleratStoku[1]++;
                        }
                        BigDecimal copaPaket = ((Produkti) ProduktiBox.getSelectedItem()).getCope().multiply(new BigDecimal(SasiaFat.getText()));
                        int rez2 = lista.get(i).getCope().compareTo(copaPaket);
                        if (rez2 == 0 || rez2 == 1) {
                            BigDecimal copaZbritje = lista.get(i).getCope().subtract(copaPaket);
                            lista.get(i).setCope(copaZbritje);
                            str.edit(lista.get(i));
                            KontrolleratStoku[2]++;
                        }
                        BigDecimal palet = new BigDecimal("1.0");
                        BigDecimal koificienti = palet.divide(((Produkti) ProduktiBox.getSelectedItem()).getPaketa(), 2, RoundingMode.CEILING);
                        BigDecimal sasiPaketPalet = new BigDecimal(SasiaFat.getText());
                        BigDecimal copaPalet = koificienti.multiply(new BigDecimal(SasiaFat.getText()));
                        int rez3 = lista.get(i).getPalete().compareTo(copaPalet);
                        if (rez3 == 0 || rez3 == 1) {
                            BigDecimal PaletZbrtije = lista.get(i).getPalete().subtract(copaPalet);
                            lista.get(i).setPalete(PaletZbrtije);
                            str.edit(lista.get(i));
                            KontrolleratStoku[3]++;
                        }
                    }
                }
                if (KontrolleratStoku[0] == 0) {
                    JOptionPane.showMessageDialog(this, "Produkti nuk egziston ne Stok.");
                    pastroFushat();
                    return;
                }
                if (KontrolleratStoku[1] == 0 && KontrolleratStoku[2] == 0 && KontrolleratStoku[3] == 0) {
                    JOptionPane.showMessageDialog(this, "Nuk ka sasi të mjaftushme te këtij Produkti në Stok.");
                    pastroFushat();
                    return;
                }
                fi.create(f);
                Kontrolleri++;
                shfaqTabelen();
                try {
                    pastroFushat();
                } catch (ProduktiException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        try {
            int row = FakturaT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    Faktura f = t.getFaktura(row);
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiBox.getSelectedItem())) {
                            lista.get(i).setPaketa(new BigDecimal(SasiaFat.getText()).add(lista.get(i).getPaketa()));
                            BigDecimal shumaCopa = ((Produkti) ProduktiBox.getSelectedItem()).getCope().multiply(new BigDecimal(SasiaFat.getText()));
                            lista.get(i).setCope(lista.get(i).getCope().add(shumaCopa));
                            BigDecimal palet = new BigDecimal("1.00");
                            BigDecimal koificienti = palet.divide(((Produkti) ProduktiBox.getSelectedItem()).getPaketa(), 2, RoundingMode.CEILING);
                            BigDecimal shumaEkthyer = koificienti.multiply(new BigDecimal(SasiaFat.getText()));
                            lista.get(i).setPalete(lista.get(i).getPalete().add(shumaEkthyer));
                            str.edit(lista.get(i));
                        }
                    }
                    if (tot.intValue() > 0 && maxvlere() == true) {
                        tot = tot.subtract(new BigDecimal(CmimimeTVSH.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                        String asd1 = tot.toString();
                        TOTALI.setText(asd1);
                    }
                    fi.remove(f);
                    Kontrolleri--;

                    try {
                        pastroFushat();
                    } catch (ProduktiException ex) {
                        ex.printStackTrace();
                    }
                    shfaqTabelen();

                }
            } else {
                JOptionPane.showMessageDialog(this, "Ju nuk keni selektuar asgje.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteBActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed

        try {
            pastroFushat();
        } catch (ProduktiException ex) {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void DeleteALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteALLActionPerformed
        try {
            DeleteAllF();
        } catch (FaturaException ex) {
            ex.printStackTrace();
        }
        try {
            pastroFushat();
        } catch (ProduktiException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_DeleteALLActionPerformed

    private void PRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTActionPerformed
        try {
            printoFaturen();
        } catch (FaturaException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_PRINTActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        try {
            int row = FakturaT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, " \"KUJDES\" Editimi nuk ka kthim mbrapa?", "Editimi", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {

                    if (CmimiField.getText().equals("") || CmimimeTVSH.getText().equals("") || SasiaFat.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar (OBLIGATIVE).");
                    } else if (Kontrolleri != 0 && egzistonBiznesi() == false) {
                        JOptionPane.showMessageDialog(this, "Fatura procesohet vetem per nje Biznes.");
                        return;
                    } else {
                        Faktura f = new Faktura();
//                 f.setFakturaID(Integer.parseInt(IDField.getText()));

                        f.setProduktiID((Produkti) ProduktiBox.getSelectedItem());
                        f.setBiznesiID((Biznesi) BiznesiBox.getSelectedItem());
                        f.setCmimi(new BigDecimal(CmimiField.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                        f.setCmimimeTVSH(new BigDecimal(CmimimeTVSH.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                        f.setData(new Date());
                        if (SimboletSasia() == true) {
                            f.setSasia(new BigDecimal(SasiaFat.getText()));
                        } else {
                            JOptionPane.showMessageDialog(this, "Rubrika e Sasisë përmban simbole joValide");
                            return;
                        }
                        f.setBarkodi(((Produkti) ProduktiBox.getSelectedItem()).getBarkodi());
                        tot = tot.add(new BigDecimal(CmimimeTVSH.getText()).multiply(new BigDecimal(SasiaFat.getText())));
                        String asd1 = tot.toString();
                        TOTALI.setText(asd1);
                        //-------------------------------------------//
                        int[] KontrolleratStoku = {0, 0, 0, 0,};
                        List<Stoku> lista = str.findAll();
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getProduktiID().equals((Produkti) ProduktiBox.getSelectedItem())) {
                                KontrolleratStoku[0]++;
                                int rez = lista.get(i).getPaketa().compareTo(new BigDecimal(SasiaFat.getText()));
                                if (rez == 0 || rez == 1) {
                                    BigDecimal paketaZbritje = lista.get(i).getPaketa().subtract(new BigDecimal(SasiaFat.getText()));
                                    lista.get(i).setPaketa(paketaZbritje);
                                    str.edit(lista.get(i));
                                    KontrolleratStoku[1]++;
                                }
                                BigDecimal copaPaket = ((Produkti) ProduktiBox.getSelectedItem()).getCope().multiply(new BigDecimal(SasiaFat.getText()));
                                int rez2 = lista.get(i).getCope().compareTo(copaPaket);
                                if (rez2 == 0 || rez2 == 1) {
                                    BigDecimal copaZbritje = lista.get(i).getCope().subtract(copaPaket);
                                    lista.get(i).setCope(copaZbritje);
                                    str.edit(lista.get(i));
                                    KontrolleratStoku[2]++;
                                }
                                BigDecimal palet = new BigDecimal("1.0");
                                BigDecimal koificienti = palet.divide(((Produkti) ProduktiBox.getSelectedItem()).getPaketa(), 2, RoundingMode.CEILING);
                                BigDecimal sasiPaketPalet = new BigDecimal(SasiaFat.getText());
                                BigDecimal copaPalet = koificienti.multiply(new BigDecimal(SasiaFat.getText()));
                                int rez3 = lista.get(i).getPalete().compareTo(copaPalet);
                                if (rez3 == 0 || rez3 == 1) {
                                    BigDecimal PaletZbrtije = lista.get(i).getPalete().subtract(copaPalet);
                                    lista.get(i).setPalete(PaletZbrtije);
                                    str.edit(lista.get(i));
                                    KontrolleratStoku[3]++;
                                }
                            }
                        }
                        if (KontrolleratStoku[0] == 0) {
                            JOptionPane.showMessageDialog(this, "Produkti nuk egziston ne Stok.");
                            return;
                        }
                        if (KontrolleratStoku[1] == 0 && KontrolleratStoku[2] == 0 && KontrolleratStoku[3] == 0) {
                            JOptionPane.showMessageDialog(this, "Nuk ka sasi të mjaftushme te këtij Produkti në Stok.");
                            return;
                        }
                        fi.edit(f);
                        Kontrolleri++;
                        shfaqTabelen();
                        try {
                            pastroFushat();
                        } catch (ProduktiException ex) {
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_EditBActionPerformed

    private void SasiaFatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SasiaFatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SasiaFatActionPerformed

//    public boolean vlene() {
//
//        for (int i = 0; i < IDField.getText().length(); i++) {
//            if (IDField.getText().charAt(i) < '0' || IDField.getText().charAt(i) > '9') {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean maxvlere() {
        int rez;
        rez = tot.compareTo(new BigDecimal(CmimimeTVSH.getText()));
        if (rez == 1 || rez == 0) {
            return true;
        }
        return false;
    }

    //no need metod.//
    public void clear() {
        FakturaT.setModel(new DefaultTableModel(null, new String[]{"ID", "Biznesi", "Produkti", "C.MeTvsh", "Cmimi", "Data"}));
    }

    public boolean egzistonBiznesi() throws FaturaException {
        List<Faktura> lista = fi.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getBiznesiID().equals((Biznesi) BiznesiBox.getSelectedItem())) {
                return true;
            }
        }
        return false;
    }

    private void printoFaturen() throws FaturaException {
        int choice;
        int count = 1;
        choice = JOptionPane.showConfirmDialog(null, "Deshironi ta shtypni Faturen.", "Kujdes!", JOptionPane.INFORMATION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            if (TOTALI.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Krijoni nje Fature, para se ta shtypni.");
                return;
            }
            Format formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
            String sdata = formatter.format(new Date());
            String string1 = "Fatura   " + count;
            String asd = TOTALI.getText().toString();
            String string2 = "TOTALI = " + asd + "  €" + "             " + sdata + "                                       Nenshkrimi:_________________";
            MessageFormat m1 = new MessageFormat(string1);
            MessageFormat m2 = new MessageFormat(string2);
            Double pp = Double.parseDouble(TOTALI.getText());
            if (pp <= 30.00) {
                JOptionPane.showMessageDialog(this, "Totali duhet te jete mbi 30 €, qe te shtypet fatura.");
            } else {
                try {
                    FakturaT.print(JTable.PrintMode.FIT_WIDTH, m1, m2);
                    //-------------------------------------------------------------//
                    List<Faktura> lista2 = fi.findAll();
                    Biznesi b = new Biznesi();
                    Shitjet sh = new Shitjet();

                    sh.setData(new Date());
                    BigDecimal totalipaTvsh = new BigDecimal("0.00");
                    BigDecimal totaliMeTvsh = new BigDecimal("0.00");
                    BigDecimal sasiaMePaket = new BigDecimal("0.00");
                    for (int v = 0; v < lista2.size(); v++) {
                        b = lista2.get(v).getBiznesiID();
                        totalipaTvsh = totalipaTvsh.add(lista2.get(v).getCmimi());
                        totaliMeTvsh = totaliMeTvsh.add(lista2.get(v).getCmimimeTVSH());
                        sasiaMePaket = sasiaMePaket.add(lista2.get(v).getSasia());
                    }
                    sh.setBiznesiID(b);
                    sh.setCmimipaTvsh(totalipaTvsh);
                    sh.setCmimimeTvsh(totaliMeTvsh);
                    sh.setSasiaPaket(sasiaMePaket);
                    sh.setTotali(totaliMeTvsh);
                    shr.create(sh);

                    List<Faktura> lista = fi.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        fi.remove(lista.get(i));
                        Kontrolleri--;
                    }
                    shfaqTabelen();

                    TOTALI.setText("");
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                count++;
            }
        }

    }

    public void DeleteAllF() throws FaturaException {

        int result2;
        Object[] ob = {"Po", "Jo"};
        result2 = JOptionPane.showOptionDialog(this, "A dëshironi ti fshini te gjitha te dhenat ne tabele ?", "DeleteAll", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
        if (result2 == 0) {

            List<Faktura> lista;
            lista = fi.findAll();
            for (int i = 0; i < lista.size(); i++) {
                fi.remove(lista.get(i));
                Kontrolleri--;
            }
            shfaqTabelen();
            TOTALI.setText("");
        }
    }

    public void time() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String texte_date = sdf.format(new Date());
                kohaButton.setText(texte_date);
            }
        }).start();

    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = FakturaT.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Faktura f = t.getFaktura(selectedIndex);
//                        IDFIELD.setText(f.getFakturaID()-1+"");
                    CmimiField.setText(f.getCmimi() + "");
                    CmimimeTVSH.setText(f.getCmimimeTVSH() + "");
                    SasiaFat.setText(f.getSasia() + "");
                    try {
                        loadbox();
                    } catch (ProduktiException ex) {
                        Logger.getLogger(FakturaForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadbox2();
                    ProduktiBox.setSelectedItem(f.getProduktiID());
                    BiznesiBox.setSelectedItem(f.getBiznesiID());
                }
            }
        });
    }
//    Metoda qe nuk e len jInternalFormen(FakturaForm) mu ba drag. Inicializohet ne konstruktor. -rm

    private void disableFakturaFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox BiznesiBox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField CmimiField;
    private javax.swing.JLabel CmimiLabel;
    private javax.swing.JTextField CmimimeTVSH;
    private javax.swing.JLabel CmimimeTVSHLABEL;
    private javax.swing.JButton DeleteALL;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JTable FakturaT;
    private javax.swing.JButton PRINT;
    private javax.swing.JComboBox ProduktiBox;
    private javax.swing.JTextField SasiaFat;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField TOTALI;
    private javax.swing.JPanel faturaBackgroundPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kohaButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
