

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class CashierScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane1;
	private JMenuBar menuBar1;
	private JPanel hSpacer2;
	private JButton button2;
	private JToolBar.Separator separator1;
	private JButton button1;
	private JPanel hSpacer1;
	

	public CashierScreen() {
		desktopPane1 = new JDesktopPane();
		menuBar1 = new JMenuBar();
		hSpacer2 = new JPanel(null);
		button2 = new JButton();
		separator1 = new JToolBar.Separator();
		button1 = new JButton();
		hSpacer1 = new JPanel(null);

		//======== this ========
		setAlwaysOnTop(true);
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"insets 0,hidemode 3",
			// columns
			"[grow,fill]",
			// rows
			"[grow,fill]"));

		//======== desktopPane1 ========
		{
			desktopPane1.setBackground(new Color(52, 140 , 238));

			//======== menuBar1 ========
			{
				menuBar1.add(hSpacer2);

				//---- button2 ----
				button2.setText("CREATE MEMBER CARD");
				menuBar1.add(button2);
				menuBar1.add(separator1);

				//---- button1 ----
				button1.setText("SCAN PRODUCTS");
				menuBar1.add(button1);
				menuBar1.add(hSpacer1);
			}
			desktopPane1.add(menuBar1, JLayeredPane.DEFAULT_LAYER);
			menuBar1.setBounds(0, 0, 1540, 45);
		}
		contentPane.add(desktopPane1, "cell 0 0");
		pack();
		setLocationRelativeTo(getOwner());
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

}	
