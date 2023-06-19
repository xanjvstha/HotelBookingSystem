package view;
//Import necessary packages
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import model.BookingLibrary;
import model.BookingLibrary1;
import controller.JDBCBooking;
import controller.JDBCRoomService;
import model.RoomLibrary;

public class HotelDashboard implements MouseListener {
	
	// Initialize instance variables
	JFrame frame;
	JButton btnsignout;
	JDateChooser txtcheckindate,txtcheckoutdate;
	JTextField txtcustomerid,txtbookingid, txtbookingtype,txtroomid ;
	JButton btninsert, btnupdate;
	Object[] columnsName, column;
	DefaultTableModel model, model2;
	JTable table;
	ArrayList<BookingLibrary1>a2;
	TableRowSorter<DefaultTableModel> sorttable;
	
	static int ID;
	static String FullName;
	
	//default constructor to set the contents of frame
	public HotelDashboard(int id, String fullname) {
		
		ID = id;
		FullName = fullname;
		// Create a new JFrame
		frame = new JFrame("Hotel Dashboard");
		frame.setSize(950, 600);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		
		// Create a new JPanel for the north side of the JFrame
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(95,190,150));
		frame.add(northPanel, BorderLayout.NORTH);

		// Create a title JLabel for the JFrame
		JLabel title = new JLabel("HOTEL MANAGEMENT DASHBOARD");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(550, 30, 550, 30);
		northPanel.add(title);
		
		JLabel usertitle=new JLabel("Welcome: "+fullname);
		usertitle.setFont(new Font("Times New Roman",Font.BOLD,25));
		usertitle.setForeground(Color.white);
		usertitle.setBounds(20,30,350,30);
		northPanel.add(usertitle);
		
		JLabel usertitle1=new JLabel();
		usertitle1.setFont(new Font("Times New Roman",Font.BOLD,25));
		usertitle1.setForeground(Color.white);
		usertitle1.setBounds(1100,30,150,30);
		northPanel.add(usertitle1);
		
		// Create a signout JButton for the JFrame
		btnsignout = new JButton("Signout");
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
				// Add functionality to signout button
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
		
		// Create a new JPanel for the westPanel of the JFrame
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(400, 90));
		westPanel.setBackground(new Color(105, 105, 105));
		frame.add(westPanel, BorderLayout.WEST);
		
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
		
		// Creating a label for check-in date and setting its font and bounds
		JLabel lblcheckindate = new JLabel("Check In Date:");
		lblcheckindate.setForeground(Color.WHITE);
		lblcheckindate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblcheckindate.setBounds(10, 90, 150, 30);
		westPanel.add(lblcheckindate);
		
		// Creating a date chooser for check-in date and setting its format, font, and border
		Date checkindate = new Date();
		txtcheckindate = new JDateChooser();
		txtcheckindate.setMinSelectableDate(checkindate);
		txtcheckindate.setDateFormatString("yyyy-MM-dd");
		txtcheckindate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtcheckindate.setBorder(BorderFactory.createLineBorder(Color.white,1));
		txtcheckindate.setBounds(150, 90, 200, 30);
		westPanel.add(txtcheckindate);
		
		// Creating a label for check-out date and setting its font and bounds
		JLabel lblcheckoutdate = new JLabel("Check Out Date:");	
		lblcheckoutdate.setForeground(Color.WHITE);
		lblcheckoutdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblcheckoutdate.setBounds(10, 150, 150, 30);
		westPanel.add(lblcheckoutdate);
		
		// Creating a date chooser for check-out date and setting its format, font, and border
		Date checkoutdate = new Date();
		txtcheckoutdate = new JDateChooser();
		txtcheckoutdate.setMinSelectableDate(checkoutdate);
		txtcheckoutdate.setDateFormatString("yyyy-MM-dd");
		txtcheckoutdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtcheckoutdate.setBorder(BorderFactory.createLineBorder(Color.white,1));
		txtcheckoutdate.setBounds(150, 150, 200, 30);
		westPanel.add(txtcheckoutdate);
		
		// Creating a label for room number and setting its font and bounds
		JLabel lblroomno = new JLabel("Room No:");	
		lblroomno.setForeground(Color.WHITE);
		lblroomno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblroomno.setBounds(10, 210, 150, 30);
		westPanel.add(lblroomno);
		
		// Creating a text field for room number and setting its font and border
		txtroomid = new JTextField();		
		txtroomid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtroomid.setBorder(BorderFactory.createLineBorder(Color.white,1));
		txtroomid.setBounds(150, 210, 200, 30);
		westPanel.add(txtroomid);
		
		// Creating a button for confirming the booking and setting its properties
		btninsert = new JButton("Confirm Booking");
		btninsert.setBackground(new Color(105,105,105));
		btninsert.setFocusable(false);
		btninsert.setForeground(Color.white);
		btninsert.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btninsert.setBorder(BorderFactory.createLineBorder(Color.white,1));
		btninsert.setBounds(150, 270, 200, 30);
		westPanel.add(btninsert);
		
		// Adding an action listener to the button for confirming the booking
		btninsert.addActionListener(new ActionListener() {
			
			// actionPerformed method for performing the action when the button is clicked
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create a new RoomLibrary object
				RoomLibrary room = new RoomLibrary();
				// Get the room number from the JTextField and set the RoomLibrary object's RoomNo
	      	    int Roomid= Integer.parseInt(txtroomid.getText());
		
        		room.setRoomNo(Roomid);
				room.setRoomStatus("Booked"); // Set the RoomLibrary object's RoomStatus to "Booked"
				
				// Create a new JDBCroom object and update the database with the new room status
				JDBCRoomService jdbc=new JDBCRoomService();
				@SuppressWarnings("unused")
				boolean result2=jdbc.receptionupdate(room);     // call the receptionupdate method of the JDBCroom object passing the RoomLibrary object as parameter
				
			    // create a new bookinglibs3 object
				BookingLibrary1 booking=new BookingLibrary1();
				
			    // get the booking id from the txtbookingid text field and parse it as an integer
				int id=Integer.parseInt(txtbookingid.getText());
				int Roomid2=Integer.parseInt(txtroomid.getText());
				
			    // set the booking id of the bookinglibs3 object to the parsed id
				booking.setBookingID(id);
			    // set the room number of the bookinglibs3 object to the parsed room id
				booking.setRoomNo(Roomid2);
			    // set the booking status of the bookinglibs3 object to "Booked"
				booking.setBookingStatus("Booked");
				
			    // create a new JDBCBooking object
				JDBCBooking jdbc2=new JDBCBooking();
			    // call the receptionUpdate method of the JDBCBooking object passing the bookinglibs3 object as parameter
				boolean res=jdbc2.receptionUpdate(booking);
			    // check if the booking was successful
				if(res==true) {
			        // call the updateTable method
					updateTable();
			        // show a success message dialog
					JOptionPane.showMessageDialog(null,"Room Booked Successfully.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Error!! Room Booking Failed."); // show an error message dialog
				}
			}
		});
		
		JButton availableroom = new JButton("Available Room");
		availableroom.setBackground(new Color(105,105,105));
		availableroom.setFocusable(false);
		availableroom.setForeground(Color.white);
		availableroom.setFont(new Font("Times New Roman", Font.BOLD, 18)); 
		availableroom.setBorder(BorderFactory.createLineBorder(Color.white,1));
		availableroom.setBounds(150, 330, 200, 30);
		westPanel.add(availableroom);
		availableroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AvailableRoom();
			}
		});
		
		// Create a JButton for updating the check-in status and set its properties
		btnupdate = new JButton("Confirm Check In");
		btnupdate.setBackground(new Color(105,105,105));
		btnupdate.setFocusable(false);
		btnupdate.setForeground(Color.white);
		btnupdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnupdate.setBorder(BorderFactory.createLineBorder(Color.white,1));
		btnupdate.setBounds(150, 390, 200, 30);
		westPanel.add(btnupdate);
		
		// Add an ActionListener to the JButton
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
							
			    // create a new bookinglibs3 object
				BookingLibrary booking=new BookingLibrary();
				
				int id=Integer.parseInt(txtbookingid.getText());
				
			    // set the booking id of the bookinglibs3 object to the parsed id
				booking.setBookingID(id);
				
				// Get the selected booking status from the JComboBox
				booking.setBookingStatus("Active");
				
			    // Create a JDBCcheckin object and call its update method
				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.checkin(booking);

			    // Check if the update was successful and display a message accordingly
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Customer Checked In Sucessfully.");
				} else {
					JOptionPane.showMessageDialog(null, "Error!! Customer Checked In.");
				}
			}
		});
		
		frame.setVisible(true);

		// Create a tabbed pane for the south panel
		JTabbedPane southPanelTab = new JTabbedPane();
		southPanelTab.setPreferredSize(new Dimension(100,250));
		southPanelTab.setBackground(new Color(110,170,160));
		customerPanel.add(southPanelTab, BorderLayout.SOUTH);
		
		// Create a panel for the "Services" tab of the south panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(null);
		southPanel.setPreferredSize(new Dimension(100,250));
		southPanel.setBackground(new Color(110,170,160));
		southPanelTab.add("Services",southPanel);
		
		// Create a "Manage Room" button and add it to the south panel
		JButton manageroom=new JButton("Manage Room");
		manageroom.setFocusable(false);
		manageroom.setFont(new Font("Times New Roman",Font.BOLD,18));
		manageroom.setBounds(30,10,300,50);
		southPanel.add(manageroom);
		
		// Add an action listener to the "Manage Room" button that opens the Room GUI when clicked
		manageroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new RoomService();
			}
		});
		
		// Create a button for the "Manage Staff" option
		JButton Staff=new JButton("Manage Staff");
		Staff.setFocusable(false);
		Staff.setFont(new Font("Times New Roman",Font.BOLD,18));
		Staff.setBounds(410,10,300,50);
		southPanel.add(Staff);
		Staff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of the EmployeeRegister class
				new EmployeeRegister();
			}
		});
		
		// Create a new button for managing customers
		JButton customerbtn=new JButton("Manage Corporate & Customer");
		customerbtn.setFocusable(false);
		customerbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		customerbtn.setBounds(790,10,300,50);
		southPanel.add(customerbtn);
		
		// Add an action listener to the customerbtn button that creates a new CustomerManagement window when clicked
		customerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new CustomerManager();
			}
		});
		
		// Create a button for the "Bar" option
		JButton btnbar=new JButton("Bar Service");
		btnbar.setFocusable(false);
		btnbar.setFont(new Font("Times New Roman",Font.BOLD,18));
		btnbar.setBounds(30,80,300,50);
		southPanel.add(btnbar);
		btnbar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of the Bar class
				new BarService(id);
			}
		});
		
		// Create a button for the "Restaurant" option
		JButton restauranbtn=new JButton("Restaurant Service");
		restauranbtn.setFocusable(false);
		restauranbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		restauranbtn.setBounds(410,80,300,50);
		southPanel.add(restauranbtn);
		
		// Add an action listener to the button
		restauranbtn.addActionListener(new ActionListener() {
			@Override
			
			// Define what happens when the button is clicked
			public void actionPerformed(ActionEvent e) {
				
				new RestaurantService(id);
			}
		});
		
		// Create a button for the "Extra Service" option
		JButton servicebtn=new JButton("Extra Service");
		servicebtn.setFocusable(false);
		servicebtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		servicebtn.setBounds(790,80,300,50);
		southPanel.add(servicebtn);
		servicebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of the ExtraService class
				new ExtraService(id);
			}
		});
		
		// Create a button for the "Invoice" option
		JButton Billing=new JButton("Generate Invoice");
		Billing.setFocusable(false);
		Billing.setFont(new Font("Times New Roman",Font.BOLD,18));
		Billing.setBounds(30,150,300,50);
		southPanel.add(Billing);
		Billing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Create a new instance of the Billing class
				new Invoice(ID);
			}
		});
	timer.start();
	// Define the column names for the JTable
	columnsName = new Object[8];
	columnsName[0] = "Customer ID";
	columnsName[1] = "Full Name";
	columnsName[2] = "Booking ID";
	columnsName[3] = "Check In Date";
	columnsName[4] = "Check Out Date";
	columnsName[5] = "Room Type";
	columnsName[6] = "Room No";
	columnsName[7] = "Booking Status";

	// Create a JTable and set the column names
	table = new JTable();
	table.addMouseListener(this);
	model = (DefaultTableModel) table.getModel();
	model.setColumnIdentifiers(columnsName);
	
	// Update the table with the data from the database
	updateTable();
	
	JTableHeader heading = table.getTableHeader();
	heading.setBackground(Color.BLACK);
	heading.setForeground(Color.WHITE);
	heading.setFont(new Font("Times New Roman", Font.BOLD, 15));
	table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	table.setRowHeight(20);
	sorttable = new TableRowSorter<>(model);
	table.setRowSorter(sorttable);
	
	// Create a scrollable pane for the JTable and add it to the center panel
	JScrollPane scroll1 = new JScrollPane(table);
	scroll1.setBounds(400, 20, 500, 400);
	customerPanel.add(scroll1, BorderLayout.CENTER);
	
	frame.setVisible(true);
}
	
	// A method to update the JTable with data from the database
	public void updateTable() {
		JDBCBooking managebooking = new JDBCBooking();
		ArrayList<?> select = managebooking.receptionselect();
		model.setRowCount(0); // Clearing the model before adding new rows
		if (select.size() > 0) {
		
			// Looping through the ArrayList of bookinglibs3 objects and adding the data to the model
			for(int i = 0; i< select.size(); i++) {
		
				BookingLibrary1 manaagerbooking = (BookingLibrary1) select.get(i);  
				@SuppressWarnings("rawtypes")
				Vector<Comparable> tmpBooking = new Vector<Comparable>();
				
				tmpBooking.add(manaagerbooking.getCustomerID());
				tmpBooking.add(manaagerbooking.getFullName());
				tmpBooking.add(manaagerbooking.getBookingID());
				tmpBooking.add(manaagerbooking.getCheckInDate());
				tmpBooking.add(manaagerbooking.getCheckOutDate());
				tmpBooking.add(manaagerbooking.getRoomType());
				tmpBooking.add(manaagerbooking.getRoomNo());
				tmpBooking.add(manaagerbooking.getBookingStatus());
		
				model.addRow(tmpBooking);
			}
		}
	}
	
	Timer timer = new Timer(2000, new ActionListener() {
		@Override
      public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setRowCount(0);
			updateTable();	
		}
	}
);
		
	@Override
	public void mouseClicked(MouseEvent e) {
		
		try {
			// Getting the selected row from the JTable
			int rows=table.getSelectedRow();
			
			TableModel model=table.getModel();
			
			// Extracting the booking ID and setting it in the text field
			String bookingid=model.getValueAt(rows,2).toString();
			txtbookingid.setText(bookingid);
			
			// Parsing the arrival date from the JTable and setting it in the date chooser
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(rows, 3));
			txtcheckindate.setDate(date);
			
			// parse the checkout date from a JTable component called model
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(rows, 4));
			txtcheckoutdate.setDate(date2);
			
			String roomid=model.getValueAt(rows, 6).toString();
			txtroomid.setText(roomid);
			
		}
		catch(Exception ex) {
			// catch any errors that occur during parsing or setting the checkout date
			System.out.println("Error"+ex.getMessage());
		}
	}
	
	// implemented MouseListener methods that are not used in this code
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