package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	int motorbikes = 0;
	int parkinglot = 0;

	Map<Integer, Vehicle> vehicles;

	public Garage() {
		vehicles = new HashMap<Integer, Vehicle>(1);
	}

	public Map<Integer, Vehicle> getVehicles() {
		return vehicles;		
	}

	public void listAll() {
		System.out.println("Antal fordon parkerade av respektive typ:"
				+ "\n" + cars + " bilar, "
				+ "\n" + boats + " båtar, "
				+ "\n" + aircrafts + "flygplan, "
				+ "\n" + buses + "bussar och"
				+ "\n" + motorbikes + "motorcyklar.");
	}

	public void parkVehicle(Vehicle vehicle) {
		if( vehicles.size()<maxCapacity) {
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

	public Vehicle findVehicle(int parkinglot){
		return vehicles.get(parkinglot);	
	}

	public List<Vehicle> findByProperty(int inputInt, String query) {
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
			query = query.toLowerCase();

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

	
	public void save() {

		try {
			FileOutputStream fout = new FileOutputStream("garage.lex");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(vehicles);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException{
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream("garage.lex");
			ois = new ObjectInputStream(fis);
			vehicles = (Map<Integer, Vehicle>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String output = "";
		for (Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
			output += vehicle.getValue().toString() + "\n";
		}
		return output;
	}
}
