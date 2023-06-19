package view;

//Importing necessary libraries
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;


@SuppressWarnings("serial")
public class InvoicePrint extends JFrame {
	JPanel center;
	JFrame frame;

	// Default constructor to set the contents of the frame
	public InvoicePrint(String fullname, int bookingid, float totalamount, float grandtotal, 
			float subtotal, float discount, float service_charge,
			float roomprice1, float serviceprice1, float foodprice1,
			float drinkprice1, float taxamount)	
	{
		String FN = fullname;
		String BID = Integer.toString(bookingid);
		String GT = Float.toString(grandtotal);
		String TA = Float.toString(totalamount);
		String ST = Float.toString(subtotal);
		String DC = Float.toString(discount);
		String RP = Float.toString(roomprice1);
		String SP = Float.toString(serviceprice1);
		String FP = Float.toString(foodprice1);
		String DP = Float.toString(drinkprice1);
		String TX = Float.toString(taxamount);
		String SC = Float.toString(service_charge);
		
		// Creates a JFrame object and sets its properties
		frame = new JFrame("Invoice");
		frame.setSize(750, 650);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		// Setting the frame properties
		setTitle("Invoice Print");
		setSize(500, 650);	
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		
		// Initializing and allocating memory for the center panel
		center = new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100, 100));
		add(center, BorderLayout.CENTER);
		
		// Creating and adding a Print Bill button
		JButton tbn=new JButton("Print Bill");
		tbn.setBounds(20,450,100,20);
		center.add(tbn);
		tbn.addActionListener(new ActionListener() {
			
			// Implementing polymorphism and replacing the code in actionPerformed method
			public void actionPerformed(ActionEvent ae)
			{
				PrinterJob job = PrinterJob.getPrinterJob();
	            job.setJobName("Print Details");
	            
	            job.setPrintable(new Printable()
	            {
	            	public int print(Graphics page,PageFormat format, int pageNo)
	            	{
	            		format.setOrientation(PageFormat.LANDSCAPE);
	            		if (pageNo > 0) 
	            		{
	            			return Printable.NO_SUCH_PAGE;
	            		}
	                
	            		// Casting Graphics to Graphics2D
	            		Graphics2D InvoicePrint = (Graphics2D)page;
	                
	            		// Translating the graphics to the origin
	            		InvoicePrint.translate(format.getImageableX(), format.getImageableY());
	                
	            		// Scaling the graphics to fit the page
	            		InvoicePrint.scale(0.85,0.70);
	                
	            		// Printing the center panel to the graphics object
	            		center.print(InvoicePrint);
	         
	            		return Printable.PAGE_EXISTS;
	                                         
	            	}
	            });
	            boolean ok = job.printDialog();
	            if (ok)
	            {
	            	try
	            	{
	            		job.print();
	            	}
	            	catch (PrinterException ex)
	            	{
	            	ex.printStackTrace();
	            	}
	            }
			}
		});
				
		// Creating and adding a heading label
		JLabel heading = new JLabel("LUTON HOTEL");
		heading.setFont(new Font("Times New Roman",Font.BOLD,40));
		heading.setBounds(105,20,450,35);
		center.add(heading);
		
		// Creating and adding a subheading label
		JLabel heading2 = new JLabel("Luton, United Kingdom");
		heading2.setFont(new Font("Times New Roman",Font.BOLD,20));
		heading2.setBounds(150,55,480,30);
		center.add(heading2);
		
		// Creating and adding a subheading label
		JLabel heading3 = new JLabel("Tel No: +442035816570");
		heading3.setFont(new Font("Times New Roman",Font.PLAIN,20));
		heading3.setBounds(150,85,480,30);
		center.add(heading3);
		
		// Creating and adding a separator label
		JSeparator lineborder = new JSeparator();
		lineborder.setBounds(0,120,500,30);
		center.add(lineborder);

		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = simpledate.format(date);
		
		JLabel currentdatelbl = new JLabel("Date: - ");
		currentdatelbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		currentdatelbl.setBounds(300, 130, 150, 30);
		center.add(currentdatelbl);
		
		JLabel datelbl = new JLabel();
		datelbl.setText(currentDate);
		datelbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		datelbl.setBounds(370, 130, 150, 30);
		center.add(datelbl);
		
		// Creating and adding a label for Invoice No
		JLabel invoice=new JLabel("Invoice No: ");
		invoice.setFont(new Font("Times New Roman",Font.BOLD,18));
		invoice.setBounds(10,130,150,30);
		center.add(invoice);
		
		// Create a new instance of the Random class
		@SuppressWarnings("unused")
		Random rand=new Random();
		
		// Generate a random integer between 1 and 500
		int random=(int) (Math.random()*4900+900);
		
		// Create a new label for the invoice number and set its text
		JLabel lblInvoice=new JLabel();
		lblInvoice.setText(String.valueOf(random));
		lblInvoice.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblInvoice.setBounds(160,130,150,30);
		center.add(lblInvoice);
		
		// Create a new label for the full name and set its text
		JLabel lblFullName=new JLabel("Full Name: ");
		lblFullName.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblFullName.setBounds(10,170,150,30);
		center.add(lblFullName);
		
		// Create a new label for the name and set its text
		JLabel lblname=new JLabel(FN);
		lblname.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblname.setBounds(160,170,150,30);
		center.add(lblname);
		
		JLabel lblBookingID=new JLabel("Booking ID: ");
		lblBookingID.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblBookingID.setBounds(10,210,150,30);
		center.add(lblBookingID);
		
		// Create a new label for the name and set its text
		JLabel lblbooking=new JLabel(BID);
		lblbooking.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblbooking.setBounds(160,210,150,30);
		center.add(lblbooking);
		
		// Creating and adding a separator label
		JSeparator lineborder2 = new JSeparator();
		lineborder2.setBounds(0,250,500,30);
		center.add(lineborder2);
		
		// Create a new label for the room amount and set its text
		JLabel lblRoomAmount=new JLabel("Room Amount: ");
		lblRoomAmount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblRoomAmount.setBounds(10,260,150,30);
		center.add(lblRoomAmount);
		
		// Create a new label for the room and set its text
		JLabel lblRoom=new JLabel(RP);
		lblRoom.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblRoom.setBounds(160,260,150,30);
		center.add(lblRoom);
		
		// Create a new label for the service amount and set its text
		JLabel lblServiceAmount=new JLabel("Service Amount: ");
		lblServiceAmount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblServiceAmount.setBounds(10,300,150,30);
		center.add(lblServiceAmount);
		
		// Create a new label for the service and set its text
		JLabel lblService=new JLabel(SP);
		lblService.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblService.setBounds(160,300,150,30);
		center.add(lblService);
		
		// Create a new label for the food amount and set its text
		JLabel lblFoodAmount=new JLabel("Food Amount: ");
		lblFoodAmount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblFoodAmount.setBounds(10,340,150,30);
		center.add(lblFoodAmount);
		
		// Create a new label for the food and set its text
		JLabel lblFood=new JLabel(FP);
		lblFood.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblFood.setBounds(160,340,150,30);
		center.add(lblFood);
		
		// Create a label for displaying the bar amount
		JLabel lblBarAmount=new JLabel("Bar Amount: ");
		lblBarAmount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblBarAmount.setBounds(10,380,150,30);
		center.add(lblBarAmount);
		
		// Create a label for displaying the bar
		JLabel lblBar=new JLabel(DP);
		lblBar.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblBar.setBounds(160,380,150,30);
		center.add(lblBar);
		
		// Create a label for displaying a separator
		JSeparator lineborder1 = new JSeparator();
		lineborder1.setBounds(0,430,500,30);
		center.add(lineborder1);
		
		// Create a label for displaying the total amount
		JLabel lblTotalBill=new JLabel("Total Amount: ");
		lblTotalBill.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblTotalBill.setBounds(200,450,150,30);
		center.add(lblTotalBill);
		
		// Create a label for displaying the total bill amount
		JLabel lblBill=new JLabel(TA);
		lblBill.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblBill.setBounds(380,450,150,30);
		center.add(lblBill);
		
		// Create a label for displaying the discount price
		JLabel lblTaxAmount=new JLabel("13% Tax Amount: ");
		lblTaxAmount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblTaxAmount.setBounds(200,470,200,30);
		center.add(lblTaxAmount);
		
		// Create a label for displaying the total bill amount
		JLabel lblTax=new JLabel(TX);
		lblTax.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblTax.setBounds(380,470,150,30);
		center.add(lblTax);
		
		// Create a label for displaying the discount price
		JLabel lblServiceCharge=new JLabel("Service Charge: ");
		lblServiceCharge.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblServiceCharge.setBounds(200,490,150,30);
		center.add(lblServiceCharge);
		
		// Create a label for displaying the discount amount
		JLabel lblServicecrg=new JLabel(SC);
		lblServicecrg.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblServicecrg.setBounds(380,490,150,30);
		center.add(lblServicecrg);
		
		// Create a label for displaying the discount price
		JLabel lblSubTotal=new JLabel("SubTotal Amount: ");
		lblSubTotal.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblSubTotal.setBounds(200,510,200,30);
		center.add(lblSubTotal);
		
		// Create a label for displaying the discount amount
		JLabel lblsubtotl=new JLabel(ST);
		lblsubtotl.setFont(new Font("Times New Roman",Font.PLAIN,18));
		lblsubtotl.setBounds(380,510,150,30);
		center.add(lblsubtotl);
		
		// Create a label for displaying the discount price
		JLabel lblDiscount=new JLabel("Discount Price:          - ");
		lblDiscount.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblDiscount.setBounds(200,530,200,30);
		center.add(lblDiscount);
		
		// Create a label for displaying the discount amount
		JLabel discountlbl=new JLabel(DC);
		discountlbl.setFont(new Font("Times New Roman",Font.PLAIN,18));
		discountlbl.setBounds(380,530,150,30);
		center.add(discountlbl);
		
		// Creating and adding a separator label
		JSeparator lineborder3 = new JSeparator();
		lineborder3.setBounds(0,560,500,30);
		center.add(lineborder3);
		
		// Create a label for displaying the paid amount
		JLabel paid=new JLabel("Grand Total: ");
		paid.setFont(new Font("Times New Roman",Font.BOLD,18));
		paid.setBounds(200, 570,150,30);
		center.add(paid);
		
		// Create a label for displaying the paid amount value
		JLabel paidlbl=new JLabel(GT);
		paidlbl.setFont(new Font("Times New Roman",Font.PLAIN,18));
		paidlbl.setBounds(380,570,150,30);
		center.add(paidlbl);
		
		// sets the frame visible
		setVisible(true);
	}
}