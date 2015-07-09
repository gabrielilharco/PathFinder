package pathfinder.main;

import java.io.IOException;

import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.RecursiveDepthFirstSearch;
import pathfinder.algorithm.Heuristic;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Edge;
import pathfinder.representations.primitives.Point;
import pathfinder.statistics.Benchmark;
import pathfinder.draw.GUIDrawer;
import pathfinder.graphicInterface.ChooseAlgorithmJPanel;
import pathfinder.graphicInterface.CreateMapJPanel;
import pathfinder.utils.graphCreator.GridGraphCreator;
import pathfinder.utils.gridMapCreator.ImageGridMapCreator;
import pathfinder.graphicInterface.MainJFrame;

//main-entry point for program
public class Main {
	public static void main(String[] args)  {
	
		
//		Benchmark b = new Benchmark();
//		b.generateGridMapStatistics();
		
		//start the UI
		try {
			new MainJFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished test");
	}

}
