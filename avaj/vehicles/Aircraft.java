package avaj.vehicles;

public class Aircraft {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	private static long		idCounter = 0;


	Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
	}

	private long nextId() {
		return idCounter++;
	}
}
