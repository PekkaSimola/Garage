package models;

public class Motorboat extends Boat {

	private String motorSize;
	private int numberOfEngines;
	
	public Motorboat(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot, String homePort,
			String motorSize, int numberOfEngines) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot, homePort);
		
		this.motorSize = motorSize.trim();
		this.numberOfEngines = numberOfEngines;
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
