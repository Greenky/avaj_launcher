package avaj.vehicles;

import avaj.simulator.WeatherTower;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Baloon extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void registerTower(WeatherTower weatherTower, Writer writer) throws IOException{
		this.weatherTower = weatherTower;
		writer.append("Baloon#"+ name + "(" + id +") registered to weather tower.\n");
	}

	@Override
	public void updateConditions() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", true));
		String weather = weatherTower.getWeather(coordinates);
		writer.append("Baloon#"+ name + "(" + id +"): ");
		switch (weather) {
			case "RAIN":
				this.coordinates.addHeight(-5);
				writer.append("On no, where my umbrella?\n");
				break;
			case "FOG":
				this.coordinates.addHeight(-3);
				writer.append("How we land now, I can't see a thing..... WE ALL DIE!!!\n");
				break;
			case "SUN" :
				this.coordinates.addLongitude(2);
				this.coordinates.addHeight(4);
				writer.append("So good weather, time to do selfie!\n");
				break;
			case "SNOW":

				this.coordinates.addHeight(-15);
				writer.append("WHO'S IDEA WAS TO FLY ON A BALOON IN SNOW?\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			writer.append("Baloon#" + name + "(" + id + ") landing on coordinates (" +
					this.coordinates.getLatitude() + " "+ this.coordinates.getLongitude() + ").\n");
			weatherTower.unregister(this);
			writer.append("Tower says: Baloon#"+ name + "(" + id +") unregistered from weather tower.\n");
		}
		writer.close();
	}

}
