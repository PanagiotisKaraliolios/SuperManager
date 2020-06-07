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




	@SuppressWarnings("serial")
	public class RUDProductListScreen extends JInternalFrame {
	
		public RUDProductListScreen() {
			initComponents();
			this.setLocation(50, 50);
		}

		private void initComponents() {
		
		panel1 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setResizable(true);
				this.setTitle("Products List");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//---- label1 ----
				label1.setText("Product ID");
				contentPane.add(label1);
				label1.setBounds(30, 35, 70, label1.getPreferredSize().height);

				//---- label2 ----
				label2.setText("Name");
				contentPane.add(label2);
				label2.setBounds(30, 85, 70, 16);

				//---- label3 ----
				label3.setText("Stock Type");
				contentPane.add(label3);
				label3.setBounds(30, 135, 70, 16);

				//---- label4 ----
				label4.setText("Stock");
				contentPane.add(label4);
				label4.setBounds(30, 185, 70, 16);

				//---- label5 ----
				label5.setText("Price");
				contentPane.add(label5);
				label5.setBounds(30, 235, 70, 16);

				//---- label6 ----
				label6.setText("Supplier ID");
				contentPane.add(label6);
				label6.setBounds(25, 285, 70, 16);
				contentPane.add(textField1);
				textField1.setBounds(120, 30, 150, textField1.getPreferredSize().height);
				contentPane.add(textField2);
				textField2.setBounds(120, 80, 150, 28);
				contentPane.add(textField3);
				textField3.setBounds(120, 130, 150, 28);
				contentPane.add(textField4);
				textField4.setBounds(120, 180, 150, 28);
				contentPane.add(textField5);
				textField5.setBounds(120, 230, 150, 28);
				contentPane.add(textField6);
				textField6.setBounds(120, 280, 150, 28);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME", "TYPE", "STOCK", "PRICE", "SUPPLIER ID"
						}
					) 
					{
						Class<?>[] columnTypes = new Class<?>[] {
							Integer.class, Object.class, Object.class, Integer.class, Double.class, Integer.class
						};
						boolean[] columnEditable = new boolean[] {
							false, false, false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
						
						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseClicked(java.awt.event.MouseEvent evt) {
			                try {
								rowClicked(evt);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
			            }
			        });
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(350, 15, 625, 440);

				//---- button1 ----
				button1.setText("Add Product");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign2.png")));
				contentPane.add(button1);
				button1.setBounds(20, 330, 150, 40);
				button1.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
					
						try
						{
							addProduct(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});

				//---- button2 ----
				button2.setText("Update Product");
				button2.setIcon(new ImageIcon(getClass().getResource("/update.png")));
				contentPane.add(button2);
				button2.setBounds(190, 330, 150, 40);
				button2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
						try
						{
							updateProduct(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});

				//---- button3 ----
				button3.setText("Delete Product");
				button3.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				contentPane.add(button3);
				button3.setBounds(20, 385, 150, 40);
				button3.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
						try
						{
							deleteProduct(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});
			}
			panel1.add(this);
			this.setBounds(0, 0, 1000, 500);

			panel1.setPreferredSize(new Dimension(1000, 500));
		}
		
		listOfProducts=new ArrayList<Product>();
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		
		try {
			getProductListFromDB(listOfProducts,model);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
		
	private JPanel panel1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private ArrayList<Product> listOfProducts;
		
		
	private void getProductListFromDB(ArrayList<Product> listOfProducts,DefaultTableModel model) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM products");
		
		//get member list
		while(rs.next()) {
			listOfProducts.add(new Product(rs.getString("name"), rs.getDouble("price"), rs.getString("stockType"),rs.getInt("id"), Integer.parseInt(rs.getString("supplierID")), rs.getInt("stock")));
		}
		
		//add list to table
		for(Product p: listOfProducts){
			model.addRow(new Object[] {p.getProductsID(),p.getName(),p.getStockType(),p.getStock(),p.getPrice(),p.getSuppliersID()});
		}
		
		stm.close();
		con.close();
	}
	
	
	private void rowClicked(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
		int row = table1.getSelectedRow();
		Product prod = null;
		
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM products");
		
		if(row!=-1) {
			for(int i=0;i<=row;i++) {
				rs.next();
				prod = new Product(rs.getString("name"), rs.getDouble("price"), rs.getString("stockType"),Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("supplierID")), rs.getInt("stock"));
			}
		}
		
		if(row!=-1) {
			textField1.setText(String.valueOf(prod.getProductsID()));
			textField2.setText(prod.getName());
		    textField3.setText(prod.getStockType());
		    textField4.setText(String.valueOf(prod.getStock()));
		    textField5.setText(String.valueOf(prod.getPrice()));
		    textField6.setText(String.valueOf(prod.getSuppliersID()));
		}
		stm.close();
		con.close();
	}
	
	
	private void addProduct(ActionEvent e) throws ClassNotFoundException, SQLException {
		/*retrieve input*/
		String inputID = textField1.getText();
		String inputName = textField2.getText();
		String inputStockType = textField3.getText();
		String inputStock = textField4.getText();
		String inputPrice = textField5.getText();
		String inputSupplierID = textField6.getText();
		
		Connection con = null;
		Statement  stm = null;
		boolean flag=false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		
		ResultSet rs=stm.executeQuery("SELECT id FROM products");
		while(rs.next()) {
			if(Integer.parseInt(inputID) == rs.getInt("id")) {
				flag=true;
				break;
			}
		}
		
		if(flag==false) {
			/*update db*/
			stm.executeUpdate("INSERT INTO products VALUES('" + inputID + "', '" + inputStockType + "', '" + inputStock + "', '" + inputPrice + "', '" + inputName + "', '"+ inputSupplierID+ "')");
			
			/*update table*/
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			model.addRow(new Object[] {inputID,inputName,inputStockType,inputStock,inputPrice,inputSupplierID});
		}
		else if(flag==true){
			JOptionPane.showMessageDialog(null, "product id already exists", "ERROR", 2);
		}
		
		stm.close();
		con.close();
	}
	
	
	private void deleteProduct(ActionEvent e) throws ClassNotFoundException, SQLException {
		//get Selected Row
		int row = table1.getSelectedRow();		
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		String selectedID = null;
		
		//delete is done based on name
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT id FROM products");
		for(int i=0;i<=row;i++) {
			rs.next();
			selectedID = rs.getString("id");
		}
		
				
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "No product selected", "ERROR", 2);
		}
		else {	
			/*table update*/
			model.removeRow(row);
			
			/*db update*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			stm = con.createStatement();
			stm.executeUpdate("DELETE FROM  products WHERE id = '" + selectedID + "'");
			
		}
		stm.close();
		con.close();
	}
	
	
	private void updateProduct(ActionEvent e) throws ClassNotFoundException, SQLException {
		int row = table1.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		String selectedID = null;
		
		//update is done based on id
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT id FROM products");
		for(int i=0;i<=row;i++) {
			rs.next();
			selectedID = rs.getString("id");
		}
		
		
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "No product selected", "ERROR", 2);
		}
		else {
			
			/*table update*/
			if(!textField2.getText().trim().isEmpty()) model.setValueAt(textField2.getText(), row, 1);
			if(!textField3.getText().trim().isEmpty()) model.setValueAt(textField3.getText(), row, 2);
			if(!textField4.getText().trim().isEmpty()) model.setValueAt(textField4.getText(), row, 3);
			if(!textField5.getText().trim().isEmpty()) model.setValueAt(textField5.getText(), row, 4);
			if(!textField6.getText().trim().isEmpty()) model.setValueAt(textField6.getText(), row, 5);
			
			/*db update*/
			//id can't be updated
			if(!textField2.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET name = '" + textField2.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!textField3.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET stockType = '" + textField3.getText() + "'" + " WHERE id = '" + selectedID + "'");;
			if(!textField4.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET stock = '" + textField4.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!textField5.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET price = '" + textField5.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!textField6.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET supplierID = '" + textField6.getText() + "'" + " WHERE id = '" + selectedID + "'");
		}
		stm.close();
		con.close();
	}
	
	
	
	

}
