import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;






@SuppressWarnings("serial")
public class ViewAdvancedStatisticsScreen extends JInternalFrame {
	
	public ViewAdvancedStatisticsScreen(int ID, String FROM, String TO) {
		try
		{
			retrieveSales(ID, FROM, TO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		initComponents();
		this.setLocation(80, 30);
	}

	private void initComponents() {
		
		panel1 = new JPanel();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);
			
			// Create dataset
		    DefaultCategoryDataset dataset = createDataset();
		    // Create chart
		    JFreeChart chart = ChartFactory.createLineChart(
		        "Product Sales", // Chart title
		        "Date", // X-Axis Label
		        "Quantity Sold", // Y-Axis Label
		        dataset
		        );

		    
		    ChartPanel panel = new ChartPanel(chart);
		    setContentPane(panel);

			//======== this ========
			{
				this.setVisible(true);
				this.setClosable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.setTitle("Advanced Statistics");
				var contentPane = this.getContentPane();
				contentPane.setLayout(null);
			}
			panel1.add(this);
			this.setBounds(0, 0, 900, 500);

			panel1.setPreferredSize(new Dimension(900, 500));
		}
		
	}

	
	private JPanel panel1;
	ArrayList<Sale> sales = new ArrayList<>();
	
	
	private DefaultCategoryDataset createDataset() {

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    if(!(sales.size()>9))
	    {
	    	for(Sale sale : sales)
	    	{
	    		dataset.addValue(sale.getQuantity(), sale.getProduct().getName(), sale.getDate());
	    	}
	    }
	    else
	    {
	    	for(int i = 0; i<sales.size(); i++)
	    	{
	    		if(i == 0 || i == (Integer) sales.size()-1/2 || i ==  sales.size()-1)
	    		{
	    			dataset.addValue(sales.get(i).getQuantity(), sales.get(i).getProduct().getName(), sales.get(i).getDate());
	    		}
	    		else
	    		{
	    			dataset.addValue(sales.get(i).getQuantity(), sales.get(i).getProduct().getName(), "");
	    		}
	    	}
	    }

	    return dataset;
	  }
	
	private void retrieveSales(int ID, String FROM, String TO) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sm", "root", "");
		Statement stm = con.createStatement();
		ResultSet rs;
		
		
		if(!FROM.equals("") && !TO.equals(""))
		{
			//Both dates given
			rs = stm.executeQuery("SELECT sales.date, sales.quantity, products.name"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.id = " + ID + " AND sales.date >= '" + FROM + "' AND sales.date <= '" + TO + "'");
			
			while(rs.next())
			{
				sales.add(new Sale(new Product(rs.getString("products.name"), 0, "", 0,  0, 0), rs.getInt("sales.quantity"), rs.getString("sales.date")));
			}
			
			
		}
		else if(!FROM.equals("") && TO.equals(""))
		{
			//Only from given
			rs = stm.executeQuery("SELECT sales.date, sales.quantity, products.name"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.id = " + ID + " AND sales.date >= '" + FROM + "'");
			
			while(rs.next())
			{
				sales.add(new Sale(new Product(rs.getString("products.name"), 0, "", 0,  0, 0), rs.getInt("sales.quantity"), rs.getString("sales.date")));
			}
		}
		else if(FROM.equals("") && !TO.equals(""))
		{
			//Only to given
			rs = stm.executeQuery("SELECT sales.date, sales.quantity, products.name"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.id = " + ID + " AND sales.date <= '" + TO + "'");
			
			while(rs.next())
			{
				sales.add(new Sale(new Product(rs.getString("products.name"), 0, "", 0,  0, 0), rs.getInt("sales.quantity"), rs.getString("sales.date")));
			}
		}
		else if(FROM.equals("") && TO.equals(""))
		{
			//No dates given
			rs = stm.executeQuery("SELECT sales.date, sales.quantity, products.name"
					+ " FROM sales JOIN products ON sales.id = products.id "
					+ "WHERE sales.id = " + ID);
			
			while(rs.next())
			{
				sales.add(new Sale(new Product(rs.getString("products.name"), 0, "", 0,  0, 0), rs.getInt("sales.quantity"), rs.getString("sales.date")));
			}
		}
		
		
		
		stm.close();
		con.close();
	}

}
