package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialogDemo.SwingUtils;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class HouseView extends JDialog {

	HouseView dialog = this;
	private JPanel panel;
	private Boolean Outside = true;
	private JTextField txtName;
	private JTextField txtCity;
	private JTextField txtAddress;
	private JTextField txtDescription;
	private JTextField txtDateFrom;
	private JTextField txtDateTo;
	private JTextField txtPrice;

	public HouseView(JFrame parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Enable back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("House View");
		
		
		// Dialog panel
		panel = new JPanel();
		panel.setBackground(new Color(32,33,36));
		panel.setLayout(null);
		//panel.setPreferredSize(new Dimension(400, 300));
		panel.setPreferredSize(new Dimension(600, 600));

		
		// The following two lines are only needed because there is no
		// focusable component in here, and the "hit ESC to close" requires
		// the focus to be in the dialog. If you have a button, a text field,
		// or any focusable stuff, you don't need these lines.
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		
		// Support for close on clicking outside the dialog
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				//System.out.println("Mouse Exited.");
				Outside = true;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//System.out.println("Mouse Entered.");
				Outside = false;
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Outside)
					SwingUtils.fadeOut(dialog);
			}
		});

		getContentPane().add(panel);
		panel.setLayout(null);
		
		Map map = new Map("errazkinenea_4", 18);
		map.setBounds(10, 11, 300, 300);
		panel.add(map);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setForeground(SystemColor.textInactiveText);
		txtName.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBounds(378, 26, 212, 45);
		panel.add(txtName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(327, 26, 52, 45);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Home_32px_1.png")));
		panel_1.add(label);
		
		txtCity = new JTextField();
		txtCity.setText("City");
		txtCity.setForeground(SystemColor.textInactiveText);
		txtCity.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBorder(null);
		txtCity.setBounds(378, 93, 212, 45);
		panel.add(txtCity);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(327, 93, 52, 45);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Marker_32px.png")));
		panel_2.add(label_1);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setForeground(SystemColor.textInactiveText);
		txtAddress.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);
		txtAddress.setBounds(378, 165, 212, 45);
		panel.add(txtAddress);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(327, 165, 52, 45);
		panel.add(panel_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Marker_32px.png")));
		panel_3.add(label_2);
		
		txtDescription = new JTextField();
		txtDescription.setText("Description");
		txtDescription.setForeground(SystemColor.textInactiveText);
		txtDescription.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDescription.setColumns(10);
		txtDescription.setBorder(null);
		txtDescription.setBounds(327, 241, 263, 164);
		panel.add(txtDescription);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setText("Date From");
		txtDateFrom.setForeground(SystemColor.textInactiveText);
		txtDateFrom.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDateFrom.setColumns(10);
		txtDateFrom.setBorder(null);
		txtDateFrom.setBounds(55, 438, 212, 45);
		panel.add(txtDateFrom);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 438, 52, 45);
		panel.add(panel_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Date From_32px.png")));
		panel_5.add(label_4);
		
		txtDateTo = new JTextField();
		txtDateTo.setText("Date To");
		txtDateTo.setForeground(SystemColor.textInactiveText);
		txtDateTo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDateTo.setColumns(10);
		txtDateTo.setBorder(null);
		txtDateTo.setBounds(372, 438, 212, 45);
		panel.add(txtDateTo);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(327, 438, 52, 45);
		panel.add(panel_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Date To_32px.png")));
		panel_6.add(label_5);
		
		txtPrice = new JTextField();
		txtPrice.setText("Price");
		txtPrice.setForeground(SystemColor.textInactiveText);
		txtPrice.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtPrice.setColumns(10);
		txtPrice.setBorder(null);
		txtPrice.setBounds(55, 521, 212, 45);
		panel.add(txtPrice);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 521, 52, 45);
		panel.add(panel_9);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Sell Property_32px.png")));
		panel_9.add(label_8);
		
		JButton btnPay = new JButton("PAY");
		btnPay.setBackground(new Color(12,158,188));
		btnPay.setBorder(null);
		btnPay.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		btnPay.setBounds(327, 521, 260, 45);
		btnPay.setOpaque(true);
		panel.add(btnPay);
		
		JLabel lblAccepted = new JLabel("Accepted");
		lblAccepted.setForeground(new Color(255, 255, 255));
		lblAccepted.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblAccepted.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Cat Footprint_32px_1.png")));
		lblAccepted.setBounds(10, 369, 86, 45);
		panel.add(lblAccepted);
		
		JLabel lblX = new JLabel("x2");
		lblX.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Toilet Bowl_32px_1.png")));
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblX.setBounds(131, 369, 70, 45);
		panel.add(lblX);
		
		JLabel lblFree = new JLabel("Free");
		lblFree.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Wi-Fi_32px_1.png")));
		lblFree.setForeground(Color.WHITE);
		lblFree.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblFree.setBounds(224, 369, 70, 45);
		panel.add(lblFree);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Back_32px.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		label_3.setBounds(10, 313, 32, 32);
		panel.add(label_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Zoom Out_32px.png")));
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		label_6.setBounds(99, 313, 32, 32);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Zoom In_32px.png")));
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		label_7.setBounds(189, 313, 32, 32);
		panel.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(HouseView.class.getResource("/GUI/icons/Forward_32px.png")));
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		label_9.setBounds(278, 313, 32, 32);
		panel.add(label_9);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}
