package pathfinder.graphicInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import pathfinder.graphicInterface.buttonListeners.MainButtonListener;
import pathfinder.utils.ConfigManager;

import java.awt.image.BufferedImage;
import java.io.File;

public class CreateMapJPanel extends ImagePanel
{
	public CreateMapJPanel()
	{
		  super(Backgrounds.getCreateMapBackground());

		  BoxLayout mainBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS); // top to bottom
		  setLayout(mainBoxLayout);
		  
		
		  
		  JPanel secPanel = new JPanel(); 
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
		  
		  add(secPanel);

		  JPanel p3 = new JPanel();
		  p3.setOpaque(false);
		  p3.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		  JButton bDrawMap = new ImageButton(ConfigManager.getDrawMapName(),ConfigManager.getDrawMapClickedName());
		  p3.add(bDrawMap);
		  add(p3);
		  
		  
		  JPanel p4 = new JPanel();
		  p4.setOpaque(false);
		  p4.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 1300));
		  JButton bBack = new ImageButton (ConfigManager.getBackName(), ConfigManager.getBackClickedName());
		  bBack.addActionListener(new MainButtonListener());
		  p4.add(bBack);
		  
		  add(p4);
		  
		  setVisible(true);
	}

}