
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
	private int V;
	private int E;
	private static Vertex[] vertices;
	private static int from;
	private static int to;
	
	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(new File("/Users/saimanasa/eclipse-workspace/ShortestPath/input6.txt"));
		} catch (FileNotFoundException e) {}
		
		Graph test = new Graph(input);
		System.out.println(distance(0, 5));
	}
	
	@SuppressWarnings("static-access")
	public Graph(Scanner input) {
		this.V = input.nextInt();
		this.E = input.nextInt();
		this.vertices = new Vertex[V];
		
		for (int i = 0; i < V; i++) {
			int ID = input.nextInt();
			int x = input.nextInt();
			int y = input.nextInt();
			vertices[ID] = new Vertex(ID, x, y);
		}
		
		for (int i = 0; i < E; i++) {
			from = input.nextInt();
			to = input.nextInt();
			vertices[from].getEdges().add(to);
			vertices[to].getEdges().add(from);
		}
	}
	
	public static double distance(int from, int to) {
		return vertices[from].distanceTo(vertices[to]);
	}
	
	public Vertex[] getVertices() {
		return vertices;
	}
}