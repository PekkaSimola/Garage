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
					+ "\nHej och välkommen till det Granna Garaget!"
					+ "\nVad vill du göra?"
					+ "\n1: Parkera ett fordon"
					+ "\n2: Lista alla parkerade fordon"
					+ "\n3: Söka efter ett fordon"
					+ "\nQ: Avsluta");

			inputString = sc.nextLine();

			if(inputString.equalsIgnoreCase("q")) {
				break;
			}
			if(!inputString.equals("1")
					&& !inputString.equals("2")
					&& !inputString.equals("3")) { 
				System.out.println("Du har gjort en ogiltig inmatning, vänligen försök igen.");
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
		System.out.println("Tack för att du besökte det Granna Garaget!\nHa en bra dag!");
	}

	public void findByProperty() {
		String resultPresentation = "";
		String vehicleType = "";

		List<Vehicle> results;

		System.out.println("På vilken egenskap vill du göra sökningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: Färg");
		inputInt = sc.nextInt();

		if(inputInt == 1) {
			System.out.println("Vänligen ange registreringsnummer:");
			query = sc.next();
			resultPresentation = "Din sökning på registreringsnumret " + query + "gav följande resultat:";
		}

		if(inputInt == 2) {
			System.out.println("Vänligen ange fordonstyp:"
					+ "\n1: Bil"
					+ "\n2: Båt"
					+ "\n3: Flygplan"
					+ "\n4: Buss"
					+ "\n5: Motorcykel");			
			query = sc.next();

			switch(query) {
			case "1": vehicleType = "bil"; break;
			case "2": vehicleType = "båt"; break;
			case "3": vehicleType = "flygplan"; break;
			case "4": vehicleType = "buss"; break;
			default: break;
			}

			resultPresentation = "Din sökning på fordonstypen " + vehicleType + "gav följande resultat:";
		}
		if(inputInt == 3) {
			System.out.println("Vänligen ange fordonets färg:");
			query = sc.next();
			
			resultPresentation = "Din sökning på färgen " +query+ " gav följande resultat:";
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

		System.out.println("Vänligen ange fordonstyp:"
				+ "\n1: Bil"
				+ "\n2: Båt"
				+ "\n3: Flygplan"
				+ "\n4: Buss"
				+ "\n5: Motorcykel");
		
		while(inputInt < 1 || inputInt > 5) {
			try {
				inputInt = sc.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("Du har gjort en felaktig inmatning.\nVänligen ange ditt val med 1, 2, 3, 4 eller 5.");
				sc.nextLine();
			}
		}//while
		
		System.out.println("Ange registreringsnummer:");
		regNo = sc.next();

		System.out.println("Ange färg:");
		color = sc.next();

		System.out.println("Ange märke:");
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
