

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import com.jgoodies.forms.factories.Borders;

import net.miginfocom.swing.*;

public class CashierScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane1;
	private JMenuBar menuBar1;
	private JPanel hSpacer2;
	private JButton button1;
	private JToolBar.Separator separator1;
	private JButton button2;
	private JPanel hSpacer1;
	

	public CashierScreen() {
		desktopPane1 = new JDesktopPane();
		menuBar1 = new JMenuBar();
		hSpacer2 = new JPanel(null);
		button1 = new JButton();
		separator1 = new JToolBar.Separator();
		button2 = new JButton();
		hSpacer1 = new JPanel(null);

		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"insets 0,hidemode 3",
			"[grow,fill]",
			"[grow,fill]"));

		desktopPane1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		desktopPane1.setBackground(new Color(52, 140 , 238));

		hSpacer1.setBackground(Color.BLUE);
		hSpacer2.setBackground(Color.BLUE);
		menuBar1.add(hSpacer2);

		button1.setText("CREATE MEMBER CARD");
		button1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		menuBar1.add(button1);
		menuBar1.add(separator1);

		button2.setText("SCAN PRODUCTS");
		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		menuBar1.add(button2);
		menuBar1.add(hSpacer1);
			
		desktopPane1.add(menuBar1, JLayeredPane.DEFAULT_LAYER);
		menuBar1.setBounds(0, 0, 1600, 45);
		menuBar1.setBackground(Color.BLUE);
		menuBar1.setBorder(null);
		
		
		contentPane.add(desktopPane1, "cell 0 0");
		pack();
		setLocationRelativeTo(getOwner());
		
		setTitle("Super Manager");
		setSize(1600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
}	



