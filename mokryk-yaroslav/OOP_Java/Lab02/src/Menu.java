package ua.lpnuai.oop.mokryk02;

import java.util.Scanner;

public class Menu {
	public static void displayHelp() {
		System.out.println("Author: Yaroslav Mokryk, Group KN-108\n" + 
				   "Task:\nВвести текст. У кожному слові тексту k-ту літеру замінити заданим\n" + 
				   "символом. Якщо k більше довжини слова, видати повідомлення та заміну\n" + 
				   "не виконувати. Початкові дані та результат вивести у вигляді таблиці.\n" + 
				   "Menu items:\nInput data - input the data (string, number and character) through the console\n" +
				   "Output data - output a table with the original and result strings\n" +
				   "Compute - replace every k-th character with the input character\n" +
				   "Quit - exit the program\nCommand line arguments:\n" +
				   "-h or -help - display this help message\n" +
				   "-d or -debug - run the program in debug mode");
		quit();
	}
	public static void printMenu() {
		System.out.print("a. Add new string\nb. Delete string\nc. Edit string\nd. Input N and C\ne. Serialize strings\nf. Deserialize strings\ng. Output\nh. Quit\nYour option: ");
	}
	public static void getInput() {
		Scanner s = new Scanner(System.in);
		boolean over = false;
		while (!over) {
			printMenu();
			char inp = s.nextLine().charAt(0);
			switch(inp) {
			case 'a':
				StringManager.addStr(s);
				break;
			case 'b':
				StringManager.deleteStr(s);
				break;
			case 'c':
				StringManager.deleteStr(s);
				StringManager.addStr(s);
				break;
			case 'd':
				StringManager.getNumAndChar(s);
				break;
			case 'e':
				StringManager.serialize();
				break;
			case 'f':
				StringManager.deSerialize();
				break;
			case 'g':
				StringManager.printTable();
				break;
			case 'h':
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
