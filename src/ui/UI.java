package ui;

import java.util.Scanner;

import models.Garage;

public class UI {

	Scanner sc;
	Garage garage;
	
	public UI() {
		sc = new Scanner(System.in);
		garage = new Garage();
		run();
	}
	
	public void run() {
		String input = "";
		
		while( !input.equalsIgnoreCase("q") ) {
			System.out.println("Hello and Welcome to the Grand Garage!"
				+ "\nWhat would you like to do?"
				+ "\n1: Park a vehicle"
				+ "\n2: List parked vehicles"
				+ "\nQ: Quit");
			
			input = sc.nextLine();
			
			switch(input) {
			case("1"):
				parkVehicle();
				break;
				
			case("2"):
				garage.listAllParkedVehicles();
				break;
				
			case("3"):
				garage.findByProperty();
			}
		}
		System.out.println("Thank you for visiting the Grand Garage!\nHave a nice day!");
	}
	
	public void findByProperty() {
		System.out.println("P� vilken egenskap vill du g�ra s�kningen?"
				+ "\n1: Registreringsnummer"
				+ "\n2: Typ av fordon"
				+ "\n3: F�rg");
		int choice = sc.nextInt();
		garage.findByProperty(choice, "NULL");
	}
	
	public void parkVehicle() {}
}
