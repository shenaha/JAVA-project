public class Polyline extends Shape {
	private Point[] points;
	private int numPoints;

	public Point[] getPoints() {
		return points;
	}
	public int getNumPoints() {
		return numPoints;
	}
	public void setPoints(Point []varPt)
	{
		points = varPt;
	}
	public void setNumPoints(int varNumPt)
	{
		numPoints = varNumPt;
	}
	public void setHeight(Point[] value) {
		points = value;
	}
	public void setTopleftpoint(int value) {
		numPoints = value;
	}
}
