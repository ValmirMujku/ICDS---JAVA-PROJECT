/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Biznesi;
import BLL.Komuna;
import BLL.LlojiiBiznesit;
import BLL.Qyteti;
import DAL.BiznesiInterface;
import DAL.BiznesiRepository;
import Exceptions.BiznesiException;
import DAL.KomunInterface;
import DAL.KomunaRepository;
import DAL.LlojiiBiznesitInterface;
import DAL.LlojiiBiznesitRepository;
import DAL.QytetiInterface;
import DAL.QytetiRepository;
import Exceptions.KomunaException;
import Exceptions.LlojiBiznesitException;
import Exceptions.QytetiException;
import gui.model.BiznesiTableModel;
import gui.model.KomunaComboBox;
import gui.model.LlojiiBiznesitComboBox;
import gui.model.QytetiComboBox;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class BiznesiInternalForm extends javax.swing.JInternalFrame {

    BiznesiInterface bi = new BiznesiRepository();
    BiznesiTableModel btm;
    QytetiInterface qoz = new QytetiRepository();
    KomunInterface kie = new KomunaRepository();
    LlojiiBiznesitInterface llbi = new LlojiiBiznesitRepository();

    /**
     * Creates new form BiznesiInternalForm
     */
    public BiznesiInternalForm() {
        initComponents();
        loadboxQytetet();
        loadboxKomunat();
        loadboxLlojetEBizneseve();
        try {
            loadTabelen();
        } catch (BiznesiException ex) {
            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
        }
        tabelaSelectedIndexChange();
        id_Field.setEditable(false);
        ndryshoPozicionetIconave();
        disableBiznesiFormDrag();

        setFormFullScren();//KJO
    }

    //KJO
    private void setFormFullScren() {
        int xsize = (int) gui.view.KlientiMainForm.desktopPane.getWidth();
        int ysize = (int) gui.view.KlientiMainForm.desktopPane.getHeight();
        this.setSize(xsize, ysize);
    }

    //KJO
    private void loadTabelen() throws BiznesiException {
        bi.findAll();
        List<Biznesi> list = bi.findAll();
        btm = new BiznesiTableModel(list);
        bizneset_table.setModel(btm);
        btm.fireTableDataChanged();

    }

    private void loadboxQytetet() {
        try {
            QytetiComboBox qx;
            List<Qyteti> lista = qoz.findAll();
            qx = new QytetiComboBox(lista);
            this.QytetiCombo.setModel(qx);
        } catch (QytetiException ex) {

        }

    }

    private void disableBiznesiFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    private void ndryshoPozicionetIconave() {
        ruajBiznesin_Btn.setHorizontalTextPosition(SwingConstants.LEFT);
        fshijBiznesin_Btn.setHorizontalTextPosition(SwingConstants.LEFT);
        pastroHapsirat_Btn.setHorizontalTextPosition(SwingConstants.LEFT);
        ruajBiznesin_Btn.setIconTextGap(10);
        fshijBiznesin_Btn.setIconTextGap(10);
        pastroHapsirat_Btn.setIconTextGap(10);
    }

    private void loadboxLlojetEBizneseve() {
        try {
            LlojiiBiznesitComboBox qx;
            List<LlojiiBiznesit> lista = llbi.findAll();
            qx = new LlojiiBiznesitComboBox(lista);
            this.LLojiIBiznesitComboBoxB.setModel(qx);
        } catch (LlojiBiznesitException ex) {

        }

    }

    private void loadboxKomunat() {
        try {
            KomunaComboBox qx;
            List<Komuna> lista = kie.findAll();
            qx = new KomunaComboBox(lista);
            this.KomunaCombo.setModel(qx);
        } catch (KomunaException e) {
            JOptionPane.showMessageDialog(this, "ICDS:" + e);
        }

    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = bizneset_table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Biznesi b = btm.getBiznesi(selectedIndex);
                    loadboxQytetet();
                    loadboxKomunat();
                    loadboxLlojetEBizneseve();
                    KomunaCombo.setSelectedItem(b.getKomuna());
                    QytetiCombo.setSelectedItem(b.getQyteti());
                    LLojiIBiznesitComboBoxB.setSelectedItem(b.getLloji());
                    id_Field.setText(b.getBiznesiID() + "");
                    emri_Field.setText(b.getEmri());
                }
            }
        });
    }

    private void pastroFields() {
        id_Field.setText("");
        emri_Field.setText("");
        bizneset_table.clearSelection();
        LLojiIBiznesitComboBoxB.setSelectedItem(null);
        QytetiCombo.setSelectedItem(null);
        KomunaCombo.setSelectedItem(null);

    }

    private static boolean kaVetemShkronja(String input) {
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_bizneset = new javax.swing.JPanel();
        ruajBiznesin_Btn = new javax.swing.JButton();
        fshijBiznesin_Btn = new javax.swing.JButton();
        pastroHapsirat_Btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id_Field = new javax.swing.JTextField();
        emri_Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LLojiIBiznesitComboBoxB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        QytetiCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        KomunaCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bizneset_table = new javax.swing.JTable();

        setClosable(true);
        setTitle("Menaxho Bizneset");
        setMinimumSize(new java.awt.Dimension(1205, 585));
        setNormalBounds(new java.awt.Rectangle(1205, 585, 585, 585));
        setPreferredSize(new java.awt.Dimension(1205, 585));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        background_bizneset.setBackground(new java.awt.Color(153, 153, 255));
        background_bizneset.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        ruajBiznesin_Btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ruajBiznesin_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        ruajBiznesin_Btn.setText("RUAJ BIZNESIN");
        ruajBiznesin_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruajBiznesin_BtnActionPerformed(evt);
            }
        });

        fshijBiznesin_Btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fshijBiznesin_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        fshijBiznesin_Btn.setText("FSHIJ BIZNESIN");
        fshijBiznesin_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijBiznesin_BtnActionPerformed(evt);
            }
        });

        pastroHapsirat_Btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pastroHapsirat_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-available-updates-30.png"))); // NOI18N
        pastroHapsirat_Btn.setText("PASTRO HAPSIRAT");
        pastroHapsirat_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroHapsirat_BtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("emri:");

        LLojiIBiznesitComboBoxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LLojiIBiznesitComboBoxBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("lloji i biznesit:");

        QytetiCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QytetiComboActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("qyteti:");

        KomunaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KomunaComboActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("komuna:");

        bizneset_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(bizneset_table);

        javax.swing.GroupLayout background_biznesetLayout = new javax.swing.GroupLayout(background_bizneset);
        background_bizneset.setLayout(background_biznesetLayout);
        background_biznesetLayout.setHorizontalGroup(
            background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_biznesetLayout.createSequentialGroup()
                .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_biznesetLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_biznesetLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emri_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(76, 76, 76)
                        .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(LLojiIBiznesitComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QytetiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(KomunaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(background_biznesetLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(ruajBiznesin_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(fshijBiznesin_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(pastroHapsirat_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(220, 220, 220))
        );
        background_biznesetLayout.setVerticalGroup(
            background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_biznesetLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruajBiznesin_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshijBiznesin_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pastroHapsirat_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background_biznesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KomunaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QytetiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emri_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LLojiIBiznesitComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_bizneset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_bizneset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fshijBiznesin_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijBiznesin_BtnActionPerformed
        int row = bizneset_table.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini punetorin ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    Biznesi b = btm.getBiznesi(row);
                    bi.remove(b);
                    loadTabelen();
                } catch (BiznesiException ex) {
                    JOptionPane.showMessageDialog(this, "ICDS:" + ex.getMessage());
                }
            }
            pastroFields();
            bizneset_table.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_fshijBiznesin_BtnActionPerformed

    private void KomunaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KomunaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KomunaComboActionPerformed

    private void QytetiComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QytetiComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QytetiComboActionPerformed

    private void LLojiIBiznesitComboBoxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LLojiIBiznesitComboBoxBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LLojiIBiznesitComboBoxBActionPerformed

    private void pastroHapsirat_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroHapsirat_BtnActionPerformed
        bizneset_table.clearSelection();
        pastroFields();
    }//GEN-LAST:event_pastroHapsirat_BtnActionPerformed

    private void ruajBiznesin_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruajBiznesin_BtnActionPerformed
        if (!emri_Field.getText().trim().equals("")) {
            int row = bizneset_table.getSelectedRow();
            if (row == -1) {
                Biznesi b = new Biznesi();

                String emriStandard = emri_Field.getText().replaceAll("\\s", "");

                if (kaVetemShkronja(emriStandard)) {
                    b.setEmri(emriStandard);
                    try {
                        if (LLojiIBiznesitComboBoxB.getSelectedItem() != null) {
                            b.setLloji((LlojiiBiznesit) LLojiIBiznesitComboBoxB.getSelectedItem());
                        } else {
                            JOptionPane.showMessageDialog(this, "ICDS: Ju lutem zgjidhni llogin e biznesit per ta regjistruar biznesin.");
                            return;
                        }
                        if (QytetiCombo.getSelectedItem() != null) {
                            b.setQyteti((Qyteti) QytetiCombo.getSelectedItem());
                        } else {
                            JOptionPane.showMessageDialog(this, "ICDS: Ju lutem zgjidhni qytetin per ta regjistruar biznesin.");
                            return;
                        }
                        if (KomunaCombo.getSelectedItem() != null) {
                            b.setKomuna((Komuna) KomunaCombo.getSelectedItem());
                        } else {
                            JOptionPane.showMessageDialog(this, "ICDS: Ju lutem zgjidhni komunen e biznesit per ta regjistruar biznesin.");
                            return;
                        }
                    } catch (HeadlessException ex) {
                        JOptionPane.showMessageDialog(this, "ICDS: Ju lutem zgjidhni llojin e biznesit, qytetin dhe komunen per ta regjistruar biznesin.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                bi.create(b);
            } else {
                Biznesi b = btm.getBiznesi(row);

                String emriStandard = emri_Field.getText().replaceAll("\\s", "");

                if (kaVetemShkronja(emriStandard)) {
                    b.setQyteti((Qyteti) QytetiCombo.getSelectedItem());
                    b.setLloji((LlojiiBiznesit) LLojiIBiznesitComboBoxB.getSelectedItem());
                    b.setKomuna((Komuna) KomunaCombo.getSelectedItem());
                    b.setEmri(emriStandard);

                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                bi.edit(b);
            }
            pastroFields();
            try {
                loadTabelen();
            } catch (BiznesiException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat jane obligative ti plotesoni per ta regjistruar biznesin e deshiruar!");
        }
    }//GEN-LAST:event_ruajBiznesin_BtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        bizneset_table.clearSelection();
        pastroFields();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox KomunaCombo;
    private javax.swing.JComboBox LLojiIBiznesitComboBoxB;
    public static javax.swing.JComboBox QytetiCombo;
    private javax.swing.JPanel background_bizneset;
    private javax.swing.JTable bizneset_table;
    private javax.swing.JTextField emri_Field;
    private javax.swing.JButton fshijBiznesin_Btn;
    private javax.swing.JTextField id_Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pastroHapsirat_Btn;
    private javax.swing.JButton ruajBiznesin_Btn;
    // End of variables declaration//GEN-END:variables
}
