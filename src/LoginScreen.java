import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.UIManager.*;


@SuppressWarnings("serial")
public class LoginScreen extends JFrame {
	
	
	public static void main(String[] args)
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {				//set look and feel
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} 
		catch (Exception e) {
			
		}
		
		new LoginScreen();
		
	}
	
	public LoginScreen() {					//login screen constructor
		initComponents(); 
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JButton LoginButton;
	private JPasswordField passwordField1;
	private JLabel label1;
	private JTextField nameField;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	
	private static Connection con = null ;
	private static Statement  stm = null ;
	
	private ArrayList<Cashier> listOfcashiers;
	private ArrayList<Manager> listOfmanagers;
	

	private void initComponents() {				//login screen components
		
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		LoginButton = new JButton();
		passwordField1 = new JPasswordField();
		label1 = new JLabel();
		nameField = new JTextField();			
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();

		
		setTitle("Super Manager");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

	
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(0, 102, 204));
			dialogPane.setLayout(new BorderLayout());

		
			{
				contentPanel.setBackground(new Color(52, 140, 238));

				
				LoginButton.setText("Login");
				LoginButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						try {
							LoginButtonActionPerformed(evt);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
				});

				
				label1.setText("Welcome to Super Manager");
				label1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
				label1.setAlignmentY(TOP_ALIGNMENT);
				label1.setAlignmentX(CENTER_ALIGNMENT);
				label1.setBorder(Borders.DLU2);
				label1.setHorizontalAlignment(SwingConstants.CENTER);

				
				label2.setText("Username/ID");
				label2.setLabelFor(nameField);

				
				label3.setText("Password");
				label3.setLabelFor(passwordField1);

				
				label4.setIcon(new ImageIcon(getClass().getResource("/logo.png")));

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
					.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addGap(250, 250, 250)
									.addComponent(label1)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(label4, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
									.addGroup(contentPanelLayout.createParallelGroup()
										.addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
							.addGroup(contentPanelLayout.createParallelGroup()
								.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGap(17, 17, 17))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
									.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(18, 18, 18)
									.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(14, 14, 14)
									.addComponent(LoginButton)
									.addGap(141, 141, 141))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addGap(37, 37, 37)
									.addComponent(label4, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(102, Short.MAX_VALUE))))
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	       
	private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		
		listOfcashiers = new ArrayList<Cashier>();
		listOfmanagers = new ArrayList<Manager>();
		
		char[] comparepasswordfield = passwordField1.getPassword();
		String compareusernamefield = nameField.getText();
		Cashier cashier ;
		Manager manager;
		boolean found=false;
		
		
		Class.forName ("com.mysql.cj.jdbc.Driver");											//
		con = DriverManager.getConnection ("jdbc:mysql://localhost/sm", "root", "");		//DB connection
		stm = con.createStatement () ;														//
		
		ResultSet rs = stm.executeQuery("SELECT * FROM cashiers");
		while (rs.next()) {
			cashier=new Cashier(rs.getString("username"), rs.getString("password"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNumber"),rs.getString("address"));
	        listOfcashiers.add(cashier);
	    }
		
		rs=stm.executeQuery("SELECT * FROM manager");
		while(rs.next()) {
			manager=new Manager(rs.getString("username"), rs.getString("password"));
			listOfmanagers.add(manager);
		}
		
		
		manager=listOfmanagers.get(0);
		
		char[] managerPass = new char[manager.getPassword().length()];
		for (int i = 0; i < manager.getPassword().length(); i++){
	        managerPass[i] = manager.getPassword().charAt(i);
	    }
		
		for(Cashier c : listOfcashiers) {
			
			char[] cashierPass = new char[c.getPassword().length()];
			for (int i = 0; i < c.getPassword().length(); i++){
		        cashierPass[i] = c.getPassword().charAt(i);
		    }
			
			if(Arrays.equals(cashierPass, comparepasswordfield) && c.getUsername().equals(compareusernamefield)){
				this.dispose();
				new CashierScreen();
				found=true;
			}
				
		}
		
		if(Arrays.equals(managerPass, comparepasswordfield) && manager.getUsername().equals(compareusernamefield)) {
			this.dispose();
			new ManagerScreen();
			found=true;	
		}
		
		if(found==false) JOptionPane.showMessageDialog(null, "User not found", "ERROR", 2);
		stm.close () ;
		con.close () ;
		
	 }

}