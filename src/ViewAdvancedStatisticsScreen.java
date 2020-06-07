import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;






@SuppressWarnings("serial")
public class ViewAdvancedStatisticsScreen extends JInternalFrame {
	
	public ViewAdvancedStatisticsScreen() {
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
	
	
	private DefaultCategoryDataset createDataset() {

	    String series1 = "Coca Cola Light";

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	    dataset.addValue(200, series1, "2016-12-19");
	    dataset.addValue(150, series1, "2016-12-20");
	    dataset.addValue(100, series1, "2016-12-21");
	    dataset.addValue(210, series1, "2016-12-22");
	    dataset.addValue(240, series1, "2016-12-23");
	    dataset.addValue(195, series1, "2016-12-24");
	    dataset.addValue(245, series1, "2016-12-25");

	    

	    return dataset;
	  }

}
