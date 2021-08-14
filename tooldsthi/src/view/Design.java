package view;

import DAOduan.DAOkehoach;
import DAOduan.DAOkehoachthiimprements;
import Model.Inputkehoachthi;
import Service.checksv;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

public class Design extends javax.swing.JFrame implements Runnable{

    private checksv check = new checksv();
    private String namefile,tenfile;
    private List<File> file;
    private ArrayList<Inputkehoachthi> dskht=new ArrayList<>();
    private DAOkehoach lst=new DAOkehoachthiimprements();

    public Design() {
        initComponents();
        this.setLocationRelativeTo(null);
        drag_and_drop_file();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnloai1 = new javax.swing.JButton();
        pnlfile = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbbmon = new javax.swing.JComboBox<>();
        lbladdress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnloai1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnloai1.setText("upload file điểm");
        btnloai1.setEnabled(false);
        btnloai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloai1ActionPerformed(evt);
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

        cbbmon.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbbmon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "môn online", "môn quiz", "điểm danh" }));

        lbladdress.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbladdress.setForeground(new java.awt.Color(0, 0, 255));
        lbladdress.setText("Địa Chỉ File lưu:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbmon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnloai1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))
                    .addComponent(lbladdress))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnloai1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbmon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbladdress)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloai1ActionPerformed
        String nameten[]=chonfile().split("/");
        namefile=nameten[0];
        tenfile=nameten[1];
        try {
            check.ktramondauvao(namefile,this.cbbmon.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "đọc file thành công");
            try {
                check.xuatdssthi(namefile.replace(tenfile, ""),dskht);
                this.lbladdress.setText(namefile.replace(tenfile, "")+System.getProperty("file.separator")+"danhsachthi");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "lưu file thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "đọc file thất bại");
        }


    }//GEN-LAST:event_btnloai1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String filekehoachthi[]=chonfile().split("/");
        String a=filekehoachthi[0];
        try {
            lst.docexcel(a);
            dskht.addAll(lst.xuatdskht());
            JOptionPane.showMessageDialog(this, "đọc file thành công");
            this.btnloai1.setEnabled(true);
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
        jfc.setPreferredSize(new Dimension(1376,766));
        jfc.setMultiSelectionEnabled(false);
        int ktr = jfc.showDialog(this, "chọn file");
        if (ktr == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            namefile = f.getAbsolutePath();
            tenfile=f.getName();
        }
        return namefile+"/"+tenfile;
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
    
    /*private void drag_and_drop_file() {
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
    }*/
    
    private void docfile(List<File>f){
        for(File  x:f){
            namefile=x.getAbsolutePath();
            tenfile=x.getName();
            try {
            check.ktramondauvao(namefile,this.cbbmon.getSelectedItem().toString());
            check.xuatdssthi(namefile.replace(tenfile, ""),dskht);
            JOptionPane.showMessageDialog(this, "upload "+tenfile+" thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "upload "+tenfile+" thất bại");
        }
            /*Thread t=new Thread(this);
            t.start();*/
        /*Multithread daluong;
            try {
                daluong = new Multithread(namefile,namefile.replace(tenfile, ""),this.cbbmon.getSelectedItem().toString(),dskht);
                Thread t=new Thread(daluong);
                        t.start();
                        //OptionPane.showMessageDialog(this, "đọc file: "+tenfile+"  thành công");
                        this.lbladdress.setText(namefile.replace(tenfile, "")+System.getProperty("file.separator")+"danhsachthi");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "không đọc đc file: "+tenfile);
                ex.printStackTrace();
            }      */        
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
    private javax.swing.JComboBox<String> cbbmon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JPanel pnlfile;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            check.ktramondauvao(namefile,this.cbbmon.getSelectedItem().toString());
            check.xuatdssthi(namefile.replace(tenfile, ""),dskht);
            JOptionPane.showMessageDialog(this, "upload "+tenfile+" thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "upload "+tenfile+" thất bại");
        }
    }
}
