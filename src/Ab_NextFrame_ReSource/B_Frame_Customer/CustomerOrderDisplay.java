/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.B_Frame_Customer;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javax.swing.table.DefaultTableModel;
 //
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
// File Sistematik //

// Nyari File lain //
//import ;
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
 //
import D_Funcer_ReSource.MegangData;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class CustomerOrderDisplay extends javax.swing.JInternalFrame {

    /* Set-Up Penyambungan */
    Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    // Method untuk membuat pesan
    public static String kirimNilai(String terPilih) {
        return terPilih; // Mengembalikan pesan yang telah dimodifikasi
    }

    public CustomerOrderDisplay() {
        initComponents();

        /* Pengambilan Inisialis */
        String identiNama01 = kirimNilai("Faren");
        String identiNumb01 = kirimNilai("100200300400");
        //
        String identiNama02 = kirimNilai("Lakia");
        String identiNumb02 = kirimNilai("333555000666");

        String userNama = MegangData.dapatNamae();
        String teleFone = MegangData.dapetNomor();
        //
        // Jika null, set userNama ke "Pelanggan"
        if (userNama == null) {
            //userNama = "Our Customer";
            userNama = identiNama01;
        }
        /* Pengambilan Inisialis */

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch(SQLException ex) {
            System.out.println("Error" + ": " + ex.getMessage());
        }

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        //liatkan.setNorthPane(null);
        
        //
    }

    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
    }
    //

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronDisple = new javax.swing.JPanel();
        signOrdering = new javax.swing.JLabel();
        skrolMesan = new javax.swing.JScrollPane();
        daftarMesan = new javax.swing.JList<>();
        liatMesan = new javax.swing.JButton();
        sigInvite = new javax.swing.JLabel();
        isiNgundang = new javax.swing.JTextField();
        inviTon = new javax.swing.JButton();
        minList = new javax.swing.JButton();
        liatMesan1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setMaximumSize(new java.awt.Dimension(610, 440));
        setMinimumSize(new java.awt.Dimension(610, 440));
        setPreferredSize(new java.awt.Dimension(610, 440));
        setVisible(true);

        bekgronDisple.setBackground(new java.awt.Color(51, 0, 102));
        bekgronDisple.setToolTipText("");
        bekgronDisple.setMaximumSize(new java.awt.Dimension(615, 440));
        bekgronDisple.setMinimumSize(new java.awt.Dimension(615, 440));
        bekgronDisple.setPreferredSize(new java.awt.Dimension(615, 440));

        signOrdering.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        signOrdering.setForeground(new java.awt.Color(51, 255, 0));
        signOrdering.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOrdering.setText("Serving Your Order");
        signOrdering.setMaximumSize(new java.awt.Dimension(300, 40));
        signOrdering.setMinimumSize(new java.awt.Dimension(300, 40));
        signOrdering.setPreferredSize(new java.awt.Dimension(300, 40));

        skrolMesan.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolMesan.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolMesan.setMaximumSize(new java.awt.Dimension(350, 210));
        skrolMesan.setMinimumSize(new java.awt.Dimension(350, 210));
        skrolMesan.setPreferredSize(new java.awt.Dimension(350, 210));

        daftarMesan.setBackground(new java.awt.Color(102, 0, 102));
        daftarMesan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        daftarMesan.setForeground(new java.awt.Color(0, 255, 255));
        daftarMesan.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        daftarMesan.setMaximumSize(new java.awt.Dimension(350, 750));
        daftarMesan.setMinimumSize(new java.awt.Dimension(350, 750));
        daftarMesan.setPreferredSize(new java.awt.Dimension(350, 750));
        skrolMesan.setViewportView(daftarMesan);

        liatMesan.setBackground(new java.awt.Color(102, 102, 102));
        liatMesan.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        liatMesan.setForeground(new java.awt.Color(204, 204, 204));
        liatMesan.setText("Refresh");
        liatMesan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        liatMesan.setMaximumSize(new java.awt.Dimension(150, 40));
        liatMesan.setMinimumSize(new java.awt.Dimension(150, 40));
        liatMesan.setPreferredSize(new java.awt.Dimension(150, 40));
        liatMesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liatMesanActionPerformed(evt);
            }
        });

        sigInvite.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        sigInvite.setForeground(new java.awt.Color(51, 255, 0));
        sigInvite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigInvite.setText("Inviting:");
        sigInvite.setMaximumSize(new java.awt.Dimension(150, 40));
        sigInvite.setMinimumSize(new java.awt.Dimension(150, 40));
        sigInvite.setPreferredSize(new java.awt.Dimension(150, 40));

        isiNgundang.setFont(new java.awt.Font("Minecraft", 0, 20)); // NOI18N
        isiNgundang.setMaximumSize(new java.awt.Dimension(150, 40));
        isiNgundang.setMinimumSize(new java.awt.Dimension(150, 40));
        isiNgundang.setPreferredSize(new java.awt.Dimension(150, 40));
        isiNgundang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiNgundangActionPerformed(evt);
            }
        });

        inviTon.setBackground(new java.awt.Color(0, 204, 51));
        inviTon.setFont(new java.awt.Font("Impact", 1, 40)); // NOI18N
        inviTon.setForeground(new java.awt.Color(0, 153, 0));
        inviTon.setText(">");
        inviTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inviTon.setMaximumSize(new java.awt.Dimension(60, 60));
        inviTon.setMinimumSize(new java.awt.Dimension(60, 60));
        inviTon.setPreferredSize(new java.awt.Dimension(60, 60));
        inviTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviTonActionPerformed(evt);
            }
        });

        minList.setBackground(new java.awt.Color(153, 0, 0));
        minList.setFont(new java.awt.Font("Impact", 1, 40)); // NOI18N
        minList.setForeground(new java.awt.Color(153, 153, 153));
        minList.setText("-");
        minList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        minList.setMaximumSize(new java.awt.Dimension(60, 60));
        minList.setMinimumSize(new java.awt.Dimension(60, 60));
        minList.setPreferredSize(new java.awt.Dimension(60, 60));
        minList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minListActionPerformed(evt);
            }
        });

        liatMesan1.setBackground(new java.awt.Color(102, 102, 102));
        liatMesan1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        liatMesan1.setForeground(new java.awt.Color(204, 204, 204));
        liatMesan1.setText("Completion");
        liatMesan1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        liatMesan1.setMaximumSize(new java.awt.Dimension(200, 40));
        liatMesan1.setMinimumSize(new java.awt.Dimension(200, 40));
        liatMesan1.setPreferredSize(new java.awt.Dimension(200, 40));
        liatMesan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liatMesan1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton1.setText("Done");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButton2.setText("Not Done");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bekgronDispleLayout = new javax.swing.GroupLayout(bekgronDisple);
        bekgronDisple.setLayout(bekgronDispleLayout);
        bekgronDispleLayout.setHorizontalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signOrdering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skrolMesan, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(liatMesan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bekgronDispleLayout.createSequentialGroup()
                        .addComponent(inviTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(liatMesan, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(sigInvite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isiNgundang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bekgronDispleLayout.setVerticalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addComponent(signOrdering, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(liatMesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sigInvite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isiNgundang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inviTon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minList, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(skrolMesan, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(liatMesan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronDisple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronDisple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isiNgundangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiNgundangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiNgundangActionPerformed

    private void liatMesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liatMesanActionPerformed
        rifresPesan();
    }//GEN-LAST:event_liatMesanActionPerformed
    //
    private void rifresPesan() {
        DefaultListModel<String> model = new DefaultListModel<>();

        try {
        String sql = "SELECT DISTINCT p.pro_name " +
                     "FROM transaction t " +
                     "INNER JOIN customer c ON t.customer_id = c.id " + 
                     "INNER JOIN product p ON t.product_id = p.id " +
                     "WHERE c.name = ?"; // 1 parameter saja

            try (PreparedStatement pst = koneksi.prepareStatement(sql)) {
                // [NEW] Ambil userNama terbaru dari MegangData
                String identiNama01 = kirimNilai("Faren");
                String userNama = MegangData.dapatNamae();

                // [MODIFIED] Jika userNama null, pakai identiNama01
                if (userNama == null) {
                    userNama = identiNama01; // Default "Faren"
                }

                // [MODIFIED] Set parameter ke user yang valid
                pst.setString(1, userNama);

                ResultSet rs = pst.executeQuery();

                while(rs.next()) {
                    model.addElement(rs.getString("pro_name"));
                }
            }

            daftarMesan.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat pesanan!\nError: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inviTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviTonActionPerformed
        String identiNama01 = kirimNilai("Faren");
        String userNama = MegangData.dapatNamae();

        if (userNama == null) {
            userNama = identiNama01;
        }

        // Validasi 1: Cek item terpilih
        if (daftarMesan.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, 
                "Pilih produk dulu!", 
                "Kesalahan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi 2: Cek input quantity
        String qtyInput = isiNgundang.getText().trim();
        if (qtyInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Isi jumlah undangan!", 
                "Kesalahan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int newQty = Integer.parseInt(qtyInput);

            // Validasi 3: Quantity minimal 1
            if (newQty < 1) {
                JOptionPane.showMessageDialog(this,
                    "Quantity minimal 1!",
                    "Peringatan",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Dapatkan nama produk terpilih
            String selectedProduct = daftarMesan.getSelectedValue();

            // ================================================
            // [NEW] Ambil harga produk dari database
            // ================================================
            long productPrice = 0;
            String sqlGetPrice = "SELECT price FROM product WHERE pro_name = ?";
            try (PreparedStatement pstPrice = koneksi.prepareStatement(sqlGetPrice)) {
                pstPrice.setString(1, selectedProduct);
                ResultSet rsPrice = pstPrice.executeQuery();

                if (rsPrice.next()) {
                    productPrice = rsPrice.getLong("price");
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Harga produk tidak ditemukan!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // ================================================
            // [NEW] Hitung total amount baru
            // ================================================
            long totalAmount = newQty * productPrice;

            // ================================================
            // [MODIFIED] Update kedua kolom sekaligus
            // ================================================
            String sqlUpdate = "UPDATE transaction t "
                    + "INNER JOIN customer c ON t.customer_id = c.id "
                    + "INNER JOIN product p ON t.product_id = p.id "
                    + "SET t.total_qty = ?, t.total_amount = ? " // Update 2 kolom
                    + "WHERE c.name = ? AND p.pro_name = ?";

            try (PreparedStatement pst = koneksi.prepareStatement(sqlUpdate)) {
                pst.setInt(1, newQty);
                pst.setLong(2, totalAmount); // [NEW] Total amount
                pst.setString(3, userNama);
                pst.setString(4, selectedProduct);

                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this,
                        "Berhasil update:\n"
                        + newQty + " undangan\n"
                        + "Total: Rp" + "." + totalAmount, // [NEW] Tampilkan total
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);

                    // Refresh data + reset input
                    rifresPesan();
                    isiNgundang.setText("");
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Data tidak ditemukan!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Harap masukkan angka!",
                "Format Salah",
                JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + ex.getMessage(),
                "Error Kritis",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inviTonActionPerformed

    private void minListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minListActionPerformed
        String selectedProduct = daftarMesan.getSelectedValue();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this,
                    "Pilih item terlebih dahulu!",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 1. Ambil ID product
            String sqlGetId = "SELECT id FROM product WHERE pro_name = ?";
            PreparedStatement pstGetId = koneksi.prepareStatement(sqlGetId);
            pstGetId.setString(1, selectedProduct);
            ResultSet rs = pstGetId.executeQuery();

            if (rs.next()) {
                int productId = rs.getInt("id");

                // 2. Hapus dari transaction
                String sqlDelete = "DELETE FROM transaction WHERE product_id = ?";
                PreparedStatement pstDelete = koneksi.prepareStatement(sqlDelete);
                pstDelete.setInt(1, productId);
                int affectedRows = pstDelete.executeUpdate();

                if (affectedRows > 0) {
                    // 3. Perbarui JList
                    DefaultListModel<String> model = (DefaultListModel<String>) daftarMesan.getModel();
                    model.removeElement(selectedProduct);
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Gagal menghapus!\nError: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_minListActionPerformed

    private void liatMesan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liatMesan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_liatMesan1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bekgronDisple;
    private javax.swing.JList<String> daftarMesan;
    private javax.swing.JButton inviTon;
    private javax.swing.JTextField isiNgundang;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton liatMesan;
    private javax.swing.JButton liatMesan1;
    private javax.swing.JButton minList;
    private javax.swing.JLabel sigInvite;
    private javax.swing.JLabel signOrdering;
    private javax.swing.JScrollPane skrolMesan;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
