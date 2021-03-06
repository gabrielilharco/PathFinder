package pathfinder.utils.gridMapCreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import pathfinder.representations.maps.GridMap;
import pathfinder.utils.ConfigManager;

import javax.imageio.ImageIO;

public class ImageGridMapCreator extends AbstractGridMapCreator {
	public GridMap createMap (){
		try {
			
			String fileName = ConfigManager.getImageMapName();
			System.out.println(fileName);
			
			BufferedImage image = null;
			
			try {
			    image = ImageIO.read( new File(fileName));
			} catch (IOException e) {
				System.out.println("Could not read file. Given path: "+ fileName);
			}

			int mWidth = image.getWidth();
			int mHeight = image.getHeight();
			System.out.println(mWidth);
			System.out.println(mHeight);
			
			GridMap map = new GridMap(mWidth, mHeight); 
			for (int y = 0; y < mHeight; y++) {
				for (int x = 0; x < mWidth; x++) {

					int rgb = image.getRGB(x, y);
					int red = (rgb & 0x00ff0000) >> 16;
                	int green = (rgb & 0x0000ff00) >> 8;
                	int blue = rgb & 0x000000ff;
					
					if (red >= 0x000000e0 && green >= 0x000000e0 && blue >= 0x000000e0) { // if it's black-ish
						map.isObstacle[x][y] = false;
					}
					else {
						map.isObstacle[x][y] = true;
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
	    }
		
		return null;
	}
}



//package pathfinder.Utils;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import pathfinder.representations.Map;
//import pathfinder.representations.Point;
//
//public class ImageMapCreator implements IMapCreator {
//	final String fileName = "map1.txt";
//	
//	//stores the image on disk
//	BufferedImage img = null;
//	
//	public ImageMapCreator() {
//		readImageFromDisk();
//	}
//	
//	public Map createMap () {
//		//change this to alter map size
//		Map map = new Map (img.getWidth(), img.getHeight());
//		
//		//iterate over all pixels
//		for (int y = 0; y < img.getHeight(); y++) {
//			for (int x = 0; x < img.getWidth(); x++) {
//				int pixel = img.getRGB(x, y);
//				
//				//black = obstacle
//				if ((pixel & 0x00FFFFFF) == 0) {
//					map.setPointAsObstacle(new Point(x,y));
//				}
//			}
//		}
//		return map;
//	}
//	
//	public void readImageFromDisk() {
//		try {
//			//Get file from resources folder
////			ClassLoader classLoader = getClass().getClassLoader();
////			File mapFile = new File(classLoader.getResource("/resources/" + fileName).getFile());
//			File mapFile = new File("resources/" + fileName);
//		    img = ImageIO.read(mapFile);
//		} 
//		catch (IOException e) {
//			System.out.println("Could not read file");
//		}
//	}
//}
