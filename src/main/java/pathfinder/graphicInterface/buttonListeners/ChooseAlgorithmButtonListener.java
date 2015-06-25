package pathfinder.graphicInterface.buttonListeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pathfinder.graphicInterface.ChooseAlgorithmJPanel;

public class ChooseAlgorithmButtonListener implements ActionListener{

    public void actionPerformed(ActionEvent e)
    {

      JPanel p = new ChooseAlgorithmJPanel();
      JFrame f = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
      f.getContentPane().removeAll();
      f.getContentPane().add(p);
      f.revalidate();
      f.repaint();
      
    }
}
