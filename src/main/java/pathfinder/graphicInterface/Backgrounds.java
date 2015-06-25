package pathfinder.graphicInterface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pathfinder.utils.ConfigManager;

public class Backgrounds {
	public static BufferedImage getMainBackground() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(ConfigManager.getMainBackgroundName()));
		} catch (IOException e) {
			
		}
		return image;

	}
	
	public static BufferedImage getChooseAlgorithmBackground() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(ConfigManager.getChooseAlgorithmBackgroundName()));
		} catch (IOException e) {
			
		}
		return image;

	}
	
	public static BufferedImage getCreateMapBackground() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(ConfigManager.getCreateMapBackgroundName()));
		} catch (IOException e) {
			
		}
		return image;

	}

}
