package main;

import processing.core.PApplet;
import representations.Map;
import draw.DisplayFrame;
import draw.GUIDrawer;
import utils.ImageMapCreator;
import representations.Path;

public class Main {
	public static void main(String[] args)  {
	
		ImageMapCreator fmc = new ImageMapCreator();
		Map map = fmc.createMap();

		new DisplayFrame().setVisible(true);

		//drawer.drawPath(new Path(), map);
		System.out.println("Finished test");
	}

}
