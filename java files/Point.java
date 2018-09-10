import java.awt.Color;

public class Point extends Shape {
	private double  x;
	private double  y;
	
	public Point() {
		this.x = x;
		this.y = y;
	}
	
	public Point(double d, double e) {
		// TODO Auto-generated constructor stub
	}

	public double  getX() {
		return x;
	}
	
	public double  getY() {
		return y;
	}
	
	public void setX(double  value) {
		x = value;
	}
	
	public void setY(double  value) {
		y = value;
	}
	
	public void setPosition(double  xValue, double  yValue) {
		x = xValue;
		y = yValue;
	}
		
	public String toString() {
		String descriptionOfPoint = "Point (" + x + "," + y + ")";
		return descriptionOfPoint;
	}
	
	public double  distance(double  xValue, double  yValue) {
		double  distanceValue = (double)Math.sqrt((x - xValue)* (x - xValue) + (y - yValue) * (y - yValue));
		return distanceValue;
	}

	public Color getStrokeColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public float getStrokeWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Color getFillColor() {
		// TODO Auto-generated method stub
		return null;
	}
}


