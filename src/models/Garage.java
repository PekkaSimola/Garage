package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
				+ "\n" + motorbikes + "motorcyklar.");
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
				if(vehicle.getValue().getRegNo().equals(query)) {
					results.add(vehicle.getValue());
				}
			}
			break;
			
		case 2:
			query = query.toLowerCase();

			switch(query) {
			
			case("bil"):	
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Car ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("båt"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Boat ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
			
			case("flygplan"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Aircraft ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("buss"):
				for(Entry<Integer, Vehicle> vehicle : vehicles.entrySet()) {
					if( vehicle.getValue() instanceof Bus ) {
						results.add(vehicle.getValue());
					}//if
				}//for
				break;
				
			case("motorcykel"):
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
	
	public void save() throws FileNotFoundException{
		String temp = vehicles.toString();
		
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("garage.lex"));
			pw.write(temp);
			pw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Det här ska inte kunna hända för filnamnet är hårdkodat.");
		}	
	}
	
//	public void load() throws FileNotFoundException{
//		ArrayList<Vehicle> test = new ArrayList();
//		FileInputStream in = new FileInputStream("garage.lex");
//		Scanner sc = new Scanner(in);
//		test.addAll(sc.next());
//	}
//	
}
