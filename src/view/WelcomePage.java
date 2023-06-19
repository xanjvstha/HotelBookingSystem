package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class WelcomePage extends JFrame implements ActionListener {
    // Declare class variables
    JPanel pane1, pane2, pane3;
    JLabel lbl, lblpic;
    JButton btnlogin;

    public WelcomePage() {
        // Set JFrame properties
        setTitle("Welcome To Hotel Luton");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setExtendedState(MAXIMIZED_BOTH);

        // Create header panel with a background color
        JPanel panel = new JPanel();
        panel.setBackground(new Color(106, 101, 101));
        panel.setPreferredSize(new Dimension(10, 80));
        panel.setLayout(null);
        add(panel, BorderLayout.NORTH);

        // Add a welcome label to the header panel
        JLabel lbl = new JLabel("WELCOME TO HOTEL LUTON ", JLabel.CENTER);
        lbl.setBounds(450, 15, 600, 55);
        lbl.setForeground(Color.white);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        panel.add(lbl);

        // Create a sign-in button and add it to the header panel
        btnlogin = new JButton("Signin");
        btnlogin.setBounds(1170, 20, 100, 50);
        btnlogin.setBackground(new Color(206, 201, 201));
        btnlogin.setForeground(Color.white);
        btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnlogin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        btnlogin.setFocusable(false);
        btnlogin.addActionListener(this);
        panel.add(btnlogin);

        // Set the cursor to a hand cursor while moving the mouse pointer over the button
        Cursor add = new Cursor(Cursor.HAND_CURSOR);
        btnlogin.setCursor(add);
        btnlogin.setVisible(true);

        // Add an image to the center of the JFrame
        JLabel lbl1 = new JLabel();
        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("welcomepage.jpg")));
        add(lbl1, BorderLayout.CENTER);

        // Set the JFrame to be visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnlogin) {
            // Create an instance of the login class when the sign-in button is clicked
            @SuppressWarnings("unused")
			LoginPage Login = new LoginPage();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the WelcomePage class
        new WelcomePage();
    }
}