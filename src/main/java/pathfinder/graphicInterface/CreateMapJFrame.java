package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.utils.ConfigManager;

import java.awt.image.BufferedImage;
import java.io.File;

public class CreateMapJFrame extends JFrame
{
	public CreateMapJFrame()
	{
		JFrame f = new JFrame("Path Finder");
		  BufferedImage myImage = null;
		  try {
		      myImage = ImageIO.read(new File(ConfigManager.getCreateMapBackgroundName()));
		  } catch (Exception ex) {}
		  f.setSize(1520, 1050);
		  f.setResizable(false);
		  
		  JPanel mainPanel = new ImagePanel(myImage);

		  BoxLayout mainBoxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS); // top to bottom
		  mainPanel.setLayout(mainBoxLayout);
		  
		
		  
		  JPanel secPanel = new JPanel(); // new FlowLayout not needed
		  BoxLayout secBoxLayout = new BoxLayout(secPanel, BoxLayout.X_AXIS); // top to bottom
		  secPanel.setLayout(secBoxLayout);
		  secPanel.setOpaque(false);
		  
		 
		  
		  JPanel p1 = new JPanel();
		  p1.setOpaque(false);
		  p1.setBorder(BorderFactory.createEmptyBorder(400, 60, 0, 0));
		  JButton bFromFile = new ImageButton(ConfigManager.getFromFileName(),ConfigManager.getFromFileClickedName());
		  p1.add(bFromFile);
		  secPanel.add(p1);
		  
		  JPanel p2 = new JPanel();
		  p2.setOpaque(false);
		  p2.setBorder(BorderFactory.createEmptyBorder(400, 0, 0, 60));
		  JButton bFromImage = new ImageButton(ConfigManager.getFromImageName(),ConfigManager.getFromImageClickedName());
		  p2.add(bFromImage);
		  secPanel.add(p2);
		  
		  mainPanel.add(secPanel);

		  JPanel p3 = new JPanel();
		  p3.setOpaque(false);
		  p3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		  JButton bDrawMap = new ImageButton(ConfigManager.getDrawMapName(),ConfigManager.getDrawMapClickedName());
		  p3.add(bDrawMap);
		  mainPanel.add(p3);
		  
		  
		  JPanel p4 = new JPanel();
		  p4.setOpaque(false);
		  p4.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new ImageButton (ConfigManager.getBackName(), ConfigManager.getBackClickedName());
		  p4.add(bBack);
		  mainPanel.add(p4);
		  
		  f.add(mainPanel);
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}