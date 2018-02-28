package models;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	List<Vehicle> vehicles;
	
	public void listAllParkedVehicles(){
		 for(Vehicle v: vehicles) {
			 System.out.println(v.toString());
		 }
	}
	
	public void listAllCurrentlyParkedTypes() {
		for(Vehicle v : vehicles) {
			//try to cast the vehicle to all types
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
	
	public Vehicle findVehicle() {
		return null;
	}
}
