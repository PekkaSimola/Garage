package models;

// Common properties of all vehicles
// NOTE to Ozur; Niklas wants this to be an abstract class to prevent instantiation of it
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
	
	
	//TODO: remove this later
	// set to standard type (ANY) here
	// subClasses might change to a more specific type
	private VehicleType vehicleType;
	
	public Vehicle(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model, String brand, double lengthMeters,
			double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats, String parkingDenotation) {
		//super();
		
		parked = true;
		vehicleType = VehicleType.ANY; // standard-type
		
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
		this.parkingDenotation = parkingDenotation;
		
	}
	
	

}
