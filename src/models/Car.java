package models;

public class Car extends Vehicle {
	
	//private static final long serialVersionUID = 1L;
	private CarType carType;

	// The Constructor to set all the properties except note
	public Car(boolean parked, String regNo, String color, int numberOfWheels, String model, String brand,
			double lengthMeters, double heigthMeters, int weightKG, FuelType fuelType, int numberOfSeats,
			String parkingDenotation, int parkingLot, CarType carType) {
		
		super(parked, regNo, color, numberOfWheels, model, brand, lengthMeters, heigthMeters, weightKG, fuelType,
				numberOfSeats, parkingDenotation, parkingLot);
		
		this.carType = carType;
	}

    // The Constructor to set the non-optional properties
	public Car(String regNo, String color, String brand) {
		
		super(regNo, color, brand);
		
		this.carType = CarType.UNDEFINED;
	}

	public CarType getCarType() {
		return carType;
	}
	
	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		//CarType as a title
		s.append(super.carTypeAsASwedishTitle(carType));
		s.append(":\n");
		
		//Common vehicle properties
		s.append(super.toString());
		
		//A car specific property
		if (carType != CarType.UNDEFINED) {
			s.append("\nBiltyp: ");
			s.append(super.carTypeToSwedish(carType));
		}
		return s.toString();
	}
	
}
