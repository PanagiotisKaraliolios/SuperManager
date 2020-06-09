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




@SuppressWarnings("serial")
public class ViewStatisticsScreen extends JInternalFrame {
	public ViewStatisticsScreen() {
		initComponents();
		this.setLocation(130, 50);
	}

	private void initComponents() {
		
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		confirmButton = new JButton();
		advancedStatisticsButton = new JButton();
		datePickerFrom = new DatePicker();
		datePickerTo = new DatePicker();
		fromLabel = new JLabel();
		toLabel = new JLabel();
		productIDlabel = new JLabel();
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
				confirmButton.setText("Confirm");
				confirmButton.setIcon(new ImageIcon(getClass().getResource("/checkMark.png")));
				contentPane.add(confirmButton);
				confirmButton.setBounds(new Rectangle(new Point(140, 200), confirmButton.getPreferredSize()));
				confirmButton.addActionListener(new ActionListener() {
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
				advancedStatisticsButton.setText("Advanced Statistics");
				advancedStatisticsButton.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
				contentPane.add(advancedStatisticsButton);
				advancedStatisticsButton.setBounds(new Rectangle(new Point(75, 305), advancedStatisticsButton.getPreferredSize()));
				advancedStatisticsButton.addActionListener(new ActionListener() {
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
				datePickerFrom.setSettings(datePickerSettings1);
				contentPane.add(datePickerFrom);
				datePickerFrom.setBounds(90, 100, 170, datePickerFrom.getPreferredSize().height);

				//---- datePicker2 ----
				datePickerSettings2.getFormatsForParsing().add(formatter);
				datePickerSettings2.setFormatForDatesCommonEra(formatter);
				datePickerSettings2.setFormatForDatesBeforeCommonEra(formatter);
				datePickerSettings2.setFormatForTodayButton(formatter);
				datePickerTo.setSettings(datePickerSettings2);
				contentPane.add(datePickerTo);
				datePickerTo.setBounds(90, 150, 170, 30);
				
				//---- label1 ----
				fromLabel.setText("From :");
				fromLabel.setFont(fromLabel.getFont().deriveFont(fromLabel.getFont().getSize() + 5f));
				contentPane.add(fromLabel);
				fromLabel.setBounds(new Rectangle(new Point(35, 100), fromLabel.getPreferredSize()));

				//---- label2 ----
				toLabel.setText("To :");
				toLabel.setFont(toLabel.getFont().deriveFont(toLabel.getFont().getSize() + 5f));
				contentPane.add(toLabel);
				toLabel.setBounds(55, 150, 30, 23);

				//---- label3 ----
				productIDlabel.setText("Product ID :");
				productIDlabel.setFont(productIDlabel.getFont().deriveFont(productIDlabel.getFont().getSize() + 3f));
				contentPane.add(productIDlabel);
				productIDlabel.setBounds(new Rectangle(new Point(10, 45), productIDlabel.getPreferredSize()));
				contentPane.add(textField1);
				textField1.setBounds(90, 40, 125, 30);
			}
			panel1.add(this);
			this.setBounds(0, 0, 745, 465);

			panel1.setPreferredSize(new Dimension(745, 465));
		}
		
		
	}

	
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton confirmButton; //confirm button
	private JButton advancedStatisticsButton; //advanced statistics button
	private DatePicker datePickerFrom; //from Field
	private DatePicker datePickerTo; //to Field
	private JLabel fromLabel;
	private JLabel toLabel;
	private JLabel productIDlabel;
	private JTextField textField1;
	private DatePickerSettings datePickerSettings1;
	private DatePickerSettings datePickerSettings2;
	
	
	private void confirmButtonAction(ActionEvent e) throws SQLException, ClassNotFoundException
	{
		String from = datePickerFrom.getComponentDateTextField().getText();
		String to = datePickerTo.getComponentDateTextField().getText();
		String ID = textField1.getText();
		
		if(!ID.equals("") && from.equals("") && to.equals(""))
		{
			//Only ID given
			int inputID = Integer.parseInt(ID);
			
			//Empty the table
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() - 1; i>=0; i--)
			{
				model.removeRow(i);
			}
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			String name = "";
			int quantity = 0;
			
			
			ResultSet rs = stm.executeQuery("SELECT products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE products.id = " + inputID );
			
			while(rs.next())
			{
				name = rs.getString("products.name");
				quantity += rs.getInt("sales.quantity");
			}
			
			if(name.equals("") || quantity == 0)
				JOptionPane.showMessageDialog(null, "No product / sale with given product ID", "Notification", 2);
			else
			{
				model.addRow(new Object[] {name, quantity});
			}
			
			con.close();
			stm.close();
			
		}
		else if(!ID.equals("") && !from.equals("") && to.equals(""))
		{
			//ID and from date given
			int inputID = Integer.parseInt(ID);
			
			String name = "";
			int quantity = 0;
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			//Empty the table
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() - 1; i>=0; i--)
			{
				model.removeRow(i);
			}
			
			ResultSet rs = stm.executeQuery("SELECT products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE products.id = " + inputID + " AND sales.date >= '" + from + "'");
			
			while(rs.next())
			{
				name = rs.getString("products.name");
				quantity += rs.getInt("sales.quantity");
			}
			
			if(name.equals("") || quantity == 0)
				JOptionPane.showMessageDialog(null, "No product / sale with given product ID", "Notification", 2);
			else
			{
				model.addRow(new Object[] {name, quantity});
			}
			
			con.close();
			stm.close();
			
		}
		else if(!ID.equals("") && !from.equals("") && !to.equals("") )
		{
			//all fields given
			int inputID = Integer.parseInt(ID);
			
			String name = "";
			int quantity = 0;
			
			//empty the table
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount()-1; i>=0; i--)
			{
				model.removeRow(i);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE products.id =" + inputID + " AND sales.date >='" + from + "' AND sales.date<= '" + to + "'");
			
			while(rs.next())
			{
				name = rs.getString("products.name");
				quantity+= rs.getInt("sales.quantity");
			}
			
			if(name.equals("") || quantity == 0)
				JOptionPane.showMessageDialog(null, "No product / sale with given product ID", "Notification", 2);
			else
			{
				model.addRow(new Object[] {name, quantity});
			}
			
			
			con.close();
			stm.close();			
		}
		else if(!ID.equals("") && from.equals("") && !to.equals(""))
		{
			//ID and to fields given
			int inputID = Integer.parseInt(ID);
			
			String name = "";
			int quantity = 0;
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() - 1; i>=0; i--)
			{
				model.removeRow(i);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE products.id = " + inputID + " AND sales.date <= '" + to + "'");
			
			while(rs.next())
			{
				name = rs.getString("products.name");
				quantity+= rs.getInt("sales.quantity");
			}
			
			if(name.equals("") || quantity == 0)
				JOptionPane.showMessageDialog(null, "No product / sale with given product ID", "Notification", 2);
			else
			{
				model.addRow(new Object[] {name, quantity});
			}
			
			con.close();
			stm.close();
		}
		else if(ID.equals("") && !from.equals("") && !to.equals(""))
		{
			//Only from and to fields given
			ArrayList<Sale> sales = new ArrayList<>();
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() - 1; i>=0; i--)
			{
				model.removeRow(i);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT products.id, products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.ID "
					+ "WHERE sales.date>= '" + from + "' AND sales.date <= '" + to + "'");
			
			while(rs.next())
			{
				int inID = rs.getInt("products.id");
				String inName = rs.getString("products.name");
				int inQuantity = rs.getInt("sales.quantity");
				
				boolean prodFound = false;
				int index =-1;
				for(int i=0; i<sales.size(); i++)
				{
					if( sales.get(i).getProduct().getProductsID() == inID)
					{
						prodFound = true;
						index = i;
					}
				}
				
				if(prodFound)
				{
					sales.get(index).setQuantity( sales.get(index).getQuantity() + inQuantity);
				}
				else
				{
					sales.add(new Sale(new Product(inName, 0, "", inID, 0, 0), inQuantity, ""));
				}
			}
			
			for(int i = 0; i < sales.size(); i++)
			{
				model.addRow(new Object[] {sales.get(i).getProduct().getName(), sales.get(i).getQuantity()});
			}
			
			if(model.getRowCount() == 0)
				JOptionPane.showMessageDialog(null, "No sales during given period", "Notification", 2);
			
			con.close();
			stm.close();
		}
		else if(ID.equals("") && !from.equals("") && to.equals(""))
		{
			//error
			//only from field given
			ArrayList<Sale> sales = new ArrayList<>();
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() - 1; i >= 0; i--)
			{
				model.removeRow(i);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", ""); 
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT products.id, products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.date >= '" + from + "'");
			
			while(rs.next())
			{
				int inID = rs.getInt("products.id");
				String inName = rs.getString("products.name");
				int inQuantity = rs.getInt("sales.quantity");
				
				boolean prodFound = false;
				int index =-1;
				for(int i=0; i<sales.size(); i++)
				{
					if( sales.get(i).getProduct().getProductsID() == inID)
					{
						prodFound = true;
						index = i;
					}
				}
				
				if(prodFound)
				{
					sales.get(index).setQuantity( sales.get(index).getQuantity() + inQuantity);
				}
				else
				{
					sales.add(new Sale(new Product(inName, 0, "", inID, 0, 0), inQuantity, ""));
				}
			}
			
			for(int i = 0; i < sales.size(); i++)
			{
				model.addRow(new Object[] {sales.get(i).getProduct().getName(), sales.get(i).getQuantity()});
			}
			
			if(model.getRowCount() == 0)
				JOptionPane.showMessageDialog(null, "No sales during given period", "Notification", 2);
			
			con.close();
			stm.close();
		}
		else if(ID.equals("") && from.equals("") && !to.equals(""))
		{
			//only to field given
			ArrayList<Sale> sales = new ArrayList<>();
			
			DefaultTableModel model = (DefaultTableModel) table1.getModel();
			for(int i = model.getRowCount() -1 ; i >= 0; i--)
			{
				model.removeRow(i);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT products.id, products.name, sales.quantity"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.date <= '" + to + "'");
			
			while(rs.next())
			{
				int inID = rs.getInt("products.id");
				String inName = rs.getString("products.name");
				int inQuantity = rs.getInt("sales.quantity");
				
				boolean prodFound = false;
				int index =-1;
				for(int i=0; i<sales.size(); i++)
				{
					if( sales.get(i).getProduct().getProductsID() == inID)
					{
						prodFound = true;
						index = i;
					}
				}
				
				if(prodFound)
				{
					sales.get(index).setQuantity( sales.get(index).getQuantity() + inQuantity);
				}
				else
				{
					sales.add(new Sale(new Product(inName, 0, "", inID, 0, 0), inQuantity, ""));
				}
			}
			
			for(int i = 0; i < sales.size(); i++)
			{
				model.addRow(new Object[] {sales.get(i).getProduct().getName(), sales.get(i).getQuantity()});
			}
			
			if(model.getRowCount() == 0)
				JOptionPane.showMessageDialog(null, "No sales during given period", "Notification", 2);
			
			con.close();
			stm.close();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No input", "WARNING", 2);
		}
		
		
	}
	
	
	private void advancedStatisticsButtonAction(ActionEvent e)
	{
		if(!this.textField1.getText().equals("") && this.table1.getRowCount() != 0) {
			
			ViewAdvancedStatisticsScreen vas = new ViewAdvancedStatisticsScreen(Integer.parseInt(textField1.getText()), datePickerFrom.getComponentDateTextField().getText(), datePickerTo.getComponentDateTextField().getText());
			this.getParent().add(vas);
			vas.setVisible(true);
			vas.toFront();	
			try {
				vas.setSelected(true);
			} catch (PropertyVetoException e1) {
				
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please first select one product ID and press Confirm.\nThen press Advanced Statistics", "WARNING", 2);
		}
	}
}
