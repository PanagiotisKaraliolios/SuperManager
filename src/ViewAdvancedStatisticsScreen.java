import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;






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
		this.setLocation(200, 50);
	}

	@SuppressWarnings("static-access")
	private void initComponents() {
		
		panel1 = new JPanel();

		//======== panel1 ========
		{
			
			panel1.setLayout(null);
			
			//Create Chart
		    DateAxis timeAxis = new DateAxis("Date");
	        timeAxis.setUpperMargin(DateAxis.DEFAULT_UPPER_MARGIN /* * 2*/); // UPDATED
	        timeAxis.setLowerMargin(DateAxis.DEFAULT_LOWER_MARGIN /* * 2*/); // UPDATED
	        timeAxis.setDateFormatOverride(new SimpleDateFormat("YYYY-MM-dd"));
	        NumberAxis numberAxis = new NumberAxis("Quantity");
	        numberAxis.setAutoRangeIncludesZero(false);
	        numberAxis.setStandardTickUnits(numberAxis.createIntegerTickUnits());
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
	        XYPlot plot = new XYPlot(createDataset(), timeAxis, numberAxis, renderer);
	        plot.setBackgroundPaint(Color.lightGray);
	        plot.setDomainGridlinePaint(Color.white);
	        plot.setRangeGridlinePaint(Color.white);
	        JFreeChart lineChart = new JFreeChart("Product Sales " + sales.get(0).getDate() + " / " + sales.get(sales.size()-1).getDate(), plot);
	        lineChart.setBackgroundPaint(Color.white);
	        ChartPanel chartPanel = new ChartPanel(lineChart);
	        //add(chartPanel);
		    
		    
		    //ChartPanel panel = new ChartPanel(chart1);
		    setContentPane(chartPanel);

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
	
	
	
	
	private TimeSeriesCollection createDataset() {

        TimeSeries typeA = new TimeSeries(sales.get(0).getProduct().getName());
        TimeSeriesCollection collection = new TimeSeriesCollection();

        collection.addSeries(typeA);
        for(Sale sale : sales) {
        	typeA.add(Day.parseDay(sale.getDate()) , sale.getQuantity());
        }
        
        return collection;
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
