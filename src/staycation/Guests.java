package staycation;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Guests extends JFrame {

    private JLabel jLabel1;
    private JButton jButton1;

    public Guests() {
        initComponents();
        setSize(800, 800);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Guests::new);
    }
}
