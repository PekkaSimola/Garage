package models;

public class Aircraft extends Vehicle {
	
	private String homePort;

	public Aircraft(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot,
			String homePort) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG, parkingLot);
		
		this.homePort = homePort.trim();
	}

}
