package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.utils.ConfigManager;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainJFrame extends JFrame
{
	public MainJFrame() throws IOException
	{
		  JFrame f = new JFrame("Path Finder");
		  f.setSize(1500, 1050);
		  f.setResizable(false);
		  JPanel p = new MainJPanel();
		  
		  f.add(p);
		  
		  //f.pack(); // call after everything has been added
		  f.setLocationRelativeTo(null); // to center
		  f.setVisible(true);
	}

}