package GUI;

import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GoogleMaps extends JFrame {

	private JPanel contentPane;
	private JLabel map = new JLabel();
	
	private int mZoom = 18;
	private String mLocation = "errazkinenea_4";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoogleMaps frame = new GoogleMaps();
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
	public GoogleMaps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 11, 300, 300);
		map.setIcon(getMap(mLocation, mZoom));
		panel.add(map);
		contentPane.add(panel);
		
		JButton btnZoomIn = new JButton("Zoom In");
		btnZoomIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mZoom += 1;
				map.setIcon((getMap(mLocation, mZoom)));
				contentPane.add(panel);
			}
		});
		btnZoomIn.setBounds(92, 373, 89, 23);
		contentPane.add(btnZoomIn);
		
		JButton btnZoomOut = new JButton("Zoom out");
		btnZoomOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mZoom -= 1;
				map.setIcon((getMap(mLocation, mZoom)));
				contentPane.add(panel);
			}
		});
		btnZoomOut.setBounds(303, 373, 89, 23);
		contentPane.add(btnZoomOut);
	}
	
	private ImageIcon getMap(String location, int zoom){
		try {
			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
					+ location + "&zoom=" +
					zoom + "&size=300x300&scale=2&maptype=hybrid&markers=color:red|" + 
					location;
			String destinationFile = "image.jpg";
			// read the map image from Google
			// then save it to a local file: image.jpg
			//
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// create a GUI component that loads the image: image.jpg
		//
		ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
				.getImage().getScaledInstance(300, 320,
						java.awt.Image.SCALE_SMOOTH));
		return imageIcon;
	}
}
