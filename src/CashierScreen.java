

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import com.jgoodies.forms.factories.Borders;

import net.miginfocom.swing.*;

public class CashierScreen extends JFrame {

	
	

	public CashierScreen() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void CashierScreenActionPerformed(java.awt.event.ActionEvent evt){
		if(evt.getSource().equals(button1)) {
			CreateMemberCardScreen mcs = new CreateMemberCardScreen();
			this.desktopPane1.add(mcs);
			mcs.setVisible(true);
		}
		else if(evt.getSource().equals(button2)) {
			ScanProductsScreen sps = new ScanProductsScreen();
			this.desktopPane1.add(sps);
			sps.setVisible(true);
		}
	}
	
	
	
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Panagiotis Karaliolios
		panel1 = new JPanel();
		desktopPane1 = new JDesktopPane();
		button1 = new JButton();
		button2 = new JButton();

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
			button1.setText("Create Member Card");
			button1.setSelectedIcon(null);
			button1.setIcon(new ImageIcon(getClass().getResource("/memberCard2.png")));
			panel1.add(button1);
			button1.setBounds(400, 15, 180, 40);
			button1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					CashierScreenActionPerformed(evt);
				}
			});

			//---- button2 ----
			button2.setText("      Add Bill");
			button2.setIcon(new ImageIcon(getClass().getResource("/transaction.png")));
			panel1.add(button2);
			button2.setBounds(700, 15, 160, 40);
			button2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					CashierScreenActionPerformed(evt);
				}
			});

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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}	



