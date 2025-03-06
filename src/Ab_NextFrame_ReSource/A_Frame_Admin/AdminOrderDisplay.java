/* Paketan Folder-nya */
package Ab_NextFrame_ReSource.A_Frame_Admin;
/* Paketan Folder-nya */


/* Import-an untuk memfungsikan lebih file */
// File Sistematik //
//import ;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
 //
import java.awt.HeadlessException;
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
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
// File Sistematik //

// Nyari File lain //
//import ;
 //
//import Ab_Frame_ReSource.AdminDasbor_01__G13;
// Nyari File lain //
/* Import-an untuk memfungsikan lebih file */


/* Main System */
public final class AdminOrderDisplay extends javax.swing.JInternalFrame {

    /* Set-Up Penyambungan */
    private Connection koneksi;
    //
    private static final String debe = "party_catrg_db";
    private static final String url = "jdbc:mysql://localhost:3306/" + debe;
    private static final String user = "root";
    private static final String pass = "";
    /* Set-Up Penyambungan */

    public AdminOrderDisplay() {
        initComponents();

        enterNumb.setDocument(new javax.swing.JTextField().getDocument());
        ((AbstractDocument) enterNumb.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
                throws BadLocationException {
                if (string.matches("\\d+")) { // Hanya izinkan angka
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
                throws BadLocationException {
                if (text.matches("\\d+")) { // Hanya izinkan angka
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        // Editing Header Table
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "No", "Name", "Order", "Quantity", "Total Price",
            "Date and Time", "Pay Method", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //
        isiDataan.setModel(model); // isiDataan adalah JTable
        isiDataan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Memungkinkan pemilihan satu baris
        //
        /* Atur lebar kolom */
        // ID/No
        isiDataan.getColumnModel().getColumn(0).setPreferredWidth(100);
        //
        // Nama
        isiDataan.getColumnModel().getColumn(1).setPreferredWidth(250);
        //
        // Pesanan
        isiDataan.getColumnModel().getColumn(2).setPreferredWidth(400);
        //
        // Jumlah Orangan
        isiDataan.getColumnModel().getColumn(3).setPreferredWidth(100);
        //
        // Harga Total
        isiDataan.getColumnModel().getColumn(4).setPreferredWidth(150);
        //
        // Tanggal Waktu Pembayaran
        isiDataan.getColumnModel().getColumn(5).setPreferredWidth(150);
        //
        // Pembayaran (Metode)
        isiDataan.getColumnModel().getColumn(6).setPreferredWidth(150);
        //
        // Pembayaran (Udah atau Belum)
        isiDataan.getColumnModel().getColumn(7).setPreferredWidth(150);
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
        } catch(SQLException ex) {//System.out.println("Error" + ": " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Database Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI liatkan = (BasicInternalFrameUI)this.getUI();
        //liatkan.setNorthPane(null);
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
    public void liatPesanAn() {
        DefaultTableModel keMeja = (DefaultTableModel) isiDataan.getModel();
        keMeja.setRowCount(0); // Reset tabel

        // Query dengan JOIN ke tabel customer dan product
        String query = 
            "SELECT td.id, c.name AS customer_name, p.pro_name AS product_name, " +
            "td.ordet_totalqty, td.ordet_amount, td.order_datetime, td.pay_method, " +
            "td.order_done AS status " +
            "FROM transaction_detail td " +
            "JOIN transaction t ON td.transaction_id = t.id " +       // Join ke transaction
            "JOIN customer c ON t.customer_id = c.id " +              // Ambil nama customer
            "JOIN product p ON t.product_id = p.id";                  // Ambil nama produk

        try (PreparedStatement siapStet = koneksi.prepareStatement(query);
             ResultSet hasil = siapStet.executeQuery()) {

            while (hasil.next()) {
                int id = hasil.getInt("id");
                String customerName = hasil.getString("customer_name"); // Ambil nama customer
                String productName = hasil.getString("product_name");   // Ambil nama produk
                int qty = hasil.getInt("ordet_totalqty");
                long harga = hasil.getLong("ordet_amount");
                String datetime = hasil.getString("order_datetime");
                String payMethod = hasil.getString("pay_method");
                String status = hasil.getString("status");

                // Update row data dengan nama customer dan produk
                keMeja.addRow(new Object[]{
                    id, 
                    customerName,    // Kolom "Name" diisi dari customer.name
                    productName,     // Kolom "Order" diisi dari product.pro_name
                    qty, 
                    harga, 
                    datetime, 
                    payMethod, 
                    status
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bekgronTabel = new javax.swing.JPanel();
        lookaTon = new javax.swing.JButton();
        upDateTon = new javax.swing.JButton();
        cariTon = new javax.swing.JButton();
        deleTon = new javax.swing.JButton();
        enterCari = new javax.swing.JTextField();
        sigName = new javax.swing.JLabel();
        enterNumb = new javax.swing.JTextField();
        sigPaid = new javax.swing.JLabel();
        panelPilih = new javax.swing.JScrollPane();
        antaraPilih = new javax.swing.JList<>();
        peiBayar = new javax.swing.JButton();
        skrolTabel = new javax.swing.JScrollPane();
        isiDataan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
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
        lookaTon.setMaximumSize(new java.awt.Dimension(100, 30));
        lookaTon.setMinimumSize(new java.awt.Dimension(100, 30));
        lookaTon.setPreferredSize(new java.awt.Dimension(100, 30));
        lookaTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookaTonActionPerformed(evt);
            }
        });

        upDateTon.setBackground(new java.awt.Color(102, 102, 102));
        upDateTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        upDateTon.setForeground(new java.awt.Color(204, 204, 204));
        upDateTon.setText("Edit");
        upDateTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        upDateTon.setMaximumSize(new java.awt.Dimension(100, 30));
        upDateTon.setMinimumSize(new java.awt.Dimension(100, 30));
        upDateTon.setPreferredSize(new java.awt.Dimension(100, 30));
        upDateTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upDateTonActionPerformed(evt);
            }
        });

        cariTon.setBackground(new java.awt.Color(102, 102, 102));
        cariTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        cariTon.setForeground(new java.awt.Color(204, 204, 204));
        cariTon.setText("Search");
        cariTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cariTon.setMaximumSize(new java.awt.Dimension(100, 30));
        cariTon.setMinimumSize(new java.awt.Dimension(100, 30));
        cariTon.setPreferredSize(new java.awt.Dimension(100, 30));
        cariTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTonActionPerformed(evt);
            }
        });

        deleTon.setBackground(new java.awt.Color(102, 102, 102));
        deleTon.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        deleTon.setForeground(new java.awt.Color(204, 204, 204));
        deleTon.setText("Remove");
        deleTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deleTon.setMaximumSize(new java.awt.Dimension(100, 30));
        deleTon.setMinimumSize(new java.awt.Dimension(100, 30));
        deleTon.setPreferredSize(new java.awt.Dimension(100, 30));
        deleTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleTonActionPerformed(evt);
            }
        });

        enterCari.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterCari.setMaximumSize(new java.awt.Dimension(206, 30));
        enterCari.setMinimumSize(new java.awt.Dimension(206, 30));
        enterCari.setPreferredSize(new java.awt.Dimension(206, 30));
        enterCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCariActionPerformed(evt);
            }
        });

        sigName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sigName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigName.setText("Quantity");
        sigName.setMaximumSize(new java.awt.Dimension(80, 20));
        sigName.setMinimumSize(new java.awt.Dimension(80, 30));
        sigName.setPreferredSize(new java.awt.Dimension(80, 30));

        enterNumb.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        enterNumb.setMaximumSize(new java.awt.Dimension(260, 30));
        enterNumb.setMinimumSize(new java.awt.Dimension(260, 30));
        enterNumb.setPreferredSize(new java.awt.Dimension(260, 30));
        enterNumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNumbActionPerformed(evt);
            }
        });

        sigPaid.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sigPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigPaid.setText("Paid");
        sigPaid.setMaximumSize(new java.awt.Dimension(80, 67));
        sigPaid.setMinimumSize(new java.awt.Dimension(80, 67));
        sigPaid.setPreferredSize(new java.awt.Dimension(80, 67));

        panelPilih.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelPilih.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        panelPilih.setHorizontalScrollBar(null);
        panelPilih.setMaximumSize(new java.awt.Dimension(90, 67));
        panelPilih.setMinimumSize(new java.awt.Dimension(90, 67));
        panelPilih.setPreferredSize(new java.awt.Dimension(90, 67));

        antaraPilih.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Done", "Not Done" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        antaraPilih.setMaximumSize(new java.awt.Dimension(90, 67));
        antaraPilih.setMinimumSize(new java.awt.Dimension(90, 67));
        antaraPilih.setPreferredSize(new java.awt.Dimension(90, 67));
        panelPilih.setViewportView(antaraPilih);

        peiBayar.setBackground(new java.awt.Color(102, 102, 102));
        peiBayar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 30)); // NOI18N
        peiBayar.setForeground(new java.awt.Color(204, 204, 204));
        peiBayar.setText("Completion");
        peiBayar.setToolTipText("");
        peiBayar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        peiBayar.setMaximumSize(new java.awt.Dimension(100, 30));
        peiBayar.setMinimumSize(new java.awt.Dimension(100, 30));
        peiBayar.setPreferredSize(new java.awt.Dimension(100, 30));
        peiBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peiBayarActionPerformed(evt);
            }
        });

        skrolTabel.setMaximumSize(new java.awt.Dimension(590, 285));
        skrolTabel.setMinimumSize(new java.awt.Dimension(590, 285));
        skrolTabel.setPreferredSize(new java.awt.Dimension(590, 285));

        isiDataan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        isiDataan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Name", "Order", "Quantity", "Total Price", "Date and Time", "Pay Method", "Status"
            }
        ));
        isiDataan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        isiDataan.setMaximumSize(new java.awt.Dimension(750, 600));
        isiDataan.setMinimumSize(new java.awt.Dimension(750, 600));
        isiDataan.setPreferredSize(new java.awt.Dimension(750, 600));
        skrolTabel.setViewportView(isiDataan);

        javax.swing.GroupLayout bekgronTabelLayout = new javax.swing.GroupLayout(bekgronTabel);
        bekgronTabel.setLayout(bekgronTabelLayout);
        bekgronTabelLayout.setHorizontalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skrolTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                                        .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sigName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                                        .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sigPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bekgronTabelLayout.createSequentialGroup()
                                .addComponent(panelPilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peiBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(enterNumb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        bekgronTabelLayout.setVerticalGroup(
            bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bekgronTabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upDateTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lookaTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bekgronTabelLayout.createSequentialGroup()
                        .addGroup(bekgronTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(enterCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sigPaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(peiBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skrolTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

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
        liatPesanAn();
    }//GEN-LAST:event_lookaTonActionPerformed

    public void perBaikPesan() {
        // Validasi 1: Pastikan baris terpilih
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                "Choose the Transaction you want update!",
                "Unchoosen Table",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi 2: Ambil dan cek input
        String newQtyText = enterNumb.getText().trim();

        // Cek apakah field kosong
        if (newQtyText.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Fill the Quantity you want to update!",
                "Unfilled Text",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Cek format angka dengan regex
        if (!newQtyText.matches("^[1-9]\\d*$")) { // Hanya angka > 0
            JOptionPane.showMessageDialog(null,
                "Don't make it Negative!",
                "Wrong Format",
                JOptionPane.WARNING_MESSAGE);
            enterNumb.setText(""); // Reset field
            return;
        }

        // Proses update jika semua validasi passed
        try {
            int transactionId = (int) isiDataan.getValueAt(selectedRow, 0); // Ambil ID dari kolom tersembunyi
            int newQty = Integer.parseInt(enterNumb.getText().trim());

            // 1. Dapatkan harga produk
            String getPriceQuery = "UPDATE transaction_detail " +
                                   "SET ordet_totalqty = ?, ordet_amount = ? " +
                                   "WHERE id = ?";

            try (PreparedStatement priceStmt = koneksi.prepareStatement(getPriceQuery)) {
                priceStmt.setInt(1, transactionId);
                ResultSet priceResult = priceStmt.executeQuery();

                if (priceResult.next()) {
                    long price = priceResult.getLong("price");
                    long totalAmount = newQty * price;

                    // 2. Update database
                    String updateQuery = "UPDATE transaction " +
                                         "SET total_qty = ?, total_amount = ? " +
                                         "WHERE id = ?";

                    try (PreparedStatement updateStmt = koneksi.prepareStatement(updateQuery)) {
                        updateStmt.setInt(1, newQty);
                        updateStmt.setLong(2, totalAmount);
                        updateStmt.setInt(3, transactionId);

                        int affectedRows = updateStmt.executeUpdate();

                        if (affectedRows > 0) {
                            JOptionPane.showMessageDialog(
                                null, 
                                """
                                Update Product Quantity Successfully!
                                Total: Rp""" + " " + totalAmount,
                                "Successful Updated",
                                JOptionPane.INFORMATION_MESSAGE);
                            liatPesanAn(); // Refresh tabel
                            enterNumb.setText(""); // Kosongkan field setelah update
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                "Getting Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void upDateTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upDateTonActionPerformed
        perBaikPesan();
    }//GEN-LAST:event_upDateTonActionPerformed

    public void delPesanAn() {
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Choose who you wanna to delete!",
                    "Unchoosen Table",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Ambil ID transaksi langsung dari kolom pertama tabel
            int transactionId = (int) isiDataan.getValueAt(selectedRow, 0);

            // Konfirmasi penghapusan
            int confirm = JOptionPane.showConfirmDialog(
                null, 
                "Deleting Transaction ID: " + transactionId + "?", 
                "Confirm", 
                JOptionPane.YES_NO_OPTION);

            // Hapus dari transaction_detail
            if (confirm == JOptionPane.YES_OPTION) {  // Konfirmasi
                // Eksekusi query DELETE langsung menggunakan ID
                String deleteQuery = "DELETE FROM transaction WHERE id = ?";
                try (PreparedStatement deleteStmt = koneksi.prepareStatement(deleteQuery)) {
                    deleteStmt.setInt(1, transactionId);
                    int affectedRows = deleteStmt.executeUpdate();

                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null,
                                "Deleteing the Transaction!",
                                "Successfully Deleted",
                                JOptionPane.INFORMATION_MESSAGE);
                        liatPesanAn(); // Refresh tabel
                    }
                }
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(
                null, 
                "Getting Error: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleTonActionPerformed
        delPesanAn();
    }//GEN-LAST:event_deleTonActionPerformed

    private void enterNumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterNumbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterNumbActionPerformed

    private void cariTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTonActionPerformed
        cariData();
    }//GEN-LAST:event_cariTonActionPerformed
    //
    public void cariData() {
        String searchTerm = enterCari.getText().trim();
        DefaultTableModel model = (DefaultTableModel) isiDataan.getModel();

        // Handle escape character untuk regex
        String escapedSearchTerm = Pattern.quote(searchTerm); // <-- Fix error backslash

        TableRowSorter<DefaultTableModel> sorter = 
            (TableRowSorter<DefaultTableModel>) isiDataan.getRowSorter();

        if (sorter == null) {
            sorter = new TableRowSorter<>(model);
            isiDataan.setRowSorter(sorter);
        }

        if (!searchTerm.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + escapedSearchTerm));
        } else {
            sorter.setRowFilter(null);
        }
    }

    private void enterCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterCariActionPerformed

    private void peiBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peiBayarActionPerformed
        // 1. Validasi baris terpilih
        int selectedRow = isiDataan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                null,
                "Choose transaction that to be update!",
                "Unchoosen Table",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Ambil ID transaksi dari kolom pertama tabel
        int transactionId = (int) isiDataan.getValueAt(selectedRow, 0);

        // 3. Validasi pilihan status
        String selectedStatus = antaraPilih.getSelectedValue();
        if (selectedStatus == null) {
            JOptionPane.showMessageDialog(
                null,
                "Choose the Payment status!",
                "Empty Status",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 4. Konversi pilihan ke nilai database
        String dbStatus = selectedStatus.equals("Done") ? "Done" : "Not Done";

        // 5. Eksekusi update
        try {
            String query = "UPDATE transaction_detail SET order_done = ? WHERE id = ?";
            PreparedStatement stmt = koneksi.prepareStatement(query);
            stmt.setString(1, dbStatus);
            stmt.setInt(2, transactionId);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "Payment is" + ": " + selectedStatus,
                    "Successfully Updated",
                    JOptionPane.INFORMATION_MESSAGE);
                liatPesanAn(); // Refresh tabel
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                null,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_peiBayarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> antaraPilih;
    private javax.swing.JPanel bekgronTabel;
    private javax.swing.JButton cariTon;
    private javax.swing.JButton deleTon;
    private javax.swing.JTextField enterCari;
    private javax.swing.JTextField enterNumb;
    private javax.swing.JTable isiDataan;
    private javax.swing.JButton lookaTon;
    private javax.swing.JScrollPane panelPilih;
    private javax.swing.JButton peiBayar;
    private javax.swing.JLabel sigName;
    private javax.swing.JLabel sigPaid;
    private javax.swing.JScrollPane skrolTabel;
    private javax.swing.JButton upDateTon;
    // End of variables declaration//GEN-END:variables
}
/* Main System */
