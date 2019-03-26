package ua.lpnuai.oop.mokryk02;

import ua.lpnuai.oop.mokryk02.Menu;

public class Main {
	public static boolean debug = false;
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("-h") || args[0].equals("-help"))
				Menu.displayHelp();
			if (args[0].equals("-d") || args[0].equals("-debug"))
				debug = true;
		}
		Menu.getInput();
	}
}