package pathfinder.graphicInterface;

import javax.swing.*;

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