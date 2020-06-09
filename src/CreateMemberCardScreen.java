import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;





@SuppressWarnings("serial")
public class CreateMemberCardScreen extends JInternalFrame {
	
	public CreateMemberCardScreen() {		//Members Screen Constructor
		initComponents();
		this.setLocation(50, 50);
	}

	private void initComponents() {			//Members Screen Components
		
		panel1 = new JPanel();
		idLabel = new JLabel();
		idTextField = new JTextField();
		nameLabel = new JLabel();
		nameTextField = new JTextField();
		emailTextField = new JTextField();
		phoneNumberTextField = new JTextField();
		addressTextField = new JTextField();
		emailLabel = new JLabel();
		phoneNumberLabel = new JLabel();
		addressLabel = new JLabel();
		addMemberButton = new JButton();			//this button adds new member
		deleteSelectedMemberButton = new JButton();			//this button deletes a selected member
		scrollPane1 = new JScrollPane();
		table1 = new JTable();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setTitle("Members");
				this.setDoubleBuffered(true);
				this.setMinimumSize(new Dimension(800, 500));
				this.setResizable(true);
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//---- label1 ----
				idLabel.setText("Member/Card ID");
				contentPane.add(idLabel);
				idLabel.setBounds(20, 55, 105, idLabel.getPreferredSize().height);

				//---- textField1 ----
				idTextField.setEditable(true);
				contentPane.add(idTextField);
				idTextField.setBounds(145, 50, 170, idTextField.getPreferredSize().height);

				//---- label2 ----
				nameLabel.setText("Name");
				contentPane.add(nameLabel);
				nameLabel.setBounds(20, 105, 70, nameLabel.getPreferredSize().height);
				contentPane.add(nameTextField);
				nameTextField.setBounds(145, 100, 170, 28);
				contentPane.add(emailTextField);
				emailTextField.setBounds(145, 150, 170, 28);
				contentPane.add(phoneNumberTextField);
				phoneNumberTextField.setBounds(145, 200, 170, 28);
				contentPane.add(addressTextField);
				addressTextField.setBounds(145, 250, 170, 28);

				//---- label3 ----
				emailLabel.setText("Email");
				contentPane.add(emailLabel);
				emailLabel.setBounds(20, 155, 70, 16);

				//---- label4 ----
				phoneNumberLabel.setText("Phone Number");
				contentPane.add(phoneNumberLabel);
				phoneNumberLabel.setBounds(20, 205, 100, 16);

				//---- label5 ----
				addressLabel.setText("Address");
				contentPane.add(addressLabel);
				addressLabel.setBounds(20, 255, 70, 16);

				//---- button1 ----
				addMemberButton.setText("Add Member");
				addMemberButton.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				contentPane.add(addMemberButton);
				addMemberButton.setBounds(20, 310, 150, 40);

				//---- button2 ----
				deleteSelectedMemberButton.setText("Delete Member");
				deleteSelectedMemberButton.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				contentPane.add(deleteSelectedMemberButton);
				deleteSelectedMemberButton.setBounds(190, 310, 150, 40);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME", "EMAIL", "PHONE", "ADDRESS"
						}
					) {
						boolean[] columnEditable = new boolean[] {
							false, false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setAutoCreateRowSorter(true);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(370, 5, 510, 455);
			}
			panel1.add(this);
			this.setBounds(0, 0, 900, 500);

			panel1.setPreferredSize(new Dimension(900, 500));
		}
		
		
		
		addMemberButton.addActionListener(new ActionListener()
		{
					
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					addMemberButtonAction(e);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
				});
		
		deleteSelectedMemberButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					deleteMemberButtonAction(e);
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		
		//initialize table
		try
		{
			//get member list
			ArrayList<Member> memList = new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM members");
			
			while(rs.next())
				memList.add(new Member(rs.getString("memberCardID"), rs.getString("name"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("address"), rs.getDouble("points")));
			
			//add list to table
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(Member mem: memList)
			{
				model.addRow(new Object[] {mem.getMemberCardId(), mem.getName(), mem.getEmail(), mem.getPhoneNumber(), mem.getAddress()});
			}
			stm.close();
			con.close();
		}
		catch (Exception e3)
		{
			e3.printStackTrace();
		}
	}

	
	private JPanel panel1;
	private JLabel idLabel;
	private JTextField idTextField; //Member/Card ID field
	private JLabel nameLabel;
	private JTextField nameTextField; //Name field
	private JTextField emailTextField; //Email field
	private JTextField phoneNumberTextField; //phoneNum field
	private JTextField addressTextField; //address field
	private JLabel emailLabel;
	private JLabel phoneNumberLabel;
	private JLabel addressLabel;
	private JButton addMemberButton; //addMemberButton
	private JButton deleteSelectedMemberButton; //deleteMemberButton
	private JScrollPane scrollPane1;
	private JTable table1;
	
	
	private void addMemberButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		if(!idTextField.getText().equals("") || !nameTextField.getText().equals("") || !emailTextField.getText().equals("") || !phoneNumberTextField.getText().equals("") || !addressTextField.getText().equals("")) {
			
		
			//retrieve input
			String inputID = idTextField.getText();
			String inputName = nameTextField.getText();
			String inputEmail = emailTextField.getText();
			String inputNum = phoneNumberTextField.getText();
			String inputAddress = addressTextField.getText();
			
			//create connection and receive member list
			Connection con = null;
			Statement  stm = null;
			ArrayList<Member> memList = new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			stm = con.createStatement();
			
			ResultSet rs=stm.executeQuery("SELECT * FROM members");
			
			while(rs.next())
				memList.add(new Member(rs.getString("memberCardID"), rs.getString("name"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("address"), rs.getDouble("points")));
			
			stm.close();
			
			//search if given ID is taken. if not add the new member else display message.
			boolean flag = false;
			
			for(Member mem : memList)
			{
				if( mem.getMemberCardId().equals(inputID) )
				{
					JOptionPane.showMessageDialog(null, "Given Member/Card ID already taken.", "ERROR", 2);
					flag = true;
					break;
				}
			}
			
			if(flag == false)
			{
				stm = con.createStatement();
				stm.executeUpdate("INSERT INTO members VALUES('" + inputID + "', '" + inputName + "', '" + inputAddress + "', '" + inputNum + "', '" + inputEmail + "', 0)"); 
				stm.close();
				//update the table
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.addRow(new Object[] {inputID, inputName, inputEmail, inputNum, inputAddress});
			}
			
			con.close();
		}
		else {
			JOptionPane.showMessageDialog(null, "Please fill every field", "ERROR", 2);
		}
		
	}
	
	
	private void deleteMemberButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		//get Selected Row
		int index = table1.getSelectedRow();		
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		if(index == -1)
		{
			JOptionPane.showMessageDialog(null, "No member selected", "ERROR", 2);
		}
		else
		{
			String selectedID = (String) table1.getValueAt(index, 0);
			model.removeRow(index);
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
				Statement stm = con.createStatement();
				stm.executeUpdate("DELETE FROM  members WHERE memberCardID = '" + selectedID + "'");
				stm.close();
				con.close();

			}
			catch (Exception e4)
			{
				e4.printStackTrace();
			}
		}		
	}
}
