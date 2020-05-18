import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Sun May 17 23:00:48 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
public class ViewStockScreen extends JInternalFrame  {

	public ViewStockScreen() {
		initComponents();
		this.setLocation(50, 50);
		
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();

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
				this.setTitle("Stock");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);

				//======== scrollPane1 ========
				{

					//---- table1 ----
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"STOCK", "NAME", "ID"
						}
					) {
						boolean[] columnEditable = new boolean[] {
							false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return columnEditable[columnIndex];
						}
					});
					table1.setAutoCreateRowSorter(true);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(10, 5, 470, 490);

				//---- button1 ----
				button1.setText("Order Products");
				button1.setIcon(new ImageIcon(getClass().getResource("/order.png")));
				contentPane.add(button1);
				button1.setBounds(new Rectangle(new Point(170, 505), button1.getPreferredSize()));
			}
			panel1.add(this);
			this.setBounds(0, 0, 500, 600);

			panel1.setPreferredSize(new Dimension(500, 600));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
