import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.*;




@SuppressWarnings("serial")
public class PaymentScreen extends JInternalFrame {
	
	private ArrayList<Integer> ids = new ArrayList<>();			//these two arrayLists are used to store the data
	private ArrayList<Integer> quantities = new ArrayList<>();	//form the ScanProductScreen list to store them in
																//mySQL table sales
														      
															   
	public PaymentScreen(ArrayList<Integer> productID,ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices) {		//Payment Screen Constructor
		initComponents();
		fillTable(Names, Quantities,Prices);
		ids = productID;
		quantities = Quantities;
		totalCalculation(Quantities,Prices);
		this.setLocation(100, 30);
		showDate();
		
	}

	private void initComponents() {
		
		
	
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		memberIDlabel = new JLabel();
		idTextField = new JTextField();
		checkPointsButton = new JButton(); //check points button
		
		checkPointsButton.addActionListener(new ActionListener() {
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
		
		printButton = new JButton(); //print button
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				printButtonAction(e);
			}
		});
		
		discountTextField = new JTextField();
		applyDiscountButton = new JButton(); //apply discount button
		applyDiscountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				applyDiscountButtonAction(e);
			}
		});
		
		finishButton = new JButton();
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				finishButtonAction(e);
			}
		});
		
		totalLabel = new JLabel();
		totalTextField = new JTextField();
		dateLabel = new JLabel();
		dateTextField = new JTextField();

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
				memberIDlabel.setText("Member/Card ID");
				contentPane.add(memberIDlabel);
				memberIDlabel.setBounds(20, 100, 100, memberIDlabel.getPreferredSize().height);
				contentPane.add(idTextField);
				idTextField.setBounds(130, 95, 160, 30);

				//---- button1 ----
				checkPointsButton.setText("Check points");
				checkPointsButton.setIcon(new ImageIcon(getClass().getResource("/search.png")));
				contentPane.add(checkPointsButton);
				checkPointsButton.setBounds(140, 135, 140, 40);

				//---- button2 ----
				printButton.setText("Print");
				printButton.setIcon(new ImageIcon(getClass().getResource("/print.png")));
				contentPane.add(printButton);
				printButton.setBounds(new Rectangle(new Point(105, 460), printButton.getPreferredSize()));
				contentPane.add(discountTextField);
				discountTextField.setBounds(10, 185, 280, 30);
				discountTextField.setEditable(false);

				//---- button3 ----
				applyDiscountButton.setText("Apply Discount");
				applyDiscountButton.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(applyDiscountButton);
				applyDiscountButton.setBounds(140, 220, 140, 40);

				//---- button4 ----
				finishButton.setText("Finish");
				finishButton.setIcon(new ImageIcon(getClass().getResource("/checkMark2.png")));
				contentPane.add(finishButton);
				finishButton.setBounds(95, 400, 110, 45);

				//---- label2 ----
				totalLabel.setText("Total");
				totalLabel.setFont(totalLabel.getFont().deriveFont(totalLabel.getFont().getSize() + 4f));
				contentPane.add(totalLabel);
				totalLabel.setBounds(new Rectangle(new Point(140, 355), totalLabel.getPreferredSize()));
				contentPane.add(totalTextField);
				totalTextField.setBounds(185, 350, 100, 30);
				totalTextField.setEditable(false);
				//do sum of cost

				//---- label5 ----
				dateLabel.setText("Date");
				dateLabel.setFont(dateLabel.getFont().deriveFont(dateLabel.getFont().getSize() + 2f));
				contentPane.add(dateLabel);
				dateLabel.setBounds(70, 20, 50, 16);

				//---- textField5 ----
				dateTextField.setEditable(false);
				contentPane.add(dateTextField);
				dateTextField.setBounds(130, 15, 150, 28);
			}
			panel1.add(this);
			this.setBounds(0, 0, 840, 540);

			panel1.setPreferredSize(new Dimension(840, 540));
		}
		
		
		
	}

	
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JLabel memberIDlabel;
	private JTextField idTextField; //ID field
	private JButton checkPointsButton;
	private JButton printButton;
	private JTextField discountTextField; //Apply Discount Field
	private JButton applyDiscountButton;
	private JButton finishButton;
	private JLabel totalLabel;
	private JTextField totalTextField; //Total field
	private JLabel dateLabel;
	private JTextField dateTextField;
	private static  String DateFormat = "yyyy-MM-dd";
	private boolean hasThePaymentFinished = false;
	private boolean hasDiscountAlreadyApplied = false;
	private double total=0;
	private double discount = 0;
	private double limit = 10;
	private int points = -1;
	
	
	private void fillTable(ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices)
	{
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		for(int i=0; i<Names.size(); i++)
		model.addRow(new Object[] {Names.get(i), Prices.get(i), Quantities.get(i)});
	}
	
	private void checkPointsButtonAction(ActionEvent e) throws SQLException,ClassNotFoundException
	{
		//get input id
		String inputID = idTextField.getText();
		//connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		//retrieve member points
		rs = stm.executeQuery("SELECT points FROM members WHERE memberCardID = '" + inputID + "'");
		
		
		rs.next();
		points = rs.getInt("points");
		
		if(points == -1)//Points used as flag here
		{
			JOptionPane.showMessageDialog(null, "Given member ID doesnt exist", "ERROR",2);
		}
		else
		{
			//Assuming discount by 6� on 200 points
			if(points>=200)
			{
				discount = 6;
				discountTextField.setText("Applicable discount of " + discount + "�");
			}
			else				
			{
				JOptionPane.showMessageDialog(null, "No potential discount!", "Notification", 1);
				discountTextField.setText("");
			}
		}
		
		stm.close();
		con.close();
		
	}
	
	private void applyDiscountButtonAction(ActionEvent e)
	{
		if (hasThePaymentFinished == false)
		{
			//get discount
			if(hasDiscountAlreadyApplied==false) {
				
				if(!discountTextField.getText().equals("") && total > limit) 
				{
					
					total = total - discount;
					
					totalTextField.setText("" + total + "�");
					
					decresePointsInDB();
					hasDiscountAlreadyApplied = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Potential discount not calculated\nOr the purchase is lower than 10 �", "ERROR",2);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Discount already applied!", "ERROR",1);
			}
	    }
		else
		{
			JOptionPane.showMessageDialog(null, "You can not apply any discount if the transaction is finished!", "ERROR",1);
		}
	}
	
	                                                                           
	private void finishButtonAction(ActionEvent e)	//when the finish button is pushed this method sends the data 
	{											 	//about the products that the cashier scanned to mySQL table sales
		if(hasThePaymentFinished==false) {
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
				
				String sql1 =" INSERT INTO sales(id,date,quantity) VALUES (?,?,?)";
				String sql2 =" UPDATE sales SET quantity = quantity + ? WHERE id=? AND date=?";
				
				PreparedStatement ps2 = con.prepareStatement(sql2);
		        PreparedStatement ps1 = con.prepareStatement(sql1);
		        
		        
				Calendar cal= Calendar.getInstance();
			    SimpleDateFormat format = new SimpleDateFormat(DateFormat);
	
			   for (int i=0; i<ids.size();i++)
			   {
				   
				   
				   if (checkExistanceOfRecordInSales(ids.get(i),format,cal))//if the record already exists update only the quantity of that record
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
			   //calculateNewPoints();
			   addPointsInDB();
			   con.close();
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
	
	
	private void addPointsInDB()
	{
		String inputID = idTextField.getText();
		
		if(inputID != "")
		{
			if (checkExistanceOfMember(inputID))
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
					
					String sql =" UPDATE members SET points = points + ? WHERE memberCardID = ? ";
					PreparedStatement ps = con.prepareStatement(sql);
					
					int addedPoints = (int) (Math.floor(total));
					ps.setInt(1, addedPoints);
					ps.setString(2, inputID);
					ps.executeUpdate(); 
					
					con.close();
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		}
		
	}
	
	private void decresePointsInDB()
	{
		String inputID = idTextField.getText();
		
		if(inputID != "")
		{
			if (checkExistanceOfMember(inputID))
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
					
					String sql =" UPDATE members SET points = points - ? WHERE memberCardID = ? ";
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setInt(1, 200);
					ps.setString(2, inputID);
					ps.executeUpdate(); 
					
					con.close();
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		}
		
	}
	
	
	
	private  boolean checkExistanceOfMember(String memberID)
	{
		try 
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
			
			String sql = " SELECT memberCardID FROM members WHERE memberCardID = ? ";  
	    	PreparedStatement ps = con.prepareStatement(sql);
	    	ps.setString(1, memberID);
	    	ResultSet rs = ps.executeQuery();
	    	
	        return rs.next();
	    }
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	
		return false;
	  
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
				con.close();
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
			
			con.close();
			
			return takenStock;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
	}
	
	private  boolean checkExistanceOfRecordInSales(int id,SimpleDateFormat format,Calendar cal)
	{
		try 
		{  
			String sql = " SELECT id,date FROM sales WHERE id = ? AND date = ?";  
	    	PreparedStatement ps = con.prepareStatement(sql);
	    	ps.setInt(1, id);
	    	ps.setDate(2, java.sql.Date.valueOf(format.format(cal.getTime())));
	    	ResultSet rs = ps.executeQuery();
	    	
	        boolean flag = rs.next();
	        ps.close();
	    	return flag;
	        
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
		MessageFormat footer = new MessageFormat("Invoice End------TOTAL : " + total + " �");
		
		
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
      dateTextField.setText(format.format(cal.getTime()));        
    }
	
	private void totalCalculation(ArrayList<Integer> Quantities, ArrayList<Double> Prices) {
		
		for(int i=0; i<Prices.size();i++) {
			total=total+Quantities.get(i)*Prices.get(i);
			
		}

		total = (double)Math.round(total* 1000) / 1000;
		
		totalTextField.setText(Double.toString(total) + " �");
	}
	
	
}
