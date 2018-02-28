package models;

public class Aircraft extends Vehicle {
	
	private String homePort;

	public Aircraft(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, String homePort) {
		
		super(vehicleType, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation);
		
		this.homePort = homePort;
	}
	
	

}
