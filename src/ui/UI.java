package ui;

import java.util.Scanner;

import models.Aircraft;
import models.Boat;
import models.Bus;
import models.Car;
import models.Garage;
import models.Motorbike;

public class UI {

	Scanner sc;
	String input = "";
	String query = "";
	int choice = 0;
	Garage garage;
	
	public UI() {
		sc = new Scanner(System.in);
		garage = new Garage();
		run();
	}
	
	public void run() {
		
		while( !input.equalsIgnoreCase("q") ) {
			System.out.println("****************************************"
				+ "\nHej och v�lkommen till det Granna Garaget!"
				+ "\nVad vill du g�ra?"
				+ "\n1: Parkera ett fordon"
				+ "\n2: Lista alla parkerade fordon"
				+ "\n3: S�ka efter ett fordon"
				+ "\nQ: Avsluta");
			
			input = sc.nextLine();
			
			switch(input) {
			case("1"):
				parkVehicle();
				break;
				
			case("2"):
				garage.listAllParkedVehicles();
				break;
				
			case("3"):
				findByProperty();
			}
		}
		System.out.println("Tack f�r att du bes�kte det Granna Garaget!\nHa en bra dag!");
	}
	
	public void findByProperty() {
		System.out.println("P� vilken egenskap vill du g�ra s�kningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: F�rg");
		choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("V�nligen ange registreringsnummer:");
		}
		if(choice == 2) {
			System.out.println("V�nligen ange fordonstyp:"
					+ "\n1: Bil"
					+ "\n2: B�t"
					+ "\n3: Flygplan"
					+ "\n4: Buss"
					+ "\n5: Motorcykel");
		}
		if(choice == 3) {
			System.out.println("V�nligen ange fordonets f�rg:");
		}
		
		query = sc.nextLine();
		
		garage.findByProperty(choice, query);
	}
	
	public void parkVehicle() {
		String regNo = "";
		String color = "";
		String brand = "";
		String type = "";
		
		System.out.println("V�nligen ange fordonstyp:"
				+ "\n1: Bil"
				+ "\n2: B�t"
				+ "\n3: Flygplan"
				+ "\n4: Buss"
				+ "\n5: Motorcykel");
		choice = sc.nextInt();
		
		System.out.println("Ange registreringsnummer:");
		regNo = sc.nextLine();
		System.out.println("Ange f�rg:");
		color = sc.nextLine();
		System.out.println("Ange m�rke:");
		brand = sc.nextLine();

		switch(choice) {
		case 1:
			garage.parkVehicle( new Car(regNo, color, brand) );
			break;
		case 2:
			garage.parkVehicle( new Boat(regNo, color, brand) );
			break;
		case 3:
			garage.parkVehicle( new Aircraft(regNo, color, brand) );
			break;
		case 4:
			garage.parkVehicle( new Bus(regNo, color, brand) );
			break;
		case 5:
			garage.parkVehicle( new Motorbike(regNo, color, brand) );
			break;
		}//switch
	}
}
