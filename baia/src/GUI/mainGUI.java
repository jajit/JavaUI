package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;
import java.awt.Window.Type;

public class mainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private int xMouse;
	private int yMouse;
	private int max = 900;
	private double current = 1020;
	private double speed = 1.25;
	private boolean active = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI frame = new mainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainGUI() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel leftSidePanel = new JPanel();
		leftSidePanel.setBackground(new Color(0, 18, 50));
		leftSidePanel.setBounds(0, 0, 60, 720);
		contentPane.add(leftSidePanel);
		leftSidePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popup bai = new popup();
				bai.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("D:\\Users\\Ruben\\Documents\\NetBeansProjects\\PruebaInterfaz\\icon\\Xbox Menu_40px.png"));
		lblNewLabel.setBounds(10, 10, 40, 40);
		leftSidePanel.add(lblNewLabel);

		JPanel topPanel = new JPanel();
		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				setLocation(x-xMouse, y - yMouse);
			}
		});
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setBackground(new Color(0, 18, 50));
		rightSidePanel.setBounds(1020, 50, 180, 670);
		contentPane.add(rightSidePanel);
		rightSidePanel.setLayout(null);

		JLabel lblFiltros = new JLabel("");
		lblFiltros.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// Codigo del slide del sidePanel
				new Timer(1, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rightSidePanel.getX() > 900 && !active){
							
							current -= speed;
							rightSidePanel.setBounds((int) (rightSidePanel.getX()-speed), rightSidePanel.getY(), rightSidePanel.getWidth(), rightSidePanel.getHeight());
							
							if(rightSidePanel.getX() <= 900){
								((Timer) e.getSource()).stop();
								active = true;
								System.out.println("Timer stopped");
							}
						}else{
							
							current += speed;
							rightSidePanel.setBounds((int) (rightSidePanel.getX()+speed), rightSidePanel.getY(), rightSidePanel.getWidth(), rightSidePanel.getHeight());
							System.out.println(rightSidePanel.getX());
							if(rightSidePanel.getX() >= 1020){
								active = false;
								((Timer) e.getSource()).stop();
								System.out.println("Timer stopped");
							}
						}
					}
				}).start();

			}

		});
		lblFiltros.setIcon(new ImageIcon("D:\\Users\\Ruben\\Documents\\NetBeansProjects\\PruebaInterfaz\\icon\\Filter_40px.png"));
		lblFiltros.setBounds(10, 10, 40, 40);
		rightSidePanel.add(lblFiltros);
		
		JCheckBox chckbxBuenFiltro = new JCheckBox("Buen filtro");
		chckbxBuenFiltro.setForeground(new Color(255, 255, 255));
		chckbxBuenFiltro.setBackground(new Color(0, 18, 50));
		chckbxBuenFiltro.setBounds(77, 98, 97, 23);
		rightSidePanel.add(chckbxBuenFiltro);
		topPanel.setBackground(new Color(255, 255, 255));
		topPanel.setBounds(60, 0, 1020, 50);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel lblSearch = new JLabel("");
		lblSearch.setIcon(new ImageIcon("D:\\Users\\Ruben\\Documents\\NetBeansProjects\\PruebaInterfaz\\icon\\Search_50px.png"));
		lblSearch.setBounds(50, 0, 46, 50);
		topPanel.add(lblSearch);

		JSeparator separator = new JSeparator();
		separator.setBounds(124, 37, 215, 2);
		topPanel.add(separator);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		textField.setBorder(null);
		textField.setBounds(124, 11, 215, 20);
		topPanel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setIcon(new ImageIcon("D:\\Users\\Ruben\\Documents\\NetBeansProjects\\PruebaInterfaz\\icon\\Xbox X_40px_1.png"));
		label.setBounds(970, 0, 40, 40);
		topPanel.add(label);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setIcon(new ImageIcon("D:\\Users\\Ruben\\Documents\\NetBeansProjects\\PruebaInterfaz\\icon\\Minus_40px.png"));
		label_1.setBounds(930, -1, 40, 40);
		topPanel.add(label_1);

		JPanel midPanel = new JPanel();
		midPanel.setBounds(60, 50, 960, 270);
		contentPane.add(midPanel);

		JPanel botPanel = new JPanel();
		botPanel.setBackground(new Color(32,47,90));
		botPanel.setBounds(60, 320, 960, 400);
		contentPane.add(botPanel);
		botPanel.setLayout(null);

		JPanel largePanel = new JPanel();
		largePanel.setBackground(new Color(106,116,145));
		largePanel.setBounds(31, 11, 919, 120);
		botPanel.add(largePanel);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(106,116,145));
		leftPanel.setBounds(31, 149, 261, 240);
		botPanel.add(leftPanel);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(106, 116, 145));
		centerPanel.setBounds(344, 149, 300, 240);
		botPanel.add(centerPanel);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(106, 116, 145));
		rightPanel.setBounds(689, 149, 261, 240);
		botPanel.add(rightPanel);
	}
}