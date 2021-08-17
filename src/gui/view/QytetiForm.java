package gui.view;

import BLL.Komuna;
import BLL.Qyteti;
import DAL.KomunaRepository;
import Exceptions.QytetiException;

import DAL.QytetiRepository;
import Exceptions.KomunaException;

import gui.model.KomunTable;
import gui.model.QytetiComboBox;
import gui.model.QytetiTable;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class QytetiForm extends javax.swing.JInternalFrame {

    QytetiRepository qr = new QytetiRepository();
    QytetiTable qt;
    KomunaRepository kr = new KomunaRepository();
    KomunTable kt;

    public QytetiForm() throws QytetiException, KomunaException {
        initComponents();
        shfaqTabelen();
        tabelaSelectedIndexChange();
        loadbox();
        shfaqTabelenKomuna();
        tabelaSelectedIndexChange2();
        disableQytetiFormDrag();
//        setFormInMiddle();
        setFormFullScren();
    }
    
    private void setFormFullScren() {
        int xsize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int) gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize, ysize);
    }
    
//    private void setFormInMiddle(){
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
//    }

    public void pastroFushatKomuna() throws QytetiException {
        KomunaT.clearSelection();
        IDKomuna.setText("");
        EmriKomuna.setText("");
        QytetiBox.setSelectedItem(-1);
        loadbox();
    }

    public void pastroFushat() {
        QytetiT.clearSelection();
        IDQyteti.setText("");
        EmriQyteti.setText("");
        ZipQyteti.setText("");
    }

    public void shfaqTabelen() throws QytetiException {

        List<Qyteti> lista = qr.findAll();
        qt = new QytetiTable(lista);
        QytetiT.setModel(qt);
        qt.fireTableDataChanged();

    }

    public void shfaqTabelenKomuna() throws KomunaException {
      
            List<Komuna> lista = kr.findAll();
            kt = new KomunTable(lista);
            KomunaT.setModel(kt);
            kt.fireTableDataChanged();
        
    }

    public void loadbox() throws QytetiException {
        QytetiComboBox qc;
        List<Qyteti> lista = qr.findAll();
        qc = new QytetiComboBox(lista);
        this.QytetiBox.setModel(qc);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        choice1 = new java.awt.Choice();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        SaveQyteti = new javax.swing.JButton();
        CancelQyteti = new javax.swing.JButton();
        DeleteQyteti = new javax.swing.JButton();
        EditQyteti = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDQyteti = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        EmriQyteti = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ZipQyteti = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        QytetiT = new javax.swing.JTable();
        SaveKomuna = new javax.swing.JButton();
        CancelKomuna = new javax.swing.JButton();
        DeleteKomuna = new javax.swing.JButton();
        EditKomuna = new javax.swing.JButton();
        QytetiBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        IDKomuna = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EmriKomuna = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        KomunaT = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setTitle("LOKACIONET");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        SaveQyteti.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaveQyteti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        SaveQyteti.setText("SAVE");
        SaveQyteti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveQytetiActionPerformed(evt);
            }
        });

        CancelQyteti.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelQyteti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-30.png"))); // NOI18N
        CancelQyteti.setText("CANCEL");
        CancelQyteti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelQytetiActionPerformed(evt);
            }
        });

        DeleteQyteti.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteQyteti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        DeleteQyteti.setText("DELETE");
        DeleteQyteti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteQytetiActionPerformed(evt);
            }
        });

        EditQyteti.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EditQyteti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-edit-file-30.png"))); // NOI18N
        EditQyteti.setText("EDIT");
        EditQyteti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditQytetiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("EMRI");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("ZIP C");

        QytetiT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(QytetiT);

        SaveKomuna.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaveKomuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        SaveKomuna.setText("SAVE");
        SaveKomuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveKomunaActionPerformed(evt);
            }
        });

        CancelKomuna.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelKomuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-30.png"))); // NOI18N
        CancelKomuna.setText("CANCEL");
        CancelKomuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelKomunaActionPerformed(evt);
            }
        });

        DeleteKomuna.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteKomuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        DeleteKomuna.setText("DELETE");
        DeleteKomuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteKomunaActionPerformed(evt);
            }
        });

        EditKomuna.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EditKomuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-edit-file-30.png"))); // NOI18N
        EditKomuna.setText("EDIT");
        EditKomuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditKomunaActionPerformed(evt);
            }
        });

        QytetiBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("ID");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("Emri");

        KomunaT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(KomunaT);

        jSeparator1.setBackground(new java.awt.Color(45, 45, 45));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EmriQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ZipQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(SaveQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(DeleteQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(EditQyteti)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(SaveKomuna, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelKomuna)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteKomuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(EditKomuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QytetiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(IDKomuna, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(EmriKomuna, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)))
                        .addGap(46, 46, 46))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelKomuna, CancelQyteti, DeleteKomuna, DeleteQyteti, EditKomuna, EditQyteti, SaveKomuna, SaveQyteti});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveKomuna)
                            .addComponent(CancelKomuna)
                            .addComponent(DeleteKomuna)
                            .addComponent(EditKomuna))
                        .addGap(43, 43, 43)
                        .addComponent(QytetiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(EmriKomuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(IDKomuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SaveQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CancelQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DeleteQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EditQyteti)))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(EmriQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(ZipQyteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 209, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(16, 16, 16))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {EmriQyteti, IDQyteti, ZipQyteti, jLabel1, jLabel2, jLabel3});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {EmriKomuna, IDKomuna, jLabel4});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CancelKomuna, CancelQyteti, DeleteKomuna, DeleteQyteti, EditKomuna, EditQyteti, SaveKomuna, SaveQyteti});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelQytetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelQytetiActionPerformed
        pastroFushat();
    }//GEN-LAST:event_CancelQytetiActionPerformed

    public boolean vlene() {

        for (int i = 0; i < IDQyteti.getText().length(); i++) {
            if (IDQyteti.getText().charAt(i) < '0' || IDQyteti.getText().charAt(i) > '9') {
                return false;
            }

        }
        return true;
    }

    public boolean EmriQyteti() {
        int COUNT = 0;
        char[] shkronjat = EmriQyteti.getText().toCharArray();
        for (char c : shkronjat) {
            if (Character.isDigit(c)) {
                COUNT++;
            }
        }
        if (COUNT == EmriQyteti.getText().length()) {
            return true;
        }
        return false;
    }

    public boolean Simbolet() {
        int COUNT = 0;
        char[] shkronjat = EmriQyteti.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 97 && code <= 122) {
                COUNT++;
            } else if (code >= 65 && code <= 90) {
                COUNT++;
            }
        }
        if (COUNT == EmriQyteti.getText().length()) {
            return true;
        }
        return false;

    }

    public boolean ZipCode() {
        if (Integer.parseInt(ZipQyteti.getText()) <= 0) {
            return true;
        }
        return false;
    }

    public boolean egzistonQyteti() throws QytetiException {
        List<Qyteti> lista = qr.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmri().equals(EmriQyteti.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean egzistonKodi() throws QytetiException {
        List<Qyteti> lista = qr.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getZipCode() == Integer.parseInt(ZipQyteti.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean SimboletKodi() {
        int COUNT = 0;
        char[] shkronjat = ZipQyteti.getText().toCharArray();
        for (char c : shkronjat) {
            if (Character.isDigit(c)) {
                COUNT++;
            }
        }
        if (COUNT == ZipQyteti.getText().length()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveValid() throws QytetiException {
        if (IDQyteti.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet Hapsira e ID.");
        } else if (EmriQyteti.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet Hapsira e Emrit.");
        } else if (ZipQyteti.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet Zip Kodi");
        } else if (vlene() == false) {
            JOptionPane.showMessageDialog(this, "ID duhet te permbaje vetem shifra numerike.");
        } else if (EmriQyteti() == true) {
            JOptionPane.showMessageDialog(this, "Emri nuk lejohet te permbaje vetem numra.");
        } else if (Simbolet() == false) {
            JOptionPane.showMessageDialog(this, "Emri permbane simbole te panjohura.");
        } else if (SimboletKodi() == false) {
            JOptionPane.showMessageDialog(this, "Zip Kodi permbane Simbole joValide");
        } else if (ZipCode() == true) {
            JOptionPane.showMessageDialog(this, "Zip Kodi nuk guxon te jete 0 ose numer negativ.");
        } else if (egzistonQyteti() == true) {
            JOptionPane.showMessageDialog(this, "Qyteti Egziston.");
        } else if (egzistonKodi() == true) {
            JOptionPane.showMessageDialog(this, "Zip Kodi i dhene egziston.");
        } else {
            return true;
        }
        return false;
    }
    private void SaveQytetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveQytetiActionPerformed
       try{
        if (IDQyteti.getText().equals("") && EmriQyteti.getText().equals("") && ZipQyteti.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar Obligative.");
        } else {
            try {
                if (saveValid() == true) {
                    Qyteti q = new Qyteti();
                    q.setQytetiID(Integer.parseInt(IDQyteti.getText()));
                    q.setEmri(EmriQyteti.getText());
                    q.setZipCode(Integer.parseInt(ZipQyteti.getText()));
                    qr.create(q);
                    shfaqTabelen();
                    pastroFushat();
                    loadbox();
                }
            } catch (QytetiException ex) {
                ex.printStackTrace();
            }
        }
       }catch(Exception e){
           e.printStackTrace();
       }

    }//GEN-LAST:event_SaveQytetiActionPerformed

    private void DeleteQytetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteQytetiActionPerformed
      try{
        int row = QytetiT.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (result == 0) {
                Qyteti q = qt.getQyteti(row);
                try {
                    qr.remove(q);
                    shfaqTabelen();
                    loadbox();
                } catch (QytetiException ex) {
                }
                pastroFushat();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ju nuk keni selektuar asgje.");
        }
        }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_DeleteQytetiActionPerformed

    private void EditQytetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditQytetiActionPerformed
       try{
        int row = QytetiT.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, " \"KUJDES\" Editimi nuk ka kthim mbrapa?", "Editimi", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (result == 0) {
                if (IDQyteti.getText().equals("") && EmriQyteti.getText().equals("") && ZipQyteti.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar Obligative.");
                    return;
                } else {
                    try {
                        if (saveValid() == true) {
                            Qyteti q = new Qyteti();
                            q.setQytetiID(Integer.parseInt(IDQyteti.getText()));
                            q.setEmri(EmriQyteti.getText());
                            q.setZipCode(Integer.parseInt(ZipQyteti.getText()));
                            qr.edit(q);
                            shfaqTabelen();
                            pastroFushat();
                            loadbox();
                        }
                    } catch (QytetiException ex) {
                        Logger.getLogger(QytetiForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ju nuk keni selektuar asgje.");
        }
        }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_EditQytetiActionPerformed

    public boolean vleneIDKomuna() {

        for (int i = 0; i < IDKomuna.getText().length(); i++) {
            if (IDKomuna.getText().charAt(i) < '0' || IDKomuna.getText().charAt(i) > '9') {
                return false;
            }

        }
        return true;
    }

    public boolean SimboletEmriKomuna() {
        int COUNT = 0;
        char[] shkronjat = EmriKomuna.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 97 && code <= 122) {
                COUNT++;
            } else if (code >= 65 && code <= 90) {
                COUNT++;
            }
        }
        if (COUNT == EmriKomuna.getText().length()) {
            return true;
        }
        return false;

    }

    public boolean egizstonKomuna() throws KomunaException {
        
            List<Komuna> lista = kr.findAll();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getEmri().equals(EmriKomuna.getText())) {
                    return true;
                }
            }
            return false;
      
        
    }

    public boolean saveKomunaValid() throws KomunaException {
        if (IDKomuna.getText().equals("") && EmriKomuna.getText().equals("") && QytetiBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Kolona duhet plotesuar (OBLIGATIVE).");
        } else if (IDKomuna.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet fusha e ID.");
        } else if (EmriKomuna.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet fusha e Emrit");
        } else if (QytetiBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Duhet te zgjedhet Qyteti te cilit i perket Komuna.");
        } else if (vleneIDKomuna() == false) {
            JOptionPane.showMessageDialog(this, "ID duhet te permbaje vetem numra.");
        } else if (SimboletEmriKomuna() == false) {
            JOptionPane.showMessageDialog(this, "Emri permbane simbole joValide.");
        } else if (egizstonKomuna() == true) {
            JOptionPane.showMessageDialog(this, "Kjo Komune egziston.");
        } else {
            return true;
        }
        return false;
    }
    private void SaveKomunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveKomunaActionPerformed
        try{
        if (saveKomunaValid() == true) {
            Komuna k = new Komuna();
            k.setKId(Integer.parseInt(IDKomuna.getText()));
            k.setEmri(EmriKomuna.getText());
            k.setQyteti((Qyteti) QytetiBox.getSelectedItem());
            kr.create(k);
            shfaqTabelenKomuna();
            try {
                pastroFushatKomuna();
            } catch (QytetiException ex) {
            }
        }
        }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_SaveKomunaActionPerformed

    private void CancelKomunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelKomunaActionPerformed

        try {
            pastroFushatKomuna();
        } catch (QytetiException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_CancelKomunaActionPerformed

    private void EditKomunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditKomunaActionPerformed
      try{
        int row = KomunaT.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, " \"KUJDES\" Editimi nuk ka kthim mbrapa?", "Editimi", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (result == 0) {
                if (saveKomunaValid() == true) {
                    Komuna k = new Komuna();
                    k.setKId(Integer.parseInt(IDKomuna.getText()));
                    k.setEmri(EmriKomuna.getText());
                    k.setQyteti((Qyteti) QytetiBox.getSelectedItem());
                    kr.edit(k);
                    shfaqTabelenKomuna();
                    try {
                        pastroFushatKomuna();
                    } catch (QytetiException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_EditKomunaActionPerformed

    private void DeleteKomunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteKomunaActionPerformed
       try{
        int row = KomunaT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(result == 0){
                    Komuna k = kt.getKomuna(row);
                    kr.remove(k);
                     shfaqTabelenKomuna();
                    try {
                        pastroFushatKomuna();
                    } catch (QytetiException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_DeleteKomunaActionPerformed

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = QytetiT.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Qyteti q = qt.getQyteti(selectedIndex);
                    IDQyteti.setText(q.getQytetiID() + "");
                    EmriQyteti.setText(q.getEmri());
                    ZipQyteti.setText(q.getZipCode() + "");

                }
            }
        });

    }
    
    private void disableQytetiFormDrag(){
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        } 
    
    private void tabelaSelectedIndexChange2() {
        final ListSelectionModel rowSM = KomunaT.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Komuna k = kt.getKomuna(selectedIndex);
                    IDKomuna.setText(k.getKId()+"");
                    EmriKomuna.setText(k.getEmri());


                    try {
                        loadbox();
                    } catch (QytetiException ex) {
                        ex.printStackTrace();
                    }
                    
                    QytetiBox.setSelectedItem(k.getQyteti());
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelKomuna;
    private javax.swing.JButton CancelQyteti;
    private javax.swing.JButton DeleteKomuna;
    private javax.swing.JButton DeleteQyteti;
    private javax.swing.JButton EditKomuna;
    private javax.swing.JButton EditQyteti;
    private javax.swing.JTextField EmriKomuna;
    private javax.swing.JTextField EmriQyteti;
    private javax.swing.JTextField IDKomuna;
    private javax.swing.JTextField IDQyteti;
    private javax.swing.JTable KomunaT;
    private javax.swing.JComboBox QytetiBox;
    private javax.swing.JTable QytetiT;
    private javax.swing.JButton SaveKomuna;
    private javax.swing.JButton SaveQyteti;
    private javax.swing.JTextField ZipQyteti;
    private java.awt.Choice choice1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
