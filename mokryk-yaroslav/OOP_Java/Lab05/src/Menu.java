package ua.lpnuai.oop.mokryk05;

import java.util.Scanner;

public class Menu {
	public static void auto() {
		System.out.println("Automatic mode. Loading file.txt");
		try {
			TourManager.deSerialize();
		} catch (Exception e1) {
			System.out.println("file.txt not found. Loading file.xml");
			try {
				TourManager.loadXML();
			} catch (Exception e2) {
				System.out.println("file.xml not found.");
				quit();
			}
		}
		TourManager.display();
	}
	public static void printMenu() {
		System.out.print("a. Add tour\nb. Delete tour\nc. Delete all\nd. Display all tours\ne. Serialize\nf. Deserialize\ng. Save to XML\nh. Load from XML\ni. Quit\nYour option: ");
	}
	public static void getInput() {
		Scanner s = new Scanner(System.in);
		boolean over = false;
		while (!over) {
			printMenu();
			char inp = s.nextLine().charAt(0);
			switch(inp) {
			case 'a':
				TourManager.add(); break;
			case 'b':
				TourManager.delete(); break;
			case 'c':
				TourManager.deleteAll(); break;
			case 'd':
				TourManager.display(); break;
			case 'e':
				TourManager.serialize(); break;
			case 'f':
				TourManager.deSerialize(); break;
			case 'g':
				TourManager.saveXML(); break;
			case 'h':
				TourManager.loadXML(); break;
			case 'i':
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