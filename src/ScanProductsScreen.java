import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 15 18:10:40 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
@SuppressWarnings("serial")
public class ScanProductsScreen extends JInternalFrame {
	public ScanProductsScreen() {
		initComponents();
		showDate();
		this.setLocation(50, 50);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		textField5 = new JTextField(); //date field
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton(); //addProductButton
		button1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							addProductButtonAction(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});
		button2 = new JButton(); //remove Product button
		button2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							removeProductButtonAction(e);
						}
						catch (Exception e2)
						{
							e2.printStackTrace();
						}
					}
				});
		button3 = new JButton();
		button3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							proceedToPaymentButtonAction(e);
						}
						catch (Exception e3)
						{
							e3.printStackTrace();
						}
					}
				});
			
		

		//======== panel1 ========
		{
			
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setTitle("Scan Products");
				this.setResizable(true);
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);
				contentPane.add(textField1);
				textField1.setBounds(110, 50, 150, textField1.getPreferredSize().height);

				//---- textField2 ----
				textField2.setEditable(false);
				contentPane.add(textField2);
				textField2.setBounds(110, 170, 150, 28);

				//---- textField3 ----
				textField3.setColumns(2);
				textField3.setEditable(false);
				contentPane.add(textField3);
				textField3.setBounds(110, 110, 150, 28);

				//---- textField4 ----
				textField4.setText("1");
				contentPane.add(textField4);
				textField4.setBounds(110, 230, 70, 28);

				//---- label1 ----
				label1.setText("Product ID");
				contentPane.add(label1);
				label1.setBounds(new Rectangle(new Point(30, 55), label1.getPreferredSize()));

				//---- label2 ----
				label2.setText("Name");
				contentPane.add(label2);
				label2.setBounds(30, 115, 57, 16);

				//---- label3 ----
				label3.setText("Price");
				contentPane.add(label3);
				label3.setBounds(30, 175, 57, 16);

				//---- label4 ----
				label4.setText("Quantity");
				contentPane.add(label4);
				label4.setBounds(30, 235, 57, 16);

				//---- label5 ----
				label5.setText("Date");
				label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
				contentPane.add(label5);
				label5.setBounds(465, 15, 57, 16);

				//---- textField5 ----
				textField5.setEditable(false);
				contentPane.add(textField5);
				textField5.setBounds(545, 10, 150, 28);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME", "PRICE", "QUANTITY"
						}
					)
					{
						Class<?>[] columnTypes = new Class<?>[] {
						Integer.class, String.class, Double.class, Integer.class};
							
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
				scrollPane1.setBounds(355, 50, 520, 400);

				//---- button1 ----
				button1.setText("Add Product");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign3.png")));
				contentPane.add(button1);
				button1.setBounds(20, 290, 150, 40);

				//---- button2 ----
				button2.setText("Remove Product");
				button2.setIcon(new ImageIcon(getClass().getResource("/minusSign.png")));
				contentPane.add(button2);
				button2.setBounds(185, 290, 150, 40);

				//---- button3 ----
				button3.setText("Proceed to Payment");
				button3.setIcon(new ImageIcon(getClass().getResource("/payment1.png")));
				contentPane.add(button3);
				button3.setBounds(80, 375, 195, 40);
			}
			panel1.add(this);
			this.setBounds(0, 0, 905, 500);

			panel1.setPreferredSize(new Dimension(905, 500));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JTextField textField1;  //ProductID field
	private JTextField textField2;	//Price Tag
	private JTextField textField3;	//Name field
	private JTextField textField4;	//Quantity field
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField textField5;	//Date field
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;	//addProduct
	private JButton button2;	//removeProduct
	private JButton button3;	//proceed to payment
	private static  String DateFormat = "yyyy-MM-dd";
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	private void addProductButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		String inputID = textField1.getText();
		Product chosenProduct = new Product("",0 , "units", 0, 0, 0);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM products WHERE id = '" + inputID + "'");
		//loop probably not needed
		while(rs.next())
		{
			chosenProduct.setProductsID(rs.getInt("id"));
			chosenProduct.setName(rs.getString("name"));
			chosenProduct.setPrice(rs.getDouble("price"));
			chosenProduct.setStockType(rs.getString("stockType"));
			chosenProduct.setSuppliersID(rs.getInt("supplierID"));
		}
		boolean flag = true;
		if(chosenProduct.getProductsID() == 0)
		{
			JOptionPane.showMessageDialog(null, "Given ProductID doesnt exist", "ERROR", 2);
			flag = false;
		}
		
		if(flag)
		{
			textField2.setText("" + chosenProduct.getPrice());
			textField3.setText(chosenProduct.getName());
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			model.addRow(new Object[] {chosenProduct.getProductsID(), chosenProduct.getName(), chosenProduct.getPrice(), textField4.getText()});
		}		
	}
	
	private void removeProductButtonAction(ActionEvent e)
	{
		int index = table1.getSelectedRow();
		if(index!=-1)
		{DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.removeRow(index);}
	}
	
	private void proceedToPaymentButtonAction(ActionEvent e)
	{
		
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		ArrayList<String> Names = new ArrayList<>();
		ArrayList<Integer> Quantities = new ArrayList<>();
		ArrayList<Double> Prices = new ArrayList<>();	
		ArrayList<Integer> Ids = new ArrayList<>();
<<<<<<< HEAD
		if(model.getRowCount()!=0)
		{
		for(int i=0;i<model.getRowCount(); i++)
		{
			Ids.add(Integer.parseInt( table1.getValueAt(i, 0).toString()));
			Names.add((table1.getValueAt(i, 1).toString()));
			Quantities.add(Integer.parseInt( table1.getValueAt(i, 3).toString()));
			Prices.add(Double.parseDouble(table1.getValueAt(i, 2).toString()));
			
		}
=======
		if(model.getRowCount()!=0){
			for(int i=0;i<model.getRowCount(); i++){
				Names.add((table1.getValueAt(i, 1).toString()));
				Quantities.add(Integer.parseInt( table1.getValueAt(i, 3).toString()));
				Prices.add(Double.parseDouble(table1.getValueAt(i, 2).toString()));
				Ids.add(Integer.parseInt( table1.getValueAt(i, 3).toString()));
			}
			PaymentScreen PS = new PaymentScreen(Ids,Names, Quantities,Prices);
			
			this.getParent().add(PS);
			try {
				this.setClosed(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
>>>>>>> b165384117d86acb61c8eda0adc36329141505e1
		}
		else{
			JOptionPane.showMessageDialog(null, "No products scanned", "ERROR", 2);
		}
		
		
		
		
		
	}
	
	private void showDate()
    {
      Calendar cal= Calendar.getInstance();
      SimpleDateFormat format = new SimpleDateFormat(DateFormat);
      textField5.setText(format.format(cal.getTime()));        
    }
}
