package Utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ConfigManager {
	private static final ConfigManager configManager = new ConfigManager();
	
	private ConfigManager() { }
	
	public static ConfigManager getInstance() {
		return configManager;
	}
	
	private Document getXml() {		
		Document doc = null;
		
		try {
			File fXmlFile = new File("res/map.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
						
		} catch (Exception e) {
			e.printStackTrace();
	    }
		
		return doc;		
	}
	
	public String getMapName() {
		Document doc = getXml();
		NodeList nList = doc.getElementsByTagName("map");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		String mapName = eElement.getElementsByTagName("file").item(0).getTextContent();		
		return mapName;
	}
}
