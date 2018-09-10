import java.awt.Color;
public class Shape {
	private float strokeWidth;
	private Color strokeColor;
	private Color fillColor;
	private float transparency;
	
public float getStrokeWidth() {
	return strokeWidth;
}
public Color getStrokeColor(){
	return strokeColor;
}
public Color getFillColor(){
	return fillColor;
}
public float getTransparency(){
	return transparency;
}
public void setStrokeWidth(float value) {
	strokeWidth = value;
}
public void setStrokeColor(Color value) {
	strokeColor = value;
}
public void setFillColor(Color value) {
	fillColor = value;
}
public float setTransparency(float value){
	return transparency;
}
}

