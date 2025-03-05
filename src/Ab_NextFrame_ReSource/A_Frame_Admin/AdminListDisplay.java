/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.A_Frame_Admin;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
 //
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
// File Sistematik //

// Nyari File lain //
//import ;
 //
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class AdminListDisplay extends javax.swing.JInternalFrame {

    /* Set-Up Penyambungan */
    private Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    public AdminListDisplay() {
        initComponents();

        // Editing Header Table
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Telephone", "Noted"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tidak dapat diedit
            }
        };
        isiDataan.setModel(model); // isiDataan adalah JTable
        isiDataan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Memungkinkan pemilihan satu baris
        isiDataan.setAutoCreateRowSorter(true);
         //
        /* Atur lebar kolom */
        // ID
        isiDataan.getColumnModel().getColumn(0).setPreferredWidth(50);
        //
        // Name
        isiDataan.getColumnModel().getColumn(1).setPreferredWidth(200);
        //
        // Telpon
        isiDataan.getColumnModel().getColumn(2).setPreferredWidth(150);
        //
        // Catatan
        isiDataan.getColumnModel().getColumn(3).setPreferredWidth(350);
        //
        /* Atur lebar kolom */

        // Menambahkan MouseListener untuk menyalin data
        isiDataan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Menyalin saat double-click
                    int row = isiDataan.getSelectedRow();
                    int column = isiDataan.getSelectedColumn();
                    //
                    if (row != -1 && column != -1) {
                        String cellValue = isiDataan.getValueAt(row, column).toString();
                        StringSelection selection = new StringSelection(cellValue);
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(selection, null);
                    }
                }
            }
        });

        //

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch(SQLException ex) {
            System.out.println("Error" + ": " + ex.getMessage());
        }

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        liatkan.setNorthPane(null);
    }

        DefaultTableModel hapusMeja;
        DefaultTableModel hapusMeja01;
    //
    public void tambahData(String nama, String telp) {
        // Menambahkan data ke model tabel
        hapusMeja01.addRow(new Object[]{nama, telp});
    }
    //
    @SuppressWarnings("empty-statement")
    public void liatSiapAja() {
        /* Permulaan */
        DefaultTableModel keMeja = (DefaultTableModel)isiDataan.getModel();
        keMeja.setRowCount(0);

        String kolom01 = "id";
        String index01 = "0";
        //
         // [name] //
        String kolom02 = "name";
        String index02 = "Inmat";
         // [Inmat] //
        //
         // [telphone] //
        String kolom03 = "telphone";
        String index03 = "123498763690";
         // [123498763690] //
        //
        String kueri01 = "SELECT * FROM " +
                         "customer" + " WHERE " +     // Table
                         kolom01 + " != " + index01;  // Kolom dan Index-nya
        /* Permulaan */

        /* Sistematis */
        try {
            PreparedStatement siapStet = koneksi.prepareStatement(kueri01);
            ResultSet hasiRiset = siapStet.executeQuery();
            //DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Telephone"}, 0);
            //isiDataan.setModel(model); // isiDataan adalah JTable
            //
            while(hasiRiset.next()) {
                int aidi = hasiRiset.getInt("id");
                String nama = hasiRiset.getString("name");
                String telp = hasiRiset.getString("telphone");
                String note = hasiRiset.getString("notes");
                //
                keMeja.addRow(new Object[]{aidi, nama, telp, note});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    """
                    Database Error: 
                    """ + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        /* Sistematis */
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) isiDataan.getRowSorter();
        if (sorter != null) {
            sorter.setRowFilter(null);
        }
        enterCari.setText(""); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronTabel = new javax.swing.JPanel();
        lookaTon = new javax.swing.JButton();
        addTon = new javax.swing.JButton();
        upDateTon = new javax.swing.JButton();
        deleTon = new javax.swing.JButton();
        sigName = new javax.swing.JLabel();
        enterName = new javax.swing.JTextField();
        sigNumb = new javax.swing.JLabel();
        enterNumb = new javax.swing.JTextField();
        sigNid = new javax.swing.JLabel();
        enterNid = new javax.swing.JTextField();
        cariTon = new javax.swing.JButton();
        enterCari = new javax.swing.JTextField();
        skrolTabel = new javax.swing.JScrollPane();
        isiDataan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setVisible(true);

        bekgronTabel.setBackground(new java.awt.Color(123, 139, 142));
        bekgronTabel.setToolTipText("");

        lookaTon.setBackground(new java.awt.Color(102, 102, 102));
        lookaTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        lookaTon.setForeground(new java.awt.Color(204, 204, 204));
        lookaTon.setText("Refresh");
        lookaTon.setToolTipText("");
        lookaTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lookaTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lookaTon.setMaximumSize(new java.awt.Dimension(100, 30));
        lookaTon.setMinimumSize(new java.awt.Dimension(100, 30));
        lookaTon.setPreferredSize(new java.awt.Dimension(100, 30));
        lookaTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookaTonActionPerformed(evt);
            }
        });

        addTon.setBackground(new java.awt.Color(102, 102, 102));
        addTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        addTon.setForeground(new java.awt.Color(204, 204, 204));
        addTon.setText("Adding");
        addTon.setToolTipText("");
        addTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addTon.setMaximumSize(new java.awt.Dimension(100, 30));
        addTon.setMinimumSize(new java.awt.Dimension(100, 30));
        addTon.setPreferredSize(new java.awt.Dimension(100, 30));
        addTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTonActionPerformed(evt);
            }
        });

        upDateTon.setBackground(new java.awt.Color(102, 102, 102));
        upDateTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        upDateTon.setForeground(new java.awt.Color(204, 204, 204));
        upDateTon.setText("Edit");
        upDateTon.setToolTipText("Fix Button");
        upDateTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        upDateTon.setMaximumSize(new java.awt.Dimension(100, 30));
        upDateTon.setMinimumSize(new java.awt.Dimension(100, 30));
        upDateTon.setPreferredSize(new java.awt.Dimension(100, 30));
        upDateTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upDateTonActionPerformed(evt);
            }
        });

        deleTon.setBackground(new java.awt.Color(102, 102, 102));
        deleTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        deleTon.setForeground(new java.awt.Color(204, 204, 204));
        deleTon.setText("Remove");
        deleTon.setToolTipText("Delete Button");
        deleTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deleTon.setMaximumSize(new java.awt.Dimension(100, 30));
        deleTon.setMinimumSize(new java.awt.Dimension(100, 30));
        deleTon.setPreferredSize(new java.awt.Dimension(100, 30));
        deleTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleTonActionPerformed(evt);
            }
        });

        sigName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigName.setText("Name");
        sigName.setToolTipText("");
        sigName.setMaximumSize(new java.awt.Dimension(80, 20));
        sigName.setMinimumSize(new java.awt.Dimension(80, 30));
        sigName.setPreferredSize(new java.awt.Dimension(80, 30));

        enterName.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterName.setToolTipText("");
        enterName.setMaximumSize(new java.awt.Dimension(150, 30));
        enterName.setMinimumSize(new java.awt.Dimension(150, 30));
        enterName.setPreferredSize(new java.awt.Dimension(150, 30));
        enterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNameActionPerformed(evt);
            }
        });

        sigNumb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigNumb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigNumb.setText("Telp");
        sigNumb.setToolTipText("");
        sigNumb.setMaximumSize(new java.awt.Dimension(80, 30));
        sigNumb.setMinimumSize(new java.awt.Dimension(80, 30));
        sigNumb.setPreferredSize(new java.awt.Dimension(80, 30));

        enterNumb.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterNumb.setToolTipText("");
        enterNumb.setMaximumSize(new java.awt.Dimension(150, 30));
        enterNumb.setMinimumSize(new java.awt.Dimension(150, 30));
        enterNumb.setPreferredSize(new java.awt.Dimension(150, 30));
        enterNumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNumbActionPerformed(evt);
            }
        });

        sigNid.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigNid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigNid.setText("ID");
        sigNid.setToolTipText("");
        sigNid.setMaximumSize(new java.awt.Dimension(100, 30));
        sigNid.setMinimumSize(new java.awt.Dimension(100, 30));
        sigNid.setPreferredSize(new java.awt.Dimension(100, 30));

        enterNid.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterNid.setToolTipText("");
        enterNid.setMaximumSize(new java.awt.Dimension(100, 30));
        enterNid.setMinimumSize(new java.awt.Dimension(100, 30));
        enterNid.setPreferredSize(new java.awt.Dimension(100, 30));
        enterNid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNidActionPerformed(evt);
            }
        });

        cariTon.setBackground(new java.awt.Color(102, 102, 102));
        cariTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        cariTon.setForeground(new java.awt.Color(204, 204, 204));
        cariTon.setText("Search");
        cariTon.setToolTipText("");
        cariTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cariTon.setMaximumSize(new java.awt.Dimension(210, 30));
        cariTon.setMinimumSize(new java.awt.Dimension(210, 30));
        cariTon.setPreferredSize(new java.awt.Dimension(210, 30));
        cariTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTonActionPerformed(evt);
            }
        });

        enterCari.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterCari.setToolTipText("");
        enterCari.setMaximumSize(new java.awt.Dimension(340, 30));
        enterCari.setMinimumSize(new java.awt.Dimension(340, 30));
        enterCari.setPreferredSize(new java.awt.Dimension(340, 30));
        enterCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCariActionPerformed(evt);
            }
        });

        skrolTabel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolTabel.setToolTipText("");
        skrolTabel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolTabel.setMaximumSize(new java.awt.Dimension(570, 260));
        skrolTabel.setMinimumSize(new java.awt.Dimension(570, 260));
        skrolTabel.setPreferredSize(new java.awt.Dimension(570, 260));

        isiDataan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        isiDataan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Telephone", "Noted"
            }
        ));
        isiDataan.setToolTipText("");
        isiDataan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        isiDataan.setMaximumSize(new java.awt.Dimension(570, 1500));
        isiDataan.setMinimumSize(new java.awt.Dimension(570, 1500));
        isiDataan.setPreferredSize(new java.awt.Dimension(570, 1500));
        skrolTabel.setViewportView(isiDataan);
        isiDataan.getAccessibleContext().setAccessibleName("Users List");
        isiDataan.getAccessibleContext().setAccessibleDescription("Main User List in Table");

        javax.swing.GroupLayout bekgronTabelLayout = new javax.swing.GroupLayout(bekgronTabel);
        bekgronTabel.setLayout(bekgronTabelLayout);
        bekgronTabelLayout.setHorizontalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(skrolTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bekgronTabelLayout.createSequentialGroup()
                            .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bekgronTabelLayout.createSequentialGroup()
                            .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(bekgronTabelLayout.createSequentialGroup()
                                    .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(sigName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sigNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(bekgronTabelLayout.createSequentialGroup()
                                    .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(sigNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enterNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enterNid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        bekgronTabelLayout.setVerticalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sigNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skrolTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        lookaTon.getAccessibleContext().setAccessibleName("View Listed");
        lookaTon.getAccessibleContext().setAccessibleDescription("See the List");
        addTon.getAccessibleContext().setAccessibleName("Add Listed");
        addTon.getAccessibleContext().setAccessibleDescription("Add the List");
        upDateTon.getAccessibleContext().setAccessibleName("Update Listed");
        upDateTon.getAccessibleContext().setAccessibleDescription("Fix the List");
        deleTon.getAccessibleContext().setAccessibleName("Remove Listed");
        deleTon.getAccessibleContext().setAccessibleDescription("Delete the List");
        sigName.getAccessibleContext().setAccessibleName("Name Sign");
        sigName.getAccessibleContext().setAccessibleDescription("Sign: Name");
        enterName.getAccessibleContext().setAccessibleName("Type Name");
        enterName.getAccessibleContext().setAccessibleDescription("Write the Name");
        enterName.getAccessibleContext().setAccessibleParent(sigName);
        sigNumb.getAccessibleContext().setAccessibleName("Telephone Sign");
        enterNumb.getAccessibleContext().setAccessibleName("Type Number");
        enterNumb.getAccessibleContext().setAccessibleDescription("Write the Number");
        enterNumb.getAccessibleContext().setAccessibleParent(sigNumb);
        sigNid.getAccessibleContext().setAccessibleName("ID Sign");
        sigNid.getAccessibleContext().setAccessibleDescription("Sign: ID");
        enterNid.getAccessibleContext().setAccessibleName("Type ID");
        enterNid.getAccessibleContext().setAccessibleDescription("Write the ID");
        enterNid.getAccessibleContext().setAccessibleParent(sigNid);
        skrolTabel.getAccessibleContext().setAccessibleName("Table Panel Scroll");
        skrolTabel.getAccessibleContext().setAccessibleDescription("Panel with Scroller");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookaTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookaTonActionPerformed
        liatSiapAja();
    }//GEN-LAST:event_lookaTonActionPerformed

    public void addSiapAja() {
        /* Penyaringan */
        String nameAdd = enterName.getText();
        String numbAdd = enterNumb.getText();
        /* Penyaringan */

        /* Sistem */
        if (enterName.getText().equals("") || enterNumb.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Fill 'em all!",
                    "Unfilled",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika ada field yang kosong
        }

        String numb = "";
        //
        if (!numbAdd.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null,
                    "Telephone must be 12 number digits, and no Spaces",
                    "Non-Number Typed",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika input tidak valid
        }

        try {
            String query = "INSERT INTO " +
                           "customer" + " (" +
                           "name" + ", " +
                           "telphone" + ") " +
                           "VALUES"+ " (?, ?)";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setString(1, nameAdd);
            stmt.setString(2, numbAdd);
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Added!");
            liatSiapAja();  // Refresh tabel setelah menambahkan products
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    """
                    Database Error: 
                    """ + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        /* Sistem */
    }

    private void addTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTonActionPerformed
        addSiapAja();
    }//GEN-LAST:event_addTonActionPerformed

    public void perBaikAn() {
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Choose who you wanna to update!",
                    "Unchoosen Table",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID dari 'teks kotak ID'
        String aidie = enterNid.getText();
        int lamaId = (int) isiDataan.getValueAt(selectedRow, 0);
        int baruId = lamaId; // Gunakan ID lama sebagai default jika field kosong

        // Validasi ID
        if (!enterNid.getText().trim().isEmpty()) {
            try {
                baruId = Integer.parseInt(enterNid.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "New ID must be a number!",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        String aidi = enterNid.getText();
        String name = enterName.getText();
        String numb = enterNumb.getText();
        
        // Validasi input
        if (name.isEmpty() || numb.isEmpty()) {
            //aidi.isEmpty() ||
            JOptionPane.showMessageDialog(null,
                    "Fill 'em all!",
                    "Unfilled",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika ada field yang kosong
        }

        if (!numb.matches("\\d{12}") && !aidie.matches("\\d")) {
            JOptionPane.showMessageDialog(null,
                    "Telephone must be 12 number digits",
                    "Under digit Phone Number",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika input tidak valid
        }

        // Ambil ID lama dari tabel
        int oldId = (int) isiDataan.getValueAt(selectedRow, 0);

        try {            
            String query = "UPDATE " +
                           "customer" + " SET " +
                           "name" + " = ?, " +
                           "telphone" + " = ?, " +
                           "id" + " = ? WHERE " +
                           "id = ?";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setString(1, name); // Set nama
            stmt.setString(2, numb); // Set nomor telepon
            stmt.setInt(3, baruId); // Set ID baru
            stmt.setInt(4, oldId); // ID lama untuk kondisi WHERE
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Update the Customer!");
            liatSiapAja();  // Refresh tabel setelah mengedit products
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    """
                    Database Error: 
                    """ + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void upDateTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upDateTonActionPerformed
        perBaikAn();
    }//GEN-LAST:event_upDateTonActionPerformed

    public void delSiapAja() {
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Choose who you wanna delete!",
                    "Unchoosen Table",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) isiDataan.getValueAt(selectedRow, 0);

        try {
            String query = "DELETE FROM " +
                           "customer" + " WHERE " +
                           "id" + " = ?";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setInt(1, id);
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Deleting the Costumer!");
            liatSiapAja();  // Refresh tabel setelah menghapus products
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    """
                    Database Error: 
                    """ + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleTonActionPerformed
        delSiapAja();
    }//GEN-LAST:event_deleTonActionPerformed

    private void enterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterNameActionPerformed

    private void enterNumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterNumbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterNumbActionPerformed

    private void enterNidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterNidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterNidActionPerformed

    private void cariTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTonActionPerformed
        cariData();
    }//GEN-LAST:event_cariTonActionPerformed
    //
    public void cariData() {
        String searchTerm = enterCari.getText().toLowerCase(); // Ambil input dari TextField
        DefaultTableModel model = (DefaultTableModel) isiDataan.getModel();

        // Gunakan sorter yang sudah ada atau buat baru
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) isiDataan.getRowSorter();
        if (sorter == null) {
            sorter = new TableRowSorter<>(model);
            isiDataan.setRowSorter(sorter);
        }

        // Filter berdasarkan input
        if (!searchTerm.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // (?i) = ignore case
        } else {
            sorter.setRowFilter(null); // Reset filter jika kosong
        }
    }

    private void enterCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTon;
    private javax.swing.JPanel bekgronTabel;
    private javax.swing.JButton cariTon;
    private javax.swing.JButton deleTon;
    private javax.swing.JTextField enterCari;
    private javax.swing.JTextField enterName;
    private javax.swing.JTextField enterNid;
    private javax.swing.JTextField enterNumb;
    private javax.swing.JTable isiDataan;
    private javax.swing.JButton lookaTon;
    private javax.swing.JLabel sigName;
    private javax.swing.JLabel sigNid;
    private javax.swing.JLabel sigNumb;
    private javax.swing.JScrollPane skrolTabel;
    private javax.swing.JButton upDateTon;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
