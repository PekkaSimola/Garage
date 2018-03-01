package models;

public class Motorboat extends Boat {

	private String motorSize;
	private int numberOfEngines;
	
	public Motorboat(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort, String motorSize, int numberOfEngines) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot, homePort);

		this.motorSize = motorSize.trim();
		this.numberOfEngines = numberOfEngines;
	}

	public Motorboat(String regNo, String color, String brand) {
		
		super(regNo, color, brand);

		this.motorSize = "";
		this.numberOfEngines = 1;
	}
	
	public String getMotorSize() {
		return motorSize;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		//super = Boat
		s.append(super.toString());
		s.append("\nMotorstorlek: ");
		s.append(motorSize);		
		s.append("\nAntal motorer: ");
		s.append(numberOfEngines);
		return s.toString();
	}

}
