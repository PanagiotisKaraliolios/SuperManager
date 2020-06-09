import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.*;





@SuppressWarnings("serial")
public class ScanProductsScreen extends JInternalFrame {
	public ScanProductsScreen() {
		initComponents();
		showDate();
		this.setLocation(50, 50);
	}

	private void initComponents() {
		
		panel1 = new JPanel();
		productIDtextField = new JTextField();
		priceTextField = new JTextField();
		nameTextField = new JTextField();
		quantityTextField = new JTextField();
		productIDlabel = new JLabel();
		nameLabel = new JLabel();
		priceLabel = new JLabel();
		quantityLabel = new JLabel();
		dateLabel = new JLabel();
		dateTextField = new JTextField(); //date field
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		addProductButton = new JButton(); //addProductButton
		removeProductButton = new JButton(); //remove Product button
		proceedToPaymentButton = new JButton();
		
		addProductButton.addActionListener(new ActionListener()
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
							JOptionPane.showMessageDialog(null, "Given ProductID doesnt exist", "ERROR", 2);
						}
					}
				});
		
		removeProductButton.addActionListener(new ActionListener()
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
		
		proceedToPaymentButton.addActionListener(new ActionListener()
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
				contentPane.add(productIDtextField);
				productIDtextField.setBounds(110, 50, 150, productIDtextField.getPreferredSize().height);

				//---- textField2 ----
				priceTextField.setEditable(false);
				contentPane.add(priceTextField);
				priceTextField.setBounds(110, 170, 150, 28);

				//---- textField3 ----
				nameTextField.setColumns(2);
				nameTextField.setEditable(false);
				contentPane.add(nameTextField);
				nameTextField.setBounds(110, 110, 150, 28);

				//---- textField4 ----
				quantityTextField.setText("1");
				contentPane.add(quantityTextField);
				quantityTextField.setBounds(110, 230, 70, 28);

				//---- label1 ----
				productIDlabel.setText("Product ID");
				contentPane.add(productIDlabel);
				productIDlabel.setBounds(new Rectangle(new Point(30, 55), productIDlabel.getPreferredSize()));

				//---- label2 ----
				nameLabel.setText("Name");
				contentPane.add(nameLabel);
				nameLabel.setBounds(30, 115, 57, 16);

				//---- label3 ----
				priceLabel.setText("Price");
				contentPane.add(priceLabel);
				priceLabel.setBounds(30, 175, 57, 16);

				//---- label4 ----
				quantityLabel.setText("Quantity");
				contentPane.add(quantityLabel);
				quantityLabel.setBounds(30, 235, 57, 16);

				//---- label5 ----
				dateLabel.setText("Date");
				dateLabel.setFont(dateLabel.getFont().deriveFont(dateLabel.getFont().getSize() + 2f));
				contentPane.add(dateLabel);
				dateLabel.setBounds(465, 15, 57, 16);

				//---- textField5 ----
				dateTextField.setEditable(false);
				contentPane.add(dateTextField);
				dateTextField.setBounds(545, 10, 150, 28);

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
						
						boolean[] columnEditable = new boolean[] {
								false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					table1.setAutoCreateRowSorter(false);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(355, 50, 520, 400);

				//---- button1 ----
				addProductButton.setText("Add Product");
				addProductButton.setIcon(new ImageIcon(getClass().getResource("/plusSign3.png")));
				contentPane.add(addProductButton);
				addProductButton.setBounds(20, 290, 150, 40);

				//---- button2 ----
				removeProductButton.setText("Remove Product");
				removeProductButton.setIcon(new ImageIcon(getClass().getResource("/minusSign.png")));
				contentPane.add(removeProductButton);
				removeProductButton.setBounds(185, 290, 150, 40);

				//---- button3 ----
				proceedToPaymentButton.setText("Proceed to Payment");
				proceedToPaymentButton.setIcon(new ImageIcon(getClass().getResource("/payment1.png")));
				contentPane.add(proceedToPaymentButton);
				proceedToPaymentButton.setBounds(80, 375, 195, 40);
			}
			panel1.add(this);
			this.setBounds(0, 0, 905, 500);

			panel1.setPreferredSize(new Dimension(905, 500));
		}
		
		
		
	}

	
	private JPanel panel1;
	private JTextField productIDtextField;  //ProductID field
	private JTextField priceTextField;	//Price Tag
	private JTextField nameTextField;	//Name field
	private JTextField quantityTextField;	//Quantity field
	private JLabel productIDlabel;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel quantityLabel;
	private JLabel dateLabel;
	private JTextField dateTextField;	//Date field
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton addProductButton;	//addProduct
	private JButton removeProductButton;	//removeProduct
	private JButton proceedToPaymentButton;	//proceed to payment
	private static  String DateFormat = "yyyy-MM-dd";
	
	
	private void addProductButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		String inputID = productIDtextField.getText();
		Product chosenProduct = new Product("",0 , "units", 0, 0, 0);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM products WHERE id = '" + inputID + "'");
		
		rs.next();
	
		chosenProduct.setProductsID(rs.getInt("id"));
		chosenProduct.setName(rs.getString("name"));
		chosenProduct.setPrice(rs.getDouble("price"));
		chosenProduct.setStockType(rs.getString("stockType"));
		chosenProduct.setSuppliersID(rs.getInt("supplierID"));
		chosenProduct.setStock(rs.getInt("stock"));
		
		boolean idExists = true;
		
		
		if(chosenProduct.getProductsID() == 0)
		{
			idExists= false;
		}
		
		if(idExists)
		{
			priceTextField.setText("" + chosenProduct.getPrice());
			nameTextField.setText(chosenProduct.getName());
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			if(quantityTextField.getText().contains("-") || quantityTextField.getText().equals("0") || quantityTextField.getText().equals("")) {//Checks product quantity >0
				JOptionPane.showMessageDialog(null, "Please select a valid quantity", "WARNING", 2);
			}
			else {
				model.addRow(new Object[] {chosenProduct.getProductsID(), chosenProduct.getName(), chosenProduct.getPrice(), quantityTextField.getText()});
			}	
		}
		stm.close();
		con.close();
	}
	
	private void removeProductButtonAction(ActionEvent e)
	{
		int index = table1.getSelectedRow();
		if(index!=-1) {
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			model.removeRow(index);
		}
	}
	
	private void proceedToPaymentButtonAction(ActionEvent e)
	{
		
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		ArrayList<String> Names = new ArrayList<>();
		ArrayList<Integer> Quantities = new ArrayList<>();
		ArrayList<Double> Prices = new ArrayList<>();	
		ArrayList<Integer> Ids = new ArrayList<>();
		if(model.getRowCount()!=0)
		{
			for(int i=0;i<model.getRowCount(); i++)
			{
				Ids.add(Integer.parseInt( table1.getValueAt(i, 0).toString()));
				Names.add((table1.getValueAt(i, 1).toString()));
				Quantities.add(Integer.parseInt( table1.getValueAt(i, 3).toString()));
				Prices.add(Double.parseDouble(table1.getValueAt(i, 2).toString()));
			}
			
			PaymentScreen PS = new PaymentScreen(Ids,Names, Quantities,Prices);
			
			this.getParent().add(PS);
			try
			{
				this.setClosed(true);
			} catch (PropertyVetoException e1)
			{
				e1.printStackTrace();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "No products scanned", "Warning", 2);
		}
		
	  
	}
	
	private void showDate()
    {
      Calendar cal= Calendar.getInstance();
      SimpleDateFormat format = new SimpleDateFormat(DateFormat);
      dateTextField.setText(format.format(cal.getTime()));        
    }
}
