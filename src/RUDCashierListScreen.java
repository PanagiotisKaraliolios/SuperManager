import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu May 14 16:27:15 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class RUDCashierListScreen extends JInternalFrame {
	public RUDCashierListScreen() {
		initComponents();
		this.setLocation(50, 50);
		
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
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
				this.setTitle("RUD Cashiers");
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
				contentPane.add(button1);
				button1.setBounds(15, 315, 145, 40);

				//---- button2 ----
				button2.setText("Delete Cashier");
				button2.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
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
					table1.setAutoCreateRowSorter(true);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(340, 10, 506, scrollPane1.getPreferredSize().height);

				//---- button3 ----
				button3.setText("Update Cashier");
				button3.setIcon(new ImageIcon(getClass().getResource("/update.png")));
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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
