package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import java.awt.Font;

public class popup extends JDialog {

	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			popup dialog = new popup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void exit(){
		dispose();
	}

	@Override
	public void setVisible(boolean visible){
		if (visible == false) super.setVisible(visible);
		else{
			new Timer(1, new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					if (panel.getWidth() <= 600){
						panel.setBounds(panel.getX()-10, panel.getY()-10, panel.getWidth()+20, panel.getHeight()+20);
						
					}else{
						((Timer) e.getSource()).stop();
						getContentPane().setBackground(new Color(0.0f,0.18f,0.5f,0.4f));
						setBackground(new Color(0.0f,0.18f,0.5f,0.4f));
					}
				}
			}).start();
			super.setVisible(visible);
		}
	}

	/**
	 * Create the dialog.
	 */
	public popup() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setResizable(false);
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
		});
		setUndecorated(true);
		setType(Type.POPUP);
		getContentPane().setBackground(new Color(0.0f,0.18f,0.5f,0.25f));
		setBackground(new Color(0.0f,0.18f,0.5f,0.25f));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1079, 720);
		getContentPane().setLayout(null);
		panel.setBackground(new Color(106,116,145));
		panel.setBounds(389, 210, 300, 300);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnHolaBuenas = new JButton("Boton");
		btnHolaBuenas.setBounds(250, 280, 100, 40);
		panel.add(btnHolaBuenas);
	}
}
