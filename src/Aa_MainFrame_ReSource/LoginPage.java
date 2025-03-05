/* {Main Frame: Akses Masuk} */
//
/* Catatan */
// Dibaca (ID, Nama, Hak Akses, Sandi)
// [00]/[--], [Satwan], [First High Admin], [s4tl0ps_01]
// [00]/[--], [Rocksam], [High Admin], [S1xm4ura_06]
// 
/* Catatan */


/* Paketan Folder-nya */
package Aa_MainFrame_ReSource;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import javax.swing.*;
//import javax.swing.ImageIcon;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.sql.PreparedStatement;
// import javax.swing.JOptionPane;
// import javax.swing.text.PlainDocument;
// import java.sql.ResultSet;
 //
import D_Funcer_ReSource.MegangData;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// File Sistematik //

// Nyari File lain //
//import ;
//import B_Dialog_ReSource.DialogAdmin_01_G13;
 //
import Ab_NextFrame_ReSource.AdminDashboardPage;
import Ab_NextFrame_ReSource.CustomerDashboardPage;
// Nyari File lain //
/* Main Application */
public class LoginPage extends javax.swing.JFrame {

    /* Set-Up Penyambungan */
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    /* Creates new in this file */
    public LoginPage() {
        initComponents();

        // Mengatur lokasi frame di tengah layar
        setLocationRelativeTo(null);  // Memposisikan frame di tengah layar
    }

    public LoginPage(MegangData pegangData) {
        this(); // Panggil konstruktor kosong
        // Inisialisasi tambahan jika diperlukan
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Get Connected!");
        } catch (SQLException e) {
            System.out.println("Failed Connect" + ": " + e.getMessage());
        }
        return connection;
    }

    public void ClosingApp() {
        /* Rumus bawainnya */
        //Project_01__4_ISA_3 closapp = new Project_01__4_ISA_3();
        //closapp.ClosingApp();
        /* Rumus bawainnya */

        /* Kode Sistem */
        //System.out.println("==~== ==~== ==~==");  // Batasin
        //
        System.out.println("Thank You!");
        System.out.println("Please come again!");
        System.out.println("===== =-~-= =====");  // Batasin
        System.out.println("");  // Batasin
        /* Kode Sistem */
    }
    
    /* ? */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        outAppEd = new javax.swing.JButton();
        mainBekgron = new javax.swing.JPanel();
        judulTempatBisnis = new javax.swing.JLabel();
        namaPelakuan = new javax.swing.JLabel();
        isiNama = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        isiNoTelp = new javax.swing.JTextField();
        goLogIn = new javax.swing.JButton();
        addCustomIn = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        outAppEd.setBackground(new java.awt.Color(225, 4, 37));
        outAppEd.setFont(new java.awt.Font("Minecraft", 1, 28)); // NOI18N
        outAppEd.setForeground(new java.awt.Color(6, 202, 0));
        outAppEd.setText("Exit");
        outAppEd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        outAppEd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outAppEd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        outAppEd.setName(""); // NOI18N
        outAppEd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outAppEdActionPerformed(evt);
            }
        });
        outAppEd.getAccessibleContext().setAccessibleDescription("Close the App");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partival's Catering");
        setBackground(new java.awt.Color(51, 153, 255));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("login_gui"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainBekgron.setBackground(new java.awt.Color(64, 182, 221));
        mainBekgron.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainBekgron.setForeground(new java.awt.Color(0, 204, 204));
        mainBekgron.setToolTipText("");
        mainBekgron.setMaximumSize(new java.awt.Dimension(772, 450));
        mainBekgron.setMinimumSize(new java.awt.Dimension(772, 450));
        mainBekgron.setPreferredSize(new java.awt.Dimension(772, 450));

        judulTempatBisnis.setFont(new java.awt.Font("Harlow Solid Italic", 3, 36)); // NOI18N
        judulTempatBisnis.setForeground(new java.awt.Color(27, 193, 32));
        judulTempatBisnis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulTempatBisnis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/C_Images_ReSource/CateringTitle.png"))); // NOI18N
        judulTempatBisnis.setLabelFor(this);
        judulTempatBisnis.setToolTipText("");
        judulTempatBisnis.setAlignmentY(0.0F);
        judulTempatBisnis.setDoubleBuffered(true);
        judulTempatBisnis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        judulTempatBisnis.setMaximumSize(new java.awt.Dimension(770, 160));
        judulTempatBisnis.setMinimumSize(new java.awt.Dimension(770, 160));
        judulTempatBisnis.setName("Name Title"); // NOI18N
        judulTempatBisnis.setPreferredSize(new java.awt.Dimension(770, 160));
        judulTempatBisnis.setRequestFocusEnabled(false);

        namaPelakuan.setFont(new java.awt.Font("Playbill", 1, 40)); // NOI18N
        namaPelakuan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaPelakuan.setText("Full Name ");
        namaPelakuan.setToolTipText("");
        namaPelakuan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        namaPelakuan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        namaPelakuan.setMaximumSize(new java.awt.Dimension(175, 40));
        namaPelakuan.setMinimumSize(new java.awt.Dimension(175, 40));
        namaPelakuan.setName("Full Name"); // NOI18N
        namaPelakuan.setPreferredSize(new java.awt.Dimension(175, 40));

        isiNama.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        isiNama.setToolTipText("");
        isiNama.setMargin(new java.awt.Insets(4, 6, 2, 6));
        isiNama.setMaximumSize(new java.awt.Dimension(550, 40));
        isiNama.setMinimumSize(new java.awt.Dimension(550, 40));
        isiNama.setPreferredSize(new java.awt.Dimension(550, 40));
        isiNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiNamaActionPerformed(evt);
            }
        });

        noTelp.setFont(new java.awt.Font("Playbill", 1, 40)); // NOI18N
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noTelp.setText("Telephone ");
        noTelp.setToolTipText("");
        noTelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        noTelp.setMaximumSize(new java.awt.Dimension(175, 40));
        noTelp.setMinimumSize(new java.awt.Dimension(175, 40));
        noTelp.setName("No Phone"); // NOI18N
        noTelp.setPreferredSize(new java.awt.Dimension(175, 40));

        isiNoTelp.setFont(new java.awt.Font("Minecraft", 1, 12)); // NOI18N
        isiNoTelp.setToolTipText("");
        isiNoTelp.setMargin(new java.awt.Insets(4, 6, 2, 6));
        isiNoTelp.setMaximumSize(new java.awt.Dimension(550, 40));
        isiNoTelp.setMinimumSize(new java.awt.Dimension(550, 40));
        isiNoTelp.setName("phoNumber"); // NOI18N
        isiNoTelp.setPreferredSize(new java.awt.Dimension(550, 40));
        isiNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiNoTelpActionPerformed(evt);
            }
        });
        isiNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                isiNoTelpKeyTyped(evt);
            }
        });

        goLogIn.setBackground(new java.awt.Color(93, 9, 14));
        goLogIn.setFont(new java.awt.Font("Minecraft", 1, 28)); // NOI18N
        goLogIn.setForeground(new java.awt.Color(255, 125, 0));
        goLogIn.setText("Log In");
        goLogIn.setToolTipText("");
        goLogIn.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(58, 9, 9), new java.awt.Color(84, 35, 49)));
        goLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goLogIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goLogIn.setMaximumSize(new java.awt.Dimension(250, 50));
        goLogIn.setMinimumSize(new java.awt.Dimension(250, 50));
        goLogIn.setName(""); // NOI18N
        goLogIn.setPreferredSize(new java.awt.Dimension(250, 50));
        goLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goLogInActionPerformed(evt);
            }
        });

        addCustomIn.setBackground(new java.awt.Color(0, 153, 0));
        addCustomIn.setFont(new java.awt.Font("Minecraft", 1, 28)); // NOI18N
        addCustomIn.setForeground(new java.awt.Color(51, 102, 0));
        addCustomIn.setText("Ordering");
        addCustomIn.setToolTipText("");
        addCustomIn.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(19, 153, 0), new java.awt.Color(32, 59, 0)));
        addCustomIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCustomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCustomIn.setMaximumSize(new java.awt.Dimension(250, 50));
        addCustomIn.setMinimumSize(new java.awt.Dimension(250, 50));
        addCustomIn.setName(""); // NOI18N
        addCustomIn.setPreferredSize(new java.awt.Dimension(250, 50));
        addCustomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainBekgronLayout = new javax.swing.GroupLayout(mainBekgron);
        mainBekgron.setLayout(mainBekgronLayout);
        mainBekgronLayout.setHorizontalGroup(
            mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainBekgronLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaPelakuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainBekgronLayout.createSequentialGroup()
                        .addComponent(goLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCustomIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(isiNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isiNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainBekgronLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(judulTempatBisnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainBekgronLayout.setVerticalGroup(
            mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainBekgronLayout.createSequentialGroup()
                .addComponent(judulTempatBisnis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaPelakuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isiNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(mainBekgronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCustomIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        judulTempatBisnis.getAccessibleContext().setAccessibleName("Business Place");
        judulTempatBisnis.getAccessibleContext().setAccessibleDescription("Title of the Business");
        namaPelakuan.getAccessibleContext().setAccessibleName("Full Username Sign");
        namaPelakuan.getAccessibleContext().setAccessibleDescription("Sign: Full Name");
        namaPelakuan.getAccessibleContext().setAccessibleParent(judulTempatBisnis);
        isiNama.getAccessibleContext().setAccessibleName("Username Box");
        isiNama.getAccessibleContext().setAccessibleDescription("Fill your name!");
        isiNama.getAccessibleContext().setAccessibleParent(namaPelakuan);
        noTelp.getAccessibleContext().setAccessibleName("Phone Number Sign");
        noTelp.getAccessibleContext().setAccessibleDescription("Sign: Phone Number");
        noTelp.getAccessibleContext().setAccessibleParent(namaPelakuan);
        isiNoTelp.getAccessibleContext().setAccessibleName("Phone Number Box");
        isiNoTelp.getAccessibleContext().setAccessibleDescription("Fill your number phone!");
        isiNoTelp.getAccessibleContext().setAccessibleParent(noTelp);
        goLogIn.getAccessibleContext().setAccessibleName("LogIn Button");
        goLogIn.getAccessibleContext().setAccessibleDescription("Go Further in App");
        goLogIn.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBekgron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBekgron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        mainBekgron.getAccessibleContext().setAccessibleName("Panel Form");
        mainBekgron.getAccessibleContext().setAccessibleDescription("Background of Login Form");

        getAccessibleContext().setAccessibleDescription("First Main Login");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MegangData pegangData = new MegangData();

        /* Menampilkan pesan */
        LoginPage closapp = new LoginPage(pegangData);
        closapp.ClosingApp();
        /* Menampilkan pesan */
        
        /* Menutup jendela */
        this.dispose();
        /* Menutup jendela */
    }//GEN-LAST:event_formWindowClosing

    private void outAppEdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outAppEdActionPerformed
        MegangData pegangData = new MegangData();

        /* Menampilkan pesan */
        LoginPage closapp = new LoginPage(pegangData);
        closapp.ClosingApp();
        /* Menampilkan pesan */

        /* Menutup jendela */
        System.exit(0);
        /* Menutup jendela */
    }//GEN-LAST:event_outAppEdActionPerformed

    private void authenticateUser (String username, String password) {
        String dapetNama = isiNama.getText();

        /* Mendapatkan Tabel */
        String query = "SELECT * FROM " +
                       "customer" + " WHERE " +     // Table
                       "name" + " = ? AND " +       // Nama
                       "telphone" + " = ?";         // Nomor Telpon
        /* Mendapatkan Tabel */

        /* Sistematik Masuk */
        try (Connection koneksi = DriverManager.getConnection(url, user, pass);
             PreparedStatement siapStet = koneksi.prepareStatement(query)) {
             
            siapStet.setString(1, username);
            siapStet.setString(2, password);

            try (ResultSet resultSet = siapStet.executeQuery()) {
                if (resultSet.next()) {  //[Inmat] [123498763690]
                    String mintanama = resultSet.getString("name");  // Nomor Khusus
                    String mintanomor = resultSet.getString("telphone");  // Nomor Khusus

                    // [Inmat 123498763690] //
                    String adminem = "Inmat";  // [Inmat]
                    String adminom = "123498763690";  // [1234-9876-3690]
                    // [Inmat 123498763690] //

                    // Menampilkan khusus kepada Admin
                    // [nama] [telp] [nama telp]
                    // [Inmat] [123498763690] [Inmat 123498763690]
                    if (mintanama.equalsIgnoreCase(adminem) &&
                        mintanomor.equalsIgnoreCase(adminom)) {
                        /* Selamat Datang, Admin */
                        JOptionPane.showMessageDialog(this,
                        "Login Succesfully! Welcome back!",
                        "Access Granted",
                        JOptionPane.INFORMATION_MESSAGE);
                        
                        System.out.println("Welcome: " + mintanama);
                        System.out.println("===== =-~-= =====");  // Batasin
                        /* Selamat Datang, Admin */

                        /* Menuju: Dasbor - Admin */
                        AdminDashboardPage adminDasbor = new AdminDashboardPage();
                        dispose();                      // Menutup jendela login
                        adminDasbor.AppOp_Admin();
                        adminDasbor.setVisible(true);     // Menampilkan dashboard
                        /* Menuju: Dasbor - Admin */
                    } else {
                        /* Selamat Datang, Pelanggan */
                        JOptionPane.showMessageDialog(this,
                        "Login Succesfully! Can to Ordering.",
                        "Acceptance to Order",
                        JOptionPane.INFORMATION_MESSAGE);

                        System.out.println("Welcome: " + "Customer");
                        System.out.println("===== =-~-= =====");  // Batasin
                        /* Selamat Datang, Pelanggan */

                        /* Menuju: Dasbor - Pelanggan */
                        CustomerDashboardPage langganDasbor = new CustomerDashboardPage();
                        dispose();                      // Menutup jendela login
                        langganDasbor.AppOp_Custom();
                        langganDasbor.setVisible(true);     // Menampilkan dashboard
                        /* Menuju: Dasbor - Pelanggan */
                    }

                } else {
                    JOptionPane.showMessageDialog(this,
                    "Failed Login! Invalid Username or Telephone Number!",
                    "Invalid Login",
                    JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
            "Database Error" + ": " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        /* Sistematik Masuk */
    }

    private void goLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goLogInActionPerformed
        /* Kodean Data */
        String username = isiNama.getText().trim();
        String telphone = isiNoTelp.getText();

        // Simpan nilai ke DataHolder
        MegangData.setNamae(username);
        MegangData.setNomor(telphone);

        // Pindah ke frame admin/pelanggan
        authenticateUser(username, telphone);
        /* Kodean Data */
        
        /* Sistematik Masuk */
        if (username.isEmpty() || telphone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please filled all!");
        }
        /* Sistematik Masuk */
    }//GEN-LAST:event_goLogInActionPerformed

    private void isiNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiNoTelpActionPerformed

    private void isiNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiNamaActionPerformed

    private void isiNoTelpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isiNoTelpKeyTyped
        char c = evt.getKeyChar();
        String currentText = isiNoTelp.getText();

        if (Character.isDigit(c)) {
            if (currentText.length() >= 16) {
                evt.consume();
            }
        } else if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) { // Allow backspace and delete
            evt.consume();
        }
    }//GEN-LAST:event_isiNoTelpKeyTyped

    private void addCustomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomInActionPerformed
        /* Menambahkan Data Pelanggan */
        String username = isiNama.getText().trim();
        String telphone = isiNoTelp.getText();

        // Simpan nilai ke DataHolder
        MegangData.setNamae(username);
        MegangData.setNomor(telphone);
        /* Menambahkan Data Pelanggan */

        // Cek apakah kedua teks kosong
        if (username.isEmpty() || telphone.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Fill 'em all!",
                    "Unfilled",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika ada yang kosong
        }

        // Validasi panjang nomor telepon
        else if (telphone.length() != 10) {
            JOptionPane.showMessageDialog(this,
                    "Phone Number must than 10 digits!",
                    "Unidentified Phone Number",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Perintah SQL - Menambahkan Data
            String query = "INSERT INTO " +
                           "customer" + " (" +  // Tabel
                           "name" + ", " +      // Nama
                           "telphone" + ")" +   // Nomor Telpon
                           "VALUES (?, ?)";

            /* Sistematik Penambahan */
            // Integrasi
            Connection koneksi = DriverManager.getConnection(url, user, pass);
            PreparedStatement steTambah = koneksi.prepareStatement(query);
            //
            steTambah.setString(1, username);
            steTambah.setString(2, telphone);
            steTambah.executeUpdate();

            // Pemberitahuan
            JOptionPane.showMessageDialog(this,  // Dibawah: Teks
                    """
                    Added New Customer!
                    
                    Name: """ + " " + username + "\n" +     // Nama
                    "Telp" + ": " + telphone,               // Telepon
                    "Customer Added",                       // Judul
                    JOptionPane.INFORMATION_MESSAGE);

            // Menuju: Dasbor - Pelanggan
            CustomerDashboardPage langganTambahDasbor = new CustomerDashboardPage();
            dispose();                      // Menutup jendela login
            langganTambahDasbor.AppOp_Custom();
            langganTambahDasbor.setVisible(true);     // Menampilkan dashboard
            /* Sistematik Penambahan */
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    """
                    Getting Error: 
                    """ + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addCustomInActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Memastikan File mampu menjalankan program (membuka GUI) */
        String penJudulan = "Partival's Catering";
        //
        System.out.println("");  // Batasin
        System.out.println("==~== ==~== ==~==");  // Batasin
        System.out.println("Open the App:");
        //
        try {
            // [2000 ms = 2 detik]
            Thread.sleep(750);
        } catch (InterruptedException e) {
            //System.out.println(penJudulan);
        }
        //
         //System.out.print("{ ");
        System.out.println(penJudulan);  // Judulnya
         //System.out.println(" }");
        System.out.println("==~== ==~== ==~==");  // Batasin
        /* Memastikan File mampu menjalankan program (membuka GUI) */

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomIn;
    private javax.swing.JButton goLogIn;
    private javax.swing.JTextField isiNama;
    private javax.swing.JTextField isiNoTelp;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel judulTempatBisnis;
    private javax.swing.JPanel mainBekgron;
    private javax.swing.JLabel namaPelakuan;
    private javax.swing.JLabel noTelp;
    private javax.swing.JButton outAppEd;
    // End of variables declaration//GEN-END:variables
}
/* Main Application */
