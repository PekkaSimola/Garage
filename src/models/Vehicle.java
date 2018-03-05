package models;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Vehicle implements Serializable {

	// Common properties of all vehicle-types 
	private static final long serialVersionUID = 1L;
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
	private int parkingLot;
	private String note;

	// The Constructor to set all the common properties
	public Vehicle(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot) {

		parked = true;

		this.regNo = regNo.trim().toUpperCase();
		this.color = fixTextInput(color, true);
		this.numberOfWheels = numberOfWheels;
		this.model = fixTextInput(model, true);
		this.brand = fixTextInput(brand, true);
		this.lengthMeters = lengthMeters;
		this.heigthMeters = heigthMeters;
		this.weightKG = weightKG; // kan ev. tas bort
		this.fuelType = fuelType; // kan ev. tas bort
		this.numberOfSeats = numberOfSeats; // kan ev. tas bort
		this.parkingLot = parkingLot;
		this.note = "";
	}

	// The Constructor to set the non-optional properties
	public Vehicle(String regNo, String color, String brand) {

		parked = true;

		this.regNo = regNo.trim().toUpperCase();
		this.color = fixTextInput(color, true);
		this.numberOfWheels = 0;
		this.model = "";
		this.brand = fixTextInput(brand, true);
		this.lengthMeters = 0;
		this.heigthMeters = 0;
		this.weightKG = 0;
		this.fuelType = FuelType.UNDEFINED;
		this.numberOfSeats = 0;
		this.parkingLot = 0;
		this.note = "";

	}

	// ——————————————————————————————
	// *** START of local setters ***
	// ——————————————————————————————
	public void setNote(String note) {
		this.note = note;
	}

	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setParked() {
		parked = !parked;
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

		// RegNo, brand and color should always exist.
		// The remaining properties are optional
		slip.append("RegNr: ");
		slip.append(regNo);

		slip.append("\nMärke: ");
		slip.append(brand);
		
		if (model.length() > 0) {
			slip.append(" ");
			slip.append(model);
		}

		slip.append("\nFärg: ");
		slip.append(color);

		if (fuelType != FuelType.UNDEFINED) {
			slip.append("\nBränsle: ");
			slip.append(fuelTypeToSwedish(fuelType));
		}

		if (numberOfSeats > 0) {
			slip.append("\nSäten: ");
			slip.append(numberOfSeats);
			slip.append(" st");
		}
		
		if (numberOfWheels > 0) {
			slip.append("\nAntal hjul: ");
			slip.append(numberOfWheels);
			slip.append(" st");
		}

		if (lengthMeters > 0.1 || heigthMeters > 0.1) {
			slip.append(lengthAndHeightInMeters(lengthMeters, heigthMeters));
		}

		if (weightKG > 0) {
			slip.append("\nVikt: ");
			slip.append(weightKG);
			slip.append(" kg");
		}

		return slip.toString();

	}

	 // ———————————————————————————————
	 // *** Convert to Swedish routines
	 // ———————————————————————————————
	public String carTypeAsASwedishTitle(CarType ct) {

		if (ct == CarType.SEDAN) {
			return "SEDANBIL";
		} else if (ct == CarType.HATCHBACK) {
			return "KOMBIBIL";
		} else if (ct == CarType.COUPE) {
			return "COUPÉBIL";
		} else if (ct == CarType.VAN) {
			return "PAKETBIL";
		} else {
			return "BIL"; // UNKNOWN
		}
	}	
	
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
			return "Uppgift saknas!"; // UNKNOWN
		}
	}

	public String booleanInSwedish(boolean b) {
		if (b == true) {
			return "Ja";
		} else {
			return "Nej";
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
			return "Uppgift saknas!"; // UNKNOWN
		}
	}

    // Used by toString to get a Swedish length and height phrase
	// • At least one of the properties is given at call.
	private String lengthAndHeightInMeters(double length, double height) {

		StringBuilder s = new StringBuilder();

		s.append("\nStorlek (");

		DecimalFormat f = new DecimalFormat("0.00 meter");

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

	// used by toString to convert lacking numbers (0) to a question-mark
	public String zeroToQuestionMark(int no) {
		if (no < 0.1) {
			return "?";
		} else {
			return "" + no;
		}
	}

	// Returns a sentence with single spaces between words/phrases
	// • Possible tabs are deleted
	// • If firstCharToUpperCase == true, the very first word/phrase
	//   will begin with an upper case letter
	public static String fixTextInput(String s, boolean firstCharToUpperCase) {

		s = s.trim();

		// replace tabs with spaces because the loop use spaces as delimiters
		s = s.replaceAll("\t", " ");

		StringBuilder sentence = new StringBuilder();
		String[] splited = s.split(" ");
		String word = new String();
		String firstChar = "";

		for (int i = 0; i < splited.length; i++) {

			word = splited[i];

			// Exclude empty strings (==space)
			if (word.equals("") == false) {

				// Possible conversion of the very first letter to upper case
				if (i == 0 && firstCharToUpperCase == true) {
					firstChar = word.substring(0, 1);
					firstChar = firstChar.toUpperCase();
					word = firstChar + word.substring(1);
				}

				sentence.append(" ");
				sentence.append(word);
			}
		}
		
		//Delete the preceding space
		if (sentence.length() > 0) {
			word = sentence.substring(1);
		}

		return word;

	}

}
