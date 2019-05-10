package ua.lpnuai.oop.mokryk07;

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
		System.out.print("a. Add tour\nb. Delete tour\nc. Search\nd. Sort\ne. Display all tours\nf. Serialize\ng. Deserialize\nh. Save to XML\ni. Load from XML\nj. Quit\nYour option: ");
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
				TourManager.search(); break;
			case 'd':
				TourManager.sort(); break;
			case 'e':
				TourManager.display(); break;
			case 'f':
				TourManager.serialize(); break;
			case 'g':
				TourManager.deSerialize(); break;
			case 'h':
				TourManager.saveXML(); break;
			case 'i':
				TourManager.loadXML(); break;
			case 'j':
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