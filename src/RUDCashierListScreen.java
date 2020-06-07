import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;




@SuppressWarnings("serial")
public class RUDCashierListScreen extends JInternalFrame {
	public RUDCashierListScreen() {
		initComponents();
		this.setLocation(50, 50);
	}

	
	private void initComponents() {
		
		panel1 = new JPanel();
		label2 = new JLabel();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button3 = new JButton();
		label6 = new JLabel();
		label7 = new JLabel();
		textField6 = new JTextField();
		textField7 = new JTextField();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setTitle("Cashiers");
				this.setDoubleBuffered(true);
				this.setMinimumSize(new Dimension(800, 500));
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//---- label2 ----
				label2.setText("Name");
				contentPane.add(label2);
				label2.setBounds(20, 120, 70, label2.getPreferredSize().height);
				contentPane.add(textField2);
				textField2.setBounds(145, 115, 170, 28);
				contentPane.add(textField3);
				textField3.setBounds(145, 165, 170, 28);
				contentPane.add(textField4);
				textField4.setBounds(145, 215, 170, 28);
				contentPane.add(textField5);
				textField5.setBounds(145, 265, 170, 28);

				//---- label3 ----
				label3.setText("Email");
				contentPane.add(label3);
				label3.setBounds(20, 170, 70, 16);

				//---- label4 ----
				label4.setText("Phone Number");
				contentPane.add(label4);
				label4.setBounds(20, 220, 100, 16);

				//---- label5 ----
				label5.setText("Address");
				contentPane.add(label5);
				label5.setBounds(20, 270, 70, 16);

				//---- button1 ----
				button1.setText("Add Cashier");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				button1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							addCashier(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});
				contentPane.add(button1);
				button1.setBounds(15, 315, 145, 40);

				//---- button2 ----
				button2.setText("Delete Cashier");
				button2.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				button2.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
					
						try
						{
							deleteCashier(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});
				contentPane.add(button2);
				button2.setBounds(15, 375, 145, 40);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"NAME", "EMAIL", "PHONE", "ADDRESS"
						}
					) {
						boolean[] columnEditable = new boolean[] {
							false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setAutoCreateRowSorter(false);
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
				scrollPane1.setBounds(340, 10, 506, scrollPane1.getPreferredSize().height);

				//---- button3 ----
				button3.setText("Update Cashier");
				button3.setIcon(new ImageIcon(getClass().getResource("/update.png")));
				button3.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
					
						try
						{
							updateCashier(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});
				contentPane.add(button3);
				button3.setBounds(170, 315, 145, 40);

				//---- label6 ----
				label6.setText("Username");
				contentPane.add(label6);
				label6.setBounds(20, 20, 70, 16);

				//---- label7 ----
				label7.setText("Password");
				contentPane.add(label7);
				label7.setBounds(20, 70, 70, 16);
				contentPane.add(textField6);
				textField6.setBounds(145, 15, 170, 28);
				contentPane.add(textField7);
				textField7.setBounds(145, 65, 170, 28);
			}
			panel1.add(this);
			this.setBounds(0, 0, 865, 475);

			panel1.setPreferredSize(new Dimension(865, 475));
		}
		
		listOfCashiers=new ArrayList<Cashier>();
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		
		try {
			getCashierListFromDB(listOfCashiers,model);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private JPanel panel1;
	private JLabel label2;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton button1;
	private JButton button2;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button3;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField6;
	private JTextField textField7;
	private ArrayList<Cashier> listOfCashiers;
	
	
	private void deleteCashier(ActionEvent e) throws ClassNotFoundException, SQLException {
		//get Selected Row
		int row = table1.getSelectedRow();		
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		String selectedUsername = null;
		
		//delete is done based on username
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		
		
		ResultSet rs = stm.executeQuery("SELECT username FROM cashiers");
		for(int i=0;i<=row;i++) {
			rs.next();
			selectedUsername = rs.getString("username");
		}
		
				
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "No cashier selected", "ERROR", 2);
		}
		else {	
			/*table update*/
			model.removeRow(row);
			
			/*db update*/
			stm.executeUpdate("DELETE FROM  cashiers WHERE username = '" + selectedUsername + "'");
			
		}
		stm.close();
		con.close();
	}
	
	
	private void addCashier(ActionEvent e) throws ClassNotFoundException, SQLException {
		/*retrieve input*/
		String inputUsername = textField6.getText();
		String inputPassword = textField7.getText();
		String inputName = textField2.getText();
		String inputEmail = textField3.getText();
		String inputNum = textField4.getText();
		String inputAddress = textField5.getText();
		
		Connection con = null;
		Statement  stm = null;
		boolean flag=false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT username FROM cashiers");
		while(rs.next()) {
			if(inputUsername.equals(rs.getString("username"))) {
				flag=true;
				break;
			}
		}
		
		if(flag==false) {
			/*update db*/
			stm.executeUpdate("INSERT INTO cashiers VALUES('" + inputUsername + "', '" + inputPassword + "', '" + inputName + "', '" + inputEmail + "', '" + inputNum + "', '"+ inputAddress+ "')"); 
			
			/*update table*/
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			model.addRow(new Object[] {inputName,inputEmail,inputNum,inputAddress});
		}
		else if(flag==true) {
			JOptionPane.showMessageDialog(null, "cashier username already exists", "ERROR", 2);
		}
		
		stm.close();
		con.close();
	}
	
	
	private void updateCashier(ActionEvent e) throws ClassNotFoundException, SQLException {
		int row = table1.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		String selectedUsername = null;
		
		//update is done based on username
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT username FROM cashiers");
		for(int i=0;i<=row;i++) {
			rs.next();
			selectedUsername = rs.getString("username");
		}
		
		
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "No member selected", "ERROR", 2);
		}
		else {
			
			/*table update*/
			if(!textField2.getText().trim().isEmpty()) model.setValueAt(textField2.getText(), row, 0);
			if(!textField3.getText().trim().isEmpty()) model.setValueAt(textField3.getText(), row, 1);
			if(!textField4.getText().trim().isEmpty()) model.setValueAt(textField4.getText(), row, 2);
			if(!textField5.getText().trim().isEmpty()) model.setValueAt(textField5.getText(), row, 3);
			
			/*db update*/
			//username can't be updated
			if(!textField7.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET password = '" + textField7.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!textField2.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET name = '" + textField2.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!textField3.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET email = '" + textField3.getText() + "'" + " WHERE username = '" + selectedUsername + "'");;
			if(!textField4.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET phoneNumber = '" + textField4.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!textField5.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET address = '" + textField5.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			
		}
		stm.close();
		con.close();
	}
	
	
	private void getCashierListFromDB(ArrayList<Cashier> listOfCashiers,DefaultTableModel model) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM cashiers");
		
		//get member list
		while(rs.next()) {
			listOfCashiers.add(new Cashier(rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNumber"),rs.getString("address")));
		}
		
		//add list to table
		for(Cashier c: listOfCashiers){
			model.addRow(new Object[] {c.getName(),c.getEmail(),c.getPhoneNumber(),c.getAddress()});
		}
		
		stm.close();
		con.close();
	}
	
	
	private void rowClicked(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
		int row = table1.getSelectedRow();
		Cashier cash=null;
		
		Connection con = null;
		Statement  stm = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM cashiers");
		
		if(row!=-1) {
			for(int i=0;i<=row;i++) {
				rs.next();
				cash=new Cashier(rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNumber"),rs.getString("address"));
			}
		}
		
		if(row!=-1) {
			textField6.setText(cash.getUsername());
			textField7.setText(cash.getPassword());
		    textField2.setText(cash.getName());
		    textField3.setText(cash.getEmail());
		    textField4.setText(cash.getPhoneNumber());
		    textField5.setText(cash.getAddress());
		}
		stm.close();
		con.close();
	}
	

	
	
}
