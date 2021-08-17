/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Biznesi;
import BLL.Porosia;
import BLL.Porosite;
import BLL.Produkti;
import DAL.BiznesiInterface;
import DAL.BiznesiRepository;
import Exceptions.PorosiaException;
import DAL.PorosiaInterface;
import DAL.PorosiaRepository;
import DAL.PorositeInterface;
import DAL.PorositeRepository;
import DAL.ProduktiInterface;
import DAL.ProduktiRepository;
import Exceptions.BiznesiException;
import Exceptions.ProduktiException;
import gui.model.BiznesiComboBox;
import gui.model.PorosiaTableModel;
import gui.model.PorositeTableModel;
import gui.model.ProduktiComboBox;
import gui.model.ProduktiTableModel_PorosiaForm;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class PorosiaInternalForm extends javax.swing.JInternalFrame {

    PorosiaInterface pff = new PorosiaRepository();
    PorosiaTableModel potm;
    PorositeTableModel potma;
    ProduktiTableModel_PorosiaForm ptm;
    BiznesiInterface bi = new BiznesiRepository();
    ProduktiInterface pki = new ProduktiRepository();
    PorositeInterface prr = new PorositeRepository();
    Double shumaTotali = 0.0;

    /**
     * Creates new form PorosiaInternalForm
     */
    public PorosiaInternalForm() {
        initComponents();
        try {
            pastroTablePorosia();
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
        }
        try {
            loadTabelenPorosia();
            loadTabelenPorosite();
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
        }
        try {
            loadTabelenProduktet();
        } catch (ProduktiException ex) {
            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
        }
        loadboxProduktet();
        loadboxBizneset();
        tabelaSelectedIndexChange();
        ndryshoPozicionetIconave();
        disablePorosiaFormDrag();
        setNumriPorosive();
        setNumriProdukteveNeListe();

        setFormFullScren();//KJO

    }

    private void loadTabelenPorosia() throws PorosiaException {
        pff.findAll();
        List<Porosia> list = pff.findAll();
        potm = new PorosiaTableModel(list);
        listaProdukteve_table.setModel(potm);
        potm.fireTableDataChanged();

    }

    //KJO
    private void setFormFullScren() {
        int xsize = (int) gui.view.KlientiMainForm.desktopPane.getWidth();
        int ysize = (int) gui.view.KlientiMainForm.desktopPane.getHeight();
        this.setSize(xsize, ysize);
    }

    private void loadTabelenPorosite() {
        try {
            prr.findAll();
            List<Porosite> list = prr.findAll();
            potma = new PorositeTableModel(list);
            porositeTable.setModel(potma);
            potm.fireTableDataChanged();
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, "ICDS:" + ex);
        }
    }

    private void disablePorosiaFormDrag() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component northPane = ui.getNorthPane();
        MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

        for (MouseMotionListener listener : motionListeners) {
            northPane.removeMouseMotionListener(listener);
        }
    }

    private void ndryshoPozicionetIconave() {
        ShtoNeListeProduktin.setHorizontalTextPosition(SwingConstants.LEFT);
        FshijeProduktinBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        NdryshoProduktinBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        PastroHapsiratBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        FshijePorositeBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        BejPorosinteBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        PastroHapsiratBtn.setIconTextGap(20);
        FshijeProduktinBtn.setIconTextGap(15);
        FshijePorositeBtn.setIconTextGap(10);
        BejPorosinteBtn.setIconTextGap(10);
    }

    private void loadTabelenProduktet() throws ProduktiException {
        pki.findAll();
        List<Produkti> list = pki.findAll();
        ptm = new ProduktiTableModel_PorosiaForm(list);
        produktet_tabela_porosia.setModel(ptm);
        potm.fireTableDataChanged();

    }

    private void loadboxProduktet() {
        try {
            ProduktiComboBox qx;
            List<Produkti> lista = pki.findAll();
            qx = new ProduktiComboBox(lista);
            this.ProduktiComboBoxB1.setModel(qx);
            this.ProduktiComboBoxB2.setModel(qx);
        } catch (ProduktiException e) {
            JOptionPane.showMessageDialog(this, "ICDS:" + e);
        }

    }

    private void loadboxBizneset() {
        BiznesiComboBox qx;
        List<Biznesi> lista = bi.findAll();
        qx = new BiznesiComboBox(lista);
        this.BiznesiComboBoxB.setModel(qx);

    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = listaProdukteve_table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Porosia p = potm.getPorosia(selectedIndex);
                    //loadboxProduktet();
                    //loadboxBizneset();
                    sasia_Field.setText(p.getSasia() + "");
                    adresa_field_edit.setText(p.getAdresa() + "");
                    numri_pakovePerOrder_Field.setText(p.getSasia() + "");
                    BiznesiComboBoxB.setSelectedItem(p.getBiznesiID());

                }
            }
        });
    }

    private void pastroFields() {
        produktet_tabela_porosia.clearSelection();
        porositeTable.clearSelection();
        listaProdukteve_table.clearSelection();
        sasia_Field.setText("");
        adresa_field_edit.setText("");
        adresa_field.setText("");
        numri_pakovePerOrder_Field.setText("");
        BiznesiComboBoxB.setEnabled(true);
        adresa_field.setEnabled(true);
        adresa_field_edit.setEnabled(true);

    }

    private void pastroTablePorosia() throws PorosiaException {
        try {
            List<Porosia> lista = pff.findAll();
            for (int i = 0; i < lista.size(); i++) {
                pff.remove(lista.get(i));

            }
        } catch (PorosiaException ex) {
            Logger.getLogger(PorosiaInternalForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        NdryshoProduktinBtn = new javax.swing.JButton();
        FshijeProduktinBtn = new javax.swing.JButton();
        ShtoNeListeProduktin = new javax.swing.JButton();
        BiznesiComboBoxB = new javax.swing.JComboBox();
        qmimi_jlabel = new javax.swing.JLabel();
        zgjedh_biznesin_label = new javax.swing.JLabel();
        sasia_Field = new javax.swing.JTextField();
        sasia_nePako_jlabel = new javax.swing.JLabel();
        ProduktiComboBoxB2 = new javax.swing.JComboBox();
        numri_pakovePerOrder_Field = new javax.swing.JTextField();
        numri_pakove_jlabel = new javax.swing.JLabel();
        qmimi_per_parko_jlabel = new javax.swing.JLabel();
        ProduktiComboBoxB1 = new javax.swing.JComboBox();
        zgjedhProduktin_jLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProdukteve_table = new javax.swing.JTable();
        lista_porosive_jlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produktet_tabela_porosia = new javax.swing.JTable();
        available_products_jlabel = new javax.swing.JLabel();
        produkti_porosia_jlabel = new javax.swing.JLabel();
        adresa_field = new javax.swing.JTextField();
        adresa_porosia_jlabel = new javax.swing.JLabel();
        adresa_field_edit = new javax.swing.JTextField();
        adresajlabel_edit = new javax.swing.JLabel();
        PastroHapsiratBtn = new javax.swing.JButton();
        qmimiMeTVSH_jlabel = new javax.swing.JLabel();
        BejPorosinteBtn = new javax.swing.JButton();
        qmimi_per_parko_jlabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        porositeTable = new javax.swing.JTable();
        listaPorosiveTeBeraJlabel = new javax.swing.JLabel();
        FshijePorositeBtn = new javax.swing.JButton();
        NumriPorosiveTeBeraJlabel = new javax.swing.JLabel();
        actualNumberOfOrders = new javax.swing.JLabel();
        NumriProdukteveNeListeJlabel = new javax.swing.JLabel();
        actualNumberOfListProducts = new javax.swing.JLabel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(1205, 585));
        setNormalBounds(new java.awt.Rectangle(1205, 591, 591, 591));
        setPreferredSize(new java.awt.Dimension(1205, 585));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background.setMinimumSize(new java.awt.Dimension(1205, 600));
        background.setPreferredSize(new java.awt.Dimension(1205, 600));
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMouseClicked(evt);
            }
        });

        NdryshoProduktinBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NdryshoProduktinBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-edit-file-30.png"))); // NOI18N
        NdryshoProduktinBtn.setText("Ndrysho Produktin");
        NdryshoProduktinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NdryshoProduktinBtnActionPerformed(evt);
            }
        });

        FshijeProduktinBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        FshijeProduktinBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-delete-30.png"))); // NOI18N
        FshijeProduktinBtn.setText("Fshije Produktin");
        FshijeProduktinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FshijeProduktinBtnActionPerformed(evt);
            }
        });

        ShtoNeListeProduktin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ShtoNeListeProduktin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-buying-40.png"))); // NOI18N
        ShtoNeListeProduktin.setText("Shto Produktin në Listë");
        ShtoNeListeProduktin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShtoNeListeProduktinActionPerformed(evt);
            }
        });

        BiznesiComboBoxB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        BiznesiComboBoxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiznesiComboBoxBActionPerformed(evt);
            }
        });

        qmimi_jlabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        qmimi_jlabel.setForeground(new java.awt.Color(51, 0, 0));
        qmimi_jlabel.setText("-");

        zgjedh_biznesin_label.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        zgjedh_biznesin_label.setText("zgjedh biznesin:");

        sasia_Field.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sasia_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sasia_FieldActionPerformed(evt);
            }
        });

        sasia_nePako_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sasia_nePako_jlabel.setText("sasia në pako:");

        ProduktiComboBoxB2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ProduktiComboBoxB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProduktiComboBoxB2ActionPerformed(evt);
            }
        });

        numri_pakovePerOrder_Field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        numri_pakovePerOrder_Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        numri_pakove_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        numri_pakove_jlabel.setText("numri i pakove që dëshironi të porositni:");

        qmimi_per_parko_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        qmimi_per_parko_jlabel.setText("qmimi për pako(-TVSH):");

        ProduktiComboBoxB1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ProduktiComboBoxB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProduktiComboBoxB1ActionPerformed(evt);
            }
        });

        zgjedhProduktin_jLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        zgjedhProduktin_jLabel.setText("zgjedh produktin e dëshiruar:");

        listaProdukteve_table.setModel(new javax.swing.table.DefaultTableModel(
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
        listaProdukteve_table.setMaximumSize(new java.awt.Dimension(300, 64));
        listaProdukteve_table.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane2.setViewportView(listaProdukteve_table);

        lista_porosive_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lista_porosive_jlabel.setText("Produktet e shtuara në listë për porositje:");

        produktet_tabela_porosia.setModel(new javax.swing.table.DefaultTableModel(
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
        produktet_tabela_porosia.setMaximumSize(new java.awt.Dimension(300, 64));
        produktet_tabela_porosia.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(produktet_tabela_porosia);

        available_products_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        available_products_jlabel.setText("Produktet në dispozicion:");

        produkti_porosia_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        produkti_porosia_jlabel.setText("produkti:");

        adresa_porosia_jlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        adresa_porosia_jlabel.setText("adresa:");

        adresajlabel_edit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        adresajlabel_edit.setText("adresa:");

        PastroHapsiratBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        PastroHapsiratBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-available-updates-30.png"))); // NOI18N
        PastroHapsiratBtn.setText("Pastro Hapsirat");
        PastroHapsiratBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastroHapsiratBtnActionPerformed(evt);
            }
        });

        qmimiMeTVSH_jlabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        qmimiMeTVSH_jlabel.setForeground(new java.awt.Color(51, 0, 0));
        qmimiMeTVSH_jlabel.setText("-");

        BejPorosinteBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        BejPorosinteBtn.setForeground(new java.awt.Color(0, 153, 0));
        BejPorosinteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-buy-20.png"))); // NOI18N
        BejPorosinteBtn.setText("Bëj Porosinë");
        BejPorosinteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BejPorosinteBtnActionPerformed(evt);
            }
        });

        qmimi_per_parko_jlabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        qmimi_per_parko_jlabel1.setText("qmimi per pako(+TVSH):");

        jSeparator1.setBackground(new java.awt.Color(15, 15, 15));
        jSeparator1.setForeground(new java.awt.Color(15, 15, 15));
        jSeparator1.setOpaque(true);

        jSeparator2.setBackground(new java.awt.Color(15, 15, 15));
        jSeparator2.setForeground(new java.awt.Color(15, 15, 15));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        porositeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(porositeTable);

        listaPorosiveTeBeraJlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        listaPorosiveTeBeraJlabel.setText("Lista e porosive të bëra:");

        FshijePorositeBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        FshijePorositeBtn.setForeground(new java.awt.Color(153, 0, 0));
        FshijePorositeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-20.png"))); // NOI18N
        FshijePorositeBtn.setText("Fshije Porosinë");
        FshijePorositeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FshijePorositeBtnActionPerformed(evt);
            }
        });

        NumriPorosiveTeBeraJlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NumriPorosiveTeBeraJlabel.setText("Numri i porosive të bëra:");

        actualNumberOfOrders.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        NumriProdukteveNeListeJlabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NumriProdukteveNeListeJlabel.setText("Numri i produkteve në listë:");

        actualNumberOfListProducts.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(listaPorosiveTeBeraJlabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(NumriPorosiveTeBeraJlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actualNumberOfOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FshijePorositeBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(lista_porosive_jlabel)
                                        .addGap(196, 196, 196))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(NumriProdukteveNeListeJlabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(actualNumberOfListProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BejPorosinteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ProduktiComboBoxB2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(produkti_porosia_jlabel)
                                            .addComponent(sasia_nePako_jlabel)
                                            .addComponent(sasia_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(adresa_field_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(adresajlabel_edit)))))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(FshijeProduktinBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NdryshoProduktinBtn)
                                .addGap(38, 38, 38)
                                .addComponent(PastroHapsiratBtn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(available_products_jlabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zgjedhProduktin_jLabel)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(qmimi_per_parko_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qmimi_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ProduktiComboBoxB1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(qmimi_per_parko_jlabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qmimiMeTVSH_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ShtoNeListeProduktin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numri_pakove_jlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(numri_pakovePerOrder_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adresa_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BiznesiComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zgjedh_biznesin_label))
                            .addComponent(adresa_porosia_jlabel))
                        .addGap(43, 43, 43))))
        );

        backgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FshijeProduktinBtn, NdryshoProduktinBtn, PastroHapsiratBtn});

        backgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {qmimi_per_parko_jlabel, qmimi_per_parko_jlabel1});

        backgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BejPorosinteBtn, FshijePorositeBtn});

        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zgjedhProduktin_jLabel)
                            .addComponent(zgjedh_biznesin_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProduktiComboBoxB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BiznesiComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qmimi_per_parko_jlabel)
                                    .addComponent(qmimi_jlabel))
                                .addGap(50, 50, 50)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qmimiMeTVSH_jlabel)
                                    .addComponent(qmimi_per_parko_jlabel1)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(adresa_porosia_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adresa_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(numri_pakove_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numri_pakovePerOrder_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ShtoNeListeProduktin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(available_products_jlabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addComponent(listaPorosiveTeBeraJlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumriPorosiveTeBeraJlabel)
                                    .addComponent(actualNumberOfOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FshijePorositeBtn))
                                .addGap(97, 97, 97))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FshijeProduktinBtn)
                            .addComponent(NdryshoProduktinBtn)
                            .addComponent(PastroHapsiratBtn))
                        .addGap(55, 55, 55)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lista_porosive_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BejPorosinteBtn)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(NumriProdukteveNeListeJlabel))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(actualNumberOfListProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(produkti_porosia_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProduktiComboBoxB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(sasia_nePako_jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sasia_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adresajlabel_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adresa_field_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        backgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {qmimiMeTVSH_jlabel, qmimi_jlabel, qmimi_per_parko_jlabel, qmimi_per_parko_jlabel1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FshijeProduktinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FshijeProduktinBtnActionPerformed
        int row = listaProdukteve_table.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini porosine ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    BiznesiComboBoxB.setEnabled(true);
                    adresa_field.setEnabled(true);
                    Porosia p = potm.getPorosia(row);
                    pff.remove(p);
                    loadTabelenPorosia();
                    setNumriProdukteveNeListe();
                } catch (PorosiaException ex) {
                    JOptionPane.showMessageDialog(this, "ICDS: " + ex.getMessage());
                }
            }
            pastroFields();
            listaProdukteve_table.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_FshijeProduktinBtnActionPerformed

    private void sasia_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sasia_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sasia_FieldActionPerformed

    private void NdryshoProduktinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NdryshoProduktinBtnActionPerformed
        int row = listaProdukteve_table.getSelectedRow();
        if (row > -1) {
            Porosia po = potm.getPorosia(row);
            try {
                po.setProduktiID((Produkti) ProduktiComboBoxB2.getSelectedItem());
                po.setAdresa(adresa_field_edit.getText().replaceAll("\\s", ""));
            } catch (Exception ixe) {
                JOptionPane.showMessageDialog(this, "ICDS: " + ixe);
            }
            try {
                Integer sasiaNePako = Integer.parseInt(sasia_Field.getText());
                po.setSasia(sasiaNePako);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "ICDS: Sasia e pakove që dëshironi të porositni duhet te kete vlere numerike.");
                sasia_Field.setText("");
                return;
            }
            BigDecimal s = new BigDecimal(sasia_Field.getText());
            BigDecimal t = s.multiply(new BigDecimal(qmimiMeTVSH_jlabel.getText()));
            po.setTotali(t);

            double d = t.doubleValue();
            shumaTotali = shumaTotali + d;

            try {
                pff.edit(po);
                loadTabelenPorosia();
                setNumriProdukteveNeListe();
                numri_pakovePerOrder_Field.setText("");
            } catch (PorosiaException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat janë obligative për ta ndryshuar produktin në listë!");
        }


    }//GEN-LAST:event_NdryshoProduktinBtnActionPerformed

    private void ProduktiComboBoxB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProduktiComboBoxB2ActionPerformed
        Produkti p = (Produkti) ProduktiComboBoxB1.getSelectedItem();

        qmimi_jlabel.setText(p.getCmimi() + "");
        BigDecimal per = new BigDecimal("100.00");
        BigDecimal TVSH = new BigDecimal("18.00");
        BigDecimal cm = (((Produkti) ProduktiComboBoxB1.getSelectedItem()).getCmimi());
        BigDecimal perlog = cm.divide(per);
        BigDecimal tvshlog = perlog.multiply(TVSH);
        BigDecimal shuma = (((Produkti) ProduktiComboBoxB1.getSelectedItem()).getCmimi()).add(tvshlog);
        String stringshuma = shuma.toString();
        qmimiMeTVSH_jlabel.setText(stringshuma.substring(0, stringshuma.length() - 2));

        

     
    }//GEN-LAST:event_ProduktiComboBoxB2ActionPerformed

    private void BiznesiComboBoxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BiznesiComboBoxBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BiznesiComboBoxBActionPerformed


    private void ProduktiComboBoxB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProduktiComboBoxB1ActionPerformed
        Produkti p = (Produkti) ProduktiComboBoxB1.getSelectedItem();

        qmimi_jlabel.setText(p.getCmimi() + "");
        BigDecimal per = new BigDecimal("100.00");
        BigDecimal TVSH = new BigDecimal("18.00");
        BigDecimal cm = (((Produkti) ProduktiComboBoxB1.getSelectedItem()).getCmimi());
        BigDecimal perlog = cm.divide(per);
        BigDecimal tvshlog = perlog.multiply(TVSH);
        BigDecimal shuma = (((Produkti) ProduktiComboBoxB1.getSelectedItem()).getCmimi()).add(tvshlog);
        String stringshuma = shuma.toString();
        qmimiMeTVSH_jlabel.setText(stringshuma.substring(0, stringshuma.length() - 2));

       
      
    }//GEN-LAST:event_ProduktiComboBoxB1ActionPerformed

    private void ShtoNeListeProduktinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShtoNeListeProduktinActionPerformed
        if (!numri_pakovePerOrder_Field.getText().trim().equals("") && !adresa_field.getText().trim().equals("")) {
            Porosia p = new Porosia();
            String sasia_pako = numri_pakovePerOrder_Field.getText().replaceAll("\\s", "");
            if (ProduktiComboBoxB1.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "ICDS: Ju nuk keni zgjedhur llojin e produktit që ta shtoni në listë");
                return;
            }
            if (BiznesiComboBoxB.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "ICDS: Ju lutem zgjedhni biznesin për ta shtuar produktin në listë");
                return;
            }
            try {
                p.setProduktiID((Produkti) ProduktiComboBoxB1.getSelectedItem());
                p.setBiznesiID((Biznesi) BiznesiComboBoxB.getSelectedItem());
                p.setAdresa(adresa_field.getText().replaceAll("\\s", ""));

            } catch (Exception ixe) {
                JOptionPane.showMessageDialog(this, "ICDS: " + ixe);
            }
            try {
                Integer sasiaNePako = Integer.parseInt(sasia_pako);
                p.setSasia(sasiaNePako);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "ICDS: Sasia e pakove që dëshironi të porositni duhet te kete vlere numerike.");
                numri_pakovePerOrder_Field.setText("");
                return;
            }

            BigDecimal s = new BigDecimal(numri_pakovePerOrder_Field.getText());
            BigDecimal t = s.multiply(new BigDecimal(qmimiMeTVSH_jlabel.getText()));
            p.setTotali(t);

            double d = t.doubleValue();
            shumaTotali = shumaTotali + d;
            try {
                BiznesiComboBoxB.setEnabled(false);
                adresa_field.setEnabled(false);
                adresa_field_edit.setEnabled(false);
                pff.create(p);
                loadTabelenPorosia();
                setNumriProdukteveNeListe();
                numri_pakovePerOrder_Field.setText("");
            } catch (PorosiaException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "ICDS: Te gjitha fushat janë obligative për ta shtuar produktin në listë!");
        }

    }//GEN-LAST:event_ShtoNeListeProduktinActionPerformed

    private void PastroHapsiratBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastroHapsiratBtnActionPerformed
        produktet_tabela_porosia.clearSelection();
        listaProdukteve_table.clearSelection();
        pastroFields();
        try {
            pastroTablePorosia();
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        setNumriProdukteveNeListe();
    }//GEN-LAST:event_PastroHapsiratBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        produktet_tabela_porosia.clearSelection();
        listaProdukteve_table.clearSelection();
        pastroFields();
    }//GEN-LAST:event_formMouseClicked

    private int ktheNumrinEPorosive() {
        int numriPorosive = 0;
        try {
            List<Porosite> lista = prr.findAll();
            for (int i = 0; i < lista.size(); i++) {
                numriPorosive++;
            }
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return numriPorosive;
    }

    private void setNumriPorosive() {
        actualNumberOfOrders.setText(ktheNumrinEPorosive() + "");
    }

    private int ktheNumrinEProdukteveNeList() {
        int numriProdukteve = 0;
        try {
            List<Porosia> lista = pff.findAll();
            for (int i = 0; i < lista.size(); i++) {
                numriProdukteve++;
            }
        } catch (PorosiaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return numriProdukteve;
    }

    private void setNumriProdukteveNeListe() {
        actualNumberOfListProducts.setText(ktheNumrinEProdukteveNeList() + "");
    }


    private void BejPorosinteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BejPorosinteBtnActionPerformed
        try {
            List<Porosia> listap;
            try {
                listap = pff.findAll();
                Biznesi b = new Biznesi();
                Porosite pp = new Porosite();
                pp.setData(new Date());
                int sasia = 0;
                BigDecimal totali = new BigDecimal("0.00");

                for (int i = 0; i < listap.size(); i++) {
                    b = listap.get(i).getBiznesiID();
                    sasia = sasia + listap.get(i).getSasia();
                    totali = totali.add(listap.get(i).getTotali());
                }
                pp.setData(new Date());
                pp.setBiznesiID(b);
                pp.setSasia(sasia);
                pp.setTotali(totali);

                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "ICDS: A jeni i sigurtë qe dëshironi ta bëni porosinë?"
                        + "\n\nEmri i Biznesit: " + BiznesiComboBoxB.getSelectedItem().toString() + "\nQmimi në total: " + totali + "€" + "\nNumri i pakove te porositura: " + sasia, "Porosia", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    prr.create(pp);
                    actualNumberOfListProducts.setText("");
                } else {
                    return;
                }
                pastroFields();
                BiznesiComboBoxB.setEnabled(true);
                adresa_field.setEnabled(true);
            } catch (PorosiaException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            List<Porosia> lista = pff.findAll();
            for (int i = 0; i < lista.size(); i++) {
                pff.remove(lista.get(i));

            }
            loadTabelenPorosia();
            loadTabelenPorosite();
            setNumriPorosive();

        } catch (PorosiaException ex) {
            Logger.getLogger(PorosiaInternalForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BejPorosinteBtnActionPerformed


    private void FshijePorositeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FshijePorositeBtnActionPerformed
        int row = porositeTable.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int result = JOptionPane.showOptionDialog(this, "ICDS: A dëshironi ta fshini porosinë ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);

            if (result == 0) {
                try {
                    Porosite p = potma.getPorosite(row);
                    prr.remove(p);
                    loadTabelenPorosite();
                    setNumriPorosive();
                } catch (PorosiaException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
            pastroFields();
            porositeTable.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_FshijePorositeBtnActionPerformed

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        produktet_tabela_porosia.clearSelection();
        porositeTable.clearSelection();
        listaProdukteve_table.clearSelection();
    }//GEN-LAST:event_backgroundMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BejPorosinteBtn;
    private javax.swing.JComboBox BiznesiComboBoxB;
    private javax.swing.JButton FshijePorositeBtn;
    private javax.swing.JButton FshijeProduktinBtn;
    private javax.swing.JButton NdryshoProduktinBtn;
    private javax.swing.JLabel NumriPorosiveTeBeraJlabel;
    private javax.swing.JLabel NumriProdukteveNeListeJlabel;
    private javax.swing.JButton PastroHapsiratBtn;
    private javax.swing.JComboBox ProduktiComboBoxB1;
    private javax.swing.JComboBox ProduktiComboBoxB2;
    private javax.swing.JButton ShtoNeListeProduktin;
    private javax.swing.JLabel actualNumberOfListProducts;
    private javax.swing.JLabel actualNumberOfOrders;
    private javax.swing.JTextField adresa_field;
    private javax.swing.JTextField adresa_field_edit;
    private javax.swing.JLabel adresa_porosia_jlabel;
    private javax.swing.JLabel adresajlabel_edit;
    private javax.swing.JLabel available_products_jlabel;
    private javax.swing.JPanel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel listaPorosiveTeBeraJlabel;
    private javax.swing.JTable listaProdukteve_table;
    private javax.swing.JLabel lista_porosive_jlabel;
    private javax.swing.JTextField numri_pakovePerOrder_Field;
    private javax.swing.JLabel numri_pakove_jlabel;
    private javax.swing.JTable porositeTable;
    private javax.swing.JTable produktet_tabela_porosia;
    private javax.swing.JLabel produkti_porosia_jlabel;
    private javax.swing.JLabel qmimiMeTVSH_jlabel;
    private javax.swing.JLabel qmimi_jlabel;
    private javax.swing.JLabel qmimi_per_parko_jlabel;
    private javax.swing.JLabel qmimi_per_parko_jlabel1;
    private javax.swing.JTextField sasia_Field;
    private javax.swing.JLabel sasia_nePako_jlabel;
    private javax.swing.JLabel zgjedhProduktin_jLabel;
    private javax.swing.JLabel zgjedh_biznesin_label;
    // End of variables declaration//GEN-END:variables
}
