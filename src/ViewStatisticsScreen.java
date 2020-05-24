import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.optionalusertools.*;
import com.github.lgooddatepicker.tableeditors.*;

import org.jdatepicker.*;

import java.util.Calendar;
import org.jdatepicker.impl.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
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
		datePicker1 = new DatePicker();
		datePicker2 = new DatePicker();
		label2 = new JLabel();
		label1 = new JLabel();
		label3 = new JLabel();
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
				scrollPane1.setBounds(420, 10, 461, scrollPane1.getPreferredSize().height);

				//---- button1 ----
				button1.setText("Confirm");
				button1.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(button1);
				button1.setBounds(new Rectangle(new Point(205, 160), button1.getPreferredSize()));

				//---- button2 ----
				button2.setText("Advanced Statistics");
				button2.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
				contentPane.add(button2);
				button2.setBounds(new Rectangle(new Point(225, 360), button2.getPreferredSize()));

				//---- datePicker1 ----
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				datePickerSettings1.getFormatsForParsing().add(formatter);
				datePickerSettings1.setFormatForDatesCommonEra(formatter);
				datePickerSettings1.setFormatForDatesBeforeCommonEra(formatter);
				datePickerSettings1.setFormatForTodayButton(formatter);
				datePicker1.setSettings(datePickerSettings1);
				contentPane.add(datePicker1);
				datePicker1.setBounds(135, 35, 170, datePicker1.getPreferredSize().height);

				//---- datePicker2 ----
				datePickerSettings2.getFormatsForParsing().add(formatter);
				datePickerSettings2.setFormatForDatesCommonEra(formatter);
				datePickerSettings2.setFormatForDatesBeforeCommonEra(formatter);
				datePickerSettings2.setFormatForTodayButton(formatter);
				datePicker2.setSettings(datePickerSettings2);
				contentPane.add(datePicker2);
				datePicker2.setBounds(135, 100, 170, 30);

				//---- label2 ----
				label2.setText("From :");
				contentPane.add(label2);
				label2.setBounds(0, 443, 35, 16);

				//---- label1 ----
				label1.setText("From :");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
				contentPane.add(label1);
				label1.setBounds(new Rectangle(new Point(75, 40), label1.getPreferredSize()));

				//---- label3 ----
				label3.setText("To :");
				label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
				contentPane.add(label3);
				label3.setBounds(75, 105, 48, 23);
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
	private DatePicker datePicker1;
	private DatePicker datePicker2;
	private JLabel label2;
	private JLabel label1;
	private JLabel label3;
	private DatePickerSettings datePickerSettings1;
	private DatePickerSettings datePickerSettings2;
	
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
