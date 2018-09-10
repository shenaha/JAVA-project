public class Circle extends Shape {
	private Point topleftpoint;
	private double diameter;
	private Point centralPoint;
	
public double getDiameter() {
	return diameter;
}
public Point getTopLeftPoint()
	{
		return topleftpoint;
	}
public void setDiameter(double value)
	{
		diameter = value;
	}
public Point getCentralPoint()
	{
		return this.centralPoint;
	}
public void setCentalPoint(Point centalPoint)
	{
		this.centralPoint = centalPoint;
		//set the topLeftPoint
		double tempLength =0;
		tempLength = (double) (diameter/2);
		topleftpoint = new Point(centalPoint.getX()-tempLength,centalPoint.getY()-tempLength);
	}
public void setTopLeftPoint(Point value) 
	{
		topleftpoint = value;
	}
 
public double calculateArea() {
	double area =(double) 3.14 * ((diameter/2)*(diameter/2));
	 return area;
	 }
public double calculatePeri() {
	double perimeter =(double) 3.14*diameter;
	 return perimeter;
	 }
public boolean contains(Point pt) {	
	Point centroid = centroid();

	double distance =centroid.distance(pt.getX(), pt.getY());
	//float radius = diameter/2;
		boolean found = false;
			if(distance < (diameter/2)){
				System.out.println("("+pt.getX()+" , "+pt.getY()+")" +" is within the circle");
				found = true;
				}
			else if(distance >= (diameter/2)) {
				System.out.println("("+pt.getX()+" , "+pt.getY()+")" +"is outside the circle");
				found = false;
		}
			return found;
}


public Point centroid() {
double cx=0,cy=0;
Point pt = new Point(cx,cy);
cx=(double)(topleftpoint.getX()+(diameter/2));
cy=(double)(topleftpoint.getY()+(diameter/2));
pt.setX(cx);
pt.setY(cy);
System.out.println("centroid is:"+cx+","+cy+")");
return pt;
}

}



