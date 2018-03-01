package models;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	private int maxCapacity = 0;

	List<Vehicle> vehicles;

	public void listAllParkedVehicles() {
		for (Vehicle v : vehicles) {
			System.out.println(v.toString());
		}
	}

	public void listAllCurrentlyParkedTypes() {
		for (Vehicle v : vehicles) {
			// try to cast the vehicle to all types
		}
	}

	public void parkVehicle(Vehicle v) {
		if(! vehicles.contains(v) ) {
			vehicles.add(v);
		}
		else {
			System.out.println("The vehicle is already parked in the garage.");
		}
	}

	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}

	public Vehicle findVehicle() {
		return null;
	}

}
