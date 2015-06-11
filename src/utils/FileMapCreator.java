package utils;

import representations.Map;

public class FileMapCreator implements IMapCreator {
	public Map createMap (){
		return new Map(1,1); // dummy for now
	}
}
