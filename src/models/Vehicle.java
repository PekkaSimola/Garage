package models;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Vehicle implements Serializable{
	
	private boolean parked;
	private String regNo;
	private String color;
	private int numberOfWheels;
	private String model;
	private String brand;
	private double lengthMeters;
	private double heigthMeters;
	private int weightKG;
	private FuelType fuelType;
	private int numberOfSeats;
	private String parkingDenotation;
	private int parkingLot;
	private String note;
		
	// The Constructor to set all the properties	
	public Vehicle(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot) {
		
		parked = true;
		
		this.regNo = regNo;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.model = model;
		this.brand = brand;
		this.lengthMeters = lengthMeters;
		this.heigthMeters = heigthMeters;
		this.weightKG = weightKG; //kan ev. tas bort
		this.fuelType = fuelType; //kan ev. tas bort
		this.numberOfSeats = numberOfSeats; //kan ev. tas bort
		this.parkingDenotation = parkingDenotation;
		this.parkingLot = parkingLot;
		this.note ="";
	}

	// The Constructor to set the non-optional properties
	public Vehicle(String regNo, String color, String brand) {
		
		parked = true;

		this.regNo = regNo.trim();
		this.color = color.trim();
		this.numberOfWheels = 0;
		this.model = "?";
		this.brand = brand.trim();
		this.lengthMeters = 0;
		this.heigthMeters = 0;
		this.weightKG = 0;
		this.fuelType = FuelType.UNDEFINED;
		this.numberOfSeats = 0;
		this.parkingDenotation = "";
		this.parkingLot = 0;
		this.note = "";

	}
	
	
	// ——————————————————————————————
	// *** START of local setters ***
    // ——————————————————————————————
	public void setNote(String note) {
		this.note = note;
	}
	
	public void setParkingDenotation(String parkingDenotation) {
		this.parkingDenotation = parkingDenotation;
	}
	
	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	// ——————————————————————
	// *** END of setters ***
    // ——————————————————————

	

	// ——————————————————————————————
	// *** START of local getters ***
    // ——————————————————————————————
	public String getNote() {
		return note;
	}
	
	public String getRegNo() {
		return regNo;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getColor() {
		return color;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	public double getLengthMeters() {
		return lengthMeters;
	}
	
	public double getHeigthMeters() {
		return heigthMeters;
	}

	public int getWeightKG() {
		return weightKG;
	}

	public int getParkingLot() {
		return parkingLot;
	}

	public boolean getParked() {
		return parked;
	}

	// ——————————————————————
	// *** END of getters ***
    // ——————————————————————
	
	public String toString() {

		StringBuilder slip = new StringBuilder();

		slip.append("RegNr: ");
		slip.append(regNo);

		slip.append("\nFordon: ");
		slip.append(brand);
		if (brand.length() > 0) {
			slip.append(" ");
		}
		slip.append(model);

		slip.append("\nFärg: ");
		slip.append(color);

		slip.append("\nBränsle: ");
		slip.append(fuelTypeToSwedish(fuelType));

		slip.append("\nSäten: ");
		slip.append(zeroToQuestionMark(numberOfSeats));
		if (numberOfSeats > 0) {
			slip.append(" st");
		}

		slip.append("\nAntal hjul: ");
		slip.append(zeroToQuestionMark(numberOfWheels));
		if (numberOfWheels > 0) {
			slip.append(" st");
		}

		slip.append(lengthAndHeightInMeters(lengthMeters, heigthMeters));

		slip.append("\nVikt: ");
		slip.append(weightKG);
		if (weightKG > 0) {
			slip.append(" kg");
		}

		return slip.toString();

	}

	// ———————————————————————————————————
	// *** Convert to Swedish routines ***
	// ———————————————————————————————————
	public String carTypeToSwedish(CarType ct) {

		if (ct == CarType.SEDAN) {
			return "Sedan";
		} else if (ct == CarType.HATCHBACK) {
			return "Kombi";
		} else if (ct == CarType.COUPE) {
			return "Coupé";
		} else if (ct == CarType.VAN) {
			return "Paketbil";
		} else {
			return "Ospecificerad biltyp"; // UNKNOWN
		}
	}
	
	public String booleanInSwedish(boolean b) {
		if (b == true) {
			return "SANT";
		} else {
			return "FALSKT";
		}
	}

	private String fuelTypeToSwedish(FuelType ft) {

		if (ft == FuelType.PETROL) {
			return "Bensin";
		} else if (ft == FuelType.DIESEL) {
			return "Diesel";
		} else if (ft == FuelType.ELECTRICITY) {
			return "Eldriven";
		} else if (ft == FuelType.ETHANOL) {
			return "Etanol";
		} else if (ft == FuelType.HYBRID) {
			return "Hybrid";
		} else {
			return "Ospecificerad drivmedelstyp"; // UNKNOWN
		}
	}
	
	// used by toString to get a length and height phrase in Swedish
	private String lengthAndHeightInMeters(double length, double height) {

		StringBuilder s = new StringBuilder();

		if (length < 0.1 && height < 0.1) {
			return "\nStorlek: ?";

		} else {

			DecimalFormat f = new DecimalFormat("0.00 meter");

			s.append("\nStorlek (");
			if (length > 0.1 && height > 0.1) {
				s.append("L×H): ");
				s.append(f.format(length));
				s.append(" × ");
				s.append(f.format(height));

			} else if (length > 0.1) {
				s.append("L): ");
				s.append(f.format(length));

			} else {
				s.append("H):");
				s.append(f.format(height));
			}

			return s.toString();

		}
	}

	// used by toString to convert lacking numbers (0) to a question-mark
	private String zeroToQuestionMark(int no) {
		if (no < 0.1) {
			return "?";
		} else {
			return "" + no;
		}
	}

}
