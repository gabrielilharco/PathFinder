package utils.gridMapCreator;

import representations.maps.GridMap;
import representations.primitives.Point;
import utils.ConfigManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileGridMapCreator implements IGridMapCreator {
	public GridMap createMap (){
		
		String fileName = ConfigManager.getTextMapName();
		BufferedReader bufferedReader = null;
		try {
			 
			String currentLine;
			
			FileReader fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			
			int height = 0;
			int width = 0;
			
			while ((currentLine = bufferedReader.readLine()) != null) {
				if (width < currentLine.length())
					width = currentLine.length();
				height++;
			}
			
			bufferedReader.close();
			fileReader.close();
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			
			GridMap map = new GridMap(width,height);
			
			int x, y = 0;
			
			while ((currentLine = bufferedReader.readLine()) != null) {
				for (x = 0; x < currentLine.length(); x++) {
					if (currentLine.charAt(x) == 'x')
						map.setPointAsObstacle(new Point(x,y));
				}
				y++;
			}
			return map;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (bufferedReader != null)bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		
	
	}
}