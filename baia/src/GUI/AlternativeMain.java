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
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class AlternativeMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserta;
	private JTextField txtFechaDeInicio;
	private JTextField txtFechaDeVuelta;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(22,21,23));
		panel_1.setBounds(0, 430, 1064, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(22,21,23,230));
		panel_2.setBounds(0, 0, 1064, 68);
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1064, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(12, 158, 188));
		panel_3.setBounds(99, 274, 865, 127);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		txtInserta = new JTextField();
		txtInserta.setText("Inserta ciudad, regi\u00F3n o distrito");
		txtInserta.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtInserta.setBorder(null);
		txtInserta.setBounds(80, 40, 212, 45);
		panel_3.add(txtInserta);
		txtInserta.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(35, 40, 52, 45);
		panel_3.add(panel_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("resources\\icons\\Marker_32px.png"));
		panel_4.add(label_1);
		
		txtFechaDeInicio = new JTextField();
		txtFechaDeInicio.setText("Fecha de inicio");
		txtFechaDeInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtFechaDeInicio.setColumns(10);
		txtFechaDeInicio.setBorder(null);
		txtFechaDeInicio.setBounds(365, 40, 149, 45);
		panel_3.add(txtFechaDeInicio);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(320, 40, 45, 45);
		panel_3.add(panel_5);
		
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon("resources\\icons\\Date From_32px.png"));
		panel_5.add(label_2);
		
		txtFechaDeVuelta = new JTextField();
		txtFechaDeVuelta.setText("Fecha de vuelta");
		txtFechaDeVuelta.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtFechaDeVuelta.setColumns(10);
		txtFechaDeVuelta.setBorder(null);
		txtFechaDeVuelta.setBounds(569, 40, 149, 45);
		panel_3.add(txtFechaDeVuelta);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(524, 40, 45, 45);
		panel_3.add(panel_6);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("resources\\icons\\Date To_32px.png"));
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(12,158,188));
		panel_7.setBounds(722, 0, 143, 127);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setBounds(45, 51, 53, 25);
		panel_7.add(lblBuscar);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(22, 14, 99, 99);
		label_4.setIcon(new ImageIcon("resources\\icons\\Circle_99px.png"));
		panel_7.add(label_4);
		
		JLabel lblViaje = new JLabel("El viaje de tus sue\u00F1os");
		lblViaje.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblViaje.setForeground(new Color(255, 255, 255));
		lblViaje.setBounds(444, 144, 176, 22);
		panel.add(lblViaje);
		
		JLabel lblClicks = new JLabel("solo a unos clicks de distancia");
		lblClicks.setForeground(Color.WHITE);
		lblClicks.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblClicks.setBounds(405, 189, 254, 22);
		panel.add(lblClicks);
		
		JLabel lblBackG = new JLabel("");
		lblBackG.setForeground(Color.WHITE);
		lblBackG.setBounds(0, 5, 1064, 426);
		lblBackG.setIcon(new ImageIcon("resources\\icons\\backgroundImage.png"));
		panel.add(lblBackG);
	}
}
