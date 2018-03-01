package models;

public class Motorbike extends Vehicle {

	private boolean hasSideCar;

	public Motorbike(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot,
			boolean hasSideCar) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot);
		
		this.hasSideCar = hasSideCar;
	}

	
}
