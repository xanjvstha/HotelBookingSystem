package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.JDBCCustomerRegistration;
import controller.RegexExpression;
import model.RegistrationLibrary;

import javax.swing.*;

public class CustomerRegister implements ActionListener, ItemListener {
	//declaring variables for GUI components
	JFrame frame;
	JTextField CustomerID, FullName, Address, District, State, Postcode, Country, EmailID, MobileNo, Username, AccountTypes;
	JComboBox<?> AccountType;
	JButton registerbtn, btnback;
	JPasswordField CustomerPassword;
	JCheckBox showPasswordCheckbox;
	
	public CustomerRegister() {
		// create the frame and set its properties
		frame = new JFrame("Registration");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

        // create the north panel and set its properties
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 60));
		north.setBackground(new Color(106, 101, 101));
		frame.add(north, BorderLayout.NORTH);

        // create the title label and add it to the north panel
		JLabel titlelb = new JLabel("Create New Customer Account", JLabel.CENTER);
		titlelb.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelb.setBounds(180, 15, 250, 35);
		titlelb.setForeground(Color.white);
		north.add(titlelb);
		
        // create the tabbed pane and add it to the frame
		JTabbedPane tab = new JTabbedPane();
		frame.add(tab, BorderLayout.CENTER);

        // create the customer registration panel and add it to the tabbed pane
		JPanel CustomerRegisterPanel = new JPanel();
		CustomerRegisterPanel.setLayout(null);
		tab.add("Customer Register Form", CustomerRegisterPanel);
		
        // create the heading panel and add it to the customer registration panel
		JPanel HeadingPanel = new JPanel();
		HeadingPanel.setBounds(0, 0, 1000, 50);
		HeadingPanel.setLayout(null);
		HeadingPanel.setBackground(new Color(106, 101, 101));
		CustomerRegisterPanel.add(HeadingPanel);

        // create the title label for the customer registration form and add it to the heading panel
		JLabel titlelbl = new JLabel("Customer Registration Form", JLabel.CENTER);
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl.setBounds(180, 10, 550, 35);
		titlelbl.setForeground(Color.white);
		HeadingPanel.add(titlelbl);

		// create a JLabel and a JTextField for Full Name, and add them to the CustomerRegisterPanel
		JLabel FullNamelbl = new JLabel("Full Name: -");
		FullNamelbl.setBounds(50, 70, 150, 35);
		FullNamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(FullNamelbl);

		// Creating a text field for the Full Name
		FullName = new JTextField();
		FullName.setBounds(160, 75, 250, 30);
		FullName.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		FullName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(FullName);
		
		// Creating a label for the address field
		JLabel Addresslbl = new JLabel("Address: -");
		Addresslbl.setBounds(450, 70, 150, 35);
		Addresslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Addresslbl);

		// Creating a text field for the address
		Address = new JTextField();
		Address.setBounds(560, 75, 250, 30);
		Address.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Address.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Address);

		// Creating a label for the district field
		JLabel Districtlbl = new JLabel("District: -");
		Districtlbl.setBounds(50, 130, 150, 35);
		Districtlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Districtlbl);

		// Creating a text field for the district
		District = new JTextField();
		District.setBounds(160, 135, 250, 30);
		District.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		District.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(District);
		
		// Creating a label for the state field
		JLabel Statelbl = new JLabel("State: -");
		Statelbl.setBounds(450, 130, 150, 35);
		Statelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Statelbl);

		// Creating a text field for the state
		State = new JTextField();
		State.setBounds(560, 135, 250, 30);
		State.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		State.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(State);
		
		// Creating a label for the postcode field
		JLabel Postcodelbl = new JLabel("Postcode: -");
		Postcodelbl.setBounds(50, 200, 150, 35);
		Postcodelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Postcodelbl);

		// Creating a text field for the postcode
		Postcode = new JTextField();
		Postcode.setBounds(160, 205, 250, 30);
		Postcode.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Postcode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Postcode);

		// Creating a label for the country field
		JLabel Countrylbl = new JLabel("Country: -");
		Countrylbl.setBounds(450, 200, 150, 35);
		Countrylbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Countrylbl);

		// Creating a text field for the country
		Country = new JTextField();
		Country.setBounds(560, 205, 250, 30);
		Country.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Country.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Country);
		
		// Creating a label for the email field
		JLabel EmailIDlbl = new JLabel("EmailID: -");
		EmailIDlbl.setBounds(50, 270, 150, 35);
		EmailIDlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(EmailIDlbl);
		
		// Creating a text field for the email
		EmailID = new JTextField();
		EmailID.setBounds(160, 275, 250, 30);
		EmailID.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		EmailID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(EmailID);
		
		// Create a JLabel for the mobile number field, set its position, font, and add it to the panel.
		JLabel MobileNolbl = new JLabel("MobileNo: -");
		MobileNolbl.setBounds(450, 270, 150, 35);
		MobileNolbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(MobileNolbl);

		// Create a JTextField for the mobile number, set its position, border, font, and add it to the panel.
		MobileNo = new JTextField();
		MobileNo.setBounds(560, 275, 250, 30);
		MobileNo.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		MobileNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(MobileNo);

		// Create a JLabel for the username field, set its position, font, and add it to the panel.
		JLabel Usernamelbl = new JLabel("Username: -");
		Usernamelbl.setBounds(50, 340, 150, 35);
		Usernamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Usernamelbl);

		// Create a JTextField for the username, set its position, border, font, and add it to the panel.
		Username = new JTextField();
		Username.setBounds(160, 345, 250, 30);
		Username.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(Username);
		
		// Create a JLabel for the password field, set its position, font, and add it to the panel.
		JLabel CustomerPasswordlbl = new JLabel("Password: -");
		CustomerPasswordlbl.setBounds(450, 340, 150, 35);
		CustomerPasswordlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(CustomerPasswordlbl);

		// Create a JPasswordField for the password, set its position, border, font, and add it to the panel.
		CustomerPassword = new JPasswordField();
		CustomerPassword.setBounds(560, 345, 250, 30);
		CustomerPassword.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CustomerPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(CustomerPassword);

		// Create a JLabel for the account type field, set its position, font, and add it to the panel.
		JLabel AccountTypelbl = new JLabel("Account Type: -");
		AccountTypelbl.setBounds(50, 390, 150, 35);
		AccountTypelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(AccountTypelbl);

		// Create a JComboBox for the account type, set its options, position, border, font, and add it to the panel.
		Object[] H1 = { "Customer" };
		AccountType = new JComboBox<Object>(H1);
		AccountType.setBounds(160, 395, 250, 30);
		AccountType.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		AccountType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(AccountType);

		// Create a JButton for the registration button, set its text, position, border, font, add an ActionListener to it, and add it to the panel.
		registerbtn = new JButton("Register");
		registerbtn.setForeground(Color.white);
		registerbtn.setBackground(new Color(106, 101, 101));
		registerbtn.setBounds(560, 390, 250, 30);
		registerbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		registerbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(registerbtn);
		registerbtn.addActionListener(this);

		// create a "Back to login" button with specific properties and add it to CustomerRegisterPanel
		btnback = new JButton("Already have an Account");
		btnback.addActionListener(this);
		btnback.setForeground(Color.white);
		btnback.setBackground(new Color(106, 101, 101));
		btnback.setBounds(560, 430, 250, 30);
		btnback.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerRegisterPanel.add(btnback);

		// make the frame visible
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerbtn)
			
		{
			
			String fullname2 = FullName.getText();
			String address2 = Address.getText();
			String district2 = District.getText();
			String state2 = State.getText();
			String postcode2 = Postcode.getText();
			String country2 = Country.getText();
			String mobileno2 = MobileNo.getText();
			String emailid2 = EmailID.getText();
			String username2 = Username.getText();
			@SuppressWarnings("deprecation")
			String password2 = CustomerPassword.getText();
			String accounttype2 = AccountType.getSelectedItem().toString();
	        
	        
			RegexExpression val = new RegexExpression();
				boolean resultFName = val.Name(fullname2);
				if (resultFName == true) 
				{
					boolean result = val.Mobile(mobileno2);
					if (result == true) 
					{							
						boolean emailresult = val.Email(emailid2);
						if (emailresult == true) 
						{										
							boolean resultpassword=val.Password(password2);
							if(resultpassword==true) 
							{
								boolean resultusername=val.Username(username2);
								if(resultusername==true) 
								{										
									RegistrationLibrary registration = new RegistrationLibrary();
									registration.setFullName(fullname2);
									registration.setAddress(address2);
									registration.setDistrict(district2);
									registration.setState(state2);
									registration.setPostcode(postcode2);
									registration.setCountry(country2);
									registration.setMobileNo(mobileno2);
									registration.setEmailID(emailid2);
									registration.setUsername(username2);
									registration.setPassword(password2);
									registration.setAccountType(accounttype2);
								
									boolean result2 = new JDBCCustomerRegistration().insert(registration);
							        if (result2 == true) 
							        {
							        	JOptionPane.showMessageDialog(registerbtn, "Customer Registered Successfully.");
							        	new LoginPage();
							        	dispose();
							        	frame.setVisible(false);
							        }
							        else 
							        {
							        	JOptionPane.showMessageDialog(registerbtn, "Error!! Customer Registration Failed.");
							        }
								}
								else 
								{
									JOptionPane.showMessageDialog(null, "Please Enter Valid Username.");
								}     
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Please Enter Valid Password.");
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Please Enter Valid Email ID.");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Please Enter Valid Mobile Number with 10 digits.");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid FullName Starting with Capital Letter.");
				}

		}
		
		//checking if the back button is clicked, redirecting to the login page
		else if (e.getSource() == btnback) 
		{
			new LoginPage();
			frame.setVisible(false);
		}
		}

	private void dispose() {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
	}
	
	//main method to run the program
	public static void main(String[] args) {
		new CustomerRegister();
	}
}