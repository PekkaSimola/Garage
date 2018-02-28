package models;

public class Motorbike extends Vehicle {

	private boolean hasSideCar;

	public Motorbike(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model,
			String brand, double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, boolean hasSideCar) {
		
		super(vehicleType, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation);
		
		this.hasSideCar = hasSideCar;
	}


	
}
