/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Produkti;
import BLL.Stoku;
import Exceptions.ProduktiException;

import DAL.ProduktiInterface;
import DAL.ProduktiRepository;
import Exceptions.StokuException;
import DAL.StokuRepository;
import gui.model.ProduktiTable;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;



public class ProduktiForm extends javax.swing.JInternalFrame {

    ProduktiInterface pi = new ProduktiRepository();
    ProduktiTable pt;
    StokuRepository str = new StokuRepository();

    public ProduktiForm() throws ProduktiException, StokuException {
        initComponents();
        shfaqTabelen();
        tabelaSelectedIndexChange();
        setFormFullScren();
        
    }
     
     private void setFormFullScren(){
        int xsize = (int)gui.view.PunetoriMainForm.jDesktopPane1.getWidth();
        int ysize = (int)gui.view.PunetoriMainForm.jDesktopPane1.getHeight();
        this.setSize(xsize,ysize);  
    }

    public void pastrofushat() {
        ProduktiT.clearSelection();
        IDF.setText("");
        EmriF.setText("");
        CmimiF.setText("");
        BarkodiF.setText("");
        PaketaF.setText("");
        CopeF.setText("");
    }

    public void shfaqTabelen() {
        try {
            List<Produkti> list = pi.findAll();
            pt = new ProduktiTable(list);
            ProduktiT.setModel(pt);
            pt.fireTableDataChanged();
            ProduktiT.getColumnModel().getColumn(0).setPreferredWidth(7);
            ProduktiT.getColumnModel().getColumn(1).setPreferredWidth(100);
            ProduktiT.getColumnModel().getColumn(3).setPreferredWidth(90);
        } catch (ProduktiException pe) {
            pe.printStackTrace();
        }
        disableProduktiFormDrag();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProduktiT = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        CopeF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BarkodiF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CmimiF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PaketaF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        EmriF = new javax.swing.JTextField();
        Emrilabel = new javax.swing.JLabel();
        IDF = new javax.swing.JTextField();
        IDlabel = new javax.swing.JLabel();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        CancelB = new javax.swing.JButton();
        SaveB = new javax.swing.JButton();

        setClosable(true);
        setTitle("Produktet ");
        setMinimumSize(new java.awt.Dimension(1205, 570));
        setPreferredSize(new java.awt.Dimension(1205, 570));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        ProduktiT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ProduktiT);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel11.setText("Copë");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel9.setText("1 Paketë = ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Barkodi");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("€");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("Cmimi per pakete:");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel12.setText("1 Paletë = ");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel10.setText("Paketa");

        Emrilabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        Emrilabel.setText("EMRI");

        IDlabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        IDlabel.setText("ID");

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

        CancelB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-cancel-30.png"))); // NOI18N
        CancelB.setText("CANCEL");
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });

        SaveB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaveB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icons8-save-30.png"))); // NOI18N
        SaveB.setText("SAVE");
        SaveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(IDlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CmimiF, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BarkodiF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Emrilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmriF, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(473, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PaketaF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10)
                            .addGap(258, 258, 258)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CopeF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(CancelB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Emrilabel)
                    .addComponent(EmriF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CmimiF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(BarkodiF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(PaketaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(CopeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BarkodiF, CmimiF, CopeF, EmriF, Emrilabel, IDF, IDlabel, PaketaF, jLabel1, jLabel10, jLabel11, jLabel12, jLabel3, jLabel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean barkodiV() {
        if (BarkodiF.getText().length() > 9 || BarkodiF.getText().length() < 9) {
            return true;
        }
        return false;
    }
    
    private boolean egzistonEmri() throws ProduktiException{
        List<Produkti>lista = pi.findAll();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getEmri().toString().equals(EmriF.getText())){
                return true;
            }
        }
        return false;
    }

    public boolean saveValid() throws ProduktiException {
        if (IDF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet Hapsira e ID.");
        } else if (EmriF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Duhet te plotesohet emri i Produktit.");
        }else if(egzistonEmri()==true){
             JOptionPane.showMessageDialog(this, "Ky emer i Produktit egziston.");
        } else if (CmimiF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Produktit duhet ti cakothet cmim.");
        } else if (BarkodiF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Produktit duhet ti shenohet Barkodi egzistues.");
        } else if (BarkodiF.getText().length() > 10 || BarkodiF.getText().length() < 10) {
            JOptionPane.showMessageDialog(this, "Barkodi duhet ti kete saktesisht 10 shifra.");
        } else if (SimboletPaketa() == false) {
            JOptionPane.showMessageDialog(this, "Rubrika e sasise se Paketes permban simbole te panjohura.");
        } else if (SimboletCope() == false) {
            JOptionPane.showMessageDialog(this, "Rubrika e sasise se copes permban simbole te panjohura.");
        } else if (Double.parseDouble(CopeF.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Paketa permban shifer joValide.");
        } else if (Double.parseDouble(PaketaF.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Paleta permban shifer joValide.");
        } else {
            return true;
        }
        return false;
    }

    public boolean SimboletPaketa() {
        int COUNT = 0;
        char[] shkronjat = PaketaF.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }
        }
        if (COUNT == PaketaF.getText().length()) {
            return true;
        }
        return false;

    }

    public boolean SimboletCope() {
        int COUNT = 0;
        char[] shkronjat = CopeF.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }
        }
        if (COUNT == CopeF.getText().length()) {
            return true;
        }
        return false;

    }

    public boolean vlene() {

        for (int i = 0; i < IDF.getText().length(); i++) {
            if (IDF.getText().charAt(i) < '0' || IDF.getText().charAt(i) > '9') {
                return false;
            }

        }
        return true;
    }

    public boolean emriProd() {
        int COUNT = 0;
        char[] shkronjat = EmriF.getText().toCharArray();
        for (char c : shkronjat) {
            if (Character.isDigit(c)) {
                COUNT++;
            }
        }
        if (COUNT == EmriF.getText().length()) {
            return true;
        }
        return false;
    }

    public boolean Simbolet() {
        int COUNT = 0;
        char[] shkronjat = EmriF.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 97 && code <= 122) {
                COUNT++;
            } else if (code >= 65 && code <= 90) {
                COUNT++;
            } else if (code == 32) {
                COUNT++;
            } else if (code == 47) {
                COUNT++;
            } else if (code >= 48 && code <= 57) {
                COUNT++;
            }

        }
        if (COUNT == EmriF.getText().length()) {
            return true;
        }
        return false;

    }

    public boolean SimboletCmimi() {
        int COUNT = 0;
        char[] shkronjat = CmimiF.getText().toCharArray();
        for (char c : shkronjat) {
            int code = (int) c;
            if (code >= 48 && code <= 57) {
                COUNT++;
            }
            if (code == 46) {
                COUNT++;
            }

        }
        if (COUNT == CmimiF.getText().length()) {
            return true;
        }
        return false;

    }


    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        try {
            if (IDF.getText().equals("") && EmriF.getText().equals("") && CmimiF.getText().equals("")
                    && BarkodiF.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar (OBLIGATIVE).");
                return;
            } else if (saveValid() == true) {
                Produkti p = new Produkti();
                if (vlene() == true) {
                    p.setProduktiID(Integer.parseInt(IDF.getText()));
                } else {
                    JOptionPane.showMessageDialog(this, "ID joValide.");
                    return;
                }
                if (emriProd() == true) {
                    JOptionPane.showMessageDialog(this, "Emri i Produktit nuk guxon te jete vetem me numra.");
                    return;
                } else if (Simbolet() == false) {
                    JOptionPane.showMessageDialog(this, "Emri i Produktit permbane simbole te panjohura.");
                } else if (EmriF.getText().length() <= 3) {
                    JOptionPane.showMessageDialog(this, "Emri i Produktit nuk guxon te kete me pak se 3 karaktere");
                    return;
                } else {
                    p.setEmri(EmriF.getText());
                }
                if (SimboletCmimi() == false) {
                    JOptionPane.showMessageDialog(this, "Cmimi permbane Simbole joValide.");
                    return;
                }
                if (cmimiEdit() == false) {
                    p.setCmimi(new BigDecimal(CmimiF.getText()));
                } else {
                    JOptionPane.showMessageDialog(this, "Cmimi i Produktit nuk guxon te jete 0 ose me i vogel");
                    return;
                }
                p.setBarkodi(Integer.parseInt(BarkodiF.getText()));
                p.setPaketa(new BigDecimal(PaketaF.getText()));
                p.setCope(new BigDecimal(CopeF.getText()));
                p.setPalete(new BigDecimal("1.0"));

                try {
                    pi.create(p);
                    Stoku s = new Stoku();
                    s.setProduktiID(p);
                    s.setPalete(new BigDecimal(0.00));
                    s.setPaketa(new BigDecimal(0.00));
                    s.setCope(new BigDecimal(0.00));
                    s.setDataSkadencesProd(new Date());
                    str.create(s);
                } catch (ProduktiException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                shfaqTabelen();
                pastrofushat();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveBActionPerformed

    public boolean cancelValid() {
        if (IDF.getText().equals("") && EmriF.getText().equals("") && CmimiF.getText().equals("")
                && BarkodiF.getText().equals("")) {
            return true;
        }
        return false;
    }
    private void CancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBActionPerformed

        pastrofushat();
    }//GEN-LAST:event_CancelBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        try {
            int row = ProduktiT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    Produkti p = pt.getProdukti(row);
                    try {
                        pi.remove(p);
                    } catch (ProduktiException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                    pastrofushat();
                    shfaqTabelen();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ju nuk keni selektuar asgje.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_DeleteBActionPerformed

    public boolean cmimiEdit() {
        int rez;
        final BigDecimal con = new BigDecimal("0.00");
        rez = (new BigDecimal(CmimiF.getText()).compareTo(con));
        if (rez == -1 || rez == 0) {
            return true;
        }
        return false;

    }


    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        try {
            int row = ProduktiT.getSelectedRow();
            if (row != -1) {
                Object[] ob = {"Po", "Jo"};
                int result = JOptionPane.showOptionDialog(this, " \"KUJDES\" Editimi nuk ka kthim mbrapa?", "Editimi", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if (result == 0) {
                    if (IDF.getText().equals("") && EmriF.getText().equals("") && CmimiF.getText().equals("")
                            && BarkodiF.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Kolonat duhet plotesuar (OBLIGATIVE).");
                        return;
                    } else if (saveValid() == true) {
                        Produkti p = new Produkti();
                        if (vlene() == true) {
                            p.setProduktiID(Integer.parseInt(IDF.getText()));
                        } else {
                            JOptionPane.showMessageDialog(this, "ID joValide.");
                            return;
                        }
                        if (emriProd() == true) {
                            JOptionPane.showMessageDialog(this, "Emri i Produktit nuk guxon te jete vetem me numra.");
                            return;
                        } else if (Simbolet() == true) {
                            p.setEmri(EmriF.getText());
                        } else {
                            JOptionPane.showMessageDialog(this, "Emri i Produktit permbane simbole te panjohura.");
                            return;
                        }
                        if (SimboletCmimi() == false) {
                            JOptionPane.showMessageDialog(this, "Cmimi permbane Simbole joValide.");
                            return;
                        }
                        if (cmimiEdit() == false) {
                            p.setCmimi(new BigDecimal(CmimiF.getText()));
                        } else {
                            JOptionPane.showMessageDialog(this, "Cmimi i Produktit nuk guxon te jete 0 ose me i vogel");
                        }
                        if (barkodiV() == false) {
                            p.setBarkodi(Integer.parseInt(BarkodiF.getText()));
                        } else {
                            JOptionPane.showMessageDialog(this, "Barkodi duhet ti kete saktesisht 9 shifra.");
                            pastrofushat();
                            return;
                        }
                        p.setPaketa(new BigDecimal(PaketaF.getText()));
                        p.setCope(new BigDecimal(CopeF.getText()));
                        p.setPalete(new BigDecimal("1.0"));
                        try {
                            pi.edit(p);

                        } catch (ProduktiException ex) {
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                        pastrofushat();
                        shfaqTabelen();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ju nuk keni selektuar asgje.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EditBActionPerformed

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = ProduktiT.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Produkti p = pt.getProdukti(selectedIndex);
                    IDF.setText(p.getProduktiID() + "");
                    EmriF.setText(p.getEmri());
                    CmimiF.setText(p.getCmimi() + "");
                    BarkodiF.setText(p.getBarkodi() + "");
                    PaketaF.setText(p.getPaketa() + "");
                    CopeF.setText(p.getCope() + "");

                }
            }
        });
    }
    
    private void disableProduktiFormDrag(){
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarkodiF;
    private javax.swing.JButton CancelB;
    private javax.swing.JTextField CmimiF;
    private javax.swing.JTextField CopeF;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JTextField EmriF;
    private javax.swing.JLabel Emrilabel;
    private javax.swing.JTextField IDF;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JTextField PaketaF;
    private javax.swing.JTable ProduktiT;
    private javax.swing.JButton SaveB;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
