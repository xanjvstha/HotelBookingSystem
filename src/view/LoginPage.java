package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JDBCCustomerLogin;
import controller.JDBCEmployeeLogin;
import model.CustomerLoginLibrary;
import model.EmployeeLoginLibrary;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener {

	// Declare class variables
	JLabel lblusername, lblImg, lblpassword, lbltitle;
	JTextField txtusername;
	JPasswordField txtpassword;
	JPanel loginpanel;
	JButton btnlogin, btnregister, btnclose, btnpassword;

	JRadioButton radioButton;

	// Default constructor
	public LoginPage() {
		// Set JFrame properties
		setTitle("Login");
		setSize(950, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		// Create login panel with a background color
		loginpanel = new JPanel();
		loginpanel.setBackground(new Color(106, 101, 101));
		loginpanel.setBounds(0, 0, 950, 60);
		loginpanel.setLayout(null);
		add(loginpanel);

		// Add a title label to the login panel
		lbltitle = new JLabel("WELCOME BACK !!! Please Login to Enjoy at LUTON HOTEL");
		lbltitle.setBounds(200, 15, 600, 35);
		lbltitle.setForeground(Color.white);
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		loginpanel.add(lbltitle);

		// Add an image label to the JFrame
		lblImg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("LoginPage.png")).getImage();
		lblImg.setIcon(new ImageIcon(img));
		lblImg.setBounds(550, 85, 400, 400);

		// Initialize and declare all the components
		lblusername = new JLabel("USERNAME : -");
		lblusername.setBounds(50, 150, 150, 25);
		lblusername.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// Define a text field for the user to enter their username
		txtusername = new JTextField();
		txtusername.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtusername.setBounds(190, 150, 250, 25);

		// Define a label to prompt the user to enter their password
		lblpassword = new JLabel("PASSWORD : -");
		lblpassword.setBounds(50, 220, 150, 25);
		lblpassword.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// Define a password field for the user to enter their password
		txtpassword = new JPasswordField();
		txtpassword.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtpassword.setBounds(190, 220, 250, 25);

		// Define a button for the user to submit their login information
		btnlogin = new JButton("SIGN IN");
		btnlogin.addActionListener(this);
		btnlogin.setBackground(new Color(106, 101, 101));
		btnlogin.setForeground(Color.white);
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnlogin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnlogin.setBounds(190, 300, 250, 25);

		// Define a button for the user to register a new account
		btnregister = new JButton("SIGN UP");
		btnregister.setBounds(190, 350, 250, 25);
		btnregister.setBackground(new Color(106, 101, 101));
		btnregister.setForeground(Color.white);
		btnregister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnregister.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnregister.addActionListener(this);

		// Define a button for the user to close the login screen
		btnclose = new JButton("CLOSE");
		btnclose.setBounds(190, 400, 250, 25);
		btnclose.setBackground(new Color(106, 101, 101));
		btnclose.setForeground(Color.white);
		btnclose.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnclose.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnclose.setFocusable(false);
		btnclose.addActionListener(this);

		radioButton = new JRadioButton("Show Password");
		radioButton.setBounds(190, 260, 250, 25);
		radioButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		radioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				// show password chars
				if (radioButton.isSelected()) {
					txtpassword.setEchoChar((char) 0);
				}
				// hide password chars
				else {
					txtpassword.setEchoChar('*');
				}
			}
		});

		// Set the cursor to a hand cursor while moving the mouse pointer over the
		// button
		Cursor add = new Cursor(Cursor.HAND_CURSOR);
		btnlogin.setCursor(add);
		btnlogin.setVisible(true);
		btnregister.setCursor(add);
		btnregister.setVisible(true);
		btnclose.setCursor(add);
		btnclose.setVisible(true);

		// Add all the components to the JFrame
		add(lblImg);
		add(lblusername);
		add(txtusername);
		add(lblpassword);
		add(txtpassword);
		add(btnlogin);
		add(btnregister);
		add(btnclose);
		add(radioButton);
		setVisible(true);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Check which button was clicked
		if (ae.getSource() == btnregister) {
			// If "Register" button was clicked, create a new CustomerRegister instance and
			// hide the login page
			CustomerRegister book = new CustomerRegister();
			setVisible(false);
		} else if (ae.getSource() == btnclose) {
			// If "Close" button was clicked, dispose of the login page
			this.dispose();
			// System.exit(0);
		} else if (ae.getSource() == btnlogin) {
			// If "Login" button was clicked, create a new LoginLibs instance and set its
			// username and password fields
			CustomerLoginLibrary user = new CustomerLoginLibrary();
			user.setUsername(txtusername.getText());
			user.setPassword(txtpassword.getText());
			// frametoframe.obj1 = user;

			EmployeeLoginLibrary empuser = new EmployeeLoginLibrary();
			empuser.setEmp_Username(txtusername.getText());
			empuser.setEmp_Password(txtpassword.getText());

			// Call the login method of the JDBCLogin class, passing in the LoginLibs object
			boolean result = new JDBCCustomerLogin().customerlogin(user);
			boolean result1 = new JDBCEmployeeLogin().employeelogin(empuser);
			if (user.getNewPassword().equals(txtpassword.getText()) && result == true) {
				int id = user.getCustomerID();
				String fullname = user.getFullName();
				JOptionPane.showMessageDialog(btnlogin, "Welcome to Luton Hotel" + " " + user.getFullName());

				if (user.getAccountType().equals("Customer")) {
					CustomerDashboard cDashboard = new CustomerDashboard(id, fullname);
					this.dispose();
				}

				else if (user.getAccountType().equals("Corporate Customer")) {
					CorporateCustomerDashboard corporateCustomer = new CorporateCustomerDashboard(id, fullname);
					this.dispose();
				}
			}

			else if (empuser.getEmp_NewPassword().equals(txtpassword.getText()) && result1 == true) {
				int empid = empuser.getEmployeeID();
				String emp_fullname = empuser.getEmp_FullName();
				JOptionPane.showMessageDialog(btnlogin, "Welcome to Luton Hotel" + " " + empuser.getEmp_FullName());

				if (empuser.getEmp_Role().equals("Manager")) {
					HotelDashboard mDashboad = new HotelDashboard(empid, emp_fullname);
					this.dispose();
				}

				else if (empuser.getEmp_Role().equals("Receptionist")) {
					HotelDashboard rDashboard = new HotelDashboard(empid, emp_fullname);
					this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(btnlogin, "Please Enter Valid Username and Password ");
			}

		}
	}

	public static void main(String[] args) {
		// Create a new LoginPage instance, which creates and displays the login page
		// GUI
		new LoginPage();
	}
}