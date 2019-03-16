package avaj.vehicles;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height){
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	Coordinates(Coordinates coordinates){
		this.longitude = coordinates.getLongitude();
		this.latitude = coordinates.getLatitude();
		this.height = coordinates.getHeight();
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}

	public void addLongitude(int longitude) {
		this.longitude += longitude;
	}

	public void addLatitude(int latitude) {
		this.latitude += latitude;
	}

	public void addHeight(int height) {
		this.height += height;
		if (this.height > 100)
			this.height = 100;
	}

}
