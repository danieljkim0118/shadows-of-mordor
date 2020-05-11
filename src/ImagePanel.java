import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	private Image background;
	
	public ImagePanel(Image img) {
		super();
		background = img;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
}
