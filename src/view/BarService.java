package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import model.BarLibrary;
import controller.JDBCBarService;

//Variables for GUI components
public class BarService {
	JFrame frame;
	JTextField txtBookingID, txtDrinkPrice;
	JComboBox<?> txtBarMenu;
	JButton btnInsert;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<BarLibrary> a1;
	
	static int ID;
	// default constructor to set the contents of frame
	public BarService(int id) {
		ID = id;
		// Creates a JFrame object and sets its properties
		frame = new JFrame("Bar Services");
		frame.setSize(950, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		// Creates a JPanel object named NorthPanel and sets its properties
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(Color.DARK_GRAY);
		frame.add(northPanel, BorderLayout.NORTH);

		// Creates a JPanel object named title and sets its properties
		JLabel title = new JLabel("Bar Services ");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(350, 30, 380, 40);
		northPanel.add(title);

		// Creates a JPanel object named WestPanel and sets its properties
		JPanel WestPanel = new JPanel();
		WestPanel.setLayout(null);
		WestPanel.setPreferredSize(new Dimension(500, 90));
		WestPanel.setBackground(new Color(105, 107, 108));
		frame.add(WestPanel, BorderLayout.WEST);

		// Creates a JPanel object named customerPanel and sets its properties
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(106, 108, 109));
		frame.add(customerPanel, BorderLayout.CENTER);

		// Creates a JLabel object named lblbookingid and sets its properties
		JLabel lblBookingID = new JLabel("Booking ID:");
		lblBookingID.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBookingID.setForeground(Color.WHITE);
		lblBookingID.setBounds(10, 30, 150, 30);
		WestPanel.add(lblBookingID);

		// Creates a JTextField object named txtbookingid and sets its properties
		txtBookingID = new JTextField();
		txtBookingID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtBookingID.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtBookingID.setBounds(150, 30, 200, 30);
		WestPanel.add(txtBookingID);

		// Creates a JLabel object named barmenu and sets its properties
		JLabel lblBarMenu = new JLabel("Bar Menu:");
		lblBarMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBarMenu.setForeground(Color.WHITE);
		lblBarMenu.setBounds(10, 90, 150, 30);
		WestPanel.add(lblBarMenu);

		// Creates a JComboBox object named txtbarmenu and sets its properties
		Object[] h1 = { "Choose Drink", "Margarita", "Paradise Punch", "Pomegranate Margarita",
				"Black Grape Juice", "Orange Juice", "Unforgettable Daiquiri",
				"Pomegranate Juice", "Pineapple Juice", "Apple Juice",
				"Johnnie Walker Label", "Vodka", "Cognac", "Whisky", "Rum", "Gin", "Liqueur",
				"Tequila", "Beer", "Ale", "Lager", "Wine", "Cider"};
		txtBarMenu = new JComboBox<Object>(h1);
		txtBarMenu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtBarMenu.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtBarMenu.setBounds(150, 90, 200, 30);
		WestPanel.add(txtBarMenu);

		// Creates a JLabel object named lblfoodprice and sets its properties
		JLabel lblDrinkPrice = new JLabel("Beverage Price:");
		lblDrinkPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDrinkPrice.setForeground(Color.WHITE);
		lblDrinkPrice.setBounds(10, 150, 150, 30);
		WestPanel.add(lblDrinkPrice);

		// Creates a JTextField object named txtdrinkprice and sets its properties
		txtDrinkPrice = new JTextField();
		txtDrinkPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDrinkPrice.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtDrinkPrice.setBounds(150, 150, 200, 30);
		WestPanel.add(txtDrinkPrice);

		// Create a button to insert drink details
		btnInsert = new JButton("Add Drink");
		btnInsert.setBackground(new Color(105, 105, 105));
		btnInsert.setFocusable(false);
		btnInsert.setForeground(Color.white);
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnInsert.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnInsert.setBounds(170, 210, 100, 30);
		WestPanel.add(btnInsert);
		
		// Add an action listener to the insert button
		btnInsert.addActionListener(new ActionListener() {
			
			//this is implementation of polymorphism and we have replaced the code in action performed method
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of BarLibrary
				BarLibrary res = new BarLibrary();
				
				// Get the booking id, bar menu, and bar price from the text fields
				int bookingid = Integer.parseInt(txtBookingID.getText());
				String item = txtBarMenu.getSelectedItem().toString();
				int price = Integer.parseInt(txtDrinkPrice.getText());
				
				// Set the values for booking id, bar menu, and bar price in BarLibrary
				res.setBookingID(bookingid);
				res.setBarMenu(item);
				res.setDrinkPrice(price);
				res.setEmployeeID(id);
				
				// Create a new instance of JDBCBarService
				JDBCBarService jdbc = new JDBCBarService();
				boolean result=jdbc.insert(res);
				
				// Check if the insert was successful and show a message accordingly
				if(result==true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Bar Item Added Sucessfully.");
				}

				else {
					JOptionPane.showMessageDialog(null, "Error! Bar Item Adding Failed.");
				}
			}	
		});
		
		// Create column names for the table
		columnsName = new Object[3];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Bar Item";
		columnsName[2] = "Bar Price";

		// Create a new JTable and set the column names
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		// Add the JTable to a scroll pane and add the scroll pane to the panel
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		customerPanel.add(scroll1, BorderLayout.CENTER);

		// Call the updateTable() method to populate the table with data
		updateTable();
		frame.setVisible(true);
	}

	// Method to update the table with the latest data
	public void updateTable() {
		a1 = new JDBCBarService().selectall();
		model.setRowCount(0);

		// Add the latest data to the table
		for (BarLibrary restaurant : a1) {
			Object tmpRow[] = { 
					restaurant.getBookingID(), 
					restaurant.getBarMenu(), 
					restaurant.getDrinkPrice() 
			};
			model.addRow(tmpRow);
		}
		table = new JTable(model);
	}
}