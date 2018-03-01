package models;

public class Bus extends Vehicle {
	
	private boolean isDoubleDecker;
	private boolean isHeadedBus;
	private int maxAmountPassengers;
	
	public Bus(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, boolean isDoubleDecker, boolean isHeadedBus,
			int maxAmountPassengers) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);

		this.isDoubleDecker = isDoubleDecker;
		this.isHeadedBus = isHeadedBus;
		this.maxAmountPassengers = maxAmountPassengers;
	}

	public Bus(String regNo, String color, String brand) {
		
		super(regNo, color, brand);

		this.isDoubleDecker = false;
		this.isHeadedBus = false;
		this.maxAmountPassengers = 50;
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
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("\nDubbeldäckare: ");
		s.append(super.booleanInSwedish(isDoubleDecker));
		s.append("\nLedad buss: ");
		s.append(super.booleanInSwedish(isHeadedBus));
		s.append("\nMaxantal passagerare: ");
		s.append(maxAmountPassengers);		
		
		return s.toString();
	}
	

}
