/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package staycation;

/**
 *
 * @author HP
 */
import javax.swing.*;

public class staycation {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Staycation Hotel");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add your landing page JPanel
            window.setContentPane(new Guests());

            window.pack(); // auto-size to preferred layout
            window.setSize(1000, 700); // override if you want a custom size
            window.setLocationRelativeTo(null); // center on screen
            window.setVisible(true);
        });

    }
}

