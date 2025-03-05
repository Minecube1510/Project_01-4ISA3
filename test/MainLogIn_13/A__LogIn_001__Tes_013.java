/* Paketan */
package MainLogIn_13;
/* Paketan */


/* Import-an */
 // Unsuran
import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 // File
import Dasbor_13.Ba__Dasbor_View__Tes_13;



/* Sistem Utama */
public class A__LogIn_001__Tes_013 extends JFrame implements ActionListener {
    private final JLabel lblUser;
    private final JLabel lblPassword;
    private final JTextField txtUser;
    private final JPasswordField txtPassword;
    private final JButton btnLogin;

    public A__LogIn_001__Tes_013() {
        setTitle("Login Dasbor");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        lblUser = new JLabel("Nama/Username:");
        lblUser.setBounds(20, 30, 120, 25);
        add(lblUser );
        
        txtUser = new JTextField();
        txtUser.setBounds(150, 30, 150, 25);
        add(txtUser);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 70, 120, 25);
        add(lblPassword);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 70, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 110, 100, 25);
        btnLogin.addActionListener(this);
        add(btnLogin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void closingApp() {
        System.out.println("Thank You!");
        System.out.println("Please come again!");
        System.out.println("===== =-= =====");  // Batasin
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = txtUser.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field.");
            return;
        }

        authenticateUser (username, password);
    }

    private void authenticateUser (String username, String password) {
        String url = "jdbc:mysql://localhost:3306/party_cnr_db";  // Nama Database
        String user = "root";
        String pass = "";

        String query = "SELECT * FROM user_cnr_00 WHERE user_name = ? AND user_pswd = ?";

        try (Connection koneksi = DriverManager.getConnection(url, user, pass);
             PreparedStatement pst = koneksi.prepareStatement(query)) {
             
            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    String jabatan = resultSet.getString("role_type");  // Jabatan
                    JOptionPane.showMessageDialog(this,
                            "Login berhasil sebagai " + jabatan + "!",
                            "Log In Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    System.out.println("Welcome: " + jabatan);
                    System.out.println("===== =-~-= =====");  // Batasin
                    
                    // Menampilkan dashboard jika jabatan adalah Admin
                    if (jabatan.equalsIgnoreCase("Admin")) {
                        // [alponter] [4lph4_30n] [alponter 4lph4_30n]
                        Ba__Dasbor_View__Tes_13 dashboard = new Ba__Dasbor_View__Tes_13();
                        dashboard.setVisible(true); // Menampilkan dashboard
                        dispose(); // Menutup jendela login
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Login gagal. Periksa kembali data Anda.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        /* Opening */
        System.out.println("===== =-~-= =====");  // Batasin
        System.out.println("Open the App:");
        System.out.println("Apps");
        System.out.println("===== =-~-= =====");  // Batasin

        SwingUtilities.invokeLater(() -> {
            new A__LogIn_001__Tes_013().setVisible(true);
        });
    }
}
/* Sistem Utama */
