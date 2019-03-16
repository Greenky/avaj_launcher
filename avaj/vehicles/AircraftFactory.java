package avaj.vehicles;

public class AircraftFactory {

	static public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws MyBoundException{
		if (height > 100 || height <= 0) throw new MyBoundException("too much", height);

		Coordinates cord = new Coordinates(longitude, latitude, height);
		switch (type) {
			case "Helicopter":
				return new Helicopter(name, cord);
			case "Baloon":
				return new Baloon(name, cord);
			case "JetPlane":
				return new JetPlane(name, cord);
			default:
				System.out.println("No such vehichle as \"" + name + "\"");
				System.exit(1);
				return null;
		}
	}
}

