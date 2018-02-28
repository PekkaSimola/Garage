package models;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	private int maxCapacity = 0;

	List<Vehicle> vehicles;
	
	//TODO add-method
	
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
		if(!.v.parked()) {
			v.parkVehicle();
		}
	}

	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}

	public Vehicle findVehicle(Vehicle vehicle, VehicleType vehicleType) {
		return null;
	}

}
