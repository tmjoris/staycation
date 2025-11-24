package staycation;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Guests extends JFrame {

    private JLabel jLabel1;
    private JButton jButton1;
    private String currentUserEmail; // store logged-in user email

    public Guests(String email) {
        this.currentUserEmail = email;
        initComponents();
        setSize(800, 800);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();

        JMenu bookingMenu = new JMenu("Booking");
        JMenuItem bookRoom = new JMenuItem("Book Room");
        bookRoom.addActionListener(evt -> openCustomerBookingPage());
        JMenuItem cancelBooking = new JMenuItem("Cancel Booking");
        cancelBooking.addActionListener(evt -> 
            JOptionPane.showMessageDialog(this, "Your booking is cancelled")
        );
        bookingMenu.add(bookRoom);
        bookingMenu.add(cancelBooking);

        JMenu profileMenu = new JMenu("Profile");
        JMenuItem updatePassword = new JMenuItem("Update Password");
        updatePassword.addActionListener(evt -> updateProfileField("password", "New Password"));
        JMenuItem updateEmail = new JMenuItem("Update Email");
        updateEmail.addActionListener(evt -> updateProfileField("email", "New Email"));
        JMenuItem updateName = new JMenuItem("Update Name");
        updateName.addActionListener(evt -> updateProfileField("name", "New Name"));
        profileMenu.add(updatePassword);
        profileMenu.add(updateEmail);
        profileMenu.add(updateName);

        menuBar.add(bookingMenu);
        menuBar.add(profileMenu);
        setJMenuBar(menuBar);

        jLabel1 = new JLabel("WELCOME TO THE STAYCATION HOTEL");
        jButton1 = new JButton("Come Book Your Room ->");
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setOpaque(true);
        jLabel1.setBackground(Color.BLACK);
        jLabel1.setAlignmentX(CENTER_ALIGNMENT);

        jButton1.setAlignmentX(CENTER_ALIGNMENT); 
        jButton1.addActionListener(evt -> openCustomerBookingPage());

        add(Box.createVerticalGlue());         
        add(jLabel1);
        add(Box.createVerticalStrut(20));      
        add(jButton1);
        add(Box.createVerticalGlue());         
    }

    private void openCustomerBookingPage() {
        new CustomerBooking().setVisible(true);
        dispose();
    }

    private void updateProfileField(String field, String message) {
        String newValue = JOptionPane.showInputDialog(this, message);
        if (newValue == null || newValue.trim().isEmpty()) return;

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/staycation", "root", "");
            String sql = "UPDATE users SET " + field + "=? WHERE email=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newValue);
            pst.setString(2, currentUserEmail);
            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, field + " updated successfully!");
                if (field.equals("email")) {
                    currentUserEmail = newValue; // update current user email
                }
            }
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Guests("jor@example.com")); // for testing
    }
}
