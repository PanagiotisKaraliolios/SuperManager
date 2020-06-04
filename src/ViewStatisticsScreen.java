import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
import com.github.lgooddatepicker.components.*;



/**
 * @author Panagiotis Karaliolios
 */
@SuppressWarnings("serial")
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
		datePicker1 = new DatePicker();
		datePicker2 = new DatePicker();
		label2 = new JLabel();
		label1 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textField1 = new JTextField();
		datePickerSettings1 = new DatePickerSettings();
		datePickerSettings2 = new DatePickerSettings();

		//======== panel1 ========
		{
			
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
						Class<?>[] columnTypes = new Class<?>[] {
							String.class, Double.class
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
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(table1);
				}
				contentPane.add(scrollPane1);
				scrollPane1.setBounds(270, 5, 461, scrollPane1.getPreferredSize().height);

				//---- button1 ----
				button1.setText("Confirm");
				button1.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(button1);
				button1.setBounds(new Rectangle(new Point(140, 200), button1.getPreferredSize()));
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							confirmButtonAction(e);
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
					}
				});

				//---- button2 ----
				button2.setText("Advanced Statistics");
				button2.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
				contentPane.add(button2);
				button2.setBounds(new Rectangle(new Point(75, 305), button2.getPreferredSize()));
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						advancedStatisticsButtonAction(e);
					}
				});

				//---- datePicker1 ----
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				datePickerSettings1.getFormatsForParsing().add(formatter);
				datePickerSettings1.setFormatForDatesCommonEra(formatter);
				datePickerSettings1.setFormatForDatesBeforeCommonEra(formatter);
				datePickerSettings1.setFormatForTodayButton(formatter);
				datePicker1.setSettings(datePickerSettings1);
				contentPane.add(datePicker1);
				datePicker1.setBounds(90, 100, 170, datePicker1.getPreferredSize().height);

				//---- datePicker2 ----
				datePickerSettings2.getFormatsForParsing().add(formatter);
				datePickerSettings2.setFormatForDatesCommonEra(formatter);
				datePickerSettings2.setFormatForDatesBeforeCommonEra(formatter);
				datePickerSettings2.setFormatForTodayButton(formatter);
				datePicker2.setSettings(datePickerSettings2);
				contentPane.add(datePicker2);
				datePicker2.setBounds(90, 150, 170, 30);

				//---- label2 ----
				label2.setText("From :");
				contentPane.add(label2);
				label2.setBounds(0, 443, 35, 16);

				//---- label1 ----
				label1.setText("From :");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
				contentPane.add(label1);
				label1.setBounds(new Rectangle(new Point(35, 100), label1.getPreferredSize()));

				//---- label3 ----
				label3.setText("To :");
				label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
				contentPane.add(label3);
				label3.setBounds(55, 150, 30, 23);

				//---- label4 ----
				label4.setText("Product ID :");
				label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
				contentPane.add(label4);
				label4.setBounds(new Rectangle(new Point(10, 45), label4.getPreferredSize()));
				contentPane.add(textField1);
				textField1.setBounds(90, 40, 125, 30);
			}
			panel1.add(this);
			this.setBounds(0, 0, 745, 465);

			panel1.setPreferredSize(new Dimension(745, 465));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1; //confirm button
	private JButton button2; //advanced statistics button
	private DatePicker datePicker1; //from Field
	private DatePicker datePicker2; //to Field
	private JLabel label2;
	private JLabel label1;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField1;
	private DatePickerSettings datePickerSettings1;
	private DatePickerSettings datePickerSettings2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	private void confirmButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		String from = datePicker1.getComponentDateTextField().getText();
		String to = datePicker2.getComponentDateTextField().getText();
		int inputID;
		if(!textField1.getText().equals(""))
		{
			inputID = Integer.parseInt(textField1.getText());
			if(from.equals("") || to .equals(""))
				JOptionPane.showMessageDialog(null, "No date given", "ERROR", 2);
			else
			{
				//Empty the table
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				for(int i = model.getRowCount()-1; i>=0; i--)
					model.removeRow(i);
				
				//fill the table with new input
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
				Statement stm = con.createStatement();
				
				ResultSet rs = stm.executeQuery("SELECT products.name, sales.quantity "
						+ "FROM products JOIN sales ON sales.id = products.id "
						+ "WHERE sales.date >= '" + from + "' AND sales.date <= '" + to + "' AND sales.id = " + inputID);
				
				ArrayList<String> names = new ArrayList<>();
				ArrayList<Integer> quantities = new ArrayList<>(); 
				//get names and quantities of products
				while(rs.next())
				{
					names.add(rs.getString("products.name"));
					quantities.add(rs.getInt("sales.quantity"));
				}
				//fill table
				for(int i = 0; i<names.size(); i++)
					model.addRow(new Object[] {names.get(i), quantities.get(i)});
			}
		}
		else
			JOptionPane.showMessageDialog(null, "No ID given", "ERROR", 2);
	}
	
	private void advancedStatisticsButtonAction(ActionEvent e)
	{
		ViewAdvancedStatisticsScreen ASC = new ViewAdvancedStatisticsScreen();
		
		this.getParent().add(ASC);
		
	}
}
