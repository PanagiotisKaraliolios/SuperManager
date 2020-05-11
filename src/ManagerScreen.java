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
	
	private JDesktopPane desktopPane1;
	private JMenuBar menuBar1;
	private JPanel hSpacer2;
	private JButton button1;
	private JPanel hSpacer3;
	private JButton button2;
	private JPanel hSpacer4;
	private JButton button3;
	private JPanel hSpacer5;
	private JButton button4;
	private JPanel hSpacer1;
	

	private void initComponents() {
		
		desktopPane1 = new JDesktopPane();
		menuBar1 = new JMenuBar();
		hSpacer2 = new JPanel(null);
		button1 = new JButton();
		hSpacer3 = new JPanel(null);
		button2 = new JButton();
		hSpacer4 = new JPanel(null);
		button3 = new JButton();
		hSpacer5 = new JPanel(null);
		button4 = new JButton();
		hSpacer1 = new JPanel(null);

		//======== this ========
		setMinimumSize(new Dimension(1280, 720));
		setTitle("Super Manager");
		setResizable(false);
		var contentPane = getContentPane();

		
		{
			desktopPane1.setBorder(new LineBorder(Color.blue, 3));

			
			{
				menuBar1.setBackground(Color.blue);
				menuBar1.setBorderPainted(false);

				
				hSpacer2.setBackground(Color.blue);
				hSpacer2.setBorder(null);
				menuBar1.add(hSpacer2);

				
				button1.setText("RUD Cashiers List");
				button1.setSelectedIcon(null);
				menuBar1.add(button1);

				
				hSpacer3.setBackground(Color.blue);
				menuBar1.add(hSpacer3);

				
				button2.setText("RUD Products List");
				menuBar1.add(button2);

				
				hSpacer4.setBackground(Color.blue);
				menuBar1.add(hSpacer4);

				
				button3.setText("View Statistics");
				menuBar1.add(button3);

				
				hSpacer5.setBackground(Color.blue);
				menuBar1.add(hSpacer5);

				
				button4.setText("View Stock");
				menuBar1.add(button4);

				
				hSpacer1.setPreferredSize(new Dimension(10, 0));
				hSpacer1.setBackground(Color.blue);
				menuBar1.add(hSpacer1);
			}
			desktopPane1.add(menuBar1, JLayeredPane.DEFAULT_LAYER);
			menuBar1.setBounds(0, 0, 1280, 45);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(desktopPane1, GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(desktopPane1, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		
	}
	
}
