package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Garage {

	private int maxCapacity = 50;
	int cars = 0;
	int boats = 0;
	int aircrafts = 0;
	int buses = 0;
	int motorcycles = 0;
	int parkinglot = 0;
	
	Map<Integer, Vehicle> vehicles;

	public Garage() {
		vehicles = new HashMap<Integer, Vehicle>(1);
	}
	
	public void listAllParkedVehicles() {
		for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
			System.out.println(vehicle.getValue().toString());
		}
	}
	
	public void listAll() {
		System.out.println("Antal fordon parkerade av respektive typ:"
				+ "\n" + cars + " bilar, "
				+ "\n" + boats + " båtar, "
				+ "\n" + aircrafts + "flygplan, "
				+ "\n" + buses + "bussar och"
				+ "\n" + motorcycles + "motorcyklar.");
	}
	
	public void parkVehicle(Vehicle vehicle) {
		if( vehicles.size()<maxCapacity) {
			if(! vehicles.containsValue(vehicle) ) {
				vehicles.put(++parkinglot, vehicle);
				System.out.println("Din bil har parkerats på plats " + "parkinglot");
			}
			else {
				System.out.println("The vehicle is already parked in the garage.");
			}
		}else {
			System.out.println("Garaget har nått sin maxkapacitet på " + maxCapacity + ".");
		}
	}

	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}

	public Vehicle findVehicle(int parkinglot){
			return vehicles.get(parkinglot);	
	}
	
	public List<Vehicle> findByProperty(int choice, String query) {
		List<Vehicle> result = new ArrayList();
		
		switch(choice) {
		case 1:
			for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
				if(vehicle.getValue().getRegNr() == Integer.parseInt(query)) {
					result.add(vehicle.getValue());
				}
			}
			break;
		case 2:
			
			query = query.toLowerCase();

			Vehicle temp;
			
			switch(query) {
			
			case("car"):
				temp = (Car)temp;
				break;
			case("boat"):
				temp = (Boat)temp;
				break;
			case("aircraft"):
				temp = (Aircraft);
				break;
			case("bus"):
				temp = (Bus)temp;
			case("motorcycle"):
				temp = (Motorcycle)temp;
				break;
			
			default:
				break;
			}
			for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
				if(vehicle.getValue().instanceOf(temp)) {
					result.add(vehicle.getValue());
				}//if
			}//for
				
				
		}//switch
	}
	
}
