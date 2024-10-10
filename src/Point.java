//memorizza le informazioni di un punto
public class Point {
	
	private int animal;
	private int id;
	private String date;
	private double x;
	private double y;
	private int clusterLbl;
	private boolean visited;
	
	public Point(String row) {
		String[] rowSplit = row.split(",");

		animal = Integer.parseInt(rowSplit[0]);
		id = Integer.parseInt(rowSplit[1]);
		date = rowSplit[2];
		x = Double.parseDouble(rowSplit[3]);
		y = Double.parseDouble(rowSplit[4]);
		clusterLbl = 0;
		visited = false;
	}

	public int getAnimal() {
		return animal;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getClusterLbl() {
		return clusterLbl;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setClusterLbl(int clusterLbl) {
		this.clusterLbl = clusterLbl;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public String toString() {
		return (animal+","+id+","+date+","+x+","+y+","+clusterLbl);
	}
}