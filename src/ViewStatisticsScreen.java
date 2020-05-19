import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Tue May 19 17:55:44 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class ViewStatisticsScreen extends JInternalFrame {
	public ViewStatisticsScreen() {
		initComponents();
		this.setLocation(30, 10);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();

		//======== panel1 ========
		{
			panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
			javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
			.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
			.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
			.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
			PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
			equals(e.getPropertyName()))throw new RuntimeException();}});
			panel1.setLayout(null);

			//======== this ========
			{
				this.setVisible(true);
				this.setTitle("Statistics");
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setResizable(true);
				this.setClosable(true);
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"PRODUCT", "SOLD"
						}
					) {
						boolean[] columnEditable = new boolean[] {
							false, false
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
				scrollPane1.setBounds(new Rectangle(new Point(425, 10), scrollPane1.getPreferredSize()));

				//---- button1 ----
				button1.setText("Confirm");
				button1.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(button1);
				button1.setBounds(new Rectangle(new Point(280, 130), button1.getPreferredSize()));

				//---- button2 ----
				button2.setText("Advanced Statistics");
				button2.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
				contentPane.add(button2);
				button2.setBounds(new Rectangle(new Point(225, 360), button2.getPreferredSize()));
			}
			panel1.add(this);
			this.setBounds(0, 0, 900, 475);

			panel1.setPreferredSize(new Dimension(900, 475));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
