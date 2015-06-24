package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.utils.ConfigManager;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainJFrame extends JFrame
{
	public MainJFrame()
	{
		  JFrame f = new JFrame("Path Finder");
		  BufferedImage myImage = null;
		  try {
		      myImage = ImageIO.read(new File(ConfigManager.getMainBackgroundName()));
		  } catch (Exception ex) {}
		  f.setSize(1520, 1050);
		  f.setResizable(false);
		  JPanel p = new ImagePanel(myImage);
		  p.setLayout(new BorderLayout());
		
		  //create map button
		  
		  JPanel westPanel = new JPanel(); // new FlowLayout not needed
		  westPanel.setOpaque(false);
		  westPanel.setBorder(BorderFactory.createEmptyBorder(350, 170, 0, 0));
		  JButton bCreateMap = new ImageButton(ConfigManager.getCreateMapName(),ConfigManager.getCreateMapClickedName());
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  westPanel.add(bCreateMap);
		  p.add(westPanel, BorderLayout.WEST);
		  
		  // run algorithm button
		  
		  JPanel eastPanel = new JPanel(); // new FlowLayout not needed
		  eastPanel.setOpaque(false);
		  eastPanel.setBorder(BorderFactory.createEmptyBorder(350, 0, 0, 170));
		  JButton bRunAlgorithm = new ImageButton(ConfigManager.getRunAlgorithmName(),ConfigManager.getRunAlgorithmClickedName());
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  eastPanel.add(bRunAlgorithm);
		  p.add(eastPanel, BorderLayout.EAST);
		  
		  // run statistics button
		  
		  JPanel southPanel = new JPanel(); // new FlowLayout not needed
		  southPanel.setOpaque(false);
		  southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 300, 0));
		  JButton bRunStatistics = new ImageButton(ConfigManager.getRunStatisticsName(),ConfigManager.getRunStatisticsClickedName());
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  southPanel.add(bRunStatistics);
		  p.add(southPanel, BorderLayout.SOUTH);
		  
		  f.add(p);
		  
		  
		  
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}