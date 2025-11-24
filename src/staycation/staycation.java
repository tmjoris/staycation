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
            RegistrationForm regForm = new RegistrationForm();
            regForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            regForm.setSize(1000, 700);
            regForm.setLocationRelativeTo(null);
            regForm.setVisible(true);
        });

    }
}

