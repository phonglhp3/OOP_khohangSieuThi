/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package traul;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heheh
 */
public class BAOCAO extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public BAOCAO() {
        initComponents();
    }

    public void ViewTableXuat() {
        Date TGTu = txtTu.getDate();
        Date TGDen = txtDen.getDate();
        DefaultTableModel model = (DefaultTableModel) tbnNhapXuat.getModel();
        model.setRowCount(0);
        String sql = "SELECT "
                + "phieu_xuat_kho.id_phieu_xuat, "
                + "phieu_xuat_kho.id_Lo, "
                + "phieu_xuat_kho.thoi_gian_xuat, "
                + "san_pham.Ten_SP, "
                + "lo_san_pham.so_tien_lo "
                + "FROM "
                + "lo_san_pham "
                + "JOIN san_pham ON lo_san_pham.id_sp = san_pham.ID_SP "
                + "JOIN phieu_xuat_kho ON lo_san_pham.ID_Lo = phieu_xuat_kho.ID_Lo;";
        Database_Connection.getInstance().open();
        ResultSet rs = Database_Connection.getInstance().executeQuery(sql);
        int tongTien = 0;
        int j = 0;
        try {
            while (rs.next()) {
                Date x = rs.getDate(3);
                if (x.compareTo(TGTu) >= 0 && x.compareTo(TGDen) <= 0) {
                    j++;
                    model.addRow(new Object[]{rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4),1, rs.getInt(5)});
                    tongTien += rs.getInt(5);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                Database_Connection.getInstance().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.txtSL.setText(String.valueOf(j));
        this.txtTong.setText(String.valueOf(tongTien));
    }
    public void ViewTableNhap() {
        Date TGTu = txtTu.getDate();
        Date TGDen = txtDen.getDate();
        DefaultTableModel model = (DefaultTableModel) tbnNhapXuat.getModel();
        model.setRowCount(0);
        String sql = "SELECT " +
             "phieu_nhap.id_phieu_nhap, " +
             "lo_san_pham.id_Lo, " +
             "phieu_nhap.thoi_gian, " +
             "san_pham.Ten_SP, " +
             "phieu_nhap.So_Luong_Lo, " +
             "lo_san_pham.so_tien_lo " +
             "FROM " +
             "lo_san_pham " +
             "JOIN san_pham ON lo_san_pham.id_sp = san_pham.ID_SP " +
             "JOIN phieu_nhap ON lo_san_pham.ID_Phieu_Nhap = phieu_nhap.ID_Phieu_Nhap;";

        Database_Connection.getInstance().open();
        ResultSet rs = Database_Connection.getInstance().executeQuery(sql);
        int tongTien = 0;
        int j = 0;
        try {
            while (rs.next()) {
                Date x = rs.getDate(3);
                if (x.compareTo(TGTu) >= 0 && x.compareTo(TGDen) <= 0) {
                    j++;
                    model.addRow(new Object[]{rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getInt(5),rs.getInt(6)});
                    tongTien += rs.getInt(5)*rs.getInt(6);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                Database_Connection.getInstance().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.txtSL.setText(String.valueOf(j));
        this.txtTong.setText(String.valueOf(tongTien));
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBCaoNhap = new javax.swing.JButton();
        btnBCaoXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnNhapXuat = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        txtTong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Từ :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Đến :");

        btnBCaoNhap.setBackground(new java.awt.Color(0, 102, 102));
        btnBCaoNhap.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBCaoNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnBCaoNhap.setText("Xem Báo Cáo Nhập");
        btnBCaoNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBCaoNhapActionPerformed(evt);
            }
        });

        btnBCaoXuat.setBackground(new java.awt.Color(0, 102, 102));
        btnBCaoXuat.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBCaoXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnBCaoXuat.setText("Xem Báo Cáo Xuất");
        btnBCaoXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBCaoXuatActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 102, 102));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tbnNhapXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Phiếu", "Thời Gian", "ID Lô", "Tên Sản Phẩm", "Số Lượng", "Số Tiền"
            }
        ));
        jScrollPane1.setViewportView(tbnNhapXuat);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Số Lô :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Tổng Tiền:");

        txtSL.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        txtTong.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBCaoNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(163, 163, 163)))
                            .addComponent(btnBCaoXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(72, 72, 72)
                .addComponent(btnBCaoNhap)
                .addGap(18, 18, 18)
                .addComponent(btnBCaoXuat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setText("Báo Cáo Nhập Xuất");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBCaoXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBCaoXuatActionPerformed
        // TODO add your handling code here:
        ViewTableXuat();
    }//GEN-LAST:event_btnBCaoXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnBCaoNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBCaoNhapActionPerformed
        // TODO add your handling code here:
        ViewTableNhap();
    }//GEN-LAST:event_btnBCaoNhapActionPerformed

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
            java.util.logging.Logger.getLogger(BAOCAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BAOCAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BAOCAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BAOCAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BAOCAO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBCaoNhap;
    private javax.swing.JButton btnBCaoXuat;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbnNhapXuat;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
