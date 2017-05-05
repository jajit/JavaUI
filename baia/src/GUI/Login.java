package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dialogDemo.SwingUtils;
import javax.swing.JButton;


public class Login extends JDialog {

	Login dialog = this;
	private JPanel panel;
	private Boolean Outside = true;

	public Login(JFrame parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Enable back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("Login");
		
		
		// Dialog panel
		panel = new JPanel();
		panel.setBackground(new Color(32,33,36));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 300));
		
		// Inside of the Dialog
		JTextField txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equals("Username")){
					txtUser.setText("");
					txtUser.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equals("")){
					txtUser.setText("Username");
					txtUser.setForeground(new Color(109,109,109));
				}
			}
		});
		txtUser.setForeground(new Color(109,109,109));
		txtUser.setText("Username");
		txtUser.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtUser.setBounds(119, 38, 212, 45);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JPanel panelUserImg = new JPanel();
		panelUserImg.setBackground(new Color(255, 255, 255));
		panelUserImg.setBounds(68, 38, 52, 45);
		panel.add(panelUserImg);

		JLabel lblUserImg = new JLabel("");
		lblUserImg.setIcon(new ImageIcon(Login.class.getResource("/GUI/icons/Gender Neutral User_32px.png")));
		panelUserImg.add(lblUserImg);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")){
					txtPassword.setText("");
					txtPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")){
					txtPassword.setText("Password");
					txtPassword.setForeground(new Color(109,109,109));
				}
			}
		});
		txtPassword.setForeground(new Color(109,109,109));
		txtPassword.setText("Password");
		txtPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtPassword.setBounds(119, 109, 212, 45);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JPanel panelPassImg = new JPanel();
		panelPassImg.setBackground(new Color(255, 255, 255));
		panelPassImg.setBounds(68, 109, 52, 45);
		panel.add(panelPassImg);

		JLabel lblPassImg = new JLabel("");
		lblPassImg.setIcon(new ImageIcon(Login.class.getResource("/GUI/icons/Lock_32px.png")));
		panelPassImg.add(lblPassImg);

		
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
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setBackground(new Color(12, 158, 188));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		btnNewButton.setBounds(68, 197, 263, 45);
		panel.add(btnNewButton);
		
		JLabel lblNoAcc = new JLabel("Don't have an account yet?");
		lblNoAcc.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblNoAcc.setForeground(new Color(255, 255, 255));
		lblNoAcc.setBounds(56, 253, 192, 22);
		panel.add(lblNoAcc);
		
		JLabel lblNewLabel = new JLabel("Register now!");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(246, 253, 102, 22);
		panel.add(lblNewLabel);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}
