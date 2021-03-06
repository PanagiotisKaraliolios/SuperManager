

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

@SuppressWarnings("serial")
public class CashierScreen extends JFrame {
	private boolean isMCSopen = false;	//flag  to check if the Member Card Screen is open
	private boolean isSPSopen = false;	//flag  to check if the Scan Products Screen is open
	public boolean isPSopen = false;	//flag  to check if the payment Screen is open

	
	

	public CashierScreen() {			//Cashier Screen Constructor
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void CashierScreenActionPerformed(java.awt.event.ActionEvent evt){
		if(evt.getSource().equals(CreateMemberCardScreenButton)) {
			if(isMCSopen==false) {
				CreateMemberCardScreen mcs = new CreateMemberCardScreen();
				this.desktopPane1.add(mcs);
				mcs.setVisible(true);
				mcs.toFront();
				try {
					mcs.setSelected(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
				mcs.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isMCSopen = false;
					}

				});
				if(mcs.isEnabled()) {
					isMCSopen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(CreateMemberCardScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(CreateMemberCardScreen.class)) {
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
		else if(evt.getSource().equals(scanProductsScreenButton)) {
			
			for(JInternalFrame i : this.desktopPane1.getAllFrames()) {
				if(i.getClass().equals(PaymentScreen.class)) {
					isPSopen = true;
				}
				else {
					isPSopen = false;
				}
			}
			
			if(this.desktopPane1.getAllFrames().length == 0) {
				isPSopen = false;
			}
			
			
			if(isSPSopen==false && isPSopen==false) {
				
				ScanProductsScreen sps = new ScanProductsScreen();
				this.desktopPane1.add(sps);
				sps.setVisible(true);
				sps.toFront();
				try {
					sps.setSelected(true);				//Tries to make it the selected window
				} catch (PropertyVetoException e1) {
					
					e1.printStackTrace();
				}
				sps.addInternalFrameListener(new InternalFrameAdapter() {
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {
						isSPSopen = false;
					}

				});
				if(sps.isEnabled()) {
					isSPSopen = true;
					
				}				
			}
			else if(!this.desktopPane1.getSelectedFrame().getClass().equals(ScanProductsScreen.class)) {
				for (JInternalFrame i : this.desktopPane1.getAllFrames()) {
					if(i.getClass().equals(ScanProductsScreen.class)) {
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
	
	
	
	

	private void initComponents() {		//Cashier Screen components
		
		panel1 = new JPanel();
		desktopPane1 = new JDesktopPane();
		CreateMemberCardScreenButton = new JButton();			//This Button opens Members Screen
		scanProductsScreenButton = new JButton();			//This button opens Scan Products Screen

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
			
			desktopPane1.setBorder(null);
			
			panel1.add(desktopPane1);
			desktopPane1.setBounds(0, 65, 1280, 623);

			//---- button1 ----
			CreateMemberCardScreenButton.setText("Create Member Card");
			CreateMemberCardScreenButton.setSelectedIcon(null);
			CreateMemberCardScreenButton.setIcon(new ImageIcon(getClass().getResource("/memberCard2.png")));
			panel1.add(CreateMemberCardScreenButton);
			CreateMemberCardScreenButton.setBounds(400, 15, 180, 40);
			CreateMemberCardScreenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					CashierScreenActionPerformed(evt);
				}
			});

			//---- button2 ----
			scanProductsScreenButton.setText("Scan Products");
			scanProductsScreenButton.setIcon(new ImageIcon(getClass().getResource("/transaction.png")));
			panel1.add(scanProductsScreenButton);
			scanProductsScreenButton.setBounds(700, 15, 160, 40);
			scanProductsScreenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
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
		
	}

	
	private JPanel panel1;
	private JDesktopPane desktopPane1;
	private JButton CreateMemberCardScreenButton;
	private JButton scanProductsScreenButton;
	
}	



