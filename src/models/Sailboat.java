package models;

public class Sailboat extends Boat {
	
	private int amountSails;
	private int amountSailPoles;
	
	public Sailboat(String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, String homePort, int amountSails, int amountSailPoles) {
		
		super(regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, homePort);
		
		this.amountSails = amountSails;
		this.amountSailPoles = amountSailPoles;
	}
	

}
