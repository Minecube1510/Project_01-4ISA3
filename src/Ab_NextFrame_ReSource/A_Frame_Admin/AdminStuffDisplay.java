/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.A_Frame_Admin;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import ;
//import javax.swing.JTable;
//import ;
//import java.awt.Dimension;
 //
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
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
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
// File Sistematik //

// Nyari File lain //
//import ;
 //
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class AdminStuffDisplay extends javax.swing.JInternalFrame {
    /* Set-Up Penyambungan */
    private Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    private TableRowSorter<DefaultTableModel> sorter;

    public AdminStuffDisplay() {
        initComponents();

        try {
            koneksi = DriverManager.getConnection(url, user, pass);
            isiKombo(); // Panggil setelah koneksi berhasil
        } catch(SQLException ex) {
            // Penanganan error
        }

        // Editing Header Table
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "Name", "Description", "Category", "Price"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tidak dapat diedit
            }
        };
        isiDataan.setModel(model); // isiDataan adalah JTable
        isiDataan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Memungkinkan pemilihan satu baris
         //
        /* Atur lebar kolom */
        // ID
        isiDataan.getColumnModel().getColumn(0).setPreferredWidth(50);
        //
        // Name
        isiDataan.getColumnModel().getColumn(1).setPreferredWidth(350);
        //
        // Desc
        isiDataan.getColumnModel().getColumn(2).setPreferredWidth(450);
        //
        // Category
        isiDataan.getColumnModel().getColumn(3).setPreferredWidth(150);
        //
        // Price
        isiDataan.getColumnModel().getColumn(4).setPreferredWidth(150);
        //
        /* Atur lebar kolom */
        //
        sorter = new TableRowSorter<>((DefaultTableModel) isiDataan.getModel());
        isiDataan.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2, 3, 4)); // Sesuaikan dengan jumlah kolom

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
        
        //
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
    public void liatEnak() {
        /* Permulaan */
        DefaultTableModel keMeja = (DefaultTableModel)isiDataan.getModel();
        keMeja.setRowCount(0);
        String kueri01 = "SELECT * FROM " +
                         "product";  // Kolom dan Index-nya
        /* Permulaan */

        /* Sistematis */
        try {
            PreparedStatement siapStet = koneksi.prepareStatement(kueri01);
            ResultSet hasiRiset = siapStet.executeQuery();
            //
            int rowCount = 0; // Menyimpan jumlah baris

            while(hasiRiset.next()) {
                int aidi = hasiRiset.getInt("id");
                String barang = hasiRiset.getString("pro_name");
                String deskrip = hasiRiset.getString("pro_desc");
                String ketgo = hasiRiset.getString("category");
                int harga = hasiRiset.getInt("price");
                //
                keMeja.addRow(new Object[]{aidi, barang, deskrip, ketgo, harga});
                rowCount++; // Increment jumlah baris
            }

            // Mengatur ukuran scroll bar berdasarkan jumlah baris
            //int preferredHeight = Math.min(rowCount * isiDataan.getRowHeight(), 250);  // Maksimal 250 piksel
            //skrolTabel.setPreferredSize(new Dimension(570, preferredHeight));
            //
            //skrolTabel.revalidate(); // Memperbarui tampilan
            //skrolTabel.repaint(); // Menggambar ulang komponen

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        /* Sistematis */
        sorter.setRowFilter(null); // Reset filter
        enterCari.setText(""); // Bersihkan field pencarian
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronTabel = new javax.swing.JPanel();
        lookaTon = new javax.swing.JButton();
        addTon = new javax.swing.JButton();
        upDateTon = new javax.swing.JButton();
        deleTon = new javax.swing.JButton();
        sigproName = new javax.swing.JLabel();
        enterProname = new javax.swing.JTextField();
        enterDescs = new javax.swing.JTextField();
        sigAidi = new javax.swing.JLabel();
        enterAidi = new javax.swing.JTextField();
        stockNumb = new javax.swing.JLabel();
        enterStockn = new javax.swing.JTextField();
        priceNumb = new javax.swing.JLabel();
        enterPricen = new javax.swing.JTextField();
        sigCateg = new javax.swing.JLabel();
        milihKetgor = new javax.swing.JComboBox<>();
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
        lookaTon.setMaximumSize(new java.awt.Dimension(135, 30));
        lookaTon.setMinimumSize(new java.awt.Dimension(135, 30));
        lookaTon.setPreferredSize(new java.awt.Dimension(135, 30));
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
        addTon.setMaximumSize(new java.awt.Dimension(135, 30));
        addTon.setMinimumSize(new java.awt.Dimension(135, 30));
        addTon.setPreferredSize(new java.awt.Dimension(135, 30));
        addTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTonActionPerformed(evt);
            }
        });

        upDateTon.setBackground(new java.awt.Color(102, 102, 102));
        upDateTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        upDateTon.setForeground(new java.awt.Color(204, 204, 204));
        upDateTon.setText("Update");
        upDateTon.setToolTipText("");
        upDateTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        upDateTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upDateTon.setMaximumSize(new java.awt.Dimension(135, 30));
        upDateTon.setMinimumSize(new java.awt.Dimension(135, 30));
        upDateTon.setPreferredSize(new java.awt.Dimension(135, 30));
        upDateTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upDateTonActionPerformed(evt);
            }
        });

        deleTon.setBackground(new java.awt.Color(102, 102, 102));
        deleTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        deleTon.setForeground(new java.awt.Color(204, 204, 204));
        deleTon.setText("Remove");
        deleTon.setToolTipText("");
        deleTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deleTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleTon.setMaximumSize(new java.awt.Dimension(135, 30));
        deleTon.setMinimumSize(new java.awt.Dimension(135, 30));
        deleTon.setPreferredSize(new java.awt.Dimension(135, 30));
        deleTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleTonActionPerformed(evt);
            }
        });

        sigproName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigproName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigproName.setText("Name");
        sigproName.setToolTipText("");
        sigproName.setMaximumSize(new java.awt.Dimension(80, 20));
        sigproName.setMinimumSize(new java.awt.Dimension(80, 30));
        sigproName.setPreferredSize(new java.awt.Dimension(80, 30));

        enterProname.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterProname.setToolTipText("");
        enterProname.setMaximumSize(new java.awt.Dimension(180, 30));
        enterProname.setMinimumSize(new java.awt.Dimension(180, 30));
        enterProname.setPreferredSize(new java.awt.Dimension(180, 30));
        enterProname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPronameActionPerformed(evt);
            }
        });

        enterDescs.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterDescs.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        enterDescs.setToolTipText("");
        enterDescs.setMargin(new java.awt.Insets(-42, 0, 2, 2));
        enterDescs.setMaximumSize(new java.awt.Dimension(180, 70));
        enterDescs.setMinimumSize(new java.awt.Dimension(180, 70));
        enterDescs.setPreferredSize(new java.awt.Dimension(180, 70));
        enterDescs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterDescsActionPerformed(evt);
            }
        });

        sigAidi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigAidi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigAidi.setText("ID");
        sigAidi.setToolTipText("");
        sigAidi.setMaximumSize(new java.awt.Dimension(80, 20));
        sigAidi.setMinimumSize(new java.awt.Dimension(80, 30));
        sigAidi.setPreferredSize(new java.awt.Dimension(80, 30));

        enterAidi.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterAidi.setToolTipText("");
        enterAidi.setMaximumSize(new java.awt.Dimension(180, 30));
        enterAidi.setMinimumSize(new java.awt.Dimension(180, 30));
        enterAidi.setPreferredSize(new java.awt.Dimension(180, 30));
        enterAidi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterAidiActionPerformed(evt);
            }
        });

        stockNumb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        stockNumb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockNumb.setText("Stock");
        stockNumb.setToolTipText("");
        stockNumb.setMaximumSize(new java.awt.Dimension(60, 30));
        stockNumb.setMinimumSize(new java.awt.Dimension(60, 30));
        stockNumb.setPreferredSize(new java.awt.Dimension(60, 30));

        enterStockn.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterStockn.setToolTipText("");
        enterStockn.setMaximumSize(new java.awt.Dimension(60, 30));
        enterStockn.setMinimumSize(new java.awt.Dimension(60, 30));
        enterStockn.setPreferredSize(new java.awt.Dimension(60, 30));
        enterStockn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterStocknActionPerformed(evt);
            }
        });

        priceNumb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        priceNumb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceNumb.setText("Price");
        priceNumb.setToolTipText("");
        priceNumb.setMaximumSize(new java.awt.Dimension(60, 30));
        priceNumb.setMinimumSize(new java.awt.Dimension(60, 30));
        priceNumb.setPreferredSize(new java.awt.Dimension(60, 30));

        enterPricen.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterPricen.setToolTipText("");
        enterPricen.setMaximumSize(new java.awt.Dimension(60, 30));
        enterPricen.setMinimumSize(new java.awt.Dimension(60, 30));
        enterPricen.setPreferredSize(new java.awt.Dimension(60, 30));
        enterPricen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPricenActionPerformed(evt);
            }
        });

        sigCateg.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigCateg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigCateg.setText("Category");
        sigCateg.setToolTipText("");
        sigCateg.setMaximumSize(new java.awt.Dimension(135, 30));
        sigCateg.setMinimumSize(new java.awt.Dimension(135, 30));
        sigCateg.setPreferredSize(new java.awt.Dimension(135, 30));

        milihKetgor.setToolTipText("");

        cariTon.setBackground(new java.awt.Color(102, 102, 102));
        cariTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        cariTon.setForeground(new java.awt.Color(204, 204, 204));
        cariTon.setText("Search");
        cariTon.setToolTipText("");
        cariTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cariTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariTon.setMaximumSize(new java.awt.Dimension(135, 30));
        cariTon.setMinimumSize(new java.awt.Dimension(135, 30));
        cariTon.setPreferredSize(new java.awt.Dimension(135, 30));
        cariTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTonActionPerformed(evt);
            }
        });

        enterCari.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterCari.setToolTipText("");
        enterCari.setMaximumSize(new java.awt.Dimension(60, 30));
        enterCari.setMinimumSize(new java.awt.Dimension(60, 30));
        enterCari.setPreferredSize(new java.awt.Dimension(60, 30));
        enterCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCariActionPerformed(evt);
            }
        });

        skrolTabel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        skrolTabel.setToolTipText("");
        skrolTabel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        skrolTabel.setAutoscrolls(true);
        skrolTabel.setMaximumSize(new java.awt.Dimension(570, 190));
        skrolTabel.setMinimumSize(new java.awt.Dimension(570, 190));
        skrolTabel.setPreferredSize(new java.awt.Dimension(570, 190));

        isiDataan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        isiDataan.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Desc", "Category", "Stock", "Price"
            }
        ));
        isiDataan.setToolTipText("");
        isiDataan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        isiDataan.setMaximumSize(new java.awt.Dimension(700, 1500));
        isiDataan.setMinimumSize(new java.awt.Dimension(700, 1500));
        isiDataan.setPreferredSize(new java.awt.Dimension(700, 1500));
        skrolTabel.setViewportView(isiDataan);
        isiDataan.getAccessibleContext().setAccessibleName("Products List");
        isiDataan.getAccessibleContext().setAccessibleDescription("Main Products List in Table");

        javax.swing.GroupLayout bekgronTabelLayout = new javax.swing.GroupLayout(bekgronTabel);
        bekgronTabel.setLayout(bekgronTabelLayout);
        bekgronTabelLayout.setHorizontalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bekgronTabelLayout.createSequentialGroup()
                                .addComponent(sigproName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enterProname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bekgronTabelLayout.createSequentialGroup()
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterAidi, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(sigAidi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enterDescs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterStockn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockNumb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sigCateg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceNumb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterPricen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(milihKetgor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(skrolTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        bekgronTabelLayout.setVerticalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sigproName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterProname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(enterStockn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterPricen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sigCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(milihKetgor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(sigAidi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterAidi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterDescs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skrolTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        lookaTon.getAccessibleContext().setAccessibleName("View Listed");
        lookaTon.getAccessibleContext().setAccessibleDescription("See the List");
        addTon.getAccessibleContext().setAccessibleName("Add Listed");
        addTon.getAccessibleContext().setAccessibleDescription("Add the List");
        upDateTon.getAccessibleContext().setAccessibleName("Update Listed");
        upDateTon.getAccessibleContext().setAccessibleDescription("Fix the List");
        deleTon.getAccessibleContext().setAccessibleName("Remove Listed");
        deleTon.getAccessibleContext().setAccessibleDescription("Delete the List");
        sigproName.getAccessibleContext().setAccessibleName("Name Sign");
        sigproName.getAccessibleContext().setAccessibleDescription("Sign: Name");
        enterProname.getAccessibleContext().setAccessibleName("Name Field");
        enterProname.getAccessibleContext().setAccessibleDescription("Type the Name");
        enterProname.getAccessibleContext().setAccessibleParent(sigproName);
        enterDescs.getAccessibleContext().setAccessibleName("Description Field");
        enterDescs.getAccessibleContext().setAccessibleDescription("Type the Description");
        enterDescs.getAccessibleContext().setAccessibleParent(enterProname);
        sigAidi.getAccessibleContext().setAccessibleName("ID Sign");
        sigAidi.getAccessibleContext().setAccessibleDescription("Sign: ID");
        enterAidi.getAccessibleContext().setAccessibleName("ID Field");
        enterAidi.getAccessibleContext().setAccessibleDescription("Type the ID");
        enterAidi.getAccessibleContext().setAccessibleParent(sigAidi);
        stockNumb.getAccessibleContext().setAccessibleName("Stock Sign");
        stockNumb.getAccessibleContext().setAccessibleDescription("Sign: Stock");
        enterStockn.getAccessibleContext().setAccessibleName("Stock Field");
        enterStockn.getAccessibleContext().setAccessibleDescription("Type the Stock");
        enterStockn.getAccessibleContext().setAccessibleParent(stockNumb);
        priceNumb.getAccessibleContext().setAccessibleName("Price Sign");
        priceNumb.getAccessibleContext().setAccessibleDescription("Sign: Price");
        enterPricen.getAccessibleContext().setAccessibleName("Price Field");
        enterPricen.getAccessibleContext().setAccessibleDescription("Type the Price");
        enterPricen.getAccessibleContext().setAccessibleParent(priceNumb);
        sigCateg.getAccessibleContext().setAccessibleName("Category Sign");
        sigCateg.getAccessibleContext().setAccessibleDescription("Sign: Category");
        milihKetgor.getAccessibleContext().setAccessibleName("Category Option");
        milihKetgor.getAccessibleContext().setAccessibleDescription("Choosing the Category");
        milihKetgor.getAccessibleContext().setAccessibleParent(sigCateg);
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
        liatEnak();
    }//GEN-LAST:event_lookaTonActionPerformed

    public void addEnak() {
        /* Penyaringan */
        String naMenu = enterProname.getText();
        String tulisk = enterDescs.getText();
        //
        String katgor = (String) milihKetgor.getSelectedItem();
        //
        long hrgbrp;
        /* Penyaringan */

        /* Sistem */
        if (enterProname.getText().equals("") || //enterDescs.getText().equals("") ||
            enterStockn.getText().equals("") || enterPricen.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Fill it!",
                    "Unfilled",
                    JOptionPane.INFORMATION_MESSAGE);
            return; // Keluar dari metode jika ada field yang kosong
        }

        try {
            hrgbrp = Integer.parseInt(enterPricen.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Stock and Price must be number!",
                    "Non Numeric State",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "INSERT INTO " +
                           "product" + " (" +
                           "pro_name" + ", " +
                           "pro_desc" + ", " +
                           "category" + ", " +
                           "price" + ") " +
                           "VALUES"+ " (?, ?, ?, ?)";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setString(1, naMenu);
            stmt.setString(2, tulisk);
            stmt.setString(3, katgor);
            stmt.setLong(4, hrgbrp);
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Added!");
            liatEnak();  // Refresh tabel setelah menambahkan products
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        /* Sistem */
    }

    private void addTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTonActionPerformed
        addEnak();
    }//GEN-LAST:event_addTonActionPerformed

    public void perBaikAn() {
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Choose who you wanna to update!",
                    "Unchoosen Table",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //  Set up
        String barangan = enterProname.getText();
        String deskrips = enterDescs.getText();

        // Ambil ID dari tabel (kolom 0)
        int lamaId = (int) isiDataan.getValueAt(selectedRow, 0);
        int baruId = lamaId; // Default ke ID lama jika tidak diisi

        // Must be filled
        if (barangan.isEmpty() || enterStockn.getText().trim().isEmpty() ||
            enterPricen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Fill it!",
                    "Unfilled",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Validasi input
        if (!enterAidi.getText().trim().isEmpty()) {
            try {
                baruId = Integer.parseInt(enterAidi.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "New ID must be a number!",
                        "Invalid Input",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        try {
            long aturkaya = Long.parseLong(enterPricen.getText().trim());

            // Perbaikan query: gunakan kolom yang benar (id)
            String kueri = "UPDATE " +
                           "product" + " SET " +
                           "id" + " = ?, " +
                           "pro_name" + " = ?, " +
                           "pro_desc" + " = ?, " +
                           "category" + " = ?, " +
                           "price" + " = ? " + "WHERE " +
                           "id" + " = ?";

            PreparedStatement stmt = koneksi.prepareStatement(kueri);
            //
            stmt.setInt(1, baruId);
            stmt.setString(2, enterProname.getText().trim());
            stmt.setString(3, enterDescs.getText().trim());
            stmt.setString(4, (String) milihKetgor.getSelectedItem());
            stmt.setLong(5, aturkaya);
            stmt.setInt(6, lamaId);  // ID dari tabel, bukan text field
            //
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updating the Stuff!");
            liatEnak();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Stock and Price isn't right...",
                    "Invalid Input",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void upDateTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upDateTonActionPerformed
        perBaikAn();
    }//GEN-LAST:event_upDateTonActionPerformed

    public void delEnak() {
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
                           "product" + " WHERE " +
                           "id" + " = ?";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setInt(1, id);
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Deleting the Costumer!");
            liatEnak();  // Refresh tabel setelah menghapus products
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleTonActionPerformed
        delEnak();
    }//GEN-LAST:event_deleTonActionPerformed

    private void enterPronameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPronameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterPronameActionPerformed

    private void enterStocknActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterStocknActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterStocknActionPerformed

    private void enterPricenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPricenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterPricenActionPerformed

    private void enterDescsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterDescsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterDescsActionPerformed

    private void enterAidiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterAidiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterAidiActionPerformed

    private void cariTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTonActionPerformed
        cariData();
    }//GEN-LAST:event_cariTonActionPerformed
    //
    private void cariData() {
        String searchTerm = enterCari.getText().trim();
        
        if (searchTerm.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            // Case-insensitive + partial match di semua kolom
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm));
        }
    }

    private void enterCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterCariActionPerformed

    private void isiKombo() {
        try {
            String kueri = "SELECT " +
                           "category" + " FROM " +
                           "product;";
            //
            PreparedStatement siapStet = koneksi.prepareStatement(kueri);
            ResultSet hasiRiset = siapStet.executeQuery();
            //
            Set<String> ketgorSet = new HashSet<>();
            while (hasiRiset.next()) {
                String ketgor = hasiRiset.getString("category");
                ketgorSet.add(ketgor);
            }
            for (String ketgor : ketgorSet) {
                milihKetgor.addItem(ketgor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error" + ": " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTon;
    private javax.swing.JPanel bekgronTabel;
    private javax.swing.JButton cariTon;
    private javax.swing.JButton deleTon;
    private javax.swing.JTextField enterAidi;
    private javax.swing.JTextField enterCari;
    private javax.swing.JTextField enterDescs;
    private javax.swing.JTextField enterPricen;
    private javax.swing.JTextField enterProname;
    private javax.swing.JTextField enterStockn;
    private javax.swing.JTable isiDataan;
    private javax.swing.JButton lookaTon;
    private javax.swing.JComboBox<String> milihKetgor;
    private javax.swing.JLabel priceNumb;
    private javax.swing.JLabel sigAidi;
    private javax.swing.JLabel sigCateg;
    private javax.swing.JLabel sigproName;
    private javax.swing.JScrollPane skrolTabel;
    private javax.swing.JLabel stockNumb;
    private javax.swing.JButton upDateTon;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
