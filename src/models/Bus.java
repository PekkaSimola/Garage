package models;

public class Bus extends Vehicle {
	
	private boolean isDoubleDecker;
	private boolean isHeadedBus;
	private int maxAmountPassengers;
	
	public Bus(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot,
			boolean isDoubleDecker, boolean isHeadedBus, int maxAmountPassengers) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot);
		
		this.isDoubleDecker = isDoubleDecker;
		this.isHeadedBus = isHeadedBus;
		this.maxAmountPassengers = maxAmountPassengers;
	}

	public boolean isDoubleDecker() {
		return isDoubleDecker;
	}

	public boolean isHeadedBus() {
		return isHeadedBus;
	}

	public int getMaxAmountPassengers() {
		return maxAmountPassengers;
	}
	
	
	
	

}
