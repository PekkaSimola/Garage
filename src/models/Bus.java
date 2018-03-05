package models;

public class Bus extends Vehicle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isDoubleDecker;
	private boolean isHeadedBus;
	private int maxAmountPassengers;
	
	/*
	 *  The Constructor to set all the properties except note
	 */
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

	/*
	 *  The Constructor to set the non-optional properties
	 */
	public Bus(String regNo, String color, String brand) {
		
		super(regNo, color, brand);

		this.isDoubleDecker = false;
		this.isHeadedBus = false;
		this.maxAmountPassengers = 50;
	}

	
	// ����������������������������������
	// *** START of the local getters ***
    // ����������������������������������	
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
		s.append("\nDubbeld�ckare: ");
		s.append(super.booleanInSwedish(isDoubleDecker));
		s.append("\nLedad buss: ");
		s.append(super.booleanInSwedish(isHeadedBus));
		s.append("\nMaxantal passagerare: ");
		s.append(maxAmountPassengers);		
		
		return s.toString();
	}
	

}
