package pathfinder.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

//utility for getting resources from  xml file
public class ConfigManager {
	private static final ConfigManager configManager = new ConfigManager();
	
	private ConfigManager() { }
	
	public static ConfigManager getInstance() {
		return configManager;
	}
	
	private static Document getXml() {		
		Document doc = null;
		
		try {
			File fXmlFile = new File("src/main/resources/map.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		 
			doc.getDocumentElement().normalize();
						
		} catch (Exception e) {
			e.printStackTrace();
	    }
		
		return doc;		
	}
	
	public static String getName(String tag, String subtag) {
		Document doc = getXml();
		NodeList nList = doc.getElementsByTagName(tag);
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		//System.out.println(subtag);
		String name = eElement.getElementsByTagName(subtag).item(0).getTextContent();		
		return name;
	}
	
	// maps
	
	public static String getImageMapName() {
		return getName("map", "image_file");
	}
	
	public static String getTextMapName() {
		return getName("map", "text_file");
	}
	
	public static String getVerticesMapName() {
		return getName("map", "vertices_file");
	}
	
	// backgrounds
	
	public static String getMainBackgroundName() {
		return getName("backgrounds", "main");
	}
	
	public static String getCreateMapBackgroundName() {
		return getName("backgrounds", "map_creator");
	}
	
	public static String getChooseAlgorithmBackgroundName() {
		return getName("backgrounds", "choose_algorithm");
	}
	
	
	// buttons
	
	public static String getAStarName() {
		return getName("buttons", "a_star");
	}
	
	public static String getAStarClickedName() {
		return getName("buttons", "a_star_clicked");
	}
	
	public static String getBackName() {
		return getName("buttons", "back");
	}
	
	public static String getBackClickedName() {
		return getName("buttons", "back_clicked");
	}
	
	public static String getCreateMapName() {
		return getName("buttons", "create_map");
	}
	
	public static String getCreateMapClickedName() {
		return getName("buttons", "create_map_clicked");
	}
	
	public static String getDFSName() {
		return getName("buttons", "dfs");
	}
	
	public static String getDFSClickedName() {
		return getName("buttons", "dfs_clicked");
	}
	
	public static String getDijkstraName() {
		return getName("buttons", "dijkstra");
	}
	
	public static String getDijkstraClickedName() {
		return getName("buttons", "dijkstra_clicked");
	}
	
	public static String getDrawMapName() {
		return getName("buttons", "draw_map");
	}
	
	public static String getDrawMapClickedName() {
		return getName("buttons", "draw_map_clicked");
	}
	
	public static String getFromFileName() {
		return getName("buttons", "from_file");
	}
	
	public static String getFromFileClickedName() {
		return getName("buttons", "from_file_clicked");
	}
	
	public static String getFromImageName() {
		return getName("buttons", "from_image");
	}
	
	public static String getFromImageClickedName() {
		return getName("buttons", "from_image_clicked");
	}
	
	public static String getRunAlgorithmName() {
		return getName("buttons", "run_algorithm");
	}
	
	public static String getRunAlgorithmClickedName() {
		return getName("buttons", "run_algorithm_clicked");
	}
	
	public static String getRunStatisticsName() {
		return getName("buttons", "run_statistics");
	}
	
	public static String getRunStatisticsClickedName() {
		return getName("buttons", "run_statistics_clicked");
	}
	
	public static String getWaypointName() {
		return getName("buttons", "waypoints");
	}
	
	public static String getWaypointClickedName() {
		return getName("buttons", "waypoints_clicked");
	}
		
	
}
