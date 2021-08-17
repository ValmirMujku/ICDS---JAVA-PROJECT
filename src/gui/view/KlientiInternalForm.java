/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Klienti;
import BLL.Qyteti;
import BLL.Users;
import Exceptions.KlientiException;
import DAL.KlientiInterface;
import DAL.KlientiRepository;
import DAL.QytetiInterface;
import DAL.QytetiRepository;
import DAL.UsersRepository;
import Exceptions.QytetiException;
import Exceptions.UsersException;
import gui.model.KlientiTableModel;
import gui.model.QytetiComboBox;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Rinor
 */
public class KlientiInternalForm extends javax.swing.JInternalFrame {

    KlientiInterface kif = new KlientiRepository();
    KlientiTableModel ktm;
    QytetiInterface qoz = new QytetiRepository();

    public KlientiInternalForm() {
        initComponents();
        loadboxQytetet();
        try {
            loadTabelen();
        } catch (KlientiException ex) {

        }
        loadboxQytetet();
        tabelaSelectedIndexChange();
        idField_Klienti.setEditable(false);

        addUsersInternalFrame();
        ndryshoPozicionetIconave();
        disableKlientiFormDrag();

        setFormFullScren();
    }

    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getWidth();
        int ysize = (int) gui.view.PunetoriMenaxherMainForm.desktopPane.getHeight();
        this.setSize(xsize, ysize);
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = klienti_tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Klienti k = ktm.getKlienti(selectedIndex);
                    if (!klienti_tabela.getSelectionModel().isSelectionEmpty()) {
                        enableAllKlientiOptions();
                        gui.view.UsersInternalForm.disableAllUsersOptions();
                    } else {
                        disableAllKlientiOptions();
                        gui.view.UsersInternalForm.enableAllUsersOptions();
                    }
                    loadboxQytetet();
                    QytetiComboBoxB.setSelectedItem(k.getQyteti());
                    idField_Klienti.setText(k.getKId() + "");
                    emriField_Klienti.setText(k.getEmri());
                    mbiemriField_Klienti.setText(k.getMbiemri());
                    try {
                        gjiniaComboBox.setSelectedIndex(k.getGjinia());
                    } catch (IllegalArgumentException ill) {
                    }
                    moshaField_Klienti.setText(k.getMosha() + "");
                }
            }
        });
    }

    private void loadTabelen() throws KlientiException {
        kif.findAll();
        List<Klienti> list = kif.findAll();
        ktm = new KlientiTableModel(list);
        klienti_tabela.setModel(ktm);
        ktm.fireTableDataChanged();

    }

    private void ndryshoPozicionetIconave() {
        ruaj_KlientinBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        fshije_KlientinBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        pastro_HapsiratBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        ruaj_KlientinBtn.setIconTextGap(10);
        fshije_KlientinBtn.setIconTextGap(10);
        pastro_HapsiratBtn.setIconTextGap(10);
    }

    private void loadboxQytetet() {
        try {
            QytetiComboBox qx;
            List<Qyteti> lista = qoz.findAll();
            qx = new QytetiComboBox(lista);
            this.QytetiComboBoxB.setModel(qx);
        } catch (QytetiException e) {
            JOptionPane.showMessageDialog(this, "ICDS:" + e);
        }

    }

    private void pastroFields() {
        klienti_tabela.clearSelection();
        idField_Klienti.setText("");
        emriField_Klienti.setText("");
        mbiemriField_Klienti.setText("");
        moshaField_Klienti.setText("");

    }

    private char ktheGjinine() {
        char gender;
        String gjinia = (String) gjiniaComboBox.getSelectedItem();
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

    public static void disableAllKlientiOptions() {
        try{
        info_jlabel.setText("(i) Që të regjistroni klientin, duhet që fillimisht të krijoni llogarinë e tijë.");
        ruaj_KlientinBtn.setEnabled(false);
        idField_Klienti.setEnabled(false);
        emriField_Klienti.setEnabled(false);
        mbiemriField_Klienti.setEnabled(false);
        moshaField_Klienti.setEnabled(false);
        gjiniaComboBox.setEnabled(false);
        QytetiComboBoxB.setEnabled(false);
        klientiLogIn_Field.setEnabled(false);
        }catch(Exception e){
            
        }
    }

    public static void enableAllKlientiOptions() {
        try{
        info_jlabel.setText("");
        ruaj_KlientinBtn.setEnabled(true);
        fshije_KlientinBtn.setEnabled(true);
        pastro_HapsiratBtn.setEnabled(true);
        idField_Klienti.setEnabled(true);
        emriField_Klienti.setEnabled(true);
        mbiemriField_Klienti.setEnabled(true);
        moshaField_Klienti.setEnabled(true);
        gjiniaComboBox.setEnabled(true);
        QytetiComboBoxB.setEnabled(true);
        klientiLogIn_Field.setEnabled(true);
        klienti_tabela.setEnabled(true);
        }
        catch(Exception e){
            
        }

    }

    public static void setloginid(int a) {
        try{
        klientiLogIn_Field.setText(a + "");
        }catch(Exception e){
            
        }
    }

    private void addUsersInternalFrame() {
        try {
            UsersInternalForm uiform = new UsersInternalForm();
            usersDesktiopPaneKlienti.add(uiform);
            uiform.show();
            uiform.setFocusable(true);
            disableDragUsers();
            gui.view.UsersInternalForm.enableAllUsersOptions();
            disableAllKlientiOptions();

        } catch (UsersException ex) {

        }
    }

    public void disableDragUsers() {
        JInternalFrame[] frames = usersDesktiopPaneKlienti.getAllFrames();
        for (JInternalFrame frame : frames) {
            BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        }
    }

    private void disableKlientiFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        background_klienti = new javax.swing.JPanel();
        ruaj_KlientinBtn = new javax.swing.JButton();
        id_jlabel = new javax.swing.JLabel();
        idField_Klienti = new javax.swing.JTextField();
        emriField_Klienti = new javax.swing.JTextField();
        emri_jlabel = new javax.swing.JLabel();
        mbiemriField_Klienti = new javax.swing.JTextField();
        mbiemri_jlabel = new javax.swing.JLabel();
        moshaField_Klienti = new javax.swing.JTextField();
        mosha_jlabel = new javax.swing.JLabel();
        fshije_KlientinBtn = new javax.swing.JButton();
        gjiniaComboBox = new javax.swing.JComboBox<>();
        gjinia_jlabel = new javax.swing.JLabel();
        QytetiComboBoxB = new javax.swing.JComboBox();
        qyteti_jlabel = new javax.swing.JLabel();
        pastro_HapsiratBtn = new javax.swing.JButton();
        klientiLogIn_Field = new javax.swing.JTextField();
        logIn_jlabel = new javax.swing.JLabel();
        info_jlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        klienti_tabela = new javax.swing.JTable();
        usersDesktiopPaneKlienti = new javax.swing.JDesktopPane();
        usersDesktopPaneKlienti = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Menaxho Klientët");
        setMinimumSize(new java.awt.Dimension(1205, 585));
        setPreferredSize(new java.awt.Dimension(1205, 585));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        background_klienti.setBackground(new java.awt.Color(153, 153, 255));
        background_klienti.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_klienti.setPreferredSize(new java.awt.Dimension(1205, 585));
        background_klienti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                background_klientiMouseClicked(evt);
            }
        });

        ruaj_KlientinBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ruaj_KlientinBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        ruaj_KlientinBtn.setText("RUAJ KLIENTIN");
        ruaj_KlientinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruaj_KlientinBtnActionPerformed(evt);
            }
        });

        id_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        id_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        id_jlabel.setText("id:");

        idField_Klienti.setMaximumSize(new java.awt.Dimension(14, 24));

        emriField_Klienti.setMaximumSize(new java.awt.Dimension(14, 24));

        emri_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        emri_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        emri_jlabel.setText("emri:");

        mbiemri_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        mbiemri_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        mbiemri_jlabel.setText("mbiemri:");

        mosha_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        mosha_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        mosha_jlabel.setText("mosha:");

        fshije_KlientinBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fshije_KlientinBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        fshije_KlientinBtn.setText("FSHIJE KLIENTIN");
        fshije_KlientinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshije_KlientinBtnActionPerformed(evt);
            }
        });

        gjiniaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mashkull", "Femer" }));

        gjinia_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        gjinia_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        gjinia_jlabel.setText("gjinia:");

        QytetiComboBoxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QytetiComboBoxBActionPerformed(evt);
            }
        });

        qyteti_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        qyteti_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        qyteti_jlabel.setText("qyteti:");

        pastro_HapsiratBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pastro_HapsiratBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-available-updates-30.png"))); // NOI18N
        pastro_HapsiratBtn.setText("PASTRO HAPSIRAT");
        pastro_HapsiratBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastro_HapsiratBtnActionPerformed(evt);
            }
        });

        logIn_jlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        logIn_jlabel.setForeground(new java.awt.Color(0, 0, 0));
        logIn_jlabel.setText("log in:");

        info_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        info_jlabel.setForeground(new java.awt.Color(0, 0, 0));

        klienti_tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(klienti_tabela);

        usersDesktiopPaneKlienti.setPreferredSize(new java.awt.Dimension(1178, 224));

        usersDesktopPaneKlienti.setBackground(new java.awt.Color(153, 153, 255));
        usersDesktopPaneKlienti.setForeground(new java.awt.Color(51, 51, 51));
        usersDesktopPaneKlienti.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout usersDesktopPaneKlientiLayout = new javax.swing.GroupLayout(usersDesktopPaneKlienti);
        usersDesktopPaneKlienti.setLayout(usersDesktopPaneKlientiLayout);
        usersDesktopPaneKlientiLayout.setHorizontalGroup(
            usersDesktopPaneKlientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        usersDesktopPaneKlientiLayout.setVerticalGroup(
            usersDesktopPaneKlientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        usersDesktiopPaneKlienti.setLayer(usersDesktopPaneKlienti, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout usersDesktiopPaneKlientiLayout = new javax.swing.GroupLayout(usersDesktiopPaneKlienti);
        usersDesktiopPaneKlienti.setLayout(usersDesktiopPaneKlientiLayout);
        usersDesktiopPaneKlientiLayout.setHorizontalGroup(
            usersDesktiopPaneKlientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersDesktopPaneKlienti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        usersDesktiopPaneKlientiLayout.setVerticalGroup(
            usersDesktiopPaneKlientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersDesktopPaneKlienti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background_klientiLayout = new javax.swing.GroupLayout(background_klienti);
        background_klienti.setLayout(background_klientiLayout);
        background_klientiLayout.setHorizontalGroup(
            background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_klientiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usersDesktiopPaneKlienti, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_klientiLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_klientiLayout.createSequentialGroup()
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id_jlabel))
                                .addGap(43, 43, 43)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emriField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emri_jlabel))
                                .addGap(64, 64, 64)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mbiemriField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mbiemri_jlabel))
                                .addGap(35, 35, 35)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(moshaField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mosha_jlabel))
                                .addGap(24, 24, 24)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gjiniaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gjinia_jlabel))
                                .addGap(36, 36, 36)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QytetiComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qyteti_jlabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logIn_jlabel)
                                    .addComponent(klientiLogIn_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_klientiLayout.createSequentialGroup()
                                .addComponent(ruaj_KlientinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(fshije_KlientinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(pastro_HapsiratBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_klientiLayout.createSequentialGroup()
                        .addComponent(info_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
        );
        background_klientiLayout.setVerticalGroup(
            background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_klientiLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaj_KlientinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshije_KlientinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pastro_HapsiratBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_jlabel)
                    .addComponent(emri_jlabel)
                    .addComponent(mbiemri_jlabel)
                    .addComponent(gjinia_jlabel)
                    .addComponent(qyteti_jlabel)
                    .addComponent(mosha_jlabel)
                    .addComponent(logIn_jlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background_klientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emriField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbiemriField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gjiniaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moshaField_Klienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QytetiComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(klientiLogIn_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(info_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(usersDesktiopPaneKlienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_klienti, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_klienti, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QytetiComboBoxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QytetiComboBoxBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QytetiComboBoxBActionPerformed

    private void pastro_HapsiratBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastro_HapsiratBtnActionPerformed
        disableAllKlientiOptions();
        gui.view.UsersInternalForm.enableAllUsersOptions();
        klienti_tabela.clearSelection();
        pastroFields();
    }//GEN-LAST:event_pastro_HapsiratBtnActionPerformed

    private void ruaj_KlientinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaj_KlientinBtnActionPerformed
        if (!emriField_Klienti.getText().trim().equals("") && !mbiemriField_Klienti.getText().trim().equals("")
                && !moshaField_Klienti.getText().trim().equals("")) {
            int row = klienti_tabela.getSelectedRow();
            if (row == -1) {
                Klienti k = new Klienti();
                String emriStandard = emriField_Klienti.getText().replaceAll("\\s", "");
                String mbiemriStandard = mbiemriField_Klienti.getText().replaceAll("\\s", "");

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);
                String mbiemriModified = mbiemriStandard.substring(0, 1).toUpperCase() + mbiemriStandard.substring(1);

                if (kaVetemShkronja(emriModified) && kaVetemShkronja(mbiemriModified)) {
                    k.setEmri(emriModified);
                    k.setMbiemri(mbiemriModified);
                    k.setGjinia(ktheGjinine());
                    k.setQyteti((Qyteti) QytetiComboBoxB.getSelectedItem());

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
                            k.setKlientiLogIn(lista.get(i));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                try {
                    Integer mosha = Integer.parseInt(moshaField_Klienti.getText().replaceAll("\\s", ""));
                    if (mosha > 120 || mosha < 18) {
                        JOptionPane.showMessageDialog(this, "ICDS: Mosha e klientit nuk munde te jete me e vogel "
                                + "se 18 vjeq dhe me e madhe se 120 vjeq.");
                        moshaField_Klienti.setText("");
                        return;
                    } else {
                        k.setMosha(mosha);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit duhet te kete vlere numerike.");
                    moshaField_Klienti.setText("");
                    return;
                }
                try {
                    kif.create(k);
                    pastroFields();
                    disableAllKlientiOptions();
                    gui.view.UsersInternalForm.enableAllUsersOptions();
                } catch (KlientiException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else {
                Klienti k = ktm.getKlienti(row);

                String emriStandard = emriField_Klienti.getText().replaceAll("\\s", "");
                String mbiemriStandard = mbiemriField_Klienti.getText().replaceAll("\\s", "");

                String emriModified = emriStandard.substring(0, 1).toUpperCase() + emriStandard.substring(1);
                String mbiemriModified = mbiemriStandard.substring(0, 1).toUpperCase() + mbiemriStandard.substring(1);

                if (kaVetemShkronja(emriModified) && kaVetemShkronja(mbiemriModified)) {
                    k.setEmri(emriModified);
                    k.setMbiemri(mbiemriModified);
                    k.setGjinia(ktheGjinine());
                    k.setQyteti((Qyteti) QytetiComboBoxB.getSelectedItem());
                } else {
                    JOptionPane.showMessageDialog(this, "ICDS: Keni shtypur karakter te pa lejueshem. Ju lutem mbushni hapsirat vetem me karaktere te lejuara.");
                    pastroFields();
                    return;
                }
                try {
                    Integer mosha = Integer.parseInt(moshaField_Klienti.getText().replaceAll("\\s", ""));
                    if (mosha > 120 || mosha < 18) {
                        JOptionPane.showMessageDialog(this, "ICDS: Mosha e klientit nuk munde te jete me e vogel "
                                + "se 18 vjeq dhe me e madhe se 120 vjeq.");
                        moshaField_Klienti.setText("");
                        return;
                    } else {
                        k.setMosha(mosha);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "ICDS: Mosha e punetorit duhet te kete vlere numerike.");
                    moshaField_Klienti.setText("");
                    return;
                }
                try {
                    kif.edit(k);
                } catch (KlientiException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            pastroFields();
            try {
                loadTabelen();
            } catch (KlientiException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat jane obligative ti plotesoni per ta regjistruar klientin e deshiruar!");
        }
    }//GEN-LAST:event_ruaj_KlientinBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        klienti_tabela.clearSelection();
        pastroFields();
    }//GEN-LAST:event_formMouseClicked

    private void fshije_KlientinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshije_KlientinBtnActionPerformed
        int row = klienti_tabela.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini klientin ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    Klienti k = ktm.getKlienti(row);
                    kif.remove(k);
                    disableAllKlientiOptions();
                    gui.view.UsersInternalForm.enableAllUsersOptions();
                    loadTabelen();
                } catch (KlientiException ex) {
                    JOptionPane.showMessageDialog(this, "ICDS:" + ex.getMessage());
                }
            }
            pastroFields();
            klienti_tabela.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_fshije_KlientinBtnActionPerformed

    private void background_klientiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_background_klientiMouseClicked

    }//GEN-LAST:event_background_klientiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JComboBox QytetiComboBoxB;
    private javax.swing.JPanel background_klienti;
    static javax.swing.JTextField emriField_Klienti;
    private javax.swing.JLabel emri_jlabel;
    static javax.swing.JButton fshije_KlientinBtn;
    static javax.swing.JComboBox<String> gjiniaComboBox;
    private javax.swing.JLabel gjinia_jlabel;
    static javax.swing.JTextField idField_Klienti;
    private javax.swing.JLabel id_jlabel;
    static javax.swing.JLabel info_jlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField klientiLogIn_Field;
    static javax.swing.JTable klienti_tabela;
    private javax.swing.JLabel logIn_jlabel;
    static javax.swing.JTextField mbiemriField_Klienti;
    private javax.swing.JLabel mbiemri_jlabel;
    static javax.swing.JTextField moshaField_Klienti;
    private javax.swing.JLabel mosha_jlabel;
    static javax.swing.JButton pastro_HapsiratBtn;
    private javax.swing.JLabel qyteti_jlabel;
    static javax.swing.JButton ruaj_KlientinBtn;
    private javax.swing.JDesktopPane usersDesktiopPaneKlienti;
    public javax.swing.JPanel usersDesktopPaneKlienti;
    // End of variables declaration//GEN-END:variables
}
