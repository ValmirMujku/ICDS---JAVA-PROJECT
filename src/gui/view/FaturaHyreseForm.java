/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.FaturaHyrese;
import BLL.Hyrjet;
import BLL.Produkti;
import BLL.Stoku;
import DAL.FaturaHyreseRepository;
import DAL.HyrjetRepository;
import Exceptions.ProduktiException;
import DAL.ProduktiRepository;
import DAL.StokuRepository;
import Exceptions.FaturaHyreseException;
import gui.model.FaturaHyreseTable;
import gui.model.ProduktiComboBox;
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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class FaturaHyreseForm extends javax.swing.JInternalFrame {

    FaturaHyreseRepository fhr = new FaturaHyreseRepository();
    ProduktiRepository pr = new ProduktiRepository();
    FaturaHyreseTable fht;
    BigDecimal tot = new BigDecimal("0.00");
    StokuRepository str = new StokuRepository();
    HyrjetRepository hr = new HyrjetRepository();

    public FaturaHyreseForm() throws ProduktiException, FaturaHyreseException {
        initComponents();
        shfaqTabelen();
        loadbox();
        tabelaSelectedIndexChange();
        time();
        disableFaturaHyreseFormDrag();
 
        setFormFullScren();
    }
    
   private void setFormFullScren(){
        int xsize = (int)gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int)gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize,ysize);  
    }
    public void loadbox() throws ProduktiException {
        ProduktiComboBox qc;
        List<Produkti> lista = pr.findAll();
        qc = new ProduktiComboBox(lista);
        this.ProduktiFComboBox.setModel(qc);

    }

    public void shfaqTabelen() throws FaturaHyreseException {
        List<FaturaHyrese> lista = fhr.findAll();
        fht = new FaturaHyreseTable(lista);
        FaturaHT.setModel(fht);
        fht.fireTableDataChanged();
        FaturaHT.getColumnModel().getColumn(0).setPreferredWidth(7);
        FaturaHT.getColumnModel().getColumn(3).setPreferredWidth(120);
        FaturaHT.getColumnModel().getColumn(7).setPreferredWidth(120);
    }

    public void pastrofushat() throws ProduktiException {
        FaturaHT.clearSelection();
        PaletaFH.setText("");
        PaketaFH.setText("");
        CopeFH.setText("");
        CmimiFH.setText("");
        PaleteCmim.setText("");
        CopCmim.setText("");
        DataSkadences.setDate(null);
        ProduktiFComboBox.setSelectedItem(-1);
        loadbox();
    }

    public boolean simboletPaleta() {
        int COUNT = 0;
        char[] shkronjat = PaletaFH.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }
        }
        if (COUNT == PaletaFH.getText().length()) {
            return true;
        }
        return false;
    }

    public boolean simboletPaketa() {
        int COUNT = 0;
        char[] shkronjat = PaketaFH.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }
        }
        if (COUNT == PaketaFH.getText().length()) {
            return true;
        }
        return false;
    }

    public boolean simboletCopa() {
        int COUNT = 0;
        char[] shkronjat = CopeFH.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }
        }
        if (COUNT == CopeFH.getText().length()) {
            return true;
        }
        return false;
    }

    public boolean egzistonProdukti() throws FaturaHyreseException {
        List<FaturaHyrese> lista = fhr.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                return true;
            }
        }
        return false;
    }

    public boolean saveValid() {
        if (PaletaFH.getText().equals("") && PaketaFH.getText().equals("") && CopeFH.getText().equals("")
                && CmimiFH.getText().equals("") && ProduktiFComboBox.getSelectedItem() == null && DataSkadences.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ju nuk keni plotësuar asnjë rubrikë.");
        } else if (PaletaFH.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Nuk lejohet Sasia 0.");
        } else if (PaketaFH.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Nuk lejohet Sasia 0.");
        } else if (CopeFH.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Nuk lejohet Sasia 0.");
        } else if (PaletaFH.getText().equals("") && PaketaFH.getText().equals("") && CopeFH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ju jeni të obliguar të caktoni njërën nga sasitë e Produktit.");
        } else if (ProduktiFComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Ju duhet ta zgjedhni Produktin.");
        } else if (simboletPaleta() == false) {
            JOptionPane.showMessageDialog(this, "Simbole te panjohura ne rubriken Paleta.");
        } else if (simboletPaketa() == false) {
            JOptionPane.showMessageDialog(this, "Simbole te panjohura ne rubriken Paketa.");
        } else if (simboletCopa() == false) {
            JOptionPane.showMessageDialog(this, "Simbole te panjohura ne rubriken Copa.");
        } else {
            return true;
        }
        return false;
    }

    public boolean maxvlere() {
        int rez;
        rez = tot.compareTo(new BigDecimal(CmimiFH.getText()));
        if (rez == 1 || rez == 0) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        FaturaHyreseBackground = new javax.swing.JPanel();
        SaveFaturaH = new javax.swing.JButton();
        CancelFH = new javax.swing.JButton();
        DeleteFH = new javax.swing.JButton();
        EditFH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PaletaFH = new javax.swing.JTextField();
        PaketaFH = new javax.swing.JTextField();
        CopeFH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProduktiFComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        PaleteCmim = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CmimiFH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CopCmim = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FaturaHT = new javax.swing.JTable();
        PrintoFH = new javax.swing.JButton();
        DeleteALLFH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TotaliFH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        kohaBFH = new javax.swing.JLabel();
        DataSkadences = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Fatura Hyrëse");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        FaturaHyreseBackground.setBackground(new java.awt.Color(153, 153, 255));
        FaturaHyreseBackground.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        FaturaHyreseBackground.setPreferredSize(new java.awt.Dimension(1205, 555));

        SaveFaturaH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SaveFaturaH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        SaveFaturaH.setText("SAVE");
        SaveFaturaH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFaturaHActionPerformed(evt);
            }
        });

        CancelFH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CancelFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-30.png"))); // NOI18N
        CancelFH.setText("CANCEL");
        CancelFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelFHActionPerformed(evt);
            }
        });

        DeleteFH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        DeleteFH.setText("DELETE");
        DeleteFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteFHActionPerformed(evt);
            }
        });

        EditFH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EditFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-edit-file-30.png"))); // NOI18N
        EditFH.setText("EDIT");
        EditFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditFHActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("Sasia:");

        PaletaFH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PaletaFH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaletaFHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaletaFHMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PaletaFHMousePressed(evt);
            }
        });

        PaketaFH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PaketaFH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaketaFHMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PaketaFHMouseReleased(evt);
            }
        });
        PaketaFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaketaFHActionPerformed(evt);
            }
        });

        CopeFH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CopeFH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CopeFHMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CopeFHMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setText("Paleta");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel7.setText("Paketa");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setText("Copë");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Produkti");

        ProduktiFComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProduktiFComboBox.setPreferredSize(new java.awt.Dimension(65, 10));
        ProduktiFComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProduktiFComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Cmimi");

        PaleteCmim.setEditable(false);
        PaleteCmim.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel9.setText("€");

        CmimiFH.setEditable(false);
        CmimiFH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CmimiFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmimiFHActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel11.setText("€");

        CopCmim.setEditable(false);
        CopCmim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CopCmim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopCmimActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel12.setText("€");

        FaturaHT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(FaturaHT);

        PrintoFH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PrintoFH.setForeground(new java.awt.Color(51, 153, 0));
        PrintoFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-print-20.png"))); // NOI18N
        PrintoFH.setText("PRINT");
        PrintoFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintoFHActionPerformed(evt);
            }
        });

        DeleteALLFH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteALLFH.setForeground(new java.awt.Color(204, 0, 0));
        DeleteALLFH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-close-window-20.png"))); // NOI18N
        DeleteALLFH.setText("Delete All");
        DeleteALLFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteALLFHActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comp/Total-Commander-icon.png"))); // NOI18N
        jLabel1.setText("TOTALI");

        TotaliFH.setEditable(false);
        TotaliFH.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel10.setText("€");

        kohaBFH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kohaBFH.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel13.setText("SKADENCA");

        javax.swing.GroupLayout FaturaHyreseBackgroundLayout = new javax.swing.GroupLayout(FaturaHyreseBackground);
        FaturaHyreseBackground.setLayout(FaturaHyreseBackgroundLayout);
        FaturaHyreseBackgroundLayout.setHorizontalGroup(
            FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditFH)
                    .addComponent(SaveFaturaH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelFH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteFH))
                .addGap(174, 174, 174)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PaketaFH, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CopeFH, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addComponent(PaletaFH, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addGap(115, 115, 115)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                .addComponent(CmimiFH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                .addComponent(PaleteCmim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addComponent(CopCmim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DataSkadences, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProduktiFComboBox, 0, 180, Short.MAX_VALUE))
                .addGap(87, 87, 87))
            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotaliFH, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PrintoFH, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DeleteALLFH))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(kohaBFH, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelFH, DeleteFH, EditFH});

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CopeFH, PaketaFH});

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CmimiFH, CopCmim, PaleteCmim});

        FaturaHyreseBackgroundLayout.setVerticalGroup(
            FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProduktiFComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(189, 189, 189))
                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(kohaBFH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FaturaHyreseBackgroundLayout.createSequentialGroup()
                                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(PaletaFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(17, 17, 17)
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(PaketaFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CopeFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))
                                    .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(PaleteCmim, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CmimiFH, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel3))
                                        .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(CopCmim, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(FaturaHyreseBackgroundLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(DataSkadences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)))))))
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FaturaHyreseBackgroundLayout.createSequentialGroup()
                                .addComponent(SaveFaturaH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CancelFH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteFH)
                                .addGap(18, 18, 18)
                                .addComponent(EditFH)
                                .addGap(63, 63, 63)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FaturaHyreseBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotaliFH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(PrintoFH)
                    .addComponent(DeleteALLFH))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CancelFH, CmimiFH, CopCmim, CopeFH, DeleteFH, EditFH, PaketaFH, PaletaFH, PaleteCmim, ProduktiFComboBox, jLabel2, jLabel3, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TotaliFH, jLabel1, jLabel10});

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DeleteALLFH, PrintoFH});

        FaturaHyreseBackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DataSkadences, jLabel13});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel4)
                .addContainerGap(1080, Short.MAX_VALUE))
            .addComponent(FaturaHyreseBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(FaturaHyreseBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveFaturaHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFaturaHActionPerformed
        try {
            if (saveValid() == true) {
                FaturaHyrese fh = new FaturaHyrese();

                if (egzistonProdukti() == true) {
                    JOptionPane.showMessageDialog(this, "Produkti eshte regjistruar si hyrje më parë.");
                    return;
                } else {
                    fh.setProduktiID((Produkti) ProduktiFComboBox.getSelectedItem());
                }

                fh.setData(new Date());
                fh.setDataeSkadences(DataSkadences.getDate());
                if (PaketaFH.getText().equals("") && CopeFH.getText().equals("")) {
                    BigDecimal paleta = new BigDecimal(PaletaFH.getText());
                    BigDecimal paketa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal copa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal shumaPaketa = paleta.multiply(paketa);
                    BigDecimal shumaCopa = shumaPaketa.multiply(copa);
                    String shP = shumaPaketa.toString();
                    String shC = shumaCopa.toString();
                    PaketaFH.setText(shP.substring(0, shP.length() - 0));
                    CopeFH.setText(shC.substring(0, shC.length() - 1));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    //----------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaPaketa);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd = tot.toString();
                    TotaliFH.setText(asd);
                    //----------------------------------------------//
                    int count = 0;
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            count++;
//                            lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
//                            lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
//                            lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));

                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());
                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa2);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }
                    if (count == 0) {
                        JOptionPane.showMessageDialog(this, "Produkti nuk është i regjistruar ne Stok.");
                        TotaliFH.setText("");
                        try {
                            pastrofushat();
                        } catch (ProduktiException ex) {
                            ex.printStackTrace();
                        }
                        return;
                    }
                } else if (PaletaFH.getText().equals("") && CopeFH.getText().equals("")) {
                    BigDecimal paketa = new BigDecimal(PaketaFH.getText());
                    BigDecimal copa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal paketa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal shumaPalete = paketa.divide(paketa2, 1, RoundingMode.CEILING);
                    BigDecimal shumaCope = paketa.multiply(copa);
                    String shPal = shumaPalete.toString();
                    String shCop = shumaCope.toString();
                    PaletaFH.setText(shPal.substring(0, shPal.length() - 0));
                    CopeFH.setText(shCop.substring(0, shCop.length() - 0));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    //--------------------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(paketa);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd = tot.toString();
                    TotaliFH.setText(asd);
                    //----------------------------------------------//
                    int count = 0;
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            count++;

                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;

                        }

                    }
                    if (count == 0) {
                        JOptionPane.showMessageDialog(this, "Produkti nuk është i regjistruar ne Stok.");
                        TotaliFH.setText("");
                        try {
                            pastrofushat();
                        } catch (ProduktiException ex) {
                            ex.printStackTrace();
                        }
                        return;
                    }
                } else if (PaletaFH.getText().equals("") && PaketaFH.getText().equals("")) {
                    BigDecimal copa = new BigDecimal(CopeFH.getText());
                    BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal pako2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal shumaPako = copa.divide(copa2, 1, RoundingMode.CEILING);
                    BigDecimal shumaPalete = shumaPako.divide(pako2, 1, RoundingMode.CEILING);
                    String shPak = shumaPako.toString();
                    String shPal = shumaPalete.toString();
                    PaletaFH.setText(shPal.substring(0, shPal.length() - 0));
                    PaketaFH.setText(shPak.substring(0, shPak.length() - 0));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    //----------------------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaPako);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd = tot.toString();
                    TotaliFH.setText(asd);
                    //----------------------------------------------//
                    int count = 0;
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            count++;
                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa3);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }
                    if (count == 0) {
                        JOptionPane.showMessageDialog(this, "Produkti nuk është i regjistruar ne Stok.");
                        TotaliFH.setText("");
                        try {
                            pastrofushat();
                        } catch (ProduktiException ex) {
                            ex.printStackTrace();
                        }
                        return;
                    }
                } else if (CopeFH.getText().equals("")) {
                    BigDecimal Paleta = new BigDecimal(PaletaFH.getText());
                    BigDecimal Paketa = new BigDecimal(PaketaFH.getText());
                    BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                    BigDecimal shumaPaletPaket = Paleta.multiply(paketaProd);
                    BigDecimal shumaPaletCope = shumaPaletPaket.multiply(copaProd);
                    BigDecimal shumaPaketCope = Paketa.multiply(copaProd);
                    BigDecimal shumaPaketPalet = Paketa.divide(paketaProd, 1, RoundingMode.CEILING);
                    BigDecimal shumaTotPalet = Paleta.add(shumaPaketPalet);
                    BigDecimal shumaTotPaket = Paketa.add(shumaPaletPaket);
                    BigDecimal shumaTotCope = shumaPaletCope.add(shumaPaketCope);
                    String asd = shumaTotPalet.toString();
                    String asd1 = shumaTotPaket.toString();
                    String asd2 = shumaTotCope.toString();
                    PaletaFH.setText(asd.substring(0, asd.length() - 0));
                    PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                    CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    //----------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotPaket);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd3 = tot.toString();
                    TotaliFH.setText(asd3);
                    //--------------------------------------------------//
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }
                } else if (PaletaFH.getText().equals("")) {
                    BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                    BigDecimal Paketa = new BigDecimal(PaketaFH.getText());
                    BigDecimal Copa = new BigDecimal(CopeFH.getText());
                    BigDecimal totcop = paketaProd.multiply(copaProd);

                    BigDecimal shumaPaketeCope = Paketa.multiply(copaProd);
                    BigDecimal shumaPaketPalet = Paketa.divide(paketaProd, 1, RoundingMode.CEILING);

                    BigDecimal shumaCopePakete = Copa.divide(copaProd, 1, RoundingMode.CEILING);
                    BigDecimal shumaCopePalete = Copa.divide(totcop, 1, RoundingMode.CEILING);

                    BigDecimal shumaTotalPalete = shumaPaketPalet.add(shumaCopePalete);
                    BigDecimal shumaTotalPaket = Paketa.add(shumaCopePakete);
                    BigDecimal shumaTotalCope = Copa.add(shumaPaketeCope);

                    String asd = shumaTotalPalete.toString();
                    String asd1 = shumaTotalPaket.toString();
                    String asd2 = shumaTotalCope.toString();
                    PaletaFH.setText(asd.substring(0, asd.length() - 0));
                    PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                    CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    //----------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotalPaket);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd3 = tot.toString();
                    TotaliFH.setText(asd3);
                    //--------------------------------------------------//
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }

                } else if (PaketaFH.getText().equals("")) {
                    BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                    BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                    BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                    BigDecimal Copa = new BigDecimal(CopeFH.getText());
                    BigDecimal Paleta = new BigDecimal(PaletaFH.getText());

                    BigDecimal totcop = paketaProd.multiply(copaProd);
                    BigDecimal shumaPaletPaket = Paleta.multiply(paketaProd);
                    BigDecimal shumaPaletCope = shumaPaletPaket.multiply(copaProd);

                    BigDecimal shumaCopePakete = Copa.divide(copaProd, 1, RoundingMode.CEILING);
                    BigDecimal shumaCopePalete = Copa.divide(totcop, 1, RoundingMode.CEILING);

                    BigDecimal shumaTotPalete = Paleta.add(shumaCopePalete);
                    BigDecimal shumaTotCope = Copa.add(shumaPaletCope);
                    BigDecimal shumaTotPakete = shumaPaletPaket.add(shumaCopePakete);

                    String asd = shumaTotPalete.toString();
                    String asd1 = shumaTotPakete.toString();
                    String asd2 = shumaTotCope.toString();
                    PaletaFH.setText(asd.substring(0, asd.length() - 0));
                    PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                    CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    //----------------------------------------------//
                    BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotPakete);
                    String cc = c.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd3 = tot.toString();
                    TotaliFH.setText(asd3);
                    //--------------------------------------------------//
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }

                } else {
                    fh.setPalete(new BigDecimal(PaletaFH.getText()));
                    fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                    fh.setCope(new BigDecimal(CopeFH.getText()));
                    BigDecimal paketaCmim = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(new BigDecimal(PaketaFH.getText()));
                    BigDecimal CopCmimi = new BigDecimal(CopCmim.getText()).multiply(new BigDecimal(CopeFH.getText()));
                    BigDecimal PaletCmim = new BigDecimal(PaleteCmim.getText()).multiply(new BigDecimal(PaletaFH.getText()));
                    BigDecimal totaliCmimi = paketaCmim.add(CopCmimi).add(PaletCmim);
                    String cc = totaliCmimi.toString();
                    CmimiFH.setText(cc.substring(0, cc.length() - 2));
                    fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                    tot = tot.add(new BigDecimal(CmimiFH.getText()));
                    String asd3 = tot.toString();
                    TotaliFH.setText(asd3);
                    //-----------------------------------//
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String sdata = formatter.format(lista.get(i).getDataSkadencesProd());
                            String sdata2 = formatter.format(DataSkadences.getDate());
                            String sdata3 = formatter.format(new Date());

                            BigDecimal zero = new BigDecimal("0");
                            int rez = lista.get(i).getPaketa().compareTo(zero);
                            int rez1 = lista.get(i).getPalete().compareTo(zero);
                            int rez2 = lista.get(i).getCope().compareTo(zero);
                            if (rez == 0 && rez1 == 0 && rez2 == 0) {

                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                str.edit(lista.get(i));
                            } else if (sdata.equals(sdata2)) {
                                lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                str.edit(lista.get(i));
                            } else {
                                BigDecimal paleta2 = new BigDecimal(PaletaFH.getText());
                                BigDecimal paketa3 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                                BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                                BigDecimal shumaPaketa2 = paleta2.multiply(paketa3);
                                BigDecimal shumaCopa2 = shumaPaketa2.multiply(copa2);
                                String shP2 = shumaPaketa2.toString();
                                String shC2 = shumaCopa2.toString();
                                PaketaFH.setText(shP2.substring(0, shP2.length() - 0));
                                CopeFH.setText(shC2.substring(0, shC2.length() - 1));
                                Stoku s = new Stoku();
                                s.setProduktiID(lista.get(i).getProduktiID());
                                s.setPalete(new BigDecimal(PaletaFH.getText()));
                                s.setPaketa(new BigDecimal(PaketaFH.getText()));;
                                s.setCope(new BigDecimal(CopeFH.getText()));
                                s.setDataSkadencesProd(DataSkadences.getDate());
                                str.create(s);
                            }
                            break;
                        }

                    }

                }

                fhr.create(fh);
                shfaqTabelen();
                try {
                    pastrofushat();
                } catch (ProduktiException ex) {
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_SaveFaturaHActionPerformed

    private void ProduktiFComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProduktiFComboBoxActionPerformed
        CmimiFH.setText(((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().toString());
//        PaleteCmim.setText((((Produkti)ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(((Produkti)ProduktiFComboBox.getSelectedItem()).getPaketa())));
        BigDecimal cmimiPalet = (((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa()));
        String asd = cmimiPalet.toString();
        PaleteCmim.setText(asd.substring(0, asd.length() - 2));
        BigDecimal cmimiCope = (((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().divide(((Produkti) ProduktiFComboBox.getSelectedItem()).getCope(), 2, RoundingMode.CEILING));
        String asd1 = cmimiCope.toString();
        CopCmim.setText(asd1.substring(0, asd1.length() - 0));
    }//GEN-LAST:event_ProduktiFComboBoxActionPerformed

    private void PaketaFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaketaFHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaketaFHActionPerformed

    private void CancelFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelFHActionPerformed
        try {
            pastrofushat();
        } catch (ProduktiException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_CancelFHActionPerformed

    private void DeleteFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFHActionPerformed
        try {
            int row = FaturaHT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    FaturaHyrese fh = fht.getFaturaHyrese(row);
                    fhr.remove(fh);
                    if (tot.intValue() > 0 && maxvlere() == true) {
                        BigDecimal totcmim = new BigDecimal(CmimiFH.getText()).multiply(new BigDecimal(PaketaFH.getText()));
                        tot = tot.subtract(totcmim);
                        String asd1 = tot.toString();
                        TotaliFH.setText(asd1);
                    }
                    List<Stoku> lista = str.findAll();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                            BigDecimal shuma = lista.get(i).getPalete().subtract(new BigDecimal(PaletaFH.getText()));
                            String asd = shuma.toString();
                            lista.get(i).setPalete(shuma);

                            BigDecimal shuma2 = lista.get(i).getPaketa().subtract(new BigDecimal(PaketaFH.getText()));
                            String asd1 = shuma2.toString();
                            lista.get(i).setPaketa(shuma2);

                            BigDecimal shuma3 = lista.get(i).getCope().subtract(new BigDecimal(CopeFH.getText()));
                            String asd2 = shuma3.toString();
                            lista.get(i).setCope(shuma3);
                            str.edit(lista.get(i));
                        }

                    }
                    try {
                        pastrofushat();
                    } catch (ProduktiException ex) {
                        ex.printStackTrace();
                    }
                    shfaqTabelen();
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_DeleteFHActionPerformed

    public void DeleteALLFH() {
        try {
            int result2;
            Object[] ob = {"Po", "Jo"};
            result2 = JOptionPane.showOptionDialog(this, "A dëshironi ti fshini te gjitha te dhenat ne tabele ?", "DeleteAll", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (result2 == 0) {
                List<FaturaHyrese> lista;
                lista = fhr.findAll();
                for (int i = 0; i < lista.size(); i++) {
                    fhr.remove(lista.get(i));
                }
                TotaliFH.setText("");
                shfaqTabelen();
            }
        } catch (Exception e) {
        }
    }
    private void EditFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditFHActionPerformed
        try {
            int row = FaturaHT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, " \"KUJDES\" Editimi nuk ka kthim mbrapa?", "Editimi", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    if (saveValid() == true) {
                        FaturaHyrese fh = new FaturaHyrese();
                        fh.setProduktiID((Produkti) ProduktiFComboBox.getSelectedItem());

                        fh.setData(new Date());
                        fh.setDataeSkadences(DataSkadences.getDate());
                        if (PaketaFH.getText().equals("") && CopeFH.getText().equals("")) {
                            BigDecimal paleta = new BigDecimal(PaletaFH.getText());
                            BigDecimal paketa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal copa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal shumaPaketa = paleta.multiply(paketa);
                            BigDecimal shumaCopa = shumaPaketa.multiply(copa);
                            String shP = shumaPaketa.toString();
                            String shC = shumaCopa.toString();
                            PaketaFH.setText(shP.substring(0, shP.length() - 0));
                            CopeFH.setText(shC.substring(0, shC.length() - 1));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            //----------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaPaketa);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd = tot.toString();
                            TotaliFH.setText(asd);
                            //----------------------------------------------//

                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {

                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }

                        } else if (PaletaFH.getText().equals("") && CopeFH.getText().equals("")) {
                            BigDecimal paketa = new BigDecimal(PaketaFH.getText());
                            BigDecimal copa = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal paketa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal shumaPalete = paketa.divide(paketa2, 1, RoundingMode.CEILING);
                            BigDecimal shumaCope = paketa.multiply(copa);
                            String shPal = shumaPalete.toString();
                            String shCop = shumaCope.toString();
                            PaletaFH.setText(shPal.substring(0, shPal.length() - 0));
                            CopeFH.setText(shCop.substring(0, shCop.length() - 0));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            //--------------------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(paketa);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd = tot.toString();
                            TotaliFH.setText(asd);
                            //----------------------------------------------//

                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {

                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }

                        } else if (PaletaFH.getText().equals("") && PaketaFH.getText().equals("")) {
                            BigDecimal copa = new BigDecimal(CopeFH.getText());
                            BigDecimal copa2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal pako2 = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal shumaPako = copa.divide(copa2, 1, RoundingMode.CEILING);
                            BigDecimal shumaPalete = shumaPako.divide(pako2, 1, RoundingMode.CEILING);
                            String shPak = shumaPako.toString();
                            String shPal = shumaPalete.toString();
                            PaletaFH.setText(shPal.substring(0, shPal.length() - 0));
                            PaketaFH.setText(shPak.substring(0, shPak.length() - 0));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            //----------------------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaPako);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd = tot.toString();
                            TotaliFH.setText(asd);
                            //----------------------------------------------//
                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }

                        } else if (CopeFH.getText().equals("")) {
                            BigDecimal Paleta = new BigDecimal(PaletaFH.getText());
                            BigDecimal Paketa = new BigDecimal(PaketaFH.getText());
                            BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                            BigDecimal shumaPaletPaket = Paleta.multiply(paketaProd);
                            BigDecimal shumaPaletCope = shumaPaletPaket.multiply(copaProd);
                            BigDecimal shumaPaketCope = Paketa.multiply(copaProd);
                            BigDecimal shumaPaketPalet = Paketa.divide(paketaProd, 1, RoundingMode.CEILING);
                            BigDecimal shumaTotPalet = Paleta.add(shumaPaketPalet);
                            BigDecimal shumaTotPaket = Paketa.add(shumaPaletPaket);
                            BigDecimal shumaTotCope = shumaPaletCope.add(shumaPaketCope);
                            String asd = shumaTotPalet.toString();
                            String asd1 = shumaTotPaket.toString();
                            String asd2 = shumaTotCope.toString();
                            PaletaFH.setText(asd.substring(0, asd.length() - 0));
                            PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                            CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            //----------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotPaket);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd3 = tot.toString();
                            TotaliFH.setText(asd3);
                            //--------------------------------------------------//
                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }
                        } else if (PaletaFH.getText().equals("")) {
                            BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                            BigDecimal Paketa = new BigDecimal(PaketaFH.getText());
                            BigDecimal Copa = new BigDecimal(CopeFH.getText());
                            BigDecimal totcop = paketaProd.multiply(copaProd);

                            BigDecimal shumaPaketeCope = Paketa.multiply(copaProd);
                            BigDecimal shumaPaketPalet = Paketa.divide(paketaProd, 1, RoundingMode.CEILING);

                            BigDecimal shumaCopePakete = Copa.divide(copaProd, 1, RoundingMode.CEILING);
                            BigDecimal shumaCopePalete = Copa.divide(totcop, 1, RoundingMode.CEILING);

                            BigDecimal shumaTotalPalete = shumaPaketPalet.add(shumaCopePalete);
                            BigDecimal shumaTotalPaket = Paketa.add(shumaCopePakete);
                            BigDecimal shumaTotalCope = Copa.add(shumaPaketeCope);

                            String asd = shumaTotalPalete.toString();
                            String asd1 = shumaTotalPaket.toString();
                            String asd2 = shumaTotalCope.toString();
                            PaletaFH.setText(asd.substring(0, asd.length() - 0));
                            PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                            CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            //----------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotalPaket);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd3 = tot.toString();
                            TotaliFH.setText(asd3);
                            //--------------------------------------------------//
                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }

                        } else if (PaketaFH.getText().equals("")) {
                            BigDecimal paketaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPaketa();
                            BigDecimal copaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCope();
                            BigDecimal PaletaProd = ((Produkti) ProduktiFComboBox.getSelectedItem()).getPalete();
                            BigDecimal Copa = new BigDecimal(CopeFH.getText());
                            BigDecimal Paleta = new BigDecimal(PaletaFH.getText());

                            BigDecimal totcop = paketaProd.multiply(copaProd);
                            BigDecimal shumaPaletPaket = Paleta.multiply(paketaProd);
                            BigDecimal shumaPaletCope = shumaPaletPaket.multiply(copaProd);

                            BigDecimal shumaCopePakete = Copa.divide(copaProd, 1, RoundingMode.CEILING);
                            BigDecimal shumaCopePalete = Copa.divide(totcop, 1, RoundingMode.CEILING);

                            BigDecimal shumaTotPalete = Paleta.add(shumaCopePalete);
                            BigDecimal shumaTotCope = Copa.add(shumaPaletCope);
                            BigDecimal shumaTotPakete = shumaPaletPaket.add(shumaCopePakete);

                            String asd = shumaTotPalete.toString();
                            String asd1 = shumaTotPakete.toString();
                            String asd2 = shumaTotCope.toString();
                            PaletaFH.setText(asd.substring(0, asd.length() - 0));
                            PaketaFH.setText(asd1.substring(0, asd1.length() - 0));
                            CopeFH.setText(asd2.substring(0, asd2.length() - 0));
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            //----------------------------------------------//
                            BigDecimal c = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(shumaTotPakete);
                            String cc = c.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd3 = tot.toString();
                            TotaliFH.setText(asd3);
                            //--------------------------------------------------//
                            List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }

                        } else {
                            fh.setPalete(new BigDecimal(PaletaFH.getText()));
                            fh.setPaketa(new BigDecimal(PaketaFH.getText()));
                            fh.setCope(new BigDecimal(CopeFH.getText()));
                            fh.setDataeSkadences(DataSkadences.getDate());
                            BigDecimal paketaCmim = ((Produkti) ProduktiFComboBox.getSelectedItem()).getCmimi().multiply(new BigDecimal(PaketaFH.getText()));
                            BigDecimal CopCmimi = new BigDecimal(CopCmim.getText()).multiply(new BigDecimal(CopeFH.getText()));
                            BigDecimal PaletCmim = new BigDecimal(PaleteCmim.getText()).multiply(new BigDecimal(PaletaFH.getText()));
                            BigDecimal totaliCmimi = paketaCmim.add(CopCmimi).add(PaletCmim);
                            String cc = totaliCmimi.toString();
                            CmimiFH.setText(cc.substring(0, cc.length() - 2));
                            fh.setCmimi(new BigDecimal(CmimiFH.getText()));
                            tot = tot.add(new BigDecimal(CmimiFH.getText()));
                            String asd3 = tot.toString();
                            TotaliFH.setText(asd3);
                             List<Stoku> lista = str.findAll();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getProduktiID().equals((Produkti) ProduktiFComboBox.getSelectedItem())) {
                                    lista.get(i).setPalete(new BigDecimal(PaletaFH.getText()).add(lista.get(i).getPalete()));
                                    lista.get(i).setPaketa(new BigDecimal(PaketaFH.getText()).add(lista.get(i).getPaketa()));
                                    lista.get(i).setCope(new BigDecimal(CopeFH.getText()).add(lista.get(i).getCope()));
                                    lista.get(i).setDataSkadencesProd(DataSkadences.getDate());
                                    str.edit(lista.get(i));
                                }

                            }
                        }
                        fhr.edit(fh);
                        shfaqTabelen();
                        try {
                            pastrofushat();
                        } catch (ProduktiException ex) {
                        }
                    }
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_EditFHActionPerformed

    private void DeleteALLFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteALLFHActionPerformed
        DeleteALLFH();
        try {
            pastrofushat();
        } catch (ProduktiException ex) {
        }
    }//GEN-LAST:event_DeleteALLFHActionPerformed

    public void printofaturen() throws PrinterException {
        try {
            int choice;
            int count = 1;
            choice = JOptionPane.showConfirmDialog(null, "Deshironi ta shtypni Faturen.", "Kujdes!", JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                if (TotaliFH.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Krijoni nje Fature, para se ta shtypni.");
                    return;
                }
                Format formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
                String sdata = formatter.format(new Date());
                String string1 = "Fatura Hyrese  " + count;
                String asd = TotaliFH.getText().toString();
                String string2 = "TOTALI = " + asd + "  €" + "                                       Nenshkrimi:_________________";
                MessageFormat m1 = new MessageFormat(string1);
                MessageFormat m2 = new MessageFormat(string2);
                FaturaHT.print(JTable.PrintMode.FIT_WIDTH, m1, m2);
                Hyrjet h = new Hyrjet();

                List<FaturaHyrese> lista2 = fhr.findAll();
                BigDecimal paleta = new BigDecimal("0.00");
                BigDecimal paketa = new BigDecimal("0.00");
                BigDecimal copa = new BigDecimal("0.00");
                for (int i = 0; i < lista2.size(); i++) {
                    paleta = paleta.add(lista2.get(i).getPalete());
                    paketa = paketa.add(lista2.get(i).getPaketa());
                    copa = copa.add(lista2.get(i).getCope());
                }
                h.setData(new Date());
                h.setTotali(new BigDecimal(TotaliFH.getText()));
                String asd1 = paleta.toString();
                String asd2 = paketa.toString();
                String asd3 = copa.toString();
                h.setPalete(new BigDecimal(asd1));
                h.setPaketa(new BigDecimal(asd2));
                h.setCope(new BigDecimal(asd3));
                hr.create(h);
                List<FaturaHyrese> lista;
                lista = fhr.findAll();
                for (int i = 0; i < lista.size(); i++) {
                    fhr.remove(lista.get(i));
                }
                TotaliFH.setText("");
                shfaqTabelen();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void PrintoFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintoFHActionPerformed
        try {
            printofaturen();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_PrintoFHActionPerformed

    private void PaletaFHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaletaFHMouseClicked

    }//GEN-LAST:event_PaletaFHMouseClicked

    private void PaletaFHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaletaFHMousePressed

    }//GEN-LAST:event_PaletaFHMousePressed

    private void PaketaFHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaketaFHMouseReleased


    }//GEN-LAST:event_PaketaFHMouseReleased

    private void CopeFHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CopeFHMousePressed

    }//GEN-LAST:event_CopeFHMousePressed

    private void PaletaFHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaletaFHMouseEntered
//        PaketaFH.setEditable(false);
//        CopeFH.setEditable(false);
    }//GEN-LAST:event_PaletaFHMouseEntered

    private void PaketaFHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaketaFHMouseEntered
//        CopeFH.setEditable(false);
//        PaletaFH.setEditable(false);
    }//GEN-LAST:event_PaketaFHMouseEntered

    private void CopeFHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CopeFHMouseEntered
//         PaketaFH.setEditable(false);
//        PaletaFH.setEditable(false);
    }//GEN-LAST:event_CopeFHMouseEntered

    private void CmimiFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmimiFHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmimiFHActionPerformed

    private void CopCmimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopCmimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopCmimActionPerformed

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = FaturaHT.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    FaturaHyrese fh = fht.getFaturaHyrese(selectedIndex);
                    PaletaFH.setText(fh.getPalete() + "");
                    PaketaFH.setText(fh.getPaketa() + "");
                    CopeFH.setText(fh.getCope() + "");
                    CmimiFH.setText(fh.getCmimi() + "");
                    DataSkadences.setDate(fh.getDataeSkadences());
                    try {
                        loadbox();
                    } catch (ProduktiException ex) {
                        ex.printStackTrace();
                    }
                    ProduktiFComboBox.setSelectedItem(fh.getProduktiID());
                }
            }
        });
    }

    public void time() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String texte_date = sdf.format(new Date());
                kohaBFH.setText(texte_date);
            }
        }).start();

    }

    private void disableFaturaHyreseFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelFH;
    private javax.swing.JTextField CmimiFH;
    private javax.swing.JTextField CopCmim;
    private javax.swing.JTextField CopeFH;
    private com.toedter.calendar.JDateChooser DataSkadences;
    private javax.swing.JButton DeleteALLFH;
    private javax.swing.JButton DeleteFH;
    private javax.swing.JButton EditFH;
    private javax.swing.JTable FaturaHT;
    private javax.swing.JPanel FaturaHyreseBackground;
    private javax.swing.JTextField PaketaFH;
    private javax.swing.JTextField PaletaFH;
    private javax.swing.JTextField PaleteCmim;
    private javax.swing.JButton PrintoFH;
    private javax.swing.JComboBox ProduktiFComboBox;
    private javax.swing.JButton SaveFaturaH;
    private javax.swing.JTextField TotaliFH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kohaBFH;
    // End of variables declaration//GEN-END:variables
}
