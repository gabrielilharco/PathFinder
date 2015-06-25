package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.graphicInterface.buttonListeners.MainButtonListener;
import pathfinder.utils.ConfigManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChooseAlgorithmJPanel extends ImagePanel
{
	
	public ChooseAlgorithmJPanel()
	{
		  //super("Path Finder");
		  super(Backgrounds.getChooseAlgorithmBackground());
		  //setSize(1520, 1050);
		  //setResizable(false);
		  
		  BoxLayout mainBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS); // top to bottom
		  setLayout(mainBoxLayout);
		  
		  JPanel secPanel = new JPanel();
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
		  
		  add(secPanel);

		  
		  JPanel thPanel = new JPanel(); 
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
		  
		  add(thPanel);
		  
		  JPanel p5 = new JPanel();
		  p5.setOpaque(false);
		  p5.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new ImageButton(ConfigManager.getBackName(),ConfigManager.getBackClickedName());
		  p5.add(bBack);
		  bBack.addActionListener(new MainButtonListener());
		  add(p5);
		  
		  
		  
		  //f.pack(); // call after everything has been added
		  //setLocationRelativeTo(null); // to center
		  setVisible(true);
	}

}