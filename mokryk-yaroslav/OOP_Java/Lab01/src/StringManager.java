package ua.lpnuai.oop.mokryk01;

import java.util.Scanner;

public class StringManager {
	public static String str;
	public static StringBuilder res;
	public static int k;
	public static char c;
	
	public static void getStr(Scanner s) {
		System.out.print("Enter the string: ");
		str = s.nextLine();
	}
	public static void getNumAndChar(Scanner s) {
		System.out.print("Enter the number k and the letter to replace: ");
		String temp[] = s.nextLine().split(" ");
		if (Main.debug)
			System.out.println("k: " + temp[0] + "\nc: " + temp[1]);
		k = Integer.parseInt(temp[0]);
		c = temp[1].charAt(0);
		if (k > str.length()) {
			System.out.println("Error: k is bigger than the string");
			Menu.quit();
		}
	}
	public static void computeResult() {
		res = new StringBuilder();
		for (int i = 0; i < str.length(); i ++) {
			if ((i+1) % k != 0 || i == 0)
				res.append(str.charAt(i));
			else
				res.append(c);
			if (Main.debug)
				System.out.println(res);
		}
	}
	public static void printTable() {
		System.out.print("|");
		for (int i = 0; i < str.length()+17; i ++)
			System.out.print("-");
		System.out.print("|\n|Original string: " + str + "|\n|");
		for (int i = 0; i < str.length()+17; i ++)
			System.out.print("-");
		System.out.print("|\n|New string: " + res);
		for (int i = 0; i < 5; i ++)
			System.out.print(" ");
		System.out.print("|\n|");
		for (int i = 0; i < str.length()+17; i ++)
			System.out.print("-");
		System.out.print("|\n");
	}
}
