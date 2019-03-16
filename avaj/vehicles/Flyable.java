package avaj.vehicles;
import avaj.simulator.*;

import java.io.IOException;
import java.io.Writer;

public interface Flyable {
	long getId();
	void updateConditions() throws IOException ;
	void registerTower(WeatherTower weatherTower, Writer writer) throws IOException;
}
