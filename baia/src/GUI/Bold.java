package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Bold extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bold frame = new Bold();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String printS = "Hola buenas tardes";
	String searchS = "buenas";
	String F,M,L;
	public String formatS(String main, String substring){
		int N = main.indexOf(substring);
		int N2 = N + substring.length();
		if (N == -1){
			return null;
		}
		F = main.substring(0, N);
		M = main.substring(N,N2);
		String html = "<html>";
		String M2 = "<b>".concat(M.concat("</b>"));
		L = main.substring(N2, printS.length());
		String finalS = html.concat(F.concat(M2.concat(L.concat("</html>"))));
		//System.out.println(M);
		return finalS;
		
	}

	/**
	 * Create the frame.
	 */
	public Bold() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setText(formatS(printS, searchS));
		contentPane.add(label, BorderLayout.CENTER);
	}

}
