import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;
import java.awt.event.*;


public class ManagerScreen extends JFrame {
	public ManagerScreen() {
		initComponents();
		this.setLocationRelativeTo(null);
	}
	
	private JDesktopPane desktopPane1;
	private JButton button1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton button2;
	private JButton button3;
	private JLabel label4;
	private JButton button4;
	private JLabel label5;
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - ioslas00
		desktopPane1 = new JDesktopPane();
		button1 = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		button2 = new JButton();
		button3 = new JButton();
		label4 = new JLabel();
		button4 = new JButton();
		label5 = new JLabel();

		setMinimumSize(new Dimension(1280, 720));
		Container contentPane = getContentPane();

		{
			desktopPane1.setBackground(Color.blue);

			button1.setText("RUD Product List");
			button1.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent evt) {
					
				  }
			});
			button1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(button1, JLayeredPane.DEFAULT_LAYER);
			button1.setBounds(755, 140, 345, 55);

			label1.setText("Welcome  Manager");
			label1.setFont(new Font("Showcard Gothic", Font.PLAIN, 48));
			label1.setAlignmentY(0.0F);
			label1.setBorder(Borders.DLU2);
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			desktopPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
			label1.setBounds(470, 10, 505, 75);

			label2.setText("Company's Product List -->");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
			label2.setBounds(210, 150, 395, 30);

			label3.setText("Company's Statistics  -->");
			label3.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
			label3.setBounds(230, 280, 390, 55);

			button2.setText("View Statistics");
			button2.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent evt) {
					
				  }
			});
			button2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(button2, JLayeredPane.DEFAULT_LAYER);
			button2.setBounds(760, 280, 325, 55);

			button3.setText("View Stock");
			button3.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent evt) {
					
				  }
			});
			button3.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(button3, JLayeredPane.DEFAULT_LAYER);
			button3.setBounds(785, 420, 275, 60);

			label4.setText("Company's Stock  -->");
			label4.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(label4, JLayeredPane.DEFAULT_LAYER);
			label4.setBounds(270, 425, 300, 50);

			button4.setText("RUD Cashier List");
			button4.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent evt) {
					
				  }
			});
			button4.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(button4, JLayeredPane.DEFAULT_LAYER);
			button4.setBounds(780, 570, 270, 65);

			label5.setText("Company's Cashier List -->");
			label5.setFont(new Font("Tahoma", Font.PLAIN, 30));
			desktopPane1.add(label5, JLayeredPane.DEFAULT_LAYER);
			label5.setBounds(240, 565, 380, 65);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(desktopPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(desktopPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		
		setTitle("Super Manager");
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}
