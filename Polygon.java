public class Polygon extends Shape {
	private Point[] points;
	private int numPoints;

	public Point[] getPoints() {
		return points;
	}
	public int getNumPoints() {
		return numPoints;
	}
	public void setHeight(Point[] value) {
		points = value;
	}
	public void setTopleftpoint(int value) {
		numPoints = value;
	}
}
