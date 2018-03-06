package models;

public class Motorbike extends Vehicle {

	private static final long serialVersionUID = 1L;
	private boolean hasSideCar;

	// The Constructor to set all the properties except note
	public Motorbike(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, boolean hasSideCar) {

		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);

		this.hasSideCar = hasSideCar;
	}

	// The Constructor to set all non-optional properties
	public Motorbike(String regNo, String color, String brand) {

		super(regNo, color, brand);

		this.hasSideCar = false;
	}

	public boolean getSideCar() {
		return hasSideCar;
	}

	public String toString() {

		StringBuilder s = new StringBuilder();

		// Motorbike as a title
		s.append("MOTORCYKEL:\n");

		// Common vehicle properties
		s.append(super.toString());

		// Motorbike specific property
		if (hasSideCar) {
			s.append("\nHar sidovagn: ");
			s.append(super.booleanInSwedish(hasSideCar));
		}

		return s.toString();
	}

}
