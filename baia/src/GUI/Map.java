package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Map extends JPanel {
	
	private JLabel map = new JLabel();
	private String Location;
	private int Zoom;
	private JPanel panel = new JPanel();

	/**
	 * Create the panel.
	 */
	public Map(String mLocation, int mZoom) {
		this.setLayout(null);	
		Location = mLocation;
		Zoom = mZoom;
		panel.setBackground(new Color(32,33,36));
		panel.setBounds(0, 0, 300, 300);
		map.setIcon(getMap(mLocation, mZoom));
		panel.add(map);
		add(panel);
		
		JButton btnZoomIn = new JButton("Zoom In");
		btnZoomIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Zoom += 1;
				map.setIcon((getMap(Location, Zoom)));
				add(panel);
			}
		});
		btnZoomIn.setBounds(0, 299, 89, 23);
		add(btnZoomIn);
		
		JButton btnZoomOut = new JButton("Zoom out");
		btnZoomOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Zoom -= 1;
				map.setIcon((getMap(Location, Zoom)));
				add(panel);
			}
		});
		btnZoomOut.setBounds(211, 299, 89, 23);
		add(btnZoomOut);
	}
	public void zoomIn(){
		Zoom += 1;
		map.setIcon((getMap(Location, Zoom)));
		add(panel);
	}
	public void zoomOut(){
		Zoom -= 1;
		map.setIcon((getMap(Location, Zoom)));
		add(panel);
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
