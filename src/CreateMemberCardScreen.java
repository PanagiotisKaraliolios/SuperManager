import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu May 14 18:04:36 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class CreateMemberCardScreen extends JInternalFrame {
	public CreateMemberCardScreen() {
		initComponents();
		this.setLocation(50, 50);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
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
		button1 = new JButton();
		button2 = new JButton();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();

		//======== panel1 ========
		{
			panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
			. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
			. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
			awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
			; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
			) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
			;
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
				textField1.setEditable(false);
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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JLabel label1;
	private JTextField textField1;
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
