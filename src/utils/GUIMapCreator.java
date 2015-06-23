package utils;

import representations.Map;

public class GUIMapCreator implements IMapCreator {
	public Map createMap (){
		return new Map(1,1); // dummy for now
	}
}
