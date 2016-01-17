/*
 *   Test created for Coursera course
 * 
 */
package tsp;

import graph.AdjMatrixDirectedGraph;
import graph.AdjMatrixUndirectedGraph;
import graph.GraphFactory;
import graph.TSPPath;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TSPTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader r = new BufferedReader(new FileReader("data/TSPgraph.txt"));
		AdjMatrixDirectedGraph g = GraphFactory.read(r);
		g.setVertexName(0, "SD");
		g.setVertexName(1, "Lima");
		g.setVertexName(2, "Paris");
		g.setVertexName(3, "Chen.");
		g.setVertexName(4, "Cairo");
		g.setVertexName(5, "Perth");
		g.setVertexName(6, "Beij");
		g.setVertexName(7, "Jberg");
				
		ITSPAlgorithm tspBruteForce = (ITSPAlgorithm) new TSPBruteForce(g);
		ITSPAlgorithm tspNearestNeighbor = (ITSPAlgorithm) new TSPNearestNeighbor(g);
		ITSPAlgorithm tspRandomSelection = (ITSPAlgorithm) new TSPRandomSelection(g);
		ITSPAlgorithm tspGeneticAlgorithm = (ITSPAlgorithm) new TSPGeneticAlgorithm(g);
		
			
		List<TSPPath> bestPathList;
		Iterator it;
		
		System.out.printf("Coursera Assignment 5 TSP algorithm comparision results:\n");
		System.out.printf("----------------------------------------------------\n\n");
		
		
		
		tspBruteForce.getGraph().printGraph();

		System.out.printf("The Best Routes Found By Brute Force:\n");
		bestPathList = tspBruteForce.getBestPathList(3);
		it = bestPathList.iterator();
		while (it.hasNext()) {
			TSPPath path = ((TSPPath)it.next());
			path.printPathStartingFrom(0);
		}
		System.out.println("");
		
		// Select the best XXX routes from a randomly generated sample pool
		System.out.printf("The Best Routes Found (Approximation By Random Selection and Ranking):\n");
		// System.out.printf("Sample Size: %d\n", tspRandomSelection.getSampleSize());
		bestPathList = tspRandomSelection.getBestPathList(3);
		it = bestPathList.iterator();
		while (it.hasNext()) {
			TSPPath path = ((TSPPath)it.next());
			path.printPathStartingFrom(0);
		}
		System.out.println("");
		
		// Select the best XXX routes by Nearest Neighbor
		System.out.printf("The Best Routes Found (Approximation By Nearest Neighbor):\n");
		bestPathList = tspNearestNeighbor.getBestPathList(3);
		it = bestPathList.iterator();
		while (it.hasNext()) {
			TSPPath path = ((TSPPath)it.next());
			path.printPathStartingFrom(0);
		}
		System.out.println("");
		
		// Select the best XXX routes by Genetic Algorithm
		System.out.printf("The Best Routes Found (Approximation By Genetic Algorithm):\n");
		// System.out.printf("Population Size: %d\n", tspGeneticAlgorithm.getPopSize());
		bestPathList = tspGeneticAlgorithm.getBestPathList(3);
		it = bestPathList.iterator();
		while (it.hasNext()) {
			TSPPath path = ((TSPPath)it.next());
			path.printPathStartingFrom(0);
		}
		System.out.println("");
		
	}

}

