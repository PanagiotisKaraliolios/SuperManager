import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;
import java.awt.event.*;


public class ManagerScreen extends JFrame {
	
	public ManagerScreen() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	
	
	private void ManagerScreenActionPerformed(java.awt.event.ActionEvent evt){
		if(evt.getSource().equals(button1)) {
			RUDCashierListScreen cls = new RUDCashierListScreen();
			this.desktopPane1.add(cls);
			cls.setVisible(true);
		}
		//else if(evt.getSource().equals(button2)) new RUDProductListScreen();
		//else if(evt.getSource().equals(button3)) new ViewStatisticsScreen();
		//else if(evt.getSource().equals(button4)) new ViewStockScreen();
	}
	
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		desktopPane1 = new JDesktopPane();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();

		//======== this ========
		setMinimumSize(new Dimension(1280, 720));
		setTitle("Super Manager");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBorder(null);
			
			panel1.setLayout(null);

			//======== desktopPane1 ========
			{
				desktopPane1.setBorder(null);
			}
			panel1.add(desktopPane1);
			desktopPane1.setBounds(0, 65, 1280, 623);

			//---- button1 ----
			button1.setText("RUD Cashiers List");
			button1.setSelectedIcon(null);
			button1.setIcon(new ImageIcon(getClass().getResource("/addCashier.png")));
			panel1.add(button1);
			button1.setBounds(200, 15, 160, 40);
			button1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button2 ----
			button2.setText("RUD Products List");
			button2.setIcon(new ImageIcon(getClass().getResource("/package.png")));
			panel1.add(button2);
			button2.setBounds(420, 15, 160, 40);

			//---- button3 ----
			button3.setText("View Statistics");
			button3.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
			panel1.add(button3);
			button3.setBounds(640, 15, 160, 40);

			//---- button4 ----
			button4.setText("View Stock");
			button4.setIcon(new ImageIcon(getClass().getResource("/stock.png")));
			panel1.add(button4);
			button4.setBounds(860, 15, 160, 40);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel1.getComponentCount(); i++) {
					Rectangle bounds = panel1.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel1.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel1.setMinimumSize(preferredSize);
				panel1.setPreferredSize(preferredSize);
			}
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPaneLayout.setHonorsVisibility(false);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
	private JPanel panel1;
	private JDesktopPane desktopPane1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
