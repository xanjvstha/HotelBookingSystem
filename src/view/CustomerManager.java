package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.JDBCCustomerRegistration;
import model.RegistrationLibrary;

public class CustomerManager implements MouseListener {
	//declaring variables for GUI components
	JFrame frame;
	JTextField txtcustomerid, txtfullname, txtaddress, txtdistrict, txtstate, txtpostcode, txtcountry, txtemailid, txtmobileno, txtusername, txtpassword, txtaccounttypes;
	JButton btninsert, btnupdate, btndelete;
	Object[] columnsName, column;
	JTable table, table2;
	JComboBox<?> txtaccounttype;
	DefaultTableModel model, model2;
	ArrayList<RegistrationLibrary> a1;

	/**
	 * Constructor: Creates and sets the properties of the registration form. 
	 * It initializes and allocates memory for the GUI components and sets their 
	 * properties such as size, font, and background color. 
	 */
	@SuppressWarnings("static-access")
	public CustomerManager() {
		// create the frame and set its properties
		frame = new JFrame("Customer Manager");
		frame.setSize(950, 600);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());

        // create the north panel and set its properties
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

        // create the title label and add it to the north panel
		JLabel title = new JLabel("Customer & Corporate Manager");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(600, 30, 480, 40);
		northPanel.add(title);

		JPanel WestPanel = new JPanel();
		WestPanel.setLayout(null);
		WestPanel.setPreferredSize(new Dimension(400, 90));
		WestPanel.setBackground(new Color(105, 107, 108));
		frame.add(WestPanel, BorderLayout.WEST);

		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		frame.add(customerPanel, BorderLayout.CENTER);

		// create a JLabel and a JTextField for Full Name, and add them to the CustomerRegisterPanel
		JLabel lblfullname = new JLabel("Full Name:");
		lblfullname.setForeground(Color.WHITE);
		lblfullname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblfullname.setBounds(10, 10, 150, 30);
		WestPanel.add(lblfullname);

		// Creating a text field for the Full Name
		txtfullname = new JTextField();
		txtfullname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtfullname.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtfullname.setBounds(120, 10, 200, 30);
		WestPanel.add(txtfullname);
		
		// Creating a label for the address field
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setForeground(Color.WHITE);
		lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbladdress.setBounds(10, 50, 150, 30);
		WestPanel.add(lbladdress);

		// Creating a text field for the address
		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtaddress.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtaddress.setBounds(120, 50, 200, 30);
		WestPanel.add(txtaddress);
		
		// Creating a label for the district field
		JLabel lbldistrict = new JLabel("District:");
		lbldistrict.setForeground(Color.WHITE);
		lbldistrict.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbldistrict.setBounds(10, 90, 150, 30);
		WestPanel.add(lbldistrict);
		
		// Creating a text field for the district
		txtdistrict = new JTextField();
		txtdistrict.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtdistrict.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtdistrict.setBounds(120, 90, 200, 30);
		WestPanel.add(txtdistrict);

		// Creating a label for the state field
		JLabel lblstate = new JLabel("State:");
		lblstate.setForeground(Color.WHITE);
		lblstate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblstate.setBounds(10, 130, 150, 30);
		WestPanel.add(lblstate);

		// Creating a text field for the state
		txtstate = new JTextField();
		txtstate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtstate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtstate.setBounds(120, 130, 200, 30);
		WestPanel.add(txtstate);

		// Creating a label for the postcode field
		JLabel lblpostcode = new JLabel("Postcode:");
		lblpostcode.setForeground(Color.WHITE);
		lblpostcode.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblpostcode.setBounds(10, 170, 150, 30);
		WestPanel.add(lblpostcode);

		// Creating a text field for the postcode
		txtpostcode = new JTextField();
		txtpostcode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpostcode.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtpostcode.setBounds(120, 170, 200, 30);
		WestPanel.add(txtpostcode);

		// Creating a label for the country field
		JLabel lblcountry = new JLabel("Country:");
		lblcountry.setForeground(Color.WHITE);
		lblcountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblcountry.setBounds(10, 210, 150, 30);
		WestPanel.add(lblcountry);

		// Creating a text field for the country
		txtcountry = new JTextField();
		txtcountry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtcountry.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtcountry.setBounds(120, 210, 200, 30);
		WestPanel.add(txtcountry);

		// Creating a label for the email field
		JLabel lblemailid = new JLabel("Email ID:");
		lblemailid.setForeground(Color.WHITE);
		lblemailid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblemailid.setBounds(10, 250, 150, 30);
		WestPanel.add(lblemailid);
		
		// Creating a text field for the email
		txtemailid = new JTextField();
		txtemailid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtemailid.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtemailid.setBounds(120, 250, 200, 30);
		WestPanel.add(txtemailid);

		// Create a JLabel for the mobile number field, set its position, font, and add it to the panel.
		JLabel lblmobileno = new JLabel("Mobile No:");
		lblmobileno.setForeground(Color.WHITE);
		lblmobileno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblmobileno.setBounds(10, 290, 150, 30);
		WestPanel.add(lblmobileno);

		// Create a JTextField for the mobile number, set its position, border, font, and add it to the panel.
		txtmobileno = new JTextField();
		txtmobileno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtmobileno.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtmobileno.setBounds(120, 290, 200, 30);
		WestPanel.add(txtmobileno);

		// Create a JLabel for the username field, set its position, font, and add it to the panel.
		JLabel lblusername = new JLabel("Username:");
		lblusername.setForeground(Color.WHITE);
		lblusername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblusername.setBounds(10, 330, 150, 30);
		WestPanel.add(lblusername);

		// Create a JTextField for the username, set its position, border, font, and add it to the panel.
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtusername.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtusername.setBounds(120, 330, 200, 30);
		WestPanel.add(txtusername);
		
		// Create a JLabel for the password field, set its position, font, and add it to the panel.
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblpassword.setBounds(10, 370, 150, 30);
		WestPanel.add(lblpassword);

		// Create a JPasswordField for the password, set its position, border, font, and add it to the panel.
		txtpassword = new JTextField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpassword.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtpassword.setBounds(120, 370, 200, 30);
		WestPanel.add(txtpassword);

		// Create a JLabel for the account type field, set its position, font, and add it to the panel.
		JLabel lblaccounttype = new JLabel("Account Type:");
		lblaccounttype.setForeground(Color.WHITE);
		lblaccounttype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblaccounttype.setBounds(10, 410, 150, 30);
		WestPanel.add(lblaccounttype);

		// Create a JComboBox for the account type, set its options, position, border, font, and add it to the panel.
		Object[] H1 = { "Select Account Type", "Customer", "Corporate Customer" };
		txtaccounttype = new JComboBox<Object>(H1);
		txtaccounttype.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtaccounttype.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtaccounttype.setBounds(120, 410, 200, 30);
		WestPanel.add(txtaccounttype);

		// Create Customer Booking View Table
		columnsName = new Object[11];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Full Name";
		columnsName[2] = "Address";
		columnsName[3] = "District";
		columnsName[4] = "State";
		columnsName[5] = "Postcode";
		columnsName[6] = "Country";
		columnsName[7] = "Email ID";
		columnsName[8] = "Mobile No";
		columnsName[9] = "Username";
		columnsName[10] = "Account Type";

		// Create a JTable object and add a mouse listener to it.
		table = new JTable();
		table.addMouseListener(this);
		
		// Get the model of the table and set its column identifiers to the specified column names.
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		// Update the table with the data from the database.
		updateTable();
		
		// Create a JScrollPane object and add the table to it.
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		
		// Add the JScrollPane to the customerPanel with the BorderLayout.CENTER layout.
		customerPanel.add(scroll1, BorderLayout.CENTER);

		// Create a JButton object with the label "Insert" and add it to the westPanel1.
		btninsert = new JButton("Insert");
		btninsert.setBackground(new Color(105, 105, 105));
		btninsert.setFocusable(false);
		btninsert.setForeground(Color.white);
		btninsert.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btninsert.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btninsert.setBounds(120, 450, 200, 30);
		WestPanel.add(btninsert);
		
		// Add an action listener to the JButton to handle the event when it is clicked.
		btninsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a RegistrationLibrary object and set its properties using the data entered by the user.
				RegistrationLibrary registration = new RegistrationLibrary();

				registration.setFullName(txtfullname.getText());
				registration.setAddress(txtaddress.getText());
				registration.setDistrict(txtdistrict.getText());
				registration.setState(txtstate.getText());
				registration.setPostcode(txtpostcode.getText());
				registration.setCountry(txtcountry.getText());
				registration.setEmailID(txtemailid.getText());
				registration.setMobileNo(txtmobileno.getText());
				registration.setUsername(txtusername.getText());
				registration.setPassword(txtpassword.getText());
				registration.setAccountType(txtaccounttype.getSelectedItem().toString());
				
				// Create a JDBCRegistration object and insert the new customer into the database.
				JDBCCustomerRegistration jdbc = new JDBCCustomerRegistration();
				boolean result = jdbc.insert(registration);
				
				// If the insertion was successful, update the table and display a success message. Otherwise, display an error message.
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Customer Added Successfully.");
				}

				else {
					JOptionPane.showMessageDialog(null, "Error!! Customer Add Failed.");
				}
			}
		});
		
		JButton clearbtn=new JButton("Clear");
		clearbtn.setBounds(120,490,200,30);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(105, 105, 105));
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		WestPanel.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==clearbtn) {
					
					txtfullname.setText(null);
					txtaddress.setText(null);
					txtdistrict.setText(null);
					txtstate.setText(null);
					txtpostcode.setText(null);
					txtcountry.setText(null);
					txtemailid.setText(null);
					txtmobileno.setText(null);
					txtusername.setText(null);
					txtpassword.setText(null);
					txtaccounttype.setSelectedIndex(0);
				}}});

        // Close current frame and open login page
		frame.setVisible(true);
	}

	public void updateTable() {
		
	    // create a new instance of JDBCRegistration to handle database operations
		JDBCCustomerRegistration jdbc = new JDBCCustomerRegistration();
		
	    // retrieve all the records from the database and store them in an ArrayList
		ArrayList<?> select = jdbc.select_all();
		
	    // clear the table model to remove any previous data
		model.setRowCount(0);
		
	    // if there are records in the ArrayList, loop through each one
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				
	            // get the RegistrationLibrary object from the ArrayList
				RegistrationLibrary registration = (RegistrationLibrary) select.get(i);
				
	            // create a Vector to hold the data for the current record
				@SuppressWarnings("rawtypes")
				Vector<Comparable> tmpPerson = new Vector<Comparable>();

	            // add each field from the current record to the Vector
				tmpPerson.add(registration.getCustomerID());
				tmpPerson.add(registration.getFullName());
				tmpPerson.add(registration.getAddress());
				tmpPerson.add(registration.getDistrict());
				tmpPerson.add(registration.getState());
				tmpPerson.add(registration.getPostcode());
				tmpPerson.add(registration.getCountry());
				tmpPerson.add(registration.getEmailID());
				tmpPerson.add(registration.getMobileNo());
				tmpPerson.add(registration.getUsername());
				tmpPerson.add(registration.getAccountType());

	            // add the Vector to the table model
				model.addRow(tmpPerson);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		try {

	        // get the index of the selected row
			int rows = table.getSelectedRow();

	        // get the table model
			TableModel model1 = table.getModel();

	        // set the values of the text fields to the values from the selected row
			String fullname = model1.getValueAt(rows, 1).toString();
			txtfullname.setText(fullname);
			
			String address = model1.getValueAt(rows, 2).toString();
			txtaddress.setText(address);
			
			String district = model1.getValueAt(rows, 3).toString();
			txtdistrict.setText(district);
			
			String state = model1.getValueAt(rows, 4).toString();
			txtstate.setText(state);
			
			String postcode = model1.getValueAt(rows, 5).toString();
			txtpostcode.setText(postcode);
			
			String country = model1.getValueAt(rows, 6).toString();
			txtcountry.setText(country);
			
			String emailid = model1.getValueAt(rows, 7).toString();
			txtemailid.setText(emailid);

			String mobileno = model1.getValueAt(rows, 8).toString();
			txtmobileno.setText(mobileno);

			String username = model1.getValueAt(rows, 9).toString();
			txtusername.setText(username);

//			String password = model1.getValueAt(rows, 10).toString();
//			txtpassword.setText(password);

			String accounttype = model1.getValueAt(rows, 11).toString();
			txtaccounttypes.setText(accounttype);

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

	// override the other methods of the MouseListener interface
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {

	    // create a new instance of CustomerManager to start the application
		new CustomerManager();
	}
}