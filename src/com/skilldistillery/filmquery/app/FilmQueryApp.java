package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//    app.launch();
	}

	private void test() {
		Actor actor = db.findActorById(-5);
		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("No such actor found");
		}
		
//		if ( actor.getFilms() != null) {
//			System.out.println(actor.getFilms());
//		} else {
//			System.out.println("The actor is lazy, bad, or new. No films found at this time.");
//		}

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

	}

}
