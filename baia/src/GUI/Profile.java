package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialogDemo.SwingUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;


public class Profile extends JDialog {

	Profile dialog = this;
	private JPanel panel;
	private Boolean Outside = true;
	private JPanel panelMyHouses;
	private JPanel panelMyBookings;
	private JPanel panelProfile;

	public Profile(JFrame parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Enable back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("Profile/Settings");
		
		
		// Dialog panel
		panel = new JPanel();
		panel.setBackground(new Color(32,33,36));
		panel.setLayout(null);
		//panel.setPreferredSize(new Dimension(400, 300));
		panel.setPreferredSize(new Dimension(800,600));

		
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
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(21,23,22));
		panelLeft.setBounds(0, 0, 200, 600);
		panel.add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!panelProfile.isVisible()){
					panelMyBookings.setVisible(false);
					panelMyHouses.setVisible(false);
					panelProfile.setVisible(true);
				}
			}
		});
		lblProfile.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setBounds(0, 0, 200, 70);
		panelLeft.add(lblProfile);
		
		JLabel lblMyBookings = new JLabel("My Bookings");
		lblMyBookings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!panelMyBookings.isVisible()){
					panelMyBookings.setVisible(true);
					panelMyHouses.setVisible(false);
					panelProfile.setVisible(false);
				}
			}
		});
		lblMyBookings.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyBookings.setForeground(Color.WHITE);
		lblMyBookings.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblMyBookings.setBounds(0, 70, 200, 70);
		panelLeft.add(lblMyBookings);
		
		JLabel lblMyHouses = new JLabel("My Houses");
		lblMyHouses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!panelMyHouses.isVisible()){
					panelMyBookings.setVisible(false);
					panelMyHouses.setVisible(true);
					panelProfile.setVisible(false);
				}
			}
		});
		lblMyHouses.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyHouses.setForeground(Color.WHITE);
		lblMyHouses.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblMyHouses.setBounds(0, 140, 200, 70);
		panelLeft.add(lblMyHouses);
		
		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(Color.WHITE);
		lblLogOut.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblLogOut.setBounds(0, 530, 200, 70);
		panelLeft.add(lblLogOut);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(31,33,36));
		separator.setBackground(new Color(31,33,36));
		separator.setBounds(0, 70, 200, 2);
		panelLeft.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(31, 33, 36));
		separator_1.setBackground(new Color(31, 33, 36));
		separator_1.setBounds(0, 140, 200, 2);
		panelLeft.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(31, 33, 36));
		separator_2.setBackground(new Color(31, 33, 36));
		separator_2.setBounds(0, 210, 200, 2);
		panelLeft.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(31, 33, 36));
		separator_3.setBackground(new Color(31, 33, 36));
		separator_3.setBounds(0, 530, 200, 2);
		panelLeft.add(separator_3);
		
		panelProfile = new JPanel();
		panelProfile.setBackground(new Color(31,33,36));
		panelProfile.setBounds(200, 0, 600, 600);
		panel.add(panelProfile);
		
		panelMyBookings = new JPanel();
		panelMyBookings.setVisible(false);
		panelMyBookings.setBackground(new Color(31, 33, 36));
		panelMyBookings.setBounds(200, 0, 600, 600);
		panel.add(panelMyBookings);
		
		panelMyHouses = new JPanel();
		panelMyHouses.setVisible(false);
		panelMyHouses.setBackground(new Color(31, 33, 36));
		panelMyHouses.setBounds(200, 0, 600, 600);
		panel.add(panelMyHouses);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}