public class Rectangle extends Shape {
	private Point topleftpoint;
	private double width;
	private double height;

public double getWidth() {
	return width;
}
public double getHeight() {
	return height;
}
public Point getTopLeftPoint(){
	return topleftpoint;
}
public void setWidth(double value) {
	width = value;
}
public void setHeight(double value) {
	height = value;
}
public void setTopLeftPoint(Point value) {
	topleftpoint = value;
}
 
public double calculateArea() {
	double area = width * height;
	 return area;
	 }
public double calculatePeri() {
	double perimeter = 2*(width + height);
	 return perimeter;
	 }
public boolean contains(Point pt) {

		int x1 = (int)pt.getX();
		int y1 = (int)pt.getY();	
		boolean found = false;
			if (topleftpoint.getX() > x1 && topleftpoint.getX() < (x1 + width) && topleftpoint.getY() > y1 && (topleftpoint.getY() < y1 + height))
				{
				System.out.println("random point is inside rectangle!    (" + x1 + "," + y1 + ")");
				found = true;
				}
			else {
				System.out.println("random point is not inside rectangle!    (" + x1 + "," + y1 + ")");
				found = false;
				}
			return found;
		}

		public Point centroid() {
		double cx=0,cy=0;
		Point pt = new Point(cx,cy);
		cx=topleftpoint.getX()+(height/2);
		cy=topleftpoint.getY()+(width/2);
		System.out.println("centroid is:("+cx+","+cy+")");
		pt.setX(cx);
		pt.setY(cy);
		return pt;
		}
}

