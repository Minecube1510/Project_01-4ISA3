/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.A_Frame_Admin;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
 //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
// File Sistematik //

// Nyari File lain //
//import ;
 //
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class AdminOverviewDisplay extends javax.swing.JInternalFrame {

    /* Set-Up Penyambungan */
    Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    public AdminOverviewDisplay() {
        initComponents();

        //

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch(SQLException ex) {
            System.out.println("Error" + ": " + ex.getMessage());
        }

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        liatkan.setNorthPane(null);
        
        //
    }

    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
    }
    //

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronIntro = new javax.swing.JPanel();
        titleProjek = new javax.swing.JLabel();
        titleProjek1 = new javax.swing.JLabel();
        titleProjek2 = new javax.swing.JLabel();
        titleProjek3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setVisible(true);

        bekgronIntro.setBackground(new java.awt.Color(51, 153, 0));
        bekgronIntro.setToolTipText("Sub-Panel Background");

        titleProjek.setFont(new java.awt.Font("Planeptune HDD", 3, 40)); // NOI18N
        titleProjek.setForeground(new java.awt.Color(102, 0, 102));
        titleProjek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleProjek.setText("Project 01");
        titleProjek.setMaximumSize(new java.awt.Dimension(450, 75));
        titleProjek.setMinimumSize(new java.awt.Dimension(450, 75));
        titleProjek.setPreferredSize(new java.awt.Dimension(450, 75));

        titleProjek1.setFont(new java.awt.Font("Minecraft", 3, 40)); // NOI18N
        titleProjek1.setForeground(new java.awt.Color(153, 0, 0));
        titleProjek1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleProjek1.setText("Group 13");
        titleProjek1.setMaximumSize(new java.awt.Dimension(575, 75));
        titleProjek1.setMinimumSize(new java.awt.Dimension(575, 75));
        titleProjek1.setPreferredSize(new java.awt.Dimension(575, 75));

        titleProjek2.setFont(new java.awt.Font("Imprint MT Shadow", 3, 40)); // NOI18N
        titleProjek2.setForeground(new java.awt.Color(0, 0, 102));
        titleProjek2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleProjek2.setText("By: Aditya Rahman");
        titleProjek2.setMaximumSize(new java.awt.Dimension(575, 50));
        titleProjek2.setMinimumSize(new java.awt.Dimension(575, 50));
        titleProjek2.setPreferredSize(new java.awt.Dimension(575, 50));

        titleProjek3.setFont(new java.awt.Font("Imprint MT Shadow", 3, 40)); // NOI18N
        titleProjek3.setForeground(new java.awt.Color(0, 0, 102));
        titleProjek3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleProjek3.setText("4ISA3");
        titleProjek3.setMaximumSize(new java.awt.Dimension(575, 50));
        titleProjek3.setMinimumSize(new java.awt.Dimension(575, 50));
        titleProjek3.setPreferredSize(new java.awt.Dimension(575, 50));

        javax.swing.GroupLayout bekgronIntroLayout = new javax.swing.GroupLayout(bekgronIntro);
        bekgronIntro.setLayout(bekgronIntroLayout);
        bekgronIntroLayout.setHorizontalGroup(
            bekgronIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronIntroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleProjek1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleProjek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleProjek2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(titleProjek3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                .addContainerGap())
        );
        bekgronIntroLayout.setVerticalGroup(
            bekgronIntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronIntroLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(titleProjek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleProjek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(titleProjek2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleProjek3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronIntro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronIntro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bekgronIntro;
    private javax.swing.JLabel titleProjek;
    private javax.swing.JLabel titleProjek1;
    private javax.swing.JLabel titleProjek2;
    private javax.swing.JLabel titleProjek3;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
