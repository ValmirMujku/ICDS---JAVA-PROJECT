/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Pozitat;
import BLL.Punetori;
import BLL.Users;
import Exceptions.PunetoriException;
import DAL.PozitaInterface;
import DAL.PozitaRepository;
import DAL.PunetoriInterface;
import DAL.PunetoriRepository;
import Exceptions.UsersException;
import DAL.UsersRepository;
import Exceptions.PozitatException;
import gui.model.PozitaComboBox;
import gui.model.PunetoretTableModel;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public final class PunetoriInternalForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PunetoriInternalForm
     */
    PunetoriInterface pri = new PunetoriRepository();
    PunetoretTableModel ptm;
    PozitaInterface poz = new PozitaRepository();

    public PunetoriInternalForm() throws PunetoriException {
        initComponents();
        loadTabelen();
        loadboxPozitat();
        tabelaSelectedIndexChange();
        idField.setEditable(false);
        LogInID.setEditable(false);
        ndryshoPozicionetIconave();
        addUsersInternalFrame();
        disablePunetoriFormDrag();
        setFormFullScren();

    }

    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getWidth();
        int ysize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getHeight();
        this.setSize(xsize, ysize);
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = punetori_tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Punetori p = ptm.getPunetori(selectedIndex);
                    loadboxPozitat();
                    PozitaComboBoxB.setSelectedItem(p.getPozita());
                    idField.setText(p.getPId() + "");
                    emriField.setText(p.getEmri());
                    mbiemriField.setText(p.getMbiemri());
                    try {
                        gjiniaCombo.setSelectedIndex(p.getGjinia());
                    } catch (IllegalArgumentException ill) {
                    }
                    adresaField.setText(p.getAdresa());
                    if (p.getMosha() != 0) {
                        moshaField.setText(p.getMosha() + "");
                    } else {
                        moshaField.setText("");
                    }
                }
            }
        });
    }

    private void loadboxPozitat() {
        try {
            PozitaComboBox px;
            List<Pozitat> lista = poz.findAll();
            px = new PozitaComboBox(lista);
            this.PozitaComboBoxB.setModel(px);
        } catch (PozitatException e) {
            JOptionPane.showMessageDialog(this, "ICDS:" + e);
        }

    }

    private void ndryshoPozicionetIconave() {
        ruaj_Punetorin_btn.setHorizontalTextPosition(SwingConstants.LEFT);
        fshije_Punetorin_btn.setHorizontalTextPosition(SwingConstants.LEFT);
        pastro_Hapsirat_btn.setHorizontalTextPosition(SwingConstants.LEFT);
        ruaj_Punetorin_btn.setIconTextGap(10);
        fshije_Punetorin_btn.setIconTextGap(10);
        pastro_Hapsirat_btn.setIconTextGap(10);
    }

    private void loadTabelen() throws PunetoriException {
        pri.findAll();
        List<Punetori> list = pri.findAll();
        ptm = new PunetoretTableModel(list);
        punetori_tabela.setModel(ptm);
        ptm.fireTableDataChanged();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_punetori = new javax.swing.JPanel();
        ruaj_Punetorin_btn = new javax.swing.JButton();
        fshije_Punetorin_btn = new javax.swing.JButton();
        pastro_Hapsirat_btn = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        emriField = new javax.swing.JTextField();
        emriLabel = new javax.swing.JLabel();
        mbiemriField = new javax.swing.JTextField();
        mbiemriLabel = new javax.swing.JLabel();
        moshaField = new javax.swing.JTextField();
        moshaLabel = new javax.swing.JLabel();
        gjiniaCombo = new javax.swing.JComboBox<>();
        gjiniaLabel = new javax.swing.JLabel();
        PozitaComboBoxB = new javax.swing.JComboBox();
        pozitaLabel = new javax.swing.JLabel();
        adresaField = new javax.swing.JTextField();
        adresaLabel = new javax.swing.JLabel();
        LogInID = new javax.swing.JTextField();
        loginPunetori_jlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        punetori_tabela = new javax.swing.JTable();
        info_jlabel = new javax.swing.JLabel();
        usersDesktopPane = new javax.swing.JDesktopPane();
        background_users_punetori = new javax.swing.JPanel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(1205, 585));
        setNormalBounds(new java.awt.Rectangle(0, 0, 953, 0));
        setPreferredSize(new java.awt.Dimension(1205, 585));
        setVisible(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        background_punetori.setBackground(new java.awt.Color(153, 153, 255));
        background_punetori.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_punetori.setMinimumSize(new java.awt.Dimension(1175, 594));
        background_punetori.setPreferredSize(new java.awt.Dimension(1175, 594));
        background_punetori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                background_punetoriMouseClicked(evt);
            }
        });

        ruaj_Punetorin_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ruaj_Punetorin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        ruaj_Punetorin_btn.setText("RUAJ PUNETORIN");
        ruaj_Punetorin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruaj_Punetorin_btnActionPerformed(evt);
            }
        });

        fshije_Punetorin_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fshije_Punetorin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        fshije_Punetorin_btn.setText("FSHIJE PUNETORIN");
        fshije_Punetorin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshije_Punetorin_btnActionPerformed(evt);
            }
        });

        pastro_Hapsirat_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pastro_Hapsirat_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-available-updates-30.png"))); // NOI18N
        pastro_Hapsirat_btn.setText("PASTRO HAPSIRAT");
        pastro_Hapsirat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastro_Hapsirat_btnActionPerformed(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        idLabel.setText("id:");

        emriLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        emriLabel.setText("emri:");

        mbiemriLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        mbiemriLabel.setText("mbiemri:");

        moshaLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        moshaLabel.setText("mosha:");

        gjiniaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mashkull", "Femer" }));

        gjiniaLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        gjiniaLabel.setText("gjinia:");

        PozitaComboBoxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PozitaComboBoxBActionPerformed(evt);
            }
        });

        pozitaLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        pozitaLabel.setText("pozita:");

        adresaLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        adresaLabel.setText("adresa:");

        LogInID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInIDActionPerformed(evt);
            }
        });

        loginPunetori_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        loginPunetori_jlabel.setText("login:");

        punetori_tabela.setAutoCreateRowSorter(true);
        punetori_tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(punetori_tabela);

        info_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        info_jlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        background_users_punetori.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout background_users_punetoriLayout = new javax.swing.GroupLayout(background_users_punetori);
        background_users_punetori.setLayout(background_users_punetoriLayout);
        background_users_punetoriLayout.setHorizontalGroup(
            background_users_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );
        background_users_punetoriLayout.setVerticalGroup(
            background_users_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        usersDesktopPane.setLayer(background_users_punetori, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout usersDesktopPaneLayout = new javax.swing.GroupLayout(usersDesktopPane);
        usersDesktopPane.setLayout(usersDesktopPaneLayout);
        usersDesktopPaneLayout.setHorizontalGroup(
            usersDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_users_punetori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        usersDesktopPaneLayout.setVerticalGroup(
            usersDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_users_punetori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background_punetoriLayout = new javax.swing.GroupLayout(background_punetori);
        background_punetori.setLayout(background_punetoriLayout);
        background_punetoriLayout.setHorizontalGroup(
            background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_punetoriLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(background_punetoriLayout.createSequentialGroup()
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(105, 105, 105)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emriLabel)
                            .addComponent(emriField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mbiemriField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mbiemriLabel))
                        .addGap(62, 62, 62)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moshaField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moshaLabel))
                        .addGap(28, 28, 28)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gjiniaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gjiniaLabel))
                        .addGap(44, 44, 44)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PozitaComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pozitaLabel))
                        .addGap(61, 61, 61)
                        .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_punetoriLayout.createSequentialGroup()
                                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adresaField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adresaLabel))
                                .addGap(70, 70, 70)
                                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LogInID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginPunetori_jlabel)))
                            .addComponent(pastro_Hapsirat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_punetoriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(info_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
            .addGroup(background_punetoriLayout.createSequentialGroup()
                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_punetoriLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(ruaj_Punetorin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(fshije_Punetorin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_punetoriLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(usersDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background_punetoriLayout.setVerticalGroup(
            background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_punetoriLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaj_Punetorin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshije_Punetorin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pastro_Hapsirat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(emriLabel)
                    .addComponent(mbiemriLabel)
                    .addComponent(gjiniaLabel)
                    .addComponent(adresaLabel)
                    .addComponent(moshaLabel)
                    .addComponent(loginPunetori_jlabel)
                    .addComponent(pozitaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background_punetoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbiemriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adresaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moshaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gjiniaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PozitaComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(info_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(usersDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_punetori, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_punetori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pastro_Hapsirat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastro_Hapsirat_btnActionPerformed
        punetori_tabela.clearSelection();
        pastroFields();
        if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {
            disableAllPunetoriOptions();
            gui.view.UsersInternalForm.enableAllUsersOptions();
        }

    }//GEN-LAST:event_pastro_Hapsirat_btnActionPerformed

    private void ruaj_Punetorin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaj_Punetorin_btnActionPerformed
        if (!emriField.getText().trim().equals("") && !mbiemriField.getText().trim().equals("")
                && !adresaField.getText().trim().equals("") && !moshaField.getText().trim().equals("")) {
            int row = punetori_tabela.getSelectedRow();
            if (row == -1) {
                Punetori p = new Punetori();
                String emriStandard = emriField.getText().replaceAll("\\s", "");
                String mbiemriStandard = mbiemriField.getText().replaceAll("\\s", "");
                String adresaStandard = adresaField.getText();

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);
                String mbiemriModified = mbiemriStandard.substring(0, 1).toUpperCase() + mbiemriStandard.substring(1);
                String adresaModified = adresaStandard.substring(0, 1).toUpperCase() + adresaStandard.substring(1);

                if (kaVetemShkronja(emriModified) && kaVetemShkronja(mbiemriModified)) {
                    p.setEmri(emriModified);
                    p.setMbiemri(mbiemriModified);
                    p.setGjinia(ktheGjinine());
                    p.setPozita((Pozitat) PozitaComboBoxB.getSelectedItem());
                    p.setAdresa(adresaModified);

                    if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                            || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {

                        UsersRepository usr = new UsersRepository();
                        List<Users> lista = null;
                        try {
                            lista = usr.findAll();
                        } catch (UsersException ex) {
                            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
                        }
                        int count = 0;
                        for (int i = 0; i < lista.size(); i++) {
                            count++;
                            if (count == lista.size()) {
                                p.setPunetoriLogIn(lista.get(i));
                            }
                        }
                    } else {

                        p.setPunetoriLogIn(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                try {
                    Integer mosha = Integer.parseInt(moshaField.getText().replaceAll("\\s", ""));
                    if (mosha > 50 || mosha < 18) {
                        JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit nuk munde te jete me e vogel "
                                + "se 18 vjeq dhe me e madhe se 50 vjeq.");
                        moshaField.setText("");
                        return;
                    } else {
                        p.setMosha(mosha);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit duhet te kete vlere numerike.");
                    moshaField.setText("");
                    return;
                }
                try {
                    pri.create(p);
                    if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                            || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {
                        disableAllPunetoriOptions();
                        gui.view.UsersInternalForm.enableAllUsersOptions();
                    }

                } catch (PunetoriException ex) {

                }
            } else {
                Punetori p = ptm.getPunetori(row);
                Pozitat pozitaPuntorit = (Pozitat) PozitaComboBoxB.getSelectedItem();

                String emriStandard = emriField.getText().replaceAll("\\s", "");
                String mbiemriStandard = mbiemriField.getText().replaceAll("\\s", "");
                String adresaStandard = adresaField.getText();

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);
                String mbiemriModified = mbiemriStandard.substring(0, 1).toUpperCase() + mbiemriStandard.substring(1);
                String adresaModified = adresaStandard.substring(0, 1).toUpperCase() + adresaStandard.substring(1);

                if (kaVetemShkronja(emriModified) && kaVetemShkronja(mbiemriModified)) {
                    p.setEmri(emriModified);
                    p.setMbiemri(mbiemriModified);
                    p.setAdresa(adresaModified);
                    p.setGjinia(ktheGjinine());
                    p.setPozita(pozitaPuntorit);
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                try {
                    Integer mosha = Integer.parseInt(moshaField.getText().replaceAll("\\s", ""));
                    if (mosha > 50 || mosha < 18) {
                        JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit nuk munde te jete me e vogel "
                                + "se 18 vjeq dhe me e madhe se 50 vjeq.");
                        moshaField.setText("");
                        return;

                    } else {
                        p.setMosha(mosha);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit duhet te kete vlere numerike.");
                    moshaField.setText("");
                    return;
                }
                try {
                    pri.edit(p);
                    if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                            || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {
                        disableAllPunetoriOptions();
                        gui.view.UsersInternalForm.enableAllUsersOptions();
                        
                    }
                } catch (PunetoriException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            pastroFields();
            try {
                loadTabelen();
            } catch (PunetoriException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat jane obligative ti plotesoni per ta regjistruar punetorin e deshiruar!");
        }
    }//GEN-LAST:event_ruaj_Punetorin_btnActionPerformed

    private void fshije_Punetorin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshije_Punetorin_btnActionPerformed
        int row = punetori_tabela.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini punetorin ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    Punetori p = ptm.getPunetori(row);
                    pri.remove(p);
                    if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                            || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {
                        disableAllPunetoriOptions();
                        gui.view.UsersInternalForm.enableAllUsersOptions();
                    }
                    loadTabelen();
                } catch (PunetoriException ex) {
                    JOptionPane.showMessageDialog(this, "ICDS:" + ex.getMessage());
                }
            }
            pastroFields();
            punetori_tabela.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_fshije_Punetorin_btnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        punetori_tabela.clearSelection();
        pastroFields();
    }//GEN-LAST:event_formMouseClicked

    public void addUsersInternalFrame() {
        try {
            UsersInternalForm uiform = new UsersInternalForm();
            usersDesktopPane.add(uiform);
            uiform.show();
            uiform.setFocusable(true);
            disableUsersDrag();
            gui.view.UsersInternalForm.disableAllUsersOptions();

        } catch (UsersException ex) {

        }
    }

    private void disableUsersDrag() {
        JInternalFrame[] frames = usersDesktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        }
    }

    private void disablePunetoriFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }


    private void PozitaComboBoxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PozitaComboBoxBActionPerformed
        if (PozitaComboBoxB.getSelectedItem().toString().equals("Menaxher")
                || PozitaComboBoxB.getSelectedItem().toString().equals("Administrat")) {
            if (!punetori_tabela.getSelectionModel().isSelectionEmpty()) {
                enableAllPunetoriOptions();
                gui.view.UsersInternalForm.disableAllUsersOptions();
            } else {
                disableAllPunetoriOptions();
                gui.view.UsersInternalForm.enableAllUsersOptions();
            }

        } else {
            enableAllPunetoriOptions();
            gui.view.UsersInternalForm.disableAllUsersOptions();
        }

    }//GEN-LAST:event_PozitaComboBoxBActionPerformed

    public static void disableAllPunetoriOptions() {
        try{
        info_jlabel.setText("(i) Që të regjistroni puntorin me pozitën e zgjedhur, duhet që fillimisht të krijoni llogarinë e tijë.");
        ruaj_Punetorin_btn.setEnabled(false);
        idField.setEnabled(false);
        emriField.setEnabled(false);
        mbiemriField.setEnabled(false);
        moshaField.setEnabled(false);
        gjiniaCombo.setEnabled(false);
        adresaField.setEnabled(false);
        LogInID.setEnabled(false);
        }catch(Exception e){
            
        }

    }

    public static void enableAllPunetoriOptions() {
        try{
        info_jlabel.setText("");
        ruaj_Punetorin_btn.setEnabled(true);
        idField.setEnabled(true);
        emriField.setEnabled(true);
        mbiemriField.setEnabled(true);
        moshaField.setEnabled(true);
        gjiniaCombo.setEnabled(true);
        adresaField.setEnabled(true);
        LogInID.setEnabled(true);
        }catch(Exception e){
            
        }

    }


    private void LogInIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInIDActionPerformed

    private void background_punetoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_background_punetoriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_background_punetoriMouseClicked

    private void pastroFields() {
        punetori_tabela.clearSelection();
        idField.setText("");
        emriField.setText("");
        mbiemriField.setText("");
        adresaField.setText("");
        moshaField.setText("");

    }

    private char ktheGjinine() {
        char gender;
        String gjinia = (String) gjiniaCombo.getSelectedItem();
        if (gjinia.equals("Mashkull")) {
            gender = 'M';
        } else {
            gender = 'F';
        }
        return gender;
    }

    private static boolean kaVetemShkronja(String input) {
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void setloginid(int a) {
        LogInID.setText(a + "");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField LogInID;
    private javax.swing.JComboBox PozitaComboBoxB;
    private static javax.swing.JTextField adresaField;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.JPanel background_punetori;
    private javax.swing.JPanel background_users_punetori;
    private static javax.swing.JTextField emriField;
    private javax.swing.JLabel emriLabel;
    private static javax.swing.JButton fshije_Punetorin_btn;
    private static javax.swing.JComboBox<String> gjiniaCombo;
    private javax.swing.JLabel gjiniaLabel;
    private static javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private static javax.swing.JLabel info_jlabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginPunetori_jlabel;
    private static javax.swing.JTextField mbiemriField;
    private javax.swing.JLabel mbiemriLabel;
    private static javax.swing.JTextField moshaField;
    private javax.swing.JLabel moshaLabel;
    private static javax.swing.JButton pastro_Hapsirat_btn;
    private javax.swing.JLabel pozitaLabel;
    private static javax.swing.JTable punetori_tabela;
    private static javax.swing.JButton ruaj_Punetorin_btn;
    public static javax.swing.JDesktopPane usersDesktopPane;
    // End of variables declaration//GEN-END:variables
}
