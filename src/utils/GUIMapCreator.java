package utils;

import representations.maps.GridMap;

public class GUIMapCreator implements IMapCreator {
	public GridMap createMap (){
		return new GridMap(1,1); // dummy for now
	}
}
