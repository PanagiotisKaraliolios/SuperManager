import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 15 18:10:40 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class ScanProductsScreen extends JInternalFrame {
	public ScanProductsScreen() {
		initComponents();
		this.setLocation(50, 50);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		textField5 = new JTextField();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();

		//======== panel1 ========
		{
			panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
			. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
			. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
			12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
			. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
			getPropertyName () )) throw new RuntimeException( ); }} );
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setTitle("Add Bill");
				this.setResizable(true);
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);
				contentPane.add(textField1);
				textField1.setBounds(110, 50, 150, textField1.getPreferredSize().height);

				//---- textField2 ----
				textField2.setEditable(false);
				contentPane.add(textField2);
				textField2.setBounds(110, 170, 150, 28);

				//---- textField3 ----
				textField3.setColumns(2);
				textField3.setEditable(false);
				contentPane.add(textField3);
				textField3.setBounds(110, 110, 150, 28);

				//---- textField4 ----
				textField4.setText("1");
				contentPane.add(textField4);
				textField4.setBounds(110, 230, 70, 28);

				//---- label1 ----
				label1.setText("Product ID");
				contentPane.add(label1);
				label1.setBounds(new Rectangle(new Point(30, 55), label1.getPreferredSize()));

				//---- label2 ----
				label2.setText("Name");
				contentPane.add(label2);
				label2.setBounds(30, 115, 57, 16);

				//---- label3 ----
				label3.setText("Price");
				contentPane.add(label3);
				label3.setBounds(30, 175, 57, 16);

				//---- label4 ----
				label4.setText("Quantity");
				contentPane.add(label4);
				label4.setBounds(30, 235, 57, 16);

				//---- label5 ----
				label5.setText("Date");
				label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
				contentPane.add(label5);
				label5.setBounds(465, 15, 57, 16);

				//---- textField5 ----
				textField5.setEditable(false);
				contentPane.add(textField5);
				textField5.setBounds(545, 10, 150, 28);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME", "PRICE", "QUANTITY"
						}
					));
					table1.setAutoCreateRowSorter(true);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(355, 50, 520, 400);

				//---- button1 ----
				button1.setText("Add Product");
				button1.setIcon(new ImageIcon(getClass().getResource("/plusSign3.png")));
				contentPane.add(button1);
				button1.setBounds(20, 290, 150, 40);

				//---- button2 ----
				button2.setText("Remove Product");
				button2.setIcon(new ImageIcon(getClass().getResource("/minusSign.png")));
				contentPane.add(button2);
				button2.setBounds(185, 290, 150, 40);

				//---- button3 ----
				button3.setText("Proceed to Payment");
				button3.setIcon(new ImageIcon(getClass().getResource("/payment1.png")));
				contentPane.add(button3);
				button3.setBounds(80, 375, 195, 40);
			}
			panel1.add(this);
			this.setBounds(0, 0, 905, 500);

			panel1.setPreferredSize(new Dimension(905, 500));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField textField5;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
