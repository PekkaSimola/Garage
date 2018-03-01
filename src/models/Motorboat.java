package models;

public class Motorboat extends Boat {

	private String motorSize;
	private int numberOfEngines;
	
	public Motorboat(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot, String homePort,
			String motorSize, int numberOfEngines) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot, homePort);
		
		this.motorSize = motorSize.trim();
		this.numberOfEngines = numberOfEngines;
	}
	
	
}
