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


public class MyDialog extends JDialog {

	MyDialog dialog = this;
	private JPanel panel;
	private Boolean Outside = false;

	public MyDialog(JFrame parent) {
		super(parent, true);


		setUndecorated(true);
		
		
		// Back panel transparency
		this.setBackground(new Color(0,0,0,0));
		
		
		// Name/Title of the Dialog
		setTitle("My Dialog");
		
		
		// Inside of the Dialog
		JLabel label = new JLabel("Oh boi!");
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 20));
		
		
		// Dialog panel
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(21,23,22));
		panel.setLayout(new GridBagLayout());
		panel.add(label);
		//panel.setPreferredSize(new Dimension(400, 300));
		panel.setPreferredSize(new Dimension(800, 600));

		
		// The following two lines are only needed because there is no
		// focusable component in here, and the "hit ESC to close" requires
		// the focus to be in the dialog. If you have a button, a text field,
		// or any focusable stuff, you don't need these lines.
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		
		// Support for close on clicking outside the dialog
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Outside)
					SwingUtils.fadeOut(dialog);
			}
		});

		getContentPane().add(panel);

		SwingUtils.createDialogBackPanel(this, parent.getContentPane());
	}
}
