package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Garage {

	private int maxCapacity = 0;

<<<<<<< HEAD
	Map<Integer, Vehicle> vehicles;

	public Garage() {
		
	}
=======
	List<Vehicle> vehicles;
	
	//TODO add-method
>>>>>>> 60de11e88b2088a71de2f7f6702fdd64ef34ac61
	
	public void listAllParkedVehicles() {
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
	}

	public void listAllCurrentlyParkedTypes() {
		int cars = 0;
		int boats = 0;
		int aeroplanes = 0;
		int buses = 0;
		int motorcykles = 0;
		for (Map.Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
			if((vehicle.getValue().instanceOf(Car)) {
				cars++;
			}
		}
	}

	public void parkVehicle(Vehicle vehicle) {
		if(! vehicles.containsValue(vehicle) ) {
			vehicles.put(nextKey++, vehicle);
		}
		else {
			System.out.println("The vehicle is already parked in the garage.");
		}
	}

	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}

	public Vehicle findVehicle(Vehicle vehicle, VehicleType vehicleType) {
		return null;
	}
	
}
