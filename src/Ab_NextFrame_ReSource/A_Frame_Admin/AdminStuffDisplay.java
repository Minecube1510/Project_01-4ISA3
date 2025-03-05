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
            "ID", "Name", "Description", "Category", "Stock", "Price"}, 0) {
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
        //liatkan.setNorthPane(null);
        
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
        String kueri01 = "SELECT * FROM product";  // Kolom dan Index-nya
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
                int stock = hasiRiset.getInt("stock");
                int harga = hasiRiset.getInt("price");
                //
                keMeja.addRow(new Object[]{aidi, barang, deskrip, ketgo, stock, harga});
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
        sigCateg = new javax.swing.JLabel();
        milihKetgor = new javax.swing.JComboBox<>();
        stockNumb = new javax.swing.JLabel();
        enterStockn = new javax.swing.JTextField();
        priceNumb = new javax.swing.JLabel();
        enterPricen = new javax.swing.JTextField();
        cariTon = new javax.swing.JButton();
        enterCari = new javax.swing.JTextField();
        sigAidi = new javax.swing.JLabel();
        enterAidi = new javax.swing.JTextField();
        enterDescs = new javax.swing.JTextField();
        skrolTabel = new javax.swing.JScrollPane();
        isiDataan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setMaximumSize(new java.awt.Dimension(615, 440));
        setMinimumSize(new java.awt.Dimension(615, 440));
        setPreferredSize(new java.awt.Dimension(615, 440));
        setVisible(true);

        bekgronTabel.setBackground(new java.awt.Color(123, 139, 142));
        bekgronTabel.setToolTipText("");
        bekgronTabel.setMaximumSize(new java.awt.Dimension(615, 440));
        bekgronTabel.setMinimumSize(new java.awt.Dimension(615, 440));
        bekgronTabel.setPreferredSize(new java.awt.Dimension(615, 440));

        lookaTon.setBackground(new java.awt.Color(102, 102, 102));
        lookaTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        lookaTon.setForeground(new java.awt.Color(204, 204, 204));
        lookaTon.setText("Refresh");
        lookaTon.setToolTipText("");
        lookaTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lookaTon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lookaTon.setMaximumSize(new java.awt.Dimension(130, 30));
        lookaTon.setMinimumSize(new java.awt.Dimension(130, 30));
        lookaTon.setPreferredSize(new java.awt.Dimension(130, 30));
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
        addTon.setMaximumSize(new java.awt.Dimension(130, 30));
        addTon.setMinimumSize(new java.awt.Dimension(130, 30));
        addTon.setPreferredSize(new java.awt.Dimension(130, 30));
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
        upDateTon.setMaximumSize(new java.awt.Dimension(130, 30));
        upDateTon.setMinimumSize(new java.awt.Dimension(130, 30));
        upDateTon.setPreferredSize(new java.awt.Dimension(130, 30));
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
        deleTon.setMaximumSize(new java.awt.Dimension(130, 30));
        deleTon.setMinimumSize(new java.awt.Dimension(130, 30));
        deleTon.setPreferredSize(new java.awt.Dimension(130, 30));
        deleTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleTonActionPerformed(evt);
            }
        });

        sigproName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigproName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigproName.setText("Name");
        sigproName.setToolTipText("");
        sigproName.setMaximumSize(new java.awt.Dimension(100, 30));
        sigproName.setMinimumSize(new java.awt.Dimension(100, 30));
        sigproName.setPreferredSize(new java.awt.Dimension(100, 30));

        enterProname.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterProname.setToolTipText("");
        enterProname.setMaximumSize(new java.awt.Dimension(200, 30));
        enterProname.setMinimumSize(new java.awt.Dimension(200, 30));
        enterProname.setPreferredSize(new java.awt.Dimension(200, 30));
        enterProname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPronameActionPerformed(evt);
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
        milihKetgor.setMaximumSize(new java.awt.Dimension(135, 30));
        milihKetgor.setMinimumSize(new java.awt.Dimension(135, 30));
        milihKetgor.setPreferredSize(new java.awt.Dimension(135, 30));
        milihKetgor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milihKetgorActionPerformed(evt);
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
        enterCari.setMaximumSize(new java.awt.Dimension(135, 30));
        enterCari.setMinimumSize(new java.awt.Dimension(135, 30));
        enterCari.setPreferredSize(new java.awt.Dimension(135, 30));
        enterCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCariActionPerformed(evt);
            }
        });

        sigAidi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigAidi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigAidi.setText("ID");
        sigAidi.setToolTipText("");
        sigAidi.setMaximumSize(new java.awt.Dimension(100, 30));
        sigAidi.setMinimumSize(new java.awt.Dimension(100, 30));
        sigAidi.setPreferredSize(new java.awt.Dimension(100, 30));

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

        enterDescs.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterDescs.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        enterDescs.setToolTipText("");
        enterDescs.setMargin(new java.awt.Insets(-12, 0, 2, 6));
        enterDescs.setMaximumSize(new java.awt.Dimension(200, 100));
        enterDescs.setMinimumSize(new java.awt.Dimension(200, 100));
        enterDescs.setPreferredSize(new java.awt.Dimension(200, 100));
        enterDescs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterDescsActionPerformed(evt);
            }
        });

        skrolTabel.setToolTipText("");
        skrolTabel.setAutoscrolls(true);
        skrolTabel.setMaximumSize(new java.awt.Dimension(570, 205));
        skrolTabel.setMinimumSize(new java.awt.Dimension(570, 205));
        skrolTabel.setPreferredSize(new java.awt.Dimension(570, 205));

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
        isiDataan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        isiDataan.setAutoscrolls(false);
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
                    .addComponent(enterDescs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterPricen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterAidi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bekgronTabelLayout.createSequentialGroup()
                                .addComponent(addTon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stockNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bekgronTabelLayout.createSequentialGroup()
                                .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sigCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sigproName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(milihKetgor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterProname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(enterStockn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sigAidi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(cariTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(skrolTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                .addContainerGap())
        );
        bekgronTabelLayout.setVerticalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterProname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sigproName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lookaTon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(milihKetgor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterStockn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigAidi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterPricen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterAidi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterDescs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skrolTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
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
        sigCateg.getAccessibleContext().setAccessibleName("Category Sign");
        sigCateg.getAccessibleContext().setAccessibleDescription("Sign: Category");
        milihKetgor.getAccessibleContext().setAccessibleName("Category Option");
        milihKetgor.getAccessibleContext().setAccessibleDescription("Choosing the Category");
        milihKetgor.getAccessibleContext().setAccessibleParent(sigCateg);
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
        sigAidi.getAccessibleContext().setAccessibleName("ID Sign");
        sigAidi.getAccessibleContext().setAccessibleDescription("Sign: ID");
        enterAidi.getAccessibleContext().setAccessibleName("ID Field");
        enterAidi.getAccessibleContext().setAccessibleDescription("Type the ID");
        enterAidi.getAccessibleContext().setAccessibleParent(sigAidi);
        enterDescs.getAccessibleContext().setAccessibleName("Description Field");
        enterDescs.getAccessibleContext().setAccessibleDescription("Type the Description");
        enterDescs.getAccessibleContext().setAccessibleParent(enterProname);
        skrolTabel.getAccessibleContext().setAccessibleName("Table Panel Scroll");
        skrolTabel.getAccessibleContext().setAccessibleDescription("Panel with Scroller");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bekgronTabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bekgronTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String katgor = (String) milihKetgor.getSelectedItem();
        String stockIn = enterStockn.getText().trim();
        String priceIn = enterPricen.getText().trim();
        //
        int stok;
        long hrgbrp;
        /* Penyaringan */

        /* Sistem */
        if (naMenu.isEmpty() || stockIn.isEmpty() || priceIn.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Fill it!",
                    "Unfilled",
                    JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika ada field yang kosong
        }
        //
        if (enterStockn.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Stock and Price must be number!",
                    "Non Numeric State",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            stok = Integer.parseInt(enterStockn.getText());
            hrgbrp = Integer.parseInt(enterPricen.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Stock and Price must be number!",
                    "Non Numeric State",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "INSERT INTO product (pro_name, pro_desc, category, stock, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = koneksi.prepareStatement(query);
            //
            stmt.setString(1, naMenu);
            stmt.setString(2, tulisk);
            stmt.setString(3, katgor);
            stmt.setInt(4, stok);
            stmt.setLong(5, hrgbrp);
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
                    "Choose the Table to update!",
                    "Unchoosen Table",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID lama dari tabel
        int lamaId = (int) isiDataan.getValueAt(selectedRow, 0);
        int stock = Integer.parseInt(enterStockn.getText().trim());
        String deskrips = enterDescs.getText().trim();
        boolean updateDesc = !deskrips.isEmpty(); // Cek apakah deskripsi diisi

        try {
            // Validasi input numerik
            long aturkaya = Long.parseLong(enterPricen.getText().trim());

            // Bangun query dinamis
            StringBuilder kueri = new StringBuilder("UPDATE product SET pro_name = ?, category = ?, stock = ?, price = ?");
            if (updateDesc) {
                kueri.append(", pro_desc = ?"); // Tambahkan kolom deskripsi hanya jika diisi
            }
            kueri.append(" WHERE id = ?");

            PreparedStatement stmt = koneksi.prepareStatement(kueri.toString());

            // Set parameter sesuai urutan
            int paramIndex = 1;
            stmt.setString(paramIndex++, enterProname.getText().trim());    // pro_name
            stmt.setString(paramIndex++, (String) milihKetgor.getSelectedItem()); // category
            stmt.setInt(paramIndex++, stock);  // stock
            stmt.setLong(paramIndex++, aturkaya); // price

            if (updateDesc) {
                stmt.setString(paramIndex++, deskrips); // pro_desc (hanya jika diisi)
            }

            stmt.setInt(paramIndex, lamaId); // WHERE id

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Data!");
            liatEnak(); // Refresh tabel
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Price must be number!",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error database: " + ex.getMessage(),
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
            JOptionPane.showMessageDialog(null, "Deleting the Product!");
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

    private void milihKetgorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milihKetgorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_milihKetgorActionPerformed

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
