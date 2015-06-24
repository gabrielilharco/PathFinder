package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateMapJFrame extends JFrame
{
	public CreateMapJFrame()
	{
		JFrame f = new JFrame("Path Finder");
		  BufferedImage myImage = null;
		  try {
		      myImage = ImageIO.read(new File("src/main/resources/map_creator_background.png"));
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
		  JButton bFromFile = new JButton(new ImageIcon("src/main/resources/from_file.png"));
		  bFromFile.setBorderPainted(false);
		  bFromFile.setContentAreaFilled(false);
		  bFromFile.setFocusPainted(false);
		  bFromFile.setOpaque(false);
		  bFromFile.setSize(550, 150);
		  bFromFile.setPressedIcon(new ImageIcon("src/main/resources/from_file_clicked.png"));
		  p1.add(bFromFile);
		  secPanel.add(p1);
		  
		  JPanel p2 = new JPanel();
		  p2.setOpaque(false);
		  p2.setBorder(BorderFactory.createEmptyBorder(400, 0, 0, 60));
		  JButton bFromImage = new JButton(new ImageIcon("src/main/resources/from_image.png"));
		  bFromImage.setBorderPainted(false);
		  bFromImage.setContentAreaFilled(false);
		  bFromImage.setFocusPainted(false);
		  bFromImage.setOpaque(false);
		  bFromImage.setSize(550, 150);
		  bFromImage.setPressedIcon(new ImageIcon("src/main/resources/from_image_clicked.png"));
		  p2.add(bFromImage);
		  secPanel.add(p2);
		  
		  mainPanel.add(secPanel);

		  JPanel p3 = new JPanel();
		  p3.setOpaque(false);
		  p3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		  JButton bDrawMap = new JButton(new ImageIcon("src/main/resources/draw_map.png"));
		  bDrawMap.setBorderPainted(false);
		  bDrawMap.setContentAreaFilled(false);
		  bDrawMap.setFocusPainted(false);
		  bDrawMap.setOpaque(false);
		  bDrawMap.setSize(550, 150);
		  bDrawMap.setPressedIcon(new ImageIcon("src/main/resources/draw_map_clicked.png"));
		  p3.add(bDrawMap);
		  mainPanel.add(p3);
		  
		  
		  JPanel p4 = new JPanel();
		  p4.setOpaque(false);
		  p4.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new JButton(new ImageIcon("src/main/resources/back.png"));
		  bBack.setBorderPainted(false);
		  bBack.setContentAreaFilled(false);
		  bBack.setFocusPainted(false);
		  bBack.setOpaque(false);
		  bBack.setSize(550, 150);
		  bBack.setPressedIcon(new ImageIcon("src/main/resources/back_clicked.png"));
		  p4.add(bBack);
		  mainPanel.add(p4);
		  
		  f.add(mainPanel);
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}