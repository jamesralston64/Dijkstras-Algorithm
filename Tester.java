package project;

import project.WeightedGraph.Vertex;

public class Tester {

	public static void main(String[] args) {
		DijkstrasAlgorithm dijkstra = new DijkstrasAlgorithm();
		WeightedGraph G = new WeightedGraph(9);
		
		G.addEdge(1, 2, 9);
		G.addEdge(1,  6,  14);
		G.addEdge(1,  7,  15);
		G.addEdge(2, 3, 24);
		G.addEdge(6, 3, 18);
		G.addEdge(6, 5, 30);
		G.addEdge(6, 7, 5);
		G.addEdge(5,  7, 20);
		G.addEdge(3, 5, 2);
		G.addEdge(3, 4, 6);
		G.addEdge(4, 5, 11);
		G.addEdge(5, 8, 16);
		G.addEdge(4, 8, 8);
		G.addEdge(3, 8, 19);
		G.addEdge(7, 8, 44);
		
		dijkstra.findShortestPath(G.getVertex(1));
		
		int i = 0;
		for(Vertex V : G.getVertices()){
			if(i == 0){
				i++;
				continue;
			}
			System.out.print("Vertex 1 to Vertex " + V + " ");
			
// 			for(Vertex vertPath : V.shortestPath){
// 				System.out.print("" + vertPath + "->");
// 			}//end for
			
		   for(int j = 0; j < V.shortestPath.size(); j++){
         if(j != 0)
         {
            if(V.shortestPath.get(j).equals(V.shortestPath.get(j-1))){
               j++;
            }
         }
         if(j != V.shortestPath.size() - 1){
				System.out.print("" + V.shortestPath.get(j).toString() + "->");
         }
         else{
        	 System.out.print("" + V.shortestPath.get(j).toString());
         }
			}//end for
			
			System.out.println(",   length " + V.minimumDist);
			
			++i;
		}//end for
		
	}

}
