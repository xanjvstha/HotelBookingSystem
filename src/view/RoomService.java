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
//import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

import controller.JDBCRoomService;
//import model.RestaurantLibrary;
import model.RoomLibrary;

//Room class extends JFrame and implements ActionListener
public class RoomService implements ActionListener, MouseListener {
	
	// This code declares and initializes several Swing components for a hotel room management system.
	JFrame frame;
	JLabel lblRoom, lblRoomNo, lblRoomStatus, lblRoomType, lblRoomPrice, HotelRoom;
	Object[] columnsName, column;
	JComboBox<?> txtRoomStatus, txtRoomType;
	DefaultTableModel model, model2;
	JTextField txtRoomPrice, txtRoomNo;
	JButton btnBook;
	JPanel Room, center, panel;
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table;
	JScrollPane scrollpane;
	JButton btnupdate, btnsearch;
	ArrayList<RoomLibrary> a1;

	/**
	 * Constructor for the Room class. Sets the size and title of the frame, and 
	 * initializes and lays out the components of the UI. 
	 */	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RoomService() {
		frame = new JFrame("Employee Registration");
		// setting the frame size, title, layout and location
		frame.setSize(1200, 600);
		frame.setTitle("Add Room");
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		// Create a panel for the north of the frame color, size, layout
		JPanel north = new JPanel();
		north.setBackground(new Color(106, 101, 101));
		north.setPreferredSize(new Dimension(10, 80));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		// Create a label for the room information
		lblRoom = new JLabel("ROOM INFORMATION");
		lblRoom.setFont(new Font("Serif", Font.BOLD, 35));
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBounds(550, 0, 450, 100);
		north.add(lblRoom);

		// Create a panel for the west of the frame
		JPanel west = new JPanel();
		west.setBackground(new Color(106, 101, 101));
		west.setPreferredSize(new Dimension(350, 80));
		west.setLayout(null);
		frame.add(west, BorderLayout.WEST);

		// Create a label Room Status size, color, layout
		lblRoomStatus = new JLabel("Room Status");
		lblRoomStatus.setForeground(Color.WHITE);
		lblRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomStatus.setBounds(10, 50, 150, 30);
		west.add(lblRoomStatus);
		
		//creating JComboBox and setting its attributes
		txtRoomStatus = new JComboBox<Object>();
		txtRoomStatus.setModel(new DefaultComboBoxModel(new String[] { "Available", "Booked" }));
		txtRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomStatus.setBounds(180, 50, 150, 30);
		west.add(txtRoomStatus);

		//creating JLabel and setting its attributes
		lblRoomType = new JLabel("Room Type");
		lblRoomType.setForeground(Color.WHITE);
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomType.setBounds(10, 100, 150, 30);
		west.add(lblRoomType);
		
		//creating JComboBox and setting its attributes
		txtRoomType = new JComboBox<Object>();
		txtRoomType.setModel(new DefaultComboBoxModel(new String[] { "Single", "Double",  "Twin", "Queen", "King", "Suite", "Presidential Suite" }));
		txtRoomType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomType.setBounds(180, 100, 150, 30);
		west.add(txtRoomType);

		// Room Price label
		lblRoomPrice = new JLabel("Room Price");
		lblRoomPrice.setForeground(Color.WHITE);
		lblRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomPrice.setBounds(10, 150, 200, 30);
		west.add(lblRoomPrice);
		
		// Room Price text field
		txtRoomPrice = new JTextField();
		txtRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomPrice.setBounds(180, 150, 150, 30);
		west.add(txtRoomPrice);

		// Creating a label for Room No., color, size, position, west panel
		lblRoomNo = new JLabel("Room No");
		lblRoomNo.setForeground(Color.WHITE);
		lblRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomNo.setBounds(10, 200, 200, 30);
		west.add(lblRoomNo);
		
		// Creating a text field for Room No., color, size, position, west panel
		txtRoomNo = new JTextField();
		txtRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomNo.setBounds(180, 200, 150, 30);
		west.add(txtRoomNo);

		// Creating a center panel for the table
		center = new JPanel();
		center.setLayout(null);
		frame.add(center);

		// Creating a button for adding a room
		btnBook = new JButton("Add Room");
		btnBook.setForeground(Color.WHITE);
		btnBook.setBackground(Color.DARK_GRAY);
		btnBook.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBook.setBounds(180, 250, 150, 30);
		west.add(btnBook);
		btnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RoomLibrary room = new RoomLibrary();
				
				int id = Integer.parseInt(txtRoomNo.getText());
				String item = txtRoomType.getSelectedItem().toString();
				int price = Integer.parseInt(txtRoomPrice.getText());
				String roomcombobox = txtRoomStatus.getSelectedItem().toString();
				
				room.setRoomNo(id);
				room.setRoomType(item);
				room.setRoomPrice(price);
				room.setRoomStatus(roomcombobox);
			
			    JDBCRoomService jdbc = new JDBCRoomService(); // Create a new JDBCroom object
			    boolean result = jdbc.insert(room); // Insert the room object into the database using the insert method of the JDBCroom class
				if (result == true) {
					updateTable();
			        JOptionPane.showMessageDialog(null, " Room Added sucessfully."); // Display a success message if the room was added successfully

				} else {
			        JOptionPane.showMessageDialog(null, "Error!! Room Adding Failed."); // Display an error message if the room was not added
				}
			}
		});
		
		// create an object array with 8 elements for the column names
		columnsName = new Object[4];
		columnsName[0] = "Room No";
		columnsName[1] = "Room Type";
		columnsName[2] = "Room Price";
		columnsName[3] = "Room Status";
		
		// create a JTable and set its model with the default table model
		table = new JTable();
		
		// set column identifiers for the model with the column names array
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		// Add the JTable to a scroll pane and add the scroll pane to the panel
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(10, 10, 820, 460);
		center.add(scroll1, BorderLayout.CENTER);
		
		// call updateTable method to populate data in the table
		updateTable();

		frame.setVisible(true);
	}
	
	public void updateTable() {
		a1 = new JDBCRoomService().selectall();
		model.setRowCount(0);
		
		for (RoomLibrary room : a1) {
			Object tmpRow[] = { 
					room.getRoomNo(),
					room.getRoomType(),
					room.getRoomPrice(),
					room.getRoomStatus()
			};
			model.addRow(tmpRow);
		}
		table = new JTable(model);
	}
	//main method to run the program
	public static void main(String[] args) {
		new RoomService();
	}

@Override
public void mouseClicked(MouseEvent e) {	
}

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

@Override
public void actionPerformed(ActionEvent e) {
}
}