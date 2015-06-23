package utils;

import java.io.File;
import java.util.Scanner;

import representations.maps.VertexMap;
import representations.primitives.Point;
import representations.primitives.Rectangle;

public class TextFileVertexMapCreator implements IVertexMapCreator {

	@Override
	public VertexMap createMap() {
		try {
			VertexMap map = null;
			
			String fileName = ConfigManager.getVerticesMapName();
			String separator = " ";
			
			File inputFile = null;
			
			inputFile = new File(fileName);			
			Scanner fileScan = new Scanner(inputFile);
			
			if (!fileScan.hasNext()) {
				fileScan.close();
				throw new java.io.IOException("Could not read first line of input file. Given path: " + fileName);
			}
			
			String line = fileScan.nextLine();
			String[] lineArray = line.split(separator);
			
			try {
				int mWidth = Integer.parseInt(lineArray[0]);
				int mHeight = Integer.parseInt(lineArray[1]);
				map = new VertexMap(mWidth, mHeight);
			}
			catch (NumberFormatException e) {
				System.out.println("Wrong format on first line of input file. Expecting 2 integers.");
			}		
			
			while (fileScan.hasNext()) {
				line = fileScan.nextLine();
				lineArray = line.split(separator);
				int upperX = Integer.parseInt(lineArray[0]);
				int upperY = Integer.parseInt(lineArray[1]);
				int lowerX = Integer.parseInt(lineArray[2]);
				int lowerY = Integer.parseInt(lineArray[3]);
				Point upper = new Point(upperX, upperY);
				Point lower = new Point(lowerX, lowerY);				
				map.addRectangleObstacle(new Rectangle(upper, lower));
			}
			
			fileScan.close();
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
	    }
		return null;		
	}

}
