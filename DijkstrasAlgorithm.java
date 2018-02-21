package project;

import java.util.*;

import project.WeightedGraph.Edge;
import project.WeightedGraph.Vertex;

public class DijkstrasAlgorithm {
	
	public DijkstrasAlgorithm(){
		
	}//end ctor
	
	public void findShortestPath(Vertex root){
		PriorityQueue<Vertex> vertices = new PriorityQueue<Vertex>();
		root.minimumDist = 0;
		
		vertices.add(root);
		
		while(!vertices.isEmpty()){
			Vertex temp = vertices.poll();
			
			for(Edge adjs : temp.adj){
				int dist = (int) (temp.minimumDist + adjs.weight);
				
				if(adjs.dest.minimumDist > dist){
					
					//remove from the queue to update distance
               Vertex t = adjs.dest;
					vertices.remove(adjs.dest);
					adjs.dest.minimumDist = dist;
					
					//update the current path to current vertex
					adjs.dest.shortestPath = new LinkedList<Vertex>(temp.shortestPath);
					adjs.dest.shortestPath.add(temp);
               adjs.dest.shortestPath.add(t);
					
					//add the vertex with the new distance
					//vertices.add(adjs.dest);
               vertices.add(t);
					
				}//end if
			}//end for
		}//end while
	}//end findShortestPath

}//end class

