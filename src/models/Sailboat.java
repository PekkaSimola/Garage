package models;

public class Sailboat extends Boat {
	
	private int amountSails;
	private int amountSailPoles;
	
	
	
	public Sailboat(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort, int amountSails, int amountSailPoles) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot, homePort);
		
		this.amountSails = amountSails;
		this.amountSailPoles = amountSailPoles;
	}

	public Sailboat(String regNo, String color, String brand) {
		
		super(regNo, color, brand);
		
		this.amountSails = 1;
		this.amountSailPoles = 1;
	}

	
	public int getAmountSails() {
		return amountSails;
	}

	public int getAmountSailPoles() {
		return amountSailPoles;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		// super = Boat
		s.append(super.toString());
		s.append("\nAntal segel: ");
		s.append(amountSails);		
		s.append("\nAntal segelstolpar: ");
		s.append(amountSailPoles);
		return s.toString();
	}
	

}
