import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.beans.PropertyVetoException;


@SuppressWarnings("serial")
public class ManagerScreen extends JFrame {
	private boolean isCLSopen = false;				//flag to check if the RUD Cashiers list Screen is open
	private boolean isPLSopen = false;				//flag to check if the RUD Products list Screen is open
	private boolean isStatisticsScreenOpen = false;	//flag to check if the Statistics Screen is open
	private boolean isStockScreenOpen = false;		//flag to check if the Stock Screen is open
	
	public ManagerScreen() {		//Manager Screen Constructor
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	
	
	private void ManagerScreenActionPerformed(ActionEvent evt){
		if(evt.getSource().equals(cashierListScreenButton)) {
			
			if(isCLSopen==false) {																			//
				RUDCashierListScreen cls = new RUDCashierListScreen();										//
				this.desktopPane1.add(cls);																	//
				cls.setVisible(true);																		//
				cls.toFront();																				//
				try {																						// Check if the internal window is open.
					cls.setSelected(true);																	// If it is not create a new one.
																											//
				} catch (PropertyVetoException e1) {														//
																											//
					e1.printStackTrace();																	//
				}																							//
				cls.addInternalFrameListener(new InternalFrameAdapter() {									//
					@Override																				//
					public void internalFrameClosing(InternalFrameEvent e) {								//
						isCLSopen = false;																	//
					}																						//
																											//
				});																							//
				if(cls.isEnabled()) {																		//
					isCLSopen = true;																		//
				}																							//
			}																								//
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(RUDCashierListScreen.class)) {	// If the desired window is already created and open,
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {									// try to set it on the foreground.
					if(i.getClass().equals(RUDCashierListScreen.class)) {									//
						i.moveToFront();																	//
						try {																				//
							i.setSelected(true);															//
																											//
						} catch (PropertyVetoException e) {													//
																											//
							e.printStackTrace();															//
						}																					//
					}
				}
			}
		}
		
		else if(evt.getSource().equals(productListButton)) {
			
			if(isPLSopen==false) {
				RUDProductListScreen pls = new RUDProductListScreen();
				this.desktopPane1.add(pls);
				pls.setVisible(true);																	//
				pls.toFront();																			//same as above
				try {																					//
					pls.setSelected(true);
					
				} catch (PropertyVetoException e1) {
					
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
							
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		else if(evt.getSource().equals(viewStatisticsScreenButton)) {
			
			if(isStatisticsScreenOpen==false) {
				ViewStatisticsScreen vStat = new ViewStatisticsScreen();
				this.desktopPane1.add(vStat);
				vStat.setVisible(true);																	//same as above
				vStat.toFront();
				try {
					vStat.setSelected(true);
				} catch (PropertyVetoException e1) {
					
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
							
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		else if(evt.getSource().equals(viewStockScreenButton)) {

			if(isStockScreenOpen==false) {
				ViewStockScreen vStock = new ViewStockScreen();
				this.desktopPane1.add(vStock);
				vStock.setVisible(true);
				vStock.toFront();
				try {
					vStock.setSelected(true);														//same as above
				} catch (PropertyVetoException e1) {
					
					e1.printStackTrace();
				}
				vStock.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isStockScreenOpen = false;
					}

				});
				if(vStock.isEnabled()) {
					isStockScreenOpen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(ViewStockScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(ViewStockScreen.class)) {
						i.moveToFront();
						try {
							i.setSelected(true);
						} catch (PropertyVetoException e) {
							
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	

	private void initComponents() {			//Manager Screen Components
		
		panel1 = new JPanel();
		desktopPane1 = new JDesktopPane();
		cashierListScreenButton = new JButton();
		productListButton = new JButton();
		viewStatisticsScreenButton = new JButton();
		viewStockScreenButton = new JButton();

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
			cashierListScreenButton.setText("RUD Cashiers List");
			cashierListScreenButton.setSelectedIcon(null);
			cashierListScreenButton.setIcon(new ImageIcon(getClass().getResource("/addCashier.png")));
			panel1.add(cashierListScreenButton);
			cashierListScreenButton.setBounds(200, 15, 160, 40);
			cashierListScreenButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button2 ----
			productListButton.setText("RUD Products List");
			productListButton.setIcon(new ImageIcon(getClass().getResource("/package.png")));
			panel1.add(productListButton);
			productListButton.setBounds(420, 15, 160, 40);
			productListButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button3 ----
			viewStatisticsScreenButton.setText("View Statistics");
			viewStatisticsScreenButton.setIcon(new ImageIcon(getClass().getResource("/stats.png")));
			panel1.add(viewStatisticsScreenButton);
			viewStatisticsScreenButton.setBounds(640, 15, 160, 40);
			viewStatisticsScreenButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ManagerScreenActionPerformed(evt);
				}
			});

			//---- button4 ----
			viewStockScreenButton.setText("View Stock");
			viewStockScreenButton.setIcon(new ImageIcon(getClass().getResource("/stock.png")));
			panel1.add(viewStockScreenButton);
			viewStockScreenButton.setBounds(860, 15, 160, 40);
			viewStockScreenButton.addActionListener(new java.awt.event.ActionListener() {
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
		
	}

	
	private JPanel panel1;
	private JDesktopPane desktopPane1;
	private JButton cashierListScreenButton;
	private JButton productListButton;
	private JButton viewStatisticsScreenButton;
	private JButton viewStockScreenButton;
	
}
