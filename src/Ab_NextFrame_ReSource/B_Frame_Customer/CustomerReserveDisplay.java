/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.B_Frame_Customer;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
 //
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
// File Sistematik //

// Nyari File lain //
//import ;
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
 //
import D_Funcer_ReSource.MegangData;
import java.util.ArrayList;
import java.util.List;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class CustomerReserveDisplay extends javax.swing.JInternalFrame {

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

    public CustomerReserveDisplay() {
        /* Not Done */

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

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Order", "Quantity", "Total Price"}, 0) { // Kolom baru "ID"
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //
        liatMesankan.setModel(model);
        liatMesankan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /* Atur lebar kolom */
         // Pesanannya
        liatMesankan.getColumnModel().getColumn(0).setPreferredWidth(350);
        //
         // Yang diundang
        liatMesankan.getColumnModel().getColumn(1).setPreferredWidth(200);
        //
         // Harga Total
        liatMesankan.getColumnModel().getColumn(2).setPreferredWidth(200);
        //
        /* Atur lebar kolom */

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch(SQLException ex) {
            System.out.println("Error" + ": " + ex.getMessage());
        }

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        //liatkan.setNorthPane(null);

        //meliatMesan();
    }

    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
    }
    //

    public void meliatMesan() {
        transactionIds.clear();  // Reset list setiap kali refresh
        DefaultTableModel model = (DefaultTableModel) liatMesankan.getModel();
        model.setRowCount(0); // Reset tabel

        try {
            // Ambil username dari class Login
            String identiNama01 = kirimNilai("Faren");
            String userNama = MegangData.dapatNamae();
            //
            if (userNama == null) {
                //userNama = "Our Customer";
                userNama = identiNama01;
            }

            // Query SQL dengan parameter
            String sql = "SELECT t.id, p.pro_name, t.total_qty, t.total_amount " // Tambah kolom t.id
                       + "FROM transaction t "
                       + "JOIN customer c ON t.customer_id = c.id "
                       + "JOIN product p ON t.product_id = p.id "
                       + "WHERE c.name = ?";

            try (PreparedStatement pst = koneksi.prepareStatement(sql)) {
                pst.setString(1, userNama);
                
                // Isi data ke tabel
                try (ResultSet rs = pst.executeQuery()) {
                    // Isi data ke tabel
                        while (rs.next()) {
                            int transactionId = rs.getInt("id"); // Ambil ID transaksi
                            transactionIds.add(transactionId); // Simpan ke list

                            model.addRow(new Object[]{
                                rs.getString("pro_name"),
                                rs.getInt("total_qty"),
                                rs.getLong("total_amount")
                            });
                        }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronDisple = new javax.swing.JPanel();
        signBayar = new javax.swing.JLabel();
        alliatPesan = new javax.swing.JButton();
        bayarTon = new javax.swing.JButton();
        skrolMesankan = new javax.swing.JScrollPane();
        liatMesankan = new javax.swing.JTable();

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

        signBayar.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        signBayar.setForeground(new java.awt.Color(51, 255, 0));
        signBayar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signBayar.setText("Looking for Your Orders");
        signBayar.setMaximumSize(new java.awt.Dimension(570, 50));
        signBayar.setMinimumSize(new java.awt.Dimension(570, 50));
        signBayar.setPreferredSize(new java.awt.Dimension(570, 50));

        alliatPesan.setBackground(new java.awt.Color(102, 102, 102));
        alliatPesan.setFont(new java.awt.Font("Microsoft Tai Le", 1, 32)); // NOI18N
        alliatPesan.setForeground(new java.awt.Color(204, 204, 204));
        alliatPesan.setText("Refresh");
        alliatPesan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        alliatPesan.setMaximumSize(new java.awt.Dimension(150, 50));
        alliatPesan.setMinimumSize(new java.awt.Dimension(150, 50));
        alliatPesan.setPreferredSize(new java.awt.Dimension(150, 50));
        alliatPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alliatPesanActionPerformed(evt);
            }
        });

        bayarTon.setBackground(new java.awt.Color(102, 102, 102));
        bayarTon.setFont(new java.awt.Font("Microsoft Tai Le", 1, 32)); // NOI18N
        bayarTon.setForeground(new java.awt.Color(204, 204, 204));
        bayarTon.setText("Payment");
        bayarTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bayarTon.setMaximumSize(new java.awt.Dimension(150, 50));
        bayarTon.setMinimumSize(new java.awt.Dimension(150, 50));
        bayarTon.setPreferredSize(new java.awt.Dimension(150, 50));
        bayarTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarTonActionPerformed(evt);
            }
        });

        skrolMesankan.setToolTipText("");
        skrolMesankan.setMaximumSize(new java.awt.Dimension(570, 275));
        skrolMesankan.setMinimumSize(new java.awt.Dimension(570, 275));
        skrolMesankan.setPreferredSize(new java.awt.Dimension(570, 275));

        liatMesankan.setBackground(new java.awt.Color(153, 153, 153));
        liatMesankan.setForeground(new java.awt.Color(51, 51, 51));
        liatMesankan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order", "Quantity", "Total Price"
            }
        ));
        liatMesankan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        liatMesankan.setMaximumSize(new java.awt.Dimension(750, 500));
        liatMesankan.setMinimumSize(new java.awt.Dimension(750, 500));
        liatMesankan.setPreferredSize(new java.awt.Dimension(750, 500));
        skrolMesankan.setViewportView(liatMesankan);

        javax.swing.GroupLayout bekgronDispleLayout = new javax.swing.GroupLayout(bekgronDisple);
        bekgronDisple.setLayout(bekgronDispleLayout);
        bekgronDispleLayout.setHorizontalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skrolMesankan, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addComponent(signBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(alliatPesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bayarTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bekgronDispleLayout.setVerticalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alliatPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayarTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skrolMesankan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
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

    private void alliatPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alliatPesanActionPerformed
        meliatMesan();
    }//GEN-LAST:event_alliatPesanActionPerformed

    private List<Integer> transactionIds = new ArrayList<>();
    //
    private void bayarTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarTonActionPerformed

        // Validasi pemilihan baris
        int selectedRow = liatMesankan.getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih 1 pesanan yang akan dibayar!", 
                "Error", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Ambil ID transaksi TERPILIH saja
        int selectedTransactionId = transactionIds.get(selectedRow); // <-- Perubahan kunci

        String identiNama01 = kirimNilai("Faren");
        String userNama = MegangData.dapatNamae();

        // Check if userNama is null or empty
        if (userNama == null || userNama.trim().isEmpty()) {
            userNama = identiNama01;
        }
        //
        String kueri = "SELECT total_amount, total_qty FROM transaction WHERE id = ?";

        // 1. Pilih metode pembayaran
        String[] options = {"Cash", "Online Payment"};
        String paymentMethod = (String) JOptionPane.showInputDialog(
            this,
            "Pilih metode pembayaran:",
            "Pembayaran",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options, 
            options[0]
        );
        if (paymentMethod == null) return; // User canceled

        // 2. Dialog area pengiriman
        String[] areaOptions = {"Dalam Jabodetabek", "Luar Jabodetabek"};
        String deliveryArea = (String) JOptionPane.showInputDialog(
            this,
            "Apakah pengiriman dalam wilayah Jabodetabek?",
            "Area Pengiriman",
            JOptionPane.QUESTION_MESSAGE,
            null,
            areaOptions,
            areaOptions[0]
        );
        if (deliveryArea == null) return; // User canceled

        // 3. Hitung biaya pengiriman
        long shippingPercentage = (long) (deliveryArea.equals("Dalam Jabodetabek") ? 2L : 5L);

        try {
            // 4. Ambil totalAmount dan totalQty dari database
            String sql = "SELECT total_amount, total_qty " +
                         "FROM transaction " +
                         "WHERE id = ?";
            try (PreparedStatement pst = koneksi.prepareStatement(sql)) {
                pst.setInt(1, selectedTransactionId);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        long totalAmount = rs.getLong("total_amount");
                        int totalQty = rs.getInt("total_qty");

                        // 5. Hitung total baru dengan ongkir
                        long shippingCost = (long) (totalAmount * shippingPercentage) / 100;
                        long newTotalAmount = totalAmount + shippingCost;

                        // 6. Konfirmasi dengan info tambahan ongkir
                        String confirmMsg;
                        confirmMsg = String.format(
                            "Konfirmasi pembayaran dengan %s?\nBiaya pengiriman %d%% (Rp%,d)\nTotal menjadi: Rp%,d",
                            paymentMethod,
                            shippingPercentage, // %d untuk long
                            shippingCost,
                            newTotalAmount
                        );

                        int confirm = JOptionPane.showConfirmDialog(
                            this,
                            confirmMsg,
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION
                        );
                        if (confirm != JOptionPane.YES_OPTION) return; // User canceled

                        // 7. Update nilai yang dimasukkan ke database
                        String insertSql = "INSERT INTO transaction_detail (transaction_id, ordet_amount, ordet_totalqty, order_datetime, pay_method, order_done) VALUES (?, ?, ?, NOW(), ?, 'Not Done')";
                        try (PreparedStatement insertPst = koneksi.prepareStatement(insertSql)) {
                            insertPst.setInt(1, selectedTransactionId); // Kolom INT → setInt()
                            insertPst.setLong(2, newTotalAmount); // Kolom BIGINT → setLong()
                            insertPst.setString(3, String.valueOf(totalQty)); // Kolom VARCHAR → setString()
                            insertPst.setString(4, paymentMethod);
                            insertPst.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Tidak ada transaksi ditemukan untuk pengguna ini.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Database:\n" + ex.getMessage());
        }

    }//GEN-LAST:event_bayarTonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alliatPesan;
    private javax.swing.JButton bayarTon;
    private javax.swing.JPanel bekgronDisple;
    private javax.swing.JTable liatMesankan;
    private javax.swing.JLabel signBayar;
    private javax.swing.JScrollPane skrolMesankan;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
