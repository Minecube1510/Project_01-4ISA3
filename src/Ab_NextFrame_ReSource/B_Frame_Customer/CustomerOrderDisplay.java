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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
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

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", // Kolom baru
            "Order", "Total Price", "Quantity", "Date and Time", "Payment", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //
        tabelBayar.setModel(model);
        tabelBayar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /* Atur lebar kolom */
         // Pesanannya
        tabelBayar.removeColumn(tabelBayar.getColumnModel().getColumn(0));
        //
        tabelBayar.getColumnModel().getColumn(0).setPreferredWidth(200);
        //
         // Harga
        tabelBayar.getColumnModel().getColumn(1).setPreferredWidth(100);
        //
         // Kuantitas
        tabelBayar.getColumnModel().getColumn(2).setPreferredWidth(100);
        //
         // Tanggal Waktu
        tabelBayar.getColumnModel().getColumn(3).setPreferredWidth(150);
        //
         // Pembayaran
        tabelBayar.getColumnModel().getColumn(4).setPreferredWidth(150);
        //
         // Status
        tabelBayar.getColumnModel().getColumn(5).setPreferredWidth(100);
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
        tandaBayar = new javax.swing.JButton();
        skrolBayar = new javax.swing.JScrollPane();
        tabelBayar = new javax.swing.JTable();

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
        liatMesan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        isiNgundang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        inviTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        minList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minList.setMaximumSize(new java.awt.Dimension(60, 60));
        minList.setMinimumSize(new java.awt.Dimension(60, 60));
        minList.setPreferredSize(new java.awt.Dimension(60, 60));
        minList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minListActionPerformed(evt);
            }
        });

        tandaBayar.setBackground(new java.awt.Color(102, 102, 102));
        tandaBayar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 32)); // NOI18N
        tandaBayar.setForeground(new java.awt.Color(204, 204, 204));
        tandaBayar.setText("Completion");
        tandaBayar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tandaBayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tandaBayar.setMaximumSize(new java.awt.Dimension(200, 40));
        tandaBayar.setMinimumSize(new java.awt.Dimension(200, 40));
        tandaBayar.setPreferredSize(new java.awt.Dimension(200, 40));
        tandaBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tandaBayarActionPerformed(evt);
            }
        });

        skrolBayar.setBackground(new java.awt.Color(0, 255, 255));
        skrolBayar.setForeground(new java.awt.Color(0, 255, 255));
        skrolBayar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolBayar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolBayar.setMaximumSize(new java.awt.Dimension(365, 115));
        skrolBayar.setMinimumSize(new java.awt.Dimension(365, 115));
        skrolBayar.setPreferredSize(new java.awt.Dimension(365, 115));

        tabelBayar.setBackground(new java.awt.Color(102, 0, 102));
        tabelBayar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tabelBayar.setForeground(new java.awt.Color(0, 255, 255));
        tabelBayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order", "Price", "Inviting", "Date and Time", "Pay Method", "Status"
            }
        ));
        tabelBayar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        skrolBayar.setViewportView(tabelBayar);

        javax.swing.GroupLayout bekgronDispleLayout = new javax.swing.GroupLayout(bekgronDisple);
        bekgronDisple.setLayout(bekgronDispleLayout);
        bekgronDispleLayout.setHorizontalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signOrdering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skrolMesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(skrolBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(inviTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(minList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(isiNgundang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sigInvite, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(liatMesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tandaBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        bekgronDispleLayout.setVerticalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addComponent(signOrdering, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(liatMesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sigInvite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isiNgundang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inviTon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minList, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(skrolMesan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronDispleLayout.createSequentialGroup()
                        .addComponent(skrolBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(tandaBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
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

        // 2. MODIFIKASI QUERY UNTUK AMBIL ID
        DefaultListModel<String> listModel = new DefaultListModel<>();
        DefaultTableModel tableModel = (DefaultTableModel) tabelBayar.getModel();
        tableModel.setRowCount(0);

        try {
            // Query untuk JList
            String sqlList = "SELECT DISTINCT p.pro_name FROM transaction t " +
                            "INNER JOIN customer c ON t.customer_id = c.id " +
                            "INNER JOIN product p ON t.product_id = p.id " +
                            "WHERE c.name = ?";
            
            // Query untuk JTable (TAMBAH td.id)
            String sqlTable = "SELECT td.id, p.pro_name, td.ordet_amount, " + // AMBIL ID
                             "td.ordet_totalqty, td.order_datetime, " +
                             "td.pay_method, td.order_done " +
                             "FROM transaction_detail td " +
                             "INNER JOIN transaction t ON td.transaction_id = t.id " +
                             "INNER JOIN product p ON t.product_id = p.id " +
                             "INNER JOIN customer c ON t.customer_id = c.id " +
                             "WHERE c.name = ?";

            // Ambil data untuk JList
            try (PreparedStatement pstList = koneksi.prepareStatement(sqlList)) {
                pstList.setString(1, userNama);
                ResultSet rsList = pstList.executeQuery();
                
                while (rsList.next()) {
                    listModel.addElement(rsList.getString("pro_name"));
                }
                daftarMesan.setModel(listModel);
            }

            // Ambil data untuk JTable
            try (PreparedStatement pstTable = koneksi.prepareStatement(sqlTable)) {
                pstTable.setString(1, userNama);
                ResultSet rsTable = pstTable.executeQuery();

                while (rsTable.next()) {
                    // TAMBAH ID SEBAGAI ELEMEN PERTAMA
                    int id = rsTable.getInt("id");
                    String order = rsTable.getString("pro_name");
                    String totalHarga = "Rp" + rsTable.getLong("ordet_amount");
                    String kuantitas = String.valueOf(rsTable.getInt("ordet_totalqty"));
                    String tanggalWaktu = rsTable.getString("order_datetime");
                    String pembayaran = rsTable.getString("pay_method");
                    String status = rsTable.getString("order_done");

                    //

                    tableModel.addRow(new Object[]{
                        id,         // ID sebagai elemen pertama
                        order, 
                        totalHarga, 
                        kuantitas, 
                        tanggalWaktu, 
                        pembayaran, 
                        status
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + ex.getMessage(), 
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
                "Choose the List first!",
                "Unchoosen List",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi 2: Cek input quantity
        String qtyInput = isiNgundang.getText().trim();
        if (qtyInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Fill the number!", 
                "Unfilled Text", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int newQty = Integer.parseInt(qtyInput);

            // Validasi 3: Quantity minimal 1
            if (newQty < 1) {
                JOptionPane.showMessageDialog(this,
                    "Must have '1' Quantity!",
                    "Not Have Quantity",
                    JOptionPane.WARNING_MESSAGE);
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
                        "Produk Price is not found!",
                        "Unfound Price",
                        JOptionPane.WARNING_MESSAGE);
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
                        "Update: \n"
                        + newQty + " peoples\n"
                        + "Total: Rp" + "." + totalAmount, // [NEW] Tampilkan total
                        "Succsesfully Updated",
                        JOptionPane.INFORMATION_MESSAGE);

                    // Refresh data + reset input
                    rifresPesan();
                    isiNgundang.setText("");
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Data is Not Found!",
                        "Not Found Listed",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please put the Number!",
                "Wrong Format",
                JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inviTonActionPerformed

    private void minListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minListActionPerformed
        String selectedProduct = daftarMesan.getSelectedValue();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this,
                    "Choose the List first!",
                    "Unchoosen List",
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
                    DefaultListModel<String> model = (DefaultListModel<String>)
                            daftarMesan.getModel();
                    //
                    model.removeElement(selectedProduct);
                    JOptionPane.showMessageDialog(this,
                            "Success Deleting!",
                            "Successfully Deleted",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_minListActionPerformed

    private void tandaBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tandaBayarActionPerformed
        int selectedRow = tabelBayar.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Choose the List first!",
                    "Unchoosen List",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil ID dari kolom pertama (index 0) meskipun kolom disembunyikan
        int transactionId = (int) tabelBayar.getModel().getValueAt(selectedRow, 0);
        //
        // 1. Menampilkan dialog pilihan
        String[] options = {"Done", "Not Done"};
        int choice = JOptionPane.showOptionDialog(this,
                "The Payment is"+ ":",
                "Payment Status Update",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null,
                options, options[0]);
         //
        if (choice == JOptionPane.CLOSED_OPTION) {
            return; // Jika dialog ditutup, keluar dari metode
        }
        // 2. Konfirmasi tindakan
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure" + ", " +
                "your payment is" + " " + options[choice] + "?",
                "Confirmation Status",
                JOptionPane.YES_NO_OPTION);
         //
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Jika tidak, keluar dari metode
        }

        // 3. Mengupdate status di database
        String newStatus = (choice == 0) ? "Done" : "Not Done"; // "1" untuk Done, "0" untuk Not Done
        String sqlUpdate = "UPDATE transaction_detail SET order_done = ? WHERE id = ?"; // Ganti id sesuai kebutuhan

        try (PreparedStatement pst = koneksi.prepareStatement(sqlUpdate)) {
            pst.setString(1, newStatus);
            pst.setInt(2, transactionId); // Ganti dengan ID transaksi yang sesuai

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this,
                    "Now" + ", " + "your payament is " + options[choice] + "!",
                    "Update Payment Status",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed Update Status!",
                    "Update Failed",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tandaBayarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bekgronDisple;
    private javax.swing.JList<String> daftarMesan;
    private javax.swing.JButton inviTon;
    private javax.swing.JTextField isiNgundang;
    private javax.swing.JButton liatMesan;
    private javax.swing.JButton minList;
    private javax.swing.JLabel sigInvite;
    private javax.swing.JLabel signOrdering;
    private javax.swing.JScrollPane skrolBayar;
    private javax.swing.JScrollPane skrolMesan;
    private javax.swing.JTable tabelBayar;
    private javax.swing.JButton tandaBayar;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
