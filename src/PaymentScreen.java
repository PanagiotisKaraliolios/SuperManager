import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.table.*;
import javax.print.*;
/*
 * Created by JFormDesigner on Mon May 18 16:57:19 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
@SuppressWarnings("serial")
public class PaymentScreen extends JInternalFrame {
	
	private ArrayList<Integer> ids = new ArrayList<>();
	private ArrayList<Integer> quantities = new ArrayList<>();/*those two arrayLists are used to store the data from
																form the ScanProductScreen list to store them in 
																mySQL table sales
															   */
	public PaymentScreen(ArrayList<Integer> productID,ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices) {
		initComponents();
		fillTable(Names, Quantities,Prices);
		ids = productID;
		quantities = Quantities;
		totalCalculation(Quantities,Prices);
		this.setLocation(100, 30);
		showDate();
		//this.addInternalFrameListener(new);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		
	
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		label1 = new JLabel();
		textField1 = new JTextField();
		button1 = new JButton(); //check points button
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					checkPointsButtonAction(e);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button2 = new JButton(); //print button
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				printButtonAction(e);
			}
		});
		textField2 = new JTextField();
		button3 = new JButton(); //aply discount button
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				applyDiscountButtonAction(e);
			}
		});
		button4 = new JButton();
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				finishButtonAction(e);
			}
		});
		label2 = new JLabel();
		textField3 = new JTextField();
		label5 = new JLabel();
		textField5 = new JTextField();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setResizable(true);
				this.setClosable(true);
				this.setTitle("Payment");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"NAME", "PRICE", "QUANTITY"
						}
						
					)
					{
						Class<?>[] columnTypes = new Class<?>[] {
						String.class, Double.class, Integer.class};
						
						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
					table1.setAutoCreateRowSorter(true);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(305, 5, 520, 500);

				//---- label1 ----
				label1.setText("Member/Card ID");
				contentPane.add(label1);
				label1.setBounds(20, 100, 100, label1.getPreferredSize().height);
				contentPane.add(textField1);
				textField1.setBounds(130, 95, 160, 30);

				//---- button1 ----
				button1.setText("Check points");
				button1.setIcon(new ImageIcon(getClass().getResource("/search.png")));
				contentPane.add(button1);
				button1.setBounds(140, 135, 140, 40);

				//---- button2 ----
				button2.setText("Print");
				button2.setIcon(new ImageIcon(getClass().getResource("/print.png")));
				contentPane.add(button2);
				button2.setBounds(new Rectangle(new Point(105, 460), button2.getPreferredSize()));
				contentPane.add(textField2);
				textField2.setBounds(10, 185, 280, 30);
				textField2.setEditable(false);

				//---- button3 ----
				button3.setText("Apply Discount");
				button3.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(button3);
				button3.setBounds(140, 220, 140, 40);

				//---- button4 ----
				button4.setText("Finish");
				button4.setIcon(new ImageIcon(getClass().getResource("/checkMark2.png")));
				contentPane.add(button4);
				button4.setBounds(95, 400, 110, 45);

				//---- label2 ----
				label2.setText("Total");
				label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
				contentPane.add(label2);
				label2.setBounds(new Rectangle(new Point(140, 355), label2.getPreferredSize()));
				contentPane.add(textField3);
				textField3.setBounds(185, 350, 100, 30);
				textField3.setEditable(false);
				//do sum of cost

				//---- label5 ----
				label5.setText("Date");
				label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
				contentPane.add(label5);
				label5.setBounds(70, 20, 50, 16);

				//---- textField5 ----
				textField5.setEditable(false);
				contentPane.add(textField5);
				textField5.setBounds(130, 15, 150, 28);
			}
			panel1.add(this);
			this.setBounds(0, 0, 840, 540);

			panel1.setPreferredSize(new Dimension(840, 540));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JLabel label1;
	private JTextField textField1; //ID field
	private JButton button1;
	private JButton button2;
	private JTextField textField2; //Apply Discount Field
	private JButton button3;
	private JButton button4;
	private JLabel label2;
	private JTextField textField3; //Total field
	private JLabel label5;
	private JTextField textField5;
	private static  String DateFormat = "yyyy-MM-dd";
	private boolean hasThePaymentFinished = false;
	private boolean hasDiscountAlreadyApplied = false;
	private double total=0;
	private double discount = 0;
	private double limit = 10;
	private int points = -1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	private void fillTable(ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices)
	{
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		for(int i=0; i<Names.size(); i++)
		model.addRow(new Object[] {Names.get(i), Prices.get(i), Quantities.get(i)});
	}
	
	private void checkPointsButtonAction(ActionEvent e) throws SQLException,ClassNotFoundException
	{
		//get input id
		String inputID = textField1.getText();
		//connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		//retrieve member points
		rs = stm.executeQuery("SELECT points FROM members WHERE memberCardID = '" + inputID + "'");
		
		
		while(rs.next())
			points = rs.getInt("points");
		
		if(points == -1)
		{
			JOptionPane.showMessageDialog(null, "Given member ID doesnt exist", "ERROR",2);
		}
		else
		{
			//Assuming discount by 6€ on 200 points
			if(points>=200)
			{
				discount = 6;
				textField2.setText("Applicable discount of " + discount + "€");
			}
			else				
			{
				JOptionPane.showMessageDialog(null, "No potential discount!", "Notification", 1);
				textField2.setText("");
			}
		}
		
		stm.close();
		con.close();
		
	}
	
	private void applyDiscountButtonAction(ActionEvent e)
	{
		//get discount
		if(hasDiscountAlreadyApplied==false) {
			
			if(!textField2.getText().equals("") && total > limit) 
			{
				
				total = total - discount;
				
				textField3.setText("" + total + "€");
				if((points - 200) >= 0) {
					points = points - 200;
				}
				else {
					points = 0;
				}
				
				hasDiscountAlreadyApplied = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Potential discount not calculated\nOr the purchase is lower than 10 €", "ERROR",2);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Discount already applied!", "ERROR",1);
		}
		
	}
	
	                                                                           
	private void finishButtonAction(ActionEvent e)//when the finish button is pushed this method sends the data 
	{											 //about the products that the cashier scanned to mySQL table sales
		if(hasThePaymentFinished==false) {
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
				
				String sql1 =" INSERT INTO sales(id,date,quantity) VALUES (?,?,?)";
				String sql2 =" UPDATE sales SET quantity = quantity + ? WHERE id=? AND date=?";
				
				PreparedStatement ps2 = con.prepareStatement(sql2);
		        PreparedStatement ps1 = con.prepareStatement(sql1);
		        
		        
		        String DateFormat = "yyyy-MM-dd";
				Calendar cal= Calendar.getInstance();
			    SimpleDateFormat format = new SimpleDateFormat(DateFormat);
	
			   for (int i=0; i<ids.size();i++)
			   {
				   
				   
				   if (checkExistanceOfRecord(ids.get(i),format,cal))//if the record already exists update only the quantity of that record
				   {
					   ps2.setInt(1, quantities.get(i));
					   ps2.setInt(2, ids.get(i));
					   ps2.setDate(3, java.sql.Date.valueOf(format.format(cal.getTime())));
					   ps2.executeUpdate(); 
					   
				   }
				   else //else add the record to the sales table
				   {
					   ps1.setInt(1, ids.get(i));
					   ps1.setDate(2, java.sql.Date.valueOf(format.format(cal.getTime())));
					   ps1.setInt(3, quantities.get(i)); 
					   ps1.executeUpdate(); 
				   }
				   
			   }
			   
			   ps1.close();
			   ps2.close();
			   stm = con.createStatement();
			   hasThePaymentFinished = true;
			   decreaseStock();
			   calculateNewPoints();
			   JOptionPane.showMessageDialog(null, "The Transaction completed successfully!", "Info",1);
			   
			}
			catch(Exception ex)
			{
				System.out.println("Error1: "+ex);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "The Transaction has already been made!", "Info",1);
		}
	}
	
	private void calculateNewPoints() {
		int addedPoints = (int) (Math.floor(total));
		points = points + addedPoints;
	}
	
	private void decreaseStock()//decreases the stock if it's not zero
	{	
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
				
				String sql =" UPDATE products SET stock = stock - ? WHERE id = ? ";
				PreparedStatement ps = con.prepareStatement(sql);
				
				
				int anID = 0;
				for (int i=0; i<ids.size();i++)
				{
					anID = ids.get(i);
					if(getStock(anID)>0)
					{
						ps.setInt(1, quantities.get(i));
						ps.setInt(2, anID);
						ps.executeUpdate(); 
					}
				}
				ps.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
	}
	
	private int getStock(int id)//gets the stock from the data base 
	{
		Connection con;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
			
			String sql = "SELECT stock FROM products WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			
			rs.next();
			int takenStock = rs.getInt("stock");
			
			return takenStock;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
	}
	
	private  boolean checkExistanceOfRecord(int id,SimpleDateFormat format,Calendar cal)
	{
		try 
		{  
			String sql = " SELECT id,date FROM sales WHERE id = ? AND date = ?";  
	    	PreparedStatement ps = con.prepareStatement(sql);
	    	ps.setInt(1, id);
	    	ps.setDate(2, java.sql.Date.valueOf(format.format(cal.getTime())));
	    	ResultSet rs = ps.executeQuery();

	        return rs.next();
	    }
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
		return false;
	  
	}
	
	private void printButtonAction(ActionEvent e1)
	{
		System.out.println(e1);
		MessageFormat header = new MessageFormat("Legitimate Invoice Start");
		MessageFormat footer = new MessageFormat("Invoice End------TOTAL : " + total + " €");
		
		
		try {
			table1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
		} catch (PrinterException e2) {
			
			e2.printStackTrace();
			System.err.format("Cannot print %%n", e2.getMessage());
		}
		
	}
	
	private void showDate()
    {
      Calendar cal= Calendar.getInstance();
      SimpleDateFormat format = new SimpleDateFormat(DateFormat);
      textField5.setText(format.format(cal.getTime()));        
    }
	
	private void totalCalculation(ArrayList<Integer> Quantities, ArrayList<Double> Prices) {
		
		for(int i=0; i<Prices.size();i++) {
			total=total+Quantities.get(i)*Prices.get(i);
			
		}

		total = (double)Math.round(total* 1000) / 1000;
		
		textField3.setText(Double.toString(total) + " €");
	}
	
	
}
