package models;

public class Aircraft extends Vehicle {
	
	private String homePort;

	public Aircraft(String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, String homePort) {
		
		super(regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation);
		
		this.homePort = homePort;
	}
	
	public String toString() {
		
		String s;
		
		
		
	}
	

}
