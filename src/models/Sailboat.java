package models;

public class Sailboat extends Boat {
	
	private int amountSails;
	private int amountSailPoles;
	
	public Sailboat(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot, String homePort,
			int amountSails, int amountSailPoles) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot, homePort);
		
		this.amountSails = amountSails;
		this.amountSailPoles = amountSailPoles;
		
	}

	public int getAmountSails() {
		return amountSails;
	}

	public int getAmountSailPoles() {
		return amountSailPoles;
	}
	


}
