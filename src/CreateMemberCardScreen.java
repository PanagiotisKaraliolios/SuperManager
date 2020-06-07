import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;





@SuppressWarnings("serial")
public class CreateMemberCardScreen extends JInternalFrame {
	public CreateMemberCardScreen() {
		initComponents();
		this.setLocation(50, 50);
	}

	private void initComponents() {			//Members Screen Components
		
		panel1 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		button1 = new JButton();			//this button adds new member
		button2 = new JButton();			//this button deletes a selected member
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
				label1.setText("Member/Card ID");
				contentPane.add(label1);
				label1.setBounds(20, 55, 105, label1.getPreferredSize().height);

				//---- textField1 ----
				textField1.setEditable(true);
				contentPane.add(textField1);
				textField1.setBounds(145, 50, 170, textField1.getPreferredSize().height);

				//---- label2 ----
				label2.setText("Name");
				contentPane.add(label2);
				label2.setBounds(20, 105, 70, label2.getPreferredSize().height);
				contentPane.add(textField2);
				textField2.setBounds(145, 100, 170, 28);
				contentPane.add(textField3);
				textField3.setBounds(145, 150, 170, 28);
				contentPane.add(textField4);
				textField4.setBounds(145, 200, 170, 28);
				contentPane.add(textField5);
				textField5.setBounds(145, 250, 170, 28);

				//---- label3 ----
				label3.setText("Email");
				contentPane.add(label3);
				label3.setBounds(20, 155, 70, 16);

				//---- label4 ----
				label4.setText("Phone Number");
				contentPane.add(label4);
				label4.setBounds(20, 205, 100, 16);

				//---- label5 ----
				label5.setText("Address");
				contentPane.add(label5);
				label5.setBounds(20, 255, 70, 16);

				//---- button1 ----
				button1.setText("Add Member");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				contentPane.add(button1);
				button1.setBounds(20, 310, 150, 40);

				//---- button2 ----
				button2.setText("Delete Member");
				button2.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				contentPane.add(button2);
				button2.setBounds(190, 310, 150, 40);

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
		
		
		
		button1.addActionListener(new ActionListener()
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
		
		button2.addActionListener(new ActionListener()
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
	private JLabel label1;
	private JTextField textField1; //Member/Card ID field
	private JLabel label2;
	private JTextField textField2; //Name field
	private JTextField textField3; //Email field
	private JTextField textField4; //phoneNum field
	private JTextField textField5; //address field
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton button1; //addMemberButton
	private JButton button2; //deleteMemberButton
	private JScrollPane scrollPane1;
	private JTable table1;
	
	
	private void addMemberButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		if(!textField1.getText().equals("") || !textField2.getText().equals("") || !textField3.getText().equals("") || !textField4.getText().equals("") || !textField5.getText().equals("")) {
			
		
			//retrieve input
			String inputID = textField1.getText();
			String inputName = textField2.getText();
			String inputEmail = textField3.getText();
			String inputNum = textField4.getText();
			String inputAddress = textField5.getText();
			
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
