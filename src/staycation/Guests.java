package staycation;

import javax.swing.*;
import java.awt.*;

public class Guests extends javax.swing.JPanel {

    public Guests() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLayout(new BorderLayout());

       
        // Guest Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(240, 240, 240));

        JButton btnCreate = new JButton("Create Account");
        JButton btnLogin = new JButton("Login");
        JButton btnCatalog = new JButton("Room Catalog");
        JButton btnBookings = new JButton("My Bookings");

        menuBar.add(btnCreate);
        menuBar.add(btnLogin);
        menuBar.add(btnCatalog);
        menuBar.add(btnBookings);

        add(menuBar, BorderLayout.NORTH);


        /*Staff Menu
        JMenu staffMenu = new JMenu("Staff");
        JMenuItem staffLoginItem = new JMenuItem("Staff Login");
        staffMenu.add(staffLoginItem);

        // Admin Menu
        JMenu adminMenu = new JMenu("Admin");
        JMenuItem adminPanelItem = new JMenuItem("Admin Panel");
        adminMenu.add(adminPanelItem);

        // Add Menus to MenuBar
        menuBar.add(guestMenu);
        menuBar.add(staffMenu);
        menuBar.add(adminMenu);

        add(menuBar, BorderLayout.NORTH);
        */

        // ===== TOP BANNER =====
        JPanel banner = new JPanel(new BorderLayout());
        banner.setBackground(new Color(25, 25, 25));
        banner.setPreferredSize(new Dimension(900, 150));

        JLabel hotelName = new JLabel("Staycation Hotel", SwingConstants.CENTER);
        hotelName.setForeground(Color.WHITE);
        hotelName.setFont(new Font("Serif", Font.BOLD, 40));
        banner.add(hotelName, BorderLayout.CENTER);

        add(banner, BorderLayout.CENTER);

        // ===== FOOTER =====
        JPanel footer = new JPanel();
        footer.setBackground(new Color(30, 30, 30));
        footer.setPreferredSize(new Dimension(900, 50));

        JLabel copyright = new JLabel("© 2025 Staycation Hotel");
        copyright.setForeground(Color.WHITE);
        footer.add(copyright);

        add(footer, BorderLayout.SOUTH);
    }
}
