package view;

import DAOduan.DAOkehoach;
import DAOduan.DAOkehoachthiimprements;
import Service.Multithread;
import Service.checksv;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Design extends javax.swing.JFrame {

    private checksv check = new checksv();
    private String namefile,tenfile;
    private List<File> file;
    private DAOkehoach lst=new DAOkehoachthiimprements();

    public Design() {
        initComponents();
        this.setLocationRelativeTo(null);
        drag_and_drop_file();

    }
    private int count = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnloai1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtlanthi = new javax.swing.JTextField();
        pnlfile = new javax.swing.JPanel();
        cbbblock = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnloai1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnloai1.setText("upload file điểm");
        btnloai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloai1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Lần Thi");

        txtlanthi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtlanthi.setText("1");
        txtlanthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlanthiActionPerformed(evt);
            }
        });

        pnlfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlfileLayout = new javax.swing.GroupLayout(pnlfile);
        pnlfile.setLayout(pnlfileLayout);
        pnlfileLayout.setHorizontalGroup(
            pnlfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlfileLayout.setVerticalGroup(
            pnlfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        cbbblock.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbbblock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Block 1", "Block 2" }));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("upload file kế hoạch thi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("xuất file mẫu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlanthi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbblock, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(btnloai1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnloai1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtlanthi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbblock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloai1ActionPerformed
        String nameten[]=chonfile().split("/");
        namefile=nameten[0];
        tenfile=nameten[1];
        try {
            check.ktramondauvao(namefile);
            JOptionPane.showMessageDialog(this, "đọc file thành công");
            try {
                if (check.xuatdssvthi() < 27) {
                    count = 2;
                } else {
                    count = 3;
                }
                check.xuatdssthi(namefile.replace(tenfile, ""), this.txtlanthi.getText(),this.cbbblock.getSelectedItem().toString());
                JOptionPane.showMessageDialog(this, "lưu file thành công");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "lưu file thất bại");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "đọc file thất bại");
        }


    }//GEN-LAST:event_btnloai1ActionPerformed

    private void txtlanthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlanthiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlanthiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String filekehoachthi[]=chonfile().split("/");
        String a=filekehoachthi[0];
        try {
            lst.docexcel(a);
            JOptionPane.showMessageDialog(this, "đọc file thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "đọc file thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name[]=chonfile().split("/");
        namefile=name[0];
        tenfile=name[1];
        try {
            lst.xuatfilemau(namefile.replace(tenfile, ""));
            lst.xuatfileonlmau(namefile.replace(tenfile, ""));
            lst.xuatfilequizmau(namefile.replace(tenfile, ""));
        } catch (Exception ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private String chonfile() {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(".xlsx", ".xlsm", ".xls");
        jfc.setFileFilter(fnef);
        jfc.setMultiSelectionEnabled(false);
        int ktr = jfc.showDialog(this, "chọn file");
        if (ktr == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            namefile = f.getAbsolutePath();
            tenfile=f.getName();
        }
        return namefile+"/"+tenfile;
    }

    private String savefile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setMultiSelectionEnabled(false);
        int ktr = jfc.showDialog(this, "save");
        if (ktr == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            namefile = f.getAbsolutePath();
        }
        return namefile;
    }

    private void drag_and_drop_file() {
        TransferHandler th = new TransferHandler() {
            @Override
            public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
                return true;
            }

            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    file = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    docfile(file);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        
                    }
                return true;
            }

        };
        
        pnlfile.setTransferHandler(th);
    }
    
    private void docfile(List<File>f){
        for(File  x:f){
            namefile=x.getAbsolutePath();
            tenfile=x.getName();
        Multithread daluong;
            try {
                daluong = new Multithread(namefile,namefile.replace(tenfile, ""),txtlanthi.getText(),this.cbbblock.getSelectedItem().toString());
                Thread t=new Thread(daluong);
                        t.start();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "không đọc đc file: "+tenfile);
                ex.printStackTrace();
            }              
        }
    }
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
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Design().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnloai1;
    private javax.swing.JComboBox<String> cbbblock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlfile;
    private javax.swing.JTextField txtlanthi;
    // End of variables declaration//GEN-END:variables
}
