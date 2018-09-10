public class City {
	
	private String cityName;
	private Point  cityLocation;
	private double cityArea;
	private double cityPop;
	private double cityPopDen;
	private double cityForeignResi;
	private double cityGDP;
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityLocation(Point cityLocation) {
		this.cityLocation = cityLocation;
		cityLocation.setStrokeWidth(1/2);
		//this.cityLocation.setX(x);
		//this.cityLocation.setY(y);
	}
	 public Point getCityLocation() {
			return this.cityLocation;
	}
	public void setCityArea(double cityArea) {
		this.cityArea = cityArea;
	}
	public double getCityArea() {
		return cityArea;
	}

	public void setCityPop(double cityPop) {
		this.cityPop = cityPop;
	}
	public double getCityPop() {
		return cityPop;
	}

	public void setCityPopDen(double cityPopDen) {
		this.cityPopDen = cityPopDen;
	}
	public double getCityPopDen() {
		return cityPopDen;
	}

	public void setCityForeignResi(double cityForeignResi) {
		this.cityForeignResi = cityForeignResi;
	}
	public double getCityForeignResi() {
		return cityForeignResi;
	}

	public void setCityGDP(double cityGDP) {
		this.cityGDP = cityGDP;
	}
	public double getCityGDP() {
		return cityGDP;
	}
}
