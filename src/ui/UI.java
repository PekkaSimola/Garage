package ui;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import models.Aircraft;
import models.Boat;
import models.Bus;
import models.Car;
import models.Garage;
import models.Motorbike;
import models.Vehicle;

public class UI {

	Scanner sc;
	String input = "";
	String query = "";
	int choice = 0;
	Garage garage;
	
	public UI(Garage garage) {
		sc = new Scanner(System.in);
		this.garage = garage;
		run();
	}
	
	public void run() {
		
		while( !input.equalsIgnoreCase("q") ) {
			System.out.println("****************************************"
				+ "\nHej och välkommen till det Granna Garaget!"
				+ "\nVad vill du göra?"
				+ "\n1: Parkera ett fordon"
				+ "\n2: Lista alla parkerade fordon"
				+ "\n3: Söka efter ett fordon"
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
		
		try {
			garage.save();
		}catch(FileNotFoundException e) {
			System.out.println("Det här ska inte kunna hända för filnamnet är hårdkodat.");
		}
		
		System.out.println("Tack för att du besökte det Granna Garaget!\nHa en bra dag!");
	}
	
	public void findByProperty() {
		List<Vehicle> results;
		
		System.out.println("På vilken egenskap vill du göra sökningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: Färg");
		choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("Vänligen ange registreringsnummer:");
		}
		if(choice == 2) {
			System.out.println("Vänligen ange fordonstyp:"
					+ "\n1: Bil"
					+ "\n2: Båt"
					+ "\n3: Flygplan"
					+ "\n4: Buss"
					+ "\n5: Motorcykel");
		}
		if(choice == 3) {
			System.out.println("Vänligen ange fordonets färg:");
		}
		
		query = sc.nextLine();
		
		results = garage.findByProperty(choice, query);
	
		System.out.println("Din sökning gav följande resultat:");
		for(Vehicle vehicle : results) {
			System.out.println(vehicle.toString());
		}
		System.out.println("****************************************");
	}
	
	public void parkVehicle() {
		String regNo = "";
		String color = "";
		String brand = "";
		String type = "";
		
		System.out.println("Vänligen ange fordonstyp:"
				+ "\n1: Bil"
				+ "\n2: Båt"
				+ "\n3: Flygplan"
				+ "\n4: Buss"
				+ "\n5: Motorcykel");
		choice = sc.nextInt();
		
		System.out.println("Ange registreringsnummer:");
		regNo = sc.nextLine();
		System.out.println("Ange färg:");
		color = sc.nextLine();
		System.out.println("Ange märke:");
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
