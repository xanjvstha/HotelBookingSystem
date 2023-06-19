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

import controller.JDBCRestaurant;
import model.RestaurantLibrary;

//Variables for GUI components
public class RestaurantService {
	JFrame frame;
	JTextField txtFoodID, txtFoodPrice,txtBookingID;
	JComboBox<?> txtFoodMenu;
	JButton btninsert;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<RestaurantLibrary> a1;

	static int ID;
	// default constructor to set the contents of frame
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RestaurantService(int id) {
		ID = id;
		// Creates a JFrame object and sets its properties
		frame = new JFrame("Food Services");
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
		JLabel title = new JLabel("Food Services ");
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

		// Creates a JLabel object named foodlbl and sets its properties
		JLabel lblfoodmenu = new JLabel("Food Menu:");
		lblfoodmenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblfoodmenu.setForeground(Color.WHITE);
		lblfoodmenu.setBounds(10, 90, 150, 30);
		WestPanel.add(lblfoodmenu);

		// Creates a JComboBox object named txtfoodmenu and sets its properties
		Object[] menu = { "Breakfast", "Lunch", "Dinner", "French Fries", 
				"BBQ Pork Steak", "Burger", "BBQ Wraps", "Lasagne", 
				"Chicken Tikka Masala", "Classic Pizza", "Pepperoni Pizza", 
				"Fried Rice", "Sandwiches", "MoMo", "Thai Noodles", "Sizzler",
				"BBQ Wrap", "Club Sandwich", "Arrabbiata Pasta", "Steak"};
		txtFoodMenu = new JComboBox(menu);
		txtFoodMenu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtFoodMenu.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtFoodMenu.setBounds(150, 90, 200, 30);
		WestPanel.add(txtFoodMenu);

		// Creates a JLabel object named lblfoodprice and sets its properties
		JLabel lblfoodprice = new JLabel("Food Price:");
		lblfoodprice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblfoodprice.setForeground(Color.WHITE);
		lblfoodprice.setBounds(10, 150, 150, 30);
		WestPanel.add(lblfoodprice);

		// Creates a JTextField object named txtfoodprice and sets its properties
		txtFoodPrice = new JTextField();
		txtFoodPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtFoodPrice.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtFoodPrice.setBounds(150, 150, 200, 30);
		WestPanel.add(txtFoodPrice);

		// Create a button to insert food details
		btninsert = new JButton("Add Food");
		btninsert.setBackground(new Color(105, 105, 105));
		btninsert.setFocusable(false);
		btninsert.setForeground(Color.white);
		btninsert.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btninsert.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btninsert.setBounds(170, 210, 100, 30);
		WestPanel.add(btninsert);
		
		// Add an action listener to the insert button
		btninsert.addActionListener(new ActionListener() {
			
			//this is implementation of polymorphism and we have replaced the code in action performed method
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of restaurantLibrary
				RestaurantLibrary res = new RestaurantLibrary();
				
				// Get the booking id, food menu, and food price from the text fields and combo box
				int bookingid = Integer.parseInt(txtBookingID.getText());
				String item = txtFoodMenu.getSelectedItem().toString();
				int price = Integer.parseInt(txtFoodPrice.getText());
				
				// Set the values for booking id, food menu, and food price in restaurantLibrary
				res.setBookingID(bookingid);
				res.setFoodMenu(item);
				res.setFoodPrice(price);
				res.setEmployeeID(id);
				
				// Create a new instance of JDBCrestaurant
				JDBCRestaurant jdbc = new JDBCRestaurant();
				boolean result=jdbc.insert(res);
				
				// Check if the insert was successful and show a message accordingly
				if(result==true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Food Item Added Sucessfully.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!!! Food Item Adding Failed.");
				}
			}			
		});
		
		// adding table in JFrame
		// ****************Customer Booking Table**************
		// Create column names for the table
		columnsName = new Object[3];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Food Menu";
		columnsName[2] = "Food Price";

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
		a1 = new JDBCRestaurant().selectall(); 	// Retrieve the latest data from the database
		model.setRowCount(0); // Clear the existing data from the table

		// Add the latest data to the table
		for (RestaurantLibrary restaurant : a1) {
			Object tmpRow[] = { 
					restaurant.getBookingID(), 
					restaurant.getFoodMenu(), 
					restaurant.getFoodPrice()
			};
			model.addRow(tmpRow);
		}
		table = new JTable(model);
	}
}