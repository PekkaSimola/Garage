package models;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	List<Vehicles> vehicles;
	
	public void listAllParkedVehicles(){
		 for(Vehicles v: vehicles) {
			 System.out.println(v.toString());
		 }
	}
	
	public void listAllCurrentlyParkedTypes() {
		for(Vehicles v : vehicles) {
			//try to cast the vehicle to all types
		}
	}
	
	public void parkVehicle(Vehicles v) {
		if(!.v.parked()) {
			v.parkVehicle();
		}
	}
	
	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}
	
	public Vehicles findVehicle() {
		return null;
	}
}