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
		this.parkingDenotation = parkingDenotation;
		
	}
	
	
>>>>>>> 60de11e88b2088a71de2f7f6702fdd64ef34ac61

}
