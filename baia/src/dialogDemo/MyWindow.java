package dialogDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.DateTextField;
import GUI.HouseView;

import java.awt.GridBagConstraints;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MyWindow extends JFrame {
	public MyWindow() {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, MyWindow.class.getResourceAsStream("SquareFont.ttf"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
		} catch (FontFormatException | IOException ex) {
			throw new RuntimeException(ex);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Application");
		setSize(1600, 1200);
		

		JButton button = new JButton("Spawn the dialog!");
		button.setOpaque(false);
		button.setFocusable(false);
		button.setFont(new Font(button.getFont().getFontName(), Font.PLAIN, 16));
		button.setMargin(new Insets(5, 10, 5, 10));
		button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				HouseView dialog = new HouseView(MyWindow.this);
				SwingUtils.fadeIn(dialog);
			}
		});

		JPanel panel = new JPanel(new GridBagLayout());
		
		DateTextField dtf = new DateTextField();
		dtf.setSize(50, 20);
		GridBagConstraints gbc_dtf = new GridBagConstraints();
		gbc_dtf.insets = new Insets(0, 0, 5, 5);
		gbc_dtf.gridx = 0;
		gbc_dtf.gridy = 0;
		panel.add(dtf, gbc_dtf);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		panel.add(button, gbc_button);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new Color(0x2A3B57)));

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
	}
}
