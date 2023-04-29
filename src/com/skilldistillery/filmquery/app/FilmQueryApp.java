package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp fqa = new FilmQueryApp();
//		fqa.test();
		fqa.launch();
	}

	private void test() {
		Actor actor = db.findActorById(-5);
		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("No such actor found");
		}

		Film film = db.findFilmById(-10);
		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("No such film found");
		}
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;

		while (keepGoing) {
			try {
				Film film = null;
				printMenu();
				System.out.println("Please choose an option: ");
				int choice = input.nextInt();
				input.nextLine();

				switch (choice) {
				case 1:
					System.out.println("There are currently 1000 films in our database.");
					System.out.print("Please enter a film id between 1 & 1000: ");
					int userIdSelection = input.nextInt();
					film = db.findFilmById(userIdSelection);
					if (film != null) {
//					System.out.println(film);	Carry on
					} else {
						System.out.println("No such film found");
					}
					break;
				case 2:
					System.out.print("Please enter a keyword to search for a film: ");
					String userKeyword = input.nextLine();
					film = db.findFilmByKeyword(userKeyword);
					if (film != null) {
//					System.out.println(film);	Carry on
					} else {
						System.out.println("No such film found");
					}
					break;
				case 3:
					keepGoing = false;
					printExit();
					break;
				default:
					System.out.println("Invalid entry, please choose an option from the menu.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid entry, please choose an option from the menu.");
				input.nextLine();
			}
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("**********************************");
		System.out.println("----------- Film Query -----------");
		System.out.println("----------------------------------");
		System.out.println("  1. Look up a film by ID         ");
		System.out.println("  2. Look up a film by a keyword  ");
		System.out.println("  3. Exit the application         ");
		System.out.println("----------------------------------");
		System.out.println("**********************************");
		System.out.println();
	}

	public void printExit() {
		System.out.println("Thank you for using our Film Query!");
	}

}
