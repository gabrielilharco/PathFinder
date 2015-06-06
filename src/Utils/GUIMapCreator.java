package Utils;

import Representations.Map;

public class GUIMapCreator implements iMapCreator {
	public Map createMap (){
		return new Map(1,1); // dummy for now
	}
}
