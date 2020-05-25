import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Mon May 25 19:40:00 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class OrderProductsScreen extends JInternalFrame {
	public OrderProductsScreen() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		textField1 = new JTextField();
		label1 = new JLabel();
		textField2 = new JTextField();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		label3 = new JLabel();

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
				this.setTitle("Order Supplies");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);
				contentPane.add(textField1);
				textField1.setBounds(90, 125, 140, textField1.getPreferredSize().height);

				//---- label1 ----
				label1.setText("Product ID");
				contentPane.add(label1);
				label1.setBounds(new Rectangle(new Point(20, 130), label1.getPreferredSize()));
				contentPane.add(textField2);
				textField2.setBounds(90, 170, 140, 28);

				//---- label2 ----
				label2.setText("Quantity");
				contentPane.add(label2);
				label2.setBounds(new Rectangle(new Point(20, 175), label2.getPreferredSize()));

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Product", "Quantity"
						}
					) {
						Class<?>[] columnTypes = new Class<?>[] {
							String.class, Integer.class
						};
						boolean[] columnEditable = new boolean[] {
							false, false
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
				button1.setText("Add to order");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign1.png")));
				contentPane.add(button1);
				button1.setBounds(105, 225, 120, 40);

				//---- button2 ----
				button2.setText("Send order");
				button2.setIcon(new ImageIcon(getClass().getResource("/order.png")));
				contentPane.add(button2);
				button2.setBounds(90, 320, 130, 40);

				//---- label3 ----
				label3.setIcon(new ImageIcon(getClass().getResource("/order (2).png")));
				contentPane.add(label3);
				label3.setBounds(75, 5, 110, 85);
			}
			panel1.add(this);
			this.setBounds(0, 0, 590, 415);

			panel1.setPreferredSize(new Dimension(590, 415));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JTextField textField1;
	private JLabel label1;
	private JTextField textField2;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
