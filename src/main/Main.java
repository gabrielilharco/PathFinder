package main;

import representations.Map;
import utils.IMapCreator;
import utils.ImageMapCreator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		IMapCreator mapCreator = new  ImageMapCreator();
		Map map = mapCreator.createMap();
		System.out.println("Finished test");
	}

}
