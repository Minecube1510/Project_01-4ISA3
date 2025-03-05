/* Paketan */
package Dasbor_13;

/* Import-an */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Sistem Utama */
public class Ba__Dasbor_View__Tes_13 extends JFrame {

    public Ba__Dasbor_View__Tes_13() {
        setTitle("Aplikasi");  // Judul GUI-nya
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Panel utama dengan layout null (absolute positioning)
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(211, 211, 211));  // Menambahkan warna latar belakang
        panel.setBounds(0, 0, 750, 450); // Mengatur ukuran panel

        // Label judul
        JLabel titleLabel = new JLabel("CnR");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 0, 0));  // Menambahkan warna teks untuk visibilitas
        titleLabel.setBounds(20, 15, 300, 40);  // x, y, width, height

        //
        int bordLimit = 70;
        
        // Dropdown
        String[] opsi = {"Pembelian", "Penyewaan"};
        JComboBox<String> dropdown = new JComboBox<>(opsi);  
        dropdown.setBounds(0, bordLimit, 200, 30);  // x, y, width, height

        // Panel tombol dengan absolute positioning
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(200, 0, 600, bordLimit);  // x, y, width, height
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(true);  // Menjadikan panel transparan

        /* Tombol-tombol */
        //int xTon = 80;
        int xTonDis = 40;
        int yTon = 20;
        //
        int wiTton = 80;
        int hiTton = 30;

        // Cancel
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds((20), yTon, wiTton, hiTton);
        //cancelButton.setContentAreaFilled(false);  // Menjadikan tombol transparan
        //
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.WHITE);
        //cancelButton.setForeground(new Color(0, 0, 0));
        //cancelButton.setBackground(new Color(0, 0, 0));
        //
        cancelButton.setOpaque(true);  // Mengatur opaque tombol

        // Order
        JButton orderButton = new JButton("Order");
        orderButton.setBounds((80 + xTonDis), yTon, wiTton, hiTton);  // x, y, width, height
        //orderButton.setContentAreaFilled(false);  // Menjadikan tombol transparan
        //
        orderButton.setForeground(Color.BLACK);
        orderButton.setBackground(Color.WHITE);
        //orderButton.setForeground(new Color(0, 0, 0));
        //orderButton.setBackground(new Color(0, 0, 0));
        //
        orderButton.setOpaque(true);  // Mengatur opaque tombol

        // Close
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(425, yTon, wiTton, hiTton);  // x, y, width, height
        closeButton.setContentAreaFilled(false);  // Menjadikan tombol transparan
        //
        closeButton.setForeground(Color.BLACK);
        //closeButton.setForeground(new Color(0, 0, 0));
        closeButton.setBackground(Color.RED);
        //closeButton.setBackground(new Color(0, 0, 0));
        //
        closeButton.setOpaque(true);  // Mengatur opaque tombol
        /* Tombol-tombol */

        // Event listener untuk tombol Order
        orderButton.addActionListener((ActionEvent e) -> {
            String pilihan = (String) dropdown.getSelectedItem();
            JOptionPane.showMessageDialog(null, "Anda memilih: " + pilihan);
        });

        // Menambahkan komponen ke panel
        buttonPanel.add(cancelButton);
        buttonPanel.add(orderButton);
        buttonPanel.add(closeButton);

        panel.add(titleLabel);
        panel.add(dropdown);
        panel.add(buttonPanel);

        add(panel);
        setVisible(true);
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        /* Opening */
        System.out.println("===== =-~-= =====");
        System.out.println("Open the App:");
        System.out.println("Apps");
        System.out.println("===== =-~-= =====");

        SwingUtilities.invokeLater(() -> {
            new Ba__Dasbor_View__Tes_13().setVisible(true);
        });
    }
}
