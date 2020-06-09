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
		nameLabel = new JLabel();
		nameTextField = new JTextField();
		emailTextField = new JTextField();
		phoneNumberTextField = new JTextField();
		addressTextField = new JTextField();
		emailLabel = new JLabel();
		phoneNumberLabel = new JLabel();
		addressLabel = new JLabel();
		addCashierButton = new JButton();
		deleteCashierButton = new JButton();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		updateCashierButton = new JButton();
		usernameLabel = new JLabel();
		passwordLabel = new JLabel();
		usernameTextField = new JTextField();
		passwordTextField = new JTextField();

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
				nameLabel.setText("Name");
				contentPane.add(nameLabel);
				nameLabel.setBounds(20, 120, 70, nameLabel.getPreferredSize().height);
				contentPane.add(nameTextField);
				nameTextField.setBounds(145, 115, 170, 28);
				contentPane.add(emailTextField);
				emailTextField.setBounds(145, 165, 170, 28);
				contentPane.add(phoneNumberTextField);
				phoneNumberTextField.setBounds(145, 215, 170, 28);
				contentPane.add(addressTextField);
				addressTextField.setBounds(145, 265, 170, 28);

				//---- label3 ----
				emailLabel.setText("Email");
				contentPane.add(emailLabel);
				emailLabel.setBounds(20, 170, 70, 16);

				//---- label4 ----
				phoneNumberLabel.setText("Phone Number");
				contentPane.add(phoneNumberLabel);
				phoneNumberLabel.setBounds(20, 220, 100, 16);

				//---- label5 ----
				addressLabel.setText("Address");
				contentPane.add(addressLabel);
				addressLabel.setBounds(20, 270, 70, 16);

				//---- button1 ----
				addCashierButton.setText("Add Cashier");
				addCashierButton.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				addCashierButton.addActionListener(new ActionListener() {
					
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
				contentPane.add(addCashierButton);
				addCashierButton.setBounds(15, 315, 145, 40);

				//---- button2 ----
				deleteCashierButton.setText("Delete Cashier");
				deleteCashierButton.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				deleteCashierButton.addActionListener(new ActionListener() {
				
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
				contentPane.add(deleteCashierButton);
				deleteCashierButton.setBounds(15, 375, 145, 40);

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
				updateCashierButton.setText("Update Cashier");
				updateCashierButton.setIcon(new ImageIcon(getClass().getResource("/update.png")));
				updateCashierButton.addActionListener(new ActionListener() {
				
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
				contentPane.add(updateCashierButton);
				updateCashierButton.setBounds(170, 315, 145, 40);

				//---- label6 ----
				usernameLabel.setText("Username");
				contentPane.add(usernameLabel);
				usernameLabel.setBounds(20, 20, 70, 16);

				//---- label7 ----
				passwordLabel.setText("Password");
				contentPane.add(passwordLabel);
				passwordLabel.setBounds(20, 70, 70, 16);
				contentPane.add(usernameTextField);
				usernameTextField.setBounds(145, 15, 170, 28);
				contentPane.add(passwordTextField);
				passwordTextField.setBounds(145, 65, 170, 28);
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
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JTextField addressTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JLabel emailLabel;
	private JLabel phoneNumberLabel;
	private JLabel addressLabel;
	private JButton addCashierButton;
	private JButton deleteCashierButton;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton updateCashierButton;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
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
		String inputUsername = usernameTextField.getText();
		String inputPassword = passwordTextField.getText();
		String inputName = nameTextField.getText();
		String inputEmail = emailTextField.getText();
		String inputNum = phoneNumberTextField.getText();
		String inputAddress = addressTextField.getText();
		
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
			if(!nameTextField.getText().trim().isEmpty()) model.setValueAt(nameTextField.getText(), row, 0);
			if(!emailTextField.getText().trim().isEmpty()) model.setValueAt(emailTextField.getText(), row, 1);
			if(!phoneNumberTextField.getText().trim().isEmpty()) model.setValueAt(phoneNumberTextField.getText(), row, 2);
			if(!addressTextField.getText().trim().isEmpty()) model.setValueAt(addressTextField.getText(), row, 3);
			
			/*db update*/
			//username can't be updated
			if(!passwordTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET password = '" + passwordTextField.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!nameTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET name = '" + nameTextField.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!emailTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET email = '" + emailTextField.getText() + "'" + " WHERE username = '" + selectedUsername + "'");;
			if(!phoneNumberTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET phoneNumber = '" + phoneNumberTextField.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			if(!addressTextField.getText().trim().isEmpty()) stm.executeUpdate("UPDATE cashiers SET address = '" + addressTextField.getText() + "'" + " WHERE username = '" + selectedUsername + "'");
			
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
			usernameTextField.setText(cash.getUsername());
			passwordTextField.setText(cash.getPassword());
		    nameTextField.setText(cash.getName());
		    emailTextField.setText(cash.getEmail());
		    phoneNumberTextField.setText(cash.getPhoneNumber());
		    addressTextField.setText(cash.getAddress());
		}
		stm.close();
		con.close();
	}
	

	
	
}
