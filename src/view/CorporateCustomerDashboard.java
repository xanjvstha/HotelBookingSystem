package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import model.BookingLibrary;
import model.BookingLibrary1;
//import controller.Global;
//import model.LoginLibrary;
import controller.JDBCBooking;

public class CorporateCustomerDashboard implements MouseListener {
	// Declaring the frame and components
	JFrame frame;
	JButton btnsignout;
	Object[] columnsName, column;
	DefaultTableModel model, model2;
	JTable table, table2;
	JComboBox<?> txtroomtype;
	JDateChooser txtcheckindate, txtcheckoutdate;
	JTextField txtcustomerid, txtbookingid;
	ArrayList<BookingLibrary1> a1;
	JButton btninsert, btnupdate, btndelete;
	TableRowSorter<DefaultTableModel> sorttable;
	
	static int ID;
	static String FullName;
	
	//default constructor to set the contents of frame
	public CorporateCustomerDashboard(int id, String fullname) {
		ID = id;
		FullName = fullname;
		// Setting up the frame
		frame = new JFrame("Corporate Customer Dashboard");
		frame.setSize(950, 600);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());

		// Creating and setting up the north panel
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("CORPORATE CUSTOMER DASHBOARD");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(500, 30, 650, 30);
		northPanel.add(title);
		
		JLabel usertitle=new JLabel("Welcome: "+" "+fullname);		
		usertitle.setFont(new Font("Times New Roman",Font.BOLD,25));
		usertitle.setForeground(Color.white);
		usertitle.setBounds(20,30,350,30);
		northPanel.add(usertitle);
		
		JLabel usertitle1=new JLabel();
		usertitle1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		usertitle1.setForeground(Color.white);
		usertitle1.setBounds(1410,20,90,35);
		northPanel.add(usertitle1);

		// create a logout button
		btnsignout = new JButton("Logout");
		btnsignout.setBackground(new Color(255, 255, 255));
		btnsignout.setOpaque(true);
		btnsignout.setFocusable(false);
		btnsignout.setForeground(Color.BLACK);
		btnsignout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnsignout.setBounds(1300, 30, 120, 30);
		northPanel.add(btnsignout);
		btnsignout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LoginPage();
			}
		});
		
		// Creating and setting up the tab panel
		JTabbedPane tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(100, 250));
		tab.setBackground(new Color(105, 107, 108));
		frame.add(tab, BorderLayout.CENTER);

		// Creating and setting up the customer panel
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		tab.add("Check Booking", customerPanel);

		// Creating and setting up the west panel
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(400, 90));
		westPanel.setBackground(new Color(105, 105, 105));
		customerPanel.add(westPanel, BorderLayout.WEST);

		// Creating and setting up the Check In Date label and field
		txtbookingid = new JTextField();
		
		JLabel lblbookingid = new JLabel("Booking ID:");
		lblbookingid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblbookingid.setForeground(Color.WHITE);
		lblbookingid.setBounds(10, 30, 150, 30);
		westPanel.add(lblbookingid);

		txtbookingid = new JTextField();
		txtbookingid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtbookingid.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtbookingid.setBounds(150, 30, 200, 30);
		txtbookingid.setEditable(false);
		westPanel.add(txtbookingid);
		
		// Creating and setting up the Check In Date label and field
		JLabel lblcheckindate = new JLabel("Check In Date:");
		lblcheckindate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblcheckindate.setForeground(Color.WHITE);
		lblcheckindate.setBounds(10, 90, 150, 30);
		westPanel.add(lblcheckindate);

		Date date = new Date();
		txtcheckindate = new JDateChooser();
		txtcheckindate.setMinSelectableDate(date);
		txtcheckindate.setDateFormatString("yyyy-MM-dd");
		txtcheckindate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtcheckindate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtcheckindate.setBounds(150, 90, 200, 30);
		westPanel.add(txtcheckindate);

		// Creating and setting up the Check Out Date label and field
		JLabel lblcheckoutdate = new JLabel("Check Out Date:");
		lblcheckoutdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblcheckoutdate.setForeground(Color.WHITE);
		lblcheckoutdate.setBounds(10, 150, 150, 30);
		westPanel.add(lblcheckoutdate);
		
		// Create a new Date object with the current date and time
        Date date2 = new Date();
		txtcheckoutdate = new JDateChooser();
		txtcheckoutdate.setMinSelectableDate(date2);
		txtcheckoutdate.setDateFormatString("yyyy-MM-dd");
		txtcheckoutdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtcheckoutdate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtcheckoutdate.setBounds(150, 150, 200, 30);
		westPanel.add(txtcheckoutdate);

		// Create a new JLabel object for the room type label
		JLabel lblroomtype = new JLabel("Room Type:");
		lblroomtype.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblroomtype.setForeground(Color.WHITE);
		lblroomtype.setBounds(10, 210, 150, 30);
		westPanel.add(lblroomtype);

		// Create an array of room types
		Object[] h1 = { "Choose Room Type", "Single", "Twin", "Double", "Queen", "King", "Suite", "Presidential Suite" };
		txtroomtype = new JComboBox<Object>(h1);
		txtroomtype.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtroomtype.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtroomtype.setBounds(150, 210, 200, 30);
		westPanel.add(txtroomtype);

		// Create a new JButton object for requesting a booking
		btninsert = new JButton("Request Booking");
		btninsert.setBackground(new Color(255, 255, 255));
		btninsert.setFocusable(false);
		btninsert.setForeground(Color.BLACK);
		btninsert.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btninsert.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btninsert.setBounds(150, 270, 200, 30);
		westPanel.add(btninsert);
		
		// Add an action listener to the JButton object using an anonymous class
		btninsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new BookingLibrary object
				BookingLibrary booking = new BookingLibrary();
				
				// Retrieve the check-in date input value as a string
				String date1 = ((JTextField) txtcheckindate.getDateEditor().getUiComponent()).getText();

				// Retrieve the check-out date input value as a string
				String date2 = ((JTextField) txtcheckoutdate.getDateEditor().getUiComponent()).getText();

				// Retrieve the booking type input value as a string
				String type = txtroomtype.getSelectedItem().toString();
				

				// Set the booking object's fields with the retrieved input values
				booking.setCustomerID(ID);
				booking.setCheckInDate(date1);
				booking.setCheckOutDate(date2);
				booking.setRoomType(type);
				booking.setBookingStatus("Pending");

				// Create a new JDBCBooking object and call its insert method with the booking object
				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.insert(booking);
				
				// If the insertion was successful, update the table and display a success message
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Booking Requested Successfully.");
					
				// If the insertion was not successful, display an error message
				} else {
					JOptionPane.showMessageDialog(null, "Error!! Booking Request Failed.");
				}
			}
		});

		// Create a new JButton object for requesting a booking
		btnupdate = new JButton("Update Booking");
		btnupdate.setBackground(new Color(255, 255, 255));
		btnupdate.setFocusable(false);
		btnupdate.setForeground(Color.BLACK);
		btnupdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnupdate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnupdate.setBounds(150, 320, 200, 30);
		westPanel.add(btnupdate);
		
		// Add an action listener to the JButton object using an anonymous class
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				// Create a new BookingLibrary object
				BookingLibrary booking = new BookingLibrary();
				
				int id = Integer.parseInt(txtbookingid.getText());
				String date1 = ((JTextField) txtcheckindate.getDateEditor().getUiComponent()).getText();
				String date2 = ((JTextField) txtcheckoutdate.getDateEditor().getUiComponent()).getText();
				String roomtype = (String) txtroomtype.getSelectedItem();

				// Set the booking object's fields with the retrieved input values
				booking.setBookingID(id);
				booking.setCheckInDate(date1);
				booking.setCheckOutDate(date2);
				booking.setRoomType(roomtype);

				// Create a new JDBCBooking object and call its insert method with the booking object
				JDBCBooking updateBooking = new JDBCBooking();
				boolean result = updateBooking.update(booking);
				
				// If the insertion was successful, update the table and display a success message
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Booking Updated Successfully.");
					
				// If the insertion was not successful, display an error message
				} else {
					JOptionPane.showMessageDialog(null, "Error!! Booking Update Failed.");
				}
			}
		});
		
		// Creating a JButton object named "btncancel" with the text "Cancel Booking"
		JButton btncancel = new JButton("Cancel Booking");
		btncancel.setBackground(new Color(255, 255, 255));
		btncancel.setFocusable(false);
		btncancel.setForeground(Color.BLACK);
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btncancel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btncancel.setBounds(150, 370, 200, 30);
		westPanel.add(btncancel);
		
		// Adding an ActionListener to the JButton object
		btncancel.addActionListener(new ActionListener() {

			// Overriding the actionPerformed method of the ActionListener interface
			@Override
			public void actionPerformed(ActionEvent e) {

			    // Parsing the integer value of the text in the "txtbookingid" JTextField object
				BookingLibrary librarybooking = new BookingLibrary();
				int cancelBooking = (Integer.parseInt(txtbookingid.getText()));
				librarybooking.setBookingID(cancelBooking);
				
				JDBCBooking jdbc = new JDBCBooking();
				
			    // Calling the delete method of the JDBCBooking object with the "bookingid5" integer value as argument
				boolean result = jdbc.deleteBooking(cancelBooking);
				
			    // Checking if the delete method returned true
				if (result == true) {
					
			        // Calling the updateTable method
					updateTable();
					
			        // Displaying a message dialog with the message "Booking Cancelled Successfully"
					JOptionPane.showMessageDialog(null, "Booking Cancelled Successfully");
					
				// If the delete method returned false
				} else {
					
			        // Displaying a message dialog with the message "Booking Cancelled Error"
					JOptionPane.showMessageDialog(null, "Error!! Booking Cancel Failed");
				}
			}
		});
		
		JButton clearbtn=new JButton("Clear");
		clearbtn.setBounds(150,420,200,30);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(255,255,255));
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		westPanel.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==clearbtn) {
					
					txtbookingid.setText(null);
					txtcheckindate.setCalendar(null);
					txtcheckoutdate.setCalendar(null);
					txtroomtype.setSelectedIndex(0);

				}}});	

		// create an object array with 8 elements for the column names
		columnsName = new Object[8];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Full Name";
		columnsName[2] = "Booking ID";
		columnsName[3] = "Arrival Date";
		columnsName[4] = "Departure Date";
		columnsName[5] = "Room Type";
		columnsName[6] = "Room No";
		columnsName[7] = "Booking Status";

		// create a JTable and set its model with the default table model
		table = new JTable();
		table.addMouseListener(this);
		
		// set column identifiers for the model with the column names array
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		// call updateTable method to populate data in the table
		updateTable();
		
		JTableHeader heading = table.getTableHeader();
		heading.setBackground(Color.BLACK);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setRowHeight(20);
		sorttable = new TableRowSorter<>(model);
		table.setRowSorter(sorttable);
		table.addMouseListener(this);
		
		// create a JScrollPane and set its viewport with the table
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		
		// Add the JScrollPane to the customerPanel with the BorderLayout.CENTER layout.
		customerPanel.add(scroll1, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	public void updateTable() {

		// create a JDBCBooking object
		JDBCBooking booking = new JDBCBooking();
		
		// call the customerselect_all method of the object to retrieve all the booking data
		ArrayList<?> select = booking.customerselectall(ID);

		// remove all the rows from the model
		model.setRowCount(0);
		
		// if the select ArrayList has data
		if (select.size() > 0) {

			// loop through the ArrayList
			for (int i = 0; i < select.size(); i++) {
				
				// get the BookingLibrary3 object at the current index
				BookingLibrary1 tmp_person = (BookingLibrary1) select.get(i);
		
				// create a Vector object for the data of the current booking
				@SuppressWarnings("rawtypes")
				Vector<Comparable> tmpPerson = new Vector<Comparable>();
		
				// add the data of the current booking to the Vector object
				tmpPerson.add(tmp_person.getCustomerID());
				tmpPerson.add(tmp_person.getFullName());
				tmpPerson.add(tmp_person.getBookingID());
				tmpPerson.add(tmp_person.getCheckInDate());
				tmpPerson.add(tmp_person.getCheckOutDate());
				tmpPerson.add(tmp_person.getRoomType());
				tmpPerson.add(tmp_person.getRoomNo());
				tmpPerson.add(tmp_person.getBookingStatus());

				// add the Vector object to the model as a new row
				model.addRow(tmpPerson);
			}
		}
	}

	// This method handles the mouse click event on the table in the GUI and It updates the text fields with the information of the selected row
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table) {
			try {
			    // Get the selected row index
				int sRows = table.getSelectedRow();
	
				TableModel model = table.getModel();
	
			    // Get the booking ID from the selected row and set it in the corresponding text field
				int bookingid = (int) model.getValueAt(sRows, 2);
				txtbookingid.setText(Integer.toString(bookingid));
	
			    // Get the check-in date from the selected row and set it in the corresponding date picker
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(sRows,3));
				txtcheckindate.setDate(date);
	
			    // Get the check-out date from the selected row and set it in the corresponding date picker
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(sRows, 4));
				txtcheckoutdate.setDate(date2);
				
			    // Get the booking type from the selected row and set it in the corresponding combo box
				String type = model.getValueAt(sRows, 5).toString();
				txtroomtype.setSelectedItem(type);
	
			} catch (Exception ex) {
				System.out.println("Error" + ex.getMessage());
			}
		}
	}

	// These methods are not used in this implementation and are empty
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
}