package models;

public class Car extends Vehicle {
	
	private CarType carType;

	public Car(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, CarType carType) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);
		
		this.carType = carType;
	}

	public Car(String regNo, String color, String brand) {
		
		super(regNo, color, brand);
		
		this.carType = CarType.UNDEFINED;
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
