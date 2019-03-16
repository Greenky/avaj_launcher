package avaj.vehicles;

import avaj.simulator.WeatherTower;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void registerTower(WeatherTower weatherTower, Writer writer) throws IOException{
		this.weatherTower = weatherTower;
		writer.append("JetPlane#"+ name + "(" + id +") registered to weather tower.\n");
	}

	@Override
	public void updateConditions() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", true));
		String weather = weatherTower.getWeather(coordinates);
		writer.append("JetPlane#"+ name + "(" + id +"): ");
		switch (weather) {
			case "SUN" :
				this.coordinates.addLatitude(10);
				this.coordinates.addHeight(2);
				writer.append("Sun is shining, flight is good.\n");
				break;
			case "RAIN":
				this.coordinates.addLatitude(5);
				writer.append("A little raining out the bort, not a problem for my plane.\n");
				break;
			case "FOG":
				this.coordinates.addLatitude(1);
				writer.append("Sight is limited, trying not to crash!\n");
				break;
			case "SNOW":
				this.coordinates.addHeight(-7);
				writer.append("Dashing through the snow... In a one-horse open sleigh...\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			writer.append("JetPlane#" + name + "(" + id + ") landing on coordinates (" +
					this.coordinates.getLatitude() + " "+ this.coordinates.getLongitude() + ").\n");
			weatherTower.unregister(this);
			writer.append("Tower says: JetPlane#"+ name + "(" + id +") unregistered from weather tower.\n");
		}
		writer.close();
	}

}
