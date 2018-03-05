package models;

public class Sailboat extends Boat {
	
	//private static final long serialVersionUID = 1L;
	private int amountSails;
	private int amountSailPoles;
	
	/*
	 *  The Constructor to set all the properties except note
	 */
	public Sailboat(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, String homePort, int amountSails, int amountSailPoles) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot, homePort);
		
		this.amountSails = amountSails;
		this.amountSailPoles = amountSailPoles;
	}

	/*
	 *  The Constructor to set the non-optional properties
	 */
	public Sailboat(String regNo, String color, String brand) {
		
		super(regNo, color, brand);
		
		this.amountSails = 1;
		this.amountSailPoles = 1;
	}

	
	// ——————————————————————————————————
	// *** START of the local getters ***
    // ——————————————————————————————————
	public int getAmountSails() {
		return amountSails;
	}

	public int getAmountSailPoles() {
		return amountSailPoles;
	}
	
	// super = Boat
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		//The boat type as a title
		s.append("SEGELBÅT:\n");
		
		//Common boat and vehicle properties
		s.append(super.toString());
		
		//Sail-boat specific properties
		if (amountSails > 0) {
			s.append("\nAntal segel: ");
			s.append(amountSails);
		}
		if (amountSailPoles > 0) {
			s.append("\nAntal segelstolpar: ");
			s.append(amountSailPoles);
		}
			
		return s.toString();
	}
	

}
