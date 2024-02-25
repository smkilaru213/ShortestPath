
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
	private int ID;
	private Point point;
	private List<Integer> edges;
	private boolean visited;
	private double dist;
	private Vertex prev;
	
	public Vertex(int ID, int x, int y) {
		this.ID = ID;
		this.point = new Point(x, y);
		this.edges = new ArrayList<>();
		this.visited = false;
		this.dist = Double.POSITIVE_INFINITY;
		this.prev = null;
	}
	
	public int getID() {
		return ID;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public List<Integer> getEdges() {
		return edges;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public Vertex getPrevious() {
		return this.prev;
	}
	
	public void setPrevious(Vertex previous) {
		this.prev = previous;
	}
	
	public void setDistance(double distance) {
		this.dist = distance;
	}
	
	public double getDistance() {
		return dist;
	}

	public double distanceTo(Vertex other) {
		int x = this.point.x = other.getPoint().x;
		int y = this.point.y = other.getPoint().y;
		return Math.sqrt(x * x + y * y);
	}
	
	@Override
	public int compareTo(Vertex other) {
		return Double.compare(this.dist, other.getDistance());
	}
}