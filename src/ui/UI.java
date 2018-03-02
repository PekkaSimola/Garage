package ui;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import models.Aircraft;
import models.Boat;
import models.Bus;
import models.Car;
import models.Garage;
import models.Motorbike;
import models.Vehicle;

public class UI {

	Scanner sc;
	String inputString = "";
	String query = "";
	int inputInt = 0;
	Garage garage;

	public UI(Garage garage) {
		sc = new Scanner(System.in);
		this.garage = garage;
		run();
	}

	public void run() {

		while( !inputString.equalsIgnoreCase("q") ) {
			System.out.println("****************************************"
					+ "\nHej och v�lkommen till det Granna Garaget!"
					+ "\nVad vill du g�ra?"
					+ "\n1: Parkera ett fordon"
					+ "\n2: Lista alla parkerade fordon"
					+ "\n3: S�ka efter ett fordon"
					+ "\nQ: Avsluta");

			inputString = sc.nextLine();

			if(inputString.equalsIgnoreCase("q")) {
				break;
			}
			if(!inputString.equals("1")
					&& !inputString.equals("2")
					&& !inputString.equals("3")) { 
				System.out.println("Du har gjort en ogiltig inmatning, v�nligen f�rs�k igen.");
			}else {
				switch(inputString) {
				case("1"):
					parkVehicle();
				break;

				case("2"):
					listAllVehicles();
				break;

				case("3"):
					findByProperty();
				break;

				default:
					break;
				}//switch
			}
	
			garage.save();

		}
		System.out.println("Tack f�r att du bes�kte det Granna Garaget!\nHa en bra dag!");
	}

	public void findByProperty() {
		String resultPresentation = "";
		String vehicleType = "";

		List<Vehicle> results;

		System.out.println("P� vilken egenskap vill du g�ra s�kningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: F�rg");
		inputInt = sc.nextInt();

		if(inputInt == 1) {
			System.out.println("V�nligen ange registreringsnummer:");
			query = sc.next();
			resultPresentation = "Din s�kning p� registreringsnumret " + query + "gav f�ljande resultat:";
		}

		if(inputInt == 2) {
			System.out.println("V�nligen ange fordonstyp:"
					+ "\n1: Bil"
					+ "\n2: B�t"
					+ "\n3: Flygplan"
					+ "\n4: Buss"
					+ "\n5: Motorcykel");			
			query = sc.next();

			switch(query) {
			case "1": vehicleType = "bil"; break;
			case "2": vehicleType = "b�t"; break;
			case "3": vehicleType = "flygplan"; break;
			case "4": vehicleType = "buss"; break;
			default: break;
			}

			resultPresentation = "Din s�kning p� fordonstypen " + vehicleType + "gav f�ljande resultat:";
		}
		if(inputInt == 3) {
			System.out.println("V�nligen ange fordonets f�rg:");
			query = sc.next();
			
			resultPresentation = "Din s�kning p� f�rgen " +query+ " gav f�ljande resultat:";
		}

		results = garage.findByProperty(inputInt, query);

		System.out.println(resultPresentation);
		for(Vehicle vehicle : results) {
			System.out.println(vehicle.toString());
		}
		System.out.println("****************************************");
	}

	public void parkVehicle() {
		inputInt = 0;
		String regNo = "";
		String color = "";
		String brand = "";

		System.out.println("V�nligen ange fordonstyp:"
				+ "\n1: Bil"
				+ "\n2: B�t"
				+ "\n3: Flygplan"
				+ "\n4: Buss"
				+ "\n5: Motorcykel");
		
		while(inputInt < 1 || inputInt > 5) {
			try {
				inputInt = sc.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("Du har gjort en felaktig inmatning.\nV�nligen ange ditt val med 1, 2, 3, 4 eller 5.");
				sc.nextLine();
			}
		}//while
		
		System.out.println("Ange registreringsnummer:");
		regNo = sc.next();

		System.out.println("Ange f�rg:");
		color = sc.next();

		System.out.println("Ange m�rke:");
		brand = sc.next();

		/*here i suppose we could have a beautiful compact lambda-predicate instead of an ugly redundant switch...
		*/
		switch(inputInt) {
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
		inputString = "";
	}

	public void listAllVehicles() {
		garage.toString();
	}
}
