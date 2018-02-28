package models;

public class Car extends Vehicle {
	
	private CarType carType;

	public Car(VehicleType vehicleType, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, CarType carType) {
		
		super(vehicleType, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation);
		
		this.carType = carType;
	}
	
}
