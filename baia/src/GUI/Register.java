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
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;


public class Register extends JDialog {

	Register dialog = this;
	private JPanel panel;
	private Boolean Outside = true;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtDni;
	private JTextField txtBirthDate;
	private JTextField txtAddress;

	public Register(JDialog parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Enable back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("Register");
		
		
		// Dialog panel
		panel = new JPanel();
		panel.setBackground(new Color(32,33,36));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(600, 530));
		
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
		txtUser.setBounds(81, 38, 212, 45);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JPanel panelUserImg = new JPanel();
		panelUserImg.setBackground(new Color(255, 255, 255));
		panelUserImg.setBounds(30, 38, 52, 45);
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
		txtPassword.setBounds(365, 38, 212, 45);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JPanel panelPassImg = new JPanel();
		panelPassImg.setBackground(new Color(255, 255, 255));
		panelPassImg.setBounds(314, 38, 52, 45);
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
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(new Color(12, 158, 188));
		btnRegister.setBorder(null);
		btnRegister.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		btnRegister.setBounds(168, 406, 263, 45);
		panel.add(btnRegister);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals("Email")){
					txtEmail.setText("");
					txtEmail.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().equals("")){
					txtEmail.setText("Email");
					txtEmail.setForeground(new Color(109,109,109));
				}
			}
		});
		txtEmail.setText("Email");
		txtEmail.setForeground(SystemColor.textInactiveText);
		txtEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(81, 106, 212, 45);
		panel.add(txtEmail);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(Color.WHITE);
		panelEmail.setBounds(30, 106, 52, 45);
		panel.add(panelEmail);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/New Post_32px.png")));
		panelEmail.add(lblEmail);
		
		txtDni = new JTextField();
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDni.getText().equals("DNI")){
					txtDni.setText("");
					txtDni.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDni.getText().equals("")){
					txtDni.setText("DNI");
					txtDni.setForeground(new Color(109,109,109));
				}
			}
		});
		txtDni.setText("DNI");
		txtDni.setForeground(SystemColor.textInactiveText);
		txtDni.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDni.setColumns(10);
		txtDni.setBorder(null);
		txtDni.setBounds(365, 106, 212, 45);
		panel.add(txtDni);
		
		JPanel panelDni = new JPanel();
		panelDni.setBackground(Color.WHITE);
		panelDni.setBounds(314, 106, 52, 45);
		panel.add(panelDni);
		
		JLabel lblDni = new JLabel("");
		lblDni.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/ID Card_32px.png")));
		panelDni.add(lblDni);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("Name")){
					txtName.setText("");
					txtName.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals("")){
					txtName.setText("Name");
					txtName.setForeground(new Color(109,109,109));
				}
			}
		});
		txtName.setText("Name");
		txtName.setForeground(SystemColor.textInactiveText);
		txtName.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBounds(81, 174, 212, 45);
		panel.add(txtName);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(Color.WHITE);
		panelName.setBounds(30, 174, 52, 45);
		panel.add(panelName);
		
		JLabel lblName = new JLabel("");
		lblName.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/ID Card_32px.png")));
		panelName.add(lblName);
		
		txtSurname = new JTextField();
		txtSurname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSurname.getText().equals("Surname")){
					txtSurname.setText("");
					txtSurname.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSurname.getText().equals("")){
					txtSurname.setText("Surname");
					txtSurname.setForeground(new Color(109,109,109));
				}
			}
		});
		txtSurname.setText("Surname");
		txtSurname.setForeground(SystemColor.textInactiveText);
		txtSurname.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtSurname.setColumns(10);
		txtSurname.setBorder(null);
		txtSurname.setBounds(365, 174, 212, 45);
		panel.add(txtSurname);
		
		JPanel panelSurname = new JPanel();
		panelSurname.setBackground(Color.WHITE);
		panelSurname.setBounds(314, 174, 52, 45);
		panel.add(panelSurname);
		
		JLabel lblSurname = new JLabel("");
		lblSurname.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/ID Card_32px.png")));
		panelSurname.add(lblSurname);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setText("Birthdate");
		txtBirthDate.setForeground(SystemColor.textInactiveText);
		txtBirthDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtBirthDate.setColumns(10);
		txtBirthDate.setBorder(null);
		txtBirthDate.setBounds(81, 247, 212, 45);
		panel.add(txtBirthDate);
		
		JPanel paneBirth = new JPanel();
		paneBirth.setBackground(Color.WHITE);
		paneBirth.setBounds(30, 247, 52, 45);
		panel.add(paneBirth);
		
		JLabel lblBirth = new JLabel("");
		lblBirth.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/Calendar_32px.png")));
		paneBirth.add(lblBirth);
		
		txtAddress = new JTextField();
		txtAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAddress.getText().equals("Address")){
					txtAddress.setText("");
					txtAddress.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAddress.getText().equals("")){
					txtAddress.setText("Address");
					txtAddress.setForeground(new Color(109,109,109));
				}
			}
		});
		txtAddress.setText("Address");
		txtAddress.setForeground(SystemColor.textInactiveText);
		txtAddress.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);
		txtAddress.setBounds(365, 247, 212, 45);
		panel.add(txtAddress);
		
		JPanel panelAddress = new JPanel();
		panelAddress.setBackground(Color.WHITE);
		panelAddress.setBounds(314, 247, 52, 45);
		panel.add(panelAddress);
		
		JLabel lblAddress = new JLabel("");
		lblAddress.setIcon(new ImageIcon(Register.class.getResource("/GUI/icons/Marker_32px.png")));
		panelAddress.add(lblAddress);
		
		JComboBox comboGender = new JComboBox();
		comboGender.setBorder(null);
		comboGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboGender.setBackground(Color.WHITE);
		comboGender.setBounds(30, 324, 263, 45);
		panel.add(comboGender);
		
		JComboBox comboUserType = new JComboBox();
		comboUserType.setModel(new DefaultComboBoxModel(new String[] {"Client", "Owner"}));
		comboUserType.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		comboUserType.setBorder(null);
		comboUserType.setBackground(Color.WHITE);
		comboUserType.setBounds(314, 324, 263, 45);
		panel.add(comboUserType);
		
		JLabel lblByClickingRegister = new JLabel("By clicking register you are admitting Sinking Soft's and BuggySoft's terms and conditions");
		lblByClickingRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblByClickingRegister.setForeground(Color.WHITE);
		lblByClickingRegister.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblByClickingRegister.setBounds(26, 491, 547, 27);
		panel.add(lblByClickingRegister);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}