package avaj.simulator;
import avaj.vehicles.Coordinates;
import avaj.vehicles.Flyable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WeatherTower extends Tower{
	WeatherProvider weatherProvider;
	private Random	random;
	private double randomNumber = 0;

	public WeatherTower() {
		weatherProvider = WeatherProvider.getProvider();
		random = new Random(System.currentTimeMillis());
	}

	public String getWeather(Coordinates coordinates) {
		return weatherProvider.getCurrentWeather(coordinates, randomNumber);
	}

	public void changeWeather() throws IOException{
		randomNumber = random.nextDouble();
		conditionsChanged();
	}

	@Override
	public void register(Flyable flyable) throws IOException {
		super.register(flyable);
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", true));
		writer.append("Tower says: ");
		flyable.registerTower(this, writer);
		writer.close();
	}
}
