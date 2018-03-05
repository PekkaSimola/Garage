package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Garage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxCapacity = 50;
	int cars = 0;
	int boats = 0;
	int aircrafts = 0;
	int buses = 0;
	int motorbikes = 0;
	int parkinglot = 0;

	Map<Integer, Vehicle> vehicles;

	public Garage() {
		vehicles = new HashMap<Integer, Vehicle>(1);
	}

	/*
	 * returns the HashMap<Integer, Vehicle> containing the Vehicles.
	 */
	public Map<Integer, Vehicle> getVehicles() {
		return vehicles;		
	}

	/*
	 * Lists the number of items of each type.
	 */
	public void listAllByType() {
		System.out.println("Antal fordon parkerade av respektive typ:"
				+ "\n" + cars + " bilar, "
				+ "\n" + boats + " båtar, "
				+ "\n" + aircrafts + "flygplan, "
				+ "\n" + buses + "bussar och"
				+ "\n" + motorbikes + "motorcyklar.");
	}

	/*
	 * The method parks a new Vehicle in the garage
	 * 
	 * @param vehicle the new Vehicle to be parked.
	 */
	public void parkVehicle(Vehicle vehicle) {
		if( vehicles.size() < maxCapacity) {
			if(! vehicles.containsValue(vehicle) ) {
				vehicles.put(++parkinglot, vehicle);
				System.out.println("Din bil har parkerats på plats " + parkinglot);
				if(vehicle instanceof Car)  cars++;
				if(vehicle instanceof Boat)  boats++;
				if(vehicle instanceof Aircraft) aircrafts++;
				if(vehicle instanceof Bus) buses++;
				if(vehicle instanceof Motorbike) motorbikes++;
			}
			else {
				System.out.println("Fordonet är redan parkerat i garaget.");
			}
		}else {
			System.out.println("Garaget har nått sin maxkapacitet på " + maxCapacity + ".");
		}
	}

	public void setMaxCapacity(int newMax) {
		maxCapacity = newMax;
	}

	/*
	 * Takes a parking lot number as parameter and returns the corresponding Vehicle.
	 */
	public Vehicle findVehicle(int parkinglot) throws NullPointerException{
		return vehicles.get(parkinglot);
	}

	/*
	 * returns a list of Vehicles corresponding to the users options.
	 * 
	 * @param inputInt specifies the property.
	 * 
	 * @param query specifies the question.
	 * 
	 * @return results a list of Vehicles corresponding to the search made by the user.
	 */
	public List<Vehicle> findByProperty(int inputInt, String query) throws NullPointerException {
		List<Vehicle> results = new ArrayList<Vehicle>();

		switch(inputInt) {
		case 1:
			for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
				if(vehicle.getValue().getRegNo().equals(query)) {
					results.add(vehicle.getValue());
				}
			}
			break;

		case 2:

			switch(query) {

			case("1"):	
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Car ) {
						results.add(vehicle.getValue());
					}//if
				}//for
			break;

			case("2"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Boat ) {
						results.add(vehicle.getValue());
					}//if
				}//for
			break;

			case("3"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Aircraft ) {
						results.add(vehicle.getValue());
					}//if
				}//for
			break;

			case("4"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Bus ) {
						results.add(vehicle.getValue());
					}//if
				}//for
			break;

			case("5"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Motorbike ) {
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
		return results;
	}

	public String toString() {
		String output = "";
		for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
			output += vehicle.getValue().toString() + "\n\n";
		}
		return output;
	}
}
