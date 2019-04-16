package ua.lpnuai.oop.mokryk05;

public class Main05 {
	public static void main(String[] args) {
		if (args.length > 0 && (args[0].equals("-a") || args[0].equals("-auto")))
			Menu.auto();
		else
			Menu.getInput();
	}
}