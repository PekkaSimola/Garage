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

	public CarType getCarType() {
		return carType;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("\nBiltyp: ");
		s.append(super.carTypeToSwedish(carType));
		return s.toString();
	}
	
}
