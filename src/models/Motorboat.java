package models;

public class Motorboat extends Boat {

	private String motorSize;
	private int numberOfEngines;
	
	public Motorboat(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model,
			String brand, double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, String homePort, String motorSize, int numberOfEngines) {
		
		super(vehicleType, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, homePort);
		
		this.motorSize = motorSize;
		this.numberOfEngines = numberOfEngines;
	}
	
	
}
