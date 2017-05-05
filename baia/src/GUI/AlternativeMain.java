package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class AlternativeMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsert;
	private JTextField txtDateFrom;
	private JTextField txtDateTo;
	private JPanel panelBot;
	private JPanel panelSearch;
	private JLabel lblTrip;
	private JLabel lblClicks;
	private JLabel lblFilters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlternativeMain frame = new AlternativeMain();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBot = new JPanel();
		panelBot.setBackground(new Color(22,21,23));
		panelBot.setBounds(0, 430, 1064, 455);
		contentPane.add(panelBot);
		panelBot.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(21,22,23));
		panel.setBounds(0, 0, 72, 455);
		panelBot.add(panel);
		panel.setLayout(null);
		
		lblFilters = new JLabel("FILTERS");
		lblFilters.setVisible(false);
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setForeground(new Color(255, 255, 255));
		lblFilters.setBounds(11, 11, 50, 50);
		panel.add(lblFilters);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(22,21,23,230));
		panelTop.setBounds(0, 0, 1064, 68);
		contentPane.add(panelTop);
		
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
		lblLoc.setIcon(new ImageIcon("resources\\icons\\Marker_32px.png"));
		panelLocation.add(lblLoc);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setText("Date From");
		txtDateFrom.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDateFrom.setColumns(10);
		txtDateFrom.setBorder(null);
		txtDateFrom.setBounds(365, 40, 149, 45);
		panelSearch.add(txtDateFrom);
		
		JPanel panelDateFrom = new JPanel();
		panelDateFrom.setBackground(Color.WHITE);
		panelDateFrom.setBounds(320, 40, 45, 45);
		panelSearch.add(panelDateFrom);
		
		JLabel lblFrom = new JLabel();
		lblFrom.setIcon(new ImageIcon("resources\\icons\\Date From_32px.png"));
		panelDateFrom.add(lblFrom);
		
		txtDateTo = new JTextField();
		txtDateTo.setText("Date To");
		txtDateTo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtDateTo.setColumns(10);
		txtDateTo.setBorder(null);
		txtDateTo.setBounds(569, 40, 149, 45);
		panelSearch.add(txtDateTo);
		
		JPanel panelDateTo = new JPanel();
		panelDateTo.setBackground(Color.WHITE);
		panelDateTo.setBounds(524, 40, 45, 45);
		panelSearch.add(panelDateTo);
		
		JLabel lblTo = new JLabel("");
		lblTo.setIcon(new ImageIcon("resources\\icons\\Date To_32px.png"));
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
		
		JLabel lblSearchImg = new JLabel("");
		lblSearchImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MoveUp();
			}
		});
		lblSearchImg.setBounds(22, 14, 99, 99);
		lblSearchImg.setIcon(new ImageIcon("resources\\icons\\Circle_99px.png"));
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
		lblBackGround.setBounds(0, 11, 1064, 420);
		lblBackGround.setIcon(new ImageIcon("resources\\icons\\backgroundImage.png"));
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
				panelBot.setBounds(panelBot.getX(), ((int)Math.max(current, arrival)), panelBot.getWidth(), panelBot.getHeight());
				panelSearch.setBounds(panelSearch.getX(),(int)(Math.max(panelSearch.getY()-speed,arrivalS)), panelSearch.getWidth(), panelSearch.getHeight());
				if (current <= arrival) {
					timer.stop();
					lblFilters.setVisible(true);
				}
			}
		});
		
		timer.start();
		lblTrip.setVisible(false);
		lblClicks.setVisible(false);
	}
}

