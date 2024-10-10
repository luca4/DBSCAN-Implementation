import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Epsilon
		double eps = 300;

		int minPoints = 20;
		FileManager f = new FileManager();

		// Get points from input file
		ArrayList<Point> points = f.readDataset();

		ArrayList<Point> clustered = runDbScan(points, eps, minPoints);

		// Write resulting data to output file
		f.writeDataset(clustered);
	}
	
	private static ArrayList<Point> runDbScan(ArrayList<Point> points, double eps, int minPoints) {
		int clusterLabel = 0;
		for(int i=0; i<points.size(); i++) {
			Point point = points.get(i);

			// Skip point if already read
			if(point.isVisited())
				continue;

			// Set point as visited
			point.setVisited(true);
			
			ArrayList<Point> neighbors = getNeighbors(points, point, eps);
			// Flag point as "noise" if numberOfNeighbors < minPoints
			if(neighbors.size() < minPoints)
				point.setClusterLbl(0);
			else {
				// New cluster
				clusterLabel += 1;
				clusterGrow(points, point, neighbors, clusterLabel, eps, minPoints);
			}
		}
		return points;		
	}
	
	// Check for every neighbor point and populate the cluster
	private static void clusterGrow(ArrayList<Point> points, Point point, ArrayList<Point> neighbors,
			int clusterLbl, double eps, int minPoints) {
		point.setClusterLbl(clusterLbl);

		// For every point check if has a sufficient number of neighbors. Create FIFO data structure
		for(int i=0; i<neighbors.size(); i++) {
			Point neighPoint = neighbors.get(i);
			if(!neighPoint.isVisited())
			{
				neighPoint.setVisited(true);
				ArrayList<Point> neighborsP = getNeighbors(points, neighPoint, eps);

				// If point has sufficient neighbors, add neighbors to points to check
				if(neighborsP.size() >= minPoints)
					neighbors.addAll(neighborsP);

				// If point is not in a cluster, add to actual cluster
				if(neighPoint.getClusterLbl() == 0)
					neighPoint.setClusterLbl(clusterLbl);
			}
		}
	}
	
	// Search for points that are within "esp" distance from q
	private static ArrayList<Point> getNeighbors(ArrayList<Point> points, Point q, double eps) {
		ArrayList<Point> neighbors = new ArrayList<>();
		for(Point p : points) {
			if(getDistance(q, p) <= eps)
				neighbors.add(p);
		}
		return neighbors;
	}
	
	// Euclidean distance between two points
	private static double getDistance(Point p1, Point p2) {
		double deltaX = Math.abs(p1.getX() - p2.getX());
		double deltaY = Math.abs(p1.getY() - p2.getY());
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}
}