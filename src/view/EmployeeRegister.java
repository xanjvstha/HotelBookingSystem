package view;
//Importing required packages
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

import controller.JDBCEmployeeRegistration;
import model.EmployeeRegistrationLibrary;

public class EmployeeRegister implements ActionListener, ItemListener{
	// Declaring required fields and components
	JFrame frame;
	JTextField EmployeeID, Emp_FullName, Emp_EmailID, Emp_MobileNo, Emp_Address, Emp_Username;
	JComboBox<?> Emp_Role;
	JButton btnregister;
	JPasswordField Emp_Password;
	JLabel lblEmp_Role;

	//default constructor to set the contents of JFrame
	public EmployeeRegister() {
		frame = new JFrame("Employee Registration");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		// Initialize and allocate memory for the north panel
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 60));
		north.setBackground(new Color(106, 101, 101));
		frame.add(north, BorderLayout.NORTH);
		
		// Add a title label to the north panel
		JLabel titlelb = new JLabel("Add Employee Form", JLabel.CENTER);
		titlelb.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelb.setBounds(180, 15, 250, 35);
		titlelb.setForeground(Color.white);
		north.add(titlelb);

		// Add an image label to the west of the frame
		JLabel lbl = new JLabel();
		lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("registration.jpg")));
		lbl.setPreferredSize(new Dimension(400, 60));
		frame.add(lbl, BorderLayout.WEST);

		// Add a tabbed pane to the center of the frame
		JTabbedPane tab = new JTabbedPane();
		frame.add(tab, BorderLayout.CENTER);

		// Add a panel for employee registration to the tabbed pane
		JPanel EmployeePanel = new JPanel();
		EmployeePanel.setLayout(null); // Set the layout of the panel to null
		tab.add("Employee Register", EmployeePanel); // Add the panel to the tabbed pane with title "Employee Register"

		// Add a heading panel to the employee registration panel
		JPanel HeadingPanel1 = new JPanel();
		HeadingPanel1.setBounds(0, 0, 700, 50);
		HeadingPanel1.setLayout(null);
		HeadingPanel1.setBackground(new Color(106, 101, 101));
		EmployeePanel.add(HeadingPanel1);

		// Create a JLabel for the title of the panel
		JLabel titlelbl1 = new JLabel("Employee Registration", JLabel.CENTER);
		titlelbl1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl1.setBounds(100, 10, 450, 35);
		titlelbl1.setForeground(Color.white);
		HeadingPanel1.add(titlelbl1);
		
		// Create a JLabel for the employee role and add it to the panel
		JLabel lblEmp_Role = new JLabel("Role Type: -");
		lblEmp_Role.setBounds(20, 60, 150, 35);
		lblEmp_Role.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_Role);

		// Create an array of Object for the different roles and add it to a JComboBox, then add the combo box to the panel
		Object[] H2 = { "Manager", "Receptionist", "Restaurant Staff", "Bartender" };
		Emp_Role = new JComboBox<Object>(H2);
		Emp_Role.setBounds(130, 60, 200, 30);
		Emp_Role.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_Role.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_Role);

		// Create a JLabel for the employee full name and add it to the panel
		JLabel EmpFullNamelbl1 = new JLabel("Full Name: -");
		EmpFullNamelbl1.setBounds(20, 100, 150, 35);
		EmpFullNamelbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(EmpFullNamelbl1);

		// Create a JTextField for the employee full name and add it to the panel
		Emp_FullName = new JTextField();
		Emp_FullName.setBounds(130, 100, 200, 30);
		Emp_FullName.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_FullName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_FullName);

		// Create a JLabel for the employee email ID and add it to the panel
		JLabel lblEmp_EmailID = new JLabel("Email ID: -");
		lblEmp_EmailID.setBounds(20, 145, 150, 35);
		lblEmp_EmailID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_EmailID);

		// Create a JTextField for the employee email ID and add it to the panel
		Emp_EmailID = new JTextField();
		Emp_EmailID.setBounds(130, 145, 200, 30);
		Emp_EmailID.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_EmailID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_EmailID);

		// Create a JLabel for the employee mobile number and add it to the panel
		JLabel lblEmp_MobileNo = new JLabel("Mobile No.: -");
		lblEmp_MobileNo.setBounds(20, 190, 150, 35);
		lblEmp_MobileNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_MobileNo);

		// Create a JTextField for the employee mobile number and add it to the panel
		Emp_MobileNo = new JTextField();
		Emp_MobileNo.setBounds(130, 190, 200, 30);
		Emp_MobileNo.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_MobileNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_MobileNo);

		// Create a JLabel for the employee address and add it to the panel
		JLabel lblEmp_Address = new JLabel("Address:");
		lblEmp_Address.setBounds(20, 235, 150, 35);
		lblEmp_Address.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_Address);

		// Create a text field for employee address
		Emp_Address = new JTextField();
		Emp_Address.setBounds(130, 235, 200, 30);
		Emp_Address.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_Address.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_Address);

		// Create a label for employee username
		JLabel lblEmp_Username = new JLabel("Username:");
		lblEmp_Username.setBounds(20, 280, 150, 35);
		lblEmp_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_Username);

		// Create a text field for employee username
		Emp_Username = new JTextField();
		Emp_Username.setBounds(130, 280, 200, 30);
		Emp_Username.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_Username);

		// Create a label for employee password
		JLabel lblEmp_Password = new JLabel("Password:");
		lblEmp_Password.setBounds(20, 325, 150, 35);
		lblEmp_Password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(lblEmp_Password);

		// Create a password field for employee password
		Emp_Password = new JPasswordField();
		Emp_Password.setBounds(130, 325, 200, 30);
		Emp_Password.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Emp_Password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(Emp_Password);

		// Create a button for employee registration and add action listener to it
		btnregister = new JButton("Register");
		btnregister.addActionListener(this);
		btnregister.setForeground(Color.white);
		btnregister.setBackground(new Color(106, 101, 101));
		btnregister.setBounds(130, 370, 200, 30);
		btnregister.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnregister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		EmployeePanel.add(btnregister);
			
		// Set the frame to be visible
		frame.setVisible(true);
	}
//	this is implementation of polymorphism and we have replaced the code in action performed method

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
			
            if (e.getSource() == btnregister) {
            	
           	// Create a new RegistrationLibs object and set its properties based on the user input
			EmployeeRegistrationLibrary registration = new EmployeeRegistrationLibrary();
			
			registration.setEmp_FullName(Emp_FullName.getText());
			registration.setEmp_EmailID(Emp_EmailID.getText());
			registration.setMobileNo(Emp_MobileNo.getText());
			registration.setEmp_Address(Emp_Address.getText());
			registration.setEmp_Username(Emp_Username.getText());
			registration.setEmp_Password(Emp_Password.getText());
			registration.setEmp_Role(Emp_Role.getSelectedItem().toString());
			
			 // Call the JDBCRegistration class to insert the new employee into the database
			
			boolean result = new JDBCEmployeeRegistration().insert(registration);
			
			 // Display a success or error message depending on the result of the insertion
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Employee Added Successfully.");
				
			}

			else {
				JOptionPane.showMessageDialog(null, "Error!! Employee Add Failed.");
			}
		} 
	}
//main method to run the program
	public static void main(String[] args) {
		new EmployeeRegister();
	}
//	this is implementation of polymorphism and we have replaced the code in itemStateChanged performed method
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==Emp_Role) {
			Emp_Role.getSelectedItem().toString();

		}				
	}
}