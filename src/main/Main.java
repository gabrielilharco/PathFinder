package main;

import java.io.Console;

import representations.Map;
import Utils.ImageMapCreator;

public class Main {

	public static void main(String[] args) {
	
		ImageMapCreator fmc = new ImageMapCreator();
		Map map = fmc.createMap();
		
		System.out.println("Finished test");
	}

}
