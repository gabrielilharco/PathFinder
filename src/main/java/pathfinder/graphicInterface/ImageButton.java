package pathfinder.graphicInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{
	public ImageButton (String source, String clickedSource) {
		super(new ImageIcon(source));
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
		this.setPressedIcon(new ImageIcon(clickedSource));
		
	}
}
