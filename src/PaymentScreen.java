import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Mon May 18 16:57:19 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
@SuppressWarnings("serial")
public class PaymentScreen extends JInternalFrame {
	private ArrayList<Integer> ids = new ArrayList<>();
	public PaymentScreen(ArrayList<Integer> productID,ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices) {
		initComponents();
		fillTable(Names, Quantities,Prices);
		ids = productID;
		this.setLocation(100, 30);
		
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
			panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
			.EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax
			. swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,
			12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans
			.PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e.
			getPropertyName () ) )throw new RuntimeException( ) ;} } );
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public void fillTable(ArrayList<String> Names, ArrayList<Integer> Quantities, ArrayList<Double> Prices)
	{
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		for(int i=0; i<Names.size(); i++)
		model.addRow(new Object[] {Names.get(i), Prices.get(i), Quantities.get(i)});
	}
	
	public void checkPointsButtonAction(ActionEvent e) throws SQLException,ClassNotFoundException
	{
		//get input id
		String inputID = textField1.getText();
		//connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		//retrieve member points
		rs = stm.executeQuery("SELECT points FROM members WHERE memberCardID = '" + inputID + "'");
		
		int points = -1;
		while(rs.next())
			points = rs.getInt("points");
		
		if(points == -1)
		{
			JOptionPane.showMessageDialog(null, "Given member ID doesnt exist", "ERROR",2);
		}
		else
		{
			//calculate potential discount
		}
		
		
	}
	
	public void applyDiscountButtonAction(ActionEvent e)
	{
		//get discount
		double discount = 0;
		if(!textField2.getText().equals(""))
		{
			discount = Double.parseDouble(textField2.getText());
			double newTotal = Double.parseDouble(textField3.getText()) - discount;
			
			textField3.setText("" + newTotal);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Potential discount not calculated", "ERROR",2);
		}
		
		
	}
	
	public void finishButtonAction(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm","root","");
			stm = con.createStatement();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error1: "+ex);
		}
		
		
		try
		{
			int h=0;
			for (int i=0; i<ids.size();i++)
		{
			   //h = ids.get(i);
		       //st.executeUpdate("INSERT INTO sales(id)" + "VALUES (h)");
		}
		      	
		}
		catch(Exception exep)
		{
			System.out.println("Error2: "+exep);
		}
	}
	
	public void printButtonAction(ActionEvent e)
	{
		
	}
}
