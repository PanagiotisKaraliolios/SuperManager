import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 19 18:28:30 EEST 2020
 */



/**
 * @author Panagiotis Karaliolios
 */
@SuppressWarnings("serial")
public class ViewAdvancedStatisticsScreen extends JInternalFrame {
	public ViewAdvancedStatisticsScreen() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();

		//======== panel1 ========
		{
			panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
			swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border
			. TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog"
			, java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder
			() ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
			. beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException
			( ) ;} } );
			panel1.setLayout(null);

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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
