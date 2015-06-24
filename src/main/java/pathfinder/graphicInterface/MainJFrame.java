package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

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
		      myImage = ImageIO.read(new File("src/main/resources/background.png"));
		  } catch (Exception ex) {}
		  f.setSize(1520, 1050);
		  f.setResizable(false);
		  JPanel p = new ImagePanel(myImage);
		  p.setLayout(new BorderLayout());
		
		  //create map button
		  
		  JPanel westPanel = new JPanel(); // new FlowLayout not needed
		  westPanel.setOpaque(false);
		  westPanel.setBorder(BorderFactory.createEmptyBorder(350, 170, 0, 0));
		  JButton bCreateMap = new JButton(new ImageIcon("src/main/resources/create_map.png"));
		  bCreateMap.setBorderPainted(false);
		  bCreateMap.setContentAreaFilled(false);
		  bCreateMap.setFocusPainted(false);
		  bCreateMap.setOpaque(false);
		  bCreateMap.setSize(550, 150);
		  bCreateMap.setBounds(100,100,550,150);
		  bCreateMap.setPressedIcon(new ImageIcon("src/main/resources/create_map_clicked.png"));
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  westPanel.add(bCreateMap);
		  p.add(westPanel, BorderLayout.WEST);
		  
		  // run algorithm button
		  
		  JPanel eastPanel = new JPanel(); // new FlowLayout not needed
		  eastPanel.setOpaque(false);
		  eastPanel.setBorder(BorderFactory.createEmptyBorder(350, 0, 0, 170));
		  JButton bRunAlgorithm = new JButton(new ImageIcon("src/main/resources/run_algorithm.png"));
		  bRunAlgorithm.setBorderPainted(false);
		  bRunAlgorithm.setContentAreaFilled(false);
		  bRunAlgorithm.setFocusPainted(false);
		  bRunAlgorithm.setOpaque(false);
		  bRunAlgorithm.setSize(550, 150);
		  bRunAlgorithm.setBounds(100,100,550,150);
		  bRunAlgorithm.setPressedIcon(new ImageIcon("src/main/resources/run_algorithm_clicked.png"));
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  eastPanel.add(bRunAlgorithm);
		  p.add(eastPanel, BorderLayout.EAST);
		  
		  // run statistics button
		  
		  JPanel southPanel = new JPanel(); // new FlowLayout not needed
		  southPanel.setOpaque(false);
		  southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 300, 0));
		  JButton bRunStatistics = new JButton(new ImageIcon("src/main/resources/run_statistics.png"));
		  bRunStatistics.setBorderPainted(false);
		  bRunStatistics.setContentAreaFilled(false);
		  bRunStatistics.setFocusPainted(false);
		  bRunStatistics.setOpaque(false);
		  bRunStatistics.setSize(550, 150);
		  bRunStatistics.setBounds(100,100,550,150);
		  bRunStatistics.setPressedIcon(new ImageIcon("src/main/resources/run_statistics_clicked.png"));
		  //button.setPreferredSize(new Dimension(1050, 250)); // ?? I don't like this.
		  southPanel.add(bRunStatistics);
		  p.add(southPanel, BorderLayout.SOUTH);
		  
		  f.add(p);
		  
		  
		  
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}