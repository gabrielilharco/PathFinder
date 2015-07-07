package pathfinder.graphicInterface;

import javax.swing.*;

import pathfinder.graphicInterface.buttonListeners.ChooseAlgorithmButtonListener;
import pathfinder.graphicInterface.buttonListeners.CreateMapButtonListener;
import pathfinder.utils.ConfigManager;

import java.awt.*;

public class MainJPanel extends ImagePanel
{
	
	public MainJPanel()
	{
		  super(Backgrounds.getMainBackground());
		  setLayout(new BorderLayout());
		
		  //create map button
		  
		  JPanel westPanel = new JPanel(); 
		  westPanel.setOpaque(false);
		  westPanel.setBorder(BorderFactory.createEmptyBorder(350, 170, 0, 0));
		  JButton bCreateMap = new ImageButton(ConfigManager.getCreateMapName(),ConfigManager.getCreateMapClickedName());
		  westPanel.add(bCreateMap);
		  
		  bCreateMap.addActionListener(new CreateMapButtonListener());
		  
		  add(westPanel, BorderLayout.WEST);
		  
		  // run algorithm button
		  
		  JPanel eastPanel = new JPanel(); 
		  eastPanel.setOpaque(false);
		  eastPanel.setBorder(BorderFactory.createEmptyBorder(350, 0, 0, 170));
		  JButton bRunAlgorithm = new ImageButton(ConfigManager.getRunAlgorithmName(),ConfigManager.getRunAlgorithmClickedName());
		  eastPanel.add(bRunAlgorithm);
		  add(eastPanel, BorderLayout.EAST);
		  
		  bRunAlgorithm.addActionListener(new ChooseAlgorithmButtonListener());
		  
		  // run statistics button
		  
		  JPanel southPanel = new JPanel(); 
		  southPanel.setOpaque(false);
		  southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 300, 0));
		  JButton bRunStatistics = new ImageButton(ConfigManager.getRunStatisticsName(),ConfigManager.getRunStatisticsClickedName());
		  southPanel.add(bRunStatistics);
		  add(southPanel, BorderLayout.SOUTH);
		  
		  
		  //f.pack(); // call after everything has been added
		  //setLocationRelativeTo(null); // to center
		  setVisible(true);
	}

}