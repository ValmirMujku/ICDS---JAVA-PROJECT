/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import Exceptions.PunetoriException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PunetoriMenaxherMainForm extends javax.swing.JFrame {

    public static int idPunetoritSave;

    public static String u;
    public static String usernameId;
    public static String passwordUsr;

    public PunetoriMenaxherMainForm() {
        initComponents();
        setTitle("Punetori - Menaxher - Main Form");

        setFullScreen();//KJO
        setFormInMiddle();//KJO

        singOutIconPosition();
    }

    private void setFullScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);

    }

    private void setFormInMiddle() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        background_panel_main = new javax.swing.JPanel();
        menaxho_Punetoret_Main = new javax.swing.JButton();
        menaxho_Klientet_Main = new javax.swing.JButton();
        background_panel_upper = new javax.swing.JPanel();
        main_logo = new javax.swing.JLabel();
        emriPunetoritJlabel = new javax.swing.JLabel();
        pozitaPunetoritJlabel = new javax.swing.JLabel();
        emriPuntorit = new javax.swing.JLabel();
        pozitaPuntorit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kohaKyqjes = new javax.swing.JLabel();
        kohaKyqjesField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        logoutBtnMenaxheri = new javax.swing.JButton();
        profiliImBtn = new javax.swing.JButton();
        menaxho_Pozitat_Main = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1205, 605));
        setResizable(false);

        desktopPane.setMinimumSize(new java.awt.Dimension(1205, 594));
        desktopPane.setRequestFocusEnabled(false);
        desktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desktopPaneMouseEntered(evt);
            }
        });

        background_panel_main.setBackground(new java.awt.Color(153, 153, 255));
        background_panel_main.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_panel_main.setMinimumSize(new java.awt.Dimension(1205, 594));
        background_panel_main.setPreferredSize(new java.awt.Dimension(1205, 594));
        background_panel_main.setVerifyInputWhenFocusTarget(false);

        menaxho_Punetoret_Main.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        menaxho_Punetoret_Main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/menaxhopunetoret_vectorized.png"))); // NOI18N
        menaxho_Punetoret_Main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menaxho_Punetoret_MainMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menaxho_Punetoret_MainMousePressed(evt);
            }
        });
        menaxho_Punetoret_Main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menaxho_Punetoret_MainActionPerformed(evt);
            }
        });

        menaxho_Klientet_Main.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        menaxho_Klientet_Main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/menaxhoKlientet_vectorized.png"))); // NOI18N
        menaxho_Klientet_Main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menaxho_Klientet_MainActionPerformed(evt);
            }
        });

        background_panel_upper.setBackground(new java.awt.Color(124, 124, 255));
        background_panel_upper.setMaximumSize(new java.awt.Dimension(1204, 151));
        background_panel_upper.setMinimumSize(new java.awt.Dimension(1204, 151));
        background_panel_upper.setPreferredSize(new java.awt.Dimension(1204, 151));

        main_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/main_logo_250.png"))); // NOI18N

        emriPunetoritJlabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        pozitaPunetoritJlabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        emriPuntorit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        emriPuntorit.setForeground(new java.awt.Color(0, 0, 0));
        emriPuntorit.setText("Emri i punëtorit:");

        pozitaPuntorit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pozitaPuntorit.setForeground(new java.awt.Color(0, 0, 0));
        pozitaPuntorit.setText("Pozita e punëtorit:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/punetoriMainLOGO.png"))); // NOI18N

        kohaKyqjes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        kohaKyqjes.setForeground(new java.awt.Color(0, 0, 0));
        kohaKyqjes.setText("Koha e kyqjes:");

        kohaKyqjesField.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(17, 17, 17));
        jSeparator1.setForeground(new java.awt.Color(17, 17, 17));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);

        jSeparator2.setBackground(new java.awt.Color(17, 17, 17));
        jSeparator2.setForeground(new java.awt.Color(17, 17, 17));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        logoutBtnMenaxheri.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        logoutBtnMenaxheri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-export-48.png"))); // NOI18N
        logoutBtnMenaxheri.setText("LOG OUT");
        logoutBtnMenaxheri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnMenaxheriActionPerformed(evt);
            }
        });

        profiliImBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        profiliImBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-male-user-40.png"))); // NOI18N
        profiliImBtn.setText("PROFILI IM");
        profiliImBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profiliImBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_panel_upperLayout = new javax.swing.GroupLayout(background_panel_upper);
        background_panel_upper.setLayout(background_panel_upperLayout);
        background_panel_upperLayout.setHorizontalGroup(
            background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_panel_upperLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(main_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pozitaPuntorit)
                    .addComponent(emriPuntorit)
                    .addComponent(kohaKyqjes))
                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_panel_upperLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(emriPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_panel_upperLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kohaKyqjesField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pozitaPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutBtnMenaxheri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profiliImBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        background_panel_upperLayout.setVerticalGroup(
            background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_panel_upperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_panel_upperLayout.createSequentialGroup()
                        .addComponent(logoutBtnMenaxheri, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profiliImBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(main_logo)
                        .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(background_panel_upperLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emriPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emriPuntorit))
                                .addGap(18, 18, 18)
                                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pozitaPuntorit)
                                    .addComponent(pozitaPunetoritJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(background_panel_upperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kohaKyqjes)
                                    .addComponent(kohaKyqjesField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        menaxho_Pozitat_Main.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        menaxho_Pozitat_Main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/menaxhoPozitat_vectorized.png"))); // NOI18N
        menaxho_Pozitat_Main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menaxho_Pozitat_MainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_panel_mainLayout = new javax.swing.GroupLayout(background_panel_main);
        background_panel_main.setLayout(background_panel_mainLayout);
        background_panel_mainLayout.setHorizontalGroup(
            background_panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_panel_mainLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(menaxho_Punetoret_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(menaxho_Klientet_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(menaxho_Pozitat_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
            .addComponent(background_panel_upper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        background_panel_mainLayout.setVerticalGroup(
            background_panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_panel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background_panel_upper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(background_panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menaxho_Klientet_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menaxho_Pozitat_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menaxho_Punetoret_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        desktopPane.add(background_panel_main);
        background_panel_main.setBounds(0, 0, 1370, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menaxho_Punetoret_MainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menaxho_Punetoret_MainActionPerformed
        try {
            PunetoriInternalForm pf = new PunetoriInternalForm();
            desktopPane.add(pf);
            pf.show();
            pf.setFocusable(true);
        } catch (PunetoriException ex) {

        }


    }//GEN-LAST:event_menaxho_Punetoret_MainActionPerformed

    private void singOutIconPosition() {
        logoutBtnMenaxheri.setHorizontalTextPosition(SwingConstants.LEFT);
        profiliImBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        logoutBtnMenaxheri.setIconTextGap(5);
        profiliImBtn.setIconTextGap(5);

    }
    private void menaxho_Pozitat_MainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menaxho_Pozitat_MainActionPerformed
        PozitaInternalForm pf = new PozitaInternalForm();
        desktopPane.add(pf);
        pf.show();
        pf.setFocusable(true);
    }//GEN-LAST:event_menaxho_Pozitat_MainActionPerformed

    private void menaxho_Punetoret_MainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menaxho_Punetoret_MainMouseEntered

    }//GEN-LAST:event_menaxho_Punetoret_MainMouseEntered

    private void desktopPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desktopPaneMouseEntered

    }//GEN-LAST:event_desktopPaneMouseEntered

    private void menaxho_Punetoret_MainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menaxho_Punetoret_MainMousePressed

    }//GEN-LAST:event_menaxho_Punetoret_MainMousePressed

    private void menaxho_Klientet_MainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menaxho_Klientet_MainActionPerformed
        KlientiInternalForm kiform = new KlientiInternalForm();
        desktopPane.add(kiform);
        kiform.show();
        kiform.setFocusable(true);
    }//GEN-LAST:event_menaxho_Klientet_MainActionPerformed

    private void logoutBtnMenaxheriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnMenaxheriActionPerformed
        try {
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Deshironi te dilni?", "Logout", JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                this.dispose();
                LogIn a = new LogIn();
                a.setVisible(true);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_logoutBtnMenaxheriActionPerformed

    private void profiliImBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profiliImBtnActionPerformed
        ProfiliImMenaxher pf = new ProfiliImMenaxher();
        desktopPane.add(pf);
        pf.show();
        pf.setFocusable(true);
    }//GEN-LAST:event_profiliImBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PunetoriMenaxherMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PunetoriMenaxherMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PunetoriMenaxherMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PunetoriMenaxherMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PunetoriMenaxherMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_panel_main;
    private javax.swing.JPanel background_panel_upper;
    public static javax.swing.JDesktopPane desktopPane;
    public static javax.swing.JLabel emriPunetoritJlabel;
    private javax.swing.JLabel emriPuntorit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel kohaKyqjes;
    public static javax.swing.JLabel kohaKyqjesField;
    private javax.swing.JButton logoutBtnMenaxheri;
    private javax.swing.JLabel main_logo;
    private javax.swing.JButton menaxho_Klientet_Main;
    private javax.swing.JButton menaxho_Pozitat_Main;
    private javax.swing.JButton menaxho_Punetoret_Main;
    public static javax.swing.JLabel pozitaPunetoritJlabel;
    private javax.swing.JLabel pozitaPuntorit;
    private javax.swing.JButton profiliImBtn;
    // End of variables declaration//GEN-END:variables

}
