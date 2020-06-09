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
		idLabel = new JLabel();
		productNameLabel = new JLabel();
		stockTypelabel = new JLabel();
		stockLabel = new JLabel();
		priceLabel = new JLabel();
		supplierIDlabel = new JLabel();
		productIDtextField = new JTextField();
		productNameTextField = new JTextField();
		stockTypeTextField = new JTextField();
		stockTextField = new JTextField();
		priceTextField = new JTextField();
		supplierIDtextField = new JTextField();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		addProductButton = new JButton();
		updateProductButton = new JButton();
		deleteProductButton = new JButton();

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
				idLabel.setText("Product ID");
				contentPane.add(idLabel);
				idLabel.setBounds(30, 35, 70, idLabel.getPreferredSize().height);

				//---- label2 ----
				productNameLabel.setText("Name");
				contentPane.add(productNameLabel);
				productNameLabel.setBounds(30, 85, 70, 16);

				//---- label3 ----
				stockTypelabel.setText("Stock Type");
				contentPane.add(stockTypelabel);
				stockTypelabel.setBounds(30, 135, 70, 16);

				//---- label4 ----
				stockLabel.setText("Stock");
				contentPane.add(stockLabel);
				stockLabel.setBounds(30, 185, 70, 16);

				//---- label5 ----
				priceLabel.setText("Price");
				contentPane.add(priceLabel);
				priceLabel.setBounds(30, 235, 70, 16);

				//---- label6 ----
				supplierIDlabel.setText("Supplier ID");
				contentPane.add(supplierIDlabel);
				supplierIDlabel.setBounds(25, 285, 70, 16);
				contentPane.add(productIDtextField);
				productIDtextField.setBounds(120, 30, 150, productIDtextField.getPreferredSize().height);
				contentPane.add(productNameTextField);
				productNameTextField.setBounds(120, 80, 150, 28);
				contentPane.add(stockTypeTextField);
				stockTypeTextField.setBounds(120, 130, 150, 28);
				contentPane.add(stockTextField);
				stockTextField.setBounds(120, 180, 150, 28);
				contentPane.add(priceTextField);
				priceTextField.setBounds(120, 230, 150, 28);
				contentPane.add(supplierIDtextField);
				supplierIDtextField.setBounds(120, 280, 150, 28);

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
				addProductButton.setText("Add Product");
				addProductButton.setIcon(new ImageIcon(getClass().getResource("/plusSign2.png")));
				contentPane.add(addProductButton);
				addProductButton.setBounds(20, 330, 150, 40);
				addProductButton.addActionListener(new ActionListener() {
				
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
				updateProductButton.setText("Update Product");
				updateProductButton.setIcon(new ImageIcon(getClass().getResource("/update.png")));
				contentPane.add(updateProductButton);
				updateProductButton.setBounds(190, 330, 150, 40);
				updateProductButton.addActionListener(new ActionListener() {
					
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
				deleteProductButton.setText("Delete Product");
				deleteProductButton.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				contentPane.add(deleteProductButton);
				deleteProductButton.setBounds(20, 385, 150, 40);
				deleteProductButton.addActionListener(new ActionListener() {
					
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
	private JLabel idLabel;
	private JLabel productNameLabel;
	private JLabel stockTypelabel;
	private JLabel stockLabel;
	private JLabel priceLabel;
	private JLabel supplierIDlabel;
	private JTextField productIDtextField;
	private JTextField productNameTextField;
	private JTextField stockTypeTextField;
	private JTextField stockTextField;
	private JTextField priceTextField;
	private JTextField supplierIDtextField;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton addProductButton;
	private JButton updateProductButton;
	private JButton deleteProductButton;
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
			productIDtextField.setText(String.valueOf(prod.getProductsID()));
			productNameTextField.setText(prod.getName());
		    stockTypeTextField.setText(prod.getStockType());
		    stockTextField.setText(String.valueOf(prod.getStock()));
		    priceTextField.setText(String.valueOf(prod.getPrice()));
		    supplierIDtextField.setText(String.valueOf(prod.getSuppliersID()));
		}
		stm.close();
		con.close();
	}
	
	
	private void addProduct(ActionEvent e) throws ClassNotFoundException, SQLException {
		/*retrieve input*/
		String inputID = productIDtextField.getText();
		String inputName = productNameTextField.getText();
		String inputStockType = stockTypeTextField.getText();
		String inputStock = stockTextField.getText();
		String inputPrice = priceTextField.getText();
		String inputSupplierID = supplierIDtextField.getText();
		
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
			if(!productNameTextField.getText().trim().isEmpty()) model.setValueAt(productNameTextField.getText(), row, 1);
			if(!stockTypeTextField.getText().trim().isEmpty()) model.setValueAt(stockTypeTextField.getText(), row, 2);
			if(!stockTextField.getText().trim().isEmpty()) model.setValueAt(stockTextField.getText(), row, 3);
			if(!priceTextField.getText().trim().isEmpty()) model.setValueAt(priceTextField.getText(), row, 4);
			if(!supplierIDtextField.getText().trim().isEmpty()) model.setValueAt(supplierIDtextField.getText(), row, 5);
			
			/*db update*/
			//id can't be updated
			if(!productNameTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET name = '" + productNameTextField.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!stockTypeTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET stockType = '" + stockTypeTextField.getText() + "'" + " WHERE id = '" + selectedID + "'");;
			if(!stockTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET stock = '" + stockTextField.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!priceTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET price = '" + priceTextField.getText() + "'" + " WHERE id = '" + selectedID + "'");
			if(!supplierIDtextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE products SET supplierID = '" + supplierIDtextField.getText() + "'" + " WHERE id = '" + selectedID + "'");
		}
		stm.close();
		con.close();
	}
	
	
	
	

}
