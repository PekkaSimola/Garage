package ui;

import models.Garage;

public class Main {

	public static void main(String[] args) {
/*		try {
			garage.load();
		} catch (FileNotFoundException e) {
			System.out.println("Det h�r ska inte kunna h�nda f�r filnamnet �r h�rdkodat.");
		}
		*/
		new GarageHandler( new Garage() );

	}

}
