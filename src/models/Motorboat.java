package models;

public class Motorboat extends Boat {

	// private static final long serialVersionUID = 1L;
	private String motorSize;
	private int numberOfEngines;

	// Constructor to set all the properties except note
	public Motorboat(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort, String motorSize, int numberOfEngines) {

		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot, homePort);

		this.motorSize = motorSize.trim();
		this.numberOfEngines = numberOfEngines;
	}

	// The Constructor to set all non-optional properties
	public Motorboat(String regNo, String color, String brand) {

		super(regNo, color, brand);

		this.motorSize = "";
		this.numberOfEngines = 1;
	}

	// ————————————————————————
	// *** START of getters ***
	// ————————————————————————
	public String getMotorSize() {
		return motorSize;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	// super = Boat
	public String toString() {

		StringBuilder s = new StringBuilder();

		//The boat type as a title
		s.append("MOTORBÅT:\n");

		//Common boat and vehicle properties
		s.append(super.toString());

		//Motor-boat specific properties
		if (motorSize.length() > 0) {
			s.append("\nMotorstorlek: ");
			s.append(motorSize);
		}
		if (numberOfEngines > 0) {
			s.append("\nAntal motorer: ");
			s.append(numberOfEngines);
		}

		return s.toString();
	}

}
