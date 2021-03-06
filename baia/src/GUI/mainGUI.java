package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import GUI.CustomScrollbarUIExample.MyScrollbarUI;
import dialogDemo.MyDialog;
import dialogDemo.MyWindow;
import dialogDemo.SwingUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class mainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	private int xMouse;
	private int yMouse;
	@SuppressWarnings("unused")
	private int max = 900;
	@SuppressWarnings("unused")
	private double current = 1020;
	private double speed = 1;
	private boolean active = false;
	private JPanel botPanel;

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
				MyDialog dialog = new MyDialog(mainGUI.this);
				SwingUtils.fadeIn(dialog);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("resources\\icons\\Xbox Menu_50px.png"));
		lblNewLabel.setBounds(5, 10, 50, 50);
		leftSidePanel.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("resources\\icons\\Add House_50px.png"));
		label_2.setBounds(5, 155, 50, 50);
		leftSidePanel.add(label_2);

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
		rightSidePanel.setBounds(1020, 130, 180, 590);
		contentPane.add(rightSidePanel);
		rightSidePanel.setLayout(null);

		JLabel lblFiltros = new JLabel("");
		lblFiltros.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// Codigo del slide del sidePanel
				new Timer(1, new ActionListener() {
					
					Date prev = new Date();
					Date now;
					
					public void actionPerformed(ActionEvent e) {
						
						now = new Date();
						long deltaTime = now.getTime()-prev.getTime();
						System.out.println("DeltaTime: " + deltaTime);
						long realSpeed = (int)speed * deltaTime;
						
						if(rightSidePanel.getX() > 900 && !active){
							
							current -= speed;
							rightSidePanel.setBounds((int) (rightSidePanel.getX()-realSpeed), rightSidePanel.getY(), rightSidePanel.getWidth(), rightSidePanel.getHeight());
							botPanel.setBounds(botPanel.getX(),botPanel.getY(), (int)(botPanel.getWidth()-realSpeed), botPanel.getHeight());
							
							if(rightSidePanel.getX() <= 900){
								((Timer) e.getSource()).stop();
								active = true;
								System.out.println("Timer stopped");
							}
						}else{
							
							current += speed;
							rightSidePanel.setBounds((int) (rightSidePanel.getX()+realSpeed), rightSidePanel.getY(), rightSidePanel.getWidth(), rightSidePanel.getHeight());
							botPanel.setBounds(botPanel.getX(),botPanel.getY(), (int)(botPanel.getWidth()+realSpeed), botPanel.getHeight());
							
							//System.out.println(rightSidePanel.getX());
							if(rightSidePanel.getX() >= 1020){
								active = false;
								((Timer) e.getSource()).stop();
								System.out.println("Timer stopped");
							}
						}
						prev = new Date();
					}
				}).start();

			}

		});
		lblFiltros.setIcon(new ImageIcon("resources\\icons\\Filter_50px.png"));
		lblFiltros.setBounds(5, 11, 50, 50);
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
		lblSearch.setIcon(new ImageIcon("resources\\icons\\Search_50px.png"));
		lblSearch.setBounds(50, 0, 50, 50);
		topPanel.add(lblSearch);

		JSeparator separator = new JSeparator();
		separator.setBounds(124, 37, 215, 2);
		topPanel.add(separator);

		txtSearch = new JTextField();
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setToolTipText("");
		txtSearch.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txtSearch.setBorder(null);
		txtSearch.setBounds(124, 11, 215, 20);
		topPanel.add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblClose = new JLabel("");
		lblClose.setToolTipText("Close");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setIcon(new ImageIcon("resources\\icons\\Cancel_40px.png"));
		lblClose.setBounds(970, 5, 40, 40);
		topPanel.add(lblClose);

		JLabel lblMinimize = new JLabel("");
		lblMinimize.setToolTipText("Minimize");
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimize.setIcon(new ImageIcon("resources\\icons\\Minus_40px.png"));
		lblMinimize.setBounds(930, 5, 40, 40);
		topPanel.add(lblMinimize);
		
		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("resources\\icons\\Circled User Male_50px.png"));
		lblUser.setBounds(771, 0, 50, 50);
		topPanel.add(lblUser);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setToolTipText("Log In");
		lblLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblLogin.setBounds(830, 12, 90, 28);
		topPanel.add(lblLogin);

		JPanel midPanel = new JPanel();
		midPanel.setBounds(60, 50, 1020, 80);
		contentPane.add(midPanel);
		midPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("resources\\icons\\Country_House.png"));
		lblNewLabel_1.setBounds(808, 0, 202, 80);
		midPanel.add(lblNewLabel_1);

		botPanel = new JPanel();
		botPanel.setBackground(new Color(32,47,90));
		botPanel.setBounds(60, 130, 960, 590);
		contentPane.add(botPanel);
		botPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollBar sb = scrollPane.getVerticalScrollBar();
		sb.setUI(new MyScrollbarUI());
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBorder(null);
		scrollPane.setBounds(40, 11, 910, 539);
		scrollPane.setBackground(new Color(32, 47, 90));
		scrollPane.setViewportBorder(null);
		botPanel.add(scrollPane);
		
		JList list = new JList();
		DefaultListModel<ImageIcon> model = new DefaultListModel<ImageIcon>();
		ImageIcon img = new ImageIcon((new ImageIcon("image.jpg"))
				.getImage().getScaledInstance(100,100,
						java.awt.Image.SCALE_SMOOTH));
		model.add(0, img);
		model.add(1, img);
		model.add(2, img);
		model.add(3, img);
		model.add(4, img);
		model.add(5, img);
		model.add(6, img);
		model.add(7, img);
		model.add(8, img);
		model.add(9, img);
		model.add(10, img);
		model.add(11, img);
		model.add(12, img);
		model.add(13, img);
		model.add(14, img);
		model.add(15, img);
		model.add(16, img);
		model.add(17, img);
		model.add(18, img);
		model.add(19, img);
		model.add(20, img);
		list.setModel(model);
		list.setBackground(new Color(32, 47, 90));
		scrollPane.setViewportView(list);
	}
}
