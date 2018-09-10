import java.awt.Color;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Window;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Main
{
	  public static void main(String[] args) throws FileNotFoundException {

	   // path to the cities data
	   String FILE_PATH = "D:/sneti/java_4/data.txt";
	   // read data from file into array of strings (one line per array cell)
	   String[] filedata1 = null;
	   try {
		 
		   filedata1 = InputStringReader.readFileAsArray(FILE_PATH);

		for (String s: filedata1)
			System.out.println(s);
		//assigning the input file to a variable
		
		//creating object for city
		City[] city =new City[filedata1.length];
		City cityF[] = new City[filedata1.length];
		cityF = city;
		
		// loop through array of city data
		for(int i1 = 0; i1 < filedata1.length; i1++) 
		{
		// split entries
		String[] cityData = filedata1[i1].split(",");
		String cityName = cityData[0];
		String[] gt = cityData[1].split(" ");
		Point cityLocation = new Point();
		cityLocation.setX(Double.parseDouble(gt[1]));
		cityLocation.setY(Double.parseDouble(gt[0]));
		System.out.println(cityLocation);
		
		//convert String value to double
		double cityArea = Double.parseDouble(cityData[2]);
		double cityPop = Double.parseDouble(cityData[3]);
		double cityPopDen = Double.parseDouble(cityData[4]);
		double cityForeignResi = Double.parseDouble(cityData[5]);
		double cityGDP = Double.parseDouble(cityData[6]);
		//set values using city array
		city[i1] = new City();
		city[i1].setCityName(cityName);
		city[i1].setCityLocation(cityLocation);
		city[i1].setCityArea(cityArea);
		city[i1].setCityPop(cityPop);
		city[i1].setCityPopDen(cityPopDen);
		city[i1].setCityForeignResi(cityForeignResi);
		city[i1].setCityGDP(cityGDP);
		}
		//creating object that contains the city attributes
		for(City c : city) 
		{
			//printing the values
			System.out.print(c.getCityName()+"\t");
			System.out.print(c.getCityLocation().getX()+"\t"+c.getCityLocation().getY()+"\t");
			System.out.print(c.getCityArea()+"\t");
			System.out.print(c.getCityPop()+"\t");
			System.out.print(c.getCityPopDen()+"\t");
			System.out.print(c.getCityForeignResi()+"\t");
			System.out.println(c.getCityGDP());
		}		
				//calling bounding box
				Rectangle recBbox = Bbox(cityF);
				//calling scale function
				Point BboxCnt = scale(cityF, recBbox);
				//setting the frame size to fit all the points
				SimpleFrame frame = new SimpleFrame(1500,2000);	
				//calling translation
				translate(cityF, BboxCnt);
				//draw a separator line
//		        separateFrame(cityF,frame);
		        
		        //plot city with names in the simple cartesian panel
		        
		        //Label
		        Label lbl[] = new Label[filedata1.length];
		        
				for(int i = 0; i<city.length; i++) 
				{
				frame.addToPlot(city[i].getCityLocation());
				lbl[i] = new Label();
				lbl[i].setText((i+1)+". "+city[i].getCityName());  //to visualize the city names
				lbl[i].setPosition(city[i].getCityLocation());	  // positioning the city coordinates or points
				lbl[i].setStrokeColor(Color.black);
				frame.addToPlot(lbl[i]);		//plotting the city points
				
				//creating circular buffer for points
				Circle Buffer[] = new Circle[city.length];

				for (int i1=0;i1<city.length;i1++)
				{
					Buffer[i1] = new Circle();
					Buffer[i1].setDiameter(city[i1].getCityArea()*0.1);	//setting diameter by dividing 1/10 and multiplying with getCityArea
					Buffer[i1].setStrokeWidth(2);
					//Buffer[i1].setStrokeColor(Color.green);
					Point pt = new Point();
					pt.setX(city[i1].getCityLocation().getX()-(Buffer[i1].getDiameter()/2));
					pt.setY(city[i1].getCityLocation().getY()-(Buffer[i1].getDiameter()/2));
					Buffer[i1].setTopLeftPoint(pt);
					//saturation
					float PopDen = (float) (city[i1].getCityPop()/city[i1].getCityArea()); 
					Buffer[i1].setFillColor(Color.getHSBColor(0.5f, PopDen, 1.0f));
					Buffer[i1].setStrokeColor(Color.red);
					frame.addToPlot(Buffer[i1]);
				}
					frame.drawAllFeature();
			}
	   }
			catch (IOException e) {
			e.printStackTrace();
	   			}
}
	  //Bounding BOx for points
	  public static Rectangle Bbox(City cityDif[])
		{
			Rectangle bBox = new Rectangle();
			Point pt = new Point();
			int nindex = 0, eindex = 0, sindex = 0, windex = 0;	//store iteration 
			//setting max values for north and west to calculate box
			double north = 1000, east = 0,  south = 0, west = 1000;

			for (int i=0;i<cityDif.length;i++)
			{
				if(north > cityDif[i].getCityLocation().getY())
				{
					north = cityDif[i].getCityLocation().getY();
					nindex = i;
				}
				if(east < cityDif[i].getCityLocation().getX())
				{
					east = cityDif[i].getCityLocation().getX();
					eindex = i;
				}
				if(south < cityDif[i].getCityLocation().getY())
				{
					south = cityDif[i].getCityLocation().getY();
	  			sindex = i;
				}
				if(west > cityDif[i].getCityLocation().getX())
				{
					west = cityDif[i].getCityLocation().getX();
					windex = i;
				}
			}
			System.out.println("The northmost point"+ cityDif[nindex].getCityName()+" "+cityDif[nindex].getCityLocation().getX()+","+cityDif[nindex].getCityLocation().getY());
			System.out.println("The eastmost point"+ cityDif[eindex].getCityName()+" "+cityDif[eindex].getCityLocation().getX()+","+cityDif[eindex].getCityLocation().getY());
			System.out.println("The southmost point"+ cityDif[sindex].getCityName()+" "+cityDif[sindex].getCityLocation().getX()+","+cityDif[sindex].getCityLocation().getY());
			System.out.println("The westmost point"+ cityDif[windex].getCityName()+" "+cityDif[windex].getCityLocation().getX()+","+cityDif[windex].getCityLocation().getY());

			//setting top-left point for the bounding box
			pt.setX(cityDif[windex].getCityLocation().getX());
			pt.setY(cityDif[nindex].getCityLocation().getY());
			double tlpX = cityDif[windex].getCityLocation().getX();
			double tlpY = cityDif[nindex].getCityLocation().getY();
			System.out.println("TopLeftPoint is "+tlpX+","+tlpY);
			bBox.setTopLeftPoint(pt);
			
			//width
			double w = Math.abs(cityDif[eindex].getCityLocation().getX() - cityDif[windex].getCityLocation().getX());
			bBox.setWidth(w);
			System.out.println("Width is "+w);
			//height
			double h = Math.abs(cityDif[nindex].getCityLocation().getX() - cityDif[sindex].getCityLocation().getX());
			bBox.setHeight(h);
			System.out.println("Height "+h);
			
			return bBox;
	  		}

		public static Point scale(City cityDif[],Rectangle BBox) {
		//calculate scale
			//scale together for X and Y
				double scale = 500/Math.max(BBox.getWidth(), BBox.getHeight());	//used 500 to include all my cityLocation points
				System.out.println("Scale :" + scale);
				for(int i=0;i<cityDif.length;i++)
				{
					
					Point cityCoordinates = new Point();
					//multiplying scale value to X and Y values of CityLocation
					cityCoordinates.setX(cityDif[i].getCityLocation().getX()*scale);
					cityCoordinates.setY(cityDif[i].getCityLocation().getY()*scale);
					cityDif[i].setCityLocation(cityCoordinates);
					System.out.print(" " + cityDif[i].getCityName());
					System.out.println(" " + cityDif[i].getCityLocation().getX() + " " + cityDif[i].getCityLocation().getY());
				}
				
//				//scale separately for X and Y
//				double scaleX = 500 / BBox.getWidth();
//				double scaleY = 500 / BBox.getHeight();
//				System.out.println("ScaleX - " + scaleX + "...ScaleY - " + scaleY);
//				for(int i=0;i<cityDif.length;i++)
//				{	
//					Point cityCoordinates1 = new Point();
//					//multiplying scale value to X and Y values of CityLocation
//					cityCoordinates1.setX(cityDif[i].getCityLocation().getX()*scaleY);
//					cityCoordinates1.setY(cityDif[i].getCityLocation().getY()*scaleX);
//					cityDif[i].setCityLocation(cityCoordinates1);
//					System.out.print(" " + cityDif[i].getCityName());
//					System.out.println(" " + cityDif[i].getCityLocation().getX() + " " + cityDif[i].getCityLocation().getY());
//				}
				
				//center bounding box
				Point BboxCnt = new Point();		
				BboxCnt = BBox.centroid();
				System.out.println("BBOX center:" + BboxCnt.getX()+ " " + BboxCnt.getY());
				//set X and Y center using Width and Height
				BboxCnt.setX(BBox.getTopLeftPoint().getX()+BBox.getWidth()/2);
				BboxCnt.setY(BBox.getTopLeftPoint().getY()+BBox.getHeight()/2);
				System.out.println("BBOX center:" + BboxCnt.getX()+ " " + BboxCnt.getY());
				
				//Set X and Y according to scale
				BboxCnt.setX(BboxCnt.getX() * scale);
				BboxCnt.setY(BboxCnt.getY() * scale);
				System.out.println("BBOX center scaling:" + BboxCnt.getX()+ " " + BboxCnt.getY());
				
				return BboxCnt;
				}
		//translation 
		public static void translate(City cityDif[], Point BboxCnt)
		{
			double xTranslation = 600-BboxCnt.getX(); //used 600 according to display 
			double yTranslation = 700-BboxCnt.getY();	//used 700 according to display
			//printing xTranslation and yTranslation
			System.out.println("xTranslation: "+ xTranslation + "yTranslation: "+ yTranslation);
			
			for(int i=0;i<cityDif.length;i++)
			{			
				Point cityCoordinates = new Point(); //new object to store
				System.out.print("translation.. " + cityDif[i].getCityName());
				//adding the translation to the existing coordinates
				cityCoordinates.setX(cityDif[i].getCityLocation().getX()+xTranslation);
				//included the flip our map around the horizontal centerline along with the yTranslation
				cityCoordinates.setY(900-(cityDif[i].getCityLocation().getY()+yTranslation));
				
				cityDif[i].setCityLocation(cityCoordinates);	//setting the values
				System.out.println(" " + cityDif[i].getCityLocation().getX() + " " + cityDif[i].getCityLocation().getY()); //print
			}
		}
		//Draw a line after the far end cityLocations
//		public static void separateFrame(City cityDif[], SimpleFrame varFrame)
//		{
//			double maxLong = 0;
//			//find the max longitude value/east-most coordinate
//			for (int i = 0;i<cityDif.length;i++)
//			{
//				if(maxLong < cityDif[i].getCityLocation().getX())
//				{
//					maxLong = cityDif[i].getCityLocation().getX();
//				}
//			}
//			System.out.println("minLong - " + maxLong);
//			
//			//plot separation line
//			Polyline sepLine = new Polyline();
//			sepLine.setNumPoints(2);
//			Point seppt[] = new Point[2];
//			
//			seppt[0] = new Point();
//			seppt[0].setX(maxLong+70); //values <70 intersects with the cityLocation
//			seppt[0].setY(0);	//initial Y point
//
//			seppt[1] = new Point();
//			seppt[1].setX(maxLong+70);
//			seppt[1].setY(2000);	//simple frame Y value 
//			
//			sepLine.setPoints(seppt);
//			sepLine.setStrokeColor(Color.blue);
//			sepLine.setStrokeWidth(2);
//			varFrame.addToPlot(sepLine);
//			
//		}
}