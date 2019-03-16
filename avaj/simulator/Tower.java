package avaj.simulator;
import avaj.vehicles.Flyable;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;

public class Tower{
	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) throws IOException{
		observers.add(flyable);
	}

	public void unregister(Flyable flyable)  throws IOException{
		observers.remove(flyable);
	}

	protected void conditionsChanged() throws IOException{
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}
