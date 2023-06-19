package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controller.JDBCExtraService;
import model.ServiceLibrary;
	
	//Variables for GUI components
	public class ExtraService {
		// Declare instance variables for Swing components
		JFrame frame;
		JTextField txtbookingid, txtserviceprice;
		JComboBox<?> servicetype;
		JButton btninsert;
		Object[] columnsName;
		DefaultTableModel model;
		JTable table;
		ArrayList<ServiceLibrary> a1;
	
		static int ID;
		//The default constructor sets up the GUI frame and adds the necessary components to it.
		public ExtraService(int id) {
			ID = id;
			// Creates a JFrame object and sets its properties
			frame = new JFrame("Extra Services");
			frame.setSize(950, 600);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setLayout(new BorderLayout());
			
			// Creates a JPanel object named NorthPanel and sets its properties
			JPanel northPanel = new JPanel();
			northPanel.setLayout(null);
			northPanel.setPreferredSize(new Dimension(100, 90));
			northPanel.setBackground(new Color(106, 108, 109));
			frame.add(northPanel, BorderLayout.NORTH);
	
			// Creates a JPanel object named title and sets its properties
			JLabel title = new JLabel("Extra Services ");
			title.setForeground(Color.WHITE);
			title.setFont(new Font("Times New Roman", Font.BOLD, 30));
			title.setBounds(400, 30, 380, 40);
			northPanel.add(title);
	
			// Creates a JPanel object named WestPanel and sets its properties
			JPanel WestPanel = new JPanel();
			WestPanel.setLayout(null);
			WestPanel.setPreferredSize(new Dimension(400, 50));
			WestPanel.setBackground(new Color(106, 108, 109));
			frame.add(WestPanel, BorderLayout.WEST);
	
			//initialize and memory allocation for customerPanel
			JPanel customerPanel = new JPanel();
			customerPanel.setLayout(new BorderLayout());
			customerPanel.setPreferredSize(new Dimension(100, 250));
			customerPanel.setBackground(new Color(106, 108, 109));
			frame.add(customerPanel, BorderLayout.CENTER);
	
			//add a label for the booking ID and text field to input it
			JLabel lblbookingid = new JLabel("Booking ID:");
			lblbookingid.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblbookingid.setForeground(Color.WHITE);
			lblbookingid.setBounds(10, 30, 150, 30);
			WestPanel.add(lblbookingid);
	
			txtbookingid = new JTextField();
			txtbookingid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			txtbookingid.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			txtbookingid.setBounds(150, 30, 200, 30);
			WestPanel.add(txtbookingid);
	
			//add a label for the service type and a combo box to select it
			JLabel txtservicetype = new JLabel("Service Type:");
			txtservicetype.setFont(new Font("Times New Roman", Font.BOLD, 18));
			txtservicetype.setForeground(Color.WHITE);
			txtservicetype.setBounds(10, 90, 150, 30);
			WestPanel.add(txtservicetype);
	
			// Creating an Object array with various services
			Object[] H1 = { "Laundray", "Swimming", "Gym Fitness", "Games", "Spa and Sauna", "Massage", "Meditaion", "Yoga", "Transportation", "Hiking", "Travel Guide" };
			servicetype = new JComboBox<Object>(H1);
			servicetype.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			servicetype.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			servicetype.setBounds(150, 90, 200, 30);
			WestPanel.add(servicetype);
	
			// Creating a JLabel for the price field with the text "Price:"
			JLabel lblprice = new JLabel("Service Price:");
			lblprice.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblprice.setForeground(Color.WHITE);
			lblprice.setBounds(10, 150, 150, 30);
			WestPanel.add(lblprice);
	
			// Creating a JTextField for the price field
			txtserviceprice = new JTextField();
			txtserviceprice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			txtserviceprice.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			txtserviceprice.setBounds(150, 150, 200, 30);
			WestPanel.add(txtserviceprice);
	
			// Creating a JButton with the text "Add"
			btninsert = new JButton("Add Service");
			btninsert.setBackground(Color.WHITE);
			btninsert.setFocusable(false);
			btninsert.setForeground(Color.BLACK);
			btninsert.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btninsert.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			btninsert.setBounds(150, 210, 200, 30);
			WestPanel.add(btninsert);
			
			// Adding an ActionListener to the JButton using an anonymous inner class
			btninsert.addActionListener(new ActionListener() {
				
				// This is an implementation of polymorphism and we have replaced the code in the actionPerformed method
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// Creating a new instance of the ServiceLibs class
					ServiceLibrary res = new ServiceLibrary();
	
					// Getting the selected service type from the JComboBox
					int bookingid = Integer.parseInt(txtbookingid.getText());
					String menu = servicetype.getSelectedItem().toString();
					int price = Integer.parseInt(txtserviceprice.getText());
	
					res.setBookingID(bookingid);
					res.setServiceType(menu);
					res.setServicePrice(price);
					res.setEmployeeID(id);
	
					// Adding service using JDBCservice class and call insert method
					JDBCExtraService jdbc = new JDBCExtraService();
					boolean result = jdbc.insert(res);
					if (result == true) { // if insert operation is successful
						updateTable(); // update the table to reflect the changes
						JOptionPane.showMessageDialog(null, "Extra Service Added Sucessfully."); // show success message
					}
	
					else { // if insert operation failed
						JOptionPane.showMessageDialog(null, "Error!! Service Add Failed."); // show error message
					}
				}
	
			});
	
			// Creating JTable and JScrollPane for customer booking table
			columnsName = new Object[3];
			columnsName[0] = "Booking ID";
			columnsName[1] = "Service Type";
			columnsName[2] = "Service Price";
	
	        // Create table to display services
			table = new JTable();
			model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(columnsName);
	
	        // Add table to scroll pane and set bounds
			JScrollPane scroll1 = new JScrollPane(table);
			scroll1.setBounds(400, 20, 500, 400);
			customerPanel.add(scroll1, BorderLayout.CENTER);
	
	        // Update table and make frame visible
			updateTable();
			frame.setVisible(true);
	
		}
	
		// Subclass and to get value at table
		public void updateTable() {
			
	        // Get all services from database and add to table model
			JDBCExtraService jdbc = new JDBCExtraService();
			ArrayList<?> select = jdbc.select_all();
	
	        // Clear the rows of the table model
			model.setRowCount(0);
			if (select.size() > 0) { // Check if there is data in the ArrayList
				for (int i = 0; i < select.size(); i++) { // Loop through the ArrayList and add each object to a Vector object
					ServiceLibrary service = (ServiceLibrary) select.get(i);
					@SuppressWarnings("rawtypes")
					Vector<Comparable> tmpperson = new Vector<Comparable>();
	
					tmpperson.add(service.getBookingID());
					tmpperson.add(service.getServiceType());
					tmpperson.add(service.getServicePrice());
					
	                // Add the Vector object to the table model
					model.addRow(tmpperson);
				}
			}
		}
	}