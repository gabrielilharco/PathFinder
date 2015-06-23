package utils;

import representations.maps.Map;

public class GUIMapCreator implements IMapCreator {
	public Map createMap (){
		return new Map(1,1); // dummy for now
	}
}
