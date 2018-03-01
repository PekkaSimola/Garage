package models;

public class Car extends Vehicle {
	
	private CarType carType;

	public Car(String regNo, String model, String brand, String color, FuelType fuelType, int numberOfWheels,
			int numberOfSeats, double lengthMeters, double heigthMeters, int weightKG, int parkingLot,
			CarType carType) {
		
		super(regNo, model, brand, color, fuelType, numberOfWheels, numberOfSeats,
			  lengthMeters, heigthMeters, weightKG,	parkingLot);
		
		this.carType = carType;
	}

	
	
}
