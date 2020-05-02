import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.plaf.*;
import com.jgoodies.forms.factories.*;





public class LoginScreen extends JFrame {
	
	
	public static void main(String[] args)
	{
		new LoginScreen().setVisible(true);
		
	}
	
	public LoginScreen() {
		initComponents();
		this.setLocation(300,100);
	}
	
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JButton LoginButton;
	private JPasswordField passwordField1;
	private JLabel label1;
	private JTextField textField1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	



	private void initComponents() {
		
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		LoginButton = new JButton();
		passwordField1 = new JPasswordField();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();

		
		setTitle("Login");
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
						LoginButtonActionPerformed(evt);
					}
				});

				
				label1.setText("Welcome to Super Manager");
				label1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
				label1.setAlignmentY(0.0F);
				label1.setBorder(Borders.DLU2);
				label1.setHorizontalAlignment(SwingConstants.CENTER);

				
				label2.setText("Username/ID");
				label2.setLabelFor(textField1);

				
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
									.addGap(184, 184, 184)
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
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
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
										.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
	
	
	private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
	       this.dispose();
	    }

}