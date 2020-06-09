import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;





@SuppressWarnings("serial")
public class OrderProductsScreen extends JInternalFrame {
	
	public OrderProductsScreen() {		//Order Products Screen Constructor
		initComponents();
		this.setLocation(200, 50);
	}

	private void initComponents() {
		
		panel1 = new JPanel();
		productIDtextField = new JTextField();
		productIDLabel = new JLabel();
		quantityTextField = new JTextField();
		quantityLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		addToOrderButton = new JButton();
		sendOrderButton = new JButton();
		iconLabel = new JLabel();

		//======== panel1 ========
		{

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setResizable(true);
				this.setTitle("Order Supplies");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);
				contentPane.add(productIDtextField);
				productIDtextField.setBounds(90, 125, 140, productIDtextField.getPreferredSize().height);

				//---- label1 ----
				productIDLabel.setText("Product ID");
				contentPane.add(productIDLabel);
				productIDLabel.setBounds(new Rectangle(new Point(20, 130), productIDLabel.getPreferredSize()));
				contentPane.add(quantityTextField);
				quantityTextField.setBounds(90, 170, 140, 28);

				//---- label2 ----
				quantityLabel.setText("Quantity");
				contentPane.add(quantityLabel);
				quantityLabel.setBounds(new Rectangle(new Point(20, 175), quantityLabel.getPreferredSize()));

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Product", "Quantity", "Supplier ID"
						}
					) {
						Class<?>[] columnTypes = new Class<?>[] {
							String.class, Integer.class, Integer.class
						};
						boolean[] columnEditable = new boolean[] {
							false, false, false
						};
						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(245, 10, 325, 365);

				//---- button1 ----
				addToOrderButton.setText("Add to order");
				addToOrderButton.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				contentPane.add(addToOrderButton);
				addToOrderButton.setBounds(105, 225, 120, 40);
				addToOrderButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									addOrderButtonAction(e);
								}
								catch (Exception e1)
								{
									e1.printStackTrace();
								}
							}
						});
					
				

				//---- button2 ----
				sendOrderButton.setText("Send order");
				sendOrderButton.setIcon(new ImageIcon(getClass().getResource("/order.png")));
				contentPane.add(sendOrderButton);
				sendOrderButton.setBounds(90, 320, 130, 40);
				sendOrderButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						sendOrderButtonAction(e);
					}
				});

				//---- label3 ----
				iconLabel.setIcon(new ImageIcon(getClass().getResource("/order (2).png")));
				contentPane.add(iconLabel);
				iconLabel.setBounds(75, 5, 110, 85);
			}
			panel1.add(this);
			this.setBounds(0, 0, 590, 415);

			panel1.setPreferredSize(new Dimension(590, 415));
		}
		
	}

	
	private JPanel panel1;
	private JTextField productIDtextField; //productID field
	private JLabel productIDLabel;
	private JTextField quantityTextField; //quantity field
	private JLabel quantityLabel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton addToOrderButton; //addOrderButton
	private JButton sendOrderButton; //sendOrderButton
	private JLabel iconLabel;
	
	
	private void addOrderButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		String ID = productIDtextField.getText();
		String Q = quantityTextField.getText();
		
		if(ID.equals("") || Q.equals(""))
			JOptionPane.showMessageDialog(null, "Missing input ID/Quantity", "ERROR", 2);
		else
		{
			int inputID = Integer.parseInt(ID);
			int inputQuantity = Integer.parseInt(Q);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT name, supplierID FROM products WHERE id = " + inputID);
			String receivedName = "";
			String sid ="";
			
			while(rs.next())
			{
				receivedName = rs.getString("name");
				sid = rs.getString("supplierID");
			}
			
			if(receivedName.equals("") && sid.equals(""))
				JOptionPane.showMessageDialog(null, "Given ID doesnt exist", "ERROR", 2);
			else
			{
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.addRow(new Object[] {receivedName, inputQuantity, sid});
			}
		}
	}
	
	private void sendOrderButtonAction(ActionEvent e)
	{
		if(table1.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "No products added for order", "ERROR", 2);
		else
			JOptionPane.showMessageDialog(null, "Your order has been submited and will be delivered soon to your store", "Order Complete", 2);
	}
}
