package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ChooseAlgorithmJFrame extends JFrame
{
	public ChooseAlgorithmJFrame()
	{
		  JFrame f = new JFrame("Path Finder");
		  BufferedImage myImage = null;
		  try {
		      myImage = ImageIO.read(new File("src/main/resources/choose_algorithm_background.png"));
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
		  JButton bDFS = new JButton(new ImageIcon("src/main/resources/dfs.png"));
		  bDFS.setBorderPainted(false);
		  bDFS.setContentAreaFilled(false);
		  bDFS.setFocusPainted(false);
		  bDFS.setOpaque(false);
		  bDFS.setSize(550, 150);
		  bDFS.setPressedIcon(new ImageIcon("src/main/resources/dfs_clicked.png"));
		  p1.add(bDFS);
		  secPanel.add(p1);
		  
		  JPanel p2 = new JPanel();
		  p2.setOpaque(false);
		  p2.setBorder(BorderFactory.createEmptyBorder(380, 0, 0, 70));
		  JButton bDijkstra = new JButton(new ImageIcon("src/main/resources/dijkstra.png"));
		  bDijkstra.setBorderPainted(false);
		  bDijkstra.setContentAreaFilled(false);
		  bDijkstra.setFocusPainted(false);
		  bDijkstra.setOpaque(false);
		  bDijkstra.setSize(550, 150);
		  bDijkstra.setPressedIcon(new ImageIcon("src/main/resources/dijkstra_clicked.png"));
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
		  JButton bAStar = new JButton(new ImageIcon("src/main/resources/a_star.png"));
		  bAStar.setBorderPainted(false);
		  bAStar.setContentAreaFilled(false);
		  bAStar.setFocusPainted(false);
		  bAStar.setOpaque(false);
		  bAStar.setSize(550, 150);
		  bAStar.setPressedIcon(new ImageIcon("src/main/resources/a_star_clicked.png"));
		  p3.add(bAStar);
		  thPanel.add(p3);
		  
		  JPanel p4 = new JPanel();
		  p4.setOpaque(false);
		  p4.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 70));
		  JButton bWaypoint = new JButton(new ImageIcon("src/main/resources/waypoints.png"));
		  bWaypoint.setBorderPainted(false);
		  bWaypoint.setContentAreaFilled(false);
		  bWaypoint.setFocusPainted(false);
		  bWaypoint.setOpaque(false);
		  bWaypoint.setSize(550, 150);
		  bWaypoint.setPressedIcon(new ImageIcon("src/main/resources/waypoints_clicked.png"));
		  p4.add(bWaypoint);
		  thPanel.add(p4);
		  
		  mainPanel.add(thPanel);
		  
		  JPanel p5 = new JPanel();
		  p5.setOpaque(false);
		  p5.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new JButton(new ImageIcon("src/main/resources/back.png"));
		  bBack.setBorderPainted(false);
		  bBack.setContentAreaFilled(false);
		  bBack.setFocusPainted(false);
		  bBack.setOpaque(false);
		  bBack.setSize(550, 150);
		  bBack.setPressedIcon(new ImageIcon("src/main/resources/back_clicked.png"));
		  p5.add(bBack);
		  mainPanel.add(p5);
		  
		  f.add(mainPanel);
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}