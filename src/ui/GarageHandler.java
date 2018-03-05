package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.Aircraft;
import models.Boat;
import models.Bus;
import models.Car;
import models.Garage;
import models.Motorbike;
import models.Vehicle;

public class GarageHandler {

	Scanner sc;
	String inputString = "";
	String query = "";
	int inputInt = 0;
	Garage garage;

	/*
	 * GarageHandler provides a user interface to handle the garage.
	 * The constructor tries to load a Garage from previous state at startup.
	 */
	public GarageHandler(Garage garage) {
		sc = new Scanner(System.in);
		this.garage = garage;

		try {
			load();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		run();
	}

	/*
	 * Saves the current state of Garage for future sessions.
	 */
	public void save() {
		try {
			FileOutputStream fout = new FileOutputStream("garage.lex");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(garage);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Loads the Garage state from the latest session.
	 */
	public void load() throws FileNotFoundException{
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream("garage.lex");
			ois = new ObjectInputStream(fis);
			garage = (Garage) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Runs the user interface. Will always save changes in the garage to file before exiting.
	 */
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

			while(!inputString.equals("1")
					&& !inputString.equals("2")
					&& !inputString.equals("3")) {

				if(inputString.equalsIgnoreCase("q")) {
					break;
				}//if

				System.out.println("Du har gjort en ogiltig inmatning, vänligen försök igen.");
				inputString = sc.next();
			}//while

			switch(inputString) {
			case("1"): parkVehicle(); break;
			case("2"): listAllVehicles(); break;
			case("3"): findByProperty(); break;
			default: break;

			}//switch

			sc.nextLine();	

		}//while

		save();

		System.out.println("Tack för att du besökte det Granna Garaget!\nHa en bra dag!");

	}//run

	/*
	 * Gives the user a list of options to chose from depending on by which property he wants to make a search.
	 * Prints a list of all vehicles which match the search.
	 */
	public void findByProperty() {
		inputInt = 0;
		String resultPresentation = "";
		String vehicleType = "";

		List<Vehicle> results;

		System.out.println("På vilken egenskap vill du göra sökningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: Färg");

		while(inputInt < 1 || inputInt > 5) {
			try {
				inputInt = sc.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("Du har gjort en felaktig inmatning.\nVänligen ange ditt val med 1, 2, eller 3.");
				sc.nextLine();
			}
		}//while

		if(inputInt == 1) {
			System.out.println("Vänligen ange registreringsnummer:");
			query = sc.next().toUpperCase();//Saved with capital letters
			resultPresentation = "Din sökning på registreringsnumret " + query + " gav följande resultat:";
		}

		if(inputInt == 2) {
			System.out.println("Vänligen ange fordonstyp:"
					+ "\n1: Bil"
					+ "\n2: Båt"
					+ "\n3: Flygplan"
					+ "\n4: Buss"
					+ "\n5: Motorcykel");			
			query = Vehicle.fixTextInput(sc.next(), true);//Saved with preceding capital letter
			while(!query.equals("1")
					&& !query.equals("2")
					&& !query.equals("3")
					&& !query.equals("4")
					&& !query.equals("5")) { 
				System.out.println("Du har gjort en ogiltig inmatning,\nvänligen försök igen med ett tal mellan 1 och 5.");
				query = Vehicle.fixTextInput(sc.next(), true);//Saved with preceding capital letter
			}

			switch(query) {
			case "1": vehicleType = "bil"; break;
			case "2": vehicleType = "båt"; break;
			case "3": vehicleType = "flygplan"; break;
			case "4": vehicleType = "buss"; break;
			case "5": vehicleType = "motorcykel"; break;
			default: break;
			}

			resultPresentation = "Din sökning på fordonstypen " + vehicleType + " gav följande resultat:";
		}
		if(inputInt == 3) {
			System.out.println("Vänligen ange fordonets färg:");
			query = Vehicle.fixTextInput( sc.next(), true);//Saved with preceding capital letter

			resultPresentation = "Din sökning på färgen " +query+ " gav följande resultat:";
		}

		results = garage.findByProperty(inputInt, query);

		try{
			Vehicle v = results.get(0);

			System.out.println(resultPresentation);
			for(Vehicle vehicle : results) {
				//TODO we should write a blank line between vehicles to make the output easier to read
				System.out.println(vehicle.toString());
			}

			if(inputInt == 1) {
				if(v.getParked()) {
					System.out.println("Vill du avparkera fordonet? (j/n)");
				}
				else {
					System.out.println("Vill du parkera fordonet? (j/n)");
				}
				inputString = sc.next();
				
				if(inputString.equals("j")) {
					v.setParked();
					System.out.println("Ändringen har utförts.");
				}
				System.out.println("Kunden har alltid rätt.");
			}
			
		}catch (Exception e){
			System.out.println("Din sökning gav inga träffar.");
		}
		System.out.println("****************************************");

	}


	/*
	 * The method asks the user which type of vehicle is to be parked, the vehicles registration number, color and model.
	 * It creates a new instance of a subclass of Vehicle and puts it in the Garage.
	 */
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
		regNo = sc.next().toUpperCase();//Saved with upper case letters

		System.out.println("Ange färg:");
		color = Vehicle.fixTextInput(sc.next(), true);//Saved with preceding capital letter

		System.out.println("Ange märke:");
		brand = Vehicle.fixTextInput(sc.next(), true);//Saved with preceding capital letter


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
	}

	/*
	 * Lists all the vehicles in the garage.
	 */
	public void listAllVehicles() {
		System.out.println(garage.toString());
		System.out.println("Vänligen tryck ENTER för att fortsätta");
	}
}
