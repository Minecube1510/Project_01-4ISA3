/* Paketan Folder-nya */
package Ab_NextFrame_ReSource;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import javax.swing.ImageIcon;
//import java.awt.event.KeyEvent;
//import java.sql.PreparedStatement;
 //
//import javax.swing.*;
//import javax.swing.JOptionPane;
//import javax.swing.text.PlainDocument;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import com.mysql.cj.jdbc.result.ResultSetMetaData;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
// File Sistematik //

// Nyari File lain //
//import Ab_Frame_ReSource.DistADB_01b__G13;
//import Ab_Frame_ReSource.Ba2_DistADB__G13;
//import Z_Archives.DistADB_01a__G13_z01;
//import ;
 //
import D_Funcer_ReSource.MegangData;
//
import Aa_MainFrame_ReSource.LoginPage;  // Main Login
import Ab_NextFrame_ReSource.B_Frame_Customer.CustomerMenuDisplay;
import Ab_NextFrame_ReSource.B_Frame_Customer.CustomerOrderDisplay;
import Ab_NextFrame_ReSource.B_Frame_Customer.CustomerReserveDisplay;
import Ab_NextFrame_ReSource.B_Frame_Customer.Customer__NNN__Display;
// Nyari File lain //

/* Main System */
public class CustomerDashboardPage extends javax.swing.JFrame {

    /* Set-Up Penyambungan */
    private Connection koneksi;
     //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
     //
    //
    /* Set-Up Penyambungan */

    public final void updateLabel(String text) {
        pengGuna.setText(text); // Mengupdate teks di JLabel
    }
    //
    private void tampilkanData() {
        // Ambil nilai dari file lain dengan function buatan sendiri
        String username = MegangData.dapatNamae();
        String telphone = MegangData.dapetNomor();
    }

    // Method untuk membuat pesan
    public static String kirimNilai(String terPilih) {
        return terPilih; // Mengembalikan pesan yang telah dimodifikasi
    }

    public CustomerDashboardPage() {
        initComponents();

        /* Pengambilan Inisialis */
        String identiNama01 = kirimNilai("Faren");
        String identiNumb01 = kirimNilai("100200300400");
        //
        String identiNama02 = kirimNilai("Lakia");
        String identiNumb02 = kirimNilai("333555000666");

        String userNama = MegangData.dapatNamae();
        String teleFone = MegangData.dapetNomor();
        /* Pengambilan Inisialis */

        // Jika null, set userNama ke "Pelanggan"
        if (userNama == null) {
            //userNama = "Our Customer";
            userNama = identiNama01;
        }
        //
        updateLabel(" " + userNama + "?");

        // Mengatur lokasi frame di tengah layar
        setLocationRelativeTo(null);  // Memposisikan frame di tengah layar

        //
        //ambilJenisData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optUnknown = new javax.swing.JButton();
        skrolLanggan = new javax.swing.JScrollPane();
        bekgronServis = new javax.swing.JPanel();
        judulServis = new javax.swing.JPanel();
        judulAtas = new javax.swing.JLabel();
        judulBawah = new javax.swing.JLabel();
        kendaliServis = new javax.swing.JPanel();
        welKom = new javax.swing.JLabel();
        pengGuna = new javax.swing.JLabel();
        tubuTompol = new javax.swing.JButton();
        tomboLogOut = new javax.swing.JButton();
        opsiKeServis = new javax.swing.JPanel();
        optMenu = new javax.swing.JButton();
        optOrdery = new javax.swing.JButton();
        optReserve = new javax.swing.JButton();
        liatServis = new javax.swing.JDesktopPane();

        optUnknown.setBackground(new java.awt.Color(0, 51, 153));
        optUnknown.setFont(new java.awt.Font("Minecraft", 1, 20)); // NOI18N
        optUnknown.setForeground(new java.awt.Color(7, 210, 7));
        optUnknown.setText("4");
        optUnknown.setToolTipText("");
        optUnknown.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        optUnknown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optUnknown.setMaximumSize(new java.awt.Dimension(182, 41));
        optUnknown.setMinimumSize(new java.awt.Dimension(182, 41));
        optUnknown.setPreferredSize(new java.awt.Dimension(182, 41));
        optUnknown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optUnknownActionPerformed(evt);
            }
        });
        optUnknown.getAccessibleContext().setAccessibleName("Combo Option");
        optUnknown.getAccessibleContext().setAccessibleDescription("Option of Combo");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(850, 600));
        setMinimumSize(new java.awt.Dimension(850, 600));
        setPreferredSize(new java.awt.Dimension(850, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        skrolLanggan.setMaximumSize(new java.awt.Dimension(800, 500));
        skrolLanggan.setMinimumSize(new java.awt.Dimension(800, 500));
        skrolLanggan.setPreferredSize(new java.awt.Dimension(800, 500));

        bekgronServis.setBackground(new java.awt.Color(51, 51, 51));
        bekgronServis.setToolTipText("");
        bekgronServis.setMaximumSize(new java.awt.Dimension(800, 500));
        bekgronServis.setMinimumSize(new java.awt.Dimension(800, 500));
        bekgronServis.setPreferredSize(new java.awt.Dimension(800, 500));

        judulServis.setBackground(new java.awt.Color(51, 153, 0));
        judulServis.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        judulServis.setForeground(new java.awt.Color(255, 255, 255));
        judulServis.setToolTipText("");
        judulServis.setFont(new java.awt.Font("Harlow Solid Italic", 2, 28)); // NOI18N
        judulServis.setMaximumSize(new java.awt.Dimension(200, 100));
        judulServis.setMinimumSize(new java.awt.Dimension(200, 100));
        judulServis.setName("TitlePane"); // NOI18N
        judulServis.setPreferredSize(new java.awt.Dimension(200, 100));

        judulAtas.setFont(new java.awt.Font("Harlow Solid Italic", 2, 28)); // NOI18N
        judulAtas.setForeground(new java.awt.Color(204, 153, 0));
        judulAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulAtas.setText("Partival's");
        judulAtas.setToolTipText("");
        judulAtas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        judulAtas.setMaximumSize(new java.awt.Dimension(184, 38));
        judulAtas.setMinimumSize(new java.awt.Dimension(184, 38));
        judulAtas.setName("NorTitle"); // NOI18N
        judulAtas.setPreferredSize(new java.awt.Dimension(184, 38));

        judulBawah.setFont(new java.awt.Font("Harlow Solid Italic", 2, 28)); // NOI18N
        judulBawah.setForeground(new java.awt.Color(255, 255, 0));
        judulBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulBawah.setText("Catering");
        judulBawah.setToolTipText("");
        judulBawah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        judulBawah.setMaximumSize(new java.awt.Dimension(184, 38));
        judulBawah.setMinimumSize(new java.awt.Dimension(184, 38));
        judulBawah.setName("SouTitle"); // NOI18N
        judulBawah.setPreferredSize(new java.awt.Dimension(184, 38));

        javax.swing.GroupLayout judulServisLayout = new javax.swing.GroupLayout(judulServis);
        judulServis.setLayout(judulServisLayout);
        judulServisLayout.setHorizontalGroup(
            judulServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(judulServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulAtas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(judulBawah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        judulServisLayout.setVerticalGroup(
            judulServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulServisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judulBawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        judulAtas.getAccessibleContext().setAccessibleName("Top Title");
        judulAtas.getAccessibleContext().setAccessibleDescription("Title at North");
        judulBawah.getAccessibleContext().setAccessibleName("Bottom Title");
        judulBawah.getAccessibleContext().setAccessibleDescription("Title at South");

        kendaliServis.setBackground(new java.awt.Color(0, 153, 153));
        kendaliServis.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        kendaliServis.setForeground(new java.awt.Color(255, 102, 102));
        kendaliServis.setToolTipText("");
        kendaliServis.setMaximumSize(new java.awt.Dimension(565, 100));
        kendaliServis.setMinimumSize(new java.awt.Dimension(565, 100));
        kendaliServis.setName("ControlPane"); // NOI18N
        kendaliServis.setPreferredSize(new java.awt.Dimension(565, 100));

        welKom.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        welKom.setForeground(new java.awt.Color(73, 34, 71));
        welKom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        welKom.setText(" What's your order,");
        welKom.setToolTipText("");
        welKom.setMaximumSize(new java.awt.Dimension(350, 40));
        welKom.setMinimumSize(new java.awt.Dimension(350, 40));
        welKom.setPreferredSize(new java.awt.Dimension(350, 40));

        pengGuna.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        pengGuna.setForeground(new java.awt.Color(73, 34, 71));
        pengGuna.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pengGuna.setToolTipText("");
        pengGuna.setMaximumSize(new java.awt.Dimension(350, 40));
        pengGuna.setMinimumSize(new java.awt.Dimension(350, 40));
        pengGuna.setPreferredSize(new java.awt.Dimension(350, 40));

        tubuTompol.setBackground(new java.awt.Color(102, 102, 102));
        tubuTompol.setFont(new java.awt.Font("Minecraft", 1, 24)); // NOI18N
        tubuTompol.setForeground(new java.awt.Color(204, 0, 0));
        tubuTompol.setText("Close");
        tubuTompol.setToolTipText("");
        tubuTompol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tubuTompol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tubuTompol.setMaximumSize(new java.awt.Dimension(140, 40));
        tubuTompol.setMinimumSize(new java.awt.Dimension(140, 40));
        tubuTompol.setPreferredSize(new java.awt.Dimension(140, 40));
        tubuTompol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tubuTompolActionPerformed(evt);
            }
        });

        tomboLogOut.setBackground(new java.awt.Color(153, 0, 153));
        tomboLogOut.setFont(new java.awt.Font("Minecraft", 1, 24)); // NOI18N
        tomboLogOut.setForeground(new java.awt.Color(204, 204, 204));
        tomboLogOut.setText("Log Out");
        tomboLogOut.setToolTipText("");
        tomboLogOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tomboLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tomboLogOut.setMaximumSize(new java.awt.Dimension(140, 40));
        tomboLogOut.setMinimumSize(new java.awt.Dimension(140, 40));
        tomboLogOut.setPreferredSize(new java.awt.Dimension(140, 40));
        tomboLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kendaliServisLayout = new javax.swing.GroupLayout(kendaliServis);
        kendaliServis.setLayout(kendaliServisLayout);
        kendaliServisLayout.setHorizontalGroup(
            kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kendaliServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pengGuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welKom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tomboLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tubuTompol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        kendaliServisLayout.setVerticalGroup(
            kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaliServisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tubuTompol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welKom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaliServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tomboLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pengGuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        welKom.getAccessibleContext().setAccessibleName("Top Welcome Text");
        welKom.getAccessibleContext().setAccessibleDescription("Welcomes at Top");
        pengGuna.getAccessibleContext().setAccessibleName("Bottom Welcome Text");
        pengGuna.getAccessibleContext().setAccessibleDescription("Welcomes at Bottom");
        tubuTompol.getAccessibleContext().setAccessibleName("Close Accs");
        tubuTompol.getAccessibleContext().setAccessibleDescription("Closing System Progs");
        tomboLogOut.getAccessibleContext().setAccessibleName("Log Out Accs");
        tomboLogOut.getAccessibleContext().setAccessibleDescription("Go to Main Login");

        opsiKeServis.setBackground(new java.awt.Color(204, 204, 0));
        opsiKeServis.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        opsiKeServis.setForeground(new java.awt.Color(255, 102, 102));
        opsiKeServis.setToolTipText("");
        opsiKeServis.setFont(new java.awt.Font("Minecraft", 1, 20)); // NOI18N
        opsiKeServis.setMaximumSize(new java.awt.Dimension(200, 344));
        opsiKeServis.setMinimumSize(new java.awt.Dimension(200, 344));
        opsiKeServis.setName("OptionPane"); // NOI18N
        opsiKeServis.setPreferredSize(new java.awt.Dimension(200, 344));

        optMenu.setBackground(new java.awt.Color(0, 51, 153));
        optMenu.setFont(new java.awt.Font("Minecraft", 1, 20)); // NOI18N
        optMenu.setForeground(new java.awt.Color(7, 210, 7));
        optMenu.setText("Menu");
        optMenu.setToolTipText("");
        optMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        optMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optMenu.setMaximumSize(new java.awt.Dimension(182, 41));
        optMenu.setMinimumSize(new java.awt.Dimension(182, 41));
        optMenu.setPreferredSize(new java.awt.Dimension(182, 41));
        optMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optMenuActionPerformed(evt);
            }
        });

        optOrdery.setBackground(new java.awt.Color(0, 51, 153));
        optOrdery.setFont(new java.awt.Font("Minecraft", 1, 20)); // NOI18N
        optOrdery.setForeground(new java.awt.Color(7, 210, 7));
        optOrdery.setText("Orders");
        optOrdery.setToolTipText("");
        optOrdery.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        optOrdery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optOrdery.setMaximumSize(new java.awt.Dimension(182, 41));
        optOrdery.setMinimumSize(new java.awt.Dimension(182, 41));
        optOrdery.setPreferredSize(new java.awt.Dimension(182, 41));
        optOrdery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOrderyActionPerformed(evt);
            }
        });

        optReserve.setBackground(new java.awt.Color(0, 51, 153));
        optReserve.setFont(new java.awt.Font("Minecraft", 1, 20)); // NOI18N
        optReserve.setForeground(new java.awt.Color(7, 210, 7));
        optReserve.setText("Reserve");
        optReserve.setToolTipText("");
        optReserve.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        optReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optReserve.setMaximumSize(new java.awt.Dimension(182, 41));
        optReserve.setMinimumSize(new java.awt.Dimension(182, 41));
        optReserve.setPreferredSize(new java.awt.Dimension(182, 41));
        optReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReserveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opsiKeServisLayout = new javax.swing.GroupLayout(opsiKeServis);
        opsiKeServis.setLayout(opsiKeServisLayout);
        opsiKeServisLayout.setHorizontalGroup(
            opsiKeServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opsiKeServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opsiKeServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optOrdery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optReserve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        opsiKeServisLayout.setVerticalGroup(
            opsiKeServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opsiKeServisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optOrdery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optReserve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optMenu.getAccessibleContext().setAccessibleName("Menu Option");
        optMenu.getAccessibleContext().setAccessibleDescription("Option of Menu");
        optOrdery.getAccessibleContext().setAccessibleName("Order Option");
        optOrdery.getAccessibleContext().setAccessibleDescription("Option of Order");
        optReserve.getAccessibleContext().setAccessibleName("Reserve Option");
        optReserve.getAccessibleContext().setAccessibleDescription("Option of Reserve");

        liatServis.setBackground(new java.awt.Color(255, 0, 0));
        liatServis.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        liatServis.setToolTipText("");
        liatServis.setMaximumSize(new java.awt.Dimension(565, 344));
        liatServis.setMinimumSize(new java.awt.Dimension(565, 344));
        liatServis.setName("ObservePane"); // NOI18N

        javax.swing.GroupLayout liatServisLayout = new javax.swing.GroupLayout(liatServis);
        liatServis.setLayout(liatServisLayout);
        liatServisLayout.setHorizontalGroup(
            liatServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        liatServisLayout.setVerticalGroup(
            liatServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bekgronServisLayout = new javax.swing.GroupLayout(bekgronServis);
        bekgronServis.setLayout(bekgronServisLayout);
        bekgronServisLayout.setHorizontalGroup(
            bekgronServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronServisLayout.createSequentialGroup()
                        .addComponent(judulServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kendaliServis, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                    .addGroup(bekgronServisLayout.createSequentialGroup()
                        .addComponent(opsiKeServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(liatServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bekgronServisLayout.setVerticalGroup(
            bekgronServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kendaliServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(judulServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opsiKeServis, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(liatServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        judulServis.getAccessibleContext().setAccessibleName("Title Sign");
        judulServis.getAccessibleContext().setAccessibleDescription("Name of Service");
        kendaliServis.getAccessibleContext().setAccessibleName("Controling Panel");
        kendaliServis.getAccessibleContext().setAccessibleDescription("Controller of Service");
        opsiKeServis.getAccessibleContext().setAccessibleName("Option Button");
        opsiKeServis.getAccessibleContext().setAccessibleDescription("Options of Service");
        liatServis.getAccessibleContext().setAccessibleName("Observe Panel");
        liatServis.getAccessibleContext().setAccessibleDescription("Observing of Service");

        skrolLanggan.setViewportView(bekgronServis);
        bekgronServis.getAccessibleContext().setAccessibleName("Main Layer Background");
        bekgronServis.getAccessibleContext().setAccessibleDescription("As Frame's Background");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(skrolLanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(skrolLanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Admin Dashboard");
        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        /* Menampilkan pesan */
        LoginPage closapp = new LoginPage();
        closapp.ClosingApp();
        /* Menampilkan pesan */
        
        /* Menutup jendela */
        this.dispose();
        /* Menutup jendela */
    }//GEN-LAST:event_formWindowClosing

    private boolean isLiatInVisible = true;    // Menyimpan status visibilitas
    private final boolean isOverviewVisible = false;
    //
    private void optMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optMenuActionPerformed
        CustomerMenuDisplay keMakanan = new CustomerMenuDisplay();
        liatServis.removeAll();     // Clear Frame ini
        //
        liatServis.add(keMakanan).setVisible(true);    // Menambahkan konten ke JPanel
    }//GEN-LAST:event_optMenuActionPerformed

    //

    private void optOrderyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOrderyActionPerformed
        CustomerOrderDisplay keMinuman = new CustomerOrderDisplay();
        liatServis.removeAll();     // Clear Frame ini
        //
        liatServis.add(keMinuman).setVisible(true);   // Menambahkan konten ke JPanel
    }//GEN-LAST:event_optOrderyActionPerformed

    //

    private void optReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReserveActionPerformed
        CustomerReserveDisplay keBarangan = new CustomerReserveDisplay();
        liatServis.removeAll();     // Clear Frame ini
        liatServis.add(keBarangan).setVisible(true);    // Menambahkan konten ke JPanel
    }//GEN-LAST:event_optReserveActionPerformed


    private void tubuTompolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tubuTompolActionPerformed
        dispose();          // Menutup jendela
        //
        LoginPage closapp = new LoginPage();
        //System.out.println("");
        System.out.println("==~== ==~== ==~==");    // Batasin
        closapp.ClosingApp();
        //
        System.exit(0);     // Menghentikan program
    }//GEN-LAST:event_tubuTompolActionPerformed


    private void tomboLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboLogOutActionPerformed
        System.out.println("==~== ==~== ==~==");    // Batasin
        System.out.println("Logging Out Costumer Dashboard...");
        System.out.println("==~== ==~== ==~==");    // Batasin
        //
        this.dispose();
        //
        LoginPage kePesanan = new LoginPage();
        kePesanan.setVisible(true);
    }//GEN-LAST:event_tomboLogOutActionPerformed

    private void optUnknownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optUnknownActionPerformed
        Customer__NNN__Display siarAn = new Customer__NNN__Display();
        liatServis.removeAll();
        liatServis.add(siarAn).setVisible(true);
    }//GEN-LAST:event_optUnknownActionPerformed
    //
    private void x3() {
        //
    }

    public void AppOp_Custom() {
        /* Rumusan File */
        //AdminDB_01_G13 bukapp = new AdminDB_01_G13();
        //bukapp.AppOp();
        /* Rumusan File */

        /* Sistem Pembukaan */
        String sistematik = "Customer Dashboard";
        //
        //System.out.println("");
        //System.out.println("==~== ==~== ==~==");  // Batasin
        System.out.print("Entering" + ": ");
        //
        try {
            // [2000 ms = 2 detik]
            Thread.sleep(750);
        } catch (InterruptedException e) {
            //System.out.println(penJudulan);
        }
        //
         //System.out.print("{ ");
        System.out.println(sistematik);  // Judulnya
         //System.out.println(" }");
        //System.out.println("==~== ==~== ==~==");  // Batasin
        /* Sistem Pembukaan */
    }

    //

    public static void main(String args[]) {
        /* Memastikan File mampu menjalankan program (membuka GUI) */
        //
        System.out.println("");
        System.out.println("==~== ==~== ==~==");  // Batasin
        //
        CustomerDashboardPage bukapp = new CustomerDashboardPage();
        bukapp.AppOp_Custom();
        /* Memastikan File mampu menjalankan program (membuka GUI) */
        
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CustomerDashboardPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bekgronServis;
    private javax.swing.JLabel judulAtas;
    private javax.swing.JLabel judulBawah;
    private javax.swing.JPanel judulServis;
    private javax.swing.JPanel kendaliServis;
    private javax.swing.JDesktopPane liatServis;
    private javax.swing.JPanel opsiKeServis;
    private javax.swing.JButton optMenu;
    private javax.swing.JButton optOrdery;
    private javax.swing.JButton optReserve;
    private javax.swing.JButton optUnknown;
    private javax.swing.JLabel pengGuna;
    private javax.swing.JScrollPane skrolLanggan;
    private javax.swing.JButton tomboLogOut;
    private javax.swing.JButton tubuTompol;
    private javax.swing.JLabel welKom;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
