import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Sat May 16 19:29:45 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class RUDProductListScreen extends JInternalFrame {
	public RUDProductListScreen() {
		initComponents();
		this.setLocation(50, 50);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
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
					) {
						boolean[] columnEditable = new boolean[] {
							false, false, false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(350, 15, 625, 440);

				//---- button1 ----
				button1.setText("Add Product");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign2.png")));
				contentPane.add(button1);
				button1.setBounds(20, 330, 150, 40);

				//---- button2 ----
				button2.setText("Update Product");
				button2.setIcon(new ImageIcon(getClass().getResource("/update.png")));
				contentPane.add(button2);
				button2.setBounds(190, 330, 150, 40);

				//---- button3 ----
				button3.setText("Delete Product");
				button3.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
				contentPane.add(button3);
				button3.setBounds(20, 385, 150, 40);
			}
			panel1.add(this);
			this.setBounds(0, 0, 1000, 500);

			panel1.setPreferredSize(new Dimension(1000, 500));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
