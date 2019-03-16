import avaj.simulator.*;
import avaj.vehicles.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args){
		File file = new File("simulation.txt");
		file.delete();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line == null || line.isEmpty()) {
				System.out.println("Iterations count is empty");
				return ;
			}
			String[] nums = line.split(" ");
			if (nums.length == 0 || nums[0].isEmpty()) {
				System.out.println("First line is empty or contains spaces before number");
				return ;
			}
			WeatherTower weatherTower = new WeatherTower();
			int simulations = 0;
			try {
				simulations = Integer.parseInt(nums[0]);
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid iterations parameter");
				System.exit(1);
			}
			if (simulations > 0) {
				line = reader.readLine();
				while (line != null) {
					Flyable fly;
					try {
						fly = AircraftFactory.newAircraft
								(
									line.split(" ")[0],
									line.split(" ")[1],
									Integer.parseInt(line.split(" ")[2]),
									Integer.parseInt(line.split(" ")[3]),
									Integer.parseInt(line.split(" ")[4])
								);
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Not enough parameters specified in line");
						fly = null;
						System.exit(1);
					}
					catch (NumberFormatException e) {
						System.out.println("Invalid coordinate parameters");
						fly = null;
						System.exit(1);
					}
					catch (MyBoundException e) {
						System.out.println("Invalid height parameter, it must be between 0 and 100");
						fly = null;
						System.exit(1);
					}
					flyables.add(fly);
					line = reader.readLine();
				}

				for (Flyable fly: flyables){
					weatherTower.register(fly);
				}
				for(int i = 0; i < simulations; i++)
					weatherTower.changeWeather();
			}
			else {
				System.out.println("Iterations count is less than or equal 0");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + args[0]);
		} catch (IOException e) {
			System.out.println("Error while reading file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify file in parameters");
		}
		catch (NullPointerException e) {
			System.out.println("Iterations count is invalid");
		}
	}
}
