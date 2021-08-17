package gui.view;

import Exceptions.FaturaException;
import Exceptions.FaturaHyreseException;
import Exceptions.KomunaException;
import Exceptions.ProduktiException;
import Exceptions.QytetiException;
import Exceptions.StokuException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PunetoriMainForm extends javax.swing.JFrame {

    public PunetoriMainForm() {
        initComponents();

        setFullScreen();//KJO
        setFormInMiddle();//KJO

    }

    //KJO
    private void setFullScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);

    }

    //KJO
    private void setFormInMiddle() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        punetoriAdministrateBackground = new javax.swing.JPanel();
        HyrjetBtn = new javax.swing.JButton();
        ShitjetBtn = new javax.swing.JButton();
        StokuBtn = new javax.swing.JButton();
        LokacionetBtn = new javax.swing.JButton();
        ProduktetBtn = new javax.swing.JButton();
        faturaHyreseBtn = new javax.swing.JButton();
        FaturaDaleseBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        icds_logo = new javax.swing.JLabel();
        lg = new javax.swing.JButton();
        emriPuntorit = new javax.swing.JLabel();
        pozitaPuntorit = new javax.swing.JLabel();
        kohaKyqjes = new javax.swing.JLabel();
        emriPunetoritJlabel = new javax.swing.JLabel();
        pozitaPunetoritJlabel = new javax.swing.JLabel();
        kohaKyqjesField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setResizable(false);

        punetoriAdministrateBackground.setBackground(new java.awt.Color(153, 153, 255));
        punetoriAdministrateBackground.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        HyrjetBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        HyrjetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/Hyrjet_vectorized.png"))); // NOI18N
        HyrjetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HyrjetBtnActionPerformed(evt);
            }
        });

        ShitjetBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ShitjetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/shitjet_vectorized.png"))); // NOI18N
        ShitjetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShitjetBtnActionPerformed(evt);
            }
        });

        StokuBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        StokuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/stoku_vectorized.png"))); // NOI18N
        StokuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StokuBtnActionPerformed(evt);
            }
        });

        LokacionetBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LokacionetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/lokacionet_vectorized_vectorized.png"))); // NOI18N
        LokacionetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LokacionetBtnActionPerformed(evt);
            }
        });

        ProduktetBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ProduktetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/produktet_vectorized.png"))); // NOI18N
        ProduktetBtn.setBorderPainted(false);
        ProduktetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProduktetBtnActionPerformed(evt);
            }
        });

        faturaHyreseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        faturaHyreseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/faturaHyrese_vectorized.png"))); // NOI18N
        faturaHyreseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faturaHyreseBtnActionPerformed(evt);
            }
        });

        FaturaDaleseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FaturaDaleseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/faturaDalese_vectorized.png"))); // NOI18N
        FaturaDaleseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FaturaDaleseBtnMouseEntered(evt);
            }
        });
        FaturaDaleseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FaturaDaleseBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(124, 124, 255));

        icds_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/main_logo_250.png"))); // NOI18N

        lg.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-export-48.png"))); // NOI18N
        lg.setText("LOG OUT");
        lg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgActionPerformed(evt);
            }
        });

        emriPuntorit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        emriPuntorit.setForeground(new java.awt.Color(0, 0, 0));
        emriPuntorit.setText("Emri i punëtorit:");

        pozitaPuntorit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pozitaPuntorit.setForeground(new java.awt.Color(0, 0, 0));
        pozitaPuntorit.setText("Pozita e punëtorit:");

        kohaKyqjes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        kohaKyqjes.setForeground(new java.awt.Color(0, 0, 0));
        kohaKyqjes.setText("Koha e kyqjes:");

        emriPunetoritJlabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        pozitaPunetoritJlabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        kohaKyqjesField.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(45, 45, 45));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/ADM_vectorized.png"))); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(45, 45, 45));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icds_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kohaKyqjes)
                    .addComponent(pozitaPuntorit)
                    .addComponent(emriPuntorit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(emriPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pozitaPunetoritJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kohaKyqjesField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(lg)
                        .addGap(17, 17, 17))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emriPuntorit)
                            .addComponent(emriPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lg, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pozitaPuntorit)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(pozitaPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kohaKyqjes)
                            .addComponent(kohaKyqjesField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icds_logo)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout punetoriAdministrateBackgroundLayout = new javax.swing.GroupLayout(punetoriAdministrateBackground);
        punetoriAdministrateBackground.setLayout(punetoriAdministrateBackgroundLayout);
        punetoriAdministrateBackgroundLayout.setHorizontalGroup(
            punetoriAdministrateBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(punetoriAdministrateBackgroundLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(faturaHyreseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(FaturaDaleseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HyrjetBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShitjetBtn)
                .addGap(12, 12, 12)
                .addComponent(LokacionetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(punetoriAdministrateBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StokuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProduktetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        punetoriAdministrateBackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FaturaDaleseBtn, HyrjetBtn, ShitjetBtn});

        punetoriAdministrateBackgroundLayout.setVerticalGroup(
            punetoriAdministrateBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(punetoriAdministrateBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(punetoriAdministrateBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LokacionetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(punetoriAdministrateBackgroundLayout.createSequentialGroup()
                        .addComponent(ProduktetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StokuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ShitjetBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FaturaDaleseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(faturaHyreseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HyrjetBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );

        jDesktopPane1.setLayer(punetoriAdministrateBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(punetoriAdministrateBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(punetoriAdministrateBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FaturaDaleseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FaturaDaleseBtnActionPerformed
        FakturaForm ff = null;
        try {
            try {
                ff = new FakturaForm();
            } catch (FaturaException ex) {
                Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ProduktiException ex) {
            Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDesktopPane1.add(ff);
        ff.show();
    }//GEN-LAST:event_FaturaDaleseBtnActionPerformed

    private void ProduktetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProduktetBtnActionPerformed
        ProduktiForm pf = null;
        try {
            pf = new ProduktiForm();
        } catch (ProduktiException ex) {
            Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StokuException ex) {
            Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDesktopPane1.add(pf);
        pf.show();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = pf.getSize();
        pf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_ProduktetBtnActionPerformed


    private void lgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgActionPerformed
        try {
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Deshironi te dilni?", "Logout", JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                LogIn a = new LogIn();
                a.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lgActionPerformed

    private void LokacionetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LokacionetBtnActionPerformed
        try {
            QytetiForm qf = null;

            try {
                qf = new QytetiForm();
            } catch (KomunaException ex) {
                Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPane1.add(qf);
            qf.show();
            /*
            Dimension desktopSize = jDesktopPane1.getSize();
            Dimension jInternalFrameSize = qf.getSize();
            qf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
             */
        } catch (QytetiException ex) {
        }
    }//GEN-LAST:event_LokacionetBtnActionPerformed

    private void faturaHyreseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faturaHyreseBtnActionPerformed
        try {
            FaturaHyreseForm fh = null;

            try {
                fh = new FaturaHyreseForm();
            } catch (FaturaHyreseException ex) {
                Logger.getLogger(PunetoriMainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            jDesktopPane1.add(fh);
            fh.show();
            /*
            Dimension desktopSize = jDesktopPane1.getSize();
            Dimension jInternalFrameSize = fh.getSize();
            fh.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
             */
        } catch (ProduktiException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_faturaHyreseBtnActionPerformed

    private void StokuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StokuBtnActionPerformed
        StokuForm sf = new StokuForm();
        jDesktopPane1.add(sf);
        sf.show();
        /*
       Dimension desktopSize = jDesktopPane1.getSize();
            Dimension jInternalFrameSize = sf.getSize();
            sf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
         */

    }//GEN-LAST:event_StokuBtnActionPerformed

    private void ShitjetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShitjetBtnActionPerformed
        ShitjetForm shf = new ShitjetForm();
        jDesktopPane1.add(shf);
        shf.show();
        /*
        Dimension desktopSize = jDesktopPane1.getSize();
            Dimension jInternalFrameSize = shf.getSize();
            shf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
         */
    }//GEN-LAST:event_ShitjetBtnActionPerformed

    private void HyrjetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HyrjetBtnActionPerformed
        HyrjetForm hf = new HyrjetForm();
        jDesktopPane1.add(hf);
        hf.show();
        /*
        Dimension desktopSize = jDesktopPane1.getSize();
            Dimension jInternalFrameSize = hf.getSize();
            hf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
         */


    }//GEN-LAST:event_HyrjetBtnActionPerformed

    private void FaturaDaleseBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FaturaDaleseBtnMouseEntered

    }//GEN-LAST:event_FaturaDaleseBtnMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PunetoriMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PunetoriMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PunetoriMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PunetoriMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PunetoriMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FaturaDaleseBtn;
    private javax.swing.JButton HyrjetBtn;
    private javax.swing.JButton LokacionetBtn;
    private javax.swing.JButton ProduktetBtn;
    private javax.swing.JButton ShitjetBtn;
    private javax.swing.JButton StokuBtn;
    public static javax.swing.JLabel emriPunetoritJlabel;
    private javax.swing.JLabel emriPuntorit;
    private javax.swing.JButton faturaHyreseBtn;
    private javax.swing.JLabel icds_logo;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel kohaKyqjes;
    public static javax.swing.JLabel kohaKyqjesField;
    private javax.swing.JButton lg;
    public static javax.swing.JLabel pozitaPunetoritJlabel;
    private javax.swing.JLabel pozitaPuntorit;
    private javax.swing.JPanel punetoriAdministrateBackground;
    // End of variables declaration//GEN-END:variables

}
