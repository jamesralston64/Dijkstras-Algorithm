package project;
import java.util.*;

public class WeightedGraph {
	
	public class Vertex implements Comparable<Vertex>{
		
		public ArrayList<Edge> adj;//adj[i] stores all edges connecting to vertex i
		public LinkedList<Vertex> shortestPath;
		public double minimumDist = Double.POSITIVE_INFINITY; //sets all other distances to infinity
		public Vertex last;
		public int value;
		
		public Vertex(int value){
			this.value = value;
			adj = new ArrayList<Edge>();
			shortestPath = new LinkedList<Vertex>();
		}//end Vertex
		
		@Override
		public int compareTo(Vertex that) {
			int res;
			res = (int) (this.minimumDist - that.minimumDist);
			return 0;
		}//end compareTo
		
		public String toString(){
			return Integer.toString(value);
		}//end toString

	}//end innerVertex class
	
	public class Edge{
		public Vertex dest;
		public final double weight;
		
		public Edge(Vertex dest, double weight){
			this.dest = dest;
			this.weight = weight;
		}//end Edge ctor
		
	}//end inner class Edge
	
	private List<Vertex> verts;
	
	public WeightedGraph(int V){
		verts = new ArrayList<Vertex>(V);
		for(int v = 0; v < V; v++){
			verts.add(new Vertex(v));
		}//end for
	}//end weightedGraph ctor
	
	public void addEdge(int curr, int dest, int weight){
		Vertex src = verts.get(curr);
		Edge temp = new Edge(verts.get(dest), weight);
		src.adj.add(temp);
	}//end addEdge
	
	public Vertex getVertex(int vertex){
		return verts.get(vertex);
	}//end getVertex
	
	public ArrayList<Vertex> getVertices(){
		return (ArrayList<Vertex>) verts;
	}//end getVertices

}//end WeightedGraph class

