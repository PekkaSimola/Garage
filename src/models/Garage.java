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
		List<Vehicle> results = new ArrayList();
		
		switch(choice) {
		case 1:
			for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
				if(vehicle.getValue().getRegNr() == Integer.parseInt(query)) {
					results.add(vehicle.getValue());
				}
			}
			break;
			
		case 2:
			query = query.toLowerCase();

			switch(query) {
			
			case("car"):	
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Car ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("boat"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Boat ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
			
			case("aircraft"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Aircraft ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("bus"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Bus ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("motorcycle"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Motorcycle ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
			
			default:
				break;
			}//switch
			
		case 3:
			for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
				if(vehicle.getValue().getColor().equals(query)) {
					results.add(vehicle.getValue());
				}
			}
		}//switch
		return results
	}
	
}
