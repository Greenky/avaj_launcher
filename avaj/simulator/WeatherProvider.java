package avaj.simulator;
import avaj.vehicles.Coordinates;


public class WeatherProvider {
	private static WeatherProvider WeatherProvider;
	private String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

	public static WeatherProvider getProvider()
	{
		if (WeatherProvider == null)
			WeatherProvider = new WeatherProvider();
		return WeatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates, double randomNumber) {

		int alt = coordinates.getLatitude();
		int lon = coordinates.getLongitude();
		int h = coordinates.getHeight();

		return weather[((int)(alt * lon * h * randomNumber) + alt + lon + h) % 4];
	}
}
