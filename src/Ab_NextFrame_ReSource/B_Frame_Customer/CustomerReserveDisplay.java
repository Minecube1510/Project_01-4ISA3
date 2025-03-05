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
        liatkan.setNorthPane(null);
        
        //meliatMesan();
    }

    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
    }
    //

    public void meliatMesan() {
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
            String sql = "SELECT p.pro_name, t.total_qty, t.total_amount "
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
                        String productName = rs.getString("pro_name");
                        int quantity = rs.getInt("total_qty");
                        long totalPrice = (long) rs.getDouble("total_amount");
                        //String dateTime = rs.getString("order_datetime");
                        
                        model.addRow(new Object[]{productName, quantity, totalPrice});
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
        skrolMesankan = new javax.swing.JScrollPane();
        liatMesankan = new javax.swing.JTable();
        bayarTon = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setVisible(true);

        bekgronDisple.setBackground(new java.awt.Color(51, 0, 102));
        bekgronDisple.setToolTipText("");

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

        skrolMesankan.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolMesankan.setToolTipText("");
        skrolMesankan.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolMesankan.setMaximumSize(new java.awt.Dimension(570, 250));
        skrolMesankan.setMinimumSize(new java.awt.Dimension(570, 250));
        skrolMesankan.setPreferredSize(new java.awt.Dimension(570, 250));

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
        liatMesankan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        liatMesankan.setMaximumSize(new java.awt.Dimension(750, 500));
        liatMesankan.setMinimumSize(new java.awt.Dimension(750, 500));
        liatMesankan.setPreferredSize(new java.awt.Dimension(750, 500));
        skrolMesankan.setViewportView(liatMesankan);

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

        javax.swing.GroupLayout bekgronDispleLayout = new javax.swing.GroupLayout(bekgronDisple);
        bekgronDisple.setLayout(bekgronDispleLayout);
        bekgronDispleLayout.setHorizontalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skrolMesankan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(alliatPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bayarTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addComponent(skrolMesankan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
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

    private void bayarTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarTonActionPerformed

        String identiNama01 = kirimNilai("Faren");
        String userNama = MegangData.dapatNamae();

        // Handle jika userNama null atau kosong
        if (userNama == null || userNama.trim().isEmpty()) {
            userNama = identiNama01; // Fallback ke default
        }

        String[] options = {"Cash", "Online Payment"};
        String paymentMethod = (String) JOptionPane.showInputDialog(
            this,
            "Pilih metode pembayaran:",
            "Pembayaran",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options, options[0]);

        if (paymentMethod == null) return;

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Konfirmasi pembayaran dengan " + paymentMethod + "?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            // 1. Ambil Customer ID
            String customerId = null;
            String checkCustomerSql = "SELECT id FROM customer WHERE LOWER(name) = LOWER(?)";
            try (PreparedStatement checkPst = koneksi.prepareStatement(checkCustomerSql)) {
                checkPst.setString(1, userNama);
                ResultSet checkRs = checkPst.executeQuery();
                if (!checkRs.next()) {
                    JOptionPane.showMessageDialog(this, "Customer tidak ditemukan!");
                    return;
                }
                customerId = checkRs.getString("id");
            }

            // 2. Ambil Transaction IDs
            List<String> transactionIds = new ArrayList<>();
            String selectSql = "SELECT id FROM transaction WHERE customer_id = ?";
            try (PreparedStatement pst = koneksi.prepareStatement(selectSql)) {
                pst.setString(1, customerId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    transactionIds.add(rs.getString("id"));
                }
            }

            // 3. Hitung Total Amount & Qty
            long totalAmount = 0;
            int totalQty = 0;
            String sumSql = "SELECT SUM(total_amount) AS total_amount_sum, SUM(total_qty) AS total_qty_sum " +
                            "FROM transaction WHERE customer_id = ?";
            try (PreparedStatement sumPst = koneksi.prepareStatement(sumSql)) {
                sumPst.setString(1, customerId);
                ResultSet sumRs = sumPst.executeQuery();
                if (sumRs.next()) {
                    totalAmount = sumRs.getLong("total_amount_sum");
                    totalQty = sumRs.getInt("total_qty_sum");
                }
            }
            // 4. Eksekusi INSERT ke transaction_detail
            String insertSql = "INSERT INTO transaction_detail (transaction_id, ordet_amount, ordet_totalqty, order_datetime, pay_method, order_done) " +
                               "VALUES (?, ?, ?, NOW(), ?, 'Not Done')";
            try (PreparedStatement pst = koneksi.prepareStatement(insertSql)) {
                pst.setString(1, String.join(",", transactionIds)); // Concatenated IDs
                pst.setDouble(2, totalAmount); // SUM(total_amount)
                pst.setInt(3, totalQty); // SUM(total_qty)
                pst.setString(4, paymentMethod); // Dari input pengguna
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
            }

            try (PreparedStatement pst = koneksi.prepareStatement(insertSql)) {
                // ... (proses insert)
                JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error Database:\n" + ex.getMessage() + 
                "\nPastikan tabel 'transaction' dan 'customer' terhubung!");
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
