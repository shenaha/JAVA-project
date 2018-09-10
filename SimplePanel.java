import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class SimplePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingContent content;
	public SimplePanel() {
		super();
		content = new DrawingContent();
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		this.setBackground(Color.WHITE);
		/* Change the drawer and their attributes */
		Graphics2D g2d = ( Graphics2D )g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
		

		
		/* DRAW CIRCLES */
		for(Circle c:content.getCircles()){
			g2d.setColor( c.getStrokeColor());
			
			g2d.setStroke(new BasicStroke((float)c.getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			Ellipse2D.Double shape = new Ellipse2D.Double(c.getTopLeftPoint().getX() ,c.getTopLeftPoint().getY(), c.getDiameter(), c.getDiameter() );
		    g2d.draw(shape);
		    
		    g2d.setColor( c.getFillColor());
		    g2d.fill(shape);
			
		}
		
		/* DRAW REctangles */
		for(Rectangle r: content.getRectangles()){
			g2d.setColor( r.getStrokeColor());
			
			g2d.setStroke(new BasicStroke((float)r.getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			Rectangle2D.Double shape = new Rectangle2D.Double(r.getTopLeftPoint().getX(), r.getTopLeftPoint().getY(), r.getWidth(), r.getWidth());		  
			g2d.draw(shape);
		    
		    g2d.setColor( r.getFillColor());
		    g2d.fill(shape);
			
		}
		/* DRAW POLYGONS */
		for(Polygon p: content.getPolygons()){
			g2d.setColor( p.getStrokeColor());
			
			Path2D.Double path = new Path2D.Double();
			path.moveTo(p.getPoints()[0].getX(), p.getPoints()[0].getY());

			for(int i = 0; i < p.getNumPoints(); i ++){

				path.lineTo(p.getPoints()[i].getX(), p.getPoints()[i].getY());			
			}
			g2d.draw(path);
			

		    g2d.setColor( p.getFillColor());
		    g2d.fill(path);
			
		}
		/* DRAW POLYLINES */
		for(Polyline p: content.getPolylines()){
			g2d.setColor( p.getStrokeColor());
			
			Path2D.Double path = new Path2D.Double();
			path.moveTo(p.getPoints()[0].getX(), p.getPoints()[0].getY());

			for(int i = 0; i < p.getNumPoints(); i ++){

				path.lineTo(p.getPoints()[i].getX(), p.getPoints()[i].getY());			
			}
			g2d.draw(path);
			
			
		}
		/* DRAW POINTS */
		for(Point p:content.getPoints()){
			g2d.setColor( p.getStrokeColor());
			
			g2d.setStroke(new BasicStroke((float)p.getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			Ellipse2D.Double shape = new Ellipse2D.Double(p.getX() ,p.getY(), 5.0, 5.0 );
		    g2d.draw(shape);
		    
		    g2d.setColor( p.getFillColor());
		    g2d.fill(shape);
			
		}
		/* DRAW LABELS */
		for(Label l: content.getLabels()){
			g2d.setColor( l.getStrokeColor());
			g2d.drawString(l.getText(), Math.round(l.getPosition().getX()) , Math.round(l.getPosition().getY()) );
		}
		
	}


	public DrawingContent getContent() {
		return content;
	}


	public void setContent(DrawingContent content) {
		this.content = content;
	}

	
	
}