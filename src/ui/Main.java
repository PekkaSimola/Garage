package ui;

import models.Garage;

public class Main {

	public static void main(String[] args) {
/*		try {
			garage.load();
		} catch (FileNotFoundException e) {
			System.out.println("Det här ska inte kunna hända för filnamnet är hårdkodat.");
		}
		*/
		new GarageHandler( new Garage() );

	}

}
