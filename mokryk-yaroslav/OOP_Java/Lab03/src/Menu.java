package ua.lpnuai.oop.mokryk03;

import java.util.Scanner;

public class Menu {
	public static void printMenu() {
		System.out.print("a. Add tour\nb. Delete tour\nc. Display all tours\nd. Save\ne. Load\nf. Quit\nYour option: ");
	}
	public static void getInput() {
		Scanner s = new Scanner(System.in);
		boolean over = false;
		while (!over) {
			printMenu();
			char inp = s.nextLine().charAt(0);
			switch(inp) {
			case 'a':
				TourManager.Add();
				break;
			case 'b':
				TourManager.Delete();
				break;
			case 'c':
				TourManager.Display();
				break;
			case 'd':
				TourManager.Save();
				break;
			case 'e':
				TourManager.Load();
				break;
			case 'f':
				over = true;
				quit();
				break;
			default:
				continue;
			}
		}
		s.close();
	}
	public static void quit() {
		System.exit(0);
	}
}