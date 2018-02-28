package models;

public class Bus extends Vehicle {
	
	private boolean isDoubleDecker;
	private boolean isHeadedBus;
	private int maxAmountPassengers;
	
	public Bus(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, boolean isDoubleDecker, boolean isHeadedBus, int maxAmountPassengers) {
	
		super(vehicleType, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation);
		
		this.isDoubleDecker = isDoubleDecker;
		this.isHeadedBus = isHeadedBus;
		this.maxAmountPassengers = maxAmountPassengers;
	}
	
	

}
