package models;


public abstract class Vehicle {
	
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
		
	public Vehicle(String regNo, String color, int numberOfWheels, String model, String brand, double lengthMeters,
			double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats, String parkingDenotation) {
	
		parked = true;
		
		this.regNo = regNo;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.model = model;
		this.brand = brand;
		this.lengthMeters = lengthMeters;
		this.heigthMeters = heigthMeters;
		this.weightKG = weightKG;
		this.fuelType = fuelType;
		this.numberOfSeats = numberOfSeats;
		this.parkingLot = parkingLot;

	}

	public Vehicle(String regNo, String brand, String color) {
		
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
		this.parkingLot = 0;

	}

	public String getRegNo() {
		return regNo;
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

		slip.append("\nF�rg: ");
		slip.append(color);

		slip.append("\nBr�nsle: ");
		slip.append(fuelTypeToSwedish(fuelType));

		slip.append("\nS�ten: ");
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

	public String carTypeToSwedish(CarType ct) {

		if (ct == CarType.SEDAN) {
			return "Sedan";
		} else if (ct == CarType.HATCHBACK) {
			return "Kombi";
		} else if (ct == CarType.COUPE) {
			return "Coup�";
		} else if (ct) {
			return "Paketbil";
		} else {
			return "Ospecificerad biltyp"; // UNKNOWN
		}
	}
	
	//SEDAN, HATCHBACK, COUPE, VAN, UNDEFINED

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
	
	private String lengthAndHeightInMeters(double length, double height) {

		StringBuilder s = new StringBuilder();

		if (length < 0.1 && height < 0.1) {
			return "\nStorlek: ?";

		} else {

			DecimalFormat f = new DecimalFormat("0.00 meter");

			s.append("\nStorlek (");
			if (length > 0.1 && height > 0.1) {
				s.append("L�H): ");
				s.append(f.format(length));
				s.append(" � ");
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

	private String zeroToQuestionMark(int no) {
		if (no < 0.1) {
			return "?";
		} else {
			return "" + no;
		}
	}

	private String zeroToQuestionMark(double no) {
		return zeroToQuestionMark((int) no);
		this.parkingDenotation = parkingDenotation;
		
	}
	
	

}
