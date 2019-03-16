package avaj.vehicles;
import avaj.simulator.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void registerTower(WeatherTower weatherTower, Writer writer) throws IOException {
		this.weatherTower = weatherTower;
		writer.append("Helicopter#"+ name + "(" + id +") registered to weather tower.\n");
	}

	@Override
	public void updateConditions() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", true));
		String weather = weatherTower.getWeather(coordinates);
		writer.append("Helicopter#"+ name + "(" + id +"): ");
		switch (weather) {
			case "RAIN":
				this.coordinates.addLongitude(5);
				writer.append("Raindrops flying funny near my rotor.\n");
				break;
			case "FOG":
				this.coordinates.addLongitude(1);
				writer.append("Ffffffffffog in da house.\n");
				break;
			case "SUN" :
				this.coordinates.addLongitude(10);
				this.coordinates.addHeight(2);
				writer.append("I love sunshine so much.\n");
				break;
			case "SNOW":

				this.coordinates.addHeight(-12);
				writer.append("My rotor is going to freeze! Start calling to help!\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			writer.append("Helicopter#" + name + "(" + id + ") landing on coordinates (" +
					this.coordinates.getLatitude() + " "+ this.coordinates.getLongitude() + ").\n");
			weatherTower.unregister(this);
			writer.append("Tower says: Helicopter#"+ name + "(" + id +") unregistered from weather tower.\n");
		}
		writer.close();
	}

}
