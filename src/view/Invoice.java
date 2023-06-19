package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import model.BookingLibrary1;
import model.InvoiceLibrary;
import model.InvoiceLibrary2;
import model.RoomLibrary;
//import controller.Global;
import controller.JDBCBilling;
import controller.JDBCRoomService;
//Define the class
public class Invoice implements MouseListener {
	private static final InvoiceLibrary InvoiceLibrary = null;
	// Declare class-level variables
	float TotalAmount, SubTotal, GrandTotal, Discount, Service_Charge, room_price1, serviceprice1, food_price1, drinkprice1, TAXAmount;
	JFrame frame;
	JTextField searchField;
	TableRowSorter<?> sorter;
	JTable table1;
	JTextField txtBookingID, txtFullName, txtRoomRate, txtServicePrice, txtFoodPrice, txtVAT,
			txtServiceCharge, txtTotalAmount, txtSubTotalAmount, txtDrinkPrice, txtRoomID, txtStayedDays,
			txtRoomPrice, txtDiscount;
	String FullName;
	int BookingID;
	JComboBox<?> txtInvoiceStatus;
	JButton btnGenerateInvoice, btnCalculateInvoice;
	Object[] Col;
	DefaultTableModel model;
	ArrayList<InvoiceLibrary> Billing;
	JDateChooser txtCheckInDate, txtCheckOutDate;
	TableRowSorter<DefaultTableModel> sorttable;
	
	static int ID;
	
	// Define the default constructor to set the contents of the frame
	public Invoice(int id) {
		ID = id;
		// Create a new frame
		frame = new JFrame("Check Out Form");
		frame.setSize(1450, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		// Initialize and allocate memory for the north panel
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(185, 160, 200));
		north.setPreferredSize(new Dimension(100, 100));
		frame.add(north, BorderLayout.NORTH);
		
		// create the title label and add it to the north panel
		JLabel title = new JLabel("GENERATE INVOICE AND PRINT BILL");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(600, 30, 480, 40);
		north.add(title);

		// Initialize the text field for booking ID
		txtBookingID = new JTextField();
		
		// Adding a table to the JFrame
		Col = new Object[9];
		Col[0] = "Booking ID";
		Col[1] = "Full Name";
		Col[2] = "Arrival Date";
		Col[3] = "Departure Date";
		Col[4] = "Room No";
		Col[5] = "Room Price";
		Col[6] = "Food Price";
		Col[7] = "Drink Price";
		Col[8] = "Service Price";
		
		table1 = new JTable();
		table1.addMouseListener(this);
		
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(Col);
		
		updateTable();
		
		JTableHeader heading = table1.getTableHeader();
		heading.setBackground(Color.BLACK);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table1.setRowHeight(20);
		sorttable = new TableRowSorter<>(model);
		table1.setRowSorter(sorttable);
		
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);

		// Creating a JPanel to hold some text fields with labels
		JPanel southPanel = new JPanel();
		southPanel.setLayout(null);
		southPanel.setPreferredSize(new Dimension(400, 280));
		frame.add(southPanel, BorderLayout.SOUTH);
		
		// Creating a text field for the room ID
		txtRoomID = new JTextField();

		// Creating a label and text field for the full name
		JLabel namelbl = new JLabel("Full Name:");
		namelbl.setBounds(10, 10, 210, 25);
		namelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(namelbl);

		// Creates a new text field for the full name and sets its properties
		txtFullName = new JTextField();
		txtFullName.setBounds(150, 10, 150, 25);
		txtFullName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtFullName);
		
		// Creating a label and JDateChooser for the arrival date
		JLabel lblCheckIn = new JLabel("Check In Date:");
		lblCheckIn.setBounds(10, 50, 210, 25);
		lblCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblCheckIn);

		// Creates a new text field for the arrival date and sets its properties
		txtCheckInDate = new JDateChooser();
		txtCheckInDate.setDateFormatString("yyyy-MM-dd");
		txtCheckInDate.setBounds(150, 50, 150, 25);
		txtCheckInDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		southPanel.add(txtCheckInDate);

		// Creating a label and JDateChooser for the departure date
		JLabel lblCheckOut = new JLabel("Check Out Date: ");
		lblCheckOut.setBounds(10, 90, 210, 25);
		lblCheckOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblCheckOut);

		// Creates a new text field for the departure date and sets its properties
		txtCheckOutDate = new JDateChooser();
		txtCheckOutDate.setDateFormatString("yyyy-MM-dd");
		txtCheckOutDate.setBounds(150, 90, 150, 25);
		txtCheckOutDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		southPanel.add(txtCheckOutDate);
		
		// Creating a label and text field for the number of days stayed
		JLabel lblStayedDays = new JLabel("Stayed Days: ");
		lblStayedDays.setBounds(10, 130, 210, 25);
		lblStayedDays.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblStayedDays);

		// Creates a new text field for the stayed days and sets its properties
		txtStayedDays = new JTextField();
		txtStayedDays.setEditable(false);
		txtStayedDays.setBounds(150, 130, 150, 25);
		txtStayedDays.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtStayedDays);

		// Creating a label and text field for the room rate
		JLabel lblRoomPrice = new JLabel("Room Rate:");
		lblRoomPrice.setBounds(10, 170, 210, 25);
		lblRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblRoomPrice);

		// Creates a new text field for the room price and sets its properties
		txtRoomRate = new JTextField();
		txtRoomRate.setEditable(false);
		txtRoomRate.setBounds(150, 170, 150, 25);
		txtRoomRate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtRoomRate);

		// Creating a label and text field for drink price
		JLabel lblDrinkPrice = new JLabel("Drink Amount:");
		lblDrinkPrice.setBounds(10, 210, 150, 25);
		lblDrinkPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblDrinkPrice);

		// Creates a new text field for the drink price and sets its properties
		txtDrinkPrice = new JTextField();
		txtDrinkPrice.setEditable(false);
		txtDrinkPrice.setBounds(150, 210, 150, 25);
		txtDrinkPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtDrinkPrice);

		// Creating a label and text field for the service price
		JLabel lblServicePrice = new JLabel("Service Price:");
		lblServicePrice.setBounds(350, 10, 200, 25);
		lblServicePrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblServicePrice);

		// Creates a new text field for the service amount and sets its properties
		txtServicePrice = new JTextField();
		txtServicePrice.setEditable(false);
		txtServicePrice.setBounds(500, 10, 150, 25);
		txtServicePrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtServicePrice);

		// Creating a label and text field for the food price
		JLabel lblFoodPrice = new JLabel("Food Price:");
		lblFoodPrice.setBounds(350, 50, 210, 25);
		lblFoodPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblFoodPrice);

		// Creates a new text field for the food price and sets its properties
		txtFoodPrice = new JTextField();
		txtFoodPrice.setEditable(false);
		txtFoodPrice.setBounds(500, 50, 150, 25);
		txtFoodPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtFoodPrice);
		
		// Creating a label and text field for the room price
		JLabel lblTotalRoomPrice = new JLabel("Total Room Amount:");
		lblTotalRoomPrice.setBounds(350, 90, 210, 25);
		lblTotalRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblTotalRoomPrice);

		// Creates a new text field for the room price and sets its properties
		txtRoomPrice = new JTextField();
		txtRoomPrice.setEditable(false);
		txtRoomPrice.setBounds(500, 90, 150, 25);
		txtRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtRoomPrice);

		// Creating a label and text field for the VAT
		JLabel lblVAT = new JLabel("13% VAT Amount:");
		lblVAT.setBounds(350, 130, 210, 25);
		lblVAT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblVAT);

		// Creates a new text field for the VAT amount and sets its properties
		txtVAT = new JTextField();
		txtVAT.setEditable(false);
		txtVAT.setBounds(500, 130, 150, 25);
		txtVAT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtVAT);

		// Creating a label and text field for the service charge
		JLabel lblServiceCharge = new JLabel("Service Charge: ");
		lblServiceCharge.setBounds(350, 170, 210, 25);
		lblServiceCharge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblServiceCharge);

		// Creates a new text field for the service charge amount and sets its properties
		txtServiceCharge = new JTextField();
		txtServiceCharge.setText("Rs: 500");
		txtServiceCharge.setEditable(false);
		txtServiceCharge.setBounds(500, 170, 150, 25);
		txtServiceCharge.setFont(new Font("Times New Roman", Font.BOLD, 18));
		southPanel.add(txtServiceCharge);
		
		// Creating a label and text field for the total paid amount
		JLabel lblSubTotal = new JLabel("SubTotal Amount: ");
		lblSubTotal.setBounds(350, 210, 210, 25);
		lblSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblSubTotal);

		// Creates a new text field for the paid amount and sets its properties
		txtSubTotalAmount = new JTextField();
		txtSubTotalAmount.setEditable(false);
		txtSubTotalAmount.setBounds(500, 210, 150, 25);
		txtSubTotalAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtSubTotalAmount);
		
		// Creating a label and text field for the discount price
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(750, 10, 210, 25);
		lblDiscount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblDiscount);

		// Creates a new text field for the discount amount and sets its properties
		txtDiscount = new JTextField();
		txtDiscount.setEditable(false);
		txtDiscount.setBounds(900, 10, 150, 25);
		txtDiscount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtDiscount);

		// Creating a label and text field for the total amount
		JLabel lblTotalAmount = new JLabel("Grand Total: ");
		lblTotalAmount.setBounds(750, 50, 210, 25);
		lblTotalAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblTotalAmount);

		// Creates a new text field for the total amount and sets its properties
		txtTotalAmount = new JTextField();
		txtTotalAmount.setEditable(false);
		txtTotalAmount.setBounds(900, 50, 150, 25);
		txtTotalAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtTotalAmount);

		// Creates a new label for the billing status and sets its properties
		JLabel lblInvoiceStatus = new JLabel("Invoice Status: ");
		lblInvoiceStatus.setBounds(750, 90, 210, 25);
		lblInvoiceStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(lblInvoiceStatus);

		// Creates a new drop-down list for the billing status and sets its properties
		Object[] TotalAmount5 = { "Paid", "Unpaid", "Due"};
		txtInvoiceStatus = new JComboBox<Object>(TotalAmount5);
		txtInvoiceStatus.setBounds(900, 90, 150, 25);
		txtInvoiceStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		southPanel.add(txtInvoiceStatus);

		// Creates a new button for paying the invoice and sets its properties
		btnGenerateInvoice = new JButton("Print Bill");
		btnGenerateInvoice.setFocusable(false);
		btnGenerateInvoice.setBounds(1150, 10, 150, 25);
		btnGenerateInvoice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnGenerateInvoice.setForeground(Color.white);
		btnGenerateInvoice.setBackground(new Color(106, 101, 101));
		southPanel.add(btnGenerateInvoice);
		
		// Adds an action listener to the Pay button
		btnGenerateInvoice.addActionListener(new ActionListener() {

			// Defines the action to be taken when the button is pressed
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Checks if the source of the action was the Pay button
				if (e.getSource() == btnGenerateInvoice) {
					new InvoicePrint(FullName, BookingID, TotalAmount, GrandTotal, SubTotal, Discount, Service_Charge, room_price1, serviceprice1, food_price1, drinkprice1,TAXAmount);
				}		
			}
		});

		// ActionListener for the clear button, which clears all text fields
		JButton clearbtn = new JButton("Clear");
		clearbtn.setFocusable(false);
		clearbtn.setBounds(1150, 50, 150, 25);
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(106, 101, 101));
		southPanel.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDiscount.setText(null);
				txtFullName.setText(null);
				txtStayedDays.setText(null);
				txtFoodPrice.setText(null);
				txtDrinkPrice.setText(null);
				txtRoomRate.setText(null);
				txtRoomPrice.setText(null);
				txtServicePrice.setText(null);
				txtFoodPrice.setText(null);
				txtTotalAmount.setText(null);
				txtSubTotalAmount.setText(null);
			}
		});
		
		// ActionListener for the clear button, which clears all text fields
		JButton btnCalculate = new JButton("Check Out");
		btnCalculate.setFocusable(false);
		btnCalculate.setBounds(1150, 90, 150, 25);
		btnCalculate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalculate.setForeground(Color.white);
		btnCalculate.setBackground(new Color(106, 101, 101));
		southPanel.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creates a new RoomLibrary object and sets its properties based on the text fields
				RoomLibrary room = new RoomLibrary();
				// Get the room number from the JTextField and set the RoomLibrary object's RoomNo
	      	    int Roomid= Integer.parseInt(txtRoomID.getText());
		
        		room.setRoomNo(Roomid);
				room.setRoomStatus("Available"); // Set the RoomLibrary object's RoomStatus to "Booked"
				
				// Create a new JDBCroom object and update the database with the new room status
				JDBCRoomService jdbc=new JDBCRoomService();
				@SuppressWarnings("unused")
				boolean result2=jdbc.receptionupdate(room);     // call the receptionupdate method of the JDBCroom object passing the RoomLibrary object as parameter
				

		        // Creates a new BookingLibrary3 object and sets its properties based on the text fields
				BookingLibrary1 booking = new BookingLibrary1();
				booking.setBookingID(Integer.parseInt(txtBookingID.getText()));
				booking.setBookingStatus("Inactive");
				JDBCBilling jdbc5 = new JDBCBilling();
				jdbc5.update(booking);

				InvoiceLibrary2 billing = new InvoiceLibrary2();
				String checkindate = ((JTextField)txtCheckInDate.getDateEditor().getUiComponent()).getText();
				String checkoutdate = ((JTextField)txtCheckOutDate.getDateEditor().getUiComponent()).getText();
				
				// Set billing information to the BillingLibs2 object
				billing.setBookingID(Integer.parseInt(txtBookingID.getText()));
				billing.setFullName(txtFullName.getText());
				billing.setCheckInDate(checkindate);
				billing.setCheckOutDate(checkoutdate);
				billing.setStayedDays(txtStayedDays.getText());
				billing.setDrinkAmount(Integer.parseInt(txtDrinkPrice.getText()));
				billing.setServiceAmount(Integer.parseInt(txtServicePrice.getText()));
				billing.setFoodAmount(Integer.parseInt(txtFoodPrice.getText()));
				billing.setRoomAmount(Integer.parseInt(txtRoomPrice.getText()));
				billing.setSubTotalAmount(Double.parseDouble(txtTotalAmount.getText()));
				billing.setDiscount(Double.parseDouble(txtDiscount.getText()));
				billing.setGrandTotal(Double.parseDouble(txtSubTotalAmount.getText()));
				billing.setBillingStatus(txtInvoiceStatus.getSelectedItem().toString());
				billing.setEmployeeID(ID);
				
		        
		     // Create a new JDBCBilling object and insert billing information to the database
				JDBCBilling jdbc1 = new JDBCBilling();
				boolean result = jdbc1.insertbilling(billing);
				
				// Display message and update the table based on the result of the database insertion
				if(result==true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Invoice Paid Successfully.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!! Invoice Payment Failed.");
				}
			}
		});
		
		// Update the table using the billing information from the database
		updateTable();

		frame.setVisible(true);
	}

	// Method to update the table with billing information from the database
	public void updateTable() {
	
		JDBCBilling jdbc2 = new JDBCBilling();
		ArrayList<?> select = jdbc2.selectinvoice(InvoiceLibrary);
		model.setRowCount(0);
		if (select.size() > 0) {
		
			for (int i = 0; i < select.size(); i++) {
				
	            // Get the billing information from the ArrayList and add it to the table
				InvoiceLibrary billing = (InvoiceLibrary) select.get(i);
			    
				@SuppressWarnings("rawtypes")
				Vector<Comparable> tmpPerson = new Vector<Comparable>();
		
				// This method adds the billing information of a person to the temporary list
				tmpPerson.add(billing.getBookingID());
				tmpPerson.add(billing.getFullName());
				tmpPerson.add(billing.getCheckInDate()); 
				tmpPerson.add(billing.getCheckOutDate());
				tmpPerson.add(billing.getRoomNo()); 
				tmpPerson.add(billing.getRoomPrice()); 
				tmpPerson.add(billing.getFoodPrice());
				tmpPerson.add(billing.getDrinkPrice());
				tmpPerson.add(billing.getServicePrice());
	
				// This method adds the temporary list to the table model
				model.addRow(tmpPerson);
			}
		}
	}
	//	Implementation of polymorphism and we have replaced the code in mouse clicked method
	@Override
	public void mouseClicked(MouseEvent e) {

		try {

			// Get the selected row
			int invoice1 = table1.getSelectedRow();

			// Get the table model
			TableModel model1 = table1.getModel();
			
			// Set the booking ID text field
			String bookingid = model1.getValueAt(invoice1, 0).toString();
			txtBookingID.setText(bookingid);
			BookingID = Integer.parseInt(txtBookingID.getText());

			// Set the full name text field
			String name = model1.getValueAt(invoice1, 1).toString();
			txtFullName.setText(name);
			FullName = txtFullName.getText();

			// Set the arrival date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model1.getValueAt(invoice1, 2));
			txtCheckInDate.setDate(date);

			// Set the departure date
			Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model1.getValueAt(invoice1, 3));
			txtCheckOutDate.setDate(date3);
			
			// Get the room id to text field
			String roomNo = model1.getValueAt(invoice1, 4).toString();
			txtRoomID.setText(roomNo);

			// Set the room rate text field
			String roomprice = model1.getValueAt(invoice1, 5).toString();
			txtRoomRate.setText(roomprice);


			// Set the food price text field
			String foodprice = model1.getValueAt(invoice1, 6).toString();
			txtFoodPrice.setText(foodprice);
			
			
			// Set the drink price text field
			String drinkamount = model1.getValueAt(invoice1, 7).toString();
			txtDrinkPrice.setText(drinkamount);
			
			// Set the service price text field
			String serviceprice = model.getValueAt(invoice1, 8).toString();
			txtServicePrice.setText(serviceprice);

			// Calculate the number of stay days
			String fromdate = ((JTextField) txtCheckInDate.getDateEditor().getUiComponent()).getText();
			String todate = ((JTextField) txtCheckOutDate.getDateEditor().getUiComponent()).getText();

			LocalDate fday = LocalDate.parse(fromdate);
			LocalDate tday = LocalDate.parse(todate);

			Long day_gap = ChronoUnit.DAYS.between(fday, tday);
			txtStayedDays.setText(String.valueOf(day_gap));

			// Calculate the room price
			int rate = Integer.parseInt(txtRoomRate.getText());
			int days = Integer.parseInt(txtStayedDays.getText());
			int result = rate * days;
			txtRoomPrice.setText(String.valueOf(result));


			// Parsing values from text fields and assigning to variables
			drinkprice1 = Integer.parseInt(txtDrinkPrice.getText());
			room_price1 = Integer.parseInt(txtRoomPrice.getText());
			serviceprice1 = Integer.parseInt(txtServicePrice.getText());
			food_price1 = Integer.parseInt(txtFoodPrice.getText());
			

			// Calculating the total amount
			TotalAmount = room_price1 + serviceprice1 + food_price1 + drinkprice1;

			// Calculating the tax amount
			float TAX13 = (float) 0.13;
			TAXAmount = TAX13 * TotalAmount;

			// Adding tax, service charge and room charges and then adding 200 as base charge
			Service_Charge = 500;
			SubTotal = TAXAmount + TotalAmount + Service_Charge;

			// Calculating the discount amount
			
			Discount = SubTotal * (float) 0.10;

			// Calculating the final amount after discount
			GrandTotal = SubTotal - Discount;

			// Setting the values of discount and total amount in text fields
			txtVAT.setText(Float.toString(TAXAmount));
			txtSubTotalAmount.setText(Float.toString(SubTotal));
			txtDiscount.setText(Float.toString(Discount));
			txtTotalAmount.setText(Float.toString(GrandTotal));

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

	// Empty methods for mouse press, release, enter and exit
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