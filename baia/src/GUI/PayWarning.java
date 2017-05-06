package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialogDemo.SwingUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class PayWarning extends JDialog {

	PayWarning dialog = this;
	private JPanel panel;
	private Boolean Outside = true;

	public PayWarning(JFrame parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Enable back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("");
		
		
		// Dialog panel
		panel = new JPanel();
		panel.setBackground(new Color(32,33,36));
		panel.setLayout(null);
		//panel.setPreferredSize(new Dimension(400, 300));
		panel.setPreferredSize(new Dimension(450,100));

		
		// The following two lines are only needed because there is no
		// focusable component in here, and the "hit ESC to close" requires
		// the focus to be in the dialog. If you have a button, a text field,
		// or any focusable stuff, you don't need these lines.
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCancel = new JButton("No");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtils.fadeOut(dialog);
			}
		});
		btnCancel.setBounds(69, 49, 89, 23);
		panel.add(btnCancel);
		
		JButton btnAccept = new JButton("Yes");
		btnAccept.setBounds(283, 49, 89, 23);
		panel.add(btnAccept);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to rent this rural house?");
		lblAreYouSure.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setForeground(Color.WHITE);
		lblAreYouSure.setBounds(10, 11, 430, 27);
		panel.add(lblAreYouSure);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}
