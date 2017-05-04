package dialogDemo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MyDialog extends JDialog {

	MyDialog dialog = this;
	private JPanel panel;
	private Boolean Outside = false;

	public MyDialog(JFrame parent) {
		super(parent, true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Outside)
				SwingUtils.fadeOut(dialog);
			}
		});

		setUndecorated(true);
		//AWTUtilities.setWindowOpaque(this, false);
		this.setBackground(new Color(0,0,0,200));

		setTitle("My Dialog");

		JLabel label = new JLabel("Oh boi!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 20));

		panel = new JPanel(new GridBagLayout());
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
		panel.setBackground(new Color(0xAA05579));
		panel.setLayout(new GridBagLayout());
		panel.add(label);
		panel.setPreferredSize(new Dimension(400, 300));

		// the following two lines are only needed because there is no
		// focusable component in here, and the "hit espace to close" requires
		// the focus to be in the dialog. If you have a button, a textfield,
		// or any focusable stuff, you don't need these lines.
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		getContentPane().add(panel);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
		SwingUtils.addEscapeToCloseSupport(this, true);
	}
}
