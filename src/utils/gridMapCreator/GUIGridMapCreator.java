package utils.gridMapCreator;

import representations.maps.GridMap;

public class GUIGridMapCreator implements IGridMapCreator {
	public GridMap createMap (){
		return new GridMap(1,1); // dummy for now
	}
}
