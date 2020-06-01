import java.awt.*;
import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.beans.PropertyVetoException;


@SuppressWarnings("serial")
public class ManagerScreen extends JFrame {
	private boolean isCLSopen = false;
	private boolean isPLSopen = false;
	private boolean isStatisticsScreenOpen = false;
	private boolean isstockScreenOpen = false;
	
	public ManagerScreen() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	
	
	private void ManagerScreenActionPerformed(java.awt.event.ActionEvent evt){
		if(evt.getSource().equals(button1)) {
			
			if(isCLSopen==false) {
				RUDCashierListScreen cls = new RUDCashierListScreen();
				this.desktopPane1.add(cls);
				cls.setVisible(true);
				cls.toFront();
				try {
					cls.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cls.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isCLSopen = false;
					}

				});
				if(cls.isEnabled()) {
					isCLSopen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(RUDCashierListScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(RUDCashierListScreen.class)) {
						i.moveToFront();
						try {
							i.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		else if(evt.getSource().equals(button2)) {
			
			if(isPLSopen==false) {
				RUDProductListScreen pls = new RUDProductListScreen();
				this.desktopPane1.add(pls);
				pls.setVisible(true);
				pls.toFront();
				try {
					pls.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pls.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isPLSopen = false;
					}

				});
				if(pls.isEnabled()) {
					isPLSopen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(RUDProductListScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(RUDProductListScreen.class)) {
						i.moveToFront();
						try {
							i.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		else if(evt.getSource().equals(button3)) {
			
			if(isStatisticsScreenOpen==false) {
				ViewStatisticsScreen vStat = new ViewStatisticsScreen();
				this.desktopPane1.add(vStat);
				vStat.setVisible(true);
				vStat.toFront();
				try {
					vStat.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vStat.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isStatisticsScreenOpen = false;
					}

				});
				if(vStat.isEnabled()) {
					isStatisticsScreenOpen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(ViewStatisticsScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(ViewStatisticsScreen.class)) {
						i.moveToFront();
						try {
							i.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		else if(evt.getSource().equals(button4)) {

			if(isstockScreenOpen==false) {
				ViewStockScreen vStock = new ViewStockScreen();
				this.desktopPane1.add(vStock);
				vStock.setVisible(true);
				vStock.toFront();
				try {
					vStock.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vStock.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isstockScreenOpen = false;
					}

				});
				if(vStock.isEnabled()) {
					isstockScreenOpen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(ViewStockScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(ViewStockScreen.class)) {
						i.moveToFront();
						try {
							i.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
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
			button2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button3 ----
			button3.setText("View Statistics");
			button3.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
			panel1.add(button3);
			button3.setBounds(640, 15, 160, 40);
			button3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button4 ----
			button4.setText("View Stock");
			button4.setIcon(new ImageIcon(getClass().getResource("/stock.png")));
			panel1.add(button4);
			button4.setBounds(860, 15, 160, 40);
			button4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
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
	private JButton button3;
	private JButton button4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
