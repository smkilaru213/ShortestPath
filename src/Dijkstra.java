
import java.util.PriorityQueue;

public class Dijkstra {
	private Graph graph;
	
	public Dijkstra(Graph graph) {
		this.graph = graph;
	}
	
	public double distance(int source, int destination) {
		dijsktra(source, destination);
		return graph.getVertices()[destination].getDistance();
	}
	
	private void dijsktra(int source, int destination) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		graph.getVertices()[source].setDistance(0);
		pq.add(graph.getVertices()[source]);
		while (pq.isEmpty() == false) {
			Vertex x = pq.poll();
			if (x.isVisited()) {
				continue;
			}
			x.setVisited(true);
			if (x.getID() == destination) {
				return;
			}
			for (int id : x.getEdges()) {
				Vertex next = graph.getVertices()[id];
				if (next.isVisited() == false) {
					double dist = x.getDistance() + graph.distance(x.getID(), id);
					if (dist < next.getDistance()) {
						next.setDistance(dist);
						next.setPrevious(x);
						pq.add(next);
					}
				}
			}
		}
	}
}
