package models;

public class Aircraft extends Vehicle {
	
	private String homePort;

	public Aircraft(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort) {

		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);
		
		this.homePort = homePort.trim();
	}
	
	public Aircraft(String regNo, String color, String brand) {

		super(regNo, color, brand);
		
		this.homePort = "";
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("\nHemmahamn: ");
		s.append(homePort);
		return s.toString();
	}
	
	
}
