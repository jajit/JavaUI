package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dialogDemo.MyDialog;
import dialogDemo.SwingUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlternativeMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsert;
	private DateTextField txtDateFrom;
	private DateTextField txtDateTo;
	private JPanel panelBot;
	private JPanel panelSearch;
	private JLabel lblTrip;
	private JLabel lblClicks;
	private JLabel lblFilters;
	private JScrollPane panelHouses;
	private JPanel panelFilters;
	private JPanel panelClose;
	private JLabel lblSearchImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlternativeMain frame = new AlternativeMain();
					frame.setLocationRelativeTo(null);
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
	public AlternativeMain() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 681);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSearchImg.requestFocusInWindow();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelBot = new JPanel();
		panelBot.setBackground(new Color(21,23,22));
		panelBot.setBounds(0, 430, 1064, 455);
		contentPane.add(panelBot);
		panelBot.setLayout(null);

		panelFilters = new JPanel();
		panelFilters.setVisible(false);
		panelFilters.setBackground(new Color(32,33,36));
		panelFilters.setBounds(-130, 0, 200, 455);
		panelBot.add(panelFilters);
		panelFilters.setLayout(null);

		lblFilters = new JLabel("");
		lblFilters.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Filter_50px.png")));
		lblFilters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSearchImg.requestFocusInWindow();
				if (panelFilters.getX() == -130)
					MoveRight();
				else if (panelFilters.getX() == 0)
					MoveLeft();

			}
		});
		lblFilters.setVisible(false);
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setForeground(new Color(255, 255, 255));
		lblFilters.setBounds(139, 11, 50, 50);
		panelFilters.add(lblFilters);

		panelHouses = new JScrollPane();
		panelHouses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSearchImg.requestFocusInWindow();
			}
		});
		panelHouses.setBorder(null);
		panelHouses.setBackground(new Color(21,23,22));
		panelHouses.setBounds(70, 0, 994, 455);
		panelBot.add(panelHouses);
		panelHouses.setLayout(null);

		JList list = new JList();
		panelHouses.setViewportView(list);

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(22,21,23,230));
		panelTop.setBounds(0, 0, 1064, 68);
		contentPane.add(panelTop);
		panelTop.setLayout(null);

		JLabel lblUserImg = new JLabel("");
		lblUserImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login dialog = new Login(AlternativeMain.this);
				SwingUtils.fadeIn(dialog);
			}
		});
		lblUserImg.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Gender Neutral User_60px.png")));
		lblUserImg.setBounds(700, 4, 60, 60);
		panelTop.add(lblUserImg);

		JLabel lblUser = new JLabel("Login/Register");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login dialog = new Login(AlternativeMain.this);
				SwingUtils.fadeIn(dialog);
			}
		});
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblUser.setBounds(770, 11, 205, 46);
		panelTop.add(lblUser);

		JLabel lblClose = new JLabel("");
		lblClose.setBackground(new Color(0,0,0,0));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelClose.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Delete_25px.png")));
		lblClose.setBounds(1019, 0, 45, 25);
		panelTop.add(lblClose);

		panelClose = new JPanel();
		panelClose.setVisible(false);
		panelClose.setBackground(Color.RED);
		panelClose.setBounds(1019, 0, 45, 25);
		panelTop.add(panelClose);

		JPanel panelMid = new JPanel();
		panelMid.setBackground(new Color(255, 255, 255));
		panelMid.setBounds(0, 0, 1064, 430);
		contentPane.add(panelMid);
		panelMid.setLayout(null);

		panelSearch = new JPanel();
		panelSearch.setBackground(new Color(12, 158, 188));
		panelSearch.setBounds(100, 275, 864, 127);
		panelMid.add(panelSearch);
		panelSearch.setLayout(null);

		txtInsert = new JTextField();
		txtInsert.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtInsert.getText().equals("Insert city, region or district")){
					txtInsert.setText("");
					txtInsert.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtInsert.getText().equals("")){
					txtInsert.setText("Insert city, region or district");
					txtInsert.setForeground(new Color(109,109,109));
				}
			}
		});
		txtInsert.setForeground(new Color(109,109,109));
		txtInsert.setText("Insert city, region or district");
		txtInsert.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtInsert.setBorder(null);
		txtInsert.setBounds(80, 40, 212, 45);
		panelSearch.add(txtInsert);
		txtInsert.setColumns(10);

		JPanel panelLocation = new JPanel();
		panelLocation.setBackground(new Color(255, 255, 255));
		panelLocation.setBounds(35, 40, 52, 45);
		panelSearch.add(panelLocation);

		JLabel lblLoc = new JLabel("");
		lblLoc.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Marker_32px.png")));
		panelLocation.add(lblLoc);

		txtDateFrom = new DateTextField();
		txtDateFrom.setBackground(Color.white);
		txtDateFrom.setForeground(new Color(109,109,109));
		txtDateFrom.setText("Date From");
		txtDateFrom.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		//txtDateFrom.setColumns(10);
		txtDateFrom.setBorder(null);
		txtDateFrom.setBounds(365, 40, 149, 45);
		panelSearch.add(txtDateFrom);

		JPanel panelDateFrom = new JPanel();
		panelDateFrom.setBackground(Color.WHITE);
		panelDateFrom.setBounds(320, 40, 45, 45);
		panelSearch.add(panelDateFrom);

		JLabel lblFrom = new JLabel();
		lblFrom.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Date From_32px.png")));
		panelDateFrom.add(lblFrom);

		txtDateTo = new DateTextField();
		txtDateTo.setForeground(new Color(109,109,109));
		txtDateTo.setBackground(Color.white);
		txtDateTo.setText("Date To");
		txtDateTo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		//txtDateTo.setColumns(10);
		txtDateTo.setBorder(null);
		txtDateTo.setBounds(569, 40, 149, 45);
		panelSearch.add(txtDateTo);

		JPanel panelDateTo = new JPanel();
		panelDateTo.setBackground(Color.WHITE);
		panelDateTo.setBounds(524, 40, 45, 45);
		panelSearch.add(panelDateTo);

		JLabel lblTo = new JLabel("");
		lblTo.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Date To_32px.png")));
		panelDateTo.add(lblTo);

		JPanel panelSearchButton = new JPanel();
		panelSearchButton.setBackground(new Color(12,158,188));
		panelSearchButton.setBounds(722, 0, 143, 127);
		panelSearch.add(panelSearchButton);
		panelSearchButton.setLayout(null);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setBounds(45, 51, 53, 25);
		panelSearchButton.add(lblSearch);

		lblSearchImg = new JLabel("");
		lblSearchImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSearchImg.requestFocusInWindow();
				MoveUp();
			}
		});
		lblSearchImg.setFocusable(true);
		lblSearchImg.requestFocusInWindow();
		lblSearchImg.setBounds(22, 14, 99, 99);
		lblSearchImg.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/Circle_99px.png")));
		panelSearchButton.add(lblSearchImg);

		lblTrip = new JLabel("The journey of your dreams");
		lblTrip.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrip.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblTrip.setForeground(new Color(255, 255, 255));
		lblTrip.setBounds(99, 144, 865, 27);
		panelMid.add(lblTrip);

		lblClicks = new JLabel("just a few clicks away");
		lblClicks.setHorizontalAlignment(SwingConstants.CENTER);
		lblClicks.setForeground(Color.WHITE);
		lblClicks.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblClicks.setBounds(99, 189, 865, 27);
		panelMid.add(lblClicks);

		JLabel lblBackGround = new JLabel("");
		lblBackGround.setForeground(Color.WHITE);
		lblBackGround.setBounds(0, 2, 1064, 430);
		lblBackGround.setIcon(new ImageIcon(AlternativeMain.class.getResource("/GUI/icons/backgroundImage.png")));
		panelMid.add(lblBackGround);
	}


	private void MoveUp(){
		final Timer timer = new Timer(10, null);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			private float arrival = 225;
			private float arrivalS = 70;
			private float current = panelBot.getY();
			private int speed = 3;
			@Override public void actionPerformed(ActionEvent e) {
				current -= speed;
				panelBot.setLocation(panelBot.getX(), ((int)Math.max(current, arrival)));
				panelSearch.setLocation(panelSearch.getX(),(int)(Math.max(panelSearch.getY()-speed,arrivalS)));
				if (current <= arrival) {
					timer.stop();
					panelFilters.setVisible(true);
					lblFilters.setVisible(true);
				}
			}
		});

		timer.start();
		lblTrip.setVisible(false);
		lblClicks.setVisible(false);
	}
	private void MoveRight(){
		final Timer timer = new Timer(10, null);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {	
			private float arrival = 0;
			private float arrivalO = 200;
			private float arrivalL = 9;
			private float initialW = panelHouses.getWidth();
			private float current = panelFilters.getX();
			private float currentO = panelHouses.getX();
			private float currentL = lblFilters.getX();
			private int speed = 5;
			@Override public void actionPerformed(ActionEvent e) {
				current += speed;
				currentO += speed;
				currentL -= speed;

				panelFilters.setLocation((int)(Math.min(current, arrival)), panelFilters.getY());
				panelHouses.setBounds((int)(Math.min(currentO, arrivalO)),panelHouses.getY(), (int)(Math.max(panelHouses.getWidth()-speed,initialW )), panelHouses.getHeight());
				lblFilters.setLocation((int)(Math.max(currentL, arrivalL)), lblFilters.getY());
				if (current >= arrival){
					timer.stop();
				}
			}
		});

		timer.start();
	}
	private void MoveLeft(){
		final Timer timer = new Timer(10, null);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {	
			private float arrival = -130;
			private float arrivalO = 70;
			private float arrivalL = 139;
			private float initialW = panelHouses.getWidth();
			private float current = panelFilters.getX();
			private float currentO = panelHouses.getX();
			private float currentL = lblFilters.getX();
			private int speed = 5;
			@Override public void actionPerformed(ActionEvent e) {
				current -= speed;
				currentO -= speed;
				currentL += speed;

				panelFilters.setLocation((int)(Math.max(current, arrival)), panelFilters.getY());
				panelHouses.setBounds((int)(Math.max(currentO, arrivalO)),panelHouses.getY(),(int)(Math.min(panelHouses.getWidth()+speed,initialW )), panelHouses.getHeight());
				lblFilters.setLocation((int)(Math.min(currentL, arrivalL)), lblFilters.getY());
				if (current <= arrival){
					timer.stop();
				}
			}
		});

		timer.start();
	}
}

