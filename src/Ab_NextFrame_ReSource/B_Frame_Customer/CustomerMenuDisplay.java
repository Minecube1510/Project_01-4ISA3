/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.B_Frame_Customer;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import ;
//import ;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import java.awt.event.ActionListener;
//import javax.swing.event.ListSelectionListener;
 //
import D_Funcer_ReSource.MegangData;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
// File Sistematik //

// Nyari File lain //
//import ;
 //
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class CustomerMenuDisplay extends javax.swing.JInternalFrame {

    /* Set-Up Penyambungan */
    Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    private void tampilkanData() {
        // Ambil nilai dari file lain dengan function buatan sendiri
        String username = MegangData.dapatNamae();
        String telphone = MegangData.dapetNomor();
    }

    // Method untuk membuat pesan
    public static String kirimNilai(String terPilih) {
        return terPilih; // Mengembalikan pesan yang telah dimodifikasi
    }

    private int lastTransactionId = -1;

    public CustomerMenuDisplay() {
        initComponents();
        
        tabelHarga.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // [1] Aktifkan seleksi per sel & non-aktifkan seleksi baris
        tabelHarga.setCellSelectionEnabled(true); // Bisa pilih per sel
        tabelHarga.setRowSelectionAllowed(false); // Matikan seleksi baris <-- KUNCI!
        tabelHarga.setColumnSelectionAllowed(false);

        // [2] Hapus binding default CTRL+C yang menyalin baris
        tabelHarga.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "none");
        
        // Handler untuk CTRL+C
        tabelHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.isControlDown() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_C) {
                    kopasTabelan(true);
                }
            }
        });

        // Handler untuk double-click
        tabelHarga.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Deteksi double click
                    kopasTabelan(false);
                }
            }
        });

        try {
            koneksi = DriverManager.getConnection(url, user, pass);

            nyaringMakan();
            //
            // Set nilai default jika JComboBox kosong
            if (aturMintaReq.getItemCount() == 0) {
                aturMintaReq.addItem("Pilih Kategori");
            }
            aturMintaReq.setSelectedIndex(0); // Pilih item pertama

            ambilList();
            //

        } catch(SQLException ex) {
            System.out.println("Error" + ": " + ex.getMessage());
        }
        
        // Tambahkan ActionListener untuk JComboBox
        aturMintaReq.addActionListener((ActionEvent e) -> {
            ambilList(); // Memanggil metode untuk memperbarui JList
        });
        daftarMinta.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
            String selectedItem = daftarMinta.getSelectedValue(); // Ambil item yang dipilih
            //
            //System.out.println(""); 
            //System.out.println("Choosing Menu: " + selectedItem); // Print item yang dipilih
                terangDeskrip(); // Panggil method saat item dipilih
            }
        });

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        //liatkan.setNorthPane(null);
        
        //

    }

    // Method untuk menyalin data
    private void kopasTabelan(boolean isCtrlC) {
        if (isCtrlC) {
            // Ambil sel yang aktif
            int row = tabelHarga.getSelectedRow();
            int col = tabelHarga.getSelectedColumn();

            // Pastikan ada sel yang dipilih
            if (row != -1 && col != -1) {
                Object value = tabelHarga.getValueAt(row, col);
                String cleanedValue = (value != null) ? value.toString().trim() : "";

                // Salin ke clipboard
                StringSelection ss = new StringSelection(cleanedValue);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            }
        } else {
            // Logika untuk menyalin seluruh baris
            int[] selectedRows = tabelHarga.getSelectedRows();
            int[] selectedCols = tabelHarga.getSelectedColumns();

            StringBuilder data = new StringBuilder();

            for (int row : selectedRows) {
                StringBuilder rowData = new StringBuilder();
                for (int col : selectedCols) {
                    Object value = tabelHarga.getValueAt(row, col);
                    // Hilangkan spasi/karakter aneh & pastikan tidak null
                    String cleanedValue = (value != null) ? value.toString().trim() : "";
                    rowData.append(cleanedValue).append("\t"); 
                }
                // Hapus tab terakhir di setiap baris + tambahkan newline
                String finalRow = rowData.toString().replaceAll("\t$", "") + "\n";
                data.append(finalRow);
            }

            // Hapus newline terakhir jika ada
            String finalData = data.toString().replaceAll("\n$", "");

            // Salin ke clipboard
            StringSelection ss = new StringSelection(finalData);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        }
    }

    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
    }

    public void nyaringMakan() {
        if (koneksi == null) {
            JOptionPane.showMessageDialog(null, 
                    "Make sure for the connection!",
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String kueri = "SELECT DISTINCT category FROM product";
            PreparedStatement stmt = koneksi.prepareStatement(kueri);
            ResultSet rs = stmt.executeQuery();

            boolean hasData = false;
            while (rs.next()) {
                String ketgor = rs.getString("category");
                aturMintaReq.addItem(ketgor);
                hasData = true;
            }

            // Jika tidak ada kategori, tambahkan item default
            if (!hasData) {
                aturMintaReq.addItem("No Category");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            //aturMintaReq.addItem("Error: Database Checking");  // Default item jika error
        }
    }
    //
    public void ambilList() {
        String selectedCategory = (String) aturMintaReq.getSelectedItem(); // Ambil kategori yang dipilih
        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            //

            String kueri = "SELECT " +
                           "pro_name" + " FROM " +
                           "product" + " WHERE " +
                           "category" + " = ?";
            //
            PreparedStatement stmt = koneksi.prepareStatement(kueri);
            stmt.setString(1, selectedCategory); // Set parameter kategori
            //
            ResultSet rs = stmt.executeQuery();
            

            DefaultListModel<String> listModel = new DefaultListModel<>(); // Model untuk JList
            while (rs.next()) {
                String mauMakan = rs.getString("pro_name");
                listModel.addElement(mauMakan); // Tambahkan ke model
            }
            daftarMinta.setModel(listModel); // Set model ke JList
            //
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void terangDeskrip() {
        // Kosongkan JTextField
        deskripKan.setText("");
        // Ambil produk yang dipilih dari JList
        String pilihMinta = daftarMinta.getSelectedValue();

        if (pilihMinta != null && !pilihMinta.isEmpty()) {
            try {
                // Query database untuk mendapatkan deskripsi
                String query = "SELECT " +
                               "pro_desc" + " FROM " +
                               "product" + " WHERE " +
                               "pro_name" + " = ?";
                //
                PreparedStatement stmt = koneksi.prepareStatement(query);
                stmt.setString(1, pilihMinta);

                ResultSet rs = stmt.executeQuery();

                // Nampilin hasil di teks
                if (rs.next()) {
                    deskripKan.setText(rs.getString("pro_desc"));
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "Database Error: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            deskripKan.setText("Would you choose the Menu?");  // Pesan default jika tidak ada pilihan
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronDisple = new javax.swing.JPanel();
        welKoMenu = new javax.swing.JLabel();
        skrolPesanan = new javax.swing.JScrollPane();
        kotakMesen = new javax.swing.JPanel();
        aturMintaReq = new javax.swing.JComboBox<>();
        deskripKan = new javax.swing.JTextField();
        catatAn = new javax.swing.JTextField();
        pilihPesan = new javax.swing.JButton();
        addOkeh = new javax.swing.JButton();
        hapusNoted = new javax.swing.JButton();
        skrolMinta = new javax.swing.JScrollPane();
        daftarMinta = new javax.swing.JList<>();
        ripresListHarga = new javax.swing.JButton();
        skrolHarga = new javax.swing.JScrollPane();
        tabelHarga = new javax.swing.JTable();
        perIngatAnN = new javax.swing.JLabel();
        perIngatAnS = new javax.swing.JLabel();
        jabodetabekIn = new javax.swing.JLabel();
        jabodetabekOut = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setMaximumSize(new java.awt.Dimension(610, 440));
        setMinimumSize(new java.awt.Dimension(610, 440));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(610, 440));
        setVisible(true);

        bekgronDisple.setBackground(new java.awt.Color(51, 0, 102));
        bekgronDisple.setToolTipText("Sub-Panel Background");
        bekgronDisple.setMaximumSize(new java.awt.Dimension(615, 440));
        bekgronDisple.setMinimumSize(new java.awt.Dimension(615, 440));
        bekgronDisple.setPreferredSize(new java.awt.Dimension(615, 440));

        welKoMenu.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        welKoMenu.setForeground(new java.awt.Color(51, 255, 0));
        welKoMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welKoMenu.setText(" Our Catering Menu ");
        welKoMenu.setMaximumSize(new java.awt.Dimension(300, 40));
        welKoMenu.setMinimumSize(new java.awt.Dimension(300, 40));
        welKoMenu.setPreferredSize(new java.awt.Dimension(300, 40));
        welKoMenu.setRequestFocusEnabled(false);

        skrolPesanan.setBackground(new java.awt.Color(51, 51, 51));
        skrolPesanan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        skrolPesanan.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolPesanan.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolPesanan.setMaximumSize(new java.awt.Dimension(600, 340));
        skrolPesanan.setMinimumSize(new java.awt.Dimension(600, 340));
        skrolPesanan.setPreferredSize(new java.awt.Dimension(600, 340));

        kotakMesen.setBackground(new java.awt.Color(153, 0, 102));
        kotakMesen.setMaximumSize(new java.awt.Dimension(1000, 400));
        kotakMesen.setMinimumSize(new java.awt.Dimension(1000, 400));
        kotakMesen.setPreferredSize(new java.awt.Dimension(1000, 400));

        aturMintaReq.setBackground(new java.awt.Color(153, 0, 204));
        aturMintaReq.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        aturMintaReq.setForeground(new java.awt.Color(0, 255, 255));
        aturMintaReq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aturMintaReq.setMaximumSize(new java.awt.Dimension(150, 30));
        aturMintaReq.setMinimumSize(new java.awt.Dimension(150, 30));
        aturMintaReq.setPreferredSize(new java.awt.Dimension(150, 30));

        deskripKan.setBackground(new java.awt.Color(153, 153, 153));
        deskripKan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deskripKan.setForeground(new java.awt.Color(102, 102, 102));
        deskripKan.setText("Would you choose the Menu?");
        deskripKan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        deskripKan.setMaximumSize(new java.awt.Dimension(370, 30));
        deskripKan.setMinimumSize(new java.awt.Dimension(370, 30));
        deskripKan.setPreferredSize(new java.awt.Dimension(370, 30));

        catatAn.setBackground(new java.awt.Color(153, 153, 153));
        catatAn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        catatAn.setForeground(new java.awt.Color(102, 102, 102));
        catatAn.setMargin(new java.awt.Insets(-100, 6, 2, 6));
        catatAn.setMaximumSize(new java.awt.Dimension(370, 150));
        catatAn.setMinimumSize(new java.awt.Dimension(370, 150));
        catatAn.setPreferredSize(new java.awt.Dimension(370, 150));
        catatAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catatAnActionPerformed(evt);
            }
        });

        pilihPesan.setBackground(new java.awt.Color(0, 204, 51));
        pilihPesan.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        pilihPesan.setForeground(new java.awt.Color(204, 204, 204));
        pilihPesan.setText("Add");
        pilihPesan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pilihPesan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pilihPesan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pilihPesan.setMaximumSize(new java.awt.Dimension(100, 100));
        pilihPesan.setMinimumSize(new java.awt.Dimension(100, 100));
        pilihPesan.setPreferredSize(new java.awt.Dimension(100, 100));
        pilihPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihPesanActionPerformed(evt);
            }
        });

        addOkeh.setBackground(new java.awt.Color(153, 153, 153));
        addOkeh.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        addOkeh.setForeground(new java.awt.Color(102, 0, 51));
        addOkeh.setText("Noted");
        addOkeh.setToolTipText("");
        addOkeh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addOkeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addOkeh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addOkeh.setMaximumSize(new java.awt.Dimension(150, 100));
        addOkeh.setMinimumSize(new java.awt.Dimension(150, 100));
        addOkeh.setPreferredSize(new java.awt.Dimension(150, 100));
        addOkeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOkehActionPerformed(evt);
            }
        });

        hapusNoted.setBackground(new java.awt.Color(204, 0, 0));
        hapusNoted.setFont(new java.awt.Font("Impact", 0, 100)); // NOI18N
        hapusNoted.setForeground(new java.awt.Color(204, 204, 204));
        hapusNoted.setText("<");
        hapusNoted.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hapusNoted.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusNoted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hapusNoted.setMaximumSize(new java.awt.Dimension(100, 100));
        hapusNoted.setMinimumSize(new java.awt.Dimension(100, 100));
        hapusNoted.setPreferredSize(new java.awt.Dimension(100, 100));
        hapusNoted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusNotedActionPerformed(evt);
            }
        });

        skrolMinta.setBackground(new java.awt.Color(51, 51, 51));
        skrolMinta.setForeground(new java.awt.Color(51, 255, 0));
        skrolMinta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolMinta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolMinta.setMaximumSize(new java.awt.Dimension(150, 258));
        skrolMinta.setMinimumSize(new java.awt.Dimension(150, 258));
        skrolMinta.setName(""); // NOI18N
        skrolMinta.setPreferredSize(new java.awt.Dimension(150, 258));

        daftarMinta.setBackground(new java.awt.Color(51, 0, 102));
        daftarMinta.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        daftarMinta.setForeground(new java.awt.Color(0, 255, 255));
        daftarMinta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        daftarMinta.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        daftarMinta.setMaximumSize(new java.awt.Dimension(250, 300));
        daftarMinta.setMinimumSize(new java.awt.Dimension(250, 300));
        daftarMinta.setPreferredSize(new java.awt.Dimension(250, 300));
        skrolMinta.setViewportView(daftarMinta);

        ripresListHarga.setBackground(new java.awt.Color(102, 102, 102));
        ripresListHarga.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ripresListHarga.setForeground(new java.awt.Color(204, 204, 204));
        ripresListHarga.setText("Refresh");
        ripresListHarga.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ripresListHarga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ripresListHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ripresListHargaActionPerformed(evt);
            }
        });

        skrolHarga.setBackground(new java.awt.Color(0, 255, 255));
        skrolHarga.setForeground(new java.awt.Color(102, 0, 102));
        skrolHarga.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        skrolHarga.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolHarga.setMaximumSize(new java.awt.Dimension(350, 200));
        skrolHarga.setMinimumSize(new java.awt.Dimension(350, 200));
        skrolHarga.setPreferredSize(new java.awt.Dimension(350, 200));

        tabelHarga.setBackground(new java.awt.Color(102, 0, 102));
        tabelHarga.setForeground(new java.awt.Color(0, 255, 255));
        tabelHarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Order", "Price"
            }
        ));
        tabelHarga.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        skrolHarga.setViewportView(tabelHarga);

        perIngatAnN.setFont(new java.awt.Font("Minecraft", 1, 10)); // NOI18N
        perIngatAnN.setForeground(new java.awt.Color(0, 255, 255));
        perIngatAnN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perIngatAnN.setText("Postage");

        perIngatAnS.setFont(new java.awt.Font("Minecraft", 1, 10)); // NOI18N
        perIngatAnS.setForeground(new java.awt.Color(0, 255, 255));
        perIngatAnS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perIngatAnS.setText(" Interest");

        jabodetabekIn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 30)); // NOI18N
        jabodetabekIn.setForeground(new java.awt.Color(0, 255, 255));
        jabodetabekIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jabodetabekIn.setText("In Jabodetabek (2%)");

        jabodetabekOut.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 30)); // NOI18N
        jabodetabekOut.setForeground(new java.awt.Color(0, 255, 255));
        jabodetabekOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jabodetabekOut.setText("Out Jabodetabek (5%)");

        javax.swing.GroupLayout kotakMesenLayout = new javax.swing.GroupLayout(kotakMesen);
        kotakMesen.setLayout(kotakMesenLayout);
        kotakMesenLayout.setHorizontalGroup(
            kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kotakMesenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kotakMesenLayout.createSequentialGroup()
                        .addComponent(aturMintaReq, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(deskripKan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kotakMesenLayout.createSequentialGroup()
                        .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skrolMinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(perIngatAnN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(perIngatAnS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jabodetabekIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kotakMesenLayout.createSequentialGroup()
                                .addComponent(pilihPesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addOkeh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapusNoted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(catatAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jabodetabekOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(skrolHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(ripresListHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kotakMesenLayout.setVerticalGroup(
            kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kotakMesenLayout.createSequentialGroup()
                .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kotakMesenLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aturMintaReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deskripKan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skrolMinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kotakMesenLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ripresListHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skrolHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kotakMesenLayout.createSequentialGroup()
                                .addComponent(catatAn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addOkeh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(hapusNoted, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pilihPesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kotakMesenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jabodetabekIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jabodetabekOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kotakMesenLayout.createSequentialGroup()
                        .addComponent(perIngatAnN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perIngatAnS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        deskripKan.setEditable(false);
        skrolHarga.getAccessibleContext().setAccessibleName("");

        skrolPesanan.setViewportView(kotakMesen);

        javax.swing.GroupLayout bekgronDispleLayout = new javax.swing.GroupLayout(bekgronDisple);
        bekgronDisple.setLayout(bekgronDispleLayout);
        bekgronDispleLayout.setHorizontalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welKoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(skrolPesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        bekgronDispleLayout.setVerticalGroup(
            bekgronDispleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronDispleLayout.createSequentialGroup()
                .addComponent(welKoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skrolPesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
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

    private void hapusNotedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusNotedActionPerformed
        catatAn.setText(""); // Clear text field content
    }//GEN-LAST:event_hapusNotedActionPerformed

    private void catatAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catatAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catatAnActionPerformed

    private void pilihPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihPesanActionPerformed
        //
        //System.out.println("");
        
        // [1a] Identifikasi user (menggunakan salah satu: username atau phone)
        String username = MegangData.dapatNamae(); // Bisa null jika file dijalankan langsung
        String phone = MegangData.dapetNomor();      // Bisa null jika file dijalankan langsung
        //
        String identiNama01 = kirimNilai("Faren");
        String identiNumb01 = kirimNilai("100200300400");
        //
        if (username == null) {
            username = kirimNilai("Faren");
        }
        if (phone == null) {
            phone = kirimNilai("100200300400");
        }
        //System.out.println("Name" + ": " + username);
        //System.out.println("Telp" + ": " + phone);

        // [1b] Validasi pilihan produk dari JList
        String selectedProduct = daftarMinta.getSelectedValue();
        if (selectedProduct == null || selectedProduct.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please choose the menu!",
                "Unchoosen Menu",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Connection koneksi = null;
        PreparedStatement psCustomer = null;
        PreparedStatement psProduct = null;
        PreparedStatement psTransaction = null;
        ResultSet rs = null;

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
            koneksi.setAutoCommit(false); // Mulai transaction

            // [2a] Cari customer berdasarkan nilai username atau phone yang tersedia
            String getCustomerQuery = null;
            List<String> parameters = new ArrayList<>();
            //
            if (username != null && phone != null) {
                getCustomerQuery = "SELECT id FROM customer WHERE name = ? AND telphone = ?";
                psCustomer = koneksi.prepareStatement(getCustomerQuery);
                //
                psCustomer.setString(1, username);
                parameters.add(username);
                psCustomer.setString(2, phone);
                parameters.add(phone);
            } else if (username != null) {
                getCustomerQuery = "SELECT id FROM customer WHERE name = ?";
                psCustomer = koneksi.prepareStatement(getCustomerQuery);
                //
                psCustomer.setString(1, username);
                parameters.add(username);
            } else if (phone != null) { // phone != null
                getCustomerQuery = "SELECT id FROM customer WHERE telphone = ?";
                psCustomer = koneksi.prepareStatement(getCustomerQuery);
                //
                psCustomer.setString(1, phone);
                parameters.add(phone);
            }

            // Ini kalo gak terdaftar si user
            rs = psCustomer.executeQuery();
            int customerId;
            if (rs.next()) {
                customerId = rs.getInt("id");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Customer isn't in list!",
                    "Non-Listed Customer",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            rs.close();
            psCustomer.close();

            // [3] Ambil product_id dan harga dari tabel product berdasarkan produk yang dipilih
            String getProductQuery = "SELECT id, price FROM product WHERE pro_name = ?";
            psProduct = koneksi.prepareStatement(getProductQuery);
            psProduct.setString(1, selectedProduct);
            //psTransaction.setInt(2, productId);
            rs = psProduct.executeQuery();

            int productId;
            long price;
            if (rs.next()) {
                productId = rs.getInt("id");
                price = rs.getLong("price");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Product isn't found!",
                    "Not found Product",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            rs.close();
            psProduct.close();

            // [4] Insert ke tabel transaction (total_qty = 1, total_amount = harga produk)
            String insertTransaction = "INSERT INTO transaction (" +
                    "customer_id, product_id, total_amount, total_qty) VALUES (?, ?, ?, ?)";
            psTransaction = koneksi.prepareStatement(insertTransaction,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            psTransaction.setInt(1, customerId);
            psTransaction.setInt(2, productId);
            psTransaction.setLong(3, price); // Asumsi satu item
            psTransaction.setInt(4, 1);
            psTransaction.executeUpdate();

            // [5] Ambil transaction_id yang baru dibuat
            int transactionId;
            rs = psTransaction.getGeneratedKeys();
            if (rs.next()) {
                transactionId = rs.getInt(1);
            } else {
                throw new SQLException("Gagal mendapatkan ID transaksi");
            }
            rs.close();
            psTransaction.close();

            // Commit transaction
            koneksi.commit();

            JOptionPane.showMessageDialog(this,
                """
                The Orders successfully added!
                Transaction ID: """ + " " + transactionId,
                "Added Succsesfully",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException ex) {
            try {
                if (koneksi != null) koneksi.rollback();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,
                        "Database Error: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            //System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (psCustomer != null) psCustomer.close();
                if (psProduct != null) psProduct.close();
                if (psTransaction != null) psTransaction.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
        //
    }//GEN-LAST:event_pilihPesanActionPerformed
    //
    private int getCustomerId(String username, String phone) throws SQLException {
        String query = "SELECT id FROM customer WHERE name = ? AND telphone = ?";
        PreparedStatement ps = koneksi.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, phone);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        } else {
            throw new SQLException("Customer tidak ditemukan!");
        }
    }
    //

    //

    private void addOkehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOkehActionPerformed
        //
        String username = MegangData.dapatNamae(); // Ambil nama pengguna
        String phone = MegangData.dapetNomor(); // Ambil nomor telepon
        //
        String identiNama01 = kirimNilai("Faren");
        String identiNumb01 = kirimNilai("100200300400");
        //
        if (username == null) {
            username = kirimNilai("Faren");
        }
        if (phone == null) {
            phone = kirimNilai("100200300400");
        }

        // 1. Dapatkan customer_id berdasarkan username & telepon
        int customerId;
        try {
            customerId = getCustomerId(username, phone); // Gunakan method yang sudah ada
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Customer isn't in list!", 
                "Non Listed User", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Ambil notes dari input user
        String notes = catatAn.getText();

        // 3. Update kolom notes di tabel customer
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String query = "UPDATE customer SET notes = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, notes);
            ps.setInt(2, customerId); // Gunakan customer_id, BUKAN transaction_id

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this,
                    "Successfully saving the Notes!",
                    "Successfully Added",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed saving the Notes...",
                    "Failed Adding",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addOkehActionPerformed

    private void ripresListHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ripresListHargaActionPerformed
        try (Connection koneksi = DriverManager.getConnection(url, user, pass)) {
            String kueri = "SELECT pro_name, price FROM product";
            PreparedStatement stmt = koneksi.prepareStatement(kueri);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel(new String[]{"Order", "Price"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Matikan edit sel
                }
            };

            while (rs.next()) {
                String proName = rs.getString("pro_name");
                long price = rs.getLong("price");
                model.addRow(new Object[]{proName, price});
            }
            tabelHarga.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ripresListHargaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOkeh;
    private javax.swing.JComboBox<String> aturMintaReq;
    private javax.swing.JPanel bekgronDisple;
    private javax.swing.JTextField catatAn;
    private javax.swing.JList<String> daftarMinta;
    private javax.swing.JTextField deskripKan;
    private javax.swing.JButton hapusNoted;
    private javax.swing.JLabel jabodetabekIn;
    private javax.swing.JLabel jabodetabekOut;
    private javax.swing.JPanel kotakMesen;
    private javax.swing.JLabel perIngatAnN;
    private javax.swing.JLabel perIngatAnS;
    private javax.swing.JButton pilihPesan;
    private javax.swing.JButton ripresListHarga;
    private javax.swing.JScrollPane skrolHarga;
    private javax.swing.JScrollPane skrolMinta;
    private javax.swing.JScrollPane skrolPesanan;
    private javax.swing.JTable tabelHarga;
    private javax.swing.JLabel welKoMenu;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
