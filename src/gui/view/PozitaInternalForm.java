/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Pozitat;
import Exceptions.PozitatException;
import DAL.PozitaInterface;
import DAL.PozitaRepository;
import gui.model.PozitatTableModel;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class PozitaInternalForm extends javax.swing.JInternalFrame {

    PozitatTableModel ptm;
    PozitaInterface poz = new PozitaRepository();

    /**
     * Creates new form PozitaInternalForm
     */
    public PozitaInternalForm() {
        initComponents();
        try {
            loadTabelen();
        } catch (PozitatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        tabelaSelectedIndexChange();
        id_field_poz.setEditable(false);
        ndryshoPozicionetIconave();
        disablePozitaFormDrag();

        setFormFullScren();//KJO
    }
    //KJO

    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getWidth();
        int ysize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getHeight();
        this.setSize(xsize, ysize);
    }

    public boolean ekzistonPozita() {
        try {
            String pozita = emri_field_poz.getText().trim();
            List<Pozitat> lista = poz.findAll();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getEmri().equals(pozita)) {
                    JOptionPane.showMessageDialog(this, "ICDS: Kjo pozitë është e regjistruar në kompani.");
                    return true;
                }
            }

        } catch (PozitatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return false;
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = pozitat_tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Pozitat p = ptm.getPozita(selectedIndex);
                    id_field_poz.setText(p.getPozitaID() + "");
                    emri_field_poz.setText(p.getEmri());

                }
            }
        });
    }

    private void ndryshoPozicionetIconave() {
        ruaj_Poziten.setHorizontalTextPosition(SwingConstants.LEFT);
        fshije_Poziten.setHorizontalTextPosition(SwingConstants.LEFT);
        pastro_Hapsirat.setHorizontalTextPosition(SwingConstants.LEFT);
        ruaj_Poziten.setIconTextGap(10);
        fshije_Poziten.setIconTextGap(10);
        pastro_Hapsirat.setIconTextGap(10);
    }

    private void disablePozitaFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    private void loadTabelen() throws PozitatException {
        poz.findAll();
        List<Pozitat> list = poz.findAll();
        ptm = new PozitatTableModel(list);
        pozitat_tabela.setModel(ptm);
        ptm.fireTableDataChanged();

    }

    private void pastroFields() {
        id_field_poz.setText("");
        emri_field_poz.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pozitaBackgroundPanel = new javax.swing.JPanel();
        ruaj_Poziten = new javax.swing.JButton();
        fshije_Poziten = new javax.swing.JButton();
        pastro_Hapsirat = new javax.swing.JButton();
        id_label_poz = new javax.swing.JLabel();
        id_field_poz = new javax.swing.JTextField();
        emri_label_poz = new javax.swing.JLabel();
        emri_field_poz = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pozitat_tabela = new javax.swing.JTable();

        setClosable(true);
        setTitle("Pozitat");
        setMinimumSize(new java.awt.Dimension(1205, 585));
        setPreferredSize(new java.awt.Dimension(1205, 585));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pozitaBackgroundPanel.setBackground(new java.awt.Color(153, 153, 255));

        ruaj_Poziten.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ruaj_Poziten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        ruaj_Poziten.setText("RUAJ POZITEN");
        ruaj_Poziten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruaj_PozitenActionPerformed(evt);
            }
        });

        fshije_Poziten.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fshije_Poziten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        fshije_Poziten.setText("FSHIJE POZITEN");
        fshije_Poziten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshije_PozitenActionPerformed(evt);
            }
        });

        pastro_Hapsirat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pastro_Hapsirat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-available-updates-30.png"))); // NOI18N
        pastro_Hapsirat.setText("PASTRO HAPSIRAT");
        pastro_Hapsirat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastro_HapsiratActionPerformed(evt);
            }
        });

        id_label_poz.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        id_label_poz.setText("id:");

        emri_label_poz.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        emri_label_poz.setText("emri i pozitës:");

        pozitat_tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(pozitat_tabela);

        javax.swing.GroupLayout pozitaBackgroundPanelLayout = new javax.swing.GroupLayout(pozitaBackgroundPanel);
        pozitaBackgroundPanel.setLayout(pozitaBackgroundPanelLayout);
        pozitaBackgroundPanelLayout.setHorizontalGroup(
            pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addGroup(pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_field_poz, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_label_poz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emri_label_poz)
                    .addComponent(emri_field_poz, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(308, 308, 308))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addGroup(pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(ruaj_Poziten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(fshije_Poziten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(pastro_Hapsirat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pozitaBackgroundPanelLayout.setVerticalGroup(
            pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pozitaBackgroundPanelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaj_Poziten, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pastro_Hapsirat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshije_Poziten, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(pozitaBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(id_label_poz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_field_poz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pozitaBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(emri_label_poz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emri_field_poz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pozitaBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pozitaBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pastro_HapsiratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastro_HapsiratActionPerformed

        pozitat_tabela.clearSelection();
        pastroFields();
    }//GEN-LAST:event_pastro_HapsiratActionPerformed

    private void fshije_PozitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshije_PozitenActionPerformed
        int row = pozitat_tabela.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini poziten ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    Pozitat p = ptm.getPozita(row);
                    poz.remove(p);
                    loadTabelen();
                } catch (PozitatException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            pastroFields();
            pozitat_tabela.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_fshije_PozitenActionPerformed

    @SuppressWarnings("empty-statement")
    private void ruaj_PozitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaj_PozitenActionPerformed
        if (!emri_field_poz.getText().equals("")) {
            int row = pozitat_tabela.getSelectedRow();
            if (row == -1) {
                Pozitat p = new Pozitat();

                String emriStandard = emri_field_poz.getText().replaceAll("\\s", "");

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);

                if (kaVetemShkronja(emriModified)) {
                    if (ekzistonPozita()) {
                        pastroFields();
                        return;
                    }
                    p.setEmri(emriModified);
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Emri duhet te permbaje vetem shkronja.");
                    emri_field_poz.setText("");
                    return;
                }
                try {
                    poz.create(p);
                    loadTabelen();
                } catch (PozitatException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

            } else {
                Pozitat p = ptm.getPozita(row);

                String emriStandard = emri_field_poz.getText().replaceAll("\\s", "");

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);

                if (kaVetemShkronja(emriModified)) {
                    if (ekzistonPozita()) {
                        pastroFields();
                        return;
                    }
                    p.setEmri(emriModified);
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Emri duhet te permbaje vetem shkronja.");
                    emri_field_poz.setText("");
                    return;
                }
                try {
                    poz.edit(p);
                    loadTabelen();
                } catch (PozitatException ex) {
                    JOptionPane.showMessageDialog(this, "ICDS: " + ex);
                }
                pastroFields();

            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat jane obligative ti plotesoni per ta regjistruar poziten e re!");
        }
    }//GEN-LAST:event_ruaj_PozitenActionPerformed
    private static boolean kaVetemShkronja(String input) {
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        pozitat_tabela.clearSelection();
        id_field_poz.setText("");
        emri_field_poz.setText("");
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emri_field_poz;
    private javax.swing.JLabel emri_label_poz;
    private javax.swing.JButton fshije_Poziten;
    private javax.swing.JTextField id_field_poz;
    private javax.swing.JLabel id_label_poz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pastro_Hapsirat;
    private javax.swing.JPanel pozitaBackgroundPanel;
    private javax.swing.JTable pozitat_tabela;
    private javax.swing.JButton ruaj_Poziten;
    // End of variables declaration//GEN-END:variables
}
