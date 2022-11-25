package view;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangService;
import service.impl.KhachHangServiceImpl;

public class ViewKhachHang extends javax.swing.JFrame {
    
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcm;
    private final KhachHangService sv;
    private final ButtonGroup b;
    private final Dialog dialog;
    
    public ViewKhachHang() {
        initComponents();
        setLocationRelativeTo(null);// set Jframe giữa màn hình
        this.dialog = new Dialog();
        this.dtm = new DefaultTableModel();
        this.dcm = new DefaultComboBoxModel();
        this.sv = new KhachHangServiceImpl();
        b = new ButtonGroup();
        b.add(this.rdoNam);
        b.add(this.rdoNữ);
        this.rdoNam.setSelected(true);
        this.addComboBox();
        this.addColums();
        this.loadTable(this.sv.getList());
    }
    
    void addComboBox() {
        ArrayList<String> listCBB = new ArrayList<>();
        listCBB.add("Khach thuong");
        listCBB.add("Khach VIP");
        listCBB.add("VVIP");
        
        dcm = (DefaultComboBoxModel) this.cbLoaiKhachHang.getModel();
        
        for (String item : listCBB) {
            dcm.addElement(item);
        }
        this.cbLoaiKhachHang.setSelectedIndex(0);
    }
    
    void addColums() {
        ArrayList<String> listColums = new ArrayList<>();
        listColums.add("Mã KKH");
        listColums.add("Tên");
        listColums.add("Tuổi");
        listColums.add("Giới Tính");
        listColums.add("Loại Khách hàng");
        
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        for (String item : listColums) {
            dtm.addColumn(item);
        }
    }
    
    void loadTable(ArrayList<KhachHang> listKH) {
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        
        for (KhachHang kh : listKH) {
            Object[] rowData = {
                kh.getMaKH(),
                kh.getTen(),
                kh.getTuoi(),
                kh.isGioiTinh(),
                kh.getLoaiKhachHang()
            };
            dtm.addRow(rowData);
        }
    }
    
    void clearForm() {
        this.txtTuoiMin.setText("");
        this.txtTuoiMax.setText("");
        this.txtMaKH.setText("");
        this.txtTenKH.setText("");
        this.txtTuoi.setText("");
        this.rdoNam.setSelected(true);
        this.cbLoaiKhachHang.setSelectedIndex(0);
        this.loadTable(this.sv.getList());
        
    }
    
    public KhachHang getFormData() {
        String MaKHStr = this.txtMaKH.getText().trim();
        String TenKHStr = this.txtTenKH.getText().trim();
        String tuoiStr = this.txtTuoi.getText().trim();
        boolean gioiTinhStr = true;
        String LoaiKHStr = this.cbLoaiKhachHang.getSelectedItem().toString();
        
        if (MaKHStr.equals("") || TenKHStr.equals("") || tuoiStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu dữ liệu!");
            return null;
        }
        
        int tuoi = -1;
        try {
            tuoi = Integer.parseInt(tuoiStr);
            if (tuoi < 0) {
                JOptionPane.showMessageDialog(this, "Tuổi phải > 0!");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số!");
            return null;
        }
        
        if (this.rdoNam.isSelected()) {
            gioiTinhStr = true;
        }
        if (this.rdoNữ.isSelected()) {
            gioiTinhStr = false;
        }
        
        KhachHang kh = new KhachHang(MaKHStr, TenKHStr, tuoi, gioiTinhStr, LoaiKHStr);
        return kh;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNữ = new javax.swing.JRadioButton();
        cbLoaiKhachHang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentList = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnListKhachVip = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTuoiMin = new javax.swing.JTextField();
        txtTuoiMax = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClear.setText("ClearForm");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("information"));

        jLabel7.setText("Mã khách hàng");

        jLabel8.setText("Tên khách hàng");

        jLabel9.setText("Giới tính");

        jLabel11.setText("Loại khách hàng");

        txtMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaKHMouseClicked(evt);
            }
        });

        txtTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenKHMouseClicked(evt);
            }
        });

        rdoNam.setText("Nam");
        rdoNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNamMouseClicked(evt);
            }
        });

        rdoNữ.setText("Nữ");
        rdoNữ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNữMouseClicked(evt);
            }
        });

        cbLoaiKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbLoaiKhachHangMouseClicked(evt);
            }
        });

        jLabel1.setText("Tuổi");

        txtTuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(rdoNam)
                        .addGap(83, 83, 83)
                        .addComponent(rdoNữ)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTuoi)
                            .addComponent(txtTenKH)
                            .addComponent(txtMaKH)
                            .addComponent(cbLoaiKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rdoNam)
                            .addComponent(rdoNữ))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSapXep.setText("Sắp xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText(" Student List");

        tbStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbStudentList);

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnListKhachVip.setText("List Khách VIP");
        btnListKhachVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListKhachVipActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Tìm kiếm");

        jLabel5.setText("Tuổi min");

        jLabel6.setText("Tuổi max");

        txtTuoiMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuoiMaxActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtTuoiMin, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTuoiMax, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTuoiMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTuoiMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnListKhachVip)
                                .addGap(18, 18, 18)
                                .addComponent(btnSapXep)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnXoa)
                    .addComponent(btnSapXep)
                    .addComponent(btnExit)
                    .addComponent(btnListKhachVip))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Clear thành công!");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        int min = Integer.parseInt(this.txtTuoiMin.getText());
        int max = Integer.parseInt(this.txtTuoiMax.getText());
        this.loadTable(this.sv.getSearch(min, max));
        JOptionPane.showMessageDialog(this, "Search thành công!");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang kh = this.getFormData();
        
        if (sv == null) {
            return;
        }
        this.sv.themKH(kh);
        this.loadTable(this.sv.getList());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Add thành công!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtMaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaKHMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtMaKHMouseClicked

    private void txtTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenKHMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtTenKHMouseClicked

    private void cbLoaiKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbLoaiKhachHangMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cbLoaiKhachHangMouseClicked

    private void rdoNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNamMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoNamMouseClicked

    private void rdoNữMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNữMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoNữMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = this.tbStudentList.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
            return;
        }
        
        KhachHang kh = this.getFormData();
        if (kh == null) {
            return;
        }
        
        this.sv.suaKH(kh.getMaKH(), kh);
        this.loadTable(this.sv.getList());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Sửa thành công!");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentListMouseClicked
        int row = this.tbStudentList.getSelectedRow();
        
        if (row == -1) {
            return;
        }
        
        this.txtMaKH.setText(this.tbStudentList.getValueAt(row, 0).toString());
        this.txtTenKH.setText(this.tbStudentList.getValueAt(row, 1).toString());
        this.txtTuoi.setText(this.tbStudentList.getValueAt(row, 2).toString());
        if (this.tbStudentList.getValueAt(row, 3).toString().equals("true")) {
            this.rdoNam.setSelected(true);
        }
        if (this.tbStudentList.getValueAt(row, 3).toString().equals("false")) {
            this.rdoNữ.setSelected(true);
        }
        this.cbLoaiKhachHang.setSelectedItem(this.tbStudentList.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tbStudentListMouseClicked

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        this.sv.getList().sort(
                (o1, o2) -> {
                    return o1.getTen().compareTo(o2.getTen());
                });
        
        this.loadTable(this.sv.getList());
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tbStudentList.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
            return;
        }
        
        int cofirm = JOptionPane.showConfirmDialog(this, "Xac nhan xoa!");
        if (cofirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        String makh = this.tbStudentList.getValueAt(row, 0).toString();
        this.sv.xoaKH(makh);
        this.loadTable(this.sv.getList());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnListKhachVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListKhachVipActionPerformed
        this.loadTable(this.sv.getKhachVIP());
    }//GEN-LAST:event_btnListKhachVipActionPerformed

    private void txtTuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuoiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuoiMouseClicked

    private void txtTuoiMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuoiMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuoiMaxActionPerformed

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
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListKhachVip;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNữ;
    private javax.swing.JTable tbStudentList;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTuoi;
    private javax.swing.JTextField txtTuoiMax;
    private javax.swing.JTextField txtTuoiMin;
    // End of variables declaration//GEN-END:variables
}
