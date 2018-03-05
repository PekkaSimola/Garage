package models;

public class Boat extends Vehicle {

	// Common properties of all Boat-types 
	//private static final long serialVersionUID = 1L;
	private String homePort;

	// The Constructor to set all the properties except note
	public Boat(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort) {

		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);

		this.homePort = super.fixTextInput(homePort, true);
	}

	// The Constructor to set the non-optional properties
	public Boat(String regNo, String color, String brand) {

		super(regNo, color, brand);

		this.homePort = "";
	}

	public String getHomePort() {
		return homePort;
	}

	public void setHomePort(String homePort) {
		this.homePort = homePort.trim();
	}

	public String toString() {

		StringBuilder s = new StringBuilder();
		
		//Common vehicle properties
		s.append(super.toString());

		//Boat specific property
		if (homePort.length() > 0) {
			s.append("\nHemmahamn: ");
			s.append(homePort);
		}

		return s.toString();
	}

}
