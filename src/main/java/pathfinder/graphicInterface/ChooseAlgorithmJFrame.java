package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.utils.ConfigManager;

import java.awt.image.BufferedImage;
import java.io.File;

public class ChooseAlgorithmJFrame extends JFrame
{
	public ChooseAlgorithmJFrame()
	{
		  JFrame f = new JFrame("Path Finder");
		  BufferedImage myImage = null;
		  try {
		      myImage = ImageIO.read(new File(ConfigManager.getChooseAlgorithmBackgroundName()));
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
		  p1.setBorder(BorderFactory.createEmptyBorder(380, 70, 0, 0));
		  JButton bDFS = new ImageButton(ConfigManager.getDFSName(),ConfigManager.getDFSClickedName());
		  p1.add(bDFS);
		  secPanel.add(p1);
		  
		  JPanel p2 = new JPanel();
		  p2.setOpaque(false);
		  p2.setBorder(BorderFactory.createEmptyBorder(380, 0, 0, 70));
		  JButton bDijkstra = new ImageButton(ConfigManager.getDijkstraName(), ConfigManager.getDijkstraClickedName());
		  p2.add(bDijkstra);
		  secPanel.add(p2);
		  
		  mainPanel.add(secPanel);

		  
		  JPanel thPanel = new JPanel(); // new FlowLayout not needed
		  BoxLayout thBoxLayout = new BoxLayout(thPanel, BoxLayout.X_AXIS); // top to bottom
		  thPanel.setLayout(thBoxLayout);
		  thPanel.setOpaque(false);
		  
		  JPanel p3 = new JPanel();
		  p3.setOpaque(false);
		  p3.setBorder(BorderFactory.createEmptyBorder(30, 70, 0, 0));
		  JButton bAStar = new ImageButton(ConfigManager.getAStarName(), ConfigManager.getAStarClickedName());
		  p3.add(bAStar);
		  thPanel.add(p3);
		  
		  JPanel p4 = new JPanel();
		  p4.setOpaque(false);
		  p4.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 70));
		  JButton bWaypoint = new ImageButton(ConfigManager.getWaypointName(), ConfigManager.getWaypointClickedName());
		  p4.add(bWaypoint);
		  thPanel.add(p4);
		  
		  mainPanel.add(thPanel);
		  
		  JPanel p5 = new JPanel();
		  p5.setOpaque(false);
		  p5.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new ImageButton(ConfigManager.getBackName(),ConfigManager.getBackClickedName());
		  p5.add(bBack);
		  mainPanel.add(p5);
		  
		  f.add(mainPanel);
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}